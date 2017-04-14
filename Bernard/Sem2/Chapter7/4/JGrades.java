import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class JGrades extends JFrame
{
    int[] grades = new int[50];
    int grade;
    int count = 0;
    boolean it = true;
    int total = 0;
    int avg;
    Panel panel = new Panel();
    Panel panel2 = new Panel();
    TextArea theArea = new TextArea("",1,1,TextArea.SCROLLBARS_VERTICAL_ONLY);
    Label label = new Label("Your grade average is:");
    TextField field = new TextField(20);
    //PopupMenu area1 = new PopupMenu();
    //PopupMenu area2 = new PopupMenu();
    Font f = new Font("Hevetica", Font.BOLD, 40);

    public JGrades()
    {
        theArea.setEditable(false);
        this.setLayout(new BorderLayout());
        add(panel,BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0,2));
        panel.add(theArea);
        panel.add(panel2);
        panel2.add(label);
        panel2.add(field);
        field.setEditable(false);
        for(int i = 0; i<grades.length; i++)
        {
            try
            {
                it = true;

                grade = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your grade for " + i + " period."));
                if(grade == -1)
                {
                    //break; Tell Sam not to do a break
                    i= grades.length;
                    it = false;
                }
                else if(grade > 100 || grade < 0)
                {
                    JOptionPane.showMessageDialog(null,"Your grades can not be over 100 or less than 0");
                    i--;
                    it = false;
                }
                else if(it)
                {
                    count ++;
                    grades[i] = grade;
                    total += grade;
                    System.out.println(total);
                }
            }
            catch(Exception a)
            {
                JOptionPane.showMessageDialog(null,"Your grade must be diplayed in numercal values only rounded to the nearest whole number");
                i--;
                it = false;
            }
        }
        sort(grades);
        for(int i = 0; i<count; i++)
        {
            theArea.setEditable(false);
            if(i < 10)
            {
                if(i == 0)
                {
                    theArea.setText(theArea.getText() + "0" + i + ": " + String.valueOf(grades[i]));
                }
                else
                {
                    theArea.setText(theArea.getText() + "\n" + "0" + i + ": " + String.valueOf(grades[i]));
                }
            }
            else
            {
                theArea.setText(theArea.getText() + "\n" + i + ": " + String.valueOf(grades[i]));
            }
            theArea.setFont(f);
        }
        avg = total/count;
        System.out.println(count);
        System.out.println(total);
        field.setText(String.valueOf(avg));

    }
    public void sort(int tempArray[])
    {
        for(int pass = 1; pass < tempArray.length; pass++)
        {
            for(int element = 0; element < tempArray.length - 1; element++)
            {
                if(tempArray[element] < tempArray[element + 1])
                {
                    swap(grades, element, element + 1);
                }
            }
        }
    }
    public void swap(int swapArray[], int first, int second)
    {
        int hold;
        hold = swapArray[first];
        swapArray[first] = swapArray[second];
        swapArray[second] = hold;
    }
    public static void main(String[] args)
    {
        JGrades j = new JGrades();
        j.setVisible(true);
        j.setBounds(0,0,500,200);
    }
}