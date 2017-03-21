import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Stats extends JFrame implements ActionListener, path
{
	JPanel backPanel = new JPanel(), main = new JPanel();
	JButton back = new JButton("Back"), rename = new JButton("Rename");
	JLabel energy = new JLabel("Energy: "+g.getEnergy()),pop = new JLabel("Population: "+g.getPopulation()),popsurp = new JLabel("Population Surplus: "+g.getPopulationSurplus());
	Activator caller;
	ColorSettings currentGame;
	JTextField nameField = new JTextField(g.getName());

	public Stats(Activator callerObj, ColorSettings game)
	{
		currentGame = game;
		caller = callerObj;
		main.setLayout(new GridLayout(5,1));
		main.add(nameField);
		main.add(rename);
		main.add(energy);
		main.add(pop);
		main.add(popsurp);
		back.addActionListener(this);
		rename.addActionListener(this);
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
		else if(e.getSource() == rename)
		{
			g.setName(nameField.getText());
			g.setNamec(true);
			caller.activate();
		}
	}
}