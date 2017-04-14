import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Looping extends Frame implements ActionListener
{

	TextField[] textField = new TextField[16];

	int start = 0, step = 0, stop = 0;

	TextField startField = new TextField();
	TextField stopField = new TextField();
	TextField stepField = new TextField();

	Label startLabel = new Label("Start");
	Label stopLabel = new Label("Stop");
	Label stepLabel = new Label("Step");

	Button go = new Button("Go");
	Button clear = new Button("Clear");

	Panel arrayPanel = new Panel();
	Panel fieldsPanel = new Panel();
	Panel buttonPanel = new Panel();
	Panel southPanel = new Panel();

	public Looping()
	{
		this.setLayout(new BorderLayout());
		arrayPanel.setLayout(new GridLayout(4,4,10,10));
		fieldsPanel.setLayout(new GridLayout(2,3,4,4));;
		buttonPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new GridLayout(2,3,10,10));

		for(int i = 0; i < 16; i++)
		{
			textField[i] = new TextField();
			textField[i].setText(String.valueOf(i));
			textField[i].setEditable(false);
			textField[i].setBackground(Color.green);
			arrayPanel.add(textField[i]);
		}
		fieldsPanel.add(startField);
		fieldsPanel.add(stopField);
		fieldsPanel.add(stepField);
		fieldsPanel.add(startLabel);
		fieldsPanel.add(stopLabel);
		fieldsPanel.add(stepLabel);

		southPanel.add(fieldsPanel);
		southPanel.add(buttonPanel);

		buttonPanel.add(go);
			go.addActionListener(this);
		buttonPanel.add(clear);
			clear.addActionListener(this);

		add(arrayPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		add(new Panel(), BorderLayout.NORTH);
		add(new Panel(), BorderLayout.EAST);
		add(new Panel(), BorderLayout.WEST);

		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					JOptionPane.showMessageDialog(null, "Thanks for using this program!");
					dispose();
					System.exit(0);
				}
			}
		);

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == go)
		{
			try
			{
				start = Integer.parseInt(startField.getText());
				stop = Integer.parseInt(stopField.getText());
				step = Integer.parseInt(stepField.getText());

				if(start > 16 || stop > 16 || step > 16)
				{
					JOptionPane.showMessageDialog(null,"Please Enter values less than 16!");
					startField.setText("");
					stopField.setText("");
					stepField.setText("");

				}
				else
				{
					for(int i = start; i <= stop && i<16; i += step)
					{
						((TextField) textField[i]).setBackground(Color.blue);
					}
				}
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Only enter a number in the Start, Stop, and Step Fields");
				startField.setText("");
				stopField.setText(" ");
				stepField.setText(" ");


			}


		}
		if(e.getSource() == clear)
		{
			for(int i = 0; i<16; i ++)
			{
				((TextField)textField[i]).setBackground(Color.green);
				arrayPanel.validate();
			}
			startField.setText("");
			stopField.setText("");
			stepField.setText("");
		}

	}
	public static void main(String[] args)
	{
		Looping looping = new Looping();
		looping.setBounds(50, 100, 300, 400);
		looping.setVisible(true);
		looping.startField.requestFocus();
	}

}