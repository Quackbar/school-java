//	SchoolSplash.java
//	B.Kintzing
//	9/17/14

import java.awt.*;
import java.applet.*;

public class SchoolSplash extends Applet
{
	Font SchoolSplash = new Font("Lucida Bright", Font.BOLD, 36);
	Image RealSaltLake;

	public void init()
	{
		setBackground(new Color (177, 181, 181));
		setFont(SchoolSplash);

	}

	public void paint(Graphics g)
	{
		g.setColor(new Color(97,4,4));
		g.drawString("Helena High School",300,100);
		g.drawString("http://www.helena.k12.mt.us",230,200);
		g.drawString("1300 Billings Ave, Helena, Mt 59601",180,500);
		RealSaltLake = getImage(getDocumentBase(),"HHSLogo.png");
		g.drawImage(RealSaltLake,435,300,this);
	}
}