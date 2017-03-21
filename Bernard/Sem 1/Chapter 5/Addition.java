import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Addition extends Frame implements ActionListener
{
	Button[] button = new Button[11];
	Button clear = new Button("Clear");
	Label sum = new Label();
	Label blank = new Label();

	Panel all = new Panel();
	Panel label = new Panel();

	int total = 0;
	public Addition()
	{

		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
			all.setLayout(new GridLayout(4,3));
		this.add(label, BorderLayout.SOUTH);
			label.setLayout(new GridLayout(1,1));

		for(int i = 0; i<11; i ++)
		{
			button[i] = new Button();
			button[i].setLabel(String.valueOf(i));
			button[i].setBackground(Color.green);
			all.add(button[i]);
				button[i].addActionListener(this);
		}
		all.add(clear);
			clear.addActionListener(this);
		clear.setBackground(Color.red);
		label.add(blank);
		label.add(sum);


	}

	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == clear)
		{
			total = 0;
			sum.setText("0");
			repaint();
			invalidate();
			revalidate();
		}
		else
		{
			for(int i = 0; i < button.length; i ++)
			{
				if(e.getSource() == button[i])
				{
					total += i;
				}
			}
			sum.setText(String.valueOf(total));
		}
	}
	public static void main(String args[])
	{
		Addition thing = new Addition();
		thing.setVisible(true);
		thing.setBounds(200,200,600,300);
	}
}
