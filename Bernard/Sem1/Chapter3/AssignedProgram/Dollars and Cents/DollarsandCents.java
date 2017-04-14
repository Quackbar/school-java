/*
	Bernard.K
	To print out the number of dollars and cents based on the users numeric input.
*/

import javax.swing.JOptionPane;
import java.applet.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class DollarsandCents // extends Applet implements ActionListener
 	{
		public static void main(String[]args)
		{
			String dollarAmount;
		    dollarAmount = JOptionPane.showInputDialog(null,"Please enter the your dollar amount:");

			double dAmount= Double.parseDouble(dollarAmount);
			int dollarNum, centsNum;
			dollarNum = (int)Math.floor(dAmount/100);
			centsNum = (int)(dAmount%100);
			String printOut = Integer.toString(dollarNum) + " dollars and " + Integer.toString(centsNum) + " cents";

			JOptionPane.showMessageDialog(null, printOut, "Answer", JOptionPane.PLAIN_MESSAGE, null);
			System.exit(0);
		}
	}
