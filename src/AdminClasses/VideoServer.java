package AdminClasses;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class VideoServer {

    public VideoServer() {
        new DesktopVideoServer();
    }

    public static void main(String[] args) {
        new VideoServer();
    }

    class DesktopVideoServer implements Runnable {

        Thread t = new Thread(this);
        String url;

        public DesktopVideoServer() {
            t.start();
        }

        @Override
        public void run() {
            try {
                ServerSocket serversocket = new ServerSocket(4200);
                url = "http://127.0.0.1:4200";
                while (true) {
                    Socket socket = serversocket.accept();
                    new VideoClient(socket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        class VideoClient implements Runnable {

            long startRange = 0;
            long endRange = 0;
            Socket socket;
            DataInputStream dis;
            DataOutputStream dos;
            Thread t1;

            public VideoClient(Socket socket) {
                this.socket = socket;
                t1 = new Thread(this);
                t1.start();
            }

            @Override
            public void run() {
                try {
                    dis = new DataInputStream(socket.getInputStream());
                    dos = new DataOutputStream(socket.getOutputStream());
                    String headers = "";
                    while (true) {
                        String msg = dis.readLine();
                        if (msg == null || msg.equals("")) {
                            break;
                        }
                        headers = headers + msg + "\n";
                    }
                    System.out.println(headers);
                    int indexOfFirstSlash = headers.indexOf("/");
                    int indexOfSpaceAfterFirstSlash = headers.indexOf(" ", indexOfFirstSlash);
                    if (indexOfFirstSlash != -1 && indexOfSpaceAfterFirstSlash != -1) {
                        String uri1 = headers.substring(indexOfFirstSlash, indexOfSpaceAfterFirstSlash);
                        if (uri1.endsWith(".mp4")) {
                            handleRequest1(dis, dos, headers, uri1);
                        } else if (uri1.endsWith(".jpg") || uri1.endsWith(".JPG") || uri1.endsWith(".JPEG")
                                || uri1.endsWith(".png") || uri1.endsWith(".PNG")) {
                            sendImageToClient(uri1);
                        } else {
                            //write logic for index.html page
                        }
                    } else {
                        String backResponse = "HTTP/1.1 404 Not Found\r\n";
                        backResponse = backResponse + "Date: " + new Date() + "\r\n";
                        dos.writeBytes(backResponse + "\r\n");
                        dos.close();
                        dis.close();
                        socket.close();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void handleRequest1(DataInputStream dis, DataOutputStream dos, String headers, String uri1) {
                try {
                    File wwwroot = new File(".").getAbsoluteFile(); //get the directory where the videos are being saved
                    File f = new File(wwwroot, uri1); //make file object of requested video from wwwroot folder
                    if (!f.exists())//check if file exists or not,if exits then serve that file to client :)
                    {
                        String backResponse = "HTTP/1.1 404 Not Found\r\n";
                        backResponse = backResponse + "Date: " + new Date() + "\r\n";
                        dos.writeBytes(backResponse + "\r\n");
                        dos.close();
                        dis.close();
                        socket.close();
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
                        dos.writeBytes(backResponse + "\r\n");
                        dos.close();
                        dis.close();
                        socket.close();
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
                        dos.writeBytes(backResponse + "\r\n");
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
                                dos.write(buff, 0, read);
                                pending -= read;
                            }
                        }
                        dos.close();
                        if (fis != null) {
                            fis.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
