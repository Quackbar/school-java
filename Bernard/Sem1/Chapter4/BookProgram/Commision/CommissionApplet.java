/*
	Sales Commission Applet
	Bernard.K




*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CommissionApplet extends Applet implements ItemListener
{
	//declare variables and construct a color
	double dollars, answer;
	int empCode;
	Image dollarSign;
	Color darkRed = new Color(160, 50, 0);

	//Create components for applet
	Label promptLabel = new Label ("Enter the sales amount (do not use commas or the dollar sign):");
		TextField salesField = new TextField(20);

	Label codeLabel = new Label("Select the appropiate commission code;");

	CheckboxGroup codeGroup = new CheckboxGroup();
		Checkbox telephoneBox = new Checkbox("Telephone Sales",false,codeGroup);
		Checkbox inStoreBox = new Checkbox("In-Store Sales",false,codeGroup);
		Checkbox outsideBox = new Checkbox("Outside Sales",false,codeGroup);
		Checkbox hiddenBox = new Checkbox("",true,codeGroup);

		Label  outputLabel = new Label("Click an option button to calculate the sales commission.");

	public void init()
	{
		setBackground(darkRed);
		setForeground(Color.white);
		add(promptLabel);
		add(salesField);
		salesField.requestFocus();
		salesField.setForeground(Color.black);
		add(codeLabel);
		add(telephoneBox);
		telephoneBox.addItemListener(this);
		add(inStoreBox);
		inStoreBox.addItemListener(this);
		add(outsideBox);
		outsideBox.addItemListener(this);
		add(outputLabel);
	}

	//This method is triggered by the user clicking the option button
	public void itemStateChanged(ItemEvent choice)
	{
		try
		{
			dollars = getSales();
			empCode = getCode();
			answer = getComm(dollars,empCode);
			output(answer, dollars);
		}
        catch  (NumberFormatException e)
 		{
			outputLabel.setText("You must enter a dollar amount greter than zero");
			hiddenBox.setState(true);
			salesField.setText("");
			salesField.requestFocus();
		}
	}

	public double getSales()
	{
		double sales = Double.parseDouble(salesField.getText());

		if (sales <= 0) throw new NumberFormatException();

		return sales;
	}

	public int getCode()
	{
		int code = 0;
		if (telephoneBox.getState()) code = 1;
		else
			if (inStoreBox.getState()) code = 2;
 			else
				if (outsideBox.getState()) code = 3;
		return code;
	}

	public double getComm(double sales, int code)
	{
		double commission = 0.0;
		switch(code)
		{
			case 1:
				commission = .10 * sales;
				break;

			case 2:
				commission = .14 * sales;
				break;

			case 3:
				commission = .18 * sales;
				break;
		}
		return commission;
	}

	public void output(double commission, double sales)
	{
		DecimalFormat twoDigits = new DecimalFormat("$#,000.00");
		outputLabel.setText("Your commission on sales of " + twoDigits.format(sales) + " is " + twoDigits.format(commission));
	}
	public void paint(Graphics g)
	{
		dollarSign = getImage(getDocumentBase(), "dollarSign.gif");
		g.drawImage(dollarSign, 12, 28,this);
	}
}