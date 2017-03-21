import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Password extends Applet implements ActionListener
{
	String[] usernameArray = {"Username1","Username2","Username3","Username4","Username5"};
	String[] passwordArray = {"Password1","Password2","Password3","Password4","Password5"};

	Label titleLabel = new Label("Please enter your Username and Password");
	Label usernameLabel = new Label("Username");
	Label passwordLabel = new Label("Password");
	Label emptyLabel1 = new Label("           ");

	TextField usernameField = new TextField(10);
	TextField passwordField = new TextField(10);

	Button loginButton = new Button("Login");

	public Password()
	{
		setBackground(Color.orange);
		add(titleLabel);
		add(usernameLabel);
		add(usernameField);
		add(emptyLabel1);
		add(passwordLabel);
		add(passwordField);
		add(loginButton);
			loginButton.addActionListener(this);

	}

	public void paint(Graphics g)
	{
		resize(300,350);
	}

	public void actionPerformed(ActionEvent login)
	{
		boolean success = false;
		String username = usernameField.getText();
		String password = passwordField.getText();

		for(int i = 0; i < 5; i++)
		{
			if ((usernameArray[i].compareTo(username) == 0) && (passwordArray[i].compareTo(password) == 0)) success = true;
		}
		if(success)
		{
			titleLabel.setText("Login Complete");
		}
		else
		{
			titleLabel.setText("Login Failure");
		}
		try
		{
		Thread.sleep(50000);
		}
		catch(Exception e)
		{

		}
		titleLabel.setText("Please enter your Username and Password");
		usernameField.setText("");
		passwordField.setText("");
		repaint();
	}
}