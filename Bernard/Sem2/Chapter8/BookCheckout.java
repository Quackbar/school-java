import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class BookCheckout extends JFrame implements ActionListener
{
	DataOutputStream op;

	String titleString;

	Font fon = new Font("Arial", Font.PLAIN, 36);

	JPanel lPanel = new JPanel();
	JPanel tPanel = new JPanel();
	JPanel sPanel = new JPanel();

	JButton subButton = new JButton("Submit");

	JLabel dateLabel = new JLabel("Date:");
	JLabel nameLabel = new JLabel("Name:");
	JLabel titleLabel = new JLabel("Title:");

	JTextField dateField = new JTextField();
	JTextField nameField = new JTextField();
	JTextField titleField = new JTextField();

	public BookCheckout()
	{
		try
		{
			titleString = JOptionPane.showInputDialog(null,"Enter a name for your file:");
		}
		catch(Exception e)
		{
			JOptionPane.showInputDialog(null,"We could not create the file name, please try again");
		}
		this.setLayout(new BorderLayout());
		this.setBackground(Color.gray);
		add(lPanel, BorderLayout.WEST);
			lPanel.setLayout(new GridLayout(3,0));
			lPanel.add(dateLabel);
			lPanel.add(nameLabel);
			lPanel.add(titleLabel);
		add(tPanel, BorderLayout.CENTER);
			tPanel.setLayout(new GridLayout(3,0));
			tPanel.add(dateField);
			dateField.setEditable(false);
			dateField.setFont(fon);
			tPanel.add(nameField);
			nameField.setFont(fon);
			tPanel.add(titleField);
			titleField.setFont(fon);
		add(sPanel, BorderLayout.SOUTH);
			sPanel.add(subButton);
			subButton.addActionListener(this);

		Date today = new Date();
		SimpleDateFormat sdm = new SimpleDateFormat("M/dd/yy");

		dateField.setText("" + sdm.format(today));

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == subButton)
		{
			if(checkFields())
			{
				JOptionPane.showMessageDialog(null, "You need to fill in all of the fields.");
			}
			else
			{
				String filename = titleString;
				try
				{
					op = new DataOutputStream(new FileOutputStream(filename));
					op.writeUTF(dateField.getText());
					op.writeUTF(titleField.getText());
					op.writeUTF(nameField.getText());
					JOptionPane.showMessageDialog(null, "Your file was saved.");
					titleField.setText("");
					nameField.setText("");
					nameField.requestFocus();
				}
				catch(IOException ioex)
				{
					JOptionPane.showMessageDialog(null, "There was an error while trying to save the file.");
				}

			}
		}
	}

	public boolean checkFields()
	{
		if(nameField.getText().equals("") || titleField.getText().equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args)
	{
		BookCheckout bc = new BookCheckout();
		bc.setBounds(200,200,300,300);
		bc.setVisible(true);
	}
}