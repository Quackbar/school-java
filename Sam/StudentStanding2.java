import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class StudentStanding2 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String fileName;
        System.out.print("Enter the name of file to use: ");
        fileName = kb.nextLine();
        fileName = ".\\" + fileName;
        Path file = Paths.get(fileName);

        final String ID_FORMAT = "000";
        final String FIRST_NAME = "              ";
        final int NAME_LENGTH = FIRST_NAME.length();
        final String GPA = "0.00";
        final String LAST_NAME = "             ";
        final int NAME_LENGTH2 = LAST_NAME.length();
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + GPA + delimiter + LAST_NAME + delimiter + FIRST_NAME + System.getProperty("line.separator");
        final int RECSIZE = s.length();

        byte data[] = s.getBytes();
        final String EMPTY_ACCT = "000";
        String[] array = new String[4];
        double gpa;

        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("\nAttributes of the file: ");
            System.out.println("Creation time " + attr.creationTime());
            System.out.println("Size " + attr.size());
        }
        catch(IOException e) {
            System.out.println("IO Exception");
        }

        try {
            InputStream iStream = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));

            System.out.println("\n All non-default records: \n");
            s = reader.readLine();

            while(s != null) {
                array = s.split(delimiter);
                if (!array[0].equals(EMPTY_ACCT)) {
                    gpa = Double.parseDouble(array[1]);
                    System.out.println("ID #" + array[0] + " GPA: " + array[1] + " " + array[2] + ", " + array[3]);
                }
                s = reader.readLine();
            }
                reader.close();
        }
        catch(Exception e){
            //System.out.println("Message: "+e);
        }

        try{
            FileChannel fc = (FileChannel)Files.newByteChannel(file, READ);
            ByteBuffer buffer = ByteBuffer.wrap(data);
            int findAcct;
            System.out.print("\nEnter account to seek: ");
            findAcct = kb.nextInt();
            fc.position(findAcct * RECSIZE);
            fc.read(buffer);
            s = new String(data);
            System.out.println("Desired Record: "+s);
        }catch(Exception e){
            //System.out.println("Message: "+ e);
        }
    }
}