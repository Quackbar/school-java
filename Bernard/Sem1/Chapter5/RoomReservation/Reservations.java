/*
	Bernard.K
	Reserve a party room




*/

 import javax.swing.JOptionPane;
 import java.awt.*;
 import java.awt.event.*;
import static java.awt.BorderLayout.*;

 public class Reservations extends Frame implements ActionListener
 {
	 Color lightRed = new Color(255,90,90);
	 Color lightGreen = new Color(140,215,40);

	 Rooms room = new Rooms(5,3);

	 Panel roomPanel = new Panel();
	 	TextArea roomDisplay[] = new TextArea[9];

	 Panel buttonPanel = new Panel();
	 	Button bookButton = new Button("Book Room");

	 Panel inputPanel = new Panel();
	 	Label custNameLabel = new Label("Name ");
	 	TextField nameField = new TextField(15);
	 	Label custPhoneLabel = new Label("Phone Number");
	 	TextField phoneField = new TextField(15);
 	 	Label numLabel = new Label("Number in Party");
	 	Choice numberOfGuests = new Choice();
 	 	CheckboxGroup Options = new CheckboxGroup();
	 		Checkbox nonsmoking = new Checkbox("Nonsmoking",false,Options);
	 		Checkbox smoking = new Checkbox("smoking",false,Options);
	 		Checkbox hidden = new Checkbox("",true,Options);

	public Reservations()
	{
		//set Layout for frame and three panels
		this.setLayout(new BorderLayout());
			roomPanel.setLayout(new GridLayout(2,4,10,10));
			buttonPanel.setLayout(new FlowLayout());
			inputPanel.setLayout(new FlowLayout());

		//add components to room panel
		for (int i=1; i<9; i++)
		{
			roomDisplay[i] = new TextArea(null,3,5,3);
			if (i<6)
				roomDisplay[i].setText("Room " + i + " NonSmoking");
			else
				roomDisplay[i].setText("Room " + i + " Smoking");
			((TextArea) roomDisplay[i]).setEditable(false);
			roomDisplay[i].setBackground(lightGreen);
			roomPanel.add(roomDisplay[i]);
 		}

		//add components to button panel
		buttonPanel.add(bookButton);

		//add components to input Label
		inputPanel.add(custNameLabel);
		inputPanel.add(nameField);
		inputPanel.add(custPhoneLabel);
		inputPanel.add(phoneField);
 		inputPanel.add(numLabel);
		inputPanel.add(numberOfGuests);
			for(int i= 8; i<=20; i++)
				numberOfGuests.add(String.valueOf(i));
		inputPanel.add(nonsmoking);
 		inputPanel.add(smoking);

		//add panels to frame
		add(buttonPanel, SOUTH);
		add(inputPanel, CENTER);
		add(roomPanel, NORTH);

		bookButton.addActionListener(this);
		//overriding the windowClosing() method will allow users to click the close button
		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
 				}
			}
		);
	}//end of constructor method

	public static void main(String[] args)
	{
		Reservations f = new Reservations();
		f.setBounds(200,200,600,300);
		f.setTitle("Reserve a Party Room");
		f.setVisible(true);
 	}//end of main

	public void actionPerformed(ActionEvent e)
	{
		if(hidden.getState())
		{
			JOptionPane.showMessageDialog(null,"YOU MUST SELECT SMOKING OR NONSMOKING", "Error",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			int available = room.bookRoom(smoking.getState());

			if(available > 0) //room is available
			{

				roomDisplay[available].setBackground(lightRed); // display room as occupied
                roomDisplay[available].setText(roomDisplay[available].getText() + "\n" + nameField.getText() + " " + phoneField.getText() + "\nparty of " +  numberOfGuests.getSelectedItem());
                clearFields();
			}
			else
			{
					if(smoking.getState())
						JOptionPane.showMessageDialog(null,"Smoking is full.","Error",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,"Nonsmoking is fuul.","Error",JOptionPane.INFORMATION_MESSAGE);
					hidden.setState(true);
			}
		}
	}


 	void clearFields()
 	{
 		nameField.setText("");
 		phoneField.setText("");
 		numberOfGuests.select(0);
 		nameField.requestFocus();
 		hidden.setState(true);
 	}
 }
