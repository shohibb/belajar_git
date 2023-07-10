package com.example.ellipsedrawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClippingExample extends JFrame {

    private int x1, y1, x2, y2; // Koordinat objek

    public ClippingExample() {
        setTitle("Clipping Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();

                repaint();
            }
        });

        getContentPane().addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();

                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Menggambar objek sebelum clipping
        g.setColor(Color.BLUE);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);

        // Melakukan clipping pada area yang ditentukan
        g.setClip(x1, y1, x2 - x1, y2 - y1);

        // Menggambar objek setelah clipping
        g.setColor(Color.RED);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new ClippingExample().setVisible(true));
    }
}
