package AdminClasses;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddEpisode extends javax.swing.JInternalFrame {

    private String path = "";
    ArrayList<String> alshownames = new ArrayList<>();

    public AddEpisode() {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from videos where category_name='TV'");
            cbSelect.addItem("Select...");
            while (rs.next()) {
                String showname = rs.getString("title");
                String showid = rs.getString("video_id");
                alshownames.add(showname + "~~" + showid + "~~");
                cbSelect.addItem(showname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbSelect = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbImage1 = new javax.swing.JLabel();
        lbImage2 = new javax.swing.JLabel();
        btCover = new javax.swing.JButton();
        btSquare = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        tfDur = new javax.swing.JTextField();
        btVidpath = new javax.swing.JButton();
        tfVideo = new javax.swing.JTextField();
        tfCover = new javax.swing.JTextField();
        tfSquare = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();

        setTitle("ADD EPISODE");

        cbSelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSelectItemStateChanged(evt);
            }
        });

        jLabel1.setText("Select Tv Show");

        jLabel2.setText("Episode Name");

        jLabel3.setText("Cover Photo");

        jLabel4.setText("Square Photo");

        jLabel5.setText("Description");

        jLabel6.setText("Duration");

        jLabel7.setText("Video Path");

        lbImage1.setText("cover photo");

        lbImage2.setText("square photo");

        btCover.setBackground(new java.awt.Color(255, 255, 255));
        btCover.setText("...");
        btCover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoverActionPerformed(evt);
            }
        });

        btSquare.setBackground(new java.awt.Color(255, 255, 255));
        btSquare.setText("...");
        btSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSquareActionPerformed(evt);
            }
        });

        taDesc.setColumns(20);
        taDesc.setRows(5);
        jScrollPane1.setViewportView(taDesc);

        btVidpath.setBackground(new java.awt.Color(255, 255, 255));
        btVidpath.setText("...");
        btVidpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVidpathActionPerformed(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(255, 255, 255));
        btAdd.setText("ADD EPISODE");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cbSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btVidpath))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfCover)
                                        .addComponent(tfSquare)
                                        .addComponent(tfDur, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCover)
                            .addComponent(btSquare))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfCover, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btCover))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(tfSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(btSquare))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(lbImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btVidpath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lbImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSquareActionPerformed
        JFileChooser fc = new JFileChooser();
        int ans = fc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f1 = fc.getSelectedFile();
            tfSquare.setText(f1.getPath());
            this.path = f1.getPath();
        }
        this.lbImage2.setIcon(new ImageIcon(path));
    }//GEN-LAST:event_btSquareActionPerformed

    private void btCoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoverActionPerformed
        JFileChooser fc = new JFileChooser();

        int ans = fc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f1 = fc.getSelectedFile();
            tfCover.setText(f1.getPath());
            this.path = f1.getPath();
        }
        this.lbImage1.setIcon(new ImageIcon(path));
    }//GEN-LAST:event_btCoverActionPerformed

    private void btVidpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVidpathActionPerformed
        JFileChooser fc = new JFileChooser();

        int ans = fc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f1 = fc.getSelectedFile();
            tfVideo.setText(f1.getPath());
        }
    }//GEN-LAST:event_btVidpathActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        String Title = tfName.getText();
        String Videopath = tfVideo.getText();
        String Coverpath = tfCover.getText();
        String Squarepath = tfSquare.getText();
        String Duration = tfDur.getText();

        int selectedIndex = cbSelect.getSelectedIndex();
        if (selectedIndex == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Please select a show first?");
            return;
        }

        String show = alshownames.get(selectedIndex - 1);
        String[] split = show.split("~~");
        String desc = taDesc.getText();
        if (Title.isEmpty() || Videopath.isEmpty()
                || desc.isEmpty() || Coverpath.isEmpty() || Squarepath.isEmpty() || Duration.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Fill all the Fields");
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from episodes where episode_name='" + tfName.getText() + "'"
                        + " and video_path='" + Videopath + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Same Titled Episode Already added!!");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("episode_name", Title);
                    rs.updateString("episode_cover", Coverpath);
                    rs.updateString("episode_square", Squarepath);
                    rs.updateString("tvshow_id", split[1]);
                    rs.updateString("Description", desc);
                    rs.updateString("duration", Duration);
                    rs.updateString("video_path", Videopath);
                    rs.insertRow();
                    JOptionPane.showMessageDialog(this, "Episode of " + split[0] + " Added Successsfully");
                    taDesc.setText("");
                    tfCover.setText("");
                    tfDur.setText("");
                    tfName.setText("");
                    tfSquare.setText("");
                    tfVideo.setText("");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void cbSelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSelectItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSelectItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCover;
    private javax.swing.JButton btSquare;
    private javax.swing.JButton btVidpath;
    private javax.swing.JComboBox<String> cbSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage1;
    private javax.swing.JLabel lbImage2;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTextField tfCover;
    private javax.swing.JTextField tfDur;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSquare;
    private javax.swing.JTextField tfVideo;
    // End of variables declaration//GEN-END:variables
}
