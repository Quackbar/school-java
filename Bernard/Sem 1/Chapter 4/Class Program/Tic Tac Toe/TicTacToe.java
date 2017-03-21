import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TicTacToe extends Applet implements ActionListener
{
	Button button1 = new Button(" ");
	Button button2 = new Button("  ");
	Button button3 = new Button("    ");
	Button button4 = new Button("     ");
	Button button5 = new Button("      ");
	Button button6 = new Button("       ");
	Button button7 = new Button("        ");
	Button button8 = new Button("         ");
	Button button9 = new Button("          ");

	Button resetButton = new Button("Reset");
	Label blankLabel = new Label();
	int counter = 0, red, blue, green;
	boolean winFlag = false;

	Font tttFont = new Font("Chiller",Font.BOLD,76);
	Font ttFont = new Font("Chiller",Font.BOLD,46);

	//method that runs when an applet starts
	//public - access modifier
	//void - does not return anything (no return statment)
	public void init()
	{
		setFont(tttFont);
		setLayout(new GridLayout(4,3));
		add(button1);
			button1.addActionListener(this);
			button1.setBackground(new Color(255,0,102));

		add(button2);
			button2.addActionListener(this);
			button2.setBackground(new Color(255,0,102));

		add(button3);
			button3.addActionListener(this);
			button3.setBackground(new Color(255,0,102));

		add(button4);
			button4.addActionListener(this);
			button4.setBackground(new Color(255,0,102));

		add(button5);
			button5.addActionListener(this);
			button5.setBackground(new Color(255,0,102));

		add(button6);
			button6.addActionListener(this);
			button6.setBackground(new Color(255,0,102));

		add(button7);
			button7.addActionListener(this);
			button7.setBackground(new Color(255,0,102));

		add(button8);
			button8.addActionListener(this);
			button8.setBackground(new Color(255,0,102));

		add(button9);
			button9.addActionListener(this);
			button9.setBackground(new Color(255,0,102));

		add(blankLabel);

		add(resetButton);
			resetButton.addActionListener(this);
			resetButton.setFont(ttFont);
			resetButton.setBackground(new Color(255,0,102));
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == resetButton)
		{
			reset();
		}
		else
		{
			Button clickedButton = (Button)(e.getSource());
			if(counter % 2 == 0)
			{
				clickedButton.setLabel("X");
			}
			else
			{
				clickedButton.setLabel("O");
			}
			clickedButton.removeActionListener(this);
			//clickedButton.setEnabled(false);
			counter++;

			//checking win in a row
			if(button1.getLabel().equals(button2.getLabel()) && button1.getLabel().equals(button3.getLabel()))
			{
				button1.setBackground(Color.magenta);
				button2.setBackground(Color.magenta);
				button3.setBackground(Color.magenta);
				winFlag = true;
			}
			else if(button4.getLabel().equals(button5.getLabel()) && button4.getLabel().equals(button6.getLabel()))
			{
				button4.setBackground(Color.magenta);
				button5.setBackground(Color.magenta);
				button6.setBackground(Color.magenta);
				winFlag = true;
			}
			else if(button7.getLabel().equals(button8.getLabel()) && button7.getLabel().equals(button9.getLabel()))
			{
				button7.setBackground(Color.magenta);
				button8.setBackground(Color.magenta);
				button9.setBackground(Color.magenta);
				winFlag = true;
			}

			//checking for win in a cloumn
			else if(button1.getLabel().equals(button4.getLabel()) && button1.getLabel().equals(button7.getLabel()))
			{
				button1.setBackground(Color.magenta);
				button4.setBackground(Color.magenta);
				button7.setBackground(Color.magenta);
				winFlag = true;
			}
			else if(button2.getLabel().equals(button5.getLabel()) && button2.getLabel().equals(button8.getLabel()))
			{
				button2.setBackground(Color.magenta);
				button5.setBackground(Color.magenta);
				button8.setBackground(Color.magenta);
				winFlag = true;
			}
			else if(button3.getLabel().equals(button6.getLabel()) && button3.getLabel().equals(button9.getLabel()))
			{
				button3.setBackground(Color.magenta);
				button6.setBackground(Color.magenta);
				button9.setBackground(Color.magenta);
				winFlag = true;
			}

			//checking for win diagonally
			else if(button1.getLabel().equals(button5.getLabel()) && button1.getLabel().equals(button9.getLabel()))
			{
				button1.setBackground(Color.magenta);
				button5.setBackground(Color.magenta);
				button9.setBackground(Color.magenta);
				winFlag = true;
			}
			else if(button3.getLabel().equals(button5.getLabel()) && button3.getLabel().equals(button7.getLabel()))
			{
				button3.setBackground(Color.magenta);
				button5.setBackground(Color.magenta);
				button7.setBackground(Color.magenta);
				winFlag = true;
			}

		if(winFlag)
		{

			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
			button4.setEnabled(false);
			button5.setEnabled(false);
			button6.setEnabled(false);
			button7.setEnabled(false);
			button8.setEnabled(false);
			button9.setEnabled(false);

			if(counter % 2 == 0)
			{
				blankLabel.setText("0 Won!");
			}
			else
			{
				blankLabel.setText("X Won!");
			}
		}
		else if(counter == 9)
		{
			blankLabel.setText("LOL");
		}
	}
	}
	public void reset()
	{
		counter = 0;
		blankLabel.setText("");
		winFlag = false;
		button1.setLabel(" ");
		button2.setLabel("  ");
		button3.setLabel("   ");
		button4.setLabel("    ");
		button5.setLabel("     ");
		button6.setLabel("      ");
		button7.setLabel("       ");
		button8.setLabel("        ");
		button9.setLabel("         ");

		button1.setEnabled(true);
		button2.setEnabled(true);
		button3.setEnabled(true);
		button4.setEnabled(true);
		button5.setEnabled(true);
		button6.setEnabled(true);
		button7.setEnabled(true);
		button8.setEnabled(true);
		button9.setEnabled(true);

		red = (int)(Math.random() * 256);
		green = (int)(Math.random() * 256);
		blue = (int)(Math.random() * 256);

		button1.setBackground(new Color(red,green,blue));
		button2.setBackground(new Color(red,green,blue));
		button3.setBackground(new Color(red,green,blue));
		button4.setBackground(new Color(red,green,blue));
		button5.setBackground(new Color(red,green,blue));
		button6.setBackground(new Color(red,green,blue));
		button7.setBackground(new Color(red,green,blue));
		button8.setBackground(new Color(red,green,blue));
		button9.setBackground(new Color(red,green,blue));
		resetButton.setBackground(new Color(red,green,blue));
	}
}