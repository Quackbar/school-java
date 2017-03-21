/*
	Chapter 3 Interactive Checkbook Balancing Calculator
	Bernard.K
*/

import java.io.*;

public class Balance
	{
		public static void main(String[] args) throws IOException
		{
			String laststatement, deposits, checks, transactionfees;
			double balance, lststatement, dep, chck, tranfees;
			BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Interactive Checkbook Balancing Claculator");
			System.out.println("");
			System.out.println("What is the balance from your last statment:");
				laststatement = dataIn.readLine();
				lststatement = Double.parseDouble(laststatement);
			System.out.println("What is the total amount of all deposits:");
				deposits = dataIn.readLine();
				dep = Double.parseDouble(deposits);
			System.out.println("What is the total amount of all checks:");
					checks = dataIn.readLine();
					chck = Double.parseDouble(checks);
			System.out.println("What is the total amount of all transaction fees:");
				transactionfees = dataIn.readLine();
				tranfees = Double.parseDouble(transactionfees);

				//calculations
				balance = (lststatement + dep - chck - tranfees);
				balance =
				System.out.println("\tYour new balance is: " + Math.round(balance)+ ".");

		}
	}
