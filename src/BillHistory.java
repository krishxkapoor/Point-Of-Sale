import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.table.AbstractTableModel;


public class BillHistory extends javax.swing.JFrame {

    ArrayList<Beanbill> al;
    mytablemodel tm;
    mytablemodel1 tm1;
ArrayList<BeanBookingDetail> al1;

    public BillHistory() {
        initComponents();
        setSize(858, 668);
        setLocationRelativeTo(null);
        al = new ArrayList<>();
        tm = new mytablemodel();
        al1 = new ArrayList<>();
        tm1 = new mytablemodel1();
        BillTable.setModel(tm);
        BillDetailTable.setModel(tm1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BillDetailTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        home = new javax.swing.JButton();
        show = new javax.swing.JButton();

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

        home.setText("BACK");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(20, 10, 100, 40);

        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        getContentPane().add(show);
        show.setBounds(330, 580, 130, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        dispose();
        GenrateBill obj = new GenrateBill();
        obj.setVisible(true);    }//GEN-LAST:event_homeActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        int row = BillDetailTable.getSelectedRow();
        int col = 0;
        String val = (String) BillDetailTable.getValueAt(row, col);

        String ans = myClient.bookingdetail(val);
        System.out.println("In getCat function");
        //       System.out.println(ans);
        StringTokenizer st = new StringTokenizer(ans, "$");
        while (st.hasMoreTokens()) {
            System.out.println("**12");
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ";;");
            while (st2.hasMoreTokens()) {
                System.out.println("21");
                String name = st2.nextToken();
                String qty = st2.nextToken();
                String price = st2.nextToken();
                al1.add(new BeanBookingDetail(name, qty, price));
                tm1.fireTableDataChanged();
            

        }        }    }//GEN-LAST:event_showActionPerformed

    public void getData() {
    String ans = myClient.bill();
    StringTokenizer st = new StringTokenizer(ans, "$");
    while (st.hasMoreTokens()) {
        StringTokenizer st2 = new StringTokenizer(st.nextToken(), ";;");
        while (st2.hasMoreTokens()) {
            String id = st2.nextToken();
            String number = st2.nextToken();
            String type = st2.nextToken();
            String total = st2.nextToken();
            al.add(new Beanbill(id, number, type, total));
        }
    }
}

    class mytablemodel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return al.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int j) {
        String col[] = {"ID", "NUMBER", "TYPE", "TOTAL"};
        return col[j];
    }

    @Override
    public Object getValueAt(int i, int j) {
        Beanbill obj = al.get(i);
        if (j == 0) {
            return obj.id;
        } else if (j == 1) {
            return obj.number;
        } else if (j == 2) {
            return obj.type;
        } else if (j == 3) {
            return obj.total;
        } else {
            return null;
        }
    }
}

    class mytablemodel1 extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return al1.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int j) {
        String col[] = {"Product Name", "Quantity", "Price"};
        return col[j];
    }

    @Override
    public Object getValueAt(int i, int j) {
        BeanBookingDetail obj = al1.get(i);
        if (j == 0) {
            return obj.pname;
        } else if (j == 1) {
            return obj.qty;
        } else if (j == 2) {
            return obj.price;
        } else {
            return null;
        }
    }
}
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BillHistory().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BillDetailTable;
    private javax.swing.JTable BillTable;
    private javax.swing.JButton home;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton show;
    // End of variables declaration//GEN-END:variables
}
