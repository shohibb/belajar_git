package com.example.ellipsedrawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowingExample extends JFrame {

    private int x1, y1, x2, y2; // Koordinat kotak awal dan akhir
    private int windowX1, windowY1, windowX2, windowY2; // Koordinat window

    public WindowingExample() {
        setTitle("Windowing Example");
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

        // Menggambar kotak awal dan akhir
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);

        // Menggambar window
        g.setColor(Color.RED);
        g.drawRect(windowX1, windowY1, windowX2 - windowX1, windowY2 - windowY1);

        // Melakukan windowing untuk memotong kotak sesuai dengan window
        int clippedX1, clippedY1, clippedX2, clippedY2;
        if (x1 >= windowX1 && x1 <= windowX2 && y1 >= windowY1 && y1 <= windowY2) {
            clippedX1 = x1;
            clippedY1 = y1;
        } else {
            clippedX1 = Math.max(x1, windowX1);
            clippedY1 = Math.max(y1, windowY1);
        }

        if (x2 >= windowX1 && x2 <= windowX2 && y2 >= windowY1 && y2 <= windowY2) {
            clippedX2 = x2;
            clippedY2 = y2;
        } else {
            clippedX2 = Math.min(x2, windowX2);
            clippedY2 = Math.min(y2, windowY2);
        }

        // Menggambar kotak yang telah dipotong dengan windowing
        g.setColor(Color.BLUE);
        g.drawRect(clippedX1, clippedY1, clippedX2 - clippedX1, clippedY2 - clippedY1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowingExample().setVisible(true);
            }
        });
    }
}
