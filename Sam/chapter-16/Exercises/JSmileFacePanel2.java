/**
 * Created by bernard on 4/14/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSmileFacePanel2 extends JPanel implements ActionListener{

    boolean happy = true;
    JButton button = new JButton("Change Mood");

    public JSmileFacePanel2() {
        this.setBackground(Color.WHITE);
        this.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(happy)
            happy = false;
        else
            happy = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(happy){
            g.setColor(Color.YELLOW);
            g.fillOval(50, 50, 200, 200);
            g.setColor(Color.GREEN);
            g.fillOval(120, 100, 30, 30);
            g.fillOval(160, 100, 30, 30);
            g.setColor(Color.PINK);
            g.fillArc(100, 150, 110, 40, 0, -180);
        }
        else{
            g.setColor(Color.RED);
            g.fillOval(50, 50, 200, 200);
            g.setColor(Color.GREEN);
            g.fillOval(120, 100, 30, 30);
            g.fillOval(160, 100, 30, 30);
            g.setColor(Color.PINK);
            g.fillArc(100, 150, 110, 40, 0, 180);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new JSmileFacePanel2());
        f.setVisible(true);
        f.setSize(300, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
