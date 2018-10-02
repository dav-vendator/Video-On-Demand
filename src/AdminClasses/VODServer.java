package AdminClasses;


import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

class ClientHandler implements Runnable {

    private Socket connection;
    private DataOutputStream clientOut;
    private DataInputStream clientInp;
    private String message;
    private Connection dbCon;

    ClientHandler(Socket connection) {
        this.connection = connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error : While initializing : " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            clientOut = new DataOutputStream(connection.getOutputStream());
            clientInp = new DataInputStream(connection.getInputStream());
            String headers = "";
            do {
                message = clientInp.readLine();
                if (message.equals("**SIGNUP**")) {
                    processSignup(); //Handles SignUp process
                }else if(message.equals("**LOGIN**")){
                    processLogin();
                }else if(message.equals("**FIND**")){
                    //System.out.println("dddd");
                    doesExists();
                }else if(message.equals("**SEC**")){
                    forgotSec();
                }else if(message.equals("**OTP**")){
                    forgotOTP();
                }else if(message.equals("senduser")){
                    sendUserData();
                }else if(message.equals("**CPASS**")){
                    changePass();
                }else if(message.equals("sendtvdata")){
                    sendTvData();
                }else if (message.equals("senddata")) {
                    sendRandomRows();
                }else if(message.equals("download")){
                    handleDownload();
                }
                else if (message.equals("")) {
                    break;
                } else if (message.equals("")) {
                    headers = headers + message + "\n";
                } else if (message.equals("sendGenreMovie")) {
                    sendGenreMovie();
                } else if (message.equals("sendGenreTv")) {
                    sendGenreTv();
                }else if (message.equals("sendGenre")) {
                    sendGenre();
                }else if(message.equals("sendGenreShow")){
                    sendGenreShow();
                }else if (message.equals("sendMovies")) {
                    sendMovies();
                }else if(message.equals("sendShows")){
                    sendShows();
                }
            } while (message != null);

            if (headers.contains(".mp4")) {
                int indexOfFirstSlash = headers.indexOf("/");
                int indexOfSpaceAfterFirstSlash = headers.indexOf(" ", indexOfFirstSlash);
                if (indexOfFirstSlash != -1 && indexOfSpaceAfterFirstSlash != -1) {
                    String uri1 = headers.substring(indexOfFirstSlash, indexOfSpaceAfterFirstSlash);
                    System.out.println(uri1 + " ******uri");
                    if (uri1.endsWith(".mp4")) {
                        handleRequest1(clientInp, clientOut, headers, uri1);
                    } else if (uri1.endsWith(".jpg") || uri1.endsWith(".JPG") || uri1.endsWith(".JPEG")
                            || uri1.endsWith(".png") || uri1.endsWith(".PNG")) {
                        sendImageToClient(uri1);
                    } else {
                        //write logic for index.html page
                    }
                } else {
                    String backResponse = "HTTP/1.1 404 Not Found\r\n";
                    backResponse = backResponse + "Date: " + new Date() + "\r\n";
                    clientOut.writeBytes(backResponse + "\r\n");
                    clientOut.close();
                    clientInp.close();
                    connection.close();
                }
            }

        } catch (Exception e) {
            System.out.println("Error while handling @" + connection.getPort());
            System.out.println("Excepiton :" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException ex) {
                System.out.println("Error received while closing socket");
                System.out.println("Exception: " + ex.getMessage());
            }
            if (dbCon != null) {
                try {
                    dbCon.close();
                } catch (SQLException sqlEx) {
                    System.out.println("Error while closing connection with database:");
                    System.out.println("Exception :" + sqlEx.getMessage());
                }
            }
        }
    }

    private void handleRequest1(DataInputStream dis, DataOutputStream dos, String headers, String uri1) {
        try {
            File wwwroot = new File(".").getAbsoluteFile(); //get the directory where the videos are being saved
            File f = new File(uri1); //make file object of requested video from wwwroot folder
            if (!f.exists())//check if file exists or not,if exits then serve that file to client :)
            {
                String backResponse = "HTTP/1.1 404 Not Found\r\n";
                backResponse = backResponse + "Date: " + new Date() + "\r\n";
                dos.writeBytes(backResponse + "\r\n");
                dos.close();
                dis.close();
                connection.close();
                return;
            }
            String mime = "video/mp4";
            try {
                String etag = Integer.toHexString((f.getAbsolutePath() + f.lastModified() + "" + f.length()).hashCode());
                long startFrom = 0;
                long endAt = -1;

                if (headers.contains("bytes=")) {
                    int indexOfBytesEquals = headers.indexOf("bytes=");
                    String range1 = headers.substring(indexOfBytesEquals);
                    range1 = range1.substring("bytes=".length());
                    int minus = range1.indexOf('-');
                    if (minus > 0) {
                        startFrom = Long.parseLong(range1.substring(0, minus));
                        String substring = range1.substring(0, minus + 1);
                        if (substring.length() > substring.indexOf("-") + 1) {
                            endAt = Long.parseLong(substring.substring(substring.indexOf("-") + 1));
                        }
                    }
                    String backResponse = "HTTP/1.0 206 Partial Content\r\n";
                    backResponse = backResponse + "Content-Type: " + mime + "\r\n";
                    backResponse = backResponse + "Date: " + new Date() + "\r\n";
                    long fileLen = f.length();
                    if (range1 != null && startFrom >= 0) {
                        if (startFrom >= fileLen) {
                            backResponse = backResponse + "Content-Range: bytes 0-0/" + fileLen + "\r\n";
                            backResponse = backResponse + "ETag: " + etag + "\r\n";
                            dos.writeBytes(backResponse + "\r\n");
                        } else {
                            if (endAt < 0) {
                                endAt = fileLen - 1;
                            }
                            long newLen = endAt - startFrom + 1;
                            if (newLen < 0) {
                                newLen = 0;
                            }

                            final long dataLen = newLen;
                            FileInputStream fis = new FileInputStream(f) {
                                public int available() throws IOException {
                                    return (int) dataLen;
                                }
                            };
                            fis.skip(startFrom);
                            backResponse = backResponse + "Content-Length: " + dataLen + "\r\n";
                            backResponse = backResponse + "Content-Range: " + "bytes " + startFrom + "-" + endAt + "/" + fileLen + "\r\n";
                            backResponse = backResponse + "ETag: " + etag + "\r\n";
                            backResponse = backResponse + "Accept-Ranges: bytes\r\n";
                            dos.writeBytes(backResponse + "\r\n");
                            if (fis != null) {
                                int pending = fis.available();
                                int theBufferSize = 16 * 1024;
                                byte[] buff = new byte[theBufferSize];
                                while (pending > 0) {
                                    int read = fis.read(buff, 0, ((pending > theBufferSize)
                                            ? theBufferSize : pending));
                                    if (read <= 0) {
                                        break;
                                    }
                                    dos.write(buff, 0, read);
                                    pending -= read;
                                }
                            }
                            dos.close();
                            if (fis != null) {
                                fis.close();
                            }
                        }
                    }
                }
            } catch (IOException ioe) {
            }
        } catch (Exception e) {
        }
    }

    private void sendImageToClient(String uri1) {
        try {
            File wwwroot = new File(".").getAbsoluteFile(); //get the directory where the images are being saved
            File imageFolder = new File(wwwroot, "images");
            if (!imageFolder.exists()) {
                imageFolder.mkdir();
            }
            File f = new File(imageFolder, uri1); //make file object of requested image from wwwroot folder
            if (!f.exists())//check if file exists or not,if exits then serve that file to client :)
            {
                String backResponse = "HTTP/1.1 404 Not Found\r\n";
                backResponse = backResponse + "Date: " + new Date() + "\r\n";
                clientOut.writeBytes(backResponse + "\r\n");
                clientOut.close();
                clientInp.close();
                connection.close();
                return;
            } else {
                String mime = "";
                uri1 = uri1.toLowerCase();
                if (uri1.endsWith("jpg") || uri1.endsWith("jpeg")) {
                    mime = "image/jpeg";
                } else if (uri1.endsWith("png")) {
                    mime = "image/png";
                }
                System.out.println(mime + " mime type");
                long length = f.length();
                String backResponse = "HTTP/1.0 200 OK\r\n";
                backResponse = backResponse + "Content-Type: " + mime + "\r\n";
                backResponse = backResponse + "Date: " + new Date() + "\r\n";
                backResponse = backResponse + "Content-Length: " + length + "\r\n";
                clientOut.writeBytes(backResponse + "\r\n");
                FileInputStream fis = new FileInputStream(f);

                if (fis != null) {
                    int pending = fis.available();
                    int theBufferSize = 16 * 1024;
                    byte[] buff = new byte[theBufferSize];
                    while (pending > 0) {
                        int read = fis.read(buff, 0, ((pending > theBufferSize)
                                ? theBufferSize : pending));
                        if (read <= 0) {
                            break;
                        }
                        clientOut.write(buff, 0, read);
                        pending -= read;
                    }
                }
                clientOut.close();
                if (fis != null) {
                    fis.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
       1} EMail
       2) Password
       3) Confirm Password
       4) Security Question
       5) Contact
     */
    public void processSignup() throws Exception {
        String email = clientInp.readLine();
        String password = clientInp.readLine();
        String secQuest = clientInp.readLine();
        String secAnswer = clientInp.readLine();
        String contact = clientInp.readLine();
   
        //---Creating Statement
        Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * from users WHERE email='" + email + "'");
        if (rs.next()) {
            //AE => Already Exists
            clientOut.writeBytes("fail\r\n");
        } else {
            rs.moveToInsertRow();
            rs.updateString("email", email);
            rs.updateString("password", password);
            rs.updateString("sec_ques", secQuest);
            rs.updateString("sec_ans", secAnswer);
            rs.updateString("contact", contact);
            rs.insertRow();
            clientOut.writeBytes("success\r\n");
        }
        rs.close();
        stmt.close();
    }

    private void sendRandomRows() {
        try {
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * from videos order by rand()");

            while (rs.next()) {
                String videoid = rs.getString("video_id");
                String type = rs.getString("category_name");
                String mname = rs.getString("title");
                String mpath = rs.getString("video_path");
                String mtrailerpath = rs.getString("trailer_path");
                String mdirector = rs.getString("director");
                String mproducer = rs.getString("producer");
                String rating = rs.getString("rating");
                String releasedate = rs.getString("release_date");
                String description = rs.getString("description");
                String cover = rs.getString("cover_photo");
                String square = rs.getString("square_photo");
                String genre = rs.getString("genre");

                clientOut.writeUTF("receive");
                clientOut.writeUTF(mname);
                clientOut.writeUTF(mpath);
                clientOut.writeUTF(mtrailerpath);
                clientOut.writeUTF(mdirector);
                clientOut.writeUTF(mproducer);
                clientOut.writeUTF(rating);
                clientOut.writeUTF(releasedate);
                clientOut.writeUTF(description);
                clientOut.writeUTF(cover);
                clientOut.writeUTF(square);
                clientOut.writeUTF(videoid);
                clientOut.writeUTF(type);
                clientOut.writeUTF(genre);

            }
            clientOut.writeUTF("done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendGenreMovie() {
        try {
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * from videos where genre in(select genre_name from genre WHERE Category_name='Movies' order by rand())"
                    + " order by rand() limit 3");

            while (rs.next()) {
                String videoid = rs.getString("video_id");
                String type = rs.getString("category_name");
                String mname = rs.getString("title");
                String mpath = rs.getString("video_path");
                String mtrailerpath = rs.getString("trailer_path");
                String mdirector = rs.getString("director");
                String mproducer = rs.getString("producer");
                String rating = rs.getString("rating");
                String releasedate = rs.getString("release_date");
                String description = rs.getString("description");
                String cover = rs.getString("cover_photo");
                String square = rs.getString("square_photo");
                String genre = rs.getString("genre");
                
                clientOut.writeUTF("receive");
                clientOut.writeUTF(mname);
                clientOut.writeUTF(mpath);
                clientOut.writeUTF(mtrailerpath);
                clientOut.writeUTF(mdirector);
                clientOut.writeUTF(mproducer);
                clientOut.writeUTF(rating);
                clientOut.writeUTF(releasedate);
                clientOut.writeUTF(description);
                clientOut.writeUTF(cover);
                clientOut.writeUTF(square);
                clientOut.writeUTF(videoid);
                clientOut.writeUTF(type);
                clientOut.writeUTF(genre);
            }
            clientOut.writeUTF("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendGenreShow() {
        try {
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT distinct genre from videos WHERE category_name='TV'");

            while (rs.next()) {
                String mname = rs.getString("genre");
                System.out.println(mname);
                clientOut.writeUTF(mname);
            }
            clientOut.writeUTF("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void sendGenre() {
        try {
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT distinct genre from videos;");

            while (rs.next()) {
                String mname = rs.getString("genre");
                clientOut.writeUTF(mname);
            }
            clientOut.writeUTF("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void sendMovies() {
        try {
            String genrename = clientInp.readLine();
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT *from videos where genre='" + genrename + "';");

            while (rs.next()) {
                String videoid = rs.getString("video_id");
                String type = rs.getString("category_name");
                String mname = rs.getString("title");
                String mpath = rs.getString("video_path");
                String mtrailerpath = rs.getString("trailer_path");
                String mdirector = rs.getString("director");
                String mproducer = rs.getString("producer");
                String rating = rs.getString("rating");
                String releasedate = rs.getString("release_date");
                String description = rs.getString("description");
                String cover = rs.getString("cover_photo");
                String square = rs.getString("square_photo");
                String genre = rs.getString("genre");

                clientOut.writeUTF("receive");
                clientOut.writeUTF(mname);
                clientOut.writeUTF(mpath);
                clientOut.writeUTF(mtrailerpath);
                clientOut.writeUTF(mdirector);
                clientOut.writeUTF(mproducer);
                clientOut.writeUTF(rating);
                clientOut.writeUTF(releasedate);
                clientOut.writeUTF(description);
                clientOut.writeUTF(cover);
                clientOut.writeUTF(square);
                clientOut.writeUTF(videoid);
                clientOut.writeUTF(type);
                clientOut.writeUTF(genre);

            }
            clientOut.writeUTF("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //----Process Login
    private void processLogin() throws Exception{
        
        String email = clientInp.readLine();
        String pass  = clientInp.readLine();
        Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * from users WHERE email='" + email + "' && "
                + "password='"+pass+"'");
        
        if (rs.next()) {
            clientOut.writeBytes(rs.getString("user_id")+"\r\n");
        } else {
            clientOut.writeBytes("fail\r\n");
        }
        rs.close();
        stmt.close();
    }

    
    //SELECT sec_ques,sec_ans from vod.users WHERE email = 'dvendator@gmail.com';
    private void doesExists() throws Exception{
        String email = clientInp.readUTF();
        System.out.println(email);
        Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * from users WHERE email='" + email+"'");
        
        if (rs.next()){
             clientOut.writeBytes("succ,"+rs.getInt("user_id")+","+"\r\n");
        }else{
             clientOut.writeBytes("fail"+"\r\n");
        }
        rs.close();
        stmt.close();
    }

    private void forgotSec() throws Exception {
        String id = clientInp.readLine();
        System.out.println(id);
        Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * from users WHERE user_id='"+id+"'");
        
        if(rs.next()){
         clientOut.writeBytes(rs.getString("sec_ques")+"\r\n");
         String ans = clientInp.readLine();
        if(ans.equals(rs.getString("sec_ans"))){
            System.out.println("sending...");
            clientOut.writeBytes("**succ**\r\n"); //Opens change password there
        }else{
            clientOut.writeBytes("fail\r\n");
        }
       }
        rs.close();
        stmt.close();
    }

    private void forgotOTP() throws Exception{
        String id = clientInp.readLine();
        String phone = "";
        System.out.println(id);
        Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * from users WHERE user_id='"+id+"'");
        int otp = new Random().nextInt(2000)+1000;
        if(rs.next()){
         phone = rs.getString("contact");
         new Thread(new SMSsender(phone,"Hi,Your Password Reset Code for Video Terminal is :"+otp,"text"))
                   .start();
         String ans = clientInp.readLine();
         if(ans.equals(otp)){
            clientOut.writeBytes("**succ**\r\n"); //Opens change password there
        }else{
            clientOut.writeBytes("fail\r\n");
        }
       }
        rs.close();
        stmt.close();
    }

    private void sendUserData() throws Exception {
        String id = clientInp.readLine();
        System.out.println(id);
        Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * from users WHERE user_id='"+id+"'");
        if(rs.next()){
         clientOut.writeBytes(rs.getString("email")+"\r\n");
         clientOut.writeBytes(rs.getString("password")+"\r\n");
       }
        rs.close();
        stmt.close();
    }

    private void changePass() throws Exception{
        String id = clientInp.readLine();
        System.out.println("my id"+id);
        String npass = clientInp.readLine();
        System.out.println(id);
        Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * from users WHERE user_id='"+id+"'");
        System.out.println(npass);
        if(rs.next()){
         rs.updateString("password", npass);
         rs.updateRow();
            System.out.println("updated");
         clientOut.writeBytes("succ\r\n");
       }else{
            clientOut.writeBytes("fail\r\n");
        }
        rs.close();
        stmt.close();
    }

    private void sendGenreTv() {
         try {
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * from videos where genre in(select genre_name from genre WHERE Category_name='TV' order by rand() ) order by rand() limit 3;");

            while (rs.next()) {
                String videoid = rs.getString("video_id");
                String type = rs.getString("category_name");
                String mname = rs.getString("title");
                String mpath = rs.getString("video_path");
                String mtrailerpath = rs.getString("trailer_path");
                String mdirector = rs.getString("director");
                String mproducer = rs.getString("producer");
                String rating = rs.getString("rating");
                String releasedate = rs.getString("release_date");
                String description = rs.getString("description");
                String cover = rs.getString("cover_photo");
                String square = rs.getString("square_photo");
                String genre = rs.getString("genre");

                clientOut.writeUTF("receive");
                clientOut.writeUTF(mname);
                clientOut.writeUTF(mpath);
                clientOut.writeUTF(mtrailerpath);
                clientOut.writeUTF(mdirector);
                clientOut.writeUTF(mproducer);
                clientOut.writeUTF(rating);
                clientOut.writeUTF(releasedate);
                clientOut.writeUTF(description);
                clientOut.writeUTF(cover);
                clientOut.writeUTF(square);
                clientOut.writeUTF(videoid);
                clientOut.writeUTF(type);
                clientOut.writeUTF(genre);
            }
            clientOut.writeUTF("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }

    private void sendTvData() throws Exception{
        try {
            String video_id = clientInp.readUTF();
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * from episodes where tvshow_id='"+video_id+"'");

            while (rs.next()) {
                String epname = rs.getString("episode_name");
                String epcover = rs.getString("episode_cover");
                String epsquare = rs.getString("episode_square");
                String epdesc  = rs.getString("description");
                String epdur = rs.getString("duration");
                String vdpath = rs.getString("video_path");
                clientOut.writeUTF("receive");
                clientOut.writeUTF(epname);
                clientOut.writeUTF(epcover);
                clientOut.writeUTF(epsquare);
                clientOut.writeUTF(epdesc);
                clientOut.writeUTF(epdur);
                clientOut.writeUTF(vdpath);
                
            }
            clientOut.writeUTF("done");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private void handleDownload() throws Exception {
    
            String path = clientInp.readLine();
            System.out.println(path);
            String clientMsg;
            File fInp = new File(path);
            if(fInp.exists()){
                System.out.println("File Found");
             clientOut.writeBytes("receive\r\n");
             FileInputStream fIs = new FileInputStream(fInp);
             clientMsg = clientInp.readLine();
                System.out.println(clientMsg);
             if(clientMsg.equals("SEND")){
                 System.out.println("Sending file start");
              long filesize = fInp.length();
              clientOut.writeLong(filesize); //file Size
             byte b[] = new byte[100000];
             long count = 0;
             while(true)
             {
                int n = fIs.read(b,0,100000);
                clientOut.write(b,0,n);
                clientMsg = clientInp.readLine();
                count = count+n;
                if(clientMsg.equals("CANCEL")){
                    break;
                }else if(count>=filesize)
                {
                    System.out.println("DONE");
                    break;
                }
             }
             clientMsg = clientInp.readLine();
             fIs.close();
            }
         }else{
           clientOut.writeBytes("nf\r\n");       
         }
         
    }

    private void sendShows(){
      try {
            String genrename = clientInp.readLine();
            Statement stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT *from videos where genre='" + genrename + "' and category_name="
                    + "'TV';");

            while (rs.next()) {
                
                String videoid = rs.getString("video_id");
                String type = rs.getString("category_name");
                String mname = rs.getString("title");
                String mpath = rs.getString("video_path");
                String mtrailerpath = rs.getString("trailer_path");
                String mdirector = rs.getString("director");
                String mproducer = rs.getString("producer");
                String rating = rs.getString("rating");
                String releasedate = rs.getString("release_date");
                String description = rs.getString("description");
                String cover = rs.getString("cover_photo");
                String square = rs.getString("square_photo");
                String genre = rs.getString("genre");
                System.out.println(mname);
                clientOut.writeUTF("receive");
                clientOut.writeUTF(mname);
                clientOut.writeUTF(mpath);
                clientOut.writeUTF(mtrailerpath);
                clientOut.writeUTF(mdirector);
                clientOut.writeUTF(mproducer);
                clientOut.writeUTF(rating);
                clientOut.writeUTF(releasedate);
                clientOut.writeUTF(description);
                clientOut.writeUTF(cover);
                clientOut.writeUTF(square);
                clientOut.writeUTF(videoid);
                clientOut.writeUTF(type);
                clientOut.writeUTF(genre);
             }
            clientOut.writeUTF("done");
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
}

/*
Main Server
 */
public class VODServer implements Runnable {

    private final int portNum;
    private ServerSocket serSocket;

    public VODServer(int portNum) {
        this.portNum = portNum;
    }

    @Override
    public void run() {
        try {
            serSocket = new ServerSocket(portNum);
            System.out.println("Server Started at:" + portNum);
            while (true) {
                new Thread(new ClientHandler(serSocket.accept())).start();
            }
        } catch (IOException ex) {

        }
    }
    public static void main(String[] args) {
        new Thread(new VODServer(4000)).start();
    }
}
