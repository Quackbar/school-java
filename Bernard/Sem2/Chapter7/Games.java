import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class Games extends JFrame implements ActionListener
{
	String foo;
	String sub;
	String input;
	int j;
	int bar = 1;
	String game[] = new String[5];
	JComboBox box = new JComboBox();
	JLabel label = new JLabel("");
	Font f = new Font("Denmark", Font.PLAIN, 70);

	public Games()
	{
		this.setLayout(new GridLayout(0,2));
		add(box);
		box.addActionListener(this);
		ask();
		add(label);
	}
	public void sort(String tempArray[])
	{
		for(int pass = 1; pass < tempArray.length; pass++)
		{
			for(int element = 0; element < tempArray.length - 1; element++)
			{
				if(tempArray[element].compareTo(tempArray[element + 1])>0)
				{
					swap(game, element, element + 1);
				}
			}
		}
	}
	public void swap(String swapArray[], int first, int second)
	{
		String hold;
		hold = swapArray[first];
		swapArray[first] = swapArray[second];
		swapArray[second] = hold;
	}
	public void swap(int swapArray[], int first, int second)
	{
		int hold;
		hold = swapArray[first];
		swapArray[first] = swapArray[second];
		swapArray[second] = hold;
    }
	public void ask()
	{
		for(int i = 0; i<game.length; i++)
		{
			if(i == 0)
			{
				j = i+1;
				sub = "st";
			}
			else if(i == 1)
			{
				j = i+1;
				sub = "nd";
			}
			else if(i == 2)
			{
				j = i+1;
				sub = "rd";
			}
			else if(i == 3)
			{
				j = i+1;
				sub = "th";
			}
			else if(i == 4)
			{
				j = i+1;
				sub = "th";
			}
			try
			{
				foo = String.valueOf(JOptionPane.showInputDialog(null, "Enter the title of your " + j + sub + " game, or type null to break out"));
				if(foo.equals("null"))
				{
					i = game.length;
				}
				else
				{
					game[i] = foo;
				}
			}
			catch(Exception a)
			{
				JOptionPane.showMessageDialog(null,"You can only enter letters");
				i--;
			}
		}
		sort(game);
		for(int i = 0; i<game.length; i++)
		{
			box.addItem(game[i]);
		}

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == box)
		{
			if(bar == 1)
			{
				bar++;
				label.setText("  ");
			}
			else
			{
				System.out.println("in");
				input = (String)(box.getSelectedItem());
				label.setText(input);
			}
		}
	}
	public static void main(String args[])
	{
		Games g = new Games();
		g.setVisible(true);
		g.setSize(350,100);
	}
}