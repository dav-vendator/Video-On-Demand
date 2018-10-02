package AdminClasses;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ViewCategory extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewData
     */
    TableModel tM;
    ArrayList<Categories> list = new ArrayList<>();

    class Categories {

        String categoryName;    
        String categoryDesc;
        String photo;

        Categories(String nm, String desc, String photo) {
            this.categoryDesc = desc;
            this.categoryName = nm;
            this.photo = nm;

        }

    }

    class TableModel extends AbstractTableModel {

        private String[] title = {"Serial Number", "Category's Name",
            "Category's Description"
        };

        @Override
        public int getRowCount() {
            return list.size();
        }
        
        @Override
        public String getColumnName(int column) {
            return title[column];
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            if (columnIndex == 0) {

                return rowIndex + 1;
            } else if (columnIndex == 1) {

                return list.get(rowIndex).categoryName;
            } else {
                return list.get(rowIndex).categoryDesc;
            }

        }

    }
    Connection dbcon;

    public ViewCategory(Connection con) {
        this.dbcon = con;

        initComponents();
        try {
            Statement stmt = dbcon.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categories");

            while (rs.next()) {
                list.add(new Categories(rs.getString("c_name"),
                        rs.getString("c_desc"),
                        rs.getString("c_photo")));
            }

        } catch (SQLException seEx) {
            seEx.printStackTrace();
        }

        tM = new TableModel();
        this.tbView.setModel(tM);
        tM.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbView = new javax.swing.JTable();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setTitle("VIEW CATEGORY");

        tbView.setPreferredSize(new java.awt.Dimension(500, 500));
        jScrollPane1.setViewportView(tbView);

        btEdit.setBackground(new java.awt.Color(255, 255, 255));
        btEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btEdit.setText("EDIT");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(255, 255, 255));
        btDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btDelete.setText("DELETE");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed

        int ans = tbView.getSelectedRow();
        if (ans == -1) {
            JOptionPane.showMessageDialog(this, "Please Select a row first");
        } else {
            String cname = tbView.getValueAt(ans, 1).toString();

            JOptionPane.showConfirmDialog(this, "Are you sure to delete this row ?", "My Confirm Dialog", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                try {
                    Statement stmt = dbcon.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM categories where c_name = '" + cname
                            + "'");

                    if (rs.next()) {

                        rs.deleteRow();
                        list.remove(ans);
                        tM.fireTableDataChanged();
                    }

                } catch (SQLException seEx) {
                    seEx.printStackTrace();

                    list.remove(ans);
                    tM.fireTableDataChanged();
                }
            }

    }//GEN-LAST:event_btDeleteActionPerformed
    }
    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:

        int ans = tbView.getSelectedRow();
        if (ans == -1) {
            JOptionPane.showMessageDialog(this, "Please Select a row first");
        } else {
            String cname = tbView.getValueAt(ans, 1).toString();
            String cdecs = tbView.getValueAt(ans, 2).toString();
            String photo = list.get(ans).photo;
            EditCategory obj = new EditCategory(cname, cdecs, photo);
            obj.setSize(660, 300);
            obj.setIconifiable(true);
            obj.setMaximizable(true);
            obj.setClosable(true);
            obj.setResizable(false);
            this.getDesktopPane().add(obj);
            obj.setVisible(true);
            obj.moveToFront();
        }

    }//GEN-LAST:event_btEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    public javax.swing.JButton btEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbView;
    // End of variables declaration//GEN-END:variables

}
