import java.awt.*;
import javax.swing.*;

public class PaintPanel2 extends JPanel
{
	String pictName;

	public PaintPanel2(String pict)
	{
		pictName = pict;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Image img = Toolkit.getDefaultToolkit().getImage(pictName);
		g.drawImage(img,-1200,-1350,this);
	}
}