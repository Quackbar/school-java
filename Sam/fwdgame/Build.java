import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Build extends JFrame implements ActionListener, path
{
	JPanel backPanel = new JPanel(),buildPanel = new JPanel();
	JButton back = new JButton("Back"),powerButton = new JButton("Construct"),cityButton = new JButton(" Expand "),defenseButton = new JButton("Construct");
	JLabel powerPlant = new JLabel("Power Plant:                         (1 Steel, 1 Plutonium)"),city = new JLabel("City:                         (1 Steel, 100000Pop. Surplus)"),defense = new JLabel("Defence:                                     	( 1 Steel, 1 Plasma)");
	Activator caller;
	ColorSettings currentGame;

	public Build(Activator callerObj, ColorSettings game)
	{
		currentGame = game;
		caller = callerObj;
		back.addActionListener(this);
		powerButton.addActionListener(this);
		cityButton.addActionListener(this);
		defenseButton.addActionListener(this);
		setLayout(new BorderLayout());
		buildPanel.setLayout(new GridLayout(6,1));
		buildPanel.add(powerPlant);
		buildPanel.add(powerButton);
		buildPanel.add(city);
		buildPanel.add(cityButton);
		buildPanel.add(defense);
		buildPanel.add(defenseButton);
		backPanel.add(back);
		add(buildPanel,BorderLayout.CENTER);
		add(backPanel,BorderLayout.SOUTH);

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == back)
		{
			dispose();
		}
		else if(e.getSource() == powerButton)
		{
			if(g.getSteel()>=1 && g.getPlutonium() >= 1)
			{
				g.setPpLocalP(40);
				g.setBuild(true);
				g.setSteel(-1);
				g.setPlutonium(-1);
				dispose();
			}
		 	else
			{
                   JOptionPane.showMessageDialog(null, "Not enough steel and/or plutonium to complete that action!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == cityButton)
		{
			if(g.getPopulationSurplus()>=100000&&g.getSteel()>=1)
			{
				g.setPpLocal(20);
				g.setPpLocal2(20);
				g.setBuildC(true);
				g.setSteel(-1);
				g.setPopulationSurplus(-100000);
				g.setPopulation(100000);
				dispose();
			}
			else
			{
                   JOptionPane.showMessageDialog(null, "Not enough surplus population and/or steel to complete that action!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == defenseButton)
		{
			JOptionPane.showMessageDialog(null, "Sorry that action is not available in Beta","Defense",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}