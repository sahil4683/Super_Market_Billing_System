package super_market_billing_system;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MDIHome extends javax.swing.JFrame {

    public MDIHome() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        showDate();
        loadSell();
    }
    
     void loadSell() {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select SUM(totalcash) AS Total from billmaster where datet='"+setdate.getText()+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next())
            {
            sell.setText("Today's Sell: "+rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    public void showDate() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        setdate.setText(year + "-" + (month + 1) + "-" + day);
    }

    public MDIHome(String mgs) {
       initComponents();
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       message.setText("Welcome: "+mgs);
       showDate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dsk = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        message = new javax.swing.JMenu();
        setdate = new javax.swing.JMenu();
        sell = new javax.swing.JMenu();
        Master = new javax.swing.JMenu();
        pm = new javax.swing.JMenuItem();
        sm = new javax.swing.JMenuItem();
        om = new javax.swing.JMenuItem();
        em = new javax.swing.JMenuItem();
        bill = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        billrecords = new javax.swing.JMenuItem();
        attend = new javax.swing.JMenu();
        attendp = new javax.swing.JMenuItem();
        attendr = new javax.swing.JMenuItem();
        qreport = new javax.swing.JMenuItem();
        Report = new javax.swing.JMenu();
        prp = new javax.swing.JMenuItem();
        srp = new javax.swing.JMenuItem();
        orp = new javax.swing.JMenuItem();
        erp = new javax.swing.JMenuItem();
        qrp = new javax.swing.JMenuItem();
        srrp = new javax.swing.JMenuItem();
        about = new javax.swing.JMenu();
        aboutus = new javax.swing.JMenuItem();
        contact = new javax.swing.JMenuItem();
        Settings = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        outl = new javax.swing.JMenuItem();
        bk = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setLocationByPlatform(true);
        setUndecorated(true);

        dsk.setDoubleBuffered(true);
        dsk.setFocusTraversalPolicyProvider(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/wallp.jpg"))); // NOI18N
        jLabel1.setFocusCycleRoot(true);
        jLabel1.setFocusTraversalPolicyProvider(true);
        jLabel1.setOpaque(true);

        dsk.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dskLayout = new javax.swing.GroupLayout(dsk);
        dsk.setLayout(dskLayout);
        dskLayout.setHorizontalGroup(
            dskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dskLayout.setVerticalGroup(
            dskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE)
        );

        menuBar.setBackground(new java.awt.Color(0, 0, 0));
        menuBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));
        menuBar.setName(""); // NOI18N

        message.setBackground(new java.awt.Color(0, 0, 0));
        message.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        message.setForeground(new java.awt.Color(153, 153, 153));
        message.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        menuBar.add(message);

        setdate.setBackground(new java.awt.Color(0, 0, 0));
        setdate.setForeground(new java.awt.Color(153, 153, 153));
        setdate.setText("date");
        setdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        menuBar.add(setdate);

        sell.setBackground(new java.awt.Color(0, 0, 0));
        sell.setForeground(new java.awt.Color(102, 153, 0));
        sell.setText("Sell");
        sell.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        menuBar.add(sell);

        Master.setBackground(new java.awt.Color(0, 0, 0));
        Master.setForeground(new java.awt.Color(153, 153, 153));
        Master.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Master_48px.png"))); // NOI18N
        Master.setText("Master");
        Master.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        pm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Product_48px.png"))); // NOI18N
        pm.setText("Product Master");
        pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmActionPerformed(evt);
            }
        });
        Master.add(pm);

        sm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Supplier.png"))); // NOI18N
        sm.setText("Supplier Master");
        sm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smActionPerformed(evt);
            }
        });
        Master.add(sm);

        om.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Truck_48px.png"))); // NOI18N
        om.setText("Order Master");
        om.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omActionPerformed(evt);
            }
        });
        Master.add(om);

        em.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/AccountLogo.png"))); // NOI18N
        em.setText("Employee Master");
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        Master.add(em);

        menuBar.add(Master);

        bill.setBackground(new java.awt.Color(0, 0, 0));
        bill.setForeground(new java.awt.Color(153, 153, 153));
        bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Bill_48px.png"))); // NOI18N
        bill.setText("Bill");
        bill.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Calculator_48px.png"))); // NOI18N
        jMenuItem11.setText("Bill Generator");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        bill.add(jMenuItem11);

        billrecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Purchase Order_48px.png"))); // NOI18N
        billrecords.setText("Bill Records");
        billrecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billrecordsActionPerformed(evt);
            }
        });
        bill.add(billrecords);

        menuBar.add(bill);

        attend.setForeground(new java.awt.Color(153, 153, 153));
        attend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Calendar_48px.png"))); // NOI18N
        attend.setText("Attendance");
        attend.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        attendp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/To Do_48px_1.png"))); // NOI18N
        attendp.setText("Attend");
        attendp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendpActionPerformed(evt);
            }
        });
        attend.add(attendp);

        attendr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Report.png"))); // NOI18N
        attendr.setText("Attend Reports");
        attendr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendrActionPerformed(evt);
            }
        });
        attend.add(attendr);

        qreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Questions_48px.png"))); // NOI18N
        qreport.setText("Report Query");
        qreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qreportActionPerformed(evt);
            }
        });
        attend.add(qreport);

        menuBar.add(attend);

        Report.setBackground(new java.awt.Color(0, 0, 0));
        Report.setForeground(new java.awt.Color(153, 153, 153));
        Report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Report.png"))); // NOI18N
        Report.setText("Reports");
        Report.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        prp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Product_48px.png"))); // NOI18N
        prp.setText("Product Report");
        prp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prpActionPerformed(evt);
            }
        });
        Report.add(prp);

        srp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Supplier.png"))); // NOI18N
        srp.setText("Supplier Report");
        srp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srpActionPerformed(evt);
            }
        });
        Report.add(srp);

        orp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Truck_48px.png"))); // NOI18N
        orp.setText("Order Report");
        orp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orpActionPerformed(evt);
            }
        });
        Report.add(orp);

        erp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/AccountLogo.png"))); // NOI18N
        erp.setText("Employee Report");
        erp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                erpActionPerformed(evt);
            }
        });
        Report.add(erp);

        qrp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Questions_48px.png"))); // NOI18N
        qrp.setText("Query Report");
        qrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrpActionPerformed(evt);
            }
        });
        Report.add(qrp);

        srrp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Coins_48px.png"))); // NOI18N
        srrp.setText("Sale Report");
        srrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srrpActionPerformed(evt);
            }
        });
        Report.add(srrp);

        menuBar.add(Report);

        about.setForeground(new java.awt.Color(153, 153, 153));
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Info_48px.png"))); // NOI18N
        about.setText("Help");
        about.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        aboutus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/About_48px.png"))); // NOI18N
        aboutus.setText("AboutUS");
        aboutus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutusActionPerformed(evt);
            }
        });
        about.add(aboutus);

        contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Contacts_48px.png"))); // NOI18N
        contact.setText("Contact");
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        about.add(contact);

        menuBar.add(about);

        Settings.setBackground(new java.awt.Color(0, 0, 0));
        Settings.setForeground(new java.awt.Color(153, 153, 153));
        Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Settings_48px.png"))); // NOI18N
        Settings.setText("Settings");
        Settings.setToolTipText("");
        Settings.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close Window_48px.png"))); // NOI18N
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        Settings.add(Exit);

        outl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Exit_48px.png"))); // NOI18N
        outl.setText("LogOut");
        outl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outlActionPerformed(evt);
            }
        });
        Settings.add(outl);

        bk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Data Backup_40px.png"))); // NOI18N
        bk.setText("Backup and Restore");
        bk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkActionPerformed(evt);
            }
        });
        Settings.add(bk);

        menuBar.add(Settings);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsk)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsk)
        );

        dsk.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        int e = javax.swing.JOptionPane.showConfirmDialog(this, "Do you really want to Exit ? ", "Confirm", 0, 0);
        if (e == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void bkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkActionPerformed
        Backup bk = new Backup();
        bk.setVisible(true);
    }//GEN-LAST:event_bkActionPerformed

    private void pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmActionPerformed
        ManageProducts mp = new ManageProducts();
        mp.setVisible(true);
    }//GEN-LAST:event_pmActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        ManageEmployee me = new ManageEmployee();
        me.setVisible(true);
    }//GEN-LAST:event_emActionPerformed

    private void smActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smActionPerformed
        ManageSupplier ms = new ManageSupplier();
        ms.setVisible(true);
    }//GEN-LAST:event_smActionPerformed

    private void prpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prpActionPerformed
        ProductReport pr = new ProductReport();
        pr.setVisible(true);
    }//GEN-LAST:event_prpActionPerformed

    private void srpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srpActionPerformed
        SupplierReport sr = new SupplierReport();
        sr.setVisible(true);
    }//GEN-LAST:event_srpActionPerformed

    private void orpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orpActionPerformed
        OrderReport or = new OrderReport();
        or.setVisible(true);
    }//GEN-LAST:event_orpActionPerformed

    private void erpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_erpActionPerformed
        EmployeeReport er = new EmployeeReport();
        er.setVisible(true);
    }//GEN-LAST:event_erpActionPerformed

    private void attendrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendrActionPerformed
        EmpAttendReport eap=new EmpAttendReport();
        eap.setVisible(true);
    }//GEN-LAST:event_attendrActionPerformed

    private void attendpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendpActionPerformed
        EmployeeAttend ea=new EmployeeAttend();
        ea.setVisible(true);
    }//GEN-LAST:event_attendpActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        BillGenerator bg=new BillGenerator();
        bg.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void aboutusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutusActionPerformed
         AboutUS us=new AboutUS();
        us.setVisible(true);
    }//GEN-LAST:event_aboutusActionPerformed

    private void omActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omActionPerformed
        ManageOrders mo=new ManageOrders();
        mo.setVisible(true);
    }//GEN-LAST:event_omActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        Contact c=new Contact();
        c.setVisible(true);
    }//GEN-LAST:event_contactActionPerformed

    private void outlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outlActionPerformed
        Login l =new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_outlActionPerformed

    private void billrecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billrecordsActionPerformed
        BillReport br=new BillReport();
        br.setVisible(true);
    }//GEN-LAST:event_billrecordsActionPerformed

    private void qreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qreportActionPerformed
        QReport qr=new QReport();
        qr.setVisible(true);
    }//GEN-LAST:event_qreportActionPerformed

    private void qrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrpActionPerformed
        QReportEmp qrm=new QReportEmp();
        qrm.setVisible(true);
    }//GEN-LAST:event_qrpActionPerformed

    private void srrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srrpActionPerformed
        SellReport sr=new SellReport();
        sr.setVisible(true);
    }//GEN-LAST:event_srrpActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    javax.swing.JMenu Master;
    javax.swing.JMenu Report;
    private javax.swing.JMenu Settings;
    private javax.swing.JMenu about;
    private javax.swing.JMenuItem aboutus;
    private javax.swing.JMenu attend;
    private javax.swing.JMenuItem attendp;
    javax.swing.JMenuItem attendr;
    javax.swing.JMenu bill;
    private javax.swing.JMenuItem billrecords;
    javax.swing.JMenuItem bk;
    private javax.swing.JMenuItem contact;
    private javax.swing.JDesktopPane dsk;
    javax.swing.JMenuItem em;
    private javax.swing.JMenuItem erp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu message;
    javax.swing.JMenuItem om;
    private javax.swing.JMenuItem orp;
    private javax.swing.JMenuItem outl;
    private javax.swing.JMenuItem pm;
    private javax.swing.JMenuItem prp;
    private javax.swing.JMenuItem qreport;
    private javax.swing.JMenuItem qrp;
    javax.swing.JMenu sell;
    private javax.swing.JMenu setdate;
    javax.swing.JMenuItem sm;
    private javax.swing.JMenuItem srp;
    private javax.swing.JMenuItem srrp;
    // End of variables declaration//GEN-END:variables

}
