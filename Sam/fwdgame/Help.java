import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Help extends JFrame implements ActionListener
{
	JPanel backPanel = new JPanel(),main = new JPanel();
	JButton back = new JButton("Back");
	JLabel label = new JLabel("This city is your home, You must protect it.");
	JLabel label1 = new JLabel("In the Top left corner are your energy and population scales");
	JLabel label2 = new JLabel("The shield above your city is the only thing keeping the citizens alive.");
	JLabel label3 = new JLabel("Press embark to gather resources to keep your energy high enough to live.");
	JLabel label4 = new JLabel("Once you have gathered more than enough resources to survive you can build.");
	JLabel label5 = new JLabel("Have Fun!");
	Activator caller;
	ColorSettings currentGame;

	public Help(Activator callerObj, ColorSettings game)
	{
		currentGame = game;
		caller = callerObj;
		back.addActionListener(this);
		setLayout(new BorderLayout());
		main.add(label);
		main.add(label1);
		main.add(label2);
		main.add(label3);
		main.add(label4);
		main.add(label5);
		backPanel.add(back);
		add(main,BorderLayout.CENTER);
		add(backPanel,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == back)
		{
			dispose();
		}
	}
}