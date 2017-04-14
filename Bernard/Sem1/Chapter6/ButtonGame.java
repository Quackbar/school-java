import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonGame extends Frame implements ActionListener
{
	int buttonNum, red, green, blue, correctSquares = 0, clickCounter = 0;
	Button[][] buttonArray;
	Panel buttonPanel = new Panel();
	Color buttonColor1, buttonColor2;
	Font winFont = new Font("Chiller", Font.BOLD, 25);
	JLabel winLabel = new JLabel();


	public ButtonGame()
	{
		//Menu Creation
		MenuBar mBar = new MenuBar();
		this.setMenuBar(mBar);

		//File Menu
		Menu mFile = new Menu("File", true);
		mBar.add(mFile);
		MenuItem mFileExit = new MenuItem("Exit");
		mFile.add(mFileExit);
		mFileExit.addActionListener(this);
		mFileExit.setActionCommand("Exit");

		//Edit Menu
		Menu mEdit = new Menu("Edit", true);
		mBar.add(mEdit);
		MenuItem mEditReset = new MenuItem("Reset");
		mEdit.add(mEditReset);
		mEditReset.addActionListener(this);
		mEditReset.setActionCommand("Reset");

		MenuItem mEditStartColor = new MenuItem("Start Color");
		mEdit.add(mEditStartColor);
		mEditStartColor.addActionListener(this);
		mEditStartColor.setActionCommand("StartColor");

		MenuItem mEditSecondColor = new MenuItem("Second Color");
		mEdit.add(mEditSecondColor);
		mEditSecondColor.addActionListener(this);
		mEditSecondColor.setActionCommand("SecondColor");

		buttonNum = Integer.parseInt(JOptionPane.showInputDialog("How Many Rows:"));
		buttonArray = new Button[buttonNum][buttonNum];
		buttonPanel.setLayout(new GridLayout(buttonNum,buttonNum));
		red = (int)(Math.random() * 256);
		green = (int)(Math.random() * 256);
		blue = (int)(Math.random() * 256);
		buttonColor1 = new Color(red,green,blue);
		buttonColor2 = new Color(255-red,255-green,255-blue);

		for(int i = 0; i< buttonArray.length; i++)
		{
			for(int j = 0; j< buttonArray[0].length; j++)
			{
				buttonArray[i][j] = new Button();
				buttonArray[i][j].addActionListener(this);
				buttonArray[i][j].setBackground(buttonColor1);
				buttonPanel.add(buttonArray[i][j]);
			}
		}

		add(buttonPanel);

		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "Exit") //if(e.getSource() == mFileExit)
		{
			System.exit(0);
		}
		else if(e.getActionCommand() == "Reset")
		{
			for(int m = 0; m<buttonArray.length; m++)
			{
				for(int n = 0; n<buttonArray.length; n++)
				{
					buttonArray[m][n].setBackground(buttonColor1);
				}
			}
			clickCounter = 0;
			correctSquares = 0;
		}
		else if(e.getActionCommand() == "StartColor")
		{
			red = (int)(Math.random() * 256);
			green = (int)(Math.random() * 256);
			blue = (int)(Math.random() * 256);
			buttonColor1 = new Color(red,green,blue);
			for(int p = 0; p<buttonArray.length; p++)
			{
				for(int q = 0; q<buttonArray.length; q++)
				{
					if(buttonArray[p][q].getBackground() != buttonColor2)
					{
						buttonArray[p][q].setBackground(buttonColor1);
					}
				}
			}
		}
		else if(e.getActionCommand() == "SecondColor")
		{
			red = (int)(Math.random() * 256);
			green = (int)(Math.random() * 256);
			blue = (int)(Math.random() * 256);
			buttonColor2 = new Color(red,green,blue);
			for(int p = 0; p<buttonArray.length; p++)
			{
				for(int q = 0; q<buttonArray.length; q++)
				{
					if(buttonArray[p][q].getBackground() != buttonColor1)
					{
						buttonArray[p][q].setBackground(buttonColor2);
					}
				}
			}
		}
		else
		{
			clickCounter++;
			for(int s = 0; s < buttonArray[0].length; s++)
			{
				for(int t = 0; t < buttonArray.length; t++)
				{
					if(e.getSource() == buttonArray[t][s])
					{
						colorCheck(t,s);

						//checks to see if button above and chages color
						if(t-1 >= 0)
						{
							colorCheck(t-1,s);
						}
						//checks to see if button below and chages color
						if(t+1 < buttonArray.length)
						{
							colorCheck(t+1,s);
						}
						//checks to see if button left and chages color
						if(s-1 >= 0)
						{
							colorCheck(t,s-1);
						}
						//checks to see if button right and chages color
						if(s+1 < buttonArray.length)
						{
							colorCheck(t,s + 1);
						}
					}
				}
			}
		}
	}

	public void colorCheck(int rowNum, int colNum)
	{
		if(buttonArray[rowNum][colNum].getBackground() == buttonColor1)
		{
			buttonArray[rowNum][colNum].setBackground(buttonColor2);
			correctSquares++;
		}
		else
		{
			buttonArray[rowNum][colNum].setBackground(buttonColor1);
			correctSquares--;
		}
	}

	public static void main(String[] args)
	{
		ButtonGame f1 = new ButtonGame();
		f1.setTitle("Button Game");
		f1.setBounds(10,10,500,500);
		f1.setVisible(true);
	}
}
