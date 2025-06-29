
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.table.AbstractTableModel;

public class BillHistory extends javax.swing.JFrame {
    
    ArrayList<Beanbill> al;
    mytablemodel tm;
    
    public BillHistory() {
        initComponents();
        setSize(858, 668);
        setLocationRelativeTo(null);
        al = new ArrayList<>();
        tm = new mytablemodel();
        getData();
        BillTable.setModel(tm);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BillDetailTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BillDetailTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(BillDetailTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 130, 330, 406);

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(BillTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 130, 330, 406);

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 10, 100, 40);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 580, 130, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        GenrateBill obj = new GenrateBill();
        obj.setVisible(true);    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void getData(){
        String ans=myClient.bill();
         StringTokenizer st=new StringTokenizer(ans, "$");
        while(st.hasMoreTokens())   
        {
            StringTokenizer st2=new StringTokenizer(st.nextToken(), ";;");
            while(st2.hasMoreTokens())
            {
                String id=st2.nextToken();
                String number=st2.nextToken();
                String type=st2.nextToken();
                String total=st2.nextToken();
                al.add(new Beanbill(id,number,type,total));
            }
        }
    }
    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillHistory().setVisible(true);
            }
        });
    }
    class mytablemodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return al.size();
            
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int i, int j) {
            Beanbill obj = al.get(i);
            if(j==0){
                return obj.id;
            }
            else if(j==1){
                return obj.number;
            }
            else if(j==2){
                return obj.type;
            }
            else{
                return obj.total;
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BillDetailTable;
    private javax.swing.JTable BillTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
