/**
 * Created by bernard on 4/14/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class JStatePanel extends JPanel{

    Font font = new Font("Serif", Font.BOLD, 150);

    public JStatePanel(){
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        GeneralPath p = new GeneralPath();
        p.moveTo(200, 200);  //Start
        p.lineTo(700, 215);  //Dip in the top
        p.lineTo(750, 215);  //Dip in the top
        p.lineTo(1300, 200); //Top right corner
        p.lineTo(1325, 750); //Bottom right corner
        p.lineTo(600, 760);  //Start of the back of the chin
        p.lineTo(600, 820);  //Chin drop
        p.lineTo(595, 820);  //Left
        p.lineTo(588, 810);  //Up and Left
        p.lineTo(588, 803);  //Up
        p.lineTo(580, 790);  //Up and Left
        p.lineTo(577, 790);  //Left
        p.lineTo(575, 807);  //Down
        p.lineTo(545, 805);  //Left
        p.lineTo(535, 807);  //Left and Down
        p.lineTo(533, 802);  //Up
        p.lineTo(515, 802);  //Left
        p.lineTo(513, 804);  //Down and Left
        p.lineTo(495, 804);  //Left
        p.lineTo(493, 802);  //Up and Left
        p.lineTo(480, 807);  //Left
        p.lineTo(473, 817);  //Down and Left
        p.lineTo(439, 810);  //Left and Up
        p.lineTo(433, 817);  //Down and Left
        p.lineTo(435, 825);  //Right and Down
        p.lineTo(430, 825);  //Left
        p.lineTo(420, 815);  //End of chin
        p.lineTo(410, 790);  //Up and Left
        p.lineTo(400, 765);  //Up
        p.lineTo(375, 760);  //Left and Up
        p.lineTo(374, 740);  //Up
        p.lineTo(376, 725);  //Up and Right
        p.lineTo(375, 725);  //Left
        p.lineTo(350, 655);  //Up and Left
        p.lineTo(350, 635);  //Up
        p.lineTo(340, 630);  //Start of nose
        p.lineTo(290, 670);  //Left and Down
        p.lineTo(270, 660);  //Up and Left
        p.lineTo(277, 640);  //Up and Right
        p.lineTo(270, 635);  //Up and Left
        p.lineTo(270, 620);  //Up
        p.lineTo(280, 617);  //Right
        p.lineTo(280, 590);  //Up
        p.lineTo(275, 590);  //Left
        p.lineTo(277, 570);  //Up
        p.lineTo(274, 560);  //Up
        p.lineTo(278, 560);  //Right
        p.lineTo(285, 530);  //Up
        p.lineTo(290, 500);  //End of nose
        p.lineTo(275, 500);  //Right
        p.lineTo(220, 390);  //Up and Left
        p.lineTo(220, 360);  //Up
        p.lineTo(200, 320);  //End
        p.closePath();
        g2D.draw(p);
        g2D.setFont(font);
        g2D.drawString("Montana", 450, 550);
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new JStatePanel());
        f.setVisible(true);
        f.setSize(1500,1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
