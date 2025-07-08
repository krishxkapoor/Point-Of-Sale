
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

public class GenrateBill extends javax.swing.JFrame {

    ArrayList<cart> al;
    mytablemodel tm;

    public GenrateBill() {
        initComponents();
        setSize(926, 644);
        getcat();
        al = new ArrayList<>();
        tm = new mytablemodel();
        jt.setModel(tm);

        setLocationRelativeTo(null);
    }

    public void getproducts(String name) {
        jp2.removeAll();
        int y = 10;
        String ans = myClient.getproductbill(name);
        System.out.println(ans);
        StringTokenizer st = new StringTokenizer(ans, "$");
        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ";;");
            while (st2.hasMoreTokens()) {
                int id = 0;
                String name2 = st2.nextToken();
                String catname = st2.nextToken();
                String description = st2.nextToken();
                String price = st2.nextToken();
                String quantity = st2.nextToken();
                String photo = st2.nextToken();
                JButton bt = new JButton();
                bt.setBounds(5, y, 290, 100);
                y += 120;
                ImageIcon ic = new ImageIcon(photo);
                Image ic1 = ic.getImage().getScaledInstance(bt.getWidth(), bt.getHeight() - 30, Image.SCALE_SMOOTH);
                ImageIcon ic2 = new ImageIcon(ic1);
                bt.setIcon(ic2);
                jp2.add(bt);
                bt.setText(name2);
                bt.setHorizontalTextPosition(SwingConstants.CENTER);
                bt.setVerticalTextPosition(SwingConstants.BOTTOM);
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getcart(id, quantity, price, name2);

                    }
                });

            }
        }
        jp2.repaint();
        jp2.revalidate();
        jp2.setPreferredSize(new Dimension(270, y));
    }

    public void getcat() {
        int y = 10;
        jp1.removeAll();
        String ans = myClient.getcategory();
        System.out.println(ans);
        StringTokenizer st = new StringTokenizer(ans, "$");
        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ";;");
            while (st2.hasMoreTokens()) {
                String name = st2.nextToken();
                String desc = st2.nextToken();
                String photo = st2.nextToken();
                JButton bt = new JButton();
                bt.setBounds(5, y, 290, 100);
                y += 120;
                ImageIcon ic = new ImageIcon(photo);
                Image ic1 = ic.getImage().getScaledInstance(bt.getWidth(), bt.getHeight() - 30, Image.SCALE_SMOOTH);
                ImageIcon ic2 = new ImageIcon(ic1);
                bt.setIcon(ic2);
                jp1.add(bt);
                bt.setText(name);
                bt.setHorizontalTextPosition(SwingConstants.CENTER);
                bt.setVerticalTextPosition(SwingConstants.BOTTOM);
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getproducts(name);
                    }
                });

            }
        }
        jp1.repaint();
        jp1.revalidate();
        jp1.setPreferredSize(new Dimension(270, y));
    }

    int count = 0;
    int grandtotal = 0;

    public void getcart(int id, String qty, String price, String name) {
        int price1 = Integer.parseInt(price);
        String ans = JOptionPane.showInputDialog("Enter Quantity :");
        int qty1 = Integer.parseInt(qty);
        int qty2 = Integer.parseInt(ans);
        int total = 0;

        if (qty1 >= qty2) {
            total += price1 * qty2;
            jl.setText(total + "");
            Global.gtotal = total;
            JOptionPane.showMessageDialog(this, Global.gtotal);
            String ans1 = myClient.addcart(id, name, qty2, price1);
            if (ans1.equals("success")) {
                al.clear();
                String ans3 = myClient.getcart();
                System.out.println(ans3);
                StringTokenizer st3 = new StringTokenizer(ans3, "$");
                while (st3.hasMoreTokens()) {
                    StringTokenizer st4 = new StringTokenizer(st3.nextToken(), ";;");
                    while (st4.hasMoreTokens()) {
                        String name3 = st4.nextToken();
                        int quantity = Integer.parseInt(st4.nextToken());
                        int price3 = Integer.parseInt(st4.nextToken());

//               String quantity = st4.nextToken();
                        al.add(new cart(name3, quantity, price3));

                    }

                    tm.fireTableDataChanged();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jp1 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        DELETE = new javax.swing.JButton();
        jl = new javax.swing.JLabel();
        jb1 = new javax.swing.JButton();
        HOME = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jp1.setBackground(new java.awt.Color(30, 20, 20));

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jp1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 230, 580);

        jp2.setBackground(new java.awt.Color(30, 20, 20));

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        getContentPane().add(jp2);
        jp2.setBounds(280, 44, 230, 570);

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
        jScrollPane2.setBounds(540, 40, 360, 406);

        DELETE.setText("DELETE");
        getContentPane().add(DELETE);
        DELETE.setBounds(580, 540, 140, 60);

        jl.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jl);
        jl.setBounds(640, 480, 170, 30);

        jb1.setText("Generete Bill");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb1);
        jb1.setBounds(750, 540, 140, 60);

        HOME.setText("HOME");
        HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HOMEActionPerformed(evt);
            }
        });
        getContentPane().add(HOME);
        HOME.setBounds(10, 0, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        dispose();
        Bill obj = new Bill();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jb1ActionPerformed

    private void HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HOMEActionPerformed
        dispose();
        adminHome obj = new adminHome();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_HOMEActionPerformed
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
            cart obj = al.get(i);
            if (j == 0) {
                return obj.name;
            } else if (j == 1) {
                return obj.quantity;
            } else {
                return obj.price;
            }
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Name", "Quantity", "Price"};
            return col[j];
        }

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenrateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JButton HOME;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb1;
    private javax.swing.JLabel jl;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JTable jt;
    // End of variables declaration//GEN-END:variables
}
