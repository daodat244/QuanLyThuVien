package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class BasePanel extends JPanel {
    public BasePanel() {
        initCommonStyle();
    }

    private void initCommonStyle() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 13));
        UIManager.put("Button.font", new Font("Segoe UI", Font.PLAIN, 14));
    }

    protected void styleButton(JButton button) {
        // Màu tím nhạt cho viền và hover
        Color lightPurple = new Color(225, 190, 231); // #E1BEE7
        Color defaultBackground = new Color(255, 255, 255); // Màu nền mặc định (xanh dương nhạt)

        // Thiết lập màu nền và chữ ban đầu
        button.setBackground(defaultBackground);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);

        // Tạo viền bo góc với màu tím nhạt
        button.setBorder(BorderFactory.createLineBorder(lightPurple, 2, true)); // Viền tím nhạt, độ dày 2, bo góc

        // Hiệu ứng hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(lightPurple); // Màu tím nhạt khi hover
                button.setForeground(Color.BLACK); // Chuyển chữ thành màu đen để dễ đọc
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultBackground); // Trở lại màu mặc định
                button.setForeground(Color.BLACK); // Chữ trắng
            }
        });
    }

    protected void styleTable(JTable table) {
        table.setBorder(BorderFactory.createLineBorder(new Color(176, 190, 197)));
        table.setBackground(new Color(245, 245, 245));
        table.setSelectionBackground(new Color(66, 165, 245));
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(176, 190, 197));
        table.getTableHeader().setForeground(Color.BLACK);
    }
}