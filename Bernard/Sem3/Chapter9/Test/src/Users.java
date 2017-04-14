import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Users extends JFrame implements ActionListener {

    ArrayList aList = new ArrayList<String>();

    JButton addButton = new JButton("Add");
    JButton removeButton = new JButton("Remove");
    JButton viewButton = new JButton("View");

    JPanel buttonPanel = new JPanel();

    public Users(){
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(0, 3));
        buttonPanel.add(addButton);
        addButton.addActionListener(this);
        buttonPanel.add(removeButton);
        removeButton.addActionListener(this);
        buttonPanel.add(viewButton);
        viewButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            Boolean check = true;
            String input;
            input = JOptionPane.showInputDialog(null, "Enter the name that you wish to add.");
            if (aList.contains(input)) {
                System.out.println("In already stored");
                JOptionPane.showMessageDialog(null, "This name is already stored.");
                check = false;
            }
            if(check) {
                aList.add(input);
                System.out.println("In stored");
                JOptionPane.showMessageDialog(null, "The name has been stored");
            }

            for (int i = 0; i < aList.size(); i++){
                System.out.println(aList.get(i));
            }
        }
        else if(e.getSource() == removeButton){
            String input;
            Boolean check = true;
            input = JOptionPane.showInputDialog(null, "Enter the name that you wish to remove");
            if(aList.size() == 0){
                JOptionPane.showMessageDialog(null, "You do not have any names stored.");
            }
            else{
                System.out.println(input);
                for (int i = 0; i < aList.size(); i++){
                    if(((String)aList.get(i)).contains(input)){
                        aList.remove(i);
                        JOptionPane.showMessageDialog(null, "This name has been removed.");
                        check = false;
                    }
                }
                if(check){
                    JOptionPane.showMessageDialog(null, "There is no name saved called: " + input);
                }
            }
            for (int i = 0; i < aList.size(); i++){
                System.out.println(aList.get(i));
            }
        }
        else{
            String input = new String();
            if(aList.size() == 0){
                JOptionPane.showMessageDialog(null, "You do not have any names stored.");
            }
            else{
                for (int i = 0; i < aList.size(); i++){
                    if(i == 0){
                        input = (String)aList.get(i) + "\n";
                    }
                    else{
                        input += (String)aList.get(i) + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, "The names stored are: \n" + input);
                for (int i = 0; i < aList.size(); i++){
                    System.out.println(aList.get(i));
                }
            }
        }

    }

    public static void main(String[] args){
        Users u = new Users();
        u.setBounds(300,300,400,100);
        u.setVisible(true);
        u.setTitle("Users");
    }

}

