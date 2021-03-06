package AdminClasses;


import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hardeep
 */
public class ViewEpisode extends javax.swing.JInternalFrame {

    TableModel tm;
    ArrayList<TableData> alEpisodes = new ArrayList<>();
    ArrayList<String> tvShows;
    ArrayList<String> alshownames = new ArrayList<>();

    public ViewEpisode() {
        tm = new TableModel();
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
        tbEpisode.setModel(tm);
        tm.fireTableDataChanged();
    }

    private void getepisodes(String showid) {
        try {
            System.out.println(showid);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from episodes where tvshow_id='" + showid + "'");
            while (rs.next()) {
                TableData data = new TableData(rs.getInt("episode_id"), rs.getString("episode_name"),
                        rs.getString("episode_cover"), rs.getString("episode_square"),
                        rs.getString("description"),
                        rs.getString("video_path"),
                        rs.getString("duration"));
                alEpisodes.add(data);
            }
            tm.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class TableData {

        int episode_id;
        String e_name;
        String e_cover;
        String _square;
        String e_description;
        String video_path;
        String duration;

        public TableData(int episode_id, String e_name, String e_cover, String _square, String e_description,
                String video_path, String duration) {
            this.episode_id = episode_id;
            this.e_name = e_name;
            this.e_cover = e_cover;
            this._square = _square;
            this.e_description = e_description;
            this.video_path = video_path;
            this.duration = duration;
        }
    }

    class TableModel extends AbstractTableModel {

        String[] titles = {"Title", "Description", "Duration"};

        public int getRowCount() {
            return alEpisodes.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            TableData td = alEpisodes.get(rowIndex);
            if (columnIndex == 0) {
                return td.e_name;
            } else if (columnIndex == 1) {
                return td.e_description;
            } else {
                return td.duration;
            }
        }

        @Override
        public String getColumnName(int column) {
            return titles[column]; //To change body of generated methods, choose Tools | Templates.
        }

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
        tbEpisode = new javax.swing.JTable();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        cbSelect = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(tbEpisode);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(28, 86, 452, 262);

        btEdit.setBackground(new java.awt.Color(255, 255, 255));
        btEdit.setText("EDIT");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        getContentPane().add(btEdit);
        btEdit.setBounds(67, 385, 107, 37);

        btDelete.setBackground(new java.awt.Color(255, 255, 255));
        btDelete.setText("DELETE");
        getContentPane().add(btDelete);
        btDelete.setBounds(305, 385, 135, 37);

        cbSelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSelectItemStateChanged(evt);
            }
        });
        getContentPane().add(cbSelect);
        cbSelect.setBounds(168, 11, 243, 32);

        jLabel1.setText("Select TV Show");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(43, 11, 99, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSelectItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int selectedIndex = cbSelect.getSelectedIndex();
            if (selectedIndex == 0) {
                return;
            }
            String show = alshownames.get(selectedIndex - 1);
            String[] split = show.split("~~");
            getepisodes(split[1]);
        }
    }//GEN-LAST:event_cbSelectItemStateChanged

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        int ans = tbEpisode.getSelectedRow();
        if (ans == -1) {
            JOptionPane.showMessageDialog(this, "Please Select a row first");
        } else {
            int selectedIndex = cbSelect.getSelectedIndex();
            if (selectedIndex == 0) {
                JOptionPane.showMessageDialog(rootPane, "Please select a show first!!");
                return;
            }
            String show = alshownames.get(selectedIndex - 1);
            String[] split = show.split("~~");
            getepisodes(split[1]);
            EditEpisode obj = new EditEpisode(alEpisodes.get(ans).episode_id, show);
            obj.setSize(710, 635);
            obj.setIconifiable(true);
            obj.setClosable(true);
            obj.setMaximizable(true);
            obj.setResizable(false);
            this.getDesktopPane().add(obj);
            obj.setVisible(true);
            obj.moveToFront();

        }
    }//GEN-LAST:event_btEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JComboBox<String> cbSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEpisode;
    // End of variables declaration//GEN-END:variables
}
