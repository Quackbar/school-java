/**
 * Created by bkintzing on 10/23/2015.
 */

import java.awt.*;
import javax.swing.*;

public class PaintPanel extends JPanel{
    static int counter;
    ColorSettings currentGame;

    public PaintPanel(ColorSettings game, int guessCounter){
        currentGame = game;
        setBackground(currentGame.getDrawPanelColor());
        counter = guessCounter;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentGame.setRandomPen());
        g.drawLine(90, 60, 90, 160);
        g.drawLine(80, 160, 100, 160);
        g.drawLine(90, 60, 145, 60);
        g.drawLine(145, 60, 145, 75);

        switch (counter) {
            case 6:
                g.setColor(currentGame.setRandomPen());
                g.drawLine(148, 115, 158, 130);
                g.drawString("You Lost", 150, 150);
                //JOptionPane.showMessageDialog(null, );
            case 5:
                g.setColor(currentGame.setRandomPen());
                g.drawLine(148, 115, 138, 130);
            case 4:
                g.setColor(currentGame.setRandomPen());
                g.drawLine(148,100,163,100);
            case 3:
                g.setColor(currentGame.setRandomPen());
                g.drawLine(133,100,148,100);
            case 2:
                g.setColor(currentGame.setRandomPen());
                g.drawLine(148,90,148,115);
            case 1:
                g.setColor(currentGame.setRandomPen());
                g.drawOval(140,75,15,15);
        }

    }
}
