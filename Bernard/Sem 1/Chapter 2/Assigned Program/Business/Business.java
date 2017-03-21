/*
	Business Splash
	B.Kintzing
	9/19/14
*/

import java.awt.*;
import java.applet.Applet;


public class Business extends Applet
    {
		Font BusinessSplash = new Font("Lucida Bright", Font.PLAIN, 100); //Work at google. make notes for test
		Font Bernard = new Font("Lucida Bright", Font.PLAIN, 25);
		Image BusinessLogo;

		public void init()
		{
			setBackground (new Color (255,255,255));
			setFont(BusinessSplash);
		}

		public void paint(Graphics g)
		{
			resize(1000,1000);
			g.setColor(new Color(0,0,204));
			g.drawString("G",200,100);
			g.setColor(new Color(204,0,0));
			g.drawString("o",270,100);
			g.setColor(new Color(231,246,18));
			g.drawString("o",325,100);
			g.setColor(new Color(0,0,204));
			g.drawString("g",380,100);
			g.setColor(new Color(0,204,0));
			g.drawString("l",440,100);
			g.setColor(new Color(204,0,0));
			g.drawString("e",470,100);
			g.setColor(new Color(0,0,0));
			g.setFont(Bernard);
			g.drawString("Bernard Kintzing",150,175);
			g.drawString("1600 Amphitheatre Parkway Mountain View, CA 94043",150,225);
			g.drawString("Phone: +1 650-253-0000",150,275);
			Image Google = getImage(getDocumentBase(),"Google.png"); //save the logo of google through fireworks
			g.drawImage(Google,150,290,this);
		}

}