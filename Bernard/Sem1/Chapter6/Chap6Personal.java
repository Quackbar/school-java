import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Chap6Personal extends JFrame implements ActionListener, Runnable
{
	int p1MunInt = 1000;
	int p2MunInt = 1000;
	int one,two,three,four,five;

	Font font1 = new Font("", Font.PLAIN, 34);
	Font font2 = new Font("", Font.PLAIN, 15);
	Font font3 = new Font("", Font.PLAIN, 45);

	Panel titlePanel = new Panel();
	Panel gamePanel = new Panel();
	Panel numPanel = new Panel();
	Panel scorePanel = new Panel();
	Panel rollPanel = new Panel();

	JTextField num1 = new JTextField();
	JTextField num2 = new JTextField();
	JTextField num3 = new JTextField();
	JTextField num4 = new JTextField();
	JTextField num5 = new JTextField();

	JTextField p1Mun = new JTextField("1000", 10);
	JTextField p2Mun = new JTextField("1000", 10);

	Label playerOne = new Label();
	Label playerTwo = new Label();
	Label title = new Label("THE WINNERS GAME");
	Label p1Score = new Label("       ");
	Label p2Score = new Label("       ");
	Label empty1 = new Label("           ");
	Label yesLabel = new Label("              ");

	Button p1Roll = new Button("Player One Roll");
	Button p2Roll = new Button("Player Two Roll");
	Button stop = new Button("Stop");

	MenuItem newGame = new MenuItem("New Game");
	MenuItem redB = new MenuItem("Red");
	MenuItem greenB = new MenuItem("Green");
	MenuItem blueB = new MenuItem("Blue");
	MenuItem cyanB = new MenuItem("Cyan");
	MenuItem magentaB = new MenuItem("Magenta");
	MenuItem orangeB = new MenuItem("Orange");
	MenuItem whiteB = new MenuItem("White");
	MenuItem blackB = new MenuItem("Black");
	MenuItem redF = new MenuItem("Red");
	MenuItem greenF = new MenuItem("Green");
	MenuItem blueF = new MenuItem("Blue");
	MenuItem cyanF = new MenuItem("Cyan");
	MenuItem magentaF = new MenuItem("Magenta");
	MenuItem orangeF = new MenuItem("Orange");
	MenuItem whiteF = new MenuItem("White");
	MenuItem blackF = new MenuItem("Black");
	MenuItem p1Color = new MenuItem("Color");
	MenuItem p2Color = new MenuItem("Color");
	MenuItem rules = new MenuItem("Rules");
	MenuItem about = new MenuItem("About");

	Thread t1;

	public Chap6Personal()
	{
		MenuBar mnuBar = new MenuBar();
		this.setMenuBar(mnuBar);

		//File Menu
		Menu fileMenu = new Menu("File");
		mnuBar.add(fileMenu);
		fileMenu.add(newGame);
		newGame.addActionListener(this);

		//Layout Menu
		Menu layoutMenu = new Menu("Layout");
		mnuBar.add(layoutMenu);
		Menu background = new Menu("Background");
		layoutMenu.add(background);
		background.add(redB);
		redB.addActionListener(this);
		background.add(greenB);
		greenB.addActionListener(this);
		background.add(blueB);
		blueB.addActionListener(this);
		background.add(cyanB);
		cyanB.addActionListener(this);
		background.add(magentaB);
		magentaB.addActionListener(this);
		background.add(orangeB);
		orangeB.addActionListener(this);
		background.add(whiteB);
		whiteB.addActionListener(this);
		background.add(blackB);
		blackB.addActionListener(this);
		Menu foreground = new Menu("Foreground");
		layoutMenu.add(foreground);
		foreground.add(redF);
		redF.addActionListener(this);
		foreground.add(greenF);
		greenF.addActionListener(this);
		foreground.add(blueF);
		blueF.addActionListener(this);
		foreground.add(cyanF);
		cyanF.addActionListener(this);
		foreground.add(magentaF);
		magentaF.addActionListener(this);
		foreground.add(orangeF);
		orangeF.addActionListener(this);
		foreground.add(whiteF);
		whiteF.addActionListener(this);
		foreground.add(blackF);
		blackF.addActionListener(this);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		mnuBar.add(helpMenu);
		helpMenu.add(rules);
		rules.addActionListener(this);
		helpMenu.add(about);
		about.addActionListener(this);

		this.setLayout(new BorderLayout());
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout( new GridLayout(0,3));
		titlePanel.add(playerOne);
		titlePanel.add(title);
		title.setFont(font2);
		titlePanel.add(playerTwo);
		add(gamePanel, BorderLayout.CENTER);
		gamePanel.setLayout(new BorderLayout());
		gamePanel.add(scorePanel, BorderLayout.NORTH);
		scorePanel.setLayout(new GridLayout(0,3));
		scorePanel.add(p1Mun);
		p1Mun.setFont(font1);
		p1Mun.setEditable(false);
		scorePanel.add(empty1);
		scorePanel.add(p2Mun);
		p2Mun.setEditable(false);
		p2Mun.setFont(font1);

		scorePanel.add(p1Score);
		scorePanel.add(yesLabel);
		yesLabel.setAlignment(Label.CENTER);
		yesLabel.setFont(font2);
		scorePanel.add(p2Score);
		gamePanel.add(numPanel, BorderLayout.CENTER);
		numPanel.setLayout(new GridLayout(0,5));
		numPanel.add(num1);
		num1.setEditable(false);
		num1.setFont(font3);
		num1.setHorizontalAlignment(JTextField.CENTER);
		numPanel.add(num2);
		num2.setEditable(false);
		num2.setFont(font3);
		num2.setHorizontalAlignment(JTextField.CENTER);
		numPanel.add(num3);
		num3.setEditable(false);
		num3.setFont(font3);
		num3.setHorizontalAlignment(JTextField.CENTER);
		numPanel.add(num4);
		num4.setEditable(false);
		num4.setFont(font3);
		num4.setHorizontalAlignment(JTextField.CENTER);
		numPanel.add(num5);
		num5.setEditable(false);
		num5.setFont(font3);
		num5.setHorizontalAlignment(JTextField.CENTER);
		gamePanel.add(rollPanel, BorderLayout.SOUTH);
		rollPanel.setLayout(new GridLayout(0,3));
		rollPanel.add(p1Roll);
		rollPanel.add(stop);
		stop.addActionListener(this);
		p1Roll.addActionListener(this);
		rollPanel.add(p2Roll);
		p2Roll.addActionListener(this);
		p2Roll.setEnabled(false);

		playerOne.setText(JOptionPane.showInputDialog(null,"Enter name for player one"));
		playerOne.setFont(font2);
		playerOne.setAlignment(Label.CENTER);
		playerTwo.setText(JOptionPane.showInputDialog(null,"Enter name for player two"));
		playerTwo.setFont(font2);
		playerTwo.setAlignment(Label.CENTER);
		playerOne.setBackground(Color.white);
		playerTwo.setBackground(Color.white);
		title.setBackground(Color.white);
		empty1.setBackground(Color.white);
		p1Score.setBackground(Color.white);
		p2Score.setBackground(Color.white);
		yesLabel.setBackground(Color.white);
	}

	//Creates a random int
	private int ran(int Mult)
	{
		return (int) (Math.random() * Mult +.10 );
	}

	//Creates a rolling effect
	public void run()
	{
		for(int i = 0; i<10000; i++)
		{
			int one = ran(10);
			int two = ran(10);
			int three = ran(10);
			int four = ran(10);
			int five = ran(10);
			num1.setText(String.valueOf(one));
			num2.setText(String.valueOf(two));
			num3.setText(String.valueOf(three));
			num4.setText(String.valueOf(four));
			num5.setText(String.valueOf(five));
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
			}
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == newGame)
		{
			playerOne.setText(JOptionPane.showInputDialog(null,"Enter name for player one"));
			playerOne.setFont(font2);
			playerOne.setAlignment(Label.CENTER);
			playerTwo.setText(JOptionPane.showInputDialog(null,"Enter name for player two"));
			playerTwo.setFont(font2);
			playerTwo.setAlignment(Label.CENTER);
			p1Mun.setText("1000");
			p2Mun.setText("1000");
			playerOne.setBackground(Color.white);
			playerTwo.setBackground(Color.white);
			title.setBackground(Color.white);
			empty1.setBackground(Color.white);
			p1Score.setBackground(Color.white);
			p2Score.setBackground(Color.white);
			yesLabel.setBackground(Color.white);
			playerOne.setForeground(Color.black);
			playerTwo.setForeground(Color.black);
			title.setForeground(Color.black);
			empty1.setForeground(Color.black);
			p1Score.setForeground(Color.black);
			p2Score.setForeground(Color.black);
			yesLabel.setForeground(Color.black);
		}
		else if(e.getSource() == redB)
		{
			playerOne.setBackground(Color.red);
			playerTwo.setBackground(Color.red);
			title.setBackground(Color.red);
			empty1.setBackground(Color.red);
			p1Score.setBackground(Color.red);
			p2Score.setBackground(Color.red);
			yesLabel.setBackground(Color.red);
		}
		else if(e.getSource() == greenB)
		{
			playerOne.setBackground(Color.green);
			playerTwo.setBackground(Color.green);
			title.setBackground(Color.green);
			empty1.setBackground(Color.green);
			p1Score.setBackground(Color.green);
			p2Score.setBackground(Color.green);
			yesLabel.setBackground(Color.green);
		}
		else if(e.getSource() == blueB)
		{
			playerOne.setBackground(Color.blue);
			playerTwo.setBackground(Color.blue);
			title.setBackground(Color.blue);
			empty1.setBackground(Color.blue);
			p1Score.setBackground(Color.blue);
			p2Score.setBackground(Color.blue);
			yesLabel.setBackground(Color.blue);
		}
		else if(e.getSource() == cyanB)
		{
			playerOne.setBackground(Color.cyan);
			playerTwo.setBackground(Color.cyan);
			title.setBackground(Color.cyan);
			empty1.setBackground(Color.cyan);
			p1Score.setBackground(Color.cyan);
			p2Score.setBackground(Color.cyan);
			yesLabel.setBackground(Color.cyan);
		}
		else if(e.getSource() == magentaB)
		{
			playerOne.setBackground(Color.magenta);
			playerTwo.setBackground(Color.magenta);
			title.setBackground(Color.magenta);
			empty1.setBackground(Color.magenta);
			p1Score.setBackground(Color.magenta);
			p2Score.setBackground(Color.magenta);
			yesLabel.setBackground(Color.magenta);
		}
		else if(e.getSource() == orangeB)
		{
			playerOne.setBackground(Color.orange);
			playerTwo.setBackground(Color.orange);
			title.setBackground(Color.orange);
			empty1.setBackground(Color.orange);
			p1Score.setBackground(Color.orange);
			p2Score.setBackground(Color.orange);
			yesLabel.setBackground(Color.orange);
		}
		else if(e.getSource() == whiteB)
		{
			playerOne.setBackground(Color.white);
			playerTwo.setBackground(Color.white);
			title.setBackground(Color.white);
			empty1.setBackground(Color.white);
			p1Score.setBackground(Color.white);
			p2Score.setBackground(Color.white);
			yesLabel.setBackground(Color.white);
		}
		else if(e.getSource() == blackB)
		{
			playerOne.setBackground(Color.black);
			playerTwo.setBackground(Color.black);
			title.setBackground(Color.black);
			empty1.setBackground(Color.black);
			p1Score.setBackground(Color.black);
			p2Score.setBackground(Color.black);
			yesLabel.setBackground(Color.black);
		}
		else if(e.getSource() == redF)
		{
			playerOne.setForeground(Color.red);
			playerTwo.setForeground(Color.red);
			title.setForeground(Color.red);
			empty1.setForeground(Color.red);
			p1Score.setForeground(Color.red);
			p2Score.setForeground(Color.red);
			yesLabel.setForeground(Color.red);
		}
		else if(e.getSource() == greenF)
		{
			playerOne.setForeground(Color.green);
			playerTwo.setForeground(Color.green);
			title.setForeground(Color.green);
			empty1.setForeground(Color.green);
			p1Score.setForeground(Color.green);
			p2Score.setForeground(Color.green);
			yesLabel.setForeground(Color.green);
		}
		else if(e.getSource() == blueF)
		{
			playerOne.setForeground(Color.blue);
			playerTwo.setForeground(Color.blue);
			title.setForeground(Color.blue);
			empty1.setForeground(Color.blue);
			p1Score.setForeground(Color.blue);
			p2Score.setForeground(Color.blue);
			yesLabel.setForeground(Color.blue);
		}
		else if(e.getSource() == cyanF)
		{
			playerOne.setForeground(Color.cyan);
			playerTwo.setForeground(Color.cyan);
			title.setForeground(Color.cyan);
			empty1.setForeground(Color.cyan);
			p1Score.setForeground(Color.cyan);
			p2Score.setForeground(Color.cyan);
			yesLabel.setForeground(Color.cyan);
		}
		else if(e.getSource() == magentaF)
		{
			playerOne.setForeground(Color.magenta);
			playerTwo.setForeground(Color.magenta);
			title.setForeground(Color.magenta);
			empty1.setForeground(Color.magenta);
			p1Score.setForeground(Color.magenta);
			p2Score.setForeground(Color.magenta);
			yesLabel.setForeground(Color.magenta);
		}
		else if(e.getSource() == orangeF)
		{
			playerOne.setForeground(Color.orange);
			playerTwo.setForeground(Color.orange);
			title.setForeground(Color.orange);
			empty1.setForeground(Color.orange);
			p1Score.setForeground(Color.orange);
			p2Score.setForeground(Color.orange);
			yesLabel.setForeground(Color.orange);
		}
		else if(e.getSource() == whiteF)
		{
			playerOne.setForeground(Color.white);
			playerTwo.setForeground(Color.white);
			title.setForeground(Color.white);
			empty1.setForeground(Color.white);
			p1Score.setForeground(Color.white);
			p2Score.setForeground(Color.white);
			yesLabel.setForeground(Color.white);
		}
		else if(e.getSource() == blackF)
		{
			playerOne.setForeground(Color.black);
			playerTwo.setForeground(Color.black);
			title.setForeground(Color.black);
			empty1.setForeground(Color.black);
			p1Score.setForeground(Color.black);
			p2Score.setForeground(Color.black);
			yesLabel.setForeground(Color.black);
		}
		else if(e.getSource() == rules)
		{
			JOptionPane.showMessageDialog(null,"null");
		}
		else if(e.getSource() == about)
		{
			JOptionPane.showMessageDialog(null,"THE WINNERS GAME™\nCreated by Bernard, Chapter 6 Personal");
		}
		else if(e.getSource() == p1Roll)
		{
			yesLabel.setText(" ");
			t1 = new Thread(this);
			t1.start();
			p1Roll.setEnabled(false);
			p2Roll.setEnabled(true);
		}
		else if(e.getSource() == p2Roll)
		{
			yesLabel.setText(" ");
			t1 = new Thread(this);
			t1.start();
			p2Roll.setEnabled(false);
			p1Roll.setEnabled(true);
		}
		else if(e.getSource() == stop)
		{
			t1.stop();
			if(p2Roll.isEnabled() == true)
			{
				if((one == two) || (two == three) || (three == four) || (four == five))
				{
					yesLabel.setText("TWO IN A ROW");
					p1MunInt *= 1.15;
					p1Mun.setText(String.valueOf(p1MunInt));
				}
				else if((one == two && two == three) || (three == four && four == five) || (two == three && three == four))
				{
					yesLabel.setText("THREE IN A ROW");
					p1MunInt *= 1.50;
					p1Mun.setText(String.valueOf(p1MunInt));
				}
				else if((one == two && two == three && three == four) || (two == three && three == four && four == five))
				{
					yesLabel.setText("FOUR IN A ROW");
					p1MunInt *= 1.75;
					p1Mun.setText(String.valueOf(p1MunInt));
				}
				else if(one == two && two == three && three == four && four == five)
				{
					yesLabel.setText("FIVE IN A ROW");
					p1MunInt *= 2;
					p1Mun.setText(String.valueOf(p1MunInt));
				}
			}
			else
			{
				if((one == two) || (two == three) || (three == four) || (four == five))
				{
					yesLabel.setText("TWO IN A ROW");
					p2MunInt *= 1.15;
					p2Mun.setText(String.valueOf(p2MunInt));
				}
				else if((one == two && two == three) || (num2 == num3 && num3 == num4) || (num3 == num4 && num4 == num5))
				{
					yesLabel.setText("THREE IN A ROW");
					p2MunInt *= 1.50;
					p2Mun.setText(String.valueOf(p2MunInt));
				}
				else if((one == two && two == three && three == four) || (two == three && three == four && four == five))
				{
					yesLabel.setText("FOUR IN A ROW");
					p2MunInt *= 1.75;
					p2Mun.setText(String.valueOf(p2MunInt));
				}
				else if(one == two && two == three && three == four && four == five)
				{
					yesLabel.setText("FIVE IN A ROW");
					p2MunInt *= 2;
					p1Mun.setText(String.valueOf(p1MunInt));
				}
			}
		}
	}
	public static void main(String[] args)
	{
		Chap6Personal CP = new Chap6Personal();
		CP.setVisible(true);
		CP.setBounds(0,0,650,290);
	}
}
