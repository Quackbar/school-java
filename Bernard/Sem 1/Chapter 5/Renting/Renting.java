import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Renting extends Applet implements ActionListener
{
	RentingFrame frame = new RentingFrame();
	public Renting()
	{
		add(frame);
		}
		public void paint(Graphics g)
		{
			Color blue = new Color(22, 148, 148);
			setBackground(blue);
			resize(900,300);
		}

	public void actionPerformed(ActionEvent blank)
	{
	}
}