/*
	 BodyMassSwing.java
	 B.Kintzing
	 9/29/2014
	 Calculates the body mass using hieght and weight.


*/

import javax.swing.JOptionPane;

public class BodyMassSwing
{
	public static void main(String[]args)
	{
		// declare the constant variables
		String height, weight;
		int inches, pounds;
		double kilograms, meters, index;

		//print prompts and gets input
		System.out.println("\tTHE SUN FITNESS CENTER BODY MASS INDEX CALCULATOR");
		height=JOptionPane.showInputDialog(null, "\t\tEnter your height to the nearest inch:");
			inches = Integer.parseInt(height);
		weight=JOptionPane.showInputDialog(null,"\t\tEnter your weight to the nearest pound:");
		pounds = Integer.parseInt(weight);

		//calculation
		meters = inches / 39.36;
		kilograms = pounds / 2.2;
		index = kilograms /Math.pow(meters,2);

		//output
		JOptionPane.showInputDialog(null,"YOUR BODY MASS INDEX IS" + Math.round(index)+".", "Body MAss Calculator", JOptionPane.PLAIN_MESSAGE);
	}
}