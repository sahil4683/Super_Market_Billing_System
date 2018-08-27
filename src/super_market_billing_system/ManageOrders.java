package super_market_billing_system;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ManageOrders extends javax.swing.JFrame {

    public ManageOrders() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadTable();
        AutoInc();
        showDate();
        Update.setEnabled(false);
        Delete.setEnabled(false);

        //Add Supplier Name Values in JCombobox
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select sname from suppliermaster");
            while (rs.next()) {
                sname.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Employee Data Does Not Exit", "INFORMATION", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void AutoInc() {
        //Auto Increment ID
        try {
            String num = null;
            int no;
            String sql = "select oid from ordermaster";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = (rs.getString("oid"));
            }
            no = Integer.parseInt(num) + 1;
            id.setText(String.valueOf(no));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Order ID Not Set From Database", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            id.setText("1000");
        }
    }

    void Header() {
        orderTable.getColumnModel().getColumn(0).setHeaderValue("Order ID");
        orderTable.getColumnModel().getColumn(1).setHeaderValue("Supplier Name");
        orderTable.getColumnModel().getColumn(2).setHeaderValue("Product Name");
        orderTable.getColumnModel().getColumn(3).setHeaderValue("Quantity");
        orderTable.getColumnModel().getColumn(4).setHeaderValue("Purchase Date");
        orderTable.getColumnModel().getColumn(5).setHeaderValue("Purchase Amount");
        orderTable.getColumnModel().getColumn(6).setHeaderValue("Total");
    }

    public void updateTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from ordermaster";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            orderTable.setModel(DbUtils.resultSetToTableModel(rs));

            Header();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Table Refresh Problem", "INFORMATION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearField() {
        pname.setText("");
        sname.setSelectedIndex(0);
        qty.setText("");
        pamount.setText("");
        total.setText("");
        pdate.setDate(null);
    }
    
    public void showDate() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        //datelable.setText(year + "-" + (month + 1) + "-" + day);
        orderbilldate.setText(year + "-" + (month + 1) + "-" + day);
    }

    void loadTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from ordermaster";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            DefaultTableModel dm;
            dm = (DefaultTableModel) orderTable.getModel();
            orderTable.setModel(DbUtils.resultSetToTableModel(rs));

            Header();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        pname = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        pamount = new javax.swing.JTextField();
        sname = new javax.swing.JComboBox<>();
        pdate = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        New = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        billPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        orderbillinvoice = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        orderbilldate = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        orderbillsupplier = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        orderbillproduct = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        orderbillamount = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        orderbillqty = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        orderbilltotal = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Orders");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 116, 145));
        jPanel1.setFocusCycleRoot(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(51, 0, 102));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add Orders Information");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Truck_48px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close Window_48px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 116, 145));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel3.setBackground(new java.awt.Color(0, 116, 145));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Invoice No:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Purchase Date:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Purchase Amount:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Amount =");

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 153));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.oid}"), id, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pname}"), pname, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.qty}"), qty, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });

        total.setEditable(false);
        total.setBackground(new java.awt.Color(255, 255, 153));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.total}"), total, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pamount}"), pamount, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        pamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pamountKeyReleased(evt);
            }
        });

        sname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>" }));

        pdate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qty, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(total)
                            .addComponent(pamount))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pname)
                            .addComponent(sname, 0, 191, Short.MAX_VALUE)
                            .addComponent(id)
                            .addComponent(pdate, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(pdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 116, 145));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contols", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        Save.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save.png"))); // NOI18N
        Save.setText("SAVE");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Update.png"))); // NOI18N
        Update.setText("UPDATE");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Clear.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Clear.png"))); // NOI18N
        Clear.setText("CLEAR");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        New.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/New.png"))); // NOI18N
        New.setText("NEW");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Delete.png"))); // NOI18N
        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Close.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close.png"))); // NOI18N
        Close.setText("CLOSE");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Print.png"))); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Save, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Update))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear)
                    .addComponent(New))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Close)
                    .addComponent(Delete))
                .addGap(18, 18, 18)
                .addComponent(print)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 116, 145));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1289, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        billPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 48)); // NOI18N
        jLabel12.setText("***SuperMarket***");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel13.setText("AT: ALIBAG-RAIGHAD");

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel14.setText("PINCODE: 402201");

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel15.setText("TEL: (02141) 282589");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel28.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel28.setText("Invoice No:");

        orderbillinvoice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        orderbillinvoice.setText("------");

        jLabel29.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel29.setText("Date: ");

        orderbilldate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        orderbilldate.setText("------------");

        jLabel30.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel30.setText("To :-");

        orderbillsupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        orderbillsupplier.setText("------------");

        jLabel31.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel31.setText("Product Name: ");

        orderbillproduct.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        orderbillproduct.setText("------------");

        jLabel32.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel32.setText("Purchase Amount:");

        orderbillamount.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        orderbillamount.setText("------------");

        jLabel33.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel33.setText("Quantity:");

        orderbillqty.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        orderbillqty.setText("------------");

        jLabel34.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel34.setText("Total Amount: ");

        orderbilltotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        orderbilltotal.setText("------------");

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel35.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel35.setText("For SuperMarket Owner");

        jLabel36.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel36.setText("Signature");

        jLabel37.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel37.setText("For Supplier");

        jLabel38.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel38.setText("Signature");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel37)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(142, 142, 142)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderbillinvoice)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderbilldate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderbillsupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderbillproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderbillamount, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderbillqty, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderbilltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(billPanelLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addGroup(billPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(orderbillinvoice)
                    .addComponent(jLabel29)
                    .addComponent(orderbilldate)
                    .addComponent(jLabel30)
                    .addComponent(orderbillsupplier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(orderbillproduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(orderbillamount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(orderbillqty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(orderbilltotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel38))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(billPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if (id.getText().equals("") || pname.getText().equals("") || qty.getText().equals("") || pdate.getDate().equals("") || pamount.getText().equals("") || total.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "You have left one or more Fields BLANK", "ALERT!!!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String q = sname.getSelectedItem().toString();
            if (q.equals("<Select>")) {
                JOptionPane.showMessageDialog(this, "Select Type First !");
            } else {
                try {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String datep = df.format(pdate.getDate());
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                    String sql = "insert into ordermaster values (?,?,?,?,?,?,?)";
                    PreparedStatement ps1 = con.prepareStatement(sql);
                    ps1.setString(1, id.getText());
                    ps1.setString(2, (String) sname.getSelectedItem());
                    ps1.setString(3, pname.getText());
                    ps1.setString(4, qty.getText());
                    ps1.setString(5, datep);
                    ps1.setString(6, pamount.getText());
                    ps1.setString(7, total.getText());
                    ps1.execute();

                    orderbillinvoice.setText(id.getText());
                    //orderbilldate.setText(pdate.getDate().toString());
                    orderbillsupplier.setText(sname.getSelectedItem().toString());
                    orderbillproduct.setText(pname.getText());
                    orderbillamount.setText(pamount.getText());
                    orderbillqty.setText(qty.getText());
                    orderbilltotal.setText(total.getText());

                    JOptionPane.showMessageDialog(this, "Record saved successfully");
                    updateTable();
                    AutoInc();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please fill records in proper format");
                }
                clearField();
            }
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String datep = df.format(pdate.getDate());
            String value1 = id.getText();
            String value2 = (String) sname.getSelectedItem();
            String value3 = pname.getText();
            String value4 = qty.getText();
            String value5 = datep;
            String value6 = pamount.getText();
            String value7 = total.getText();
            String sql = "update ordermaster set oid='" + value1 + "',sname='" + value2 + "',pname='" + value3 + "',qty='" + value4 + "',pdate='" + value5 + "',pamount='" + value6 + "',total='" + value7 + "' where oid='" + value1 + "' ";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();

            orderbillinvoice.setText(id.getText());
            //orderbilldate.setText(pdate.getDate().toString());
            orderbillsupplier.setText(sname.getSelectedItem().toString());
            orderbillproduct.setText(pname.getText());
            orderbillamount.setText(pamount.getText());
            orderbillqty.setText(qty.getText());
            orderbilltotal.setText(total.getText());

            JOptionPane.showMessageDialog(this, "Record updated successfully");
            updateTable();
            AutoInc();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        clearField();
        Delete.setEnabled(false);
    }//GEN-LAST:event_UpdateActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearField();
    }//GEN-LAST:event_ClearActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        ManageOrders s = new ManageOrders();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NewActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int p = JOptionPane.showConfirmDialog(this, "Do you really want to delete this data ?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from ordermaster where oid=?";
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                PreparedStatement ps2 = con.prepareStatement(sql);
                String c = id.getText();
                ps2.setString(1, c);
                ps2.execute();
                JOptionPane.showMessageDialog(this, "Deleted successfully");
                updateTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
        clearField();
    }//GEN-LAST:event_DeleteActionPerformed

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        String sl = qty.getText().trim();
        char[] ch = sl.toCharArray();
        int j = 0;
        for (int i = 0; i < sl.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            qty.setText("");
        }
        int n1, n2, res;
        n1 = Integer.parseInt(pamount.getText());
        n2 = Integer.parseInt(qty.getText());
        res = (n1 * n2);
        total.setText(String.valueOf(res));
    }//GEN-LAST:event_qtyKeyReleased

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            int row = orderTable.getSelectedRow();
            String table_click = (orderTable.getModel().getValueAt(row, 0).toString());
            String sql = "select * from ordermaster where oid='" + table_click + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next()) {
                String add1 = rs.getString("oid");
                id.setText(add1);
                String add2 = rs.getString("sname");
                sname.setSelectedItem(add2);
                String add3 = rs.getString("pname");
                pname.setText(add3);
                String add4 = rs.getString("qty");
                qty.setText(add4);
                Date add5 = rs.getDate("pdate");
                pdate.setDate(add5);
                String add6 = rs.getString("pamount");
                pamount.setText(add6);
                String add7 = rs.getString("total");
                total.setText(add7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        Save.setEnabled(false);
        Update.setEnabled(true);
        Delete.setEnabled(true);
    }//GEN-LAST:event_orderTableMouseClicked

    private void pamountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pamountKeyReleased
        String pa = pamount.getText().trim();
        char[] ch = pa.toCharArray();
        int j = 0;
        for (int i = 0; i < pa.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            pamount.setText("");
        }
    }//GEN-LAST:event_pamountKeyReleased

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int y = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?", "Confirm", 0, 2);
        if (y == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        Toolkit tkp=billPanel.getToolkit();
        PrintJob pjb=tkp.getPrintJob(this, null, null);
        Graphics g=pjb.getGraphics();
        billPanel.print(g);
        g.dispose();
        pjb.end();
    }//GEN-LAST:event_printActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(ManageOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Close;
    private javax.swing.JButton Delete;
    private javax.swing.JButton New;
    private javax.swing.JButton Save;
    private javax.swing.JButton Update;
    private javax.swing.JPanel billPanel;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable orderTable;
    private javax.swing.JLabel orderbillamount;
    private javax.swing.JLabel orderbilldate;
    private javax.swing.JLabel orderbillinvoice;
    private javax.swing.JLabel orderbillproduct;
    private javax.swing.JLabel orderbillqty;
    private javax.swing.JLabel orderbillsupplier;
    private javax.swing.JLabel orderbilltotal;
    private javax.swing.JTextField pamount;
    private com.toedter.calendar.JDateChooser pdate;
    private javax.swing.JTextField pname;
    private javax.swing.JButton print;
    private javax.swing.JTextField qty;
    private javax.swing.JComboBox<String> sname;
    private javax.swing.JTextField total;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
