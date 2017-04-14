import java.awt.*;
import java.awt.geom.Line2D.*;
import javax.swing.*;

public class PaintPanel extends JPanel
{
    String pictName;

    public PaintPanel(String pict)
    {
        pictName = pict;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Normal Lines
        g.drawLine(19, 2, 1243, 2);
        g.drawLine(19,56,1243,56);
        g.drawLine(19,2,19,675);
        g.drawLine(19,675,1243,675);
        g.drawLine(19,108,1243,108);
        g.drawLine(1243,2,1243,675);
        g.drawLine(19,274,1243,274);
        g.drawLine(19,327,1243,327);
        g.drawLine(19,568,1243,568);
        g.drawLine(687,55,687,568);
        g.drawLine(966,55,966,568);
        g.drawLine(687,164,1243,164);
        g.drawLine(687,219,1243,219);
        g.drawLine(687,383,1243,383);
        g.drawLine(687,435,1243,435);
        g.drawLine(967,491,1243,491);
        g.drawLine(967,545,1243,545);
        g.drawLine(1048,354,1048,383);
        g.drawLine(1048,409,1048,435);
        g.drawLine(1048,463,1048,490);
        g.drawLine(1048,518,1048,545);
        g.drawLine(85, 600, 85, 625);
        g.drawLine(340, 570, 340, 675);
        g.drawLine(545, 570, 545, 675);
        g.drawLine(725, 570, 725, 675);
        g.drawLine(930, 570, 930, 675);
        g.drawLine(1108, 570, 1108, 675);
        g.drawLine(85, 650, 85, 675);

        //Bold Lines
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(277, 2, 277, 56);
        g2.drawLine(277, 56, 573, 56);
        g2.drawLine(573, 56, 573, 2);
        g2.drawLine(573,2,277,2);
        g2.drawLine(687,55,1243,55);
        g2.drawLine(687,110,1243,110);
        g2.drawLine(687,55,687,110);
        g2.drawLine(1243,55,1243,110);
        g2.drawLine(964,55,964,110);

        //Dashed Lines
        Stroke dashed = new BasicStroke(0,BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,0,new float[]{3},0);
        g2.setStroke(dashed);
        g2.drawLine(19,625,1243,625);

        //Image img = Toolkit.getDefaultToolkit().getImage(pictName);
        //g.drawImage(img,0,0,this);
    }
}