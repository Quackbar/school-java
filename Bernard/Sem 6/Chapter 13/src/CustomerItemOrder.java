import javax.swing.text.StyledEditorKit;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.READ;

public class CustomerItemOrder{
    public static String customer(){
        Scanner kb = new Scanner(System.in);
        String fileName = ".\\customers.txt";
        Path file = Paths.get(fileName);
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "       ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        String[] array = new String[100];
        for(int i = 0; i < array.length; i++){
            array[i] = "";
        }
        final String ZIP = "00000";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter + ZIP + System.getProperty("line.separator");
        final int RECSIZE = s.length();
        try {
            InputStream iStream = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
            while (!(s.equals(null))) {
                try {
                    s = reader.readLine();
                }
                catch(Exception e){}
                System.out.print(s);
                array = s.split(delimiter);
                String id;
                System.out.print("\nEnter Customer ID: ");
                id = kb.nextLine();
                boolean thing = false;
                while (thing == false) {
                    for (int i = 0; i < array.length; i++) {
                        if (id.equals(array[i]))
                            thing = true;
                    }
                    if (thing == false) {
                        System.out.print("\nInvalid, Enter Customer ID: ");
                        id = kb.nextLine();
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Message: " + e);
            e.printStackTrace();
        }

        return s;
    }

    public static String item(){
        Scanner kb = new Scanner(System.in);
        String fileName = ".\\items.txt";
        Path file = Paths.get(fileName);
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "       ";
        String[] array = new String[100];
        final int NAME_LENGTH = NAME_FORMAT.length();
        for(int i = 0; i < array.length; i++){
            array[i] = "";
        }
        final String ZIP = "00000";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + System.getProperty("line.separator");
        final int RECSIZE = s.length();
        try {
            InputStream iStream = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
            while (!(s.equals(null))) {
                try {
                    s = reader.readLine();
                }
                catch (Exception e){}
                s = reader.readLine();
                array = s.split(delimiter);
                String id;
                System.out.print("\nEnter Item ID: ");
                id = kb.nextLine();
                boolean thing = false;
                while (thing == false) {

                    for (int i = 0; i < array.length; i++) {
                        if (id.equals(array[i]))
                            thing = true;
                    }
                    if (thing == false) {
                        System.out.print("\nInvalid, Enter Item ID: ");
                        id = kb.nextLine();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }

        return s;
    }

    public static void main(String args[]) {
        String cust = customer();
        String item = item();
        System.out.println("Customer information: " + cust);
        System.out.println("Item information: " + item);
    }
}
