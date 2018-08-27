package super_market_billing_system;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BillGenerator extends javax.swing.JFrame {

    public JTextArea listPane;
    Object obj1 = null, obj2 = null, obj3 = null, obj4 = null, obj5 = null, obj6 = null, ob = null, pr = null;

    public Object GetData(JTable jTable1, int row_index, int column_index) {
        return jTable1.getModel().getValueAt(row_index, column_index);
    }

    public void SetData(Object objj, int row_index, int column_index) {
        jTable1.getModel().setValueAt(objj, row_index, column_index);
    }

    public BillGenerator() {
        initComponents();
        showDate();
        showTime();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pname.setEnabled(false);
        pbar.setEnabled(false);
        pqty.setEnabled(false);
        ptotal.setEnabled(false);
        psell.setEnabled(false);
        calculate.setEnabled(false);
        save.setEnabled(false);
        print.setEnabled(false);
        add.setEnabled(false);
        remove.setEnabled(false);
        total.setEnabled(false);
        reset.setEnabled(false);

//Auto Increment CashMemo
        try {
            String num = null;
            int no;
            String sql = "select cmemo from billmaster";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = (rs.getString("cmemo"));
            }
            no = Integer.parseInt(num) + 1;
            cmemo.setText(String.valueOf(no));
            billCashMemo.setText(cmemo.getText());
            cmemo.setEditable(false);
            datet.setEditable(false);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CashMemo Not Set From Database", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            cmemo.setText("10000");
        }

//Add Database Values in JCombobox
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select pid from productmaster");
            while (rs.next()) {
                pid.addItem(rs.getString(1));
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Employee Data Does Not Exit", "INFORMATION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showDate() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        jLabel2.setText(year + "-" + (month + 1) + "-" + day);
        datet.setText(year + "-" + (month + 1) + "-" + day);
        billDate.setText(datet.getText());
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                jLabel3.setText(s.format(d));
                billTime.setText(jLabel3.getText());
            }
        }
        ).start();
    }

    void datetime() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        jLabel2.setText(year + "-" + (month + 1) + "-" + day);
        datet.setText(year + "-" + (month + 1) + "-" + day);
    }
    
    void insertInto()
    {
                    try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                String sql = "insert into billmaster values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps1 = con.prepareStatement(sql);
                ps1.setString(1, cmemo.getText());
                ps1.setString(2, datet.getText());
                ps1.setString(3, cname.getText());
                ps1.setString(4, pid.getSelectedItem().toString());
                ps1.setString(5, pname.getText());
                ps1.setString(6, pbar.getText());
                ps1.setString(7, pqty.getText());
                ps1.setString(8, pmrp.getText());
                ps1.setString(9, psell.getText());
                ps1.setString(10, ptotal.getText());
                ps1.setString(11, null);
                ps1.setString(12, null);
                ps1.setString(13, null);
                ps1.setString(14, null);
                ps1.execute();
                con.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Please fill records in proper format");
            }
    }
    
    void clearFi()
    {
                    pid.setSelectedIndex(0);
                    pname.setText("");
                    pbar.setText("");
                    pqty.setText("");
                    pmrp.setText("");
                    psell.setText("");
                    ptotal.setText("");
    }
    void tableMod()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
          //  obj1 = pid.getSelectedItem().toString();
            obj2 = pname.getText();
            obj3 = pqty.getText();
            obj4 = pmrp.getText();
            obj5 = psell.getText();
            obj6 = ptotal.getText();
            model.insertRow(0, new Object[]{obj2, obj3, obj4, obj5, obj6});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        notepad = new javax.swing.JButton();
        calculator = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        total = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        avi = new javax.swing.JButton();
        New = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        tba = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        gst = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        calculate = new javax.swing.JButton();
        save = new javax.swing.JButton();
        print = new javax.swing.JButton();
        totalcash = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmemo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pbar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        pqty = new javax.swing.JTextField();
        pmrp = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        psell = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        ptotal = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        datet = new javax.swing.JTextField();
        pid = new javax.swing.JComboBox<>();
        billPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        billCashMemo = new javax.swing.JLabel();
        billDate = new javax.swing.JLabel();
        billTime = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        billCustName = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        billDis = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        billGST = new javax.swing.JLabel();
        billTotalCash = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();

        setTitle("Bill Generator");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 720));
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 116, 145));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bill Generator");
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        notepad.setBackground(new java.awt.Color(102, 102, 102));
        notepad.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        notepad.setForeground(new java.awt.Color(255, 255, 255));
        notepad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Note_48px.png"))); // NOI18N
        notepad.setText("Notepad");
        notepad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notepadActionPerformed(evt);
            }
        });

        calculator.setBackground(new java.awt.Color(102, 102, 102));
        calculator.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        calculator.setForeground(new java.awt.Color(255, 255, 255));
        calculator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Calculator_48px.png"))); // NOI18N
        calculator.setText("Calculator");
        calculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatorActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Today's Date:-");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date Change");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(":");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Time Change");

        Close.setBackground(new java.awt.Color(102, 102, 102));
        Close.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Close.setForeground(new java.awt.Color(255, 255, 255));
        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close.png"))); // NOI18N
        Close.setText("CLOSE");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Close Window_48px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(calculator)
                .addGap(10, 10, 10)
                .addComponent(notepad)
                .addGap(10, 10, 10)
                .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(calculator)
                    .addComponent(notepad)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Close))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 116, 145));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        add.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Plus_48px.png"))); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        total.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Equal Sign_48px.png"))); // NOI18N
        total.setText("TOTAL");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Clear.png"))); // NOI18N
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        avi.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        avi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Product_48px.png"))); // NOI18N
        avi.setText("Check Products");
        avi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aviActionPerformed(evt);
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

        remove.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Minus_48px.png"))); // NOI18N
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(remove))
                    .addComponent(avi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(New, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(total)
                    .addComponent(remove))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avi)
                    .addComponent(reset)
                    .addComponent(New))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 116, 145));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total Bill Amount: ");

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("GST :");

        gst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "5", "12", "18", "28" }));

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Discount :");

        discount.setText("0");
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
        });

        calculate.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        calculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Pincode Keyboard_48px.png"))); // NOI18N
        calculate.setText("Calculate");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
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

        totalcash.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Total CASH:");

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("%");

        jLabel24.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("%");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel23))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addComponent(jLabel24)))
                        .addGap(88, 88, 88)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalcash, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(6, 6, 6)
                            .addComponent(tba, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addGap(4, 4, 4)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(10, 10, 10)
                            .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(475, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(totalcash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print)
                    .addComponent(calculate)
                    .addComponent(save))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(tba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel21))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(80, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 116, 145));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cash Memo: ");

        cmemo.setEditable(false);
        cmemo.setBackground(new java.awt.Color(255, 255, 153));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Customer Name: ");

        cname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cnameFocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Product ID: ");

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Product Name: ");

        pname.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(" Barcode: ");

        pbar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pbarFocusGained(evt);
            }
        });
        pbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pbarKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantity: ");

        pqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pqtyKeyReleased(evt);
            }
        });

        pmrp.setEditable(false);
        pmrp.setBackground(new java.awt.Color(255, 255, 153));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("M.R.P: ");

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sell Rate: ");

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Total Amount: ");

        jLabel25.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Date: ");

        datet.setEditable(false);
        datet.setBackground(new java.awt.Color(255, 255, 153));

        pid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>" }));
        pid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pidItemStateChanged(evt);
            }
        });
        pid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pidFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pbar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(4, 4, 4)
                                .addComponent(cmemo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel25)
                                .addGap(4, 4, 4)
                                .addComponent(datet, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(4, 4, 4)
                                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pmrp, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(psell, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ptotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pqty, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel25)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(ptotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(pmrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(psell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(20, 20, 20)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        billPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "QTY", "M.R.P.", "S. Rate", "T.Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(7);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(7);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(7);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(7);
        }

        jLabel8.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 48)); // NOI18N
        jLabel8.setText("***SuperMarket***");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("AT: ALIBAG-RAIGHAD");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("PINCODE: 402201");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel12.setText("TEL: (02141) 282589");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel28.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel28.setText("CashMemo: ");

        billCashMemo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        billCashMemo.setText("------------");

        billDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        billDate.setText("__.__.____");

        billTime.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        billTime.setText("__.__.__");

        jLabel30.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel30.setText("Customer Name: ");

        billCustName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        billCustName.setText("-----------------------");

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel27.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel27.setText("Discount: ");

        jLabel34.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel34.setText("TOTAL CASH:");

        billDis.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        billDis.setText("------------");

        jLabel36.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel36.setText("GST:");

        billGST.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        billGST.setText("------");

        billTotalCash.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        billTotalCash.setText("-----------------------");

        jLabel39.setText("Many Product Are Already Discounted And Your Saving.");

        jLabel40.setText(" Please Satisfy Yourself Before Leaving The Counter.");

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel41.setText(" GST NO:27G3SK572GN9G2  R.D:1-11-2017 ");

        jLabel42.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel42.setText("Thanks To Visit Our Supermarket... ");

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel27)
                        .addGap(10, 10, 10)
                        .addComponent(billDis, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)
                        .addGap(10, 10, 10)
                        .addComponent(billGST))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel34)
                        .addGap(6, 6, 6)
                        .addComponent(billTotalCash))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel39))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel40))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel41))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel42))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(billCustName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(billCashMemo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(billDate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(billTime, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(billCashMemo)
                    .addComponent(billDate)
                    .addComponent(billTime))
                .addGap(6, 6, 6)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(billCustName))
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(billDis)
                    .addComponent(jLabel36)
                    .addComponent(billGST))
                .addGap(11, 11, 11)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(billTotalCash))
                .addGap(7, 7, 7)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel39)
                .addGap(6, 6, 6)
                .addComponent(jLabel40)
                .addGap(6, 6, 6)
                .addComponent(jLabel41)
                .addGap(6, 6, 6)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notepadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notepadActionPerformed
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("c:/WINDOWS/system32/notepad.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Notepad Not Found in System");
        }
    }//GEN-LAST:event_notepadActionPerformed

    private void calculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatorActionPerformed
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("c:/WINDOWS/system32/calc.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Calculator Not Found in System");
        }
    }//GEN-LAST:event_calculatorActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        Toolkit tkp=billPanel.getToolkit();
        PrintJob pjb=tkp.getPrintJob(this, null, null);
        Graphics g=pjb.getGraphics();
        billPanel.print(g);
        g.dispose();
        pjb.end();
        New.setEnabled(true);
        avi.setEnabled(true);
    }//GEN-LAST:event_printActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String a = pid.getSelectedItem().toString();
        String b = pname.getText();
        String c = pbar.getText();
        String d = pmrp.getText();
        String e = psell.getText();
        String f = ptotal.getText();
        if (a.equals("") || b.equals("") || c.equals("") || d.equals("") || e.equals("") || f.equals("")) {
            JOptionPane.showMessageDialog(this, "You have left one or more Fields BLANK", "ALERT!!!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                int newQty = 0;
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select pqty from productmaster where pid='" + pid.getSelectedItem().toString() + "'");
                rs.next();
                int pqty1 = rs.getInt(1);
                if (pqty1 < 0) {
                    JOptionPane.showMessageDialog(null, "Stock Out...");
                    clearFi();
                } else {
                    if (pqty1 < 10) {
                    JOptionPane.showMessageDialog(null, "Stock Are Limited...");
                    insertInto();
                    tableMod();
                    newQty = pqty1 - Integer.parseInt(pqty.getText());
                    String sql3 = "update productmaster set pqty='" + newQty + "'where pid='" + pid.getSelectedItem().toString() + "' ";
                    PreparedStatement ps = con.prepareStatement(sql3);
                    ps.execute();
                    clearFi();
                } else {
                    insertInto();
                    tableMod();
                    newQty = pqty1 - Integer.parseInt(pqty.getText());
                    String sql2 = "update productmaster set pqty='" + newQty + "'where pid='" + pid.getSelectedItem().toString() + "' ";
                    PreparedStatement ps = con.prepareStatement(sql2);
                   ps.execute();
                   clearFi();
                }
                }
                con.close();
            } catch (Exception e1) {
            }
            total.setEnabled(true);
            remove.setEnabled(true);
        }
    }//GEN-LAST:event_addActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        if (evt.getSource() == total) {
            try {
                int i = 0;
                int rowcount = jTable1.getRowCount();
                System.out.println(rowcount);
                SetData("Total", rowcount - 1, 3);//total label
                Object o1 = null, o2 = null;
                o2 = GetData(jTable1, i, 1);
                int sum = 0;
                for (i = 0; i < rowcount; i++) {
                    o1 = GetData(jTable1, i, 4);//set amount
                    float n1 = Integer.parseInt(o1.toString());
                    sum = (int) (sum + n1);
                    SetData(sum, rowcount - 1, 4);
                     System.out.println(sum);
                    tba.setText("" + sum);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            calculate.setEnabled(true);
            add.setEnabled(false);
            New.setEnabled(false);
            reset.setEnabled(false);
            total.setEnabled(false);
            remove.setEnabled(false);
            pid.setEnabled(false);
            pqty.setEnabled(false);
            avi.setEnabled(false);
        }
    }//GEN-LAST:event_totalActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        pid.setSelectedIndex(0);
        pbar.setText("");
        pname.setText("");
        pmrp.setText("");
        pqty.setText("");
        ptotal.setText("");
        psell.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed
        int n1, res, tc, dis, caldis;
        int gs;
        gs = Integer.parseInt((String) gst.getSelectedItem());
        n1 = Integer.parseInt(tba.getText());
        res = (n1 * gs) / 100;
        tc = res + n1;
        totalcash.setText(String.valueOf(tc));
        dis = Integer.parseInt(discount.getText());
        caldis = tc * (100 - dis) / 100;
        totalcash.setText(String.valueOf(caldis));
        billDis.setText(discount.getText());
        billGST.setText(gst.getSelectedItem().toString());
        billTotalCash.setText(totalcash.getText());
        save.setEnabled(true);
        calculate.setEnabled(false);
    }//GEN-LAST:event_calculateActionPerformed

    private void aviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aviActionPerformed
        CheckProducts ck = new CheckProducts();
        ck.setVisible(true);
    }//GEN-LAST:event_aviActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int y = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?", "Confirm", 0, 2);
        if (y == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            String value1 = tba.getText();
            String value2 = (String) gst.getSelectedItem();
            String value3 = discount.getText();
            String value4 = totalcash.getText();
            String sql = "update billmaster set tba='" + value1 + "',gst='" + value2 + "',discount='" + value3 + "',totalcash='" + value4 + "' where cmemo='" + cmemo.getText() + "'";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Record Save successfully");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        print.setEnabled(true);
        save.setEnabled(false);
    }//GEN-LAST:event_saveActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        BillGenerator e = new BillGenerator();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NewActionPerformed

    private void cnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cnameFocusLost
        billCustName.setText(cname.getText().toUpperCase());
        cname.setEditable(false);
        cname.setEnabled(false);
    }//GEN-LAST:event_cnameFocusLost

    private void pbarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pbarFocusGained

    }//GEN-LAST:event_pbarFocusGained

    private void pbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pbarKeyReleased
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            Statement stm = con.createStatement();
            String sql = "select * from productmaster where pbar =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pbar.getText());
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("pid");
                pid.setSelectedItem(add1);
                String add2 = rs.getString("pname");
                pname.setText(add2);
                String add3 = rs.getString("pbar");
                pbar.setText(add3);
                String add4 = rs.getString("pmrp");
                pmrp.setText(add4);
                String add5 = rs.getString("psell");
                psell.setText(add5);
            }
            con.close();
        } catch (SQLException ex) {
        }
        pid.setEnabled(true);
        pname.setEnabled(true);
        pqty.setEnabled(true);
        pbar.setEnabled(true);
        ptotal.setEnabled(true);
        psell.setEnabled(true);
        add.setEnabled(true);
        total.setEnabled(true);
    }//GEN-LAST:event_pbarKeyReleased

    private void pidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pidItemStateChanged
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperMarket_DB", "root", "root");
            Statement stm = con.createStatement();
            String sql = "select * from productmaster where pid =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pid.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("pid");
                pid.setSelectedItem(add1);
                String add2 = rs.getString("pname");
                pname.setText(add2);
                String add3 = rs.getString("pbar");
                pbar.setText(add3);
                String add4 = rs.getString("pmrp");
                pmrp.setText(add4);
                String add5 = rs.getString("psell");
                psell.setText(add5);
            }
            con.close();
        } catch (SQLException ex) {
        }
        pid.setEnabled(true);
        pname.setEnabled(true);
        pqty.setEnabled(true);
        pbar.setEnabled(true);
        ptotal.setEnabled(true);
        psell.setEnabled(true);
        add.setEnabled(true);
    }//GEN-LAST:event_pidItemStateChanged

    private void pidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pidFocusGained

    }//GEN-LAST:event_pidFocusGained

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        String sl = discount.getText().trim();
        char[] ch = sl.toCharArray();
        int j = 0;
        for (int i = 0; i < sl.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            discount.setText("");
        }
    }//GEN-LAST:event_discountKeyReleased

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        int filaselecionada = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (filaselecionada >= 0) {
            model.removeRow(filaselecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Select First Row From Table");
        }
    }//GEN-LAST:event_removeActionPerformed

    private void pqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pqtyKeyReleased
        String sl = pqty.getText().trim();
        char[] ch = sl.toCharArray();
        int j = 0;
        for (int i = 0; i < sl.length(); i++) {
            if (ch[i] < 48 || ch[i] > 57) {
                j++;
            }
        }
        if (j != 0) {
            JOptionPane.showMessageDialog(this, "Only Numerical Values should be Entered");
            pqty.setText("");
        }
        int n1, n2, res;
        n1 = Integer.parseInt(psell.getText());
        n2 = Integer.parseInt(pqty.getText());
        res = n1 * n2;
        ptotal.setText(String.valueOf(res));
    }//GEN-LAST:event_pqtyKeyReleased

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
            java.util.logging.Logger.getLogger(BillGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillGenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JButton New;
    private javax.swing.JButton add;
    private javax.swing.JButton avi;
    private javax.swing.JLabel billCashMemo;
    private javax.swing.JLabel billCustName;
    private javax.swing.JLabel billDate;
    private javax.swing.JLabel billDis;
    private javax.swing.JLabel billGST;
    private javax.swing.JPanel billPanel;
    private javax.swing.JLabel billTime;
    private javax.swing.JLabel billTotalCash;
    private javax.swing.JButton calculate;
    private javax.swing.JButton calculator;
    private javax.swing.JTextField cmemo;
    private javax.swing.JTextField cname;
    private javax.swing.JTextField datet;
    private javax.swing.JTextField discount;
    private javax.swing.JComboBox<String> gst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton notepad;
    private javax.swing.JTextField pbar;
    private javax.swing.JComboBox<String> pid;
    private javax.swing.JTextField pmrp;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField pqty;
    private javax.swing.JButton print;
    private javax.swing.JTextField psell;
    private javax.swing.JTextField ptotal;
    private javax.swing.JButton remove;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTextField tba;
    private javax.swing.JButton total;
    private javax.swing.JTextField totalcash;
    // End of variables declaration//GEN-END:variables

}
