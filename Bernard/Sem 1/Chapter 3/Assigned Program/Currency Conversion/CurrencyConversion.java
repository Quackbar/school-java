
/*
	Currency Conversion
	Bernard.K
	The purpose is to convert US dollars into the British pound, Euro, and Russion ruble.
*/
import java.util.*;
 	public class CurrencyConversion
	{
		public static void main(String[] args)
		{
			int dollars;
			float pound, euro, ruble;
 			Scanner scannerIn = new Scanner(System.in);

			System.out.print("Input the dollar amount:");
			int inDollars = scannerIn.nextInt();
			scannerIn.close();
			pound = .62f;
			euro = .79f;
			ruble = 39.75f;

			String poundDisplayString = Integer.toString(inDollars) + " dollars is " + Float.toString(pound*inDollars) + " pounds.";
			String euroDisplayString = Integer.toString(inDollars) + " dollars is " + Float.toString(euro*inDollars) + " euros.";
			String rubleDisplayString = Integer.toString(inDollars) + " dollars is " + Float.toString(ruble*inDollars) + " rubles.";

			System.out.println(poundDisplayString);
			System.out.println(euroDisplayString);
			System.out.println(rubleDisplayString);
		}
	}
