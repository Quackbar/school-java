/*




*/

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class BillPayer extends JFrame implements ActionListener
{
	String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",  "Maine", "Maryland", "Massachusetts", "Michigan",  "Minnesota", "Mississippi","Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming","AL","AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};

	//Declare output stream
	DataOutputStream output;

	//Construct a panel for each row
	JPanel firstRow = new JPanel();
	JPanel secondRow = new JPanel();
	JPanel thirdRow = new JPanel();
	JPanel fourthRow = new JPanel();
	JPanel fifthRow = new JPanel();
	JPanel sixthRow = new JPanel();
	JPanel seventhRow = new JPanel();
	JPanel eighthRow =  new JPanel();

	//Construct a panel for the feilds and buttons
	JPanel fieldPanel = new JPanel();
	JPanel buttonPanel = new JPanel();

	//Construct labels and textboxes
	JLabel acctNumLabel = new JLabel("Account Number:                          ");
		JTextField acctNum = new JTextField(15);
	JLabel pmtLabel = new JLabel("Payment Amount:");
		JTextField pmt = new JTextField(10);
	JLabel firstNameLabel = new JLabel("First Name:                 ");
		JTextField firstName = new JTextField(10);
	JLabel lastNameLabel = new JLabel("Last Name:");
		JTextField lastName = new JTextField(20);
	JLabel addressLabel = new JLabel("Address:");
		JTextField address = new JTextField(35);
	JLabel cityLabel = new JLabel("City:                              ");
		JTextField city = new JTextField(10);
	JLabel stateLabel = new JLabel("State: ");
		JTextField state = new JTextField(2);
	JLabel zipLabel = new JLabel("Zip:");
		JTextField zip = new JTextField(9);

	//Construct button
	JButton submitButton = new JButton("Submit");

	public static void main(String args[])
	{
		//set the look and feel of the interface
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "The UIManager could not set the look and Feel for this application.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}

		BillPayer f = new BillPayer();
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setSize(450,300);
		f.setTitle("Crandall Power and Light Customer Payments");
		f.setLocation(200,200);
		f.setVisible(true);
	}
	public BillPayer()
	{
		Container c = getContentPane();
		c.setLayout((new BorderLayout()));
		fieldPanel.setLayout(new GridLayout(8,1));
		FlowLayout rowSetup = new FlowLayout(FlowLayout.LEFT, 5,3);
			firstRow.setLayout(rowSetup);
			secondRow.setLayout(rowSetup);
			thirdRow.setLayout(rowSetup);
			fourthRow.setLayout(rowSetup);
			fifthRow.setLayout(rowSetup);
			sixthRow.setLayout(rowSetup);
			seventhRow.setLayout(rowSetup);
			eighthRow.setLayout(rowSetup);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		//Add fields to rows
		firstRow.add(acctNumLabel);
		firstRow.add(pmtLabel);

		secondRow.add(acctNum);
		secondRow.add(pmt);

		thirdRow.add(firstNameLabel);
		thirdRow.add(lastNameLabel);

		fourthRow.add(firstName);
		fourthRow.add(lastName);

		fifthRow.add(addressLabel);

		sixthRow.add(address);

		seventhRow.add(cityLabel);
		seventhRow.add(stateLabel);
		seventhRow.add(zipLabel);

		eighthRow.add(city);
		eighthRow.add(state);
		eighthRow.add(zip);

		//Add rows to panel
		fieldPanel.add(firstRow);
		fieldPanel.add(secondRow);
		fieldPanel.add(thirdRow);
		fieldPanel.add(fourthRow);
		fieldPanel.add(fifthRow);
		fieldPanel.add(sixthRow);
		fieldPanel.add(seventhRow);
		fieldPanel.add(eighthRow);

		//Add buton to panel
		buttonPanel.add(submitButton);

		//Add panels to frame
		c.add(fieldPanel, BorderLayout.CENTER);
		c.add(buttonPanel, BorderLayout.SOUTH);

		//Add functionality to buttons
		submitButton.addActionListener(this);

		//Get the current date and open the file
		Date today = new Date();
		SimpleDateFormat myFormat = new SimpleDateFormat("MMddyyyy");
		String filename = "payments" + myFormat.format(today);

		try
		{
			output = new DataOutputStream(new FileOutputStream(filename));
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null, "The program could not create a storage location. Please check the disk drive and then run the program again.","ERROR", JOptionPane.INFORMATION_MESSAGE);
			System.exit(1);
		}

		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit and submit the file", "File Submission",JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.YES_OPTION)
					System.exit(0);
				}
			}
		);
	}
	public void actionPerformed(ActionEvent e)
	{
		String arg = e.getActionCommand();

		if(checkFields())
		{
			int foo;
			boolean bar = false;
			try
			{

				for(int i = 0; i<states.length; i++)
				{
					if(state.getText().equals(states[i]))
					{
						i = states.length;
						bar = true;
					}
					else
					{
						bar = false;
					}
				}
				if(bar == false)
				{
					JOptionPane.showMessageDialog(null,"You must enter a valid state");
				}
				else
				{
					output.writeUTF(acctNum.getText());
					output.writeUTF(pmt.getText());
					output.writeUTF(firstName.getText());
					output.writeUTF(lastName.getText());
					output.writeUTF(address.getText());
					output.writeUTF(city.getText());
					output.writeUTF(state.getText());
					output.writeUTF(zip.getText());
					foo = Integer.parseInt(acctNum.getText());
					foo = Integer.parseInt(zip.getText());
					foo = Integer.parseInt(pmt.getText());

					JOptionPane.showMessageDialog(null, "The payment information has been saved.", "Data Entry Error", JOptionPane.WARNING_MESSAGE);
					clearFields();
				}
			}
			catch(IOException c)
			{
				System.exit(0);
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null, "You can only enter numerical values for the Account Number field,\n the Payment Amount Field and the Zip field", "Submission Successful", JOptionPane.INFORMATION_MESSAGE);
				bar = true;
			}
		}
	}
	public boolean checkFields()
	{
		if((acctNum.getText().compareTo("")<1)         ||
		   (pmt.getText().compareTo("")<1)             ||
		   (firstName.getText().compareTo("")<1)       ||
		   (lastName.getText().compareTo("")<1)        ||
	       (address.getText().compareTo("")<1)         ||
		   (city.getText().compareTo("")<1)            ||
		   (state.getText().compareTo("")<1)           ||
		   (zip.getText().compareTo("")<1))
		   {
			   JOptionPane.showMessageDialog(null, "You must fill in all the fields.", "Data Entry Error", JOptionPane.WARNING_MESSAGE);
			   return false;
		   }
		else
		{
			return true;
		}
	}

	public void clearFields()
	{
		//Clear fields and reset the focus
		acctNum.setText("");
		pmt.setText("");
		firstName.setText("");
		lastName.setText("");
		address.setText("");
		city.setText("");
		state.setText("");
		zip.setText("");
		acctNum.requestFocus();
	}
}