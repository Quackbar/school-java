/*
	BERNRARD.K
	TUITION
*/

import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;


public class Tuition
{
	public static void main(String [] args)
	{
		int hours;
		double fees, rate, tuition;
		displayWelcome();
		hours = getHours();
		rate = getRate(hours);
		tuition = calcTuition(hours, rate);
		fees = calcFees(tuition);
		displayTotal(tuition + fees);
	}
	public static void displayWelcome()
	{
		System.out.println("Welcome to the Tuition calculator");
	}
	public static int getHours()
	{
		String strHours;
		int hours;
		hours = 0;
		try
		{
			strHours = JOptionPane.showInputDialog("Input number of hours");
			hours = Integer.parseInt(strHours);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showInputDialog("Input a whole number as your hours");
		}
		return hours;
	}
	public static double getRate(int hours)
	{
		double rate;
		if(hours > 15)
		{
			rate = 44.50;
		}
		else
		{
			rate = 50.00;
		}
		return rate;
	}
	public static double calcTuition(int hours, double rate)
	{
		double tuition;
		tuition = hours * rate;
		return tuition;
	}
	public static double calcFees(double tuition)
	{
		double fees;
		fees = tuition * .08;
		return fees;
	}
	public static void displayTotal(double total)
	{
		DecimalFormat twoDigits = new DecimalFormat("$#,000.00");
		JOptionPane.showMessageDialog(null,"your final cost is "+ twoDigits.format(total),"Tuition Totals",JOptionPane.INFORMATION_MESSAGE);
	}

}
