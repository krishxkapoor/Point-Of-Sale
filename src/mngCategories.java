import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class mngCategories extends javax.swing.JFrame {

    ArrayList<BeanCategories> al;
    mytablemodel tm;
    public mngCategories() {

        initComponents();
        al = new ArrayList<>();
        tm = new mytablemodel();
        jt.setModel(tm);
        setSize(876, 653);
        setLocationRelativeTo(null);
        getcat();
    }
    public void getcat()
    {
        String ans=myClient.getcategory();
        StringTokenizer st=new StringTokenizer(ans, "$");
        while(st.hasMoreTokens())
        {
            StringTokenizer st2=new StringTokenizer(st.nextToken(), ";;");
            while(st2.hasMoreTokens())
            {
                String name=st2.nextToken();
                String desc=st2.nextToken();
                String photo=st2.nextToken();
                al.add(new BeanCategories(name, desc, photo));
            }
        }
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlb1 = new javax.swing.JLabel();
        jlb2 = new javax.swing.JLabel();
        jlb3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTextArea();
        photo = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        CHOOSE = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        HOME = new javax.swing.JButton();
        jtf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jlb1.setText("Name");
        getContentPane().add(jlb1);
        jlb1.setBounds(24, 55, 80, 30);

        jlb2.setText("Description");
        getContentPane().add(jlb2);
        jlb2.setBounds(20, 110, 80, 30);

        jlb3.setText("Photo");
        getContentPane().add(jlb3);
        jlb3.setBounds(20, 250, 80, 30);

        jta.setColumns(20);
        jta.setRows(5);
        jScrollPane1.setViewportView(jta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 110, 238, 90);
        getContentPane().add(photo);
        photo.setBounds(120, 230, 170, 130);

        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        getContentPane().add(ADD);
        ADD.setBounds(160, 410, 170, 80);

        CHOOSE.setText("Choose");
        CHOOSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHOOSEActionPerformed(evt);
            }
        });
        getContentPane().add(CHOOSE);
        CHOOSE.setBounds(300, 250, 100, 27);

        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jt);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 40, 456, 406);

        HOME.setText("HOME");
        HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HOMEActionPerformed(evt);
            }
        });
        getContentPane().add(HOME);
        HOME.setBounds(20, 10, 110, 30);
        getContentPane().add(jtf);
        jtf.setBounds(120, 50, 180, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    File selectedFile;
    private void CHOOSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHOOSEActionPerformed
        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            ImageIcon ic = new ImageIcon(selectedFile.getPath());
            Image ic1 = ic.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2 = new ImageIcon(ic1);
            photo.setIcon(ic2);
        }
    }//GEN-LAST:event_CHOOSEActionPerformed
    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed

        String name = jtf.getText();
        String desc = jta.getText();
        String ans = myClient.addcat(name, desc, selectedFile);
        if (ans.equals("success")) {
            JOptionPane.showMessageDialog(this, "Added Suucesfully");
        } else if (ans.equals("fail")) {
            JOptionPane.showMessageDialog(this, "Already Added");
        } else {
            JOptionPane.showMessageDialog(this, ans);
        }
        
        tm.fireTableDataChanged();
        al.clear();
        getcat();
    }//GEN-LAST:event_ADDActionPerformed
    private void HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HOMEActionPerformed
        dispose();
        adminHome obj = new adminHome();
        obj.setVisible(true);
    }//GEN-LAST:event_HOMEActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mngCategories().setVisible(true);
            }
        });
    }
    class mytablemodel extends AbstractTableModel {
        @Override
        public int getRowCount() {
            return al.size();
        }
        @Override
        public int getColumnCount() {
            return 3;
        }
        @Override
        public Object getValueAt(int i, int j) {
            BeanCategories obj = al.get(i);
            if (j == 0) {
                return obj.name;
            } else if (j == 1) {
                return obj.description;
            } else {
                return obj.photo;
            }
        }
        @Override
        public String getColumnName(int j){
            String col[] = {"name","description","photo"};
            return col[j];
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton CHOOSE;
    private javax.swing.JButton HOME;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlb1;
    private javax.swing.JLabel jlb2;
    private javax.swing.JLabel jlb3;
    private javax.swing.JTable jt;
    private javax.swing.JTextArea jta;
    private javax.swing.JTextField jtf;
    private javax.swing.JLabel photo;
    // End of variables declaration//GEN-END:variables
}
