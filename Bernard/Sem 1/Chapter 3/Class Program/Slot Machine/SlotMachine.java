import java.util.*;  //Scanner
import java.io.*;    //BufferedReader
import javax.swing.*; //JOptionPane

public class SlotMachine
{
	public static void main(String[] args) throws Exception
	{
		// variable delaration
		int pennies, playerID, bet, symbol1, symbol2, symbol3, jackpot = 0;
		Scanner scannerIn = new Scanner(System.in);
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

		//JOptionPane
		playerID = Integer.parseInt(JOptionPane.showInputDialog("Input your player ID:"));
		//Scanner
		System.out.print("Input the nuber of pennies:");
		pennies = scannerIn.nextInt();

		while(pennies > 0)
		{
			//BufferedReader and Prompt
			System.out.print("Input your bet:");
			bet = Integer.parseInt(dataIn.readLine());

			symbol1 = (int)((Math.random() *6) + 1);
			symbol2 = (int)((Math.random() *6) + 1);
			symbol3 = (int)((Math.random() *6) + 1);

			if(symbol1 == 3 && symbol2 == 3 && symbol2 == 3)
			{
				pennies = pennies + 1000000;
				System.out.println("you won the JACKPOT!!!!!!");
			}
			else if(symbol1 == symbol2 && symbol1 == symbol3)
			{
				pennies = pennies + (bet*5);
			}
			else if(symbol1 == symbol2 || symbol1 == symbol3)
					{
						pennies = pennies + (bet*2);
					}
			else
			{
				pennies = pennies - bet;
			}


			System.out.println("          \u00fe\u00fe\u00fe\u00fe\u00fe");
			System.out.println("     \u00fe\u00fe\u00fe\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00fe\u00fe\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe   \u004f\u004f");
			System.out.println("\u00fe\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe| |\u00B0\u00fe   \u004f\u004f");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe\u00B0| |\u00B0| |\u00B0\u00fe  \u00fe\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00fe\u00B0| |\u00B0| |\u00B0|"+(char)(symbol1) +"|\u00B0\u00fe \u00fe\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00fe\u00B0| |\u00B0|"+(char)(symbol2) +"|\u00B0| |\u00B0\u00fe\u00fe\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00fe\u00B0|"+(char)(symbol3) +"|\u00B0| |\u00B0| |\u00B0\u00fe\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00fe\u00B0| |\u00B0| |\u00B0\u00fe\u00fe\u00fe\u00fe\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00fe\u00B0| |\u00fe\u00fe\u00fe\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00B2\u00fe\u00b1\u00b1\u00b1\u00fe");
			System.out.println("\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00fe\u00fe\u00B2\u00B2\u00B2\u00B2\u00fe\u00b1\u00b1\u00b1\u00fe");
			System.out.println(" \u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00fe\u00B2\u00B2\u00B2\u00B2\u00b2\u00fe\u00b1\u00b1\u00b1\u00fe");
			System.out.println("  \u00fe\u00b1\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00fe\u00B2\u00B2\u00b2\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("   \u00fe\u00b1\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe");
			System.out.println("    \u00fe\u00b1\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe");
			System.out.println("     \u00fe\u00b1\u00fe\u00b1\u00b1\u00b1\u00b1\u00fe\u00fe\u00fe\u00fe\u00fe");
			System.out.println("      \u00fe\u00fe\u00fe\u00fe\u00fe" + pennies +" pennies");
		}
		JOptionPane.showMessageDialog(null, "YOU ARE OUT OF PENNIES", "GAME OVER", JOptionPane.ERROR_MESSAGE);
	}
}