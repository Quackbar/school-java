import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class RentingFrame extends Panel implements ActionListener
{
	int nights = 0;
	String[] vehicleArray = {"Choose Vehicle","Tent $11.20", "Pop-Up $23.17", "Travel Trailer $58.34", "Fifth Wheel $73.46", "Motor Home $149.85"};
	String[] hookupsArray = {"Choose Hookups", "Water Only $13.19", "Water and Electricity $51.84", "Water, Electricity, and Sewer $73.14","No Hookups $2.78"};
	String[] stateArray = {"Choose State", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
	"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",  "Maine", "Maryland", "Massachusetts", "Michigan",  "Minnesota", "Mississippi","Missouri", "Montana",
	"Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
	"Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",  "West Virginia", "Wisconsin", "Wyoming"};
	String[] errorArray = new String[10];
	Label firstNameLabel = new Label("First Name ");
	Label lastNameLabel = new Label("Last Name ");
	Label addressLabel = new Label("Address ");
	Label cityLabel = new Label("City ");
	Label stateLabel = new Label("State ");
	Label vehicleLabel = new Label("       Select Vehicle Type ");
	Label hookupsLabel = new Label("       Select Hookups ");
	Label arrivalLabel = new Label("       Arrival Date ");
	Label nightsLabel = new Label("       Number of Nights ");
	Label zipLabel = new Label("       Zip Code ");
	TextField firstNameField = new TextField("");
	TextField lastNameField = new TextField("");
	TextField addressField = new TextField("");
	TextField cityField = new TextField("");
	TextField arrivalField = new TextField("");
	TextField nightsField = new TextField("0");
	TextField zipField = new TextField("");
	Button submitButton = new Button("Submit");
	Button clearButton = new Button("Clear");

	private JComboBox<String> vehicleBox = new JComboBox<String>();
	private JComboBox<String> hookupsBox = new JComboBox<String>();
	private JComboBox<String> stateBox = new JComboBox<String>();
	Panel westPanel = new Panel();
	Panel eastPanel = new Panel();
	Panel southPanel = new Panel();

	public RentingFrame()
	{
		Color blue = new Color(22, 148, 148);
		setBackground(blue);
		setForeground(Color.white);
		vehicleBox.setBackground(blue);
		hookupsBox.setBackground(blue);
		stateBox.setBackground(blue);
		vehicleBox.setForeground(Color.white);
		hookupsBox.setForeground(Color.white);
		stateBox.setForeground(Color.white);
		submitButton.setBackground(blue);
		clearButton.setBackground(blue);
	    firstNameField.setBackground(blue);
		lastNameField.setBackground(blue);
		addressField.setBackground(blue);
		cityField.setBackground(blue);
	    arrivalField.setBackground(blue);
	    nightsField.setBackground(blue);
	    zipField.setBackground(blue);


		this.setLayout(new BorderLayout());
		westPanel.setLayout(new GridLayout(5,2,10,10));
		eastPanel.setLayout(new GridLayout(5,2,10,10));
		southPanel.setLayout(new FlowLayout());
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		westPanel.add(firstNameLabel);
		westPanel.add(firstNameField);
		westPanel.add(lastNameLabel);
		westPanel.add(lastNameField);
		westPanel.add(addressLabel);
		westPanel.add(addressField);
		westPanel.add(cityLabel);
		westPanel.add(cityField);
		westPanel.add(stateLabel);
		westPanel.add(stateBox);
		eastPanel.add(vehicleLabel);
		eastPanel.add(vehicleBox);
		eastPanel.add(hookupsLabel);
		eastPanel.add(hookupsBox);
		eastPanel.add(arrivalLabel);
		eastPanel.add(arrivalField);
		eastPanel.add(nightsLabel);
		eastPanel.add(nightsField);
		eastPanel.add(zipLabel);
		eastPanel.add(zipField);
		southPanel.add(submitButton);
		submitButton.addActionListener(this);
		southPanel.add(clearButton);
		clearButton.addActionListener(this);
		for(int i = 0; i<6; i++)
		{
			vehicleBox.addItem(vehicleArray[i]);
		}
		for(int i = 0; i<5; i ++)
		{
			hookupsBox.addItem(hookupsArray[i]);
		}
		for(int i = 0; i<51; i++)
		{
			stateBox.addItem(stateArray[i]);
		}
	}
	public Button getSubmitButton()
	{
		return submitButton;
	}
	public Button getClearButton()
	{
		return clearButton;
	}
	public String[] getVehicleArray()
	{
		return vehicleArray;
	}
	public String[] getHookupsArray()
	{
		return hookupsArray;
	}
	public String firstNameField()
	{
		return firstNameField.getText();
	}

	private int foo()
	{
		String vehicle = (String) vehicleBox.getSelectedItem();
		String hookups = (String) hookupsBox.getSelectedItem();
		String state = (String) stateBox.getSelectedItem();
		int counter = 0;
		boolean work = true;

		if(firstNameField.getText().equals(""))
		{
			work = false;
			errorArray[counter] = "Missing first name, \n";
			counter ++;
		}
		if(lastNameField.getText().equals(""))
		{
			work = false;
			errorArray[counter] = "Missing last name, \n";
			counter++;
		}
		if(addressField.getText().equals(""))
		{
			work = false;
			errorArray[counter] = "Missing address, \n";
			counter++;
		}
		if(cityField.getText().equals(""))
		{
			work = false;
			errorArray[counter] = "Missing city, \n";
			counter++;
		}
		if(state.equals("Choose State"))
		{
			work = false;
			errorArray[counter] = "Missing state, \n";
			counter++;
		}
		if(vehicle.equals("Choose Vehicle"))
		{
			work = false;
			errorArray[counter] = "Missing vehicle, \n";
			counter++;
		}
		if(hookups.equals("Choose Hookups"))
		{
			work = false;
			errorArray[counter] = "Missing hookups, \n";
			counter++;
		}
		if(arrivalField.getText().equals(""))
		{
			work = false;
			errorArray[counter] = "Missing arrival date, \n";
			counter++;
		}
		try
		{
			int nights = Integer.parseInt(nightsField.getText());
			if(nights<=0)
			{
				work = false;
				errorArray[counter] = "Missing number of nights, \n";
				counter++;
			}
		}
		catch(NumberFormatException e)
		{
			work = false;
			errorArray[counter] = "Missing number of nights, \n";
			counter++;
		}

		try
		{
			int zip = Integer.parseInt(zipField.getText());
		}
		catch(NumberFormatException e)
		{
			work = false;
			errorArray[counter] = "Missing zip code, \n";
			counter ++;
		}
		return counter;
	}

		public void actionPerformed(ActionEvent button)
		{
			if(button.getSource() == submitButton)
			{
				int thing = foo();

				if(thing >0)
				{
					String emptyString = new String();
					for(int i = 0; i<thing; i++)
				{
					emptyString += errorArray[i];
				}
					JOptionPane.showMessageDialog(null,""+ emptyString);
			}
			else
			{
				int sum = 0;
				String vehicle = (String) vehicleBox.getSelectedItem();
				String hookups = (String) hookupsBox.getSelectedItem();

				if(vehicle.equals("Tent $11.20"))
				{
					sum += 11.20;
				}
				if(vehicle.equals("Pop-Up $23.17"))
				{
					sum += 23.17;
				}
				if(vehicle.equals("Travel Trailer $58.34"))
				{
					sum +=58.34;
				}
				if(vehicle.equals("Fifth Wheel $73.46"))
				{
					sum += 73.46;
				}
				if(vehicle.equals("Motor Home $149.85"))
				{
					sum += 149.85;
				}
				if(hookups.equals("Water Only $13.19"))
				{
					sum += 13.19;
				}
				if(hookups.equals("Water and Electricity $51.84"))
				{
					sum += 51.84;
				}
				if(hookups.equals("Water, Electricity, and Sewer $71.34"))
				{
					sum += 75;
				}
				if(hookups.equals("No Hookups $2.78"))
				{
					sum += 2.78;
				}
				System.out.println(""+sum);
				nights = Integer.parseInt(nightsField.getText());
				sum*=nights;
				String name = firstNameField();
				JOptionPane.showMessageDialog(null, name + ", your final cost is $" + sum);
			}
		}
		if(button.getSource() == clearButton)
		{
			firstNameField.setText(" ");
			lastNameField.setText(" ");
			addressField.setText(" ");
			cityField.setText(" ");
			stateBox.setSelectedIndex(0);
			vehicleBox.setSelectedIndex(0);
			hookupsBox.setSelectedIndex(0);
			arrivalField.setText(" ");
			nightsField.setText("0");
			zipField.setText(" ");
			validate();
		}
	}
}
