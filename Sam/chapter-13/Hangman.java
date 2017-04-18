import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.text.*;
import java.util.*;
import java.util.Arrays;




public class Hangman{
	static int i=0;
	public static void password(){
		Path Pass = Paths.get(".\\Pass.txt");
        Path User = Paths.get(".\\User.txt");
		Scanner input = new Scanner(System.in);
		FileChannel fcIn = null;
        FileChannel fcOut = null;
		System.out.println("Hello and welcome to Hangman!");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Do You Have An Existing Account?(y,n):");
		String existing = input.nextLine();
		String delimiter = ",";
		String delimiter1 = ",";
		if(existing.equals("y") || existing.equals("Y")  || existing.equals("Yes") || existing.equals("yes") || existing.equals("Ye") || existing.equals("ye")){
			while(true){
				System.out.println("What is your UserName:");
				String user = input.nextLine();
				System.out.println("What is your Password:");
				String pass = input.nextLine();
				if(pass.equals("blue") && user.equals("bob") ){
					System.out.println("Credentials Accepted.");
					break;
				}
				else{
					System.out.println("Please try again.");
				}
			}

		}
		else{
			try{
				fcIn = (FileChannel)Files.newByteChannel(Pass, CREATE, WRITE);
				fcOut = (FileChannel)Files.newByteChannel(User, CREATE, WRITE);
			}catch(Exception q){}

			System.out.println("What would you like your UserName to be:");
			String user = input.nextLine();
			user = user +delimiter;
			byte data1[] = user.getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(data1);
			try{
				fcOut.write(buffer);
			}catch(Exception a){}
			System.out.println("What would you like your Password to be:");
			String pass = input.nextLine();
			pass = pass+delimiter1;
			byte data[] = pass.getBytes();
			ByteBuffer buffer1 = ByteBuffer.wrap(data);
			try{
				fcIn.write(buffer1);
			}catch(Exception e){}

		}
	}
	public static void end(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _                                             ");
		System.out.println("| |                                            ");
		System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
		System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
		System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
		System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
		System.out.println("                    __/ |                      ");
		System.out.println("                   |___/        			   ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _________");
		System.out.println("|         |");
		System.out.println("|         0");
		System.out.println("|        /|\\ 	");
		System.out.println("|        / \\ ");
		System.out.println("|");
		System.out.println("|");
		System.out.println("");
		System.out.println("");
		System.out.println("You lose!!");
	}
	public static void five(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _                                             ");
		System.out.println("| |                                            ");
		System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
		System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
		System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
		System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
		System.out.println("                    __/ |                      ");
		System.out.println("                   |___/        			   ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _________");
		System.out.println("|         |");
		System.out.println("|         0");
		System.out.println("|        /|\\  ");
		System.out.println("|        /  ");
		System.out.println("|");
		System.out.println("|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	public static void four(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _                                             ");
		System.out.println("| |                                            ");
		System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
		System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
		System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
		System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
		System.out.println("                    __/ |                      ");
		System.out.println("                   |___/        			   ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _________");
		System.out.println("|         |");
		System.out.println("|         0");
		System.out.println("|        /|\\ ");
		System.out.println("|         ");
		System.out.println("|");
		System.out.println("|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	public static void three(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _                                             ");
		System.out.println("| |                                            ");
		System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
		System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
		System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
		System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
		System.out.println("                    __/ |                      ");
		System.out.println("                   |___/        			   ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _________");
		System.out.println("|         |");
		System.out.println("|         0");
		System.out.println("|        /| ");
		System.out.println("|         ");
		System.out.println("|");
		System.out.println("|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	public static void two(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _                                             ");
		System.out.println("| |                                            ");
		System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
		System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
		System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
		System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
		System.out.println("                    __/ |                      ");
		System.out.println("                   |___/        			   ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _________");
		System.out.println("|         |");
		System.out.println("|         0");
		System.out.println("|         | ");
		System.out.println("|         ");
		System.out.println("|");
		System.out.println("|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	public static void one(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _                                             ");
		System.out.println("| |                                            ");
		System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
		System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
		System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
		System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
		System.out.println("                    __/ |                      ");
		System.out.println("                   |___/        			   ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _________");
		System.out.println("|         |");
		System.out.println("|         0");
		System.out.println("|         ");
		System.out.println("|         ");
		System.out.println("|");
		System.out.println("|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	public static void start(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _                                             ");
		System.out.println("| |                                            ");
		System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
		System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
		System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
		System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
		System.out.println("                    __/ |                      ");
		System.out.println("                   |___/        			   ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" _________");
		System.out.println("|         |");
		System.out.println("|         ");
		System.out.println("|         ");
		System.out.println("|         ");
		System.out.println("|");
		System.out.println("|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
    public static boolean printWord(String word, char[] enteredLetters) {
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter);
            else {
                System.out.print('*');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }

    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }
    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }

    public static void main(String[] args) {
		password();
		String delimiter = ",";
		String[] words;
		String line = "1";
		try{
			BufferedReader reader = new BufferedReader(new FileReader(".//hangman.txt"));
			line = reader.readLine();
		}catch(Exception e){}
		words = line.split(delimiter);
		start();



		int randomWordNumber = (int) (Math.random() * words.length);
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 0;
        boolean wordIsGuessed = false;
        do {

        switch (enterLetter(words[randomWordNumber], enteredLetters)) {
            case 0:
                triesCount++;
                break;
            case 1:
                triesCount++;
                break;
            case 2:
                break;
            case 3:
                wordIsGuessed = true;
                break;
        	}
			 if(i==0){
				start();
			 }
			 else if(i==1){
				one();
			 }
			 else if(i==2){
				two();
			 }
			 else if(i==3){
				three();
			 }
			 else if(i==4){
				four();
			 }
			 else if(i==5){
				five();
			 }
			 else if(i==6){
				end();
			}
        } while(!wordIsGuessed && i<=5);
        System.out.println("\nThe word is \"" + words[randomWordNumber] +
            "\" You missed " + (triesCount -findEmptyPosition(enteredLetters)) +
            " time(s)");

    }
    public static int enterLetter(String word, char[] enteredLetters)    {
        System.out.print("(Guess) Enter a letter in word ");
	    if (! printWord(word, enteredLetters))
            return 3;
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        }
        else {
            System.out.println(userInput + " is not in the word");
            i=i+1;
            return 0;
            }
    }
}