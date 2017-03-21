/*
	Bernard Kintzing
	KilowattApplet
	To claculate the average energy cost
*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class KilowattApplet extends Applet implements ActionListener
{
	Label welcomeLabel = new Label("\t Welcome to the Appliance Energy Calculator:");
 	Label costKwhrLabel = new Label("\t Please enter the cost per kilowatt-hour in cents:");
		TextField costKwhrField = new TextField(10);
	Label hoursperyearLabel = new Label("\t Please enter the kilowatt-hours consumed:");
		TextField hoursperyearField = new TextField(10);
	Button calcButton = new Button("Calculate");
	Label outputLabel = new Label("click the calculate button to display the average energy cost.");

	public void init()
	{
		setForeground(Color.red);
		setBackground(new Color(119,195,212));
		add(welcomeLabel);
		add(costKwhrLabel);
		add(costKwhrField);
		add(hoursperyearLabel);
		add(hoursperyearField);
		add(calcButton);
		calcButton.addActionListener(this);
		add(outputLabel);
	}
	public void actionPerformed(ActionEvent e)

	{

		double costKwhr= Double.parseDouble(costKwhrField.getText());
		double kwhrs= Double.parseDouble(hoursperyearField.getText());

		double average;
		average = (costKwhr*kwhrs);
		outputLabel.setText("The avergage cost to operate this appliance is $" + Math.round(average*100/10000D));
	}
}