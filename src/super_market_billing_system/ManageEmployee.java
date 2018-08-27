package super_market_billing_system;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ManageEmployee extends javax.swing.JFrame {

    public ManageEmployee() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        showDate();
        loadTable();
        AutoInc();
        Update.setEnabled(false);
        Delete.setEnabled(false);
    }

    public void AutoInc() {
        try {
            String num = null;
            int no;
            String sql = "select eid from employeemaster";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = (rs.getString("eid"));
            }
            no = Integer.parseInt(num) + 1;
            id.setText(String.valueOf(no));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Employee ID Not Set From Database", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            id.setText("1");
        }
    }

    public void showDate() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        regdate.setText(year + "-" + (month + 1) + "-" + day);
    }

    void Header() {
        empTable.getColumnModel().getColumn(0).setHeaderValue("Employee ID");
        empTable.getColumnModel().getColumn(1).setHeaderValue("Employee Name");
        empTable.getColumnModel().getColumn(2).setHeaderValue("Mobile NO.");
        empTable.getColumnModel().getColumn(3).setHeaderValue("Address");
        empTable.getColumnModel().getColumn(4).setHeaderValue("Register Date");
        empTable.getColumnModel().getColumn(5).setHeaderValue("Date Of Birth");
        empTable.getColumnModel().getColumn(6).setHeaderValue("Addhar NO.");
        empTable.getColumnModel().getColumn(7).setHeaderValue("Designation");
        empTable.getColumnModel().getColumn(8).setHeaderValue("Salary");
        empTable.getColumnModel().getColumn(9).setHeaderValue("Password");
    }

    public void updateTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from employeemaster";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            empTable.setModel(DbUtils.resultSetToTableModel(rs));

            Header();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Table Refresh Problem", "INFORMATION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearField() {
        name.setText("");
        mob.setText("");
        addr.setText("");
        dob.setDate(null);
        aadhar.setText("");
        desig.setSelectedIndex(0);
        salary.setText("");
        pass.setText("");
    }

    void loadTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            String sql = "select * from employeemaster";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            DefaultTableModel dm;
            dm = (DefaultTableModel) empTable.getModel();
            empTable.setModel(DbUtils.resultSetToTableModel(rs));

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
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
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
        jLabel14 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        mob = new javax.swing.JTextField();
        addr = new javax.swing.JTextField();
        regdate = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        salary = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        aadhar = new javax.swing.JTextField();
        dob = new com.toedter.calendar.JDateChooser();
        desig = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        New = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Employee");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 116, 145));
        jPanel1.setFocusCycleRoot(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(51, 0, 102));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add Employee Information");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Front Desk_64px.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close Window_48px.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 668, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
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
        jLabel2.setText("Employee ID: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mobile No: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registration Date: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date Of Birth: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Aadhaar No:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Designation:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Salary: ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Password:");

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 153));
        id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.eid}"), id, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.ename}"), name, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });

        mob.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.emob}"), mob, org.jdesktop.beansbinding.BeanProperty.create("text"));
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

        addr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.eaddr}"), addr, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        regdate.setEditable(false);
        regdate.setBackground(new java.awt.Color(255, 255, 153));
        regdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.erdate}"), regdate, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        pass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pass.setToolTipText("");
        pass.setDoubleBuffered(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.epass}"), pass, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        salary.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.esalary}"), salary, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        salary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                salaryKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salaryKeyTyped(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(0, 116, 145));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Show");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        aadhar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, empTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.eaadhar}"), aadhar, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        aadhar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                aadharFocusLost(evt);
            }
        });
        aadhar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aadharKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aadharKeyTyped(evt);
            }
        });

        dob.setDateFormatString("yyyy-MM-dd");

        desig.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        desig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Cashier" }));

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
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regdate)
                    .addComponent(id)
                    .addComponent(name)
                    .addComponent(mob)
                    .addComponent(addr)
                    .addComponent(salary)
                    .addComponent(pass)
                    .addComponent(aadhar)
                    .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(desig, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
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
                    .addComponent(mob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(aadhar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 116, 145));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controls", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Save)
                        .addComponent(Update))
                    .addGap(40, 40, 40)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Clear)
                        .addComponent(New))
                    .addGap(35, 35, 35)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Delete)
                        .addComponent(Close))
                    .addContainerGap(126, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 116, 145));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1294, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1274, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        getAccessibleContext().setAccessibleDescription("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if (id.getText().equals("") || name.getText().equals("") || mob.getText().equals("") || addr.getText().equals("") || regdate.getText().equals("") || aadhar.getText().equals("") || pass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "You have left one or more Fields BLANK", "ALERT!!!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dob1 = df.format(dob.getDate());
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                String sql = "insert into employeemaster values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps1 = con.prepareStatement(sql);
                ps1.setString(1, id.getText());
                ps1.setString(2, name.getText());
                ps1.setString(3, mob.getText());
                ps1.setString(4, addr.getText());
                ps1.setString(5, regdate.getText());
                ps1.setString(6, dob1);
                ps1.setString(7, aadhar.getText());
                ps1.setString(8, desig.getSelectedItem().toString());
                ps1.setString(9, salary.getText());
                ps1.setString(10, pass.getText());
                ps1.execute();
                JOptionPane.showMessageDialog(this, "Record saved successfully");
                updateTable();
                AutoInc();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please fill records in proper format");
            }
            clearField();
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int p = JOptionPane.showConfirmDialog(this, "Do you really want to delete this data ?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from employeemaster where eid=?";
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

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearField();
    }//GEN-LAST:event_ClearActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dob1 = df.format(dob.getDate());
            String value1 = id.getText();
            String value2 = name.getText();
            String value3 = mob.getText();
            String value4 = addr.getText();
            String value5 = regdate.getText();
            String value6 = dob1;
            String value7 = aadhar.getText();
            String value8 = desig.getSelectedItem().toString();
            String value9 = salary.getText();
            String value10 = pass.getText();
            String sql = "update employeemaster set eid='" + value1 + "',ename='" + value2 + "',emob='" + value3 + "',eaddr='" + value4 + "',erdate='" + value5 + "',edob='" + value6 + "',eaadhar='" + value7 + "',desig='" + value8 + "',esalary='" + value9 + "',epass='" + value10 + "' where eid='" + value1 + "' ";
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

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        ManageEmployee e = new ManageEmployee();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NewActionPerformed

    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            int row = empTable.getSelectedRow();
            String table_click = (empTable.getModel().getValueAt(row, 0).toString());
            String sql = "select * from employeemaster where eid='" + table_click + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next()) {
                String add1 = rs.getString("eid");
                id.setText(add1);
                String add2 = rs.getString("ename");
                name.setText(add2);
                String add3 = rs.getString("emob");
                mob.setText(add3);
                String add4 = rs.getString("eaddr");
                addr.setText(add4);
                String add5 = rs.getString("erdate");
                regdate.setText(add5);
                Date add6 = rs.getDate("edob");
                dob.setDate(add6);
                String add7 = rs.getString("eaadhar");
                aadhar.setText(add7);
                String add8 = rs.getString("desig");
                desig.setSelectedItem(add8);
                String add9 = rs.getString("esalary");
                salary.setText(add9);
                String add10 = rs.getString("epass");
                pass.setText(add10);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        Save.setEnabled(false);
        Update.setEnabled(true);
        Delete.setEnabled(true);
    }//GEN-LAST:event_empTableMouseClicked

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        boolean flag = false;
        String str = name.getText();
        int l = name.getText().length();
        for (int i = 0; i < l; i++) {
            char ch = str.charAt(i);
            if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && ch != ' ' && ch != '\n') {
                flag = true;
                break;
            }
        }
        if (flag == true) {
            JOptionPane.showMessageDialog(this, "Only text values are allowed");
            name.setText("");
        }
    }//GEN-LAST:event_nameKeyReleased

    private void aadharKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aadharKeyReleased
        String ad = aadhar.getText().trim();
        char[] ch = ad.toCharArray();
        int j = 0;
        for (int i = 0; i < ad.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            aadhar.setText("");
        }
    }//GEN-LAST:event_aadharKeyReleased

    private void salaryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryKeyReleased
        String sl = salary.getText().trim();
        char[] ch = sl.toCharArray();
        int j = 0;
        for (int i = 0; i < sl.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            salary.setText("");
        }
    }//GEN-LAST:event_salaryKeyReleased

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        int y = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?", "Confirm", 0, 2);
        if (y == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void mobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobFocusLost
        int n = Integer.parseInt(mob.getText());
        if (n != 10) {
            JOptionPane.showMessageDialog(this, "Mobile Number Shoud Be 10 Number", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            mob.setText("");
        }
    }//GEN-LAST:event_mobFocusLost

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            pass.setEchoChar((char) 0);
        } else {
            pass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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

    private void aadharFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aadharFocusLost
        String ad = aadhar.getText();
        if (ad.length() != 12) {
            JOptionPane.showMessageDialog(this, "Aadhar Number Shoud Be 12 Numbers", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            aadhar.setText("");
        }
    }//GEN-LAST:event_aadharFocusLost

    private void mobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobKeyTyped
        if (mob.getText().length() >= 10 ) // limit to 10 characters
            evt.consume();
    }//GEN-LAST:event_mobKeyTyped

    private void aadharKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aadharKeyTyped
       if (aadhar.getText().length() >= 12 ) // limit to 12 characters
            evt.consume();
    }//GEN-LAST:event_aadharKeyTyped

    private void salaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryKeyTyped
        if (salary.getText().length() >= 5 ) // limit to 5 characters
            evt.consume();
    }//GEN-LAST:event_salaryKeyTyped

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
            java.util.logging.Logger.getLogger(ManageEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageEmployee().setVisible(true);
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
    private javax.swing.JTextField aadhar;
    private javax.swing.JTextField addr;
    private javax.swing.JComboBox<String> desig;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTable empTable;
    private javax.swing.JTextField id;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mob;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField regdate;
    private javax.swing.JTextField salary;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
