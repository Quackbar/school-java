import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BaseGame extends JFrame implements ActionListener, Activator, path
{
	int guessWrongCounter = 1;
	ColorSettings game = new ColorSettings(Color.black, Color.magenta, Color.lightGray);
	static int energy = 100;
	boolean win = false, energyLoss = false;
	JPanel wordPanel = new JPanel(),buttonPanel = new JPanel(),embarkButtonPanel = new JPanel();
	PaintPanel pictPanel = new PaintPanel(game, guessWrongCounter);
	JLabel  wordLabel = new JLabel(g.getName());
	String word;
	JButton letterButton = new JButton("Shield On"), resetButton = new JButton("Shield Off"), embarkButton = new JButton("Embark"), buildButton = new JButton("Build"), resourceButton = new JButton("Resources"), itemButton = new JButton("Items"), statButton = new JButton("City Stats"), helpButton = new JButton("Help");
	ArrayList<Character> letMissList = new ArrayList<Character>();
	static BaseGame f1;

	public BaseGame()
	{
		setLayout(new BorderLayout());
		wordPanel.add(wordLabel);
		wordPanel.setBackground(Color.red);
		embarkButtonPanel.setBackground(Color.red);

		buttonPanel.setBackground(game.getPanelColor());
		buttonPanel.add(letterButton);
		buttonPanel.add(resetButton);
		embarkButtonPanel.setLayout(new GridLayout(10,1));
		embarkButtonPanel.add(embarkButton);
		embarkButtonPanel.add(buildButton);
		embarkButtonPanel.add(resourceButton);
		embarkButtonPanel.add(itemButton);
		embarkButtonPanel.add(statButton);
		embarkButtonPanel.add(helpButton);

		letterButton.addActionListener(this);
		resetButton.addActionListener(this);
		buildButton.addActionListener(this);
		embarkButton.addActionListener(this);
		resourceButton.addActionListener(this);
		itemButton.addActionListener(this);
		statButton.addActionListener(this);
		helpButton.addActionListener(this);

		add(wordPanel, BorderLayout.NORTH);
		add(pictPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(embarkButtonPanel, BorderLayout.WEST);

	}
	public void activate()
	{
		if(g.getNamec() == true)
			wordLabel.setText(g.getName());
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == letterButton)
		{
			guessWrongCounter+=1;
			pictPanel = new PaintPanel(game, guessWrongCounter);
			energyLoss = true;
			wordLabel.setText(g.getName());
		}
		else if(e.getSource() == resetButton)
		{
			guessWrongCounter-=1;
			pictPanel = new PaintPanel(game, guessWrongCounter);
			energyLoss = false;
			wordLabel.setText(g.getName());
		}
		else if(e.getSource() == embarkButton)
		{
			if(g.getFuel() >= 10&&g.getEnergy() >= 10)
			{
				Ship s = new Ship();
				g.setGTG(true);
				g.setFuel(-2000);
				g.setEnergy(-80000000);
				JFrame jf = new JFrame();
				jf.setTitle("Space Miner");
				jf.setBounds(400,0,700,1000);
				jf.setVisible(true);
				jf.add(s);
			}
			else
			{
                   JOptionPane.showMessageDialog(null, "Not enough fuel and/or energy to complete that action!\nYou need 2000 fuel and 80000000 energy to embark.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == helpButton)
		{
			Help f1 = new Help(this, game);
			f1.setTitle("Help");
			f1.setBounds(100,510,500,200);
			f1.setVisible(true);
			wordLabel.setText(g.getName());
		}
		else if(e.getSource() == statButton)
		{
			Stats f1 = new Stats(this, game);
			f1.setTitle("City Stats");
			f1.setBounds(100,420,300,400);
			f1.setVisible(true);
			wordLabel.setText(g.getName());
		}
		else if(e.getSource() == buildButton)
		{
			Build f1 = new Build(this, game);
			f1.setTitle("Build");
			f1.setBounds(100,150,300,400);
			f1.setVisible(true);
			wordLabel.setText(g.getName());
		}
		else if(e.getSource() == resourceButton)
		{
			Resource f1 = new Resource(this, game);
			f1.setTitle("Resources");
			f1.setBounds(100,240,300,400);
			f1.setVisible(true);
			wordLabel.setText(g.getName());
		}
		else if(e.getSource() == itemButton)
		{
			g.setSteel(10);
			g.setPlutonium(10);
			g.setPlasma(10);
			g.setFuel(2000);
			Item f1 = new Item(this, game);
			f1.setTitle("Items");
			f1.setBounds(100,330,300,400);
			f1.setVisible(true);
			wordLabel.setText(g.getName());
		}

	}
	public static void main(String[] args)
	{
		f1 = new BaseGame();
		f1.setTitle("Game");
		f1.setBounds(0,0,1700,1000);
		f1.setVisible(true);
//		while(true)
//		{

/*			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));
			System.out.print("" + (int)(Math.random() * 999999999));*/
//		}
	}

}