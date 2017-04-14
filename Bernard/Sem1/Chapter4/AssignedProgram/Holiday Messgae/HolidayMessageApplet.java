/*
	HolidayMeaasgeApplet
	Bernard.K
*/
import java.awt.*;
import java.io.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class HolidayMessageApplet extends Applet implements ActionListener
{
	int message, holidayNum;
	boolean done = (false);

	Button messageButton = new Button("Make message");
	TextField inputField = new TextField(5);
	Label promptLabel = new Label("Press 1 for Halloween 2 for Christmas and 3 for Easter");
	Label outputLabel = new Label("");
	Label introLabel = new Label("YOUR VERY OWN HOLIDAY MESSAGE THING!");

	public void init()
	{
		setBackground(new Color(100,13,20));
		setForeground(new Color(30,205,13));
		messageButton.setBackground(new Color(13,20,198));
		messageButton.setForeground(new Color(1,1,1));
		add(introLabel);
		add(promptLabel);
		add(inputField);
		add(messageButton);
			messageButton.addActionListener(this);
		add(outputLabel);

	}

	public void actionPerformed(ActionEvent e)
	{

			try
			{
				holidayNum = Integer.parseInt(inputField.getText());

				switch(holidayNum)
				{
					case 1:
						outputLabel.setForeground(new Color(206,112,30));
						outputLabel.setText("Have a spooktacular Halloween");
					break;

					case 2:
						outputLabel.setForeground(new Color(30,205,13));
						outputLabel.setText("Have a merry Christmas");
					break;

					case 3:
						outputLabel.setForeground(new Color(226,185,21));
						outputLabel.setText("Have a candyliciouse easter");
					break;

					default:
						throw new NumberFormatException();
				}
				invalidate();
				validate();
			}
			catch(NumberFormatException f )
			{
				JOptionPane.showMessageDialog(null,"Please enter 1,2, or 3!");
			}


	}
}