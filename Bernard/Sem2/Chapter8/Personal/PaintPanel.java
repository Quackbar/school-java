import java.util.ArrayList;
import java.awt.*;
import java.awt.Robot.*;
import javax.swing.*;

public class PaintPanel extends JPanel
{
    static int redH;
    static int redV;
    static int initialRedH;
    static int initialRedV;

    static ArrayList<Integer> hStart = new ArrayList<Integer>();
    static ArrayList<Integer> vStart = new ArrayList<Integer>();
    static ArrayList<Integer> hEnd = new ArrayList<Integer>();
    static ArrayList<Integer> vEnd = new ArrayList<Integer>();

    Color col;
    Color otherColor1 = new Color(0,0,0);

    public PaintPanel(int h, int v)
    {
        redH = h;
        redV = v;
        initialRedH = h;
        initialRedV = v;
    }

    public void paintComponent(Graphics g)
    {
        try
        {
            Robot robot = new Robot();
            col = robot.getPixelColor(redH, redV);
        }
        catch (AWTException e)
        {
        }
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(3));
        g.setColor(otherColor1);
		for (int i = 0; i < hEnd.size(); i++)
		{
			g2.drawLine(hStart.get(i), vStart.get(i), hEnd.get(i), vEnd.get(i));
		}
		g2.drawLine(initialRedH, initialRedV, redH, redV);
    }
}