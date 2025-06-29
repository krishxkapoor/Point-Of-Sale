import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
 
public class mngProducts extends javax.swing.JFrame {

    ArrayList<BeanProducts> al;
    myTableModel tm;
    public mngProducts() {
        initComponents();
        al = new ArrayList<>();
        tm = new myTableModel();
        Table.setModel(tm);
        setSize(906, 670);
        setLocationRelativeTo(null);
        getcat();
        getproduct();
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
                jcb.addItem(name);
            }
        }
    }
    public void getproduct(){
        String ans=myClient.getproduct();
        StringTokenizer st = new StringTokenizer(ans,"$");
        while(st.hasMoreTokens()){
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ";;");
            while(st2.hasMoreTokens()){
                String name=st2.nextToken();
                String catname=st2.nextToken();
                String description=st2.nextToken();
                int price = Integer.parseInt(st2.nextToken());
                int quantity = Integer.parseInt(st2.nextToken());
                String photo=st2.nextToken();
                al.add(new BeanProducts(name, catname, description, price, quantity, photo));
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HOME = new javax.swing.JButton();
        jlb5 = new javax.swing.JLabel();
        jlb1 = new javax.swing.JLabel();
        jlb2 = new javax.swing.JLabel();
        jbl3 = new javax.swing.JLabel();
        jlb6 = new javax.swing.JLabel();
        jlb4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTextArea();
        jtf = new javax.swing.JTextField();
        jcb = new javax.swing.JComboBox<>();
        pr = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        qty = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        CHOOSE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        HOME.setText("HOME");
        HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HOMEActionPerformed(evt);
            }
        });
        getContentPane().add(HOME);
        HOME.setBounds(20, 10, 140, 40);

        jlb5.setText("QUANTITY");
        getContentPane().add(jlb5);
        jlb5.setBounds(30, 360, 80, 30);

        jlb1.setText("NAME");
        getContentPane().add(jlb1);
        jlb1.setBounds(30, 80, 80, 30);

        jlb2.setText("CATEGORY");
        getContentPane().add(jlb2);
        jlb2.setBounds(30, 140, 80, 30);

        jbl3.setText("DESCRIPTION");
        getContentPane().add(jbl3);
        jbl3.setBounds(30, 200, 80, 30);

        jlb6.setText("PHOTO");
        getContentPane().add(jlb6);
        jlb6.setBounds(30, 440, 80, 30);

        jlb4.setText("PRICE");
        getContentPane().add(jlb4);
        jlb4.setBounds(30, 300, 80, 30);

        jta.setColumns(20);
        jta.setRows(5);
        jScrollPane1.setViewportView(jta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 200, 238, 90);
        getContentPane().add(jtf);
        jtf.setBounds(120, 80, 130, 40);

        jcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        jcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActionPerformed(evt);
            }
        });
        getContentPane().add(jcb);
        jcb.setBounds(120, 142, 130, 40);
        getContentPane().add(pr);
        pr.setBounds(120, 300, 120, 40);

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(110, 370, 40, 30);
        getContentPane().add(qty);
        qty.setBounds(160, 370, 68, 30);

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(240, 370, 40, 30);
        getContentPane().add(photo);
        photo.setBounds(120, 430, 120, 90);

        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        getContentPane().add(ADD);
        ADD.setBounds(260, 570, 100, 30);

        Table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Table);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(420, 30, 456, 406);

        CHOOSE.setText("Choose");
        CHOOSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHOOSEActionPerformed(evt);
            }
        });
        getContentPane().add(CHOOSE);
        CHOOSE.setBounds(250, 420, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int val = 0;
        if(val>=0){
            val++;
        } 
        else{
            val=0;
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private void HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HOMEActionPerformed
        dispose();
        adminHome obj = new adminHome();
        obj.setVisible(true);
    }//GEN-LAST:event_HOMEActionPerformed
        File selectedFile;
    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        String name = jtf.getText();
        String description = jta.getText();
        String price = pr.getText();
        String quantity = qty.getText();
        String cat=(String) jcb.getSelectedItem();
        String ans = myClient.addprod(name, description, price, quantity, selectedFile,cat);
        if (ans.equals("success")) {
            JOptionPane.showMessageDialog(this, "Added Suucesfully");
        } else if (ans.equals("fail")) {
            JOptionPane.showMessageDialog(this, "Already Added");
        } else {
            JOptionPane.showMessageDialog(this, ans);
        }
        tm.fireTableDataChanged();
        al.clear();
        getproduct();
    }//GEN-LAST:event_ADDActionPerformed
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int val=0;
        if(val>=0){
            val--;
        }
        else{
            val=0;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbActionPerformed
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mngProducts().setVisible(true);
            }
        });
    }
class myTableModel extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return al.size();
        }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int j) {
            BeanProducts obj = al.get(i);
            if (j == 0) {
                return obj.name;
            } else if (j == 1) {
                return obj.catname;
            } else if (j == 2) {
                return obj.description;
            } else if (j == 3) {
                return obj.price;
            } else if (j == 4) {
                return obj.quantity;
            } else {
                return obj.photo;
            }    
    }
    @Override
    public String getColumnName(int j){
            String col[] = {"NAME","CATNAME","DESCRIPTION","PRICE","QUANTITY","PHOTO"};
            return col[j];
        }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton CHOOSE;
    private javax.swing.JButton HOME;
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jbl3;
    private javax.swing.JComboBox<String> jcb;
    private javax.swing.JLabel jlb1;
    private javax.swing.JLabel jlb2;
    private javax.swing.JLabel jlb4;
    private javax.swing.JLabel jlb5;
    private javax.swing.JLabel jlb6;
    private javax.swing.JTextArea jta;
    private javax.swing.JTextField jtf;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField pr;
    private javax.swing.JTextField qty;
    // End of variables declaration//GEN-END:variables
}