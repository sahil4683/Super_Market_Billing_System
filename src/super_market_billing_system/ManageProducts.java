package super_market_billing_system;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

public class ManageProducts extends javax.swing.JFrame {

    public ManageProducts() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadTable();
        AutoInc();
        Update.setEnabled(false);
        Delete.setEnabled(false);
    }

    public void AutoInc() {
        try {
            String num = null;
            int no;
            String sql = "select pid from productmaster";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = (rs.getString("pid"));
            }
            no = Integer.parseInt(num) + 1;
            id.setText(String.valueOf(no));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Product ID Not Set From Database", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            id.setText("100");
        }
    }

    void Header() {
        productTable.getColumnModel().getColumn(0).setHeaderValue("Order ID");
        productTable.getColumnModel().getColumn(1).setHeaderValue("Product Name");
        productTable.getColumnModel().getColumn(2).setHeaderValue("Barcode");
        productTable.getColumnModel().getColumn(3).setHeaderValue("U.O.M.");
        productTable.getColumnModel().getColumn(4).setHeaderValue("Purchase Amount");
        productTable.getColumnModel().getColumn(5).setHeaderValue("M.R.P.");
        productTable.getColumnModel().getColumn(6).setHeaderValue("Sell Rate");
        productTable.getColumnModel().getColumn(7).setHeaderValue("Quantity");
        productTable.getColumnModel().getColumn(8).setHeaderValue("Total Amount");
        productTable.getColumnModel().getColumn(9).setHeaderValue("Barcode");
    }

    public void updateTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from productmaster";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            productTable.setModel(DbUtils.resultSetToTableModel(rs));

            Header();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Table Refresh Problem", "INFORMATION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearField() {

        // id.setText("");
        name.setText("");
        bar.setText("");
        qty.setText("");
        uom.setText("");
        pamount.setText("");
        mrp.setText("");
        sell.setText("");
        total.setText("");
    }

    void loadTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from productmaster";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            DefaultTableModel dm;
            dm = (DefaultTableModel) productTable.getModel();
            productTable.setModel(DbUtils.resultSetToTableModel(rs));

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
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        New = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        bar = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        pamount = new javax.swing.JTextField();
        sell = new javax.swing.JTextField();
        uom = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        mrp = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        imgShow = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Products");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 116, 145));
        jPanel1.setFocusCycleRoot(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(51, 0, 102));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add Product Information");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cardboard Box_48px.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close Window_48px.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
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
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)))
        );

        jPanel5.setBackground(new java.awt.Color(0, 116, 145));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel4.setBackground(new java.awt.Color(0, 116, 145));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controls", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

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

        Delete.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Delete.png"))); // NOI18N
        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
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

        Close.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close.png"))); // NOI18N
        Close.setText("CLOSE");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(New, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Update))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear)
                    .addComponent(New))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(Close))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 116, 145));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product ID: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Barcode:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Purchase Amount:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sell Amount:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("M.R.P:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Amount of Sell =");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Unit Of Measurement:");

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 153));
        id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pid}"), id, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pname}"), name, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });

        bar.setEditable(false);
        bar.setBackground(new java.awt.Color(255, 255, 153));
        bar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pbar}"), bar, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        qty.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pqty}"), qty, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });

        pamount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pamount}"), pamount, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        pamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pamountKeyReleased(evt);
            }
        });

        sell.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.psell}"), sell, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        sell.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sellFocusGained(evt);
            }
        });
        sell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sellKeyReleased(evt);
            }
        });

        uom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.puom}"), uom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        total.setEditable(false);
        total.setBackground(new java.awt.Color(255, 255, 153));
        total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.total}"), total, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        mrp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pmrp}"), mrp, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        mrp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mrpFocusLost(evt);
            }
        });
        mrp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mrpKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pamount, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(id)
                    .addComponent(name)
                    .addComponent(bar)
                    .addComponent(qty)
                    .addComponent(mrp)
                    .addComponent(total)
                    .addComponent(uom)
                    .addComponent(sell))
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(mrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.setBackground(new java.awt.Color(0, 116, 145));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel7.setBackground(new java.awt.Color(0, 116, 145));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgShow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.add(imgShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 310, 120));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Barcode: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)))
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
        FileInputStream fis;
        String barr = id.getText() + name.getText();
        if (id.getText().equals("") || name.getText().equals("") || qty.getText().equals("") || uom.getText().equals("") || pamount.getText().equals("") || mrp.getText().equals("") || sell.getText().equals("") || total.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "You have left one or more Fields BLANK", "ALERT!!!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                String sql = "insert into productmaster values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps1 = con.prepareStatement(sql);
                ps1.setString(1, id.getText());
                ps1.setString(2, name.getText());
                ps1.setString(3, barr);
                // ps1.setString(3, bar.getText());
                ps1.setString(4, uom.getText());
                ps1.setString(5, pamount.getText());
                ps1.setString(6, mrp.getText());
                ps1.setString(7, sell.getText());
                ps1.setString(8, qty.getText());
                ps1.setString(9, total.getText());

                //Get 128B Barcode instance from the Factory
                Barcode barcode = BarcodeFactory.createCode128B(id.getText() + " " + name.getText());  //what text display on barcode...
                barcode.setBarHeight(60);
                barcode.setBarWidth(2);
                File file = new File("C:\\Barcodes");
                if (!file.exists()) {
                    if (file.mkdir()) {
                        System.out.println("Directory is created!");
                    } else {
                        System.out.println("Failed to create directory!");
                    }
                }
                String backUpPath = file.getPath();
                File filedst = new File(backUpPath + "\\" + id.getText() + " " + name.getText() + ".png"); //save file with name and extention
                BarcodeImageHandler.savePNG(barcode, filedst); //wriete barcode.

                ///////////////
                fis = new FileInputStream(filedst);
                 ps1.setBinaryStream(10, (InputStream) fis, (int) (filedst.length()));
                //int s = ps1.executeUpdate();
                /////////////
                
                //ps1.execute();
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record saved successfully\nBarcode Generated For Product ' " + name.getText() + " '");
                updateTable();
                AutoInc();
                //Save.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please fill records in proper format");
            }
            clearField();
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        name.setEnabled(false);
        try {
            String value1 = id.getText();
            String value2 = name.getText();
            String value3 = bar.getText();
            String value4 = uom.getText();
            String value5 = pamount.getText();
            String value6 = mrp.getText();
            String value7 = sell.getText();
            String value8 = qty.getText();
            String value9 = total.getText();
            String sql = "update productmaster set pid='" + value1 + "',pname='" + value2 + "',pbar='" + value3 + "',puom='" + value4 + "',pamount='" + value5 + "',pmrp='" + value6 + "',psell='" + value7 + "',pqty='" + value8 + "',total='" + value9 + "' where pid='" + value1 + "' ";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
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
        ManageProducts s = new ManageProducts();
        s.setVisible(true);
        this.dispose();
        Save.setEnabled(true);
    }//GEN-LAST:event_NewActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int p = JOptionPane.showConfirmDialog(this, "Do you really want to delete this data ?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from productmaster where pid=?";
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                PreparedStatement ps2 = con.prepareStatement(sql);
                String c = id.getText();
                ps2.setString(1, c);
                ps2.execute();
                JOptionPane.showMessageDialog(this, "Deleted successfully");
                clearField();
                updateTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            int row = productTable.getSelectedRow();
            String table_click = (productTable.getModel().getValueAt(row, 0).toString());
            String sql = "select * from productmaster where pid='" + table_click + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next()) {
                String add1 = rs.getString("pid");
                id.setText(add1);
                String add2 = rs.getString("pname");
                name.setText(add2);
                String add3 = rs.getString("pbar");
                bar.setText(add3);
                String add4 = rs.getString("puom");
                uom.setText(add4);
                String add5 = rs.getString("pamount");
                pamount.setText(add5);
                String add6 = rs.getString("pmrp");
                mrp.setText(add6);
                String add7 = rs.getString("psell");
                sell.setText(add7);
                String add8 = rs.getString("pqty");
                qty.setText(add8);
                String add9 = rs.getString("total");
                total.setText(add9);

                byte[] img = rs.getBytes("image");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(imgShow.getWidth(), imgShow.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                imgShow.setIcon(newImage);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        Save.setEnabled(false);
        name.setEnabled(false);
        Update.setEnabled(true);
        Delete.setEnabled(true);
    }//GEN-LAST:event_productTableMouseClicked

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

    private void mrpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mrpKeyReleased
        String pa = mrp.getText().trim();
        char[] ch = pa.toCharArray();
        int j = 0;
        for (int i = 0; i < pa.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            mrp.setText("");
        }
    }//GEN-LAST:event_mrpKeyReleased

    private void sellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellKeyReleased
        String pa = sell.getText().trim();
        char[] ch = pa.toCharArray();
        int j = 0;
        for (int i = 0; i < pa.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            sell.setText("");
        }
    }//GEN-LAST:event_sellKeyReleased

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        int y = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?", "Confirm", 0, 2);
        if (y == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void mrpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mrpFocusLost
        int a = Integer.parseInt(pamount.getText());
        int b = Integer.parseInt(sell.getText());
        if (a >= b) {
            JOptionPane.showMessageDialog(this, "Sell Amount is Less Than Puechase Amount ");
            sell.setText("");
            mrp.setText("");
        }
    }//GEN-LAST:event_mrpFocusLost

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        String barr = id.getText() + name.getText();
        bar.setText(barr);
    }//GEN-LAST:event_nameFocusLost

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

    private void sellFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellFocusGained
        int a = Integer.parseInt(pamount.getText());
        int b = Integer.parseInt(sell.getText());
        if (a >= b) {
            JOptionPane.showMessageDialog(this, "Sell Amount is Less Than Puechase Amount ");
            sell.setText("");
            mrp.setText("");
        }
    }//GEN-LAST:event_sellFocusGained

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
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProducts().setVisible(true);
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
    private javax.swing.JTextField bar;
    private javax.swing.JTextField id;
    private javax.swing.JLabel imgShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mrp;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pamount;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField sell;
    private javax.swing.JTextField total;
    private javax.swing.JTextField uom;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
