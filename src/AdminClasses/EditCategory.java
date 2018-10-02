package AdminClasses;


import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class EditCategory extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditData
     */
    String cname;
    String cdesc;
    String path;

    public EditCategory(String cname, String decs, String photo) {
        initComponents();
        tfcname.setEnabled(false);
        this.cname = cname;
        this.cdesc = decs;
        this.path = photo;

        tfcname.setText(cname);
        tacdesc.setText(cdesc);
        lbphoto.setIcon(new ImageIcon(path));
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfcname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tacdesc = new javax.swing.JTextArea();
        lbphoto = new javax.swing.JLabel();
        editbt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        upbt = new javax.swing.JButton();
        tfcname1 = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");

        setTitle("UPDATE CATEGORY");

        jLabel2.setText("Category Description");

        jLabel3.setText("Category Photo");

        tacdesc.setColumns(20);
        tacdesc.setRows(5);
        jScrollPane1.setViewportView(tacdesc);

        lbphoto.setText("photo");

        editbt.setBackground(new java.awt.Color(255, 255, 255));
        editbt.setText("...");
        editbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtActionPerformed(evt);
            }
        });

        jLabel5.setText("Category Name");

        upbt.setBackground(new java.awt.Color(255, 255, 255));
        upbt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        upbt.setText("UPDATE");
        upbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upbtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfcname1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editbt))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(lbphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(107, 107, 107)
                                .addComponent(tfcname, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(upbt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfcname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lbphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfcname1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(editbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21)
                .addComponent(upbt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int ans = fc.showOpenDialog(this);
        File image = null;
        if (ans == JFileChooser.APPROVE_OPTION) {
            image = fc.getSelectedFile();
            this.path = image.getPath();
            Image scaledInstance = null;
            Image scaledSquare = null;
        try{
           scaledInstance = ImageIO.read(image).getScaledInstance(lbphoto.getWidth(),
                                lbphoto.getHeight(), Image.SCALE_SMOOTH);
           lbphoto.setIcon(new ImageIcon(scaledInstance));
        }catch(Exception e){
            e.printStackTrace();
        }    
       }
        this.lbphoto.setText(path.equals("") ? "dummy.jpg" : path);
    }//GEN-LAST:event_editbtActionPerformed

    private void upbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upbtActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Created");

            ResultSet rs = stmt.executeQuery("select * from categories where c_name='" + cname + "'");
            System.out.println("ResultSet Created\n\n");

            if (rs.next()) {
                rs.updateString("c_desc", tacdesc.getText());
                rs.updateString("c_photo", path);
                rs.updateRow();
                JOptionPane.showMessageDialog(rootPane, "updated sccessfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_upbtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JTextArea tacdesc;
    private javax.swing.JTextField tfcname;
    private javax.swing.JTextField tfcname1;
    private javax.swing.JButton upbt;
    // End of variables declaration//GEN-END:variables
}
