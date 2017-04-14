/*
	Bernard.K
*/

import java.util.*;
import java.io.*;
import javax.swing.*;

public class Chapter3Test
{
	public static void main(String[]args) throws IOException
	{
		//Variables and Stuff
		String name;
		int income, dependants, deductions, taxableIncome;
		Scanner scannerIn = new Scanner(System.in);
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

		//JOptionPane
		name = (JOptionPane.showInputDialog("Enter Name"));

		//Scanner
		System.out.println("Enter Income");
		income = scannerIn.nextInt();

		//BufferedReader
		System.out.println("Enter Dependants");
		dependants = Integer.parseInt(dataIn.readLine());

		//The MATH!!!!!!!!!!!!!!!!!!
		deductions = (dependants*3500);
		taxableIncome = (income-deductions);

		//Everything Else
		System.out.println("Hi " + name);
		System.out.println("Your deductions are " + deductions);
		System.out.println("Your Taxable Income is " + taxableIncome);
	}
}
