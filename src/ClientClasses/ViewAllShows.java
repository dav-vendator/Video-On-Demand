
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
import javax.swing.JOptionPane;

public class ViewAllShows extends javax.swing.JFrame {

    String ip="";
    public ViewAllShows(String ip) {
        initComponents();
        this.ip = ip;
        this.setSize(1040,768);
        this.setResizable(false);
        this.ip = ip;
        jScrollPane2.setSize(1024, 768);
        jpAllShows.setSize(1024, 768);
        jpAllShows.setOpaque(true);
        jpAllShows.setBackground(Color.BLACK);
        this.setVisible(true);
        new Thread(new GetAllShows()).start();
        repaint();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jpAllShows = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jpAllShows.setLayout(null);
        jScrollPane2.setViewportView(jpAllShows);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 40, 1230, 430);

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TV SHOWS");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1230, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             new ViewAllShows("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpAllShows;
    // End of variables declaration//GEN-END:variables

   class GetAllShows implements Runnable {

        ArrayList<String> algenre = new ArrayList<>();

        @Override
        public void run() {
            try {
                Socket socket = new Socket(ip, 4000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("sendGenreShow\r\n");
                while (true) {
                    String inpu = serverInp.readUTF();
                    if (inpu.equals("done")) {
                        break;
                    }
                    algenre.add(inpu);
                }
                System.out.println("Genre Loaded: "+algenre.size());
                if (algenre.size() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No Movies found!!");
                    dispose();
                    return;
                }

                long height = algenre.size() * 300;
                jpAllShows.setPreferredSize(new Dimension(jpAllShows.getWidth(), (int) height));

                for (int i = 0; i < algenre.size(); i++) {
                    String genre = algenre.get(i);
                    serverOut.writeBytes("sendShows\r\n");
                    serverOut.writeBytes(genre + "\r\n");
                    ArrayList<VideoData> alData = new ArrayList<>();

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
                            alData.add(new VideoData(name, path, trailer, director, prducer, rating,
                                    releasedate, desc, cover, square, videoid, type, genre));
                        }
                    }
                    showPanels(genre, alData);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int x = 10;
        int y = 10;

        private void showPanels(String genre, ArrayList<VideoData> al) {
            try {
                int x = 10;
                int y = 10;
                GeneredVideos generedVideos = new GeneredVideos();
                int height = (al.size() * 270) + (al.size() * 10);
                generedVideos.jPanel1.setPreferredSize(new Dimension(getWidth(), height));
                generedVideos.jsGV.setSize(new Dimension(getWidth(), generedVideos.jsGV.getHeight()));
                generedVideos.jLabel1.setText(genre);
                generedVideos.setBounds(this.x, this.y, getWidth(), 265);
                this.y = this.y + 280;
                jpAllShows.add(generedVideos);
                for (int i = 0; i < al.size(); i++) {
                    VideoData videoData = al.get(i);
                    SingleImage image = new SingleImage();
                    String filename1 = videoData.square;
                    image.setBounds(x, y, 300, 150);
                    Image scaledInstance1 = ImageIO.read(new File(filename1)).getScaledInstance(image.getWidth(),
                            image.getHeight(), Image.SCALE_SMOOTH);
                    image.lbImage.setIcon(new ImageIcon(scaledInstance1));
                    image.lbImage.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println(videoData.path);
                            LaunchShow launchShow = new LaunchShow(videoData,ip);
                            launchShow.setVisible(true);
                        }
                    });
                    image.setOpaque(true);
                    image.setForeground(Color.BLACK);
                    generedVideos.jPanel1.add(image);
                    generedVideos.jPanel1.setOpaque(true);
                    generedVideos.jPanel1.setForeground(Color.BLACK);
                    generedVideos.jPanel1.repaint();
                  
                    if ((i + 1) % 3 == 0) {
                        x = 10;
                        y = y + 150 + 10;
                    } else {
                        x = x + image.getWidth() + 10;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
