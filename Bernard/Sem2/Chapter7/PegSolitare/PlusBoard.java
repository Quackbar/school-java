import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class PlusBoard
{
	boolean valid; //keeps track of whether it is a valid space to add a button panel

	public PlusBoard()
	{
		for(int j = 0; j<PegSolitaire.board.length; j ++)
		{
			for(int k = 0; k<PegSolitaire.board[0].length; k ++)
			{
				valid = true;
				//checks for JPanels
				if((j == 0) || (j == 1) || (j == 5) || (j == 6))
				{
					if((k == 0) || (k == 1) || (k == 5) || (k == 6))
					{
						valid = false;
						PegSolitaire.board[j][k] = new JPanel();
						PegSolitaire.board[j][k].setBackground(new Color(59,137,89));
					}
				}

				if(valid)
				{
					//sets the images on the buttons on the button panel
					if((j > 0 && j < 6 && k == 3) || (j == 3 && k > 0 && k < 6))
					{
						PegSolitaire.board[j][k] = new ButtonPanel("colorButton.png");
					}
					else
					{
						PegSolitaire.board[j][k] = new ButtonPanel("whiteButton.png");
					}
					PegSolitaire.board[j][k].setBackground(new Color(0,176,172));
					PegSolitaire.board[j][k].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				}
			}
		}
	}
}