/*
	Bernard.K
	WHATS MY TYPE
*/

import java.io.*;
import javax.swing.JOptionPane;

public class MyType
{
	public static void main(String[] args)
	{
		String strChoice, strTryString, strTryDouble;
		String strTryInt = null;
		int choice, tryInt;
		double tryDouble;
		boolean done = (false);


		while(!done)
		{
				try
				{
					String message = "What is my Type? \n1. String \n2.integer\n3.double\n4.Quit the program";
					strChoice = (JOptionPane.showInputDialog(null,message));
					choice = Integer.parseInt(strChoice);

					switch(choice)
					{
						case 1:
							strTryInt = (JOptionPane.showInputDialog("Input String"));
							System.out.println("correct");
							break;

						case 2:
							try
							{
								strTryInt = JOptionPane.showInputDialog("Enter Integer");
								tryInt = Integer.parseInt(strTryInt);
								System.out.println("You are correct");
							}
							catch(NumberFormatException e)
							{
								JOptionPane.showMessageDialog(null,"That is not a Integer");
							}
							break;

						case 3:
							try
							{
								strTryDouble = (JOptionPane.showInputDialog(null,"Enter Double"));
								tryDouble = Double.parseDouble(strTryDouble);
								JOptionPane.showMessageDialog(null,"You are correct");
							}
							catch(NumberFormatException e)
							{
								JOptionPane.showMessageDialog(null,"That is not a Double");
							}
							break;

						case 4:
							done = true;
							JOptionPane.showMessageDialog(null,"Thank You");
							break;

						default:
							JOptionPane.showMessageDialog(null,"Enter a number from 1 to 4");


					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"You messsed up");
					done = true;
				}
			}
		}
	}