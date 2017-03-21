/*
	Chapter 2: Welcome to My Day
	Programmer: B. Kintzing
	Date: 9/7/14
	Filename: Welcome.java
	Purpose: This project displays a welcome message, the user's name, the system date, and an image in an applet.

	 */

import java.util.Date;
import java.awt.*;
import java.util.Date;

public class Welcome
{
	public static void main(String[] args)
	{
		Date currentDate = new Date(); //Date constructor
	    System.out.println();
	    System.out.println("\t\t\tWelcome to my day!");
	    System.out.println("\t\t\tDaily Planner for Bernard");
	    System.out.println("\t\t\t" + currentDate);
	    System.out.println();

	}

}