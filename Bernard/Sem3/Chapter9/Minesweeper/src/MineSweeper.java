import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MineSweeper extends JFrame implements ActionListener
{
	static MSButton[][] buttons;
	String[][] checkArray;
	int bombRow, bombCol, numBombs, bombCounter;
	boolean done;
	static MineSweeper f1;
	
	public MineSweeper()
	{
		do
		{
			try
			{
				numBombs = Integer.parseInt(JOptionPane.showInputDialog("There are 150 squares on the board, \nHow many bombs would you like?"));
				if(numBombs > 149 || numBombs < 1)
				{
					throw new NumberFormatException();
				}
				else
				{
					done = true;
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "You must enter between 1 and 149 bombs.", "BOMB ERROR", JOptionPane.WARNING_MESSAGE);
			}
			
		}while(!done);
		
		buttons = new MSButton[10][15];
		checkArray = new String[10][15];
		
		for(int i = 0; i < buttons.length; i++)
		{
			for(int j = 0; j < buttons[0].length; j++)
			{
				buttons[i][j] = new MSButton();
			}
		}
		
		for(int k = 0; k < numBombs; k++)
		{
			bombRow = (int)(Math.random() * 10);
			bombCol = (int)(Math.random() * 15);
			
			if(buttons[bombRow][bombCol].getAdjBombNum() != 100)
			{
				buttons[bombRow][bombCol].setAdjBombNum(100);
			}
			else
			{
				k--;
			}
		}
		
		this.setLayout(new GridLayout(10,15)); //row,col
		
		for(int l = 0; l < buttons.length; l++)
		{
			for(int m = 0; m < buttons[0].length; m++)
			{
				bombCounter = 0;
				if(buttons[l][m].getAdjBombNum() != 100)
				{
					//upper left
					if(l-1 >= 0 && m-1 >= 0 && buttons[l-1][m-1].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					
					//above
					if(l-1 >= 0 && buttons[l-1][m].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					
					//upper right
					if(l-1 >= 0 && m+1 < buttons[0].length && buttons[l-1][m+1].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					
					//left
					if(m-1 >= 0 && buttons[l][m-1].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					
					//right
					if(m+1 < buttons[0].length && buttons[l][m+1].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					
					//lower left
					if(l+1 < buttons.length && m-1 >= 0 && buttons[l+1][m-1].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					
					//below
					if(l+1 < buttons.length && buttons[l+1][m].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					
					//lower right
					if(l+1 < buttons.length && m+1 < buttons[0].length && buttons[l+1][m+1].getAdjBombNum() == 100)
					{
						bombCounter++;
					}
					buttons[l][m].setAdjBombNum(bombCounter);
				}
				buttons[l][m].addActionListener(this);
				add(buttons[l][m]);
				checkArray[l][m] = "not checked";
			}
		}
		
		for(int i = 0; i < buttons.length; i++)
		{
			for(int j = 0; j < buttons[0].length; j++)
			{
				System.out.print(buttons[i][j].getAdjBombNum() + "    ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		f1 = new MineSweeper();
		f1.setTitle("MineSweeper");
		f1.setBounds(10,10,800,600);
		f1.setVisible(true);
		//.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(int n = 0; n < buttons.length; n++)
		{
			for(int p = 0; p < buttons[0].length; p++)
			{
				if(e.getSource() == buttons[n][p])
				{
					if(buttons[n][p].getAdjBombNum() == 100)
					{
						for(int q = 0; q < buttons.length; q++)
						{
							for(int r = 0; r < buttons[0].length; r++)
							{
								if(checkArray[q][r].equals("not checked"))
								{
									if(buttons[q][r].getAdjBombNum() == 100)
									{
										buttons[q][r].setButtonImageIcon("Bomb.png");
									}
									else if(buttons[q][r].getAdjBombNum() == 0)
									{
										buttons[q][r].setButtonImageIcon("Blank.png");
									}
									else
									{
										buttons[q][r].setIcon(null);
										buttons[q][r].setText(Integer.toString(buttons[q][r].getAdjBombNum()));
									}
									buttons[q][r].removeActionListener(this);
								}
							}
						}
						playAgain();
					}
					else if(buttons[n][p].getAdjBombNum() == 0)
					{
						checkArray[n][p] = "need checked";
						do
						{
							done = true;
							for(int s = 0; s < buttons.length; s++)
							{
								for(int t = 0; t < buttons[0].length; t++)
								{
									if(checkArray[s][t].equals("need checked"))
									{
										checkArray[s][t] = "checked";
										buttons[s][t].setButtonImageIcon("Blank.png");
										buttons[s][t].setText("done");
										buttons[s][t].removeActionListener(this);
										checkBlanks(s,t);
									}
								}
							}
						}while(!done);
						checkWin();	
					}
					else
					{
						buttons[n][p].setText(Integer.toString(buttons[n][p].getAdjBombNum()));
						buttons[n][p].removeActionListener(this);
						checkWin();
					}
				}
			}
		}
	}
	
	public void checkBlanks(int row, int col)
	{ //add below, subtract above. Adding right, subtract left
		if(row - 1 >= 0 && col - 1 >= 0)
		{
			setCheckArray(row-1,col-1);
		}
		if(row - 1 >= 0 )
		{
			setCheckArray(row-1,col);
		}
		if(row - 1 >= 0 && col + 1 < buttons[0].length)
		{
			setCheckArray(row-1,col+1);
		}
		if(col - 1 >= 0)
		{
			setCheckArray(row,col-1);
		}
		if(col + 1 < buttons[0].length)
		{
			setCheckArray(row,col+1);
		}
		if(col - 1 >= 0 && row + 1 < buttons.length)
		{
			setCheckArray(row+1,col-1);
		}
		if(row + 1 < buttons.length)
		{
			setCheckArray(row+1,col);
		}
		if(row +  1< buttons.length && col + 1 < buttons[0].length)
		{
			setCheckArray(row+1,col+1);
		}
	}
	
	public void setCheckArray(int row, int col)
	{
		if(buttons[row][col].getAdjBombNum() == 0 && !checkArray[row][col].equals("checked"))
		{
			checkArray[row][col] = "need checked";
			done = false;
		}
		else
		{
			buttons[row][col].setText(Integer.toString(buttons[row][col].getAdjBombNum()));
		}
	}
	
	public void checkWin()
	{
		bombCounter = 0;
		for(int u = 0; u < buttons.length; u++)
		{
			for(int v = 0; v < buttons[0].length; v++)
			{
				if(buttons[u][v].getText().equals(""))
					bombCounter++;
			}
		}
		if(bombCounter == numBombs)
		{
			for(int w = 0; w < buttons.length; w++)
			{
				for(int x = 0; x < buttons[0].length; x++)
				{
					if(buttons[w][x].getAdjBombNum() == 100)
					{
						buttons[w][x].setButtonImageIcon("Smile.png");
						buttons[w][x].removeActionListener(this);
					}
				}
			}
			playAgain();
		}
	}
	
	public void playAgain()
	{
		if(JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION) == 0)
		{
			f1.setVisible(false);
			f1 = new MineSweeper();
			f1.setTitle("MineSweeper");
			f1.setBounds(10,10,800,600);
			f1.setVisible(true);
			f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else
		{
			System.exit(0);
		}
	}
}
