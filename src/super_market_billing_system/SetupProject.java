package super_market_billing_system;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SetupProject extends javax.swing.JFrame {

    public SetupProject() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        db = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tb = new javax.swing.JButton();
        Close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(51, 0, 102));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Install Database And Tables");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Settings 3_96px_1.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close Window_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setBackground(new java.awt.Color(51, 0, 102));
        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Create Tables:");

        db.setBackground(java.awt.Color.blue);
        db.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        db.setForeground(new java.awt.Color(255, 255, 255));
        db.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Data Configuration_96px.png"))); // NOI18N
        db.setText("Install");
        db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(51, 0, 102));
        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Create Database: ");

        tb.setBackground(new java.awt.Color(0, 0, 255));
        tb.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        tb.setForeground(new java.awt.Color(255, 255, 255));
        tb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Table_96px.png"))); // NOI18N
        tb.setText("Install");
        tb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbActionPerformed(evt);
            }
        });

        Close.setBackground(new java.awt.Color(0, 0, 255));
        Close.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        Close.setForeground(new java.awt.Color(255, 255, 255));
        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancel_96px.png"))); // NOI18N
        Close.setText("CLOSE");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tb, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addComponent(db, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(db, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tb, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(69, 69, 69)
                .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int y = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?", "Confirm", 0, 2);
        if (y == 0) {
            System.exit(0);
                   }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbActionPerformed
        // Defines the JDBC URL.
        String url = "jdbc:mysql://localhost:3306";
        // Defines username and password to connect to database server.
        String username = "root";
        String password = "root";
        // SQL command to create a database in MySQL.
        String sql = "CREATE DATABASE IF NOT EXISTS SuperMarket_DB";
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            JOptionPane.showMessageDialog(this, "Database Created Successfully ");
            db.setBackground(Color.GREEN);
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "MySQL Server Not Installed !", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            db.setBackground(Color.RED);
        }
    }//GEN-LAST:event_dbActionPerformed

    private void tbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbActionPerformed
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            Statement stm = c.createStatement();

            PreparedStatement ps1 = c.prepareStatement("CREATE TABLE  IF NOT EXISTS `billmaster` (\n"
                    + "  `cmemo` int(11) NOT NULL,\n"
                    + "  `datet` date DEFAULT NULL,\n"
                    + "  `cname` varchar(45) DEFAULT NULL,\n"
                    + "  `pid` int(11) DEFAULT NULL,\n"
                    + "  `pname` varchar(45) DEFAULT NULL,\n"
                    + "  `pbar` varchar(45) DEFAULT NULL,\n"
                    + "  `pqty` int(11) DEFAULT NULL,\n"
                    + "  `pmrp` decimal(10,0) DEFAULT NULL,\n"
                    + "  `psell` decimal(10,0) DEFAULT NULL,\n"
                    + "  `ptotal` decimal(10,0) DEFAULT NULL,\n"
                    + "  `tba` decimal(10,0) DEFAULT NULL,\n"
                    + "  `gst` int(11) DEFAULT NULL,\n"
                    + "  `discount` int(11) DEFAULT NULL,\n"
                    + "  `totalcash` decimal(10,0) DEFAULT NULL\n"
                    + ") ");
            ps1.executeUpdate();

            PreparedStatement ps2 = c.prepareStatement("CREATE TABLE  IF NOT EXISTS `employeeattend` (\n"
                    + "  `eid` int(11) NOT NULL,\n"
                    + "  `ename` varchar(20) NOT NULL,\n"
                    + "  `tdate` date NOT NULL,\n"
                    + "  `status` varchar(20) NOT NULL\n"
                    + ") ");
            ps2.executeUpdate();

            PreparedStatement ps3 = c.prepareStatement("CREATE TABLE  IF NOT EXISTS `employeemaster` (\n"
                    + "  `eid` int(11) NOT NULL,\n"
                    + "  `ename` varchar(45) NOT NULL,\n"
                    + "  `emob` bigint(10) NOT NULL,\n"
                    + "  `eaddr` varchar(45) NOT NULL,\n"
                    + "  `erdate` date NOT NULL,\n"
                    + "  `edob` date DEFAULT NULL,\n"
                    + "  `eaadhar` varchar(12) NOT NULL,\n"
                    + "  `desig` varchar(45) DEFAULT NULL,\n"
                    + "  `esalary` int(11) DEFAULT NULL,\n"
                    + "  `epass` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`eid`)\n"
                    + ") ");
            ps3.executeUpdate();

            PreparedStatement ps4 = c.prepareStatement("CREATE TABLE  IF NOT EXISTS `ordermaster` (\n"
                    + "  `oid` int(11) NOT NULL,\n"
                    + "  `sname` varchar(45) NOT NULL,\n"
                    + "  `pname` varchar(45) NOT NULL,\n"
                    + "  `qty` int(11) NOT NULL,\n"
                    + "  `pdate` varchar(45) NOT NULL,\n"
                    + "  `pamount` float NOT NULL,\n"
                    + "  `total` float NOT NULL,\n"
                    + "  PRIMARY KEY (`oid`)\n"
                    + ") ");
            ps4.executeUpdate();

            PreparedStatement ps5 = c.prepareStatement("CREATE TABLE  IF NOT EXISTS `productmaster` (\n"
                    + "  `pid` int(11) NOT NULL,\n"
                    + "  `pname` varchar(45) NOT NULL,\n"
                    + "  `pbar` varchar(45) DEFAULT NULL,\n"
                    + "  `puom` varchar(20) DEFAULT NULL,\n"
                    + "  `pamount` decimal(10,0) NOT NULL,\n"
                    + "  `pmrp` decimal(10,0) NOT NULL,\n"
                    + "  `psell` decimal(10,0) NOT NULL,\n"
                    + "  `pqty` int(11) NOT NULL,\n"
                    + "  `total` decimal(10,0) NOT NULL,\n"
                    + "  `image` longblob NOT NULL,\n"
                    + "  PRIMARY KEY (`pid`)\n"
                    + ") ");
            ps5.executeUpdate();

            PreparedStatement ps6 = c.prepareStatement("CREATE TABLE  IF NOT EXISTS `qreport` (\n"
                    + "  `empname` varchar(10) NOT NULL,\n"
                    + "  `query` varchar(45) NOT NULL\n"
                    + ")");
            ps6.executeUpdate();

            PreparedStatement ps7 = c.prepareStatement("CREATE TABLE  IF NOT EXISTS `suppliermaster` (\n"
                    + "  `sid` int(11) NOT NULL,\n"
                    + "  `sname` varchar(45) NOT NULL,\n"
                    + "  `smob` bigint(10) NOT NULL,\n"
                    + "  `saddr` varchar(45) NOT NULL,\n"
                    + "  `stype` varchar(45) NOT NULL,\n"
                    + "  `scomp` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`sid`)\n"
                    + ") ");
            ps7.executeUpdate();

            tb.setBackground(Color.GREEN);
            JOptionPane.showMessageDialog(this, "Tables Created Successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            c.close();
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "MySQL Server Not Installed !", "EXCEPTION", JOptionPane.ERROR_MESSAGE);
            tb.setBackground(Color.red);
        }
    }//GEN-LAST:event_tbActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_CloseActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SetupProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetupProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetupProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetupProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JButton db;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton tb;
    // End of variables declaration//GEN-END:variables
}
