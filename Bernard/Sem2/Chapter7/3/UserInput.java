import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class UserInput extends JFrame implements ActionListener
{
	int safe = 0;
	String state;
	String name;
	Boolean check = true;
	JTextPane textPane = new JTextPane();
	BufferedImage buttonImage;
	ImageIcon buttonImg;
	static UserInput u;

	String[] stateArray = {"Choose State", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",  "Maine", "Maryland", "Massachusetts", "Michigan",  "Minnesota", "Mississippi","Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",  "West Virginia", "Wisconsin", "Wyoming"};

	JLabel firstNameLabel = new JLabel("First Name ");
	JLabel lastNameLabel = new JLabel("Last Name ");
	JLabel addressLabel = new JLabel("Address ");
	JLabel cityLabel = new JLabel("City ");
	JLabel stateLabel = new JLabel("State ");
	JLabel zipLabel = new JLabel("Zip Code ");
	JLabel aLabel = new JLabel("  ");

	JLabel confirmALabel = new JLabel("");
	JLabel firstNameALabel = new JLabel("");
	JLabel lastNameALabel = new JLabel("");
	JLabel addressALabel = new JLabel("");
	JLabel cityALabel = new JLabel("");
	JLabel stateALabel = new JLabel("");
	JLabel zipALabel = new JLabel("");
	JLabel infoALabel = new JLabel("");

	JLabel northLabel = new JLabel("Bob's express delivery sign up");

	/*
	JTextField firstNameField = new JTextField("");
	JTextField lastNameField = new JTextField("");
	JTextField addressField = new JTextField("");
	JTextField cityField = new JTextField("");
	JTextField zipField = new JTextField("");
	*/


	JTextArea firstNameField = new JTextArea("",5,10);
	JTextArea lastNameField = new JTextArea("",5,10);
	JTextArea addressField = new JTextArea("",5,10);
	JTextArea cityField = new JTextArea("",5,10);
	JTextArea zipField = new JTextArea("",5,10);

	JPanel firstNamePanel = new JPanel();
	JPanel lastNamePanel = new JPanel();
	JPanel addressPanel = new JPanel();
	JPanel cityPanel = new JPanel();
	JPanel zipPanel = new JPanel();


	JButton[] checkButton = new JButton[7];
	Button submitButton = new Button("Submit");
	Button clearButton = new Button("Clear");
	Button backButton = new Button("Back");
	Button continueButton = new Button("Continue");

	private JComboBox<String> stateBox = new JComboBox<String>();

	JPanel labelPanel = new JPanel();
	JPanel textFieldPanel = new JPanel();
	JPanel aPanel = new JPanel();
	JPanel[] buttonsPanel = new JPanel[7];
	JPanel northPanel = new JPanel();
 	JPanel westPanel = new JPanel();
	JPanel eastPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel otroPanel = new JPanel();

	public UserInput()
	{
		this.setLayout(new BorderLayout());
		westPanel.setLayout(new GridLayout(1,2,10,10));
		eastPanel.setLayout(new GridLayout(9,1,10,10));
		southPanel.setLayout(new FlowLayout());
		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		northPanel.add(northLabel);
		westPanel.add(labelPanel);
		labelPanel.setLayout(new GridLayout(7,1));
		westPanel.add(textFieldPanel);
		textFieldPanel.setLayout(new GridLayout(7,2));
		//westPanel.add(textFieldPanel, new GridBagConstraints( 0, 0, 1, 1, 1.0,1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 0, 0, 0, 0 ), 0, 0 ) );
		//westPanel.add(aPanel);
		labelPanel.add(firstNameLabel);
		labelPanel.add(lastNameLabel);
		labelPanel.add(addressLabel);
		labelPanel.add(cityLabel);
		labelPanel.add(zipLabel);
		labelPanel.add(stateLabel);
		labelPanel.add(aLabel);
		for(int j = 0; j<checkButton.length; j++)
		{
			checkButton[j] = new JButton();
			checkButton[j].setPreferredSize(new Dimension(40,40));
			checkButton[j].setEnabled(true);
			checkButton[j].setVisible(false);
			buttonsPanel[j] = new JPanel();
			buttonsPanel[j].add(checkButton[j]);
		}
		textFieldPanel.add(firstNamePanel);
		firstNamePanel.add(firstNameField);
		firstNameField.setLineWrap(true);
		textFieldPanel.add(buttonsPanel[0]);
		textFieldPanel.add(lastNamePanel);
		lastNamePanel.add(lastNameField);
		lastNameField.setLineWrap(true);
		textFieldPanel.add(buttonsPanel[1]);
		textFieldPanel.add(addressPanel);
		addressPanel.add(addressField);
		addressField.setLineWrap(true);
		textFieldPanel.add(buttonsPanel[2]);
		textFieldPanel.add(cityPanel);
		cityPanel.add(cityField);
		cityField.setLineWrap(true);
		textFieldPanel.add(buttonsPanel[3]);
		textFieldPanel.add(zipPanel);
		zipPanel.add(zipField);
		zipField.setLineWrap(true);
		textFieldPanel.add(buttonsPanel[4]);
		textFieldPanel.add(stateBox);
		stateBox.addActionListener(this);
		textFieldPanel.add(buttonsPanel[5]);
			for(int i = 0; i<stateArray.length; i++)
			{
				stateBox.addItem(stateArray[i]);
			}
		eastPanel.add(confirmALabel);
		eastPanel.add(firstNameALabel);
		eastPanel.add(lastNameALabel);
		eastPanel.add(addressALabel);
		eastPanel.add(cityALabel);
		eastPanel.add(zipALabel);
		eastPanel.add(stateALabel);
		eastPanel.add(infoALabel);
		southPanel.add(submitButton);
		submitButton.addActionListener(this);
		southPanel.add(clearButton);
		clearButton.addActionListener(this);

		firstNameField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e)
			{
				if(firstNameField.getText().equals("Invalid Entry"))
				{
					firstNameField.setText(" ");
					firstNameField.setForeground(Color.black);
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(firstNameField.getText().trim().equals(""))
				{
					firstNameField.setText("Invalid Entry");
					firstNameField.setForeground(Color.red);
					try
					{
						buttonImage = ImageIO.read(new File("redX.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[0].setVisible(true);
						checkButton[0].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
				else
				{
					try
					{
						buttonImage = ImageIO.read(new File("greenCheck.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[0].setVisible(true);
						checkButton[0].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
			}
		});


		lastNameField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e)
			{
				if(lastNameField.getText().equals("Invalid Entry"))
				{
					lastNameField.setText(" ");
					lastNameField.setForeground(Color.black);
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(lastNameField.getText().trim().equals(""))
				{
					lastNameField.setText("Invalid Entry");
					lastNameField.setForeground(Color.red);
					try
					{
						buttonImage = ImageIO.read(new File("redX.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[1].setVisible(true);
						checkButton[1].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
				else
				{
					try
					{
						buttonImage = ImageIO.read(new File("greenCheck.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[1].setVisible(true);
						checkButton[1].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
			}
		});


		addressField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e)
			{
				if(addressField.getText().equals("Invalid Entry"))
				{
					addressField.setText(" ");
					addressField.setForeground(Color.black);
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(addressField.getText().trim().equals(""))
				{
					addressField.setText("Invalid Entry");
					addressField.setForeground(Color.red);
					try
					{
						buttonImage = ImageIO.read(new File("redX.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[2].setVisible(true);
						checkButton[2].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
				else
				{
					try
					{
						buttonImage = ImageIO.read(new File("greenCheck.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[2].setVisible(true);
						checkButton[2].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
			}
		});


		cityField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e)
			{
				if(cityField.getText().equals("Invalid Entry"))
				{
					cityField.setText(" ");
					cityField.setForeground(Color.black);
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(cityField.getText().trim().equals(""))
				{
					cityField.setText("Invalid Entry");
					cityField.setForeground(Color.red);
					try
					{
						buttonImage = ImageIO.read(new File("redX.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[3].setVisible(true);
						checkButton[3].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
				else
				{
					try
					{
						buttonImage = ImageIO.read(new File("greenCheck.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[3].setVisible(true);
						checkButton[3].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
			}
		});


			zipField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e)
			{
				if(zipField.getText().equals("Invalid Entry"))
				{
					zipField.setText(" ");
					zipField.setForeground(Color.black);
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(zipField.getText().trim().equals(""))
				{
					//zipField.setText("Invalid Entry");
					//zipField.setForeground(Color.red);
					//try
					//{
						//buttonImage = ImageIO.read(new File("redX.png"));
						//buttonImg = new ImageIcon(buttonImage);
						//checkButton[4].setVisible(true);
						//checkButton[4].setIcon(buttonImg);
					//}
					//catch(IOException ex){}
				}
				else
				{
					try
					{
						buttonImage = ImageIO.read(new File("greenCheck.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[4].setVisible(true);
						checkButton[4].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
				try
				{
					int hi = Integer.parseInt(zipField.getText());
				}
				catch(Exception a)
				{
					zipField.setText("Invalid Entry");
					zipField.setForeground(Color.red);
					try
					{
						buttonImage = ImageIO.read(new File("redX.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[4].setVisible(true);
						checkButton[4].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
			}
		});
	}

	public void check()
	{
		String state = (String) stateBox.getSelectedItem();
		check = true;
		if(state.equals("Choose State"))
		{
			check = false;
			try
			{
				buttonImage = ImageIO.read(new File("redX.png"));
				buttonImg = new ImageIcon(buttonImage);
				checkButton[5].setVisible(true);
				checkButton[5].setIcon(buttonImg);
			}
			catch(IOException ex){}
		}
		if(firstNameField.getText().trim().equals("") || firstNameField.getText().trim().equals("Invalid Entry"))
		{
			firstNameField.setForeground(Color.red);
			firstNameField.setText("Invalid Entry");
			try
			{
				buttonImage = ImageIO.read(new File("redX.png"));
				buttonImg = new ImageIcon(buttonImage);
				checkButton[0].setVisible(true);
				checkButton[0].setIcon(buttonImg);
			}
			catch(IOException ex){}
			check = false;
		}
		if(lastNameField.getText().trim().equals("") || lastNameField.getText().trim().equals("Invalid Entry"))
		{
			lastNameField.setForeground(Color.red);
			lastNameField.setText("Invalid Entry");
			try
			{
				buttonImage = ImageIO.read(new File("redX.png"));
				buttonImg = new ImageIcon(buttonImage);
				checkButton[1].setVisible(true);
				checkButton[1].setIcon(buttonImg);
			}
			catch(IOException ex){}
			check = false;
		}
		if(addressField.getText().trim().equals("") || addressField.getText().trim().equals("Invalid Entry"))
		{
			addressField.setForeground(Color.red);
			addressField.setText("Invalid Entry");
			try
			{
				buttonImage = ImageIO.read(new File("redX.png"));
				buttonImg = new ImageIcon(buttonImage);
				checkButton[2].setVisible(true);
				checkButton[2].setIcon(buttonImg);
			}
			catch(IOException ex){}
			check = false;
		}
		if(cityField.getText().trim().equals("") || cityField.getText().trim().equals("Invalid Entry"))
		{
			cityField.setForeground(Color.red);
			cityField.setText("Invalid Entry");
			try
			{
				buttonImage = ImageIO.read(new File("redX.png"));
				buttonImg = new ImageIcon(buttonImage);
				checkButton[3].setVisible(true);
				checkButton[3].setIcon(buttonImg);
			}
			catch(IOException ex){}
			check = false;
		}
		if(zipField.getText().trim().equals("") || zipField.getText().trim().equals("Invalid Entry"))
		{
			zipField.setForeground(Color.red);
			zipField.setText("Invalid Entry");
			try
			{
				buttonImage = ImageIO.read(new File("redX.png"));
				buttonImg = new ImageIcon(buttonImage);
				checkButton[4].setVisible(true);
				checkButton[4].setIcon(buttonImg);
			}
			catch(IOException ex){}
			check = false;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == submitButton)
		{
			check();
			if(check)
			{
				try
				{
					buttonImage = ImageIO.read(new File("greenCheck.png"));
					buttonImg = new ImageIcon(buttonImage);
					checkButton[5].setVisible(true);
					checkButton[5].setIcon(buttonImg);
				}
				catch(IOException ex){}
				check = true;
				name = firstNameField.getText();
				u.setBounds(0,0,900,410);
				confirmALabel.setText("Please check to make sure all of the information is correct!");
				firstNameALabel.setText("First Name: " + firstNameField.getText());
				lastNameALabel.setText("Last Name: " + lastNameField.getText());
				addressALabel.setText("Address: " + addressField.getText());
				cityALabel.setText("City: " + cityField.getText());
				zipALabel.setText("Zip Code: " + zipField.getText());
				stateALabel.setText("State: " + stateBox.getSelectedItem());
				infoALabel.setText("If all the information is correct hit continue, else hit back");
				eastPanel.add(otroPanel);
				otroPanel.add(continueButton);
				continueButton.addActionListener(this);
				otroPanel.add(backButton);
				backButton.addActionListener(this);
			}
			else
			{
				check = true;
			}
		}
		if(e.getSource() == clearButton)
		{
			firstNameField.setText("");
			lastNameField.setText("");
			addressField.setText("");
			cityField.setText("");
			zipField.setText("");
			stateBox.setSelectedIndex(0);
			for(int i = 0; i<checkButton.length; i++)
			{
				checkButton[i].setVisible(false);
			}
			u.setBounds(0,0,500,410);
			confirmALabel.setText("");
			firstNameALabel.setText("");
			lastNameALabel.setText("");
			addressALabel.setText("");
			cityALabel.setText("");
			zipALabel.setText("");
			stateALabel.setText("");
			infoALabel.setText("");
			otroPanel.remove(continueButton);
			otroPanel.remove(backButton);
			name = " ";
			check = false;
		}
		if(e.getSource() == continueButton)
		{
			JOptionPane.showMessageDialog(null, name + " your form has been sent");
		}
		if(e.getSource() == stateBox)
		{

			if(safe == 0)
			{

				safe++;
			}
			else
			{
				String state = (String) stateBox.getSelectedItem();
				if(state.equals("Choose State"))
				{
					try
					{
						buttonImage = ImageIO.read(new File("redX.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[5].setVisible(true);
						checkButton[5].setIcon(buttonImg);
					}
					catch(IOException ex){}
				}
				else
				{
					try
					{
						buttonImage = ImageIO.read(new File("greenCheck.png"));
						buttonImg = new ImageIcon(buttonImage);
						checkButton[5].setVisible(true);
						checkButton[5].setIcon(buttonImg);
					}
				catch(IOException ex){}
				}
			}
		}
		if(e.getSource() == backButton)
		{
			u.setBounds(0,0,500,410);
			confirmALabel.setText("");
			firstNameALabel.setText("");
			lastNameALabel.setText("");
			addressALabel.setText("");
			cityALabel.setText("");
			zipALabel.setText("");
			stateALabel.setText("");
			infoALabel.setText("");
			otroPanel.remove(continueButton);
			otroPanel.remove(backButton);
			name = " ";
			check = false;
		}
	}
	public static void main(String[] args)
	{
		u = new UserInput();
		u.setVisible(true);
		u.setBounds(0,0,500,410);

	}
}