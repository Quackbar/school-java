import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Classes6 extends Frame implements ActionListener
{
	Button[] bu = new Button[9];
	Label classy = new Label("School");
	Panel center = new Panel();

	Classes6()
	{
		this.setLayout(new BorderLayout());
		add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(3,3));
		for(int i = 0; i< bu.length; i++)
		{
			bu[i] = new Button();
			center.add(bu[i]);
			bu[i].addActionListener(this);
			bu[i].setLabel("Period" + i);
		}
		add(classy, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == bu[0])
		{
			classy.setText("Math");
		}
		else if(e.getSource() == bu[1])
		{

		}
		else if(e.getSource() == bu[2])
		{

		}
		else if(e.getSource() == bu[3])
		{

		}
		else if(e.getSource() == bu[4])
		{

		}
		else if(e.getSource() == bu[5])
		{

		}
		else if(e.getSource() == bu[6])
		{

		}
		else if(e.getSource() == bu[7])
		{

		}
		else if(e.getSource() == bu[8])
		{

		}
	}

	public static void main(String[] args)
	{
		Classes6 c = new Classes6();
		c.setVisible(true);
	}
}