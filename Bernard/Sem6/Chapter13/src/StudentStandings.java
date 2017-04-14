import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;


public class StudentStandings {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Path GoodStudentStanding = Paths.get(".\\goodStandings.txt");
        Path PoorStudentStanding = Paths.get(".\\badStandings.txt");
        final String ID_FORMAT = "000";
        final String FIRST_NAME = "              ";
        final int NAME_LENGTH = FIRST_NAME.length();
        final String GPA = "0.00";
        final String LAST_NAME = "             ";
        final int NAME_LENGTH2 = LAST_NAME.length();
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + GPA + delimiter + LAST_NAME + delimiter + FIRST_NAME + System.getProperty("line.separator");
        final int RECSIZE = s.length();

        FileChannel fcIn = null;
        FileChannel fcOut = null;
        String idString;
        int id;
        String name;
        String lname;
        double gpa;
        final String QUIT = "999";

        createEmptyFile(GoodStudentStanding, s);
        createEmptyFile(PoorStudentStanding, s);

        try{
            fcIn = (FileChannel)Files.newByteChannel(GoodStudentStanding, CREATE, WRITE);
            fcOut = (FileChannel)Files.newByteChannel(PoorStudentStanding, CREATE, WRITE);

            System.out.print("Enter student ID: ");
            idString = input.nextLine();
            while (!(idString.equals(QUIT))) {
                id = Integer.parseInt(idString);
                System.out.print("Enter student first name: ");
                name = input.nextLine();
                StringBuilder sb = new StringBuilder(name);
                sb.setLength(NAME_LENGTH);
                System.out.print("Enter student last name: ");
                lname = input.nextLine();
                StringBuilder sb2 = new StringBuilder(lname);
                sb2.setLength(NAME_LENGTH2);
                lname = sb2.toString();
                System.out.print("Enter GPA: ");
                gpa = input.nextDouble();
                input.nextLine();
                s = idString + delimiter + gpa + delimiter + lname + delimiter + name + System.getProperty("line.separator");
                byte data[] = s.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);
                if (gpa>=2.00) {
                    fcIn.position(id * RECSIZE);
                    fcIn.write(buffer);
                } else {
                    fcOut.position(id * RECSIZE);
                    fcOut.write(buffer);
                }

                System.out.print("Enter next student ID number or " + QUIT + " to quit: ");
                idString = input.nextLine();
            }
            fcIn.close();
            fcOut.close();
        }
        catch (Exception e){
            System.out.println("Error Message: " + e);
        }

    }

    public static void createEmptyFile(Path file, String s) {
        final int NUMRECS = 100;
        try{
            OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(file,CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));
            for(int count = 0; count < NUMRECS; ++count)
                writer.write(s, 0, s.length());
            writer.close();
        }
        catch (Exception e){
            System.out.println("Error message: " + e);
        }
    }

}