import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Book extends JFrame implements ActionListener{

    int nameInt, phoneInt;
    static int tot;

    static String filename1 = "Names";
    String inName, inPhone, nameCheck, phoneCheck;

    Font f = new Font("",Font.PLAIN,20);

    static DataOutputStream dos;
    static DataInputStream dis;

    static ArrayList nameAL = new ArrayList<String>();
    static ArrayList phoneAL = new ArrayList<Integer>();

    JLabel name = new JLabel("Name:");
    JLabel phone = new JLabel("Phone:");

    JTextField nameIn = new JTextField();
    JTextField phoneIn = new JTextField();

    JButton add = new JButton("Add");
    JButton delete = new JButton("Delete");
    JButton update = new JButton("Update");
    JButton find = new JButton("Find");

    JPanel cen = new JPanel();
    JPanel south = new JPanel();


    public Book(){
        this.setLayout(new BorderLayout());
        this.add(cen, BorderLayout.CENTER);
        cen.setLayout(null);
        cen.add(name);
        name.setFont(f);
        name.setBounds(10, 10, 150, 20);
        cen.add(nameIn);
        nameIn.setBounds(100, 8, 150, 25);
        cen.add(phone);
        phone.setBounds(10, 50, 150, 20);
        phone.setFont(f);
        cen.add(phoneIn);
        phoneIn.setBounds(100, 48, 150, 25);
        this.add(south, BorderLayout.SOUTH);
        south.setLayout(new GridLayout(0, 4));
        south.add(add);
        add.addActionListener(this);
        south.add(delete);
        delete.addActionListener(this);
        south.add(update);
        update.addActionListener(this);
        south.add(find);
        find.addActionListener(this);
        try{
            dis = new DataInputStream(new FileInputStream(filename1));
            //tot = dis.available();
            tot = Integer.parseInt(dis.readUTF());
            System.out.println(tot + "First read");
        }
        catch(IOException ex){}
        for(int i = 0; i<tot; i++) {
            try{
                inName = dis.readUTF();
                nameAL.add(inName);
                System.out.println(String.valueOf(nameAL));
                inPhone = dis.readUTF();
                phoneAL.add(inPhone);
                System.out.println(String.valueOf(phoneAL));
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Your contacts were not able to be saved.");
            }
        }

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add) {
            nameCheck = nameIn.getText();
            phoneCheck = phoneIn.getText();
            if((!nameCheck.equals("")) && (!phoneCheck.equals(""))){
                nameAL.add(nameCheck);
                phoneAL.add(phoneCheck);
                for (int i = 0; i < nameAL.size(); i++) {
                    System.out.println("           ");
                    System.out.println(nameAL.get(i));
                    System.out.println(phoneAL.get(i));
                }
                nameIn.setText("");
                phoneIn.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null,"You need enter both a name and a phone number");
            }
        }
        else if(e.getSource() == delete){
            boolean match = true;
            if(nameAL.size() == 0){
                JOptionPane.showMessageDialog(null, "You have no friends");
            }
            else {
                try {
                    String name = JOptionPane.showInputDialog(null, "Enter the name of the person you wish to remove.");
                    nameInt = 0;
                    phoneInt = 0;
                    for (int i = 0; i < nameAL.size(); i++) {
                        if (name.equals(nameAL.get(i))) {
                            nameInt = i;
                            phoneInt = i;
                            match = true;
                            break;
                        }
                        else {
                            match = false;
                        }
                    }
                    if(match){
                        JOptionPane.showMessageDialog(null, nameAL.get(nameInt) + "'s information has been removed.");
                        nameAL.remove(nameInt);
                        phoneAL.remove(phoneInt);
                        for (int i = 0; i < nameAL.size(); i++) {
                            System.out.println("           ");
                            System.out.println(nameAL.get(i));
                            System.out.println(phoneAL.get(i));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have a contact named " + name);
                    }
                }
                catch(ArrayIndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(null, "You have no friends");
                }
            }
        }
        else if(e.getSource() == update){
            boolean check = false;
            if(nameAL.size() == 0){
                JOptionPane.showMessageDialog(null, "You have no friends");
            }
            else {
                try {
                    String name1 = JOptionPane.showInputDialog(null, "Enter the name whose info you wish to change.");
                    for (int i = 0; i < nameAL.size(); i++) {
                        if (name1.equals(nameAL.get(i))) {
                            nameInt = i;
                            phoneInt = i;
                            check = true;
                            break;
                        }
                        else{
                            check = false;
                        }
                    }
                    if(check){
                        String nPhone = JOptionPane.showInputDialog(null, "Enter their new phone number");
                        phoneAL.set(phoneInt, nPhone);
                        for (int i = 0; i < nameAL.size(); i++) {
                            System.out.println("           ");
                            System.out.println(nameAL.get(i));
                            System.out.println(phoneAL.get(i));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You have no contacts by the name of " + name1);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "You have no friends");
                }
            }
        }
        else{
            try {
                String name2 = JOptionPane.showInputDialog(null, "Enter the name of the person you wish to find.");
                nameInt = 0;
                phoneInt = 0;
                if(nameAL.size() == 0){
                    JOptionPane.showMessageDialog(null, "You have no friends");
                }
                else {
                    for (int i = 0; i < nameAL.size(); i++) {
                        if (name2.equals(nameAL.get(i))) {
                            nameInt = i;
                            phoneInt = i;
                            JOptionPane.showMessageDialog(null, nameAL.get(nameInt) + "'s phone number is " + phoneAL.get(phoneInt));
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "You have no contacts by the name of " + name2);
                        }
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null, "You have no friends");
            }
        }
    }



    public static void main(String[] args) {
        Book b = new Book();
        b.setVisible(true);
        b.setBounds(300, 300, 320, 175);
        b.setTitle("Phone Book");
        try {
            dos = new DataOutputStream(new FileOutputStream(filename1));
        }
        catch(IOException ex){System.out.println("In catch of 2nd to last try");}
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addWindowListener(new WindowListener(){
            public void windowClosing(WindowEvent e){
                System.out.println("In windowClosing");
                tot = nameAL.size();
                try {
                    dos.writeUTF(String.valueOf(tot));
                }
                catch(IOException ex){}
                System.out.println(tot + "First write");
                for(int i = 0; i<nameAL.size(); i++) {
                    try{
                        dos.writeUTF(String.valueOf(nameAL.get(i)));
                        dos.writeUTF(String.valueOf(phoneAL.get(i)));
                        System.out.println("In Try");
                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog(null, "Your contacts were not able to be saved.");
                    }
                }
            }
            public void windowClosed(WindowEvent e){}
            public void windowOpened(WindowEvent e){}
            public void windowDeiconified(WindowEvent e){}
            public void windowIconified(WindowEvent e){}
            public void windowDeactivated(WindowEvent e){}
            public void windowActivated(WindowEvent e){}

        });
    }
}