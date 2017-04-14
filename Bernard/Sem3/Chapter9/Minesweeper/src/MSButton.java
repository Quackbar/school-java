import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class MSButton extends JButton
{
	private BufferedImage buttonImage;
	private ImageIcon buttonImg;
	private int adjBombNum, rClickedNum;
	
	public MSButton()
	{
		addMouseListener(
			new MouseAdapter()
			{
				//if e.getClickCount() == 2
				public void mouseClicked(MouseEvent e)
				{
					//if e.getClickCount() == 2  Double click
					//if(e.getButton() == MouseEvent.BUTTON1) //left click
					//if(e.getButton() == MouseEvent.BUTTON2) //middle click
					if(e.getButton() == MouseEvent.BUTTON3)   //right click
					{
						for(int n = 0; n < MineSweeper.buttons.length; n++)
						{
							for(int p = 0; p < MineSweeper.buttons[0].length; p++)
							{
								rClickedNum++;
								
								if(rClickedNum % 3 == 1)
								{
									setButtonImageIcon("Flag.png");
									removeActionListener(MineSweeper.f1);
								}
								else if(rClickedNum % 3 == 2)
								{
									setButtonImageIcon("Question.png");
								}
								else
								{
									setIcon(null);
									addActionListener(MineSweeper.f1);
								}
								p = MineSweeper.buttons[0].length;
								n = MineSweeper.buttons.length;
							}
						}
					}
				}
			}
		);
	}
	
	public int getAdjBombNum()
	{
		return adjBombNum;
	}
	
	public ImageIcon getButtonImg()
	{
		return buttonImg;
	}
	
	public BufferedImage getButtonImage()
	{
		return buttonImage;
	}
	
	public int getRClickedNum()
	{
		return rClickedNum;
	}
	
	public void setAdjBombNum(int adjNum)
	{
		adjBombNum = adjNum;
	}
	
	public void setButtonImageIcon(String imgName)
	{
		try
		{
			buttonImage = ImageIO.read(new File(imgName));
			buttonImg = new ImageIcon(buttonImage);
			setIcon(buttonImg);
		}
		catch(IOException ex){}
	}
	
	public void setRClickedNum(int rNum)
	{
		rClickedNum = rNum;
	}
}
