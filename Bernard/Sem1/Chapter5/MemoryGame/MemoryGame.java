import java.awt.*;
import java.awt.event.*;
import java.util.Random.*;
import javax.swing.*;

public class MemoryGame extends Frame implements ActionListener
{
	// this creates the array, but does not create the MemoryCells
	MemoryCell[] cells  = new MemoryCell[16];
	//first and second are the 2 cells trying to be matched
	MemoryCell first, second;
	Panel cellPanel = new Panel(new GridLayout(4,4,10,10));
	Panel infoPanel = new Panel();
	Label mismatchesLabel = new Label();
	Button reset = new Button("Reset");
	int nMismatched;
	Game thisGame = new Game();
	UIManager um = new UIManager();

	//constructor
	public MemoryGame()
	{
		thisGame.setGameName("Memory");
		um.put("OptionPane.background",Color.cyan);
		um.put("Panel.background",Color.magenta);
		um.put("OptionPane.messageForeground",Color.white);
		thisGame.setPlayerName(JOptionPane.showInputDialog("What is your name?"));

		//mouse Listener to add to sells to see which get picked
		MouseListener ml = new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				MemoryCell clickedCell = (MemoryCell)e.getSource();
				if(second != null)
				{
					first.setFocused(false);
					second.setFocused(false);
					if(!first.matches(second))
					{
						first.setHidden(true);
						second.setHidden(true);
						nMismatched ++;
						mismatchesLabel.setText(thisGame.getPlayerName() + ", your mismatched =" +nMismatched);
						thisGame.setScore(nMismatched);
					}
					first = null;
					second = null;
				}
				if(clickedCell.getHidden())
				{
					clickedCell.setFocused(true);
					clickedCell.setHidden(false);
					if(first == null)
					{
						first = clickedCell;
					}
					else
					{
						second = clickedCell;
						if(first.matches(second))
						{
							first.setMatched(true);
							second.setMatched(true);
						}
					}
				}
			}
		};//end of moused pressed

		//adds window adaptor so frame will close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				JOptionPane.showMessageDialog(null, "Your score for " + thisGame.getGameName() + " =" + thisGame.getScore() + " misses.","Game Information", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				System.exit(0);
			}
		}
		);

		first = null;
		second = null;

		for(int i = 0; i < cells.length; i++)
		{
			cells[i] = new MemoryCell(MemoryCell.NONE);
			cells[i].addMouseListener(ml);
			cellPanel.add(cells[i]);
		}
		add(cellPanel, BorderLayout.CENTER);

		reset.addActionListener(this);
		infoPanel.add(reset);
		infoPanel.add(mismatchesLabel);
		add(infoPanel, BorderLayout.SOUTH);
		randomize();
	}

	public void actionPerformed(ActionEvent e)
	{
		randomize();
	}

	public void randomize()
	{
		//array is for all possible image pairs
		int[] pictPairs = new int[cells.length];
		int pos;

		//reinitialize all cells
		for(int j = 0; j < cells.length; j++)
		{
			cells[j].setMatched(false);
			cells[j].setHidden(true);
			cells[j].setFocused(false);
			cells[j].setPicture(MemoryCell.NONE);
			pictPairs[j] = j % 8; // assigns 2 elements the same number 0 through 7
		}

		for(int k = 0; k < pictPairs.length; k++)
		{
			//selects a random cell to set picture while all cells dont have pictures
			do
			{
				pos = (int)(Math.random() * cells.length);
			}while(cells[pos].getPicture() !=MemoryCell.NONE); //finds memory cell wuth no picture in it
			cells[pos].setPicture(pictPairs[k]);
		}
		//reset first and second mismatched label, nMismatched
		first = null;
		second = null;
		nMismatched = 0;
		mismatchesLabel.setText(thisGame.getPlayerName() + ", your mismatches = 0");
		invalidate();
		validate();
	}



	public static void main(String args[])
	{
		MemoryGame f1 = new MemoryGame();
		f1.setTitle("Memory Game");
		f1.setBounds(10,10,300,300);
		f1.setResizable(false);
		f1.setVisible(true);
	}
}