import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ButtonPanel extends JPanel implements ActionListener
{
	ShapedButton solButton;
	static int counter = 0, firstButtonRow, firstButtonCol, secondButtonRow, secondButtonCol, jumpedButtonRow, jumpedButtonCol;
	static ShapedButton firstButton, secondButton, jumpedButton;
	String imageName;
	BufferedImage buttonImage;
	ImageIcon buttonImg;
	boolean firstMoveValid, moveLeft;
	int winCounter;

	public ButtonPanel(String imgName)
	{
		imageName = imgName;
		this.setLayout(new BorderLayout());
		solButton = new ShapedButton(imageName);
		solButton.addActionListener(this);
		this.add(solButton, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(solButton.contains()) //they clicked on the button
		{
			if(counter % 2 == 0) // first button clicked
			{
				if(imageName.equals("colorButton.png"))
				{
					firstButton = solButton; // needs static to keep track of the first button when next button gets clicked so can changeimages here and after the second click

					//gets the row and col of the buttonPanel that was clicked in the board array
					for(int i = 0; i < PegSolitaire.board.length; i++)
					{
						for(int j = 0; j < PegSolitaire.board[0].length; j ++)
						{
							try
							{
								//gets button from ButtonPanel and sees is it matches this button
								if(PegSolitaire.board[i][j].getComponent(0) == solButton)
								{
									firstButtonRow = i;
									firstButtonCol = j;
									//gets out of loops
									i = PegSolitaire.board.length;
									j = PegSolitaire.board[0].length;
								}
							}
							catch(ArrayIndexOutOfBoundsException ex) {}
							//for getComponent()
						}
					}
					//need individual trys because if one does not have a component I let the catch handle it
					//checks to see if there is a peg adjacent to jump and an empty space two spaces away
					firstMoveValid = false;
					if(firstButtonRow + 2 < PegSolitaire.board.length)//checks below
					{
						if(PegSolitaire.board[firstButtonRow + 1][firstButtonCol] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow + 1][firstButtonCol])).imageName.equals("colorButton.png") && PegSolitaire.board[firstButtonRow + 2][firstButtonCol] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow + 2][firstButtonCol])).imageName.equals("whiteButton.png"))
						{
							firstMoveValid = true;
						}
					}
					if(firstButtonRow - 2 >= 0) // checks above
					{
						if(PegSolitaire.board[firstButtonRow - 1][firstButtonCol] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow - 1][firstButtonCol])).imageName.equals("colorButton.png") && PegSolitaire.board[firstButtonRow - 2][firstButtonCol] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow - 2][firstButtonCol])).imageName.equals("whiteButton.png"))
						{
							firstMoveValid = true;
						}
					}
					if(firstButtonCol + 2 < PegSolitaire.board[0].length) // checks right
					{
						if(PegSolitaire.board[firstButtonRow][firstButtonCol + 1] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow][firstButtonCol +1])).imageName.equals("colorButton.png") && PegSolitaire.board[firstButtonRow][firstButtonCol + 2] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow][firstButtonCol + 2])).imageName.equals("whiteButton.png"))
						{
							firstMoveValid = true;
						}
					}
					if(firstButtonCol - 2 >= 0) // checks left
					{
						if(PegSolitaire.board[firstButtonRow][firstButtonCol - 1] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow][firstButtonCol - 1])).imageName.equals("colorButton.png") && PegSolitaire.board[firstButtonRow][firstButtonCol - 2] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[firstButtonRow][firstButtonCol - 2])).imageName.equals("whiteButton.png"))
						{
							firstMoveValid = true;
						}
					}
				}

				if(firstMoveValid)
				{
					//if valid sets first button to 2nd color
					{
						try
						{
							buttonImage = ImageIO.read(new File("color2Button.png"));
							buttonImg = new ImageIcon(buttonImage);
							solButton.setIcon(buttonImg);
						}
						catch(IOException ex){}
						// if valid adds to counter
						counter ++;
					}
				}
			}
			else //second Button
			{
				if(imageName.equals("whiteButton.png"))// has to be empty
				{
					secondButton = solButton;
					//gets second ButtonPanel's row and col array
					for(int l = 0; l <PegSolitaire.board[0].length; l++)
					{
						for(int m = 0; m < PegSolitaire.board[0].length; m++)
						{
							try
							{
								if(PegSolitaire.board[l][m].getComponent(0) == solButton)
								{
									secondButtonRow = l;
									secondButtonCol = m;
									l = PegSolitaire.board.length;
									m = PegSolitaire.board.length;
								}
							}
							catch(ArrayIndexOutOfBoundsException ex){}
						}
					}

					//checks top make sure second click is two spaces from first click ans either in the same col or row
					if((Math.abs(firstButtonRow - secondButtonRow) == 2 && firstButtonCol == secondButtonCol) || (Math.abs(firstButtonCol - secondButtonCol) == 2 && firstButtonRow == secondButtonRow))
					{
						//finds which peg was jumped
						//above
						if(firstButtonRow - secondButtonRow == 2)
						{
							jumpedButtonRow = firstButtonRow - 1;
							jumpedButtonCol = firstButtonCol;
						}
						//below
						else if(secondButtonRow - firstButtonRow == 2)
						{
							jumpedButtonRow = firstButtonRow + 1;
							jumpedButtonCol = firstButtonCol;
						}
						//to left
						else if(firstButtonCol - secondButtonCol == 2)
						{
							jumpedButtonRow = firstButtonRow;
							jumpedButtonCol = firstButtonCol - 1;
						}
						else
						{
							jumpedButtonRow = firstButtonRow;
							jumpedButtonCol = firstButtonCol + 1;
						}

						//changes all the button icons

						//button being jumped has to be a color button

						if(((ButtonPanel)(PegSolitaire.board[jumpedButtonRow][jumpedButtonCol])).imageName.equals("colorButton.png"))
						{
							try
							{
								//first to white
								buttonImage = ImageIO.read(new File("whiteButton.png"));
								buttonImg = new ImageIcon(buttonImage);
								firstButton.setIcon(buttonImg);
								((ButtonPanel)(PegSolitaire.board[firstButtonRow][firstButtonCol])).imageName = "whiteButton.png";

								//sets jumnpedButton image to white
								jumpedButton = (ShapedButton)(PegSolitaire.board[jumpedButtonRow][jumpedButtonCol].getComponent(0));
								jumpedButton.setIcon(buttonImg);
								//sets jumped button image name to white
								((ButtonPanel)(PegSolitaire.board[jumpedButtonRow][jumpedButtonCol])).imageName = "whiteButton.png";

								//second color button
								buttonImage = ImageIO.read(new File("colorButton.png"));
								buttonImg = new ImageIcon(buttonImage);
								secondButton.setIcon(buttonImg);
								((ButtonPanel)(PegSolitaire.board[secondButtonRow][secondButtonCol])).imageName = "colorButton.png";
							}
							catch(IOException u){}

							counter ++; //if valid click, add 1 to counter

							winCounter = 0;

							//check to see if win by checking for how many havew color icon
							for(int q = 0; q< PegSolitaire.board.length; q++)
							{
								for(int r = 0; r < PegSolitaire.board[0].length; r++)
								{
									if(PegSolitaire.board[q][r] instanceof ButtonPanel)
									{
										if(((ButtonPanel)(PegSolitaire.board[q][r])).imageName.equals("colorButton.png"))
										{
											winCounter++;
										}
									}
								}
							}
							if(winCounter == 1) //if only one peg is left
							{
								if(!PegSolitaire.centerFlag)
								{
									JOptionPane.showMessageDialog(null, "You Are A Winner", "Winner", JOptionPane.INFORMATION_MESSAGE);
								}
								else
								{
									if(((ButtonPanel)(PegSolitaire.board[3][3])).imageName.equals("colorButton.png"))
									{
										JOptionPane.showMessageDialog(null, "You Are A Winner", "Winner", JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										JOptionPane.showMessageDialog(null, "You Suck", "Looser", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							}
							else
							{
								//if did not win checks to see if they lost
								moveLeft = false;
								for(int r = 0; r < PegSolitaire.board.length; r++)
								{
									for(int s = 0; s< PegSolitaire.board[0].length; s++)
									{
										if(PegSolitaire.board[r][s] instanceof ButtonPanel && ((ButtonPanel)(PegSolitaire.board[r][s])).imageName.equals("colorButton.png"))
										{
											//checks for valid move below
											if(r+2 < PegSolitaire.board.length)
											{
												if(PegSolitaire.board[r+1][s] instanceof ButtonPanel && PegSolitaire.board[r + 2][s] instanceof ButtonPanel)
												{
													if(((ButtonPanel)(PegSolitaire.board[r+1][s])).imageName.equals("colorButton.png") && ((ButtonPanel)(PegSolitaire.board[r+2][s])).imageName.equals("whiteButton.png"))
													{
														moveLeft = true;
													}
												}
											}
											//checks for valid move above
											if(r-2 >= 0)
											{
												if(PegSolitaire.board[r-1][s] instanceof ButtonPanel && PegSolitaire.board[r - 2][s] instanceof ButtonPanel)
												{
													if(((ButtonPanel)(PegSolitaire.board[r-1][s])).imageName.equals("colorButton.png") && ((	ButtonPanel)(PegSolitaire.board[r-2][s])).imageName.equals("whiteButton.png"))
													{
														moveLeft = true;
													}
												}
											}
											//checks for valid move right
											if(s + 2 < PegSolitaire.board[0].length)
											{
												if(PegSolitaire.board[r][s+1] instanceof ButtonPanel && PegSolitaire.board[r][s + 2] instanceof ButtonPanel)
												{
													if(((ButtonPanel)(PegSolitaire.board[r][s + 1])).imageName.equals("colorButton.png") && ((	ButtonPanel)(PegSolitaire.board[r][s + 2])).imageName.equals("whiteButton.png"))
													{
														moveLeft = true;
													}
												}
											}
											//checks for valid move left
											if(s - 2 >= 0)
											{
												if(PegSolitaire.board[r][s-1] instanceof ButtonPanel && PegSolitaire.board[r][s - 2] instanceof ButtonPanel)
												{
													if(((ButtonPanel)(PegSolitaire.board[r][s - 1])).imageName.equals("colorButton.png") && ((	ButtonPanel)(PegSolitaire.board[r][s - 2])).imageName.equals("whiteButton.png"))
													{
														moveLeft = true;
													}
												}
											}
										}//end of if
									}//end of inner for
								}//end of outer for
								if(!moveLeft)
								{
									JOptionPane.showMessageDialog(null,"There are no moves left!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
								}
							}//end of else
						}//end of if
					}//end of if
				}
			}
		}
	}
}






