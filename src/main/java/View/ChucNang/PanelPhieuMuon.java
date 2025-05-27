
package View.ChucNang;

import UI.BasePanel;
import Model.DAO.*;
import Model.Sach;
import Model.DocGia;
import Model.NhanVien; // Giả sử có lớp này
import Model.PhieuMuon;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
        styleButton(btnLammoi);
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
                        int masach = getMaSachByTen(tensach);

                        txtMaSach.setText(masach != -1 ? String.valueOf(masach) : "");
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
            public void insertUpdate(javax.swing.event.DocumentEvent e) { searchPhieuMuon(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { searchPhieuMuon(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { searchPhieuMuon(); }
        });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieuMuon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
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

        btnLammoi.setText("Làm mới bảng");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(198, 198, 198))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            int masach = Integer.parseInt(txtMaSach.getText().trim());
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

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
loadTableData();
    }//GEN-LAST:event_btnLammoiActionPerformed
    private void loadTableData() {
    try {
        List<PhieuMuon> phieuMuonList = phieuMuonDAO.getAllPhieuMuonWithDetails();
        DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
        model.setRowCount(0);
        for (PhieuMuon pm : phieuMuonList) {
            String tendocgia = getTenDocGia(pm.getMadocgia());
            String tennv = getTenNhanVien(pm.getManv());
            String tensach = getTenSach(pm.getMasach());
            model.addRow(new Object[]{
                pm.getMaphieu(),
                tendocgia != null ? tendocgia : "Không xác định",
                tennv != null ? tennv : "Không xác định",
                tensach != null ? tensach : "Không xác định",
                pm.getNgaymuon(),
                pm.getNgayTraDuKien(),
                pm.getTrangthai() != null ? pm.getTrangthai() : "Chưa xác định" // Thêm cột trạng thái
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

            int masach = Integer.parseInt(maSachText);
            int madocgia = Integer.parseInt(maDocGiaText);
            int manv = Integer.parseInt(maNhanVienText);

            if (getTenSach(masach) == null) {
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
            pm.setMadocgia(madocgia);
            pm.setManv(manv);
            pm.setMasach(masach);
            pm.setNgaymuon(ngayMuon);
            pm.setNgayTraDuKien(ngayTraDuKien);

            if (phieuMuonDAO.addPhieuMuon(pm)) {
                JOptionPane.showMessageDialog(this, "Thêm phiếu mượn thành công!");
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

            int masach = Integer.parseInt(maSachText);
            int madocgia = Integer.parseInt(maDocGiaText);
            int manv = Integer.parseInt(maNhanVienText);
            int maphieu = (int) tablePhieuMuon.getValueAt(row, 0);

            if (getTenSach(masach) == null) {
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
            pm.setMasach(masach);
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
                } else if (searchCriteria.equals("Tên độc giả") && !searchText.isEmpty()) {
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
public void refreshTableData() {
    loadTableData();
}
private String getTenDocGia(int madocgia) throws SQLException {
        DocGia docGia = docGiaDAO.getDocGiaById(madocgia);
        return docGia != null ? docGia.getTendocgia() : null;
    }

    private String getTenNhanVien(int manv) throws SQLException {
        NhanVien nv = nhanVienDAO.getNhanVienById(manv);
        return nv != null ? nv.getTennv() : null;
    }

    private String getTenSach(int masach) throws SQLException {
        Sach sach = sachDAO.getSachById(masach);
        return sach != null ? sach.getTensach() : null;
    }
    private int getMaDocGiaByTen(String tenDocGia) throws SQLException {
        if (tenDocGia.equals("Không xác định")) return -1;
        return docGiaDAO.getMaDocGiaByTen(tenDocGia);
    }

    private int getMaNhanVienByTen(String tenNhanVien) throws SQLException {
        if (tenNhanVien.equals("Không xác định")) return -1;
        return nhanVienDAO.getMaNhanVienByTen(tenNhanVien);
    }

    private int getMaSachByTen(String tenSach) throws SQLException {
        if (tenSach.equals("Không xác định")) return -1;
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
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
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

    private static class dateTimePicker {

        private static Object getDate() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void setDate(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public dateTimePicker() {
        }
    }
}
