package super_market_billing_system;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ManageSupplier extends javax.swing.JFrame {

    public ManageSupplier() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadTable();
        AutoInc();
        Updateb.setEnabled(false);
        Delete.setEnabled(false);
    }

    public void AutoInc() {
        try {
            String num = null;
            int no;
            String sql = "select sid from suppliermaster";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = (rs.getString("sid"));
            }
            no = Integer.parseInt(num) + 1;
            id.setText(String.valueOf(no));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Supplier ID Not Set From Database", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            id.setText("10");
        }
    }

    void Header() {
        supTable.getColumnModel().getColumn(0).setHeaderValue("Supplier ID");
        supTable.getColumnModel().getColumn(1).setHeaderValue("Supplier Name");
        supTable.getColumnModel().getColumn(2).setHeaderValue("Mobile NO.");
        supTable.getColumnModel().getColumn(3).setHeaderValue("Address");
        supTable.getColumnModel().getColumn(4).setHeaderValue("Supply Type");
        supTable.getColumnModel().getColumn(5).setHeaderValue("Company Name");
    }

    public void updateTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from suppliermaster";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            supTable.setModel(DbUtils.resultSetToTableModel(rs));

            Header();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Table Refresh Problem", "INFORMATION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearField() {
        // id.setText("");
        name.setText("");
        mob.setText("");
        addr.setText("");
        type.setSelectedIndex(0);
        comp.setText("");
    }

    void loadTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from suppliermaster";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            DefaultTableModel dm;
            dm = (DefaultTableModel) supTable.getModel();
            supTable.setModel(DbUtils.resultSetToTableModel(rs));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        mob = new javax.swing.JTextField();
        addr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comp = new javax.swing.JTextField();
        type = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        Updateb = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        New = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Supplier");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 116, 145));
        jPanel1.setFocusCycleRoot(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(51, 0, 102));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add Supplier Information");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Supplier.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close Window_48px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
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
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 573, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 116, 145));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel3.setBackground(new java.awt.Color(0, 116, 145));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Supplier ID: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mobile No: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address: ");

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 153));
        id.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, supTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.sid}"), id, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        name.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, supTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.sname}"), name, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });

        mob.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, supTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.smob}"), mob, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        mob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobFocusLost(evt);
            }
        });
        mob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobKeyTyped(evt);
            }
        });

        addr.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, supTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.saddr}"), addr, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Type:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Company:");

        comp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, supTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.scomp}"), comp, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Fruits & Vegetable", "Organic Products", "Bread & Dairy", "HouseHold", "Beverages", "Personal Care" }));
        type.setToolTipText("Select Type");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, supTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.stype}"), type, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

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
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(72, 72, 72)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comp)
                    .addComponent(id)
                    .addComponent(name)
                    .addComponent(mob)
                    .addComponent(addr)
                    .addComponent(type, 0, 167, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(mob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        type.getAccessibleContext().setAccessibleName("Select Type");

        jPanel4.setBackground(new java.awt.Color(0, 116, 145));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conrols", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        Save.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save.png"))); // NOI18N
        Save.setText("SAVE");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Updateb.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Updateb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Update.png"))); // NOI18N
        Updateb.setText("UPDATE");
        Updateb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebActionPerformed(evt);
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
                    .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Updateb, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Updateb))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear)
                    .addComponent(New))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Close)
                    .addComponent(Delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 116, 145));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        supTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addContainerGap()))
        );

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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if (id.getText().equals("") || name.getText().equals("") || mob.getText().equals("") || addr.getText().equals("") || comp.getText().equals("")) {
           JOptionPane.showMessageDialog (this, "You have left one or more Fields BLANK", "ALERT!!!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String q = type.getSelectedItem().toString();
            if (q.equals("<Select>")) {
                JOptionPane.showMessageDialog(this, "Select Type First !");
            }
            else{
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                String sql = "insert into suppliermaster values (?,?,?,?,?,?)";
                PreparedStatement ps1 = con.prepareStatement(sql);
                ps1.setString(1, id.getText());
                ps1.setString(2, name.getText());
                ps1.setString(3, mob.getText());
                ps1.setString(4, addr.getText());
                ps1.setString(5, (String) type.getSelectedItem());
                ps1.setString(6, comp.getText());
                ps1.execute();
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

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int p = JOptionPane.showConfirmDialog(this, "Do you really want to delete this data ?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from suppliermaster where sid=?";
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

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        ManageSupplier s = new ManageSupplier();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NewActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearField();
    }//GEN-LAST:event_ClearActionPerformed

    private void UpdatebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebActionPerformed
        try {
            String value1 = id.getText();
            String value2 = name.getText();
            String value3 = mob.getText();
            String value4 = addr.getText();
            String value5 = (String) type.getSelectedItem();
            String value6 = comp.getText();
            String sql = "update suppliermaster set sid='" + value1 + "',sname='" + value2 + "',smob='" + value3 + "',saddr='" + value4 + "',stype='" + value5 + "',scomp='" + value6 + "' where sid='" + value1 + "' ";
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
    }//GEN-LAST:event_UpdatebActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void supTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supTableMouseClicked
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            int row = supTable.getSelectedRow();
            String table_click = (supTable.getModel().getValueAt(row, 0).toString());
            String sql = "select * from suppliermaster where sid='" + table_click + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next()) {
                String add1 = rs.getString("sid");
                id.setText(add1);
                String add2 = rs.getString("sname");
                name.setText(add2);
                String add3 = rs.getString("smob");
                mob.setText(add3);
                String add4 = rs.getString("saddr");
                addr.setText(add4);
                String add5 = rs.getString("stype");
                type.setSelectedItem(add5);
                String add6 = rs.getString("scomp");
                comp.setText(add6);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        Save.setEnabled(false);
        Updateb.setEnabled(true);
        Delete.setEnabled(true);
    }//GEN-LAST:event_supTableMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int y = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?", "Confirm", 0, 2);
        if (y == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void mobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobFocusLost
        int n = Integer.parseInt(mob.getText().trim());
        if (n != 10) {
            JOptionPane.showMessageDialog(this, "Mobile Number Shoud Be 10 Number", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            mob.setText("");
        }
    }//GEN-LAST:event_mobFocusLost

    private void mobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobKeyReleased
        String ph = mob.getText().trim();
        char[] ch = ph.toCharArray();
        int j = 0;
        for (int i = 0; i < ph.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            mob.setText("");
        }
    }//GEN-LAST:event_mobKeyReleased

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyPressed

    private void mobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobKeyTyped
       if (mob.getText().length() >= 10 ) // limit to 10 characters
            evt.consume();
    }//GEN-LAST:event_mobKeyTyped

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
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Close;
    private javax.swing.JButton Delete;
    private javax.swing.JButton New;
    private javax.swing.JButton Save;
    private javax.swing.JButton Updateb;
    private javax.swing.JTextField addr;
    private javax.swing.JTextField comp;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mob;
    private javax.swing.JTextField name;
    private javax.swing.JTable supTable;
    private javax.swing.JComboBox<String> type;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
