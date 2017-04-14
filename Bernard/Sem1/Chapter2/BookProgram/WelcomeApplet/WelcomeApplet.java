/*
	Chapter 2: Welcome to My Day
	Programmer: B. Kintzing
	Date: 9/7/14
	Filename: WelcomeApplet.java
	Purpose: This project displays a welcome message, the user's name, the system date, and an image in an applet.
*/

import java.util.Date;
import java.awt.*;
import java.applet.*;

public class WelcomeApplet extends Applet
{
	public void paint(Graphics g)
	{
		resize(1000,1000);
		Date currentDate = new Date(); //Date Constructor
		g.drawString("Welcome to my day!", 500,70);
		g.drawString("Daily Planner for Bernard",500,100);
		g.drawString(currentDate.toString(),500,130);
		Image smile; //declare an Image object
		smile = getImage(getDocumentBase(),"smile.png");
		g.drawImage(smile,20,20,this);
		setBackground(Color.blue);
		setForeground(Color.yellow);
	}
}
