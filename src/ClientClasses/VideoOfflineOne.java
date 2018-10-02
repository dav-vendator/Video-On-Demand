
package ClientClasses;


import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


public class VideoOfflineOne extends javax.swing.JFrame {

    String videoPath;
    String ip;
    public VideoOfflineOne(String videP,String ip) {
        this.videoPath = videP;
        this.ip = ip;
        ImageIcon img = new ImageIcon("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\save_file.png");
        this.setIconImage(img.getImage());
        repaint();
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSvPath = new javax.swing.JLabel();
        btBrowse = new javax.swing.JButton();
        tfSavePath = new javax.swing.JTextField();
        btCancel = new javax.swing.JButton();
        btDownload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Download Video");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.black);
        setIconImage(new ImageIcon("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\save_file.png").getImage());
        setIconImages(null);
        setLocationByPlatform(true);
        setResizable(false);

        lbSvPath.setBackground(new java.awt.Color(255, 255, 255));
        lbSvPath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSvPath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSvPath.setText("Save Path");

        btBrowse.setBackground(new java.awt.Color(255, 255, 255));
        btBrowse.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\browse.png")); // NOI18N
        btBrowse.setText("....");
        btBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBrowseActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(255, 255, 255));
        btCancel.setForeground(new java.awt.Color(255, 0, 0));
        btCancel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\cancel.png")); // NOI18N
        btCancel.setText("Cancel");
        btCancel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btCancel.setIconTextGap(10);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btDownload.setBackground(new java.awt.Color(255, 255, 255));
        btDownload.setForeground(new java.awt.Color(0, 0, 255));
        btDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/downloade_button.png"))); // NOI18N
        btDownload.setText("Download");
        btDownload.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btDownload.setIconTextGap(10);
        btDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbSvPath, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(tfSavePath, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSavePath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbSvPath, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDownload)
                            .addComponent(btCancel))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBrowseActionPerformed
        JFileChooser fc = new JFileChooser();
        int ans = fc.showSaveDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
          tfSavePath.setText(fc.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_btBrowseActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadActionPerformed
       if(!tfSavePath.getText().isEmpty()){
           VideoOfflineTwo vf2 = new VideoOfflineTwo(tfSavePath.getText(),this.videoPath,this.ip);
           vf2.setVisible(true);
           dispose();
       }
    }//GEN-LAST:event_btDownloadActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VideoOfflineOne(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBrowse;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDownload;
    private javax.swing.JLabel lbSvPath;
    private javax.swing.JTextField tfSavePath;
    // End of variables declaration//GEN-END:variables
}
