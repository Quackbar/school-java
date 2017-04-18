import java.io.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CompareFolders {

    public static void main(String args[]) {
        Boolean first = true;
        Boolean second = true;
        Boolean third = true;
        if(!new File(".\\1.txt").exists())
        {
            first = false;
        }
        if(!new File(".\\2.txt").exists())
        {
            second = false;
        }
        if(!new File(".\\3.txt").exists())
        {
            third = false;
        }
        if(first){
            System.out.print("First ");
            if(second) {
                System.out.print("and Second ");
                if(third){
                    System.out.print("and Third file are in the same folder.");
                }
                else{
                    System.out.print("are in the same folder, and the Third is not.");
                }
            }
            else if(third){
                System.out.print(" and the Third are in the same folder, the Second is not.");
            }
            else{
                System.out.print("is in the folder, Second and Third are not.");
            }
        }
        else if(second){
            System.out.print("Second ");
            if(third){
                System.out.print("and Third are in the folder, First is not.");
            }
            else{
                System.out.print("is in the folder, First and Third are not.");
            }
        }
        else if(third){
            System.out.print("Three is in the folder, First and Second are not.");
        }
        else{
            System.out.print("None of the files are in the folder.");
        }

    }
}