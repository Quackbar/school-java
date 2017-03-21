import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class CreateCustomerFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path customer = Paths.get("Z:\\Computer Science\\Sem 6\\Chapter 13\\customers.txt");
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "       ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final String ZIP = "00000";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter + ZIP + System.getProperty("line.separator");
        final int RECSIZE = s.length();

        FileChannel fcCust = null;
        String idString;
        String name;
        String zip;
        final String QUIT = "999";

        try {
            fcCust = (FileChannel) Files.newByteChannel(customer, CREATE, WRITE);

            System.out.print("Enter customer ID number: ");
            idString = input.nextLine();
            while (!(idString.equals(QUIT))) {
                System.out.print("Enter name for customer: ");
                name = input.nextLine();
                StringBuilder sb = new StringBuilder(name);
                sb.setLength(NAME_LENGTH);
                name = sb.toString();
                System.out.print("Enter ZIP: ");
                zip = input.nextLine();
                s = idString + delimiter + name + delimiter + zip + System.getProperty("line.separator");
                byte data[] = s.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);
                //fcCust.position(id * RECSIZE);
                fcCust.write(buffer);

                System.out.print("Enter next customer account number or " + QUIT + " to quit: ");
                idString = input.nextLine();
            }
            fcCust.close();
        } catch (Exception e) {
            System.out.println("Error Message: " + e);
            e.printStackTrace();
        }

    }

}
