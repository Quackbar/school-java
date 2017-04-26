import javax.swing.*;
import java.awt.*;

public class JSmileFacePanel extends JPanel{

    public JSmileFacePanel() {
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 200, 200);
        g.setColor(Color.GREEN);
        g.fillOval(120, 100, 30, 30);
        g.fillOval(160, 100, 30, 30);
        g.setColor(Color.PINK);
        g.fillArc(100, 150, 110, 40, 0, -180);
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new JSmileFacePanel());
        f.setVisible(true);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
