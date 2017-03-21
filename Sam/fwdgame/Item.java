import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Item extends JFrame implements ActionListener
{
	JPanel backPanel = new JPanel(), main = new JPanel();
	JButton back = new JButton("Back");
	JLabel item = new JLabel("                              You Have No Items");
	Activator caller;
	ColorSettings currentGame;

	public Item(Activator callerObj, ColorSettings game)
	{
		currentGame = game;
		caller = callerObj;
		main.setLayout(new GridLayout(1,1));
		main.add(item);
		back.addActionListener(this);
		setLayout(new BorderLayout());
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