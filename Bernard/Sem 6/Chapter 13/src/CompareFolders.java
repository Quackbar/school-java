import java.io.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CompareFolders {
    public static void main(String args[]) {
        Boolean one = TRUE;
        Boolean two = TRUE;
        Boolean three = TRUE;
        if(!new File("Z:\\Computer Science\\Sem 6\\Chapter 13\\Folder\\One.txt").exists())
        {
            one = FALSE;
        }
        if(!new File("Z:\\Computer Science\\Sem 6\\Chapter 13\\Folder\\Two.txt").exists())
        {
            two = FALSE;
        }
        if(!new File("Z:\\Computer Science\\Sem 6\\Chapter 13\\Folder\\Three.txt").exists())
        {
            three = FALSE;
        }

        if(one){
            System.out.print("One ");
            if(two) {
                System.out.print("and Two ");
                if(three){
                    System.out.print("and Three are in the same folder.");
                }
                else{
                    System.out.print("are in the same folder, Three is no.t");
                }
            }
            else if(three){
                System.out.print(" and Three are in the same folder, Two is not.");
            }
            else{
                System.out.print("is in the folder, Two and Three are not.");
            }
        }
        else if(two){
            System.out.print("Two ");
            if(three){
                System.out.print("and Three are in the folder, One is not.");
            }
            else{
                System.out.print("is in the folder, One and Three are not.");
            }
        }
        else if(three){
            System.out.print("Three is in the folder, One and Two are not.");
        }
        else{
            System.out.print("None of the files are in the folder.");
        }
    }
}
