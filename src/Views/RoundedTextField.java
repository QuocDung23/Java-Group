/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author admin
 */
public class RoundedTextField extends JTextField{
    public RoundedTextField() {
        super();
        setOpaque(false); // Làm nền trong suốt để vẽ bo tròn
        // Tạo khoảng cách (padding) bên trong để chữ không bị dính sát vào mép cong
        setBorder(new EmptyBorder(5, 15, 5, 15)); 
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setText(""); 
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 1. Vẽ màu nền bên trong (Màu trắng)
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        
        // 2. Vẽ cái viền (Border) - ĐÂY LÀ PHẦN BẠN CẦN THÊM
        g2.setColor(new Color(200, 200, 200)); // Màu viền xám nhạt
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        
        // 3. Gọi lệnh vẽ chữ của Java
        super.paintComponent(g);
        g2.dispose();
    }
}
