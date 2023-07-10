import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EllipseDrawing extends JFrame {

    private int centerX, centerY;
    private int radiusX, radiusY;

    public EllipseDrawing() {
        setTitle("Membuat Elips dengan Mouse");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                centerX = e.getX();
                centerY = e.getY();
            }
        });

        getContentPane().addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int currentX = e.getX();
                int currentY = e.getY();

                radiusX = Math.abs(currentX - centerX) / 2;
                radiusY = Math.abs(currentY - centerY) / 2;

                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawOval(centerX, centerY, radiusX, radiusY);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EllipseDrawing().setVisible(true);
            }
        });
    }
}
