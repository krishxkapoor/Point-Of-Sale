
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

public class GenrateBill extends javax.swing.JFrame {

    ArrayList<BeanCategories> al;
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

    public void getcat() {
        int y = 10;
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

    public void getproducts(String name) {
        jp2.removeAll();
        int y = 10;
        String ans = myClient.getproductbill(name);
        System.out.println(ans);
        StringTokenizer st = new StringTokenizer(ans, "$");
        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ";;");
            while (st2.hasMoreTokens()) {
                String name2 = st2.nextToken();
                String catname = st2.nextToken();
                String description = st2.nextToken();
                int price = Integer.parseInt(st2.nextToken());
                int quantity = Integer.parseInt(st2.nextToken());
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

                    }
                });

            }
        }
        jp2.repaint();
        jp2.revalidate();
        jp2.setPreferredSize(new Dimension(270, y));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jp1 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        jb1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();

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
        jScrollPane2.setBounds(540, 50, 360, 406);

        jb1.setText("Genrate Bill");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb1);
        jb1.setBounds(760, 500, 140, 60);

        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 10, 110, 23);

        DELETE.setText("DELETE");
        getContentPane().add(DELETE);
        DELETE.setBounds(580, 500, 140, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        adminHome obj = new adminHome();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        dispose();
        Bill obj = new Bill();
        obj.setVisible(true);    }//GEN-LAST:event_jb1ActionPerformed
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
        public String getColumnName(int j) {
            String col[] = {"name", "description", "photo"};
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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb1;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JTable jt;
    // End of variables declaration//GEN-END:variables
}
