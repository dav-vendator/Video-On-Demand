
package ClientClasses;

import java.awt.Color;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class LaunchShow extends javax.swing.JFrame {

     ArrayList<EpData> alTvShow = new ArrayList<>();

    private String ip;
    private VideoData vd;
    private TableModel tm;
    public LaunchShow(VideoData vdDat,String ip) {
        tm = new TableModel();
        initComponents();
        this.vd = vdDat;
        this.ip = ip;
        this.lbCover.setOpaque(true);
        this.lbSquare.setOpaque(true);
        this.lbCover.setBackground(Color.RED);
        this.lbSquare.setBackground(Color.BLACK);
        System.out.println("Here Launch Videos");
        try {
         Image scaledInstance = ImageIO.read(new File(vd.cover)).getScaledInstance(lbCover.getWidth(),
                                lbCover.getHeight(), Image.SCALE_SMOOTH);
        lbCover.setIcon(new ImageIcon(scaledInstance));
        
        
        }catch (Exception e) {
           e.printStackTrace();
        }
        this.lbShowName1.setText(vd.name);
        this.lbRating.setText(vd.rating);
        this.lbReleaseDate.setText(vd.releasedate);
        this.lbDri.setText(vd.director);
        loadArrayList();
        tm.fireTableDataChanged();
        this.setSize(715, 640);
        this.setResizable(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSquare = new javax.swing.JLabel();
        lbCover = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEpisodes = new javax.swing.JTable();
        lbRating = new javax.swing.JLabel();
        lbShowName1 = new javax.swing.JLabel();
        lbDri = new javax.swing.JLabel();
        lbReleaseDate = new javax.swing.JLabel();
        btOffline = new javax.swing.JButton();
        btPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lbSquare.setText("SQUARE");
        getContentPane().add(lbSquare);
        lbSquare.setBounds(10, 90, 240, 170);

        lbCover.setText("COVER");
        getContentPane().add(lbCover);
        lbCover.setBounds(0, 0, 710, 270);

        tbEpisodes.setModel(tm
        );
        tbEpisodes.setToolTipText("Epsode List");
        tbEpisodes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbEpisodes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbEpisodes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 280, 430, 270);

        lbRating.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbRating.setText("Rating");
        getContentPane().add(lbRating);
        lbRating.setBounds(10, 500, 210, 50);

        lbShowName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbShowName1.setText("Show");
        getContentPane().add(lbShowName1);
        lbShowName1.setBounds(10, 290, 210, 50);

        lbDri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDri.setText("Director");
        getContentPane().add(lbDri);
        lbDri.setBounds(10, 360, 210, 50);

        lbReleaseDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbReleaseDate.setText("Realese Date");
        getContentPane().add(lbReleaseDate);
        lbReleaseDate.setBounds(10, 430, 210, 50);

        btOffline.setText("Make Offline");
        btOffline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOfflineActionPerformed(evt);
            }
        });
        getContentPane().add(btOffline);
        btOffline.setBounds(350, 560, 150, 40);

        btPlay.setText("Play Selected");
        btPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btPlay);
        btPlay.setBounds(550, 560, 150, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private final void loadArrayList(){
        Socket socket = null;
        try {
                socket = new Socket(this.ip, 4000);
                DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
                DataInputStream serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("sendtvdata\r\n");
                serverOut.writeUTF(vd.videoid);
                System.out.println("Receiving Data");
                while (true) {
                    String inpu = serverInp.readUTF();
                    System.out.println(inpu);
                    if (inpu.equals("done")) {
                        break;
                    } else if (inpu.equals("receive")) {
                        String name = serverInp.readUTF();
                        String cover = serverInp.readUTF();
                        String square = serverInp.readUTF();
                        String description = serverInp.readUTF();
                        String duration = serverInp.readUTF();
                        String path = serverInp.readUTF();
                        alTvShow.add(new EpData(name,cover,square,description,duration,path));
                    }
                }
           }catch(Exception e){
               e.printStackTrace();
         }finally{
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
        System.out.println("Received");
        try {
            Image scaledInstance1 = ImageIO.read(new File(alTvShow.get(0).square)).getScaledInstance(lbSquare.getWidth(),
                                lbSquare.getHeight(), Image.SCALE_SMOOTH);
        lbSquare.setIcon(new ImageIcon(scaledInstance1));
        } catch (Exception e) {
        }
    }
    
    
    private void btOfflineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOfflineActionPerformed
        int selected = tbEpisodes.getSelectedRow();
        if(selected != -1){
         String path = alTvShow.get(selected).vpath;
         VideoOfflineOne voff = new VideoOfflineOne(path,ip);
         voff.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane,"Please Select an Episode to play first.");
        }
    }//GEN-LAST:event_btOfflineActionPerformed

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlayActionPerformed
        int selected = tbEpisodes.getSelectedRow();
        if(selected != -1){
         String path = alTvShow.get(selected).vpath;
         System.out.println(path + "********************");
         VLCFrameDemo cFrameDemo = new VLCFrameDemo(path);
         cFrameDemo.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane,"Please Select an Episode to play first.");
        }
    }//GEN-LAST:event_btPlayActionPerformed

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
            java.util.logging.Logger.getLogger(LaunchShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaunchShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaunchShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaunchShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          //      new ViewAllEpisodes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOffline;
    private javax.swing.JButton btPlay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCover;
    private javax.swing.JLabel lbDri;
    private javax.swing.JLabel lbRating;
    private javax.swing.JLabel lbReleaseDate;
    private javax.swing.JLabel lbShowName1;
    private javax.swing.JLabel lbSquare;
    private javax.swing.JTable tbEpisodes;
    // End of variables declaration//GEN-END:variables

class TableModel extends AbstractTableModel{
       String [] name = {"Serial No.","Name","Description","Duration"}; 
       @Override
        public int getRowCount() {
           return alTvShow.size();
        }

        @Override
        public int getColumnCount() {
           return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            EpData ep  = alTvShow.get(rowIndex);
            if(columnIndex == 0){
                return rowIndex+1;
            }else if(columnIndex == 1){
                return ep.name;
            }else if(columnIndex == 2){
                return ep.desc;
            }else{
                return ep.duration;
            }
        }
        
        public String getColumnName(int index){
            return name[index];
        }

 }
}

class EpData{

    public EpData(String name, String cover, String square, String desc, String duration, String vpath) {
        this.name = name;
        this.cover = cover;
        this.square = square;
        this.desc = desc;
        this.duration = duration;
        this.vpath = vpath;
    }

  
  String name;
  String cover;
  String square;
  String desc;
  String duration;
  String vpath;
}
