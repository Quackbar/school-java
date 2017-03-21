import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Resource extends JFrame implements ActionListener, path
{
	JPanel backPanel = new JPanel(),buildPanel = new JPanel();
	JButton back = new JButton("Back"),catalog = new JButton("Catalog"),fuel = new JButton("Make Fuel(-1000Pop. Surplus)");
	JLabel steelL = new JLabel("Steel: "),plutoniumL = new JLabel("Plutonium: "),plasmaL = new JLabel("Plasma: "),fuelL = new JLabel("Fuel: ");
	Activator caller;
	ColorSettings currentGame;

	public Resource(Activator callerObj, ColorSettings game)
	{
		steelL.setText("Steel: " + g.getSteel());
		plutoniumL.setText("Plutonium: " + g.getPlutonium());
		plasmaL.setText("Plasma: " +g.getPlasma());
		fuelL.setText("Fuel: " +g.getFuel());
		currentGame = game;
		caller = callerObj;
		catalog.addActionListener(this);
		back.addActionListener(this);
		fuel.addActionListener(this);
		setLayout(new BorderLayout());
		buildPanel.setLayout(new GridLayout(6,1));
		buildPanel.add(catalog);
		buildPanel.add(steelL);
		buildPanel.add(plutoniumL);
		buildPanel.add(plasmaL);
		buildPanel.add(fuelL);
		buildPanel.add(fuel);
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
		else if(e.getSource() == catalog)
		{
			JOptionPane.showMessageDialog(null, "Steel - used for building most structures\nPlutonium - used for making nuclear power plants\nPlasma - used for creating weapons\nFuel - used to travel in search of resources","Catalog",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == fuel)
		{
			if(g.getPopulationSurplus()>0)
			{
				g.setPopulationSurplus(-1000);
				g.setFuel(10);
				steelL.setText("Steel: " + g.getSteel());
				plutoniumL.setText("Plutonium: " + g.getPlutonium());
				plasmaL.setText("Plasma: " +g.getPlasma());
				fuelL.setText("Fuel: " +g.getFuel());
			}
			else
			{
                   JOptionPane.showMessageDialog(null, "Not enough surplus population to complete that action!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}