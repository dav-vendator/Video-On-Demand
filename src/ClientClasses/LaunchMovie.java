package ClientClasses;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class LaunchMovie extends javax.swing.JFrame {

    
    VideoData videoData1;
    String ip;
    LaunchMovie(VideoData videoData,String ip) {
        initComponents();
        this.ip = ip;
        this.videoData1 = videoData;
        this.setSize(850, 600);
        this.lbCover.setOpaque(true);
        this.lbSquare.setOpaque(true);
        lbCover.setSize(this.getWidth(),250);
        this.setVisible(true);
        Image scaledInstance = null;
        Image scaledSquare = null;
        try{
           scaledInstance = ImageIO.read(new File(videoData.cover)).getScaledInstance(lbCover.getWidth(),
                                lbCover.getHeight(), Image.SCALE_SMOOTH);
           scaledSquare = ImageIO.read(new File(videoData.square)).getScaledInstance(lbSquare.getWidth(),
                                lbSquare.getHeight(), Image.SCALE_SMOOTH);
        }catch(IOException e){
            e.printStackTrace();
        }     
        lbCover.setIcon(new ImageIcon(scaledInstance));
        lbSquare.setIcon(new ImageIcon(scaledSquare));
        this.lbTitle.setText(videoData.name);
        this.lbDirec.setText(videoData.director);
        this.lbProducer.setText(videoData.prducer);
        this.lbRating.setText(videoData.rating);
        this.lbReleaseDate.setText(videoData.releasedate);
        this.taDescr.setEnabled(false);
        this.taDescr.setText(videoData.desc);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSquare = new javax.swing.JLabel();
        lbCover = new javax.swing.JLabel();
        lbProducer = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbDirec = new javax.swing.JLabel();
        lbRating = new javax.swing.JLabel();
        lbReleaseDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescr = new javax.swing.JTextArea();
        lbMakeOffline = new javax.swing.JLabel();
        lbPlay1 = new javax.swing.JLabel();
        lbPlayTrailer1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(658, 494));
        getContentPane().setLayout(null);

        lbSquare.setForeground(new java.awt.Color(255, 102, 102));
        lbSquare.setText("Square");
        getContentPane().add(lbSquare);
        lbSquare.setBounds(20, 120, 270, 120);

        lbCover.setBackground(new java.awt.Color(255, 0, 0));
        lbCover.setForeground(new java.awt.Color(255, 51, 0));
        lbCover.setText("Cover");
        getContentPane().add(lbCover);
        lbCover.setBounds(-2, 0, 810, 250);

        lbProducer.setText("Producer");
        getContentPane().add(lbProducer);
        lbProducer.setBounds(10, 370, 230, 40);

        lbTitle.setText("Title");
        getContentPane().add(lbTitle);
        lbTitle.setBounds(10, 270, 260, 40);

        lbDirec.setText("Director");
        getContentPane().add(lbDirec);
        lbDirec.setBounds(10, 320, 260, 40);

        lbRating.setText("Rating");
        getContentPane().add(lbRating);
        lbRating.setBounds(10, 420, 210, 30);

        lbReleaseDate.setText("Release Date");
        getContentPane().add(lbReleaseDate);
        lbReleaseDate.setBounds(10, 470, 260, 30);

        taDescr.setColumns(20);
        taDescr.setRows(5);
        jScrollPane1.setViewportView(taDescr);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(370, 280, 440, 120);

        lbMakeOffline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/download-symbol.png"))); // NOI18N
        lbMakeOffline.setText("Make Offline");
        lbMakeOffline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMakeOfflineMouseClicked(evt);
            }
        });
        getContentPane().add(lbMakeOffline);
        lbMakeOffline.setBounds(450, 440, 110, 60);

        lbPlay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/play-button.png"))); // NOI18N
        lbPlay1.setText("Play");
        lbPlay1.setIconTextGap(10);
        lbPlay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPlay1MouseClicked(evt);
            }
        });
        getContentPane().add(lbPlay1);
        lbPlay1.setBounds(700, 440, 100, 60);

        lbPlayTrailer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/play-button (1).png"))); // NOI18N
        lbPlayTrailer1.setText("Play Trailer");
        lbPlayTrailer1.setIconTextGap(10);
        lbPlayTrailer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPlayTrailer1MouseClicked(evt);
            }
        });
        getContentPane().add(lbPlayTrailer1);
        lbPlayTrailer1.setBounds(580, 440, 110, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMakeOfflineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMakeOfflineMouseClicked
       String path = videoData1.path;
       VideoOfflineOne voff = new VideoOfflineOne(path,ip);
       voff.setVisible(true);
       
    }//GEN-LAST:event_lbMakeOfflineMouseClicked

    private void lbPlay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPlay1MouseClicked
        String path = videoData1.path;
        VLCFrameDemo cFrameDemo = new VLCFrameDemo(path);
        cFrameDemo.setVisible(true);
    }//GEN-LAST:event_lbPlay1MouseClicked

    private void lbPlayTrailer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPlayTrailer1MouseClicked
         String path = videoData1.trailer;
        VLCFrameDemo cFrameDemo = new VLCFrameDemo(path);
        cFrameDemo.setVisible(true);
    }//GEN-LAST:event_lbPlayTrailer1MouseClicked

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new LaunchMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCover;
    private javax.swing.JLabel lbDirec;
    private javax.swing.JLabel lbMakeOffline;
    private javax.swing.JLabel lbPlay1;
    private javax.swing.JLabel lbPlayTrailer1;
    private javax.swing.JLabel lbProducer;
    private javax.swing.JLabel lbRating;
    private javax.swing.JLabel lbReleaseDate;
    private javax.swing.JLabel lbSquare;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextArea taDescr;
    // End of variables declaration//GEN-END:variables
}
