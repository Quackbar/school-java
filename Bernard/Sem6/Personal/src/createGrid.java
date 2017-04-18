/**
 * Created by bernard on 4/17/17.
 */
import javax.swing.*;
import java.awt.*;

public class createGrid extends JPanel{

    public createGrid(){
        this.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
        int x = 200, y = 200;
        while(x <= 1720){
            g.drawLine(x, y, x, 880);
            x += 10;
        }
        x = 200;
        while(y <= 880){
            g.drawLine(x, y, 1720, y);
            y += 10;
        }
    }

    public static void main(String[]  args){
        JFrame f = new JFrame();
        f.add(new createGrid());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1920,1080);
    }
}
