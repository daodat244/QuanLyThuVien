package View.ChucNang;

import UI.BasePanel;
import Model.DAO.*;
import Model.Sach;
import Model.DocGia;
import Model.NhanVien; // Giả sử có lớp này
import Model.PhieuMuon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author TUF
 */
public class PanelPhieuMuon extends BasePanel {

    private PhieuMuonDAO phieuMuonDAO = new PhieuMuonDAO();
    private DocGiaDAO docGiaDAO = new DocGiaDAO();
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private SachDAO sachDAO = new SachDAO();

    /**
     * Creates new form PanelPhieuMuon
     */
    public PanelPhieuMuon() {
        initComponents();
        loadTableData();
        styleButton(btnThem);
        styleButton(btnSua);
        styleButton(btnXoa);
        styleButton(btnKiemtra1);
        styleButton(btnKiemtra2);
        styleButton(btnKiemtra3);
        styleTable(tablePhieuMuon);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        tablePhieuMuon.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof LocalDateTime) {
                    setText(((LocalDateTime) value).format(formatter));
                } else {
                    super.setValue(value);
                }
            }
        });
        tablePhieuMuon.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof LocalDateTime) {
                    setText(((LocalDateTime) value).format(formatter));
                } else {
                    super.setValue(value);
                }
            }
        });
        tablePhieuMuon.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                setText(value != null ? value.toString() : "Chưa xác định");
                setHorizontalAlignment(CENTER); // Căn giữa văn bản
            }

        });
        tablePhieuMuon.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tablePhieuMuon.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        int maphieu = (int) tablePhieuMuon.getValueAt(selectedRow, 0);
                        String tendocgia = (String) tablePhieuMuon.getValueAt(selectedRow, 1);
                        String tennv = (String) tablePhieuMuon.getValueAt(selectedRow, 2);
                        String tensach = (String) tablePhieuMuon.getValueAt(selectedRow, 3);
                        LocalDateTime ngaymuon = (LocalDateTime) tablePhieuMuon.getValueAt(selectedRow, 4);
                        LocalDateTime ngaytra = (LocalDateTime) tablePhieuMuon.getValueAt(selectedRow, 5);

                        int madocgia = getMaDocGiaByTen(tendocgia);
                        int manv = getMaNhanVienByTen(tennv);
                        String masach = getMaSachByTen(tensach);

                        txtMaSach.setText(masach != null ? masach : "");
                        txtMaDocGia.setText(madocgia != -1 ? String.valueOf(madocgia) : "");
                        txtManhanvien.setText(manv != -1 ? String.valueOf(manv) : "");
                        tbltensach.setText("Tên sách: " + (tensach.equals("Không xác định") ? "" : tensach));
                        tbltendocgia.setText("Tên độc giả: " + (tendocgia.equals("Không xác định") ? "" : tendocgia));
                        tbltennv.setText("Tên nhân viên: " + (tennv.equals("Không xác định") ? "" : tennv));

                        if (ngaymuon != null) {
                            date.setDateTimePermissive(ngaymuon); // Cập nhật ngày mượn vào date
                        } else {
                            date.clear();
                        }
                        if (ngaytra != null) {
                            date1.setDateTimePermissive(ngaytra); // Cập nhật ngày hẹn trả vào date1
                        } else {
                            date1.clear();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi khi lấy thông tin phiếu mượn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassCastException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi kiểu dữ liệu ngày mượn hoặc ngày trả: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        txtTimKiem.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                searchPhieuMuon();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                searchPhieuMuon();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                searchPhieuMuon();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieuMuon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtMaSach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaDocGia = new javax.swing.JTextField();
        btnKiemtra1 = new javax.swing.JButton();
        btnKiemtra2 = new javax.swing.JButton();
        tbltensach = new javax.swing.JLabel();
        tbltendocgia = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtManhanvien = new javax.swing.JTextField();
        btnKiemtra3 = new javax.swing.JButton();
        tbltennv = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel1 = new javax.swing.JLabel();
        date1 = new com.github.lgooddatepicker.components.DateTimePicker();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        btnnhapdulieu = new javax.swing.JButton();
        btnxuatdulieu = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1120, 666));
        setMinimumSize(new java.awt.Dimension(1120, 666));
        setPreferredSize(new java.awt.Dimension(1120, 666));

        tablePhieuMuon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        tablePhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu", "Tên độc giả", "Tên nhân viên", "Tên sách", "Ngày mượn", "Ngày hẹn trả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePhieuMuon);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        btnXoa.setText("Xóa phiếu mượn");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa phiếu mượn");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm phiếu mượn");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel2.setText("Mã sách : ");

        jLabel4.setText("Mã độc giả :");

        btnKiemtra1.setText("KIỂM TRA");
        btnKiemtra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemtra1ActionPerformed(evt);
            }
        });

        btnKiemtra2.setText("KIỂM TRA");
        btnKiemtra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemtra2ActionPerformed(evt);
            }
        });

        tbltensach.setText("Tên sách :");

        tbltendocgia.setText("Tên độc giả :");

        jLabel5.setText("Mã nhân viên :");

        btnKiemtra3.setText("KIỂM TRA");
        btnKiemtra3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemtra3ActionPerformed(evt);
            }
        });

        tbltennv.setText("Tên nhân viên :");

        jLabel3.setText("Ngày hẹn trả : ");

        jLabel1.setText("Ngày mượn :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbltennv)
                    .addComponent(tbltensach)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKiemtra1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbltendocgia))
                        .addGap(18, 18, 18)
                        .addComponent(btnKiemtra3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKiemtra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtra1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbltensach)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtra2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(tbltendocgia)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemtra3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbltennv)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu", "Tên sinh viên", "Tên nhân viên", "Tên sách" }));
        cbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemActionPerformed(evt);
            }
        });

        btnnhapdulieu.setText("Nhập dữ liệu");
        btnnhapdulieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhapdulieuActionPerformed(evt);
            }
        });

        btnxuatdulieu.setText("Xuất dữ liệu");
        btnxuatdulieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatdulieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnhapdulieu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnxuatdulieu)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnhapdulieu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxuatdulieu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        searchPhieuMuon();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addPhieuMuon();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        updatePhieuMuon();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        deletePhieuMuon();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnKiemtra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemtra1ActionPerformed
        try {
            String masach = txtMaSach.getText().trim();
            String tensach = getTenSach(masach);
            if (tensach != null) {
                tbltensach.setText("Tên sách: " + tensach);
            } else {
                tbltensach.setText("Tên sách: Không tìm thấy");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã sách phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi kiểm tra mã sách: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnKiemtra1ActionPerformed

    private void btnKiemtra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemtra2ActionPerformed
        try {
            int madocgia = Integer.parseInt(txtMaDocGia.getText().trim());
            String tendocgia = getTenDocGia(madocgia);
            if (tendocgia != null) {
                tbltendocgia.setText("Tên độc giả: " + tendocgia);
            } else {
                tbltendocgia.setText("Tên độc giả: Không tìm thấy");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã độc giả phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi kiểm tra mã độc giả: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnKiemtra2ActionPerformed

    private void btnKiemtra3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemtra3ActionPerformed
        try {
            String manvText = txtManhanvien.getText().trim();
            if (manvText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int manv = Integer.parseInt(manvText);
            String tennv = getTenNhanVien(manv);
            if (tennv != null) {
                tbltennv.setText("Tên nhân viên: " + tennv);
            } else {
                tbltennv.setText("Tên nhân viên: Không tìm thấy");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException ex) {
            String errorMessage = ex.getMessage() != null ? ex.getMessage() : "Không có thông tin lỗi cụ thể";
            JOptionPane.showMessageDialog(this, "Lỗi khi kiểm tra mã nhân viên: " + errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(PanelPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKiemtra3ActionPerformed

    private void cbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKiemActionPerformed

    }//GEN-LAST:event_cbTimKiemActionPerformed

    private void btnnhapdulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhapdulieuActionPerformed
        importFromExcel();
    }//GEN-LAST:event_btnnhapdulieuActionPerformed

    private void btnxuatdulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatdulieuActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
        fileChooser.setSelectedFile(new File("danh_sach_phieu_muon.xlsx"));
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
                Sheet sheet = workbook.createSheet("DanhSachPhieuMuon");

                // Tạo dòng tiêu đề
                Row headerRow = sheet.createRow(0);
                String[] headers = new String[]{"Mã Phiếu", "Tên độc giả", "Tên nhân viên", "Tên sách", "Ngày mượn", "Ngày hẹn trả", "Trạng thái"};
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                }

                // Định dạng ngày giờ
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                // Ghi dữ liệu từ bảng
                DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    row.createCell(0).setCellValue((int) model.getValueAt(i, 0)); // Mã phiếu
                    row.createCell(1).setCellValue((String) model.getValueAt(i, 1)); // Tên độc giả
                    row.createCell(2).setCellValue((String) model.getValueAt(i, 2)); // Tên nhân viên
                    row.createCell(3).setCellValue((String) model.getValueAt(i, 3)); // Tên sách
                    LocalDateTime ngayMuon = (LocalDateTime) model.getValueAt(i, 4); // Ngày mượn
                    row.createCell(4).setCellValue(ngayMuon != null ? ngayMuon.format(formatter) : "");
                    LocalDateTime ngayTraDuKien = (LocalDateTime) model.getValueAt(i, 5); // Ngày hẹn trả
                    row.createCell(5).setCellValue(ngayTraDuKien != null ? ngayTraDuKien.format(formatter) : "");
                    row.createCell(6).setCellValue((String) model.getValueAt(i, 6)); // Trạng thái
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

    }//GEN-LAST:event_btnxuatdulieuActionPerformed
    public void loadTableData() {
        try {
            List<PhieuMuon> phieuMuonList = phieuMuonDAO.getAllPhieuMuonWithDetails();
            DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
            model.setRowCount(0);
            for (PhieuMuon pm : phieuMuonList) {
                String tendocgia = getTenDocGia(pm.getMadocgia());
                String tennv = getTenNhanVien(pm.getManv());
                String tensach = getTenSach(pm.getMasach()); // masach là String
                model.addRow(new Object[]{
                    pm.getMaphieu(),
                    tendocgia != null ? tendocgia : "Không xác định",
                    tennv != null ? tennv : "Không xác định",
                    tensach != null ? tensach : "Không xác định",
                    pm.getNgaymuon(),
                    pm.getNgayTraDuKien(),
                    pm.getTrangthai() != null ? pm.getTrangthai() : "Chưa xác định"
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu phiếu mượn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPhieuMuon() {
        try {
            String maSachText = txtMaSach.getText().trim();
            String maDocGiaText = txtMaDocGia.getText().trim();
            String maNhanVienText = txtManhanvien.getText().trim();
            LocalDateTime ngayMuon = date.getDateTimePermissive();
            LocalDateTime ngayTraDuKien = date1.getDateTimePermissive();

            if (maSachText.isEmpty() || maDocGiaText.isEmpty() || maNhanVienText.isEmpty() || ngayMuon == null || ngayTraDuKien == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách, mã độc giả, mã nhân viên, chọn ngày mượn và ngày hẹn trả!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int madocgia = Integer.parseInt(maDocGiaText);
            int manv = Integer.parseInt(maNhanVienText);

            if (getTenSach(maSachText) == null) {
                JOptionPane.showMessageDialog(this, "Mã sách không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (getTenDocGia(madocgia) == null) {
                JOptionPane.showMessageDialog(this, "Mã độc giả không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (getTenNhanVien(manv) == null) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (ngayMuon.isAfter(ngayTraDuKien)) {
                JOptionPane.showMessageDialog(this, "Ngày mượn không được sau ngày hẹn trả!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Kiểm tra số lượng sách còn không
            Sach sach = sachDAO.getSachById(maSachText);
            if (sach.getSoluong() <= 0) {
                JOptionPane.showMessageDialog(this, "Sách này đã hết hàng!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            PhieuMuon pm = new PhieuMuon();
            pm.setMadocgia(madocgia);
            pm.setManv(manv);
            pm.setMasach(maSachText);
            pm.setNgaymuon(ngayMuon);
            pm.setNgayTraDuKien(ngayTraDuKien);

            if (phieuMuonDAO.addPhieuMuon(pm)) {
                // Giảm số lượng sách sau khi thêm phiếu thành công
                if (sachDAO.giamSoLuongSach(maSachText)) {
                    JOptionPane.showMessageDialog(this, "Thêm phiếu mượn thành công và đã cập nhật số lượng sách!");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm phiếu mượn thành công nhưng không thể cập nhật số lượng sách!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                }
                loadTableData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm phiếu mượn thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã sách, mã độc giả và mã nhân viên phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm phiếu mượn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePhieuMuon() {
        int row = tablePhieuMuon.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu mượn để sửa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String maSachText = txtMaSach.getText().trim();
            String maDocGiaText = txtMaDocGia.getText().trim();
            String maNhanVienText = txtManhanvien.getText().trim();
            LocalDateTime ngayMuon = date.getDateTimePermissive();
            LocalDateTime ngayTraDuKien = date1.getDateTimePermissive();

            if (maSachText.isEmpty() || maDocGiaText.isEmpty() || maNhanVienText.isEmpty() || ngayMuon == null || ngayTraDuKien == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách, mã độc giả, mã nhân viên, chọn ngày mượn và ngày hẹn trả!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int madocgia = Integer.parseInt(maDocGiaText);
            int manv = Integer.parseInt(maNhanVienText);
            int maphieu = (int) tablePhieuMuon.getValueAt(row, 0);

            if (getTenSach(maSachText) == null) {
                JOptionPane.showMessageDialog(this, "Mã sách không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (getTenDocGia(madocgia) == null) {
                JOptionPane.showMessageDialog(this, "Mã độc giả không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (getTenNhanVien(manv) == null) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (ngayMuon.isAfter(ngayTraDuKien)) {
                JOptionPane.showMessageDialog(this, "Ngày mượn không được sau ngày hẹn trả!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            PhieuMuon pm = new PhieuMuon();
            pm.setMaphieu(maphieu);
            pm.setMadocgia(madocgia);
            pm.setManv(manv);
            pm.setMasach(maSachText);
            pm.setNgaymuon(ngayMuon);
            pm.setNgayTraDuKien(ngayTraDuKien);

            if (phieuMuonDAO.updatePhieuMuon(pm)) {
                JOptionPane.showMessageDialog(this, "Sửa phiếu mượn thành công!");
                loadTableData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa phiếu mượn thất bại! Vui lòng kiểm tra lại dữ liệu hoặc kết nối cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã sách, mã độc giả và mã nhân viên phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa phiếu mượn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi không xác định: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void deletePhieuMuon() {
        int row = tablePhieuMuon.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu mượn để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phiếu mượn này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int maphieu = (int) tablePhieuMuon.getValueAt(row, 0);
                if (phieuMuonDAO.deletePhieuMuon(maphieu)) {
                    JOptionPane.showMessageDialog(this, "Xóa phiếu mượn thành công!");
                    loadTableData();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa phiếu mượn thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa phiếu mượn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void searchPhieuMuon() {
        try {
            String searchText = txtTimKiem.getText().trim();
            String searchCriteria = (String) cbTimKiem.getSelectedItem();

            List<PhieuMuon> phieuMuonList = phieuMuonDAO.getAllPhieuMuonWithDetails();
            DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
            model.setRowCount(0);

            for (PhieuMuon pm : phieuMuonList) {
                boolean match = false;
                String tendocgia = getTenDocGia(pm.getMadocgia());
                String tennv = getTenNhanVien(pm.getManv());
                String tensach = getTenSach(pm.getMasach());

                // Kiểm tra tiêu chí tìm kiếm
                if (searchCriteria.equals("Mã phiếu") && !searchText.isEmpty()) {
                    match = String.valueOf(pm.getMaphieu()).contains(searchText);
                } else if (searchCriteria.equals("Tên sinh viên") && !searchText.isEmpty()) {
                    match = tendocgia.toLowerCase().contains(searchText.toLowerCase());
                } else if (searchCriteria.equals("Tên nhân viên") && !searchText.isEmpty()) {
                    match = tennv.toLowerCase().contains(searchText.toLowerCase());
                } else if (searchCriteria.equals("Tên sách") && !searchText.isEmpty()) {
                    match = tensach.toLowerCase().contains(searchText.toLowerCase());
                } else if (searchText.isEmpty()) {
                    match = true; // Hiển thị tất cả nếu không có từ khóa
                }

                if (match) {
                    model.addRow(new Object[]{
                        pm.getMaphieu(),
                        tendocgia,
                        tennv,
                        tensach,
                        pm.getNgaymuon(),
                        pm.getNgayTraDuKien(),
                        pm.getTrangthai()
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm phiếu mượn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void importFromExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn file Excel để nhập dữ liệu phiếu mượn");
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

                Sheet sheet = workbook.getSheet("DanhSachPhieuMuon");
                if (sheet == null) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy sheet 'DanhSachPhieuMuon' trong file Excel!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int successCount = 0;
                int duplicateCount = 0;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        continue;
                    }

                    try {
                        int madocgia = (int) row.getCell(0).getNumericCellValue();
                        int manv = (int) row.getCell(1).getNumericCellValue();
                        String masach = row.getCell(2).getStringCellValue();
                        String ngaymuonStr = row.getCell(3).getStringCellValue();
                        String ngaytradukienStr = row.getCell(4).getStringCellValue();
                        String trangthai = row.getCell(5).getStringCellValue();

                        LocalDateTime ngaymuon = LocalDateTime.parse(ngaymuonStr, formatter);
                        LocalDateTime ngaytradukien = LocalDateTime.parse(ngaytradukienStr, formatter);

                        // Kiểm tra dữ liệu hợp lệ
                        if (madocgia <= 0 || manv <= 0 || masach.isEmpty() || ngaymuon == null || ngaytradukien == null) {
                            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ tại dòng " + (i + 1), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }

                        // Kiểm tra mã tồn tại
                        if (docGiaDAO.getDocGiaById(madocgia) == null) {
                            JOptionPane.showMessageDialog(this, "Mã độc giả " + madocgia + " tại dòng " + (i + 1) + " không tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }

                        if (nhanVienDAO.getNhanVienById(manv) == null) {
                            JOptionPane.showMessageDialog(this, "Mã nhân viên " + manv + " tại dòng " + (i + 1) + " không tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }

                        if (sachDAO.getSachById(masach) == null) {
                            JOptionPane.showMessageDialog(this, "Mã sách " + masach + " tại dòng " + (i + 1) + " không tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }

                        // Kiểm tra trùng
                        if (phieuMuonDAO.isPhieuMuonExists(madocgia, masach, ngaymuon)) {
                            duplicateCount++;
                            JOptionPane.showMessageDialog(this, "Phiếu mượn tại dòng " + (i + 1) + " đã tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                            continue;
                        }

                        // Tạo đối tượng và thêm vào DB
                        PhieuMuon pm = new PhieuMuon();
                        pm.setMadocgia(madocgia);
                        pm.setManv(manv);
                        pm.setMasach(masach);
                        pm.setNgaymuon(ngaymuon);
                        pm.setNgaytradukien(ngaytradukien);
                        pm.setTrangthai(trangthai);

                        if (phieuMuonDAO.addPhieuMuon(pm)) {
                            successCount++;
                        } else {
                            JOptionPane.showMessageDialog(this, "Không thể thêm phiếu mượn tại dòng " + (i + 1), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi tại dòng " + (i + 1) + ": " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }

                loadTableData(); // Cập nhật lại bảng
                String message = "Đã nhập thành công " + successCount + " phiếu mượn!";
                if (duplicateCount > 0) {
                    message += "\n" + duplicateCount + " phiếu mượn bị bỏ qua do trùng dữ liệu.";
                }
                JOptionPane.showMessageDialog(this, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String getTenDocGia(int madocgia) throws SQLException {
        DocGia docGia = docGiaDAO.getDocGiaById(madocgia);
        return docGia != null ? docGia.getTendocgia() : null;
    }

    private String getTenNhanVien(int manv) throws SQLException {
        NhanVien nv = nhanVienDAO.getNhanVienById(manv);
        return nv != null ? nv.getTennv() : null;
    }

    private String getTenSach(String masach) throws SQLException {
        Sach sach = sachDAO.getSachById(masach);
        return sach != null ? sach.getTensach() : null;
    }

    private int getMaDocGiaByTen(String tenDocGia) throws SQLException {
        if (tenDocGia.equals("Không xác định")) {
            return -1;
        }
        return docGiaDAO.getMaDocGiaByTen(tenDocGia);
    }

    private int getMaNhanVienByTen(String tenNhanVien) throws SQLException {
        if (tenNhanVien.equals("Không xác định")) {
            return -1;
        }
        return nhanVienDAO.getMaNhanVienByTen(tenNhanVien);
    }

    private String getMaSachByTen(String tenSach) throws SQLException {
        if (tenSach.equals("Không xác định")) {
            return null;
        }
        return sachDAO.getMaSachByTen(tenSach);
    }

    private void clearFields() {
        txtMaSach.setText("");
        txtMaDocGia.setText("");
        date.clear();
        date1.clear();
        txtManhanvien.setText("");
        tbltensach.setText("Tên sách: ");
        tbltendocgia.setText("Tên độc giả: ");
        tbltennv.setText("Tên nhân viên: ");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKiemtra1;
    private javax.swing.JButton btnKiemtra2;
    private javax.swing.JButton btnKiemtra3;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnnhapdulieu;
    private javax.swing.JButton btnxuatdulieu;
    private javax.swing.JComboBox<String> cbTimKiem;
    private com.github.lgooddatepicker.components.DateTimePicker date;
    private com.github.lgooddatepicker.components.DateTimePicker date1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePhieuMuon;
    private javax.swing.JLabel tbltendocgia;
    private javax.swing.JLabel tbltennv;
    private javax.swing.JLabel tbltensach;
    private javax.swing.JTextField txtMaDocGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtManhanvien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
