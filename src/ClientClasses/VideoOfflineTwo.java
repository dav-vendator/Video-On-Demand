
package ClientClasses;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;


public class VideoOfflineTwo extends javax.swing.JFrame {
   private String savePath;
   private String videoPath;
   private String ip;
   private Socket sock;
   private DataOutputStream dos;
   private DataInputStream dis;
   private FileOutputStream fos;
   private long count=0;
   private long fullSize = 0;
    VideoOfflineTwo(String text, String videoPath, String ip) {
      initComponents();
     

      this.videoPath = videoPath;
      this.savePath = text;
      this.ip = ip;
      this.pbDownload.setString("0%");
      this.setTitle("Downloading : "+videoPath+" from Video Terminal");
      new Thread(new fileDownload()).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        btCancel = new javax.swing.JButton();
        pbDownload = new javax.swing.JProgressBar();
        lbProgress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Downloading");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("  Bytes Received:");

        lbStatus.setBackground(new java.awt.Color(255, 255, 255));
        lbStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatus.setText("2200 B / 10222334 B");

        btCancel.setBackground(new java.awt.Color(255, 255, 255));
        btCancel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\cancel.png")); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        pbDownload.setBackground(new java.awt.Color(255, 153, 0));
        pbDownload.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pbDownload.setForeground(new java.awt.Color(0, 0, 0));
        pbDownload.setToolTipText("Current Progress");
        pbDownload.setValue(50);
        pbDownload.setOpaque(true);
        pbDownload.setStringPainted(true);

        lbProgress.setBackground(new java.awt.Color(255, 255, 255));
        lbProgress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProgress.setText("Progress:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pbDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pbDownload, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lbProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
          
           try {
             dos.writeBytes("CANCEL\r\n");
             fos.flush();
             fos.close();
             File file = new File(savePath);
             if(file.exists()){
               file.delete();
           }     
         } catch (Exception e) {
        }
         dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VideoOfflineTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VideoOfflineTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VideoOfflineTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VideoOfflineTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VideoOfflineTwo("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbProgress;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JProgressBar pbDownload;
    // End of variables declaration//GEN-END:variables

class fileDownload implements Runnable{
    @Override
    public void run(){
      try{
            sock = new Socket(ip,4000);
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());
            dos.writeBytes("download\r\n");
            dos.writeBytes(videoPath+"\r\n");
            if(dis.readLine().equals("receive")){
                System.out.println("Writing Started");
              fos = new FileOutputStream(VideoOfflineTwo.this.savePath);
              dos.writeBytes("SEND\r\n");
              
              fullSize = dis.readLong();
                System.out.println(fullSize);
              byte b[] = new byte[100000];
              count = 0;
              while(true)
              {
                Thread.sleep(10);
                int n = dis.read(b,0,100000);
                fos.write(b,0,n);
                count+=n;
//                System.out.println(count +" bytes read of "+filesize+" bytes");
                lbStatus.setText(count+" / "+fullSize);
//                  System.out.println("Progress:"+();
                int progress = (int)((count/(float)fullSize)*100.0);
                pbDownload.setValue(progress);
                pbDownload.setString(progress+" %");
                dos.writeBytes("d\r\n");
                 
                if(count>=fullSize)
                {
                    break;
                }
              }
              dos.writeBytes("file received\r\n");
              dos.flush();                        
           }
        }catch(Exception e){
          e.printStackTrace();
      }
      if(pbDownload.getValue() == 100){
       JOptionPane.showMessageDialog(rootPane,"File Download Completed.");
       dispose();
      }
    }
}



}
