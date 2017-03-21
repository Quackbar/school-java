import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardOpenOption.CREATE;

public class Hangman extends JFrame implements ActionListener{

    //Create initial word amd alphabet
    private String word;
    private String wordHidden;
    private JTextArea wordHiddenT = new JTextArea();
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private JButton[] alphabetF = new JButton[26];

    //Random crap for the GUI
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int)screenSize.getWidth();
    private int height = (int)screenSize.getHeight();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private Font font50 = new Font("Courier", Font.BOLD,50);
    private Font font130 = new Font("Courier", Font.BOLD,100);

    //All the Hangman Stages
    ImageIcon[] images = new ImageIcon[8];
    JLabel[] labels = new JLabel[8];

    //Other stuff
    private int right = 0, wrong = 0;

    //Stuff for IO
    String delimiter = ",";
    Path file = Paths.get("HangmanUsers.txt");

    //Stuff for the login
    String[] lArray;
    JLabel title = new JLabel("Login");
    String tot = "";
    String user = "";
    String pass = "";
    Boolean login = true;
    Boolean getit = false;
    JPanel loginPanel = new JPanel();
    JLabel userL = new JLabel("Username: ");
    JLabel passL = new JLabel("Password: ");
    JTextField userB = new JTextField();
    JTextField passB = new JTextField();
    JButton change = new JButton("<html><u>Don't have an account? Create one.</u></html>");
    JButton submit = new JButton("Login");

    //File Stuff for the word
    String s = "";
    String[] array;

    public Hangman(){
        for(int i = 0; i < images.length; i++){
            String path = "./HangmanPictures/Hangman"+ i +".png";
            images[i] = new ImageIcon(path);
            System.out.println(path);
            labels[i] = new JLabel(images[i]);
        }
        //Creating the GUI
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        if(width > 1920)
            width = 1920;

        //User Login
        CreateLogin();
        //Login();
        if(getit) {
            createHangman();
        }
    }

    public void createHangman(){
        this.remove(loginPanel);
        this.getContentPane().setBackground(Color.white);
        northPanel.setBackground(Color.white);
        southPanel.setBackground(Color.white);
        this.revalidate();
        this.repaint();

        //NORTH PANEL
        this.add(northPanel);
        northPanel.setBounds(0, 0, width, 100);
        northPanel.setLayout(new GridLayout(1, 26));
        for (int i = 0; i < alphabetF.length; i++) {
            alphabetF[i] = new JButton();
            alphabetF[i].setBackground(Color.white);
            alphabetF[i].setFocusPainted(false);
            alphabetF[i].setBorder(null);
            alphabetF[i].setFont(font50);
            alphabetF[i].setText(alphabet[i]);
            northPanel.add(alphabetF[i]);
        }
        //SOUTH PANEL
        this.add(southPanel);
        southPanel.setBounds(0, height - 170, width, 130);
        wordHiddenT.setEditable(false);
        wordHiddenT.setFont(font130);

        reset();
        this.revalidate();
        this.repaint();
    }

    public void actionPerformed(ActionEvent e){
        Boolean correct = false;
        if(e.getActionCommand().equals("Login")){
            user = userB.getText();
            pass = passB.getText();
            String line = "";
            try{
                BufferedReader br = new BufferedReader(new FileReader(".//HangmanUsers.txt"));
                line = br.readLine();
                br.close();
            }
            catch (IOException a){
                a.printStackTrace();
            }
            if(login){
                try {
                    lArray = line.split(delimiter);
                    for(int i = 0; i < lArray.length; i++){
                        if(lArray[i].equals(user)){
                            if(i != lArray.length) {
                                if (lArray[i + 1].equals(pass)) {
                                    getit = true;
                                    createHangman();
                                }
                            }
                        }
                    }

                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
            else {
                tot = line + delimiter + user + delimiter + pass;
                System.out.println(tot);
                try{
                    OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(file,CREATE));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));
                    writer.write(tot, 0, tot.length());
                    writer.close();
                    getit = true;
                    createHangman();
                }
                catch (Exception a){
                    a.printStackTrace();
                }
            }
            System.out.println(getit);
        }
        else if(e.getActionCommand().equals("<html><u>Don't have an account? Create one.</u></html>")){
            login = false;
            change.setText(("<html><u>JK I have an account.</u></html>"));
            title.setText("Create Account");
            title.setBounds(width/2 -350, height/2 - 200, 900, 120);
            loginPanel.revalidate();
            loginPanel.repaint();
        } 
        else if(e.getActionCommand().equals("<html><u>JK I have an account.</u></html>")){
            login = true;
            change.setText("<html><u>Don't have an account? Create one.</u></html>");
            title.setText("Login");
            title.setBounds(width/2 -100, height/2 - 200, 600, 120);
            loginPanel.revalidate();
            loginPanel.repaint();
        }
        else {
            for (int i = 0; i < word.length(); i++) {
                if (e.getActionCommand().toLowerCase().equals(Character.toString(word.charAt(i)))) {
                    correct = true;
                    right++;
                    System.out.println("Right: " + right);
                    if (i == 0)
                        wordHidden = changeString(i, Character.toUpperCase(word.charAt(i)), wordHidden);
                    else
                        wordHidden = changeString(i, word.charAt(i), wordHidden);
                    System.out.println(wordHidden);
                    wordHiddenT.setText(wordHidden);
                }
            }
            for (int i = 0; i < alphabetF.length; i++) {
                if (alphabetF[i].getActionCommand().equals(e.getActionCommand())) {
                    alphabetF[i].removeActionListener(this);
                    if (correct) {
                        alphabetF[i].setForeground(Color.green);
                        if (right == word.length()) {
                            winner();
                        }
                    } else {
                        alphabetF[i].setForeground(Color.red);
                        wrong++;
                        System.out.println("Wrong: " + wrong);
                        drawMan(wrong);
                    }
                }
            }
        }
    }

    public String changeString(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

    public void drawMan(int misses){
        //Death by Hanging
        for(int i = 0; i < images.length; i++){
            if(misses == i){
                this.remove(labels[i-1]);
                this.add(labels[i]);
                labels[i].setBounds(width/6, 150, width/6*4, height - 350);
                this.revalidate();
                this.repaint();
                if(misses == 7)
                    looser();
            }
        }
    }

    public void looser(){
        int response = JOptionPane.showConfirmDialog(null, "You lost, the word was " + word +". Would you like to try again");
        if(response == JOptionPane.YES_OPTION){
            for(int i = 0; i < images.length; i++){
                if(wrong == i){
                    this.remove(labels[i]);
                }
            }
            reset();
        }
        else{
            System.exit(0);
        }

    }

    public void winner(){
        int response = JOptionPane.showConfirmDialog(null, "You won, would you like to go again");
        if(response == JOptionPane.YES_OPTION){
            for(int i = 0; i < images.length; i++){
                if(wrong == i){
                    this.remove(labels[i]);
                }
            }
            reset();
        }
        else{
            System.exit(0);
        }
    }

    public void reset(){
        this.remove(labels[wrong]);
        this.add(labels[0]);
        labels[0].setBounds(width/6, 150, width/6*4, height - 350);
        this.revalidate();
        this.repaint();
        for(int i = 0; i < alphabetF.length; i++){
            alphabetF[i].setForeground(Color.BLACK);
            alphabetF[i].removeActionListener(this);
            alphabetF[i].addActionListener(this);
        }
        word = getWord();
        for(int i = 0; i < word.length(); i++) {
            if(i == 0)
                wordHidden = "-";
            else
                wordHidden = wordHidden + "-";
        }
        wordHiddenT.setText(wordHidden);
        southPanel.add(wordHiddenT);
        right = 0;
        wrong = 0;

        System.out.println("Secret word: " + word);
        System.out.println("Right: " + right);
        System.out.println("Wrong: " + wrong);
    }

    public String getWord(){
        String word = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(".//words.txt"));
            String line = br.readLine();
            array = line.split(delimiter);
            int num = ThreadLocalRandom.current().nextInt(0, array.length + 1);
            word = array[num];
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return word;
    }

    public void CreateLogin(){
        this.add(loginPanel);
        loginPanel.setBounds(0,0,width,height);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.add(title);
        title.setBounds(width/2 -100, height/2 - 200, 600, 120);
        title.setFont(font130);
        loginPanel.add(userL);
        userL.setBounds(width/2 -100, height/2 + 5, 100, 20);
        loginPanel.add(passL);
        passL.setBounds(width/2 -100, height/2 + 40, 100, 20);
        loginPanel.add(userB);
        userB.setBounds(width/2, height/2, 200, 30);
        loginPanel.add(passB);
        passB.setBounds(width/2, height/2 + 35, 200, 30);
        loginPanel.add(submit);
        submit.addActionListener(this);
        submit.setBounds(width/2 - 10, height/2 + 70, 70, 20);
        loginPanel.add(change);
        change.addActionListener(this);
        change.setBounds(width/2 - 80, height/2 + 100, 210, 20);
        change.setBackground(Color.white);
        change.setFocusPainted(false);
        change.setBorder(null);
        change.setForeground(Color.BLUE);
    }

    public static void main(String[] args){
        Hangman frame = new Hangman();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}