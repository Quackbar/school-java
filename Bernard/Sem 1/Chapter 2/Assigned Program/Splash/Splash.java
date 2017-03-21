//	Splash.java
//	B.Kintzing
//	9/12/14

import java.awt.*;
import java.applet.*;

public class Splash extends Applet
{
	Font Jokerman = new Font("Jokerman", Font.BOLD, 36);
	Image RealSaltLake;

	public void init()
	{
		setBackground(new Color (10, 16, 194));
		setForeground(new Color (194, 10, 10));
		setFont(Jokerman);
	}

	public void paint(Graphics g)
	{
		g.setColor(new Color(255,155,9));
		g.drawString("Real Salt Lake!",100,100);
		RealSaltLake = getImage(getDocumentBase(),"RealSaltLake.png");
		g.drawImage(RealSaltLake,400,300,this);
		g.setColor(Color.red);
	}
}