package ClientClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VODMainFrame extends javax.swing.JFrame {

    ArrayList<VideoData> alData = new ArrayList<>();
    ArrayList<VideoData> alData1 = new ArrayList<>();
    ArrayList<VideoData> alTv = new ArrayList<>();
    private int uid = -1;
    private String ip;
    private VideoData [] arVData;
    public VODMainFrame(String ip) {
        this(ip,-1);
    }

    public VODMainFrame(String ip,int uid) {
        initComponents();
        this.setForeground(Color.BLACK);
        setSize(1300, 690);
        this.setResizable(false);
        this.uid = uid;
        this.ip = ip;
        arVData = new VideoData[6];
        new Thread(new FillMovie()).start();
        new Thread(new FillMovieAndTvShow()).start();
        new Thread(new AnimateScrollBar()).start();
        new Thread(new GetData()).start();
        addListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbsquare = new javax.swing.JLabel();
        lbmainPhoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpslider = new javax.swing.JPanel();
        jtaboptions = new javax.swing.JTabbedPane();
        jpmovies = new javax.swing.JPanel();
        jpmovie3 = new javax.swing.JPanel();
        lbmovgenremovie2 = new javax.swing.JLabel();
        lbg2 = new javax.swing.JLabel();
        jpmovie1 = new javax.swing.JPanel();
        lbmovgenremovie3 = new javax.swing.JLabel();
        lbg3 = new javax.swing.JLabel();
        jpmovie2 = new javax.swing.JPanel();
        lbmovgenremovie1 = new javax.swing.JLabel();
        lbg1 = new javax.swing.JLabel();
        lbSmallGalleryTvShow = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jptvshows = new javax.swing.JPanel();
        jpshow3 = new javax.swing.JPanel();
        lbtvshowg2 = new javax.swing.JLabel();
        lbsh3 = new javax.swing.JLabel();
        jpshow1 = new javax.swing.JPanel();
        lbtvshowg1 = new javax.swing.JLabel();
        lbsh1 = new javax.swing.JLabel();
        jpshow4 = new javax.swing.JPanel();
        lbtvshowg3 = new javax.swing.JLabel();
        lbsh2 = new javax.swing.JLabel();
        lbSmallGallery = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbsquare.setBackground(new java.awt.Color(51, 255, 0));
        lbsquare.setText("jLabel1");
        lbsquare.setOpaque(true);
        getContentPane().add(lbsquare);
        lbsquare.setBounds(30, 130, 270, 120);

        lbmainPhoto.setBackground(new java.awt.Color(255, 0, 51));
        lbmainPhoto.setText("jLabel1");
        lbmainPhoto.setOpaque(true);
        getContentPane().add(lbmainPhoto);
        lbmainPhoto.setBounds(0, 0, 780, 250);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jpslider.setLayout(null);
        jScrollPane1.setViewportView(jpslider);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 260, 780, 100);

        jpmovies.setLayout(null);

        jpmovie3.setLayout(null);

        lbmovgenremovie2.setText("lbGenremovie2");
        jpmovie3.add(lbmovgenremovie2);
        lbmovgenremovie2.setBounds(4, 4, 360, 20);

        lbg2.setText("jLabel1");
        jpmovie3.add(lbg2);
        lbg2.setBounds(0, 30, 370, 120);

        jpmovies.add(jpmovie3);
        jpmovie3.setBounds(390, 10, 370, 150);

        jpmovie1.setLayout(null);

        lbmovgenremovie3.setText("lbGenremovie1");
        jpmovie1.add(lbmovgenremovie3);
        lbmovgenremovie3.setBounds(4, 4, 360, 20);

        lbg3.setText("jLabel1");
        jpmovie1.add(lbg3);
        lbg3.setBounds(0, 30, 370, 120);

        jpmovies.add(jpmovie1);
        jpmovie1.setBounds(770, 10, 370, 150);

        jpmovie2.setOpaque(false);
        jpmovie2.setLayout(null);

        lbmovgenremovie1.setText("lbGenremovie1");
        jpmovie2.add(lbmovgenremovie1);
        lbmovgenremovie1.setBounds(4, 4, 360, 20);

        lbg1.setText("jLabel1");
        jpmovie2.add(lbg1);
        lbg1.setBounds(0, 30, 370, 120);

        jpmovies.add(jpmovie2);
        jpmovie2.setBounds(10, 10, 370, 150);

        lbSmallGalleryTvShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/image-gallery.png"))); // NOI18N
        lbSmallGalleryTvShow.setText("             ");
        lbSmallGalleryTvShow.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lbSmallGalleryTvShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbSmallGalleryTvShowMousePressed(evt);
            }
        });
        jpmovies.add(lbSmallGalleryTvShow);
        lbSmallGalleryTvShow.setBounds(1150, 10, 130, 90);

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Movies");
        jpmovies.add(jLabel2);
        jLabel2.setBounds(1150, 110, 130, 20);

        jtaboptions.addTab("Movies", jpmovies);

        jptvshows.setLayout(null);

        jpshow3.setLayout(null);

        lbtvshowg2.setText("lbGenretvshow2");
        jpshow3.add(lbtvshowg2);
        lbtvshowg2.setBounds(4, 4, 360, 20);

        lbsh3.setText("jLabel1");
        jpshow3.add(lbsh3);
        lbsh3.setBounds(10, 40, 350, 100);

        jptvshows.add(jpshow3);
        jpshow3.setBounds(790, 10, 370, 150);

        jpshow1.setLayout(null);

        lbtvshowg1.setText("lbGenreshow1");
        jpshow1.add(lbtvshowg1);
        lbtvshowg1.setBounds(4, 4, 350, 20);

        lbsh1.setText("jLabel1");
        jpshow1.add(lbsh1);
        lbsh1.setBounds(10, 40, 340, 100);

        jptvshows.add(jpshow1);
        jpshow1.setBounds(10, 10, 360, 150);

        jpshow4.setLayout(null);

        lbtvshowg3.setText("lbGenretvshow2");
        jpshow4.add(lbtvshowg3);
        lbtvshowg3.setBounds(4, 4, 360, 20);

        lbsh2.setText("jLabel1");
        jpshow4.add(lbsh2);
        lbsh2.setBounds(10, 40, 350, 100);

        jptvshows.add(jpshow4);
        jpshow4.setBounds(390, 10, 370, 150);

        lbSmallGallery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/image-gallery.png"))); // NOI18N
        lbSmallGallery.setText("           ");
        lbSmallGallery.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lbSmallGallery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbSmallGalleryMousePressed(evt);
            }
        });
        jptvshows.add(lbSmallGallery);
        lbSmallGallery.setBounds(1180, 10, 120, 90);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Shows");
        jptvshows.add(jLabel1);
        jLabel1.setBounds(1180, 110, 120, 20);

        jtaboptions.addTab("TV Shows", jptvshows);

        getContentPane().add(jtaboptions);
        jtaboptions.setBounds(0, 370, 1310, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbSmallGalleryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSmallGalleryMousePressed
         ViewAllShows allShows = new ViewAllShows(ip);
         allShows.setVisible(true);
    }//GEN-LAST:event_lbSmallGalleryMousePressed

    private void lbSmallGalleryTvShowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSmallGalleryTvShowMousePressed
        ViewAllMovies allMovies = new ViewAllMovies(ip);
        allMovies.setVisible(true);
    }//GEN-LAST:event_lbSmallGalleryTvShowMousePressed
    
    public void addListeners(){
        //---Movie Panel
        lbg1.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
            LaunchMovie launchMovie = new LaunchMovie(arVData[0],ip);
            launchMovie.setVisible(true);
          }
        });
        
        lbg2.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
            LaunchMovie launchMovie = new LaunchMovie(arVData[1],ip);
            launchMovie.setVisible(true);
          }
        });
        
        lbg3.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
            LaunchMovie launchMovie = new LaunchMovie(arVData[2],ip);
            launchMovie.setVisible(true);
          }
        });
        
        //Tv Panel
        lbsh1.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               System.out.println("Launching");
            LaunchShow launchMovie = new LaunchShow(arVData[3],ip);
            launchMovie.setVisible(true);
          }
        });
        
        lbsh2.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
            LaunchShow launchMovie = new LaunchShow(arVData[4],ip);
            launchMovie.setVisible(true);
          }
        });
                
        lbsh3.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
            LaunchShow launchMovie = new LaunchShow(arVData[5],ip);
            launchMovie.setVisible(true);
          }
        });         
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VODMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new VODMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpmovie1;
    private javax.swing.JPanel jpmovie2;
    private javax.swing.JPanel jpmovie3;
    private javax.swing.JPanel jpmovies;
    private javax.swing.JPanel jpshow1;
    private javax.swing.JPanel jpshow3;
    private javax.swing.JPanel jpshow4;
    private javax.swing.JPanel jpslider;
    private javax.swing.JPanel jptvshows;
    private javax.swing.JTabbedPane jtaboptions;
    private javax.swing.JLabel lbSmallGallery;
    private javax.swing.JLabel lbSmallGalleryTvShow;
    private javax.swing.JLabel lbg1;
    private javax.swing.JLabel lbg2;
    private javax.swing.JLabel lbg3;
    private javax.swing.JLabel lbmainPhoto;
    private javax.swing.JLabel lbmovgenremovie1;
    private javax.swing.JLabel lbmovgenremovie2;
    private javax.swing.JLabel lbmovgenremovie3;
    private javax.swing.JLabel lbsh1;
    private javax.swing.JLabel lbsh2;
    private javax.swing.JLabel lbsh3;
    private javax.swing.JLabel lbsquare;
    private javax.swing.JLabel lbtvshowg1;
    private javax.swing.JLabel lbtvshowg2;
    private javax.swing.JLabel lbtvshowg3;
    // End of variables declaration//GEN-END:variables

    class GetData implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket(VODMainFrame.this.ip, 4000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("senddata\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    } else if (inpu.equals("receive")) {
                        String name = serverInp.readUTF();
                        String path = serverInp.readUTF();
                        String trailer = serverInp.readUTF();
                        String director = serverInp.readUTF();
                        String prducer = serverInp.readUTF();
                        String rating = serverInp.readUTF();
                        String releasedate = serverInp.readUTF();
                        String desc = serverInp.readUTF();
                        String cover = serverInp.readUTF();
                        String square = serverInp.readUTF();
                        String videoid = serverInp.readUTF();
                        String type = serverInp.readUTF();
                        String genre = serverInp.readUTF();
                        alData.add(new VideoData(name, path, trailer, director, prducer, rating,
                                releasedate, desc, cover, square, videoid, type, genre));
                    }
                }

                lbmainPhoto.setBounds(lbmainPhoto.getX(), lbmainPhoto.getY(),
                        getWidth(), getHeight() - 400);
                lbmainPhoto.setOpaque(true);
                lbmainPhoto.setBackground(Color.red);
                try {

                    int x = 10;
                    jScrollPane1.setBounds(1, lbmainPhoto.getHeight() + 10, getWidth(), 160);
                    jpslider.setOpaque(true);
                    jpslider.setBackground(Color.BLACK);

                    jtaboptions.setBounds(jScrollPane1.getX(),
                            lbmainPhoto.getHeight() + jScrollPane1.getHeight() + 10, getWidth(),
                            jScrollPane1.getHeight() + 30);
                    jpmovies.setSize(jpmovies.getWidth(), jpmovies.getHeight() - 50);
                    jtaboptions.setOpaque(true);
                    jtaboptions.setBackground(Color.BLACK);

                    jpmovies.setOpaque(true);
                    jpmovies.setBackground(Color.blue);

                    jptvshows.setOpaque(true);
                    jptvshows.setBackground(Color.ORANGE);

                    jpslider.setPreferredSize(new Dimension(3000 + 150, 300));
                    for (int i = 0; i < alData.size(); i++) {
                        VideoData videoData = alData.get(i);
                        SingleImage image = new SingleImage();
                        if(videoData.type.equals("TV")){
                            image.lbImage.setName("TV");
                        }else{
                            image.lbImage.setName("Movies");
                        }
                        String filename1 = videoData.square;
                        image.setBounds(x, 10, 300, 150);
                        Image scaledInstance1 = ImageIO.read(new File(filename1)).getScaledInstance(image.getWidth(),
                                image.getHeight(), Image.SCALE_SMOOTH);
                        image.lbImage.setIcon(new ImageIcon(scaledInstance1));
                        image.lbImage.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                
                                if(!((JLabel)e.getSource()).getName().equals("Movies")){
                                    
                                    ClientClasses.LaunchShow lSh= new ClientClasses.LaunchShow(videoData,"");
                                    lSh.setVisible(true);
                                }else{
                                LaunchMovie launchMovie = new LaunchMovie(videoData,ip);
                                launchMovie.setVisible(true);
                                }
                            }

                        });
                        jpslider.add(image);
                        jpslider.repaint();
                        x = x + image.getWidth() + 10;
                    }
                    repaint();

                    while (true) {
                        int no = (int) (Math.random() * alData.size());
                        VideoData videoData = alData.get(no);
                        Image scaledInstance = ImageIO.read(new File(videoData.cover)).getScaledInstance(lbmainPhoto.getWidth(),
                                lbmainPhoto.getHeight(), Image.SCALE_SMOOTH);
                        lbmainPhoto.setIcon(new ImageIcon(scaledInstance));

                        Image scaledInstance1 = ImageIO.read(new File(videoData.square)).getScaledInstance(lbsquare.getWidth(),
                                lbsquare.getHeight(), Image.SCALE_SMOOTH);
                        lbsquare.setIcon(new ImageIcon(scaledInstance1));
                        Thread.sleep(1500);

                    }

                } catch (Exception e) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    class FillMovie implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket(VODMainFrame.this.ip, 4000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("sendGenreMovie\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    } else if (inpu.equals("receive")) {
                        String name = serverInp.readUTF();
                        String path = serverInp.readUTF();
                        String trailer = serverInp.readUTF();
                        String director = serverInp.readUTF();
                        String prducer = serverInp.readUTF();
                        String rating = serverInp.readUTF();
                        String releasedate = serverInp.readUTF();
                        String desc = serverInp.readUTF();
                        String cover = serverInp.readUTF();
                        String square = serverInp.readUTF();
                        String videoid = serverInp.readUTF();
                        String type = serverInp.readUTF();
                        String genre = serverInp.readUTF();
                        alData1.add(new VideoData(name, path, trailer, director, prducer, rating,
                                releasedate, desc, cover, square, videoid, type, genre));
                    }
                }

                jpmovie1.setOpaque(true);
                jpmovie1.setBackground(Color.BLACK);
                jpmovie2.setOpaque(true);
                jpmovie2.setBackground(Color.BLACK);
                jpmovie3.setOpaque(true);
                jpmovie3.setBackground(Color.BLACK);
                for (int i = 0; i < alData1.size(); i++) {
                    VideoData videoData = alData1.get(i);
                    String name = videoData.name;;
                    String sqaure = videoData.square;
                    Image scaledInstance = null;
                    if (i == 0) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbg1.getWidth(),
                                lbg1.getHeight(), Image.SCALE_SMOOTH);
                        lbg1.setIcon(new ImageIcon(scaledInstance));
                        lbg1.setToolTipText(name);
                        lbmovgenremovie1.setForeground(Color.YELLOW);
                        lbmovgenremovie1.setText(name);
                        arVData[0] = videoData;
                    } else if (i == 1) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbg2.getWidth(),
                                lbg2.getHeight(), Image.SCALE_SMOOTH);
                        lbg2.setIcon(new ImageIcon(scaledInstance));
                        lbg2.setToolTipText(name);
                        lbmovgenremovie2.setForeground(Color.YELLOW);
                        lbmovgenremovie2.setText(name);
                        arVData[1] = videoData;
                    } else if (i == 2) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbg3.getWidth(),
                                lbg3.getHeight(), Image.SCALE_SMOOTH);
                        lbg3.setIcon(new ImageIcon(scaledInstance));
                        lbg3.setToolTipText(name);
                        lbmovgenremovie3.setText(name);
                        lbmovgenremovie3.setForeground(Color.YELLOW);
                        
                        arVData[2] = videoData;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     
    }

    class FillMovieAndTvShow implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket(VODMainFrame.this.ip, 4000);
                
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("sendGenreTv\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    } else if (inpu.equals("receive")) {
                         String name = serverInp.readUTF();
                        String path = serverInp.readUTF();
                        String trailer = serverInp.readUTF();
                        String director = serverInp.readUTF();
                        String prducer = serverInp.readUTF();
                        String rating = serverInp.readUTF();
                        String releasedate = serverInp.readUTF();
                        String desc = serverInp.readUTF();
                        String cover = serverInp.readUTF();
                        String square = serverInp.readUTF();
                        String videoid = serverInp.readUTF();
                        String type = serverInp.readUTF();
                        String genre = serverInp.readUTF();
                        alTv.add(new VideoData(name, path, trailer, director, prducer, rating,
                                releasedate, desc, cover, square, videoid, type, genre));
                    }
                }

                jpshow1.setOpaque(true);
                jpshow1.setBackground(Color.BLACK);
                jpshow3.setOpaque(true);
                jpshow3.setBackground(Color.BLACK);
                jpshow4.setOpaque(true);
                jpshow4.setBackground(Color.BLACK);
                for (int i = 0; i < alTv.size(); i++) {
                    VideoData videoData = alTv.get(i);
                    String name = videoData.name;;
                    String sqaure = videoData.square;
                    Image scaledInstance = null;
                    if (i == 0) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbsh1.getWidth(),
                                lbsh1.getHeight(), Image.SCALE_SMOOTH);
                        lbsh1.setIcon(new ImageIcon(scaledInstance));
                        lbsh1.setToolTipText(name);
                        lbtvshowg1.setText(name);
                        lbtvshowg1.setForeground(Color.YELLOW);
                        arVData[3] = videoData;
                    } else if (i == 1) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbsh2.getWidth(),
                                lbsh2.getHeight(), Image.SCALE_SMOOTH);
                        lbsh2.setIcon(new ImageIcon(scaledInstance));
                        lbsh2.setToolTipText(name);
                        lbtvshowg3.setText(name);
                        lbtvshowg3.setForeground(Color.YELLOW);
                        arVData[4] = videoData;
                    } else if (i == 2) {
                        scaledInstance = ImageIO.read(new File(sqaure)).getScaledInstance(lbsh3.getWidth(),
                                lbsh3.getHeight(), Image.SCALE_SMOOTH);
                        lbsh3.setIcon(new ImageIcon(scaledInstance));
                        lbsh3.setToolTipText(name);
                        lbtvshowg2.setText(name);
                        lbtvshowg2.setForeground(Color.YELLOW);
                        arVData[5] = videoData;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    class AnimateScrollBar implements Runnable {

        private int incr = 1;
        private boolean poss = true; //true=>foward
        private int currentPos;
        private int maxScroll;

        @Override
        public void run() {
            currentPos = VODMainFrame.this.jScrollPane1.getHorizontalScrollBar().getValue();
            maxScroll = VODMainFrame.this.jScrollPane1.getHorizontalScrollBar().getMaximum();
            try {
                while (true) {
                    Thread.sleep(20);
                    if (currentPos <= maxScroll && poss) {
                        VODMainFrame.this.jScrollPane1.getHorizontalScrollBar().setValue((currentPos += incr));
                    } else {
                        poss = false;
                        if (currentPos <= 0) {
                            poss = true;
                        }
                        VODMainFrame.this.jScrollPane1.getHorizontalScrollBar().setValue((currentPos -= incr));
                    }
                }
            } catch (Exception e) {
                System.out.println("ggg");
                e.printStackTrace();
            }
        }
    }
    
    

}

class VideoData {

    String name;
    String path;
    String trailer;
    String director;
    String prducer;
    String rating;
    String releasedate;
    String desc;
    String cover;
    String square;
    String videoid;
    String type;
    String genre;
    
    public VideoData(){
      this("","","","","","","","","","","","","");    
    }
    
    public VideoData(String name, String path, String trailer, String director,
            String prducer, String rating, String releasedate, String desc, String cover,
            String square, String videoid, String type, String genre) {
        this.name = name;
        this.path = path;
        this.trailer = trailer;
        this.director = director;
        this.prducer = prducer;
        this.rating = rating;
        this.releasedate = releasedate;
        this.desc = desc;
        this.cover = cover;
        this.square = square;
        this.videoid = videoid;
        this.type = type;
        this.genre = genre;

    }
}
