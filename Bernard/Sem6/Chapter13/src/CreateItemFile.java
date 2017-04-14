import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class CreateItemFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "Z:\\Computer Science\\Sem 6\\Chapter 13\\items.txt";
        Path file = Paths.get(fileName);
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "                    ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final String ZIP = "00000";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + System.getProperty("line.separator");
        final int RECSIZE = s.length();

        FileChannel fcCust = null;
        String idString = "";
        String[] array = new String[1000];
        String description;
        final String QUIT = "999";
        Boolean dub;

        try {
            fcCust = (FileChannel) Files.newByteChannel(file, CREATE, WRITE);
            System.out.print("Enter product ID number: ");
            idString = input.nextLine();
            while (!(idString.equals(QUIT))) {
                dub  = true;
                while (dub == true) {

                    InputStream iStream = new BufferedInputStream(Files.newInputStream(file));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
                    Boolean breaky = false;

                    s = reader.readLine();

                    while (s != null) {
                        array = s.split(delimiter);
                        for (int i = 0; i < array.length; i++) {
                            if (array[i].equals(idString)) {
                                System.out.println("You already have a product entered with that ID.");
                                System.out.print("Enter product ID number: ");
                                idString = input.nextLine();
                                breaky = true;
                            } else {
                                dub = false;
                            }
                            if(breaky) {
                                i  = array.length;
                            }
                        }
                        if(breaky) {
                            break;
                        }
                        s = reader.readLine();
                    }
                }
                System.out.print("Enter description: ");
                description = input.nextLine();
                StringBuilder sb = new StringBuilder(description);
                sb.setLength(NAME_LENGTH);
                description = sb.toString();
                s = idString + delimiter + description + System.getProperty("line.separator");
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
