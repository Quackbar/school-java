/*
	Bernard.K
	Freddie's Fast Food
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Freddie extends Applet implements ActionListener
{
	FreddieFrame panel = new FreddieFrame();
	PaintPanel2 eastPhotoPanel = new PaintPanel2("burger.jpg");
	PaintPanel1 westPhotoPanel = new PaintPanel1("burger.jpg");

		public void init()
		{
			this.setLayout(new GridLayout(3,1));

			add(westPhotoPanel);
			add(panel);
			add(eastPhotoPanel);
		}

		public void actionPerformed(ActionEvent blank)
		{
		}
}