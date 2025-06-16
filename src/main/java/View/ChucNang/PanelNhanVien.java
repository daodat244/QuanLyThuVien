package View.ChucNang;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.DAO.NhanVienDAO;
import Model.NhanVien;
import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PanelNhanVien extends javax.swing.JPanel {

    private final NhanVienDAO nhanvienDAO = new NhanVienDAO();
    
    public PanelNhanVien() {
        initComponents();
        loadTableData();
            txtTimKiem.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { searchNV(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { searchNV(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { searchNV(); }
        });
            
            dtpNgaySinh.getSettings().setVetoPolicy(new DateVetoPolicy() {
        @Override
        public boolean isDateAllowed(LocalDate date) {
            if (date == null) {
                return false;
            }
            int currentYear = LocalDate.now().getYear();
            return (currentYear - date.getYear()) >= 18;
        }
    });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelInfor = new javax.swing.JPanel();
        TenDG = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        SoDienThoai = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        DiaChi = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        dtpNgaySinh = new com.github.lgooddatepicker.components.DatePicker();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        SoDienThoai1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNhapDuLieu = new javax.swing.JButton();
        btnXuatDuLieu = new javax.swing.JButton();
        panelButton = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        TimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNv = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1120, 666));
        setMinimumSize(new java.awt.Dimension(1120, 666));

        panelInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TenDG.setText("Tên nhân viên");
        TenDG.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTenNV.setPreferredSize(new java.awt.Dimension(64, 25));

        SoDienThoai.setText("Số điện thoại");
        SoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSdt.setPreferredSize(new java.awt.Dimension(64, 25));

        Email.setText("Ngày sinh");
        Email.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        DiaChi.setText("Quê quán");
        DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtQueQuan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtQueQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQueQuanActionPerformed(evt);
            }
        });

        buttonGroup1.add(radNam);
        radNam.setSelected(true);
        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(radNu);
        radNu.setText("Nữ");

        SoDienThoai1.setText("Giới tính");
        SoDienThoai1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        javax.swing.GroupLayout panelInforLayout = new javax.swing.GroupLayout(panelInfor);
        panelInfor.setLayout(panelInforLayout);
        panelInforLayout.setHorizontalGroup(
            panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInforLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInforLayout.createSequentialGroup()
                        .addComponent(TenDG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInforLayout.createSequentialGroup()
                        .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SoDienThoai)
                            .addComponent(SoDienThoai1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInforLayout.createSequentialGroup()
                                .addComponent(radNam)
                                .addGap(18, 18, 18)
                                .addComponent(radNu))
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInforLayout.createSequentialGroup()
                        .addComponent(DiaChi)
                        .addGap(18, 18, 18)
                        .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInforLayout.createSequentialGroup()
                        .addComponent(Email)
                        .addGap(18, 18, 18)
                        .addComponent(dtpNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        panelInforLayout.setVerticalGroup(
            panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInforLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenDG)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email)
                    .addComponent(dtpNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SoDienThoai)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DiaChi)
                        .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radNu)
                    .addComponent(radNam)
                    .addComponent(SoDienThoai1))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNhapDuLieu.setText("Nhập Dữ liệu");
        btnNhapDuLieu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnNhapDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapDuLieuActionPerformed(evt);
            }
        });

        btnXuatDuLieu.setText("Xuất Dữ liệu");
        btnXuatDuLieu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnXuatDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDuLieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXuatDuLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNhapDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnNhapDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuatDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelButton.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        panelButton.setPreferredSize(new java.awt.Dimension(1120, 86));

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        TimKiem.setText("Tìm Kiếm:");
        TimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Nhân Viên", "Tên Nhân Viên" }));
        cbTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(TimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTimKiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimKiem))
                    .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tableNv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Số điện thoại", "Ngày sinh", "Quê quán", "Giới tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNv.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableNv.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableNv.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableNv.setShowGrid(true);
        tableNv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableNv);
        if (tableNv.getColumnModel().getColumnCount() > 0) {
            tableNv.getColumnModel().getColumn(0).setResizable(false);
            tableNv.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableNv.getColumnModel().getColumn(1).setResizable(false);
            tableNv.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableNv.getColumnModel().getColumn(2).setResizable(false);
            tableNv.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableNv.getColumnModel().getColumn(3).setResizable(false);
            tableNv.getColumnModel().getColumn(3).setPreferredWidth(200);
            tableNv.getColumnModel().getColumn(4).setResizable(false);
            tableNv.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 1148, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtQueQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQueQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQueQuanActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addNV();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        updateNV();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        deleteNV();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tableNvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNvMouseClicked
        int row = tableNv.getSelectedRow();
    if (row >= 0) {
        txtTenNV.setText(tableNv.getValueAt(row, 1) != null ? tableNv.getValueAt(row, 1).toString() : "");
        txtSdt.setText(tableNv.getValueAt(row, 2) != null ? tableNv.getValueAt(row, 2).toString() : "");
        txtQueQuan.setText(tableNv.getValueAt(row, 4) != null ? tableNv.getValueAt(row, 4).toString() : "");

        // Xử lý ngày sinh
        Object dateValue = tableNv.getValueAt(row, 3);
        if (dateValue instanceof Date) {
            dtpNgaySinh.setDate(((Date) dateValue).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        } else {
            dtpNgaySinh.setDate(null);
        }

        // Xử lý giới tính
        String gioitinh = tableNv.getValueAt(row, 5) != null ? tableNv.getValueAt(row, 5).toString() : "Nam";
        radNam.setSelected(gioitinh.equalsIgnoreCase("Nam"));
        radNu.setSelected(gioitinh.equalsIgnoreCase("Nữ"));
        
    }
            
    }//GEN-LAST:event_tableNvMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        searchNV();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnNhapDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapDuLieuActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Chọn file Excel để nhập dữ liệu nhân viên");
    fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
        @Override
        public boolean accept(File f) {
            return f.isDirectory() || f.getName().toLowerCase().endsWith(".xlsx");
        }

        @Override
        public String getDescription() {
            return "Excel Files (*.xlsx)";
        }
    });

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try (FileInputStream fis = new FileInputStream(selectedFile); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            int successCount = 0;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                try {
                    // Kiểm tra dữ liệu từ Excel
                    String tennhanvien = row.getCell(1) != null ? row.getCell(1).getStringCellValue().trim() : "";
                    String sdt = row.getCell(2) != null ? row.getCell(2).getStringCellValue().trim() : "";
                    Date ngaysinh = row.getCell(3) != null ? row.getCell(3).getDateCellValue() : null;
                    String quequan = row.getCell(4) != null ? row.getCell(4).getStringCellValue().trim() : "";
                    String gioitinh = row.getCell(5) != null ? row.getCell(5).getStringCellValue().trim() : "";

                    // Kiểm tra tên nhân viên
                    if (!isValidName(tennhanvien)) {
                        JOptionPane.showMessageDialog(this, "Tên nhân viên ở dòng " + (i + 1) + " không hợp lệ! Chỉ cho phép chữ cái, số và khoảng trắng.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    // Kiểm tra số điện thoại
                    if (!isValidPhoneNumber(sdt)) {
                        JOptionPane.showMessageDialog(this, "Số điện thoại ở dòng " + (i + 1) + " không hợp lệ! Phải bắt đầu bằng 0 và có đúng 10 chữ số.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    // Kiểm tra trùng lặp số điện thoại
                    if (nhanvienDAO.isDuplicatePhone(sdt, 0)) {
                        JOptionPane.showMessageDialog(this, "Số điện thoại ở dòng " + (i + 1) + " đã tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    // Kiểm tra ngày sinh
                    LocalDate localDate = ngaysinh != null ? ngaysinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
                    if (!isValidBirthDate(localDate)) {
                        int maxYear = LocalDate.now().getYear() - 18;
                        JOptionPane.showMessageDialog(this, "Ngày sinh ở dòng " + (i + 1) + " không hợp lệ! Nhân viên phải đủ 18 tuổi (sinh trước hoặc trong năm " + maxYear + ").", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    // Kiểm tra quê quán
                    if (!isValidAddress(quequan)) {
                        JOptionPane.showMessageDialog(this, "Quê quán ở dòng " + (i + 1) + " không hợp lệ! Chỉ cho phép chữ cái, số, khoảng trắng, dấu phẩy, gạch chéo, gạch ngang.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    // Kiểm tra giới tính
                    if (!gioitinh.equals("Nam") && !gioitinh.equals("Nữ")) {
                        JOptionPane.showMessageDialog(this, "Giới tính ở dòng " + (i + 1) + " không hợp lệ! Chỉ cho phép 'Nam' hoặc 'Nữ'.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    NhanVien nv = new NhanVien();
                    nv.setManhanvien((int) row.getCell(0).getNumericCellValue());
                    nv.setTennhanvien(tennhanvien);
                    nv.setSdt(sdt);
                    nv.setNgaysinh(ngaysinh);
                    nv.setQuequan(quequan);
                    nv.setGioitinh(gioitinh);

                    if (nhanvienDAO.addNV(nv)) {
                        successCount++;
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thể thêm nhân viên ở dòng " + (i + 1), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi đọc dòng " + (i + 1) + ": " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }

            loadTableData();
            JOptionPane.showMessageDialog(this, "Đã nhập thành công " + successCount + " nhân viên!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi đọc file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }    
    }
    }//GEN-LAST:event_btnNhapDuLieuActionPerformed

    private void btnXuatDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDuLieuActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
        fileChooser.setSelectedFile(new File("danh_sach_nhan_vien.xlsx"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".xlsx");
            }

            @Override
            public String getDescription() {
                return "Excel Files (*.xlsx)";
            }
        });

        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Đảm bảo file có đuôi .xlsx
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
                selectedFile = new File(filePath);
            }

            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("DanhSachNhanVien");

                // Tạo dòng tiêu đề
                Row headerRow = sheet.createRow(0);
                String[] headers = new String[]{"Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Ngày sinh", "Quê quán", "Giới tính"};
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                }

                // Ghi dữ liệu từ bảng
                DefaultTableModel model = (DefaultTableModel) tableNv.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    row.createCell(0).setCellValue((int) model.getValueAt(i, 0));
                    row.createCell(1).setCellValue((String) model.getValueAt(i, 1));
                    row.createCell(2).setCellValue((String) model.getValueAt(i, 2));
                    row.createCell(3).setCellValue((Date) model.getValueAt(i, 3));
                    row.createCell(4).setCellValue((String) model.getValueAt(i, 4)); 
                    row.createCell(5).setCellValue((String) model.getValueAt(i, 5));
                }

                // Tự động điều chỉnh độ rộng cột
                for (int i = 0; i < headers.length; i++) {
                    sheet.autoSizeColumn(i);
                }

                // Ghi file
                try (FileOutputStream fileOut = new FileOutputStream(selectedFile)) {
                    workbook.write(fileOut);
                }

                JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXuatDuLieuActionPerformed

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed
    
        private void loadTableData() {
            try {
                List<NhanVien> nvList = nhanvienDAO.getAllNhanVien();
                DefaultTableModel model = (DefaultTableModel) tableNv.getModel();
                model.setRowCount(0); // Xóa dữ liệu cũ
                for (NhanVien nv : nvList) {
                    model.addRow(new Object[]{
                        nv.getManhanvien(),
                        nv.getTennhanvien(),
                        nv.getSdt(),
                        nv.getNgaysinh(),
                        nv.getQuequan(),
                        nv.getGioitinh()
                    });
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        
            private void addNV() {
    try {
        String tennhanvien = txtTenNV.getText().trim();
        String sdt = txtSdt.getText().trim();
        LocalDate localDate = dtpNgaySinh.getDate();
        String quequan = txtQueQuan.getText().trim();
        String gioitinh = radNam.isSelected() ? "Nam" : "Nữ";

        // Kiểm tra tên nhân viên
        if (!isValidName(tennhanvien)) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra số điện thoại
        if (!isValidPhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! Phải bắt đầu bằng 0 và có đúng 10 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra trùng lặp số điện thoại
        if (nhanvienDAO.isDuplicatePhone(sdt, 0)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidBirthDate(localDate)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ! Nhân viên phải đủ 18 tuổi (sinh trước hoặc trong năm 2007).", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra quê quán
        if (!isValidAddress(quequan)) {
            JOptionPane.showMessageDialog(this, "Quê quán không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        NhanVien nv = new NhanVien();
        nv.setTennhanvien(tennhanvien);
        nv.setSdt(sdt);
        nv.setNgaysinh(localDate != null ? Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null);
        nv.setQuequan(quequan);
        nv.setGioitinh(gioitinh);

        if (nhanvienDAO.addNV(nv)) {
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
            loadTableData();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi thêm nhân viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void updateNV() {
    int row = tableNv.getSelectedRow();
    if (row < 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên để sửa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        String tennhanvien = txtTenNV.getText().trim();
        String sdt = txtSdt.getText().trim();
        LocalDate localDate = dtpNgaySinh.getDate();
        String quequan = txtQueQuan.getText().trim();
        String gioitinh = radNam.isSelected() ? "Nam" : "Nữ";
        int manhanvien = Integer.parseInt(tableNv.getValueAt(row, 0).toString());

        // Kiểm tra tên nhân viên
        if (!isValidName(tennhanvien)) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra số điện thoại
        if (!isValidPhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! Phải bắt đầu bằng 0 và có đúng 10 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra trùng lặp số điện thoại
        if (nhanvienDAO.isDuplicatePhone(sdt, manhanvien)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidBirthDate(localDate)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ! Nhân viên phải đủ 18 tuổi.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra quê quán
        if (!isValidAddress(quequan)) {
            JOptionPane.showMessageDialog(this, "Quê quán không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        NhanVien nv = new NhanVien();
        nv.setManhanvien(manhanvien);
        nv.setTennhanvien(tennhanvien);
        nv.setSdt(sdt);
        nv.setNgaysinh(localDate != null ? Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null);
        nv.setQuequan(quequan);
        nv.setGioitinh(gioitinh);

        if (nhanvienDAO.updateNV(nv)) {
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công!");
            loadTableData();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi sửa nhân viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

    private void deleteNV() {
        int row = tableNv.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int manv = Integer.parseInt(tableNv.getValueAt(row, 0).toString());
                if (nhanvienDAO.deleteNV(manv)) {
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
                    loadTableData();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa nhân viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
        private void searchNV() {
        try {
            String searchText = txtTimKiem.getText().trim();
            String searchCriteria = (String) cbTimKiem.getSelectedItem();

            List<NhanVien> nvList = nhanvienDAO.getAllNhanVien();
            DefaultTableModel model = (DefaultTableModel) tableNv.getModel();
            model.setRowCount(0);

            for (NhanVien nv : nvList) {
                boolean match = false;

                // Kiểm tra tiêu chí tìm kiếm
                if (searchCriteria.equals("Mã nhân viên") && !searchText.isEmpty()) {
                    match = String.valueOf(nv.getManhanvien()).contains(searchText);
                } else if (searchCriteria.equals("Tên độc giả") && !searchText.isEmpty()) {
                    match = nv.getTennhanvien().toLowerCase().contains(searchText.toLowerCase());
                } else if (searchText.isEmpty()) {
                    match = true; // Hiển thị tất cả nếu không có từ khóa
                }

                if (match) {
                    model.addRow(new Object[]{
                        nv.getManhanvien(),
                        nv.getTennhanvien(),
                        nv.getSdt(),
                        nv.getNgaysinh(),
                        nv.getQuequan()
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm nhân viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void clearFields() {
        txtTenNV.setText("");
        txtSdt.setText("");
        txtQueQuan.setText(""); 
    }
    
    
    private boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 100) {
            return false;
    }
    // Chỉ cho phép chữ cái (tiếng Việt), số và khoảng trắng
        return name.matches("^[a-zA-Z0-9À-ỹ\\s]+$");
}

    private boolean isValidAddress(String address) {
        if (address == null || address.trim().isEmpty() || address.length() > 200) {
            return false;
    }
    // Cho phép chữ cái (tiếng Việt), số, khoảng trắng, dấu phẩy, gạch chéo, gạch ngang
    return address.matches("^[a-zA-Z0-9À-ỹ\\s,/-]+$");
}

    private boolean isValidBirthDate(LocalDate date) {
        if (date == null) {
        return false;
    }
    // Kiểm tra nhân viên đủ 18 tuổi (năm hiện tại - năm sinh >= 18)
    int currentYear = LocalDate.now().getYear();
    return (currentYear - date.getYear()) >= 18;
}
    
    private boolean isValidPhoneNumber(String sdt) {
        // Kiểm tra số điện thoại: bắt đầu bằng 0, chỉ chứa số, độ dài 10
        if (sdt == null || sdt.trim().isEmpty()) {
            return false;
        }
        if (!sdt.matches("0[0-9]{9}")) {
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DiaChi;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel SoDienThoai;
    private javax.swing.JLabel SoDienThoai1;
    private javax.swing.JLabel TenDG;
    private javax.swing.JLabel TimKiem;
    private javax.swing.JButton btnNhapDuLieu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatDuLieu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbTimKiem;
    private com.github.lgooddatepicker.components.DatePicker dtpNgaySinh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelInfor;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tableNv;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

