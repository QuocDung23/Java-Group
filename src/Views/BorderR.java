/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class BorderR extends JPanel{
    private int cornerRadius = 30; // Độ bo tròn (bạn có thể sửa số này)

    public BorderR(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false); // Quan trọng: Để nền trong suốt, không bị đè bởi hình chữ nhật gốc
    }
    
    // Constructor mặc định cho NetBeans dễ kéo thả
    public BorderR() {
        super();
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Bật khử răng cưa để đường bo tròn mượt mà hơn
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Lấy màu nền hiện tại của Panel
        g2.setColor(getBackground());
        
        // Vẽ hình chữ nhật bo tròn full kích thước panel
        // fillRoundRect(x, y, width, height, arcWidth, arcHeight)
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        
        super.paintComponent(g);
    }
}
