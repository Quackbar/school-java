import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Per extends JFrame implements ActionListener{

    Font f = new Font("Elephant", Font.PLAIN, 20);

    static int width, height, ran;

    Boolean checkaroo =false;

    String picName, picName1, picName2, picName3, picName4,picName5, picName6;

    BufferedImage myPicture;
    BufferedImage walPicture;
    BufferedImage wanPicture;
    BufferedImage wizPicture;
    BufferedImage dogPicture;
    BufferedImage blackPicture;


    JButton wal = new JButton();
    JButton blackWal1 = new JButton();
    JButton blackWal2 = new JButton();

    JLabel walLabel;
    JLabel wanLabel;
    JLabel wizLabel;
    JLabel dogLabel;
    JLabel blackLabel;
    JLabel walLabelT = new JLabel();
    JLabel wanLabelT = new JLabel();
    JLabel wizLabelT = new JLabel();
    JLabel dogLabelT = new JLabel();
    JLabel blackLabelT = new JLabel();

    JPanel pan = new JPanel();
    JPanel top = new JPanel();

    public Per(){
        this.setLayout(null);
        this.add(pan);
        pan.setBounds(0, 100, 1280, 924);
        pan.setLayout(null);
        this.add(top);
        top.setBounds(0,0,1280,100);
        top.setLayout(new GridLayout(0,8));
        for(int i = 0; i<10; i++){
            //bun.get(i) = new JButton();
        }
        ran = (int) (Math.random() * (7-1));
        /*CHANGE WHEN DONE TESTING*/ran = 2;
        System.out.println(ran);
        picName = "Waldo" + ran + ".jpg";
        try {
            myPicture = ImageIO.read(new File(picName));
        }
        catch(IOException ex){System.out.println();}
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        pan.add(picLabel);
        picLabel.setBounds(0, 0, 1280, 924);
        picName1 = "Waldo.png";
        try {
            walPicture = ImageIO.read(new File(picName1));
            walLabel = new JLabel(new ImageIcon(walPicture));
        }
        catch(Exception ex){System.out.println("In waldo catch");}
        picName2 = "Wenda.png";
        try {
            wanPicture = ImageIO.read(new File(picName2));
            wanLabel = new JLabel(new ImageIcon(wanPicture));
        }
        catch(Exception ex){System.out.println("In wenda catch");}
        picName3 = "Wizard.png";
        try {
            wizPicture = ImageIO.read(new File(picName3));
            wizLabel = new JLabel(new ImageIcon(wizPicture));
        }
        catch(IOException ex){System.out.println("In wizard catch");}
        picName4 = "Dog.png";
        try {
            dogPicture = ImageIO.read(new File(picName4));
            dogLabel = new JLabel(new ImageIcon(dogPicture));
        }
        catch(IOException ex){System.out.println("In dog catch");}
        picName5 = "BlackWaldo.jpg";
        try {
            blackPicture = ImageIO.read(new File(picName5));
            blackLabel = new JLabel(new ImageIcon(blackPicture));
        }
        catch(IOException ex){System.out.println("In dog catch");}
        top.setBackground(Color.WHITE);
        setBun();
        setTop();
    }

    public void setBun(){
        if(ran == 0){
            pan.add(wal);
            wal.setBounds(624, 315, 20, 55);
            wal.addActionListener(this);
            wal.setOpaque(false);
            wal.setContentAreaFilled(false);
            wal.setBorderPainted(false);
        }
        else if(ran == 1){
            pan.add(wal);
            wal.setBounds(208, 776, 13, 13);
            wal.addActionListener(this);
            wal.setOpaque(false);
            wal.setContentAreaFilled(false);
            wal.setBorderPainted(false);
        }
        else if(ran == 2){
            pan.add(wal);
            wal.setBounds(870, 318, 20, 25);
            wal.addActionListener(this);
            wal.setOpaque(false);
            wal.setContentAreaFilled(false);
            wal.setBorderPainted(false);
            pan.add(blackWal1);
            blackWal1.setBounds(281, 184, 20, 25);
            blackWal1.addActionListener(this);
            blackWal1.setOpaque(false);
            blackWal1.setContentAreaFilled(false);
            blackWal1.setBorderPainted(false);
            pan.add(blackWal2);
            blackWal2.setBounds(1164, 554, 15, 20);
            blackWal2.addActionListener(this);
            blackWal2.setOpaque(false);
            blackWal2.setContentAreaFilled(false);
            blackWal2.setBorderPainted(false);
        }
        else if(ran == 3){
            pan.add(wal);
            wal.setBounds(70, 783, 20, 45);
            wal.addActionListener(this);
            wal.setOpaque(false);
            wal.setContentAreaFilled(false);
            wal.setBorderPainted(false);
        }
        else if(ran == 4){
            pan.add(wal);
            wal.setBounds(1073, 259, 23, 42);
            wal.addActionListener(this);
            wal.setOpaque(false);
            wal.setContentAreaFilled(false);
            wal.setBorderPainted(false);
        }
        else if(ran == 5){
            pan.add(wal);
            wal.setBounds(602, 189, 15, 30);
            wal.addActionListener(this);
            wal.setOpaque(false);
            wal.setContentAreaFilled(false);
            wal.setBorderPainted(false);
        }
    }

    public void setTop(){
        if(ran == 0){
            walLabelT.setText("1000");
            walLabelT.setFont(f);
        }
        if(ran == 1){
            walLabelT.setText("1000");
            walLabelT.setFont(f);
        }
        if(ran == 2){
            walLabelT.setText("1000");
            walLabelT.setFont(f);
            blackLabelT.setText("1000 X2");
            blackLabelT.setFont(f);
            try {
                top.add(walLabel);
                top.add(walLabelT);
                top.add(blackLabel);
                top.add(blackLabelT);
            } catch (Exception ex) {

            }
        }
        if(ran == 3){
            try{
                this.add(walLabel);
                this.add(walLabelT);
            }
            catch (Exception ex){

            }
            walLabelT.setText("1000");
            walLabelT.setFont(f);
            wanLabelT.setText("0");
            wanLabelT.setFont(f);
            wizLabelT.setText("0");
            wizLabelT.setFont(f);
            dogLabelT.setText("0");
            dogLabelT.setFont(f);
        }
        if(ran == 4){
            try{
                this.add(walLabel);
                this.add(walLabelT);
            }
            catch (Exception ex){

            }
            walLabelT.setText("1000");
            walLabelT.setFont(f);
            wanLabelT.setText("0");
            wanLabelT.setFont(f);
            wizLabelT.setText("0");
            wizLabelT.setFont(f);
            dogLabelT.setText("0");
            dogLabelT.setFont(f);
        }
        if(ran == 5){
            try{
                this.add(walLabel);
                this.add(walLabelT);
            }
            catch (Exception ex){

            }
            walLabelT.setText("1000");
            walLabelT.setFont(f);
            wanLabelT.setText("0");
            wanLabelT.setFont(f);
            wizLabelT.setText("0");
            wizLabelT.setFont(f);
            dogLabelT.setText("0");
            dogLabelT.setFont(f);
        }
    }

    public void check0(){

    }
    public void check1(){

    }
    public void check2(int a){
        System.out.println("checkaroo = " + checkaroo + "\n" + "a = " + a);
        if(a == 1){
            JOptionPane.showMessageDialog(null,"You found Waldo");
            wal.setEnabled(false);
        }
        else if(a == 2){
            if(checkaroo == false){
                JOptionPane.showMessageDialog(null,"You found one of the Black Waldo's");;
                checkaroo = true;
            }
            else{
                JOptionPane.showMessageDialog(null,"You found the last Black Waldo");
            }
            blackWal1.setEnabled(false);
        }
        else if(a == 3){
            if(checkaroo == false){
                JOptionPane.showMessageDialog(null,"You found one of the Black Waldo's");;
                checkaroo = true;
            }
            else{
                JOptionPane.showMessageDialog(null,"You found the last Black Waldo");
            }
            blackWal2.setEnabled(false);
        }


    }
    public void check3(){

    }
    public void check4(){

    }
    public void check5(){

    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == wal){
            if(ran == 0){
                JOptionPane.showMessageDialog(null, "You Found Waldo");

            }
            else if(ran == 1){
                JOptionPane.showMessageDialog(null,"You Found Waldo");
            }
            else if(ran == 2){
                check2(1);
                System.out.println("Waldo found");
            }
            else if(ran == 3){
                JOptionPane.showMessageDialog(null, "You Found Waldo");
            }
            else if(ran == 4){
                JOptionPane.showMessageDialog(null, "You Found Waldo");
            }
            else if(ran == 5){
                JOptionPane.showMessageDialog(null,"You found Waldo");
            }
        }
        else if(e.getSource() == blackWal1){
            check2(2);
            System.out.println("BlackWal1 getSource");
        }
        else if(e.getSource() == blackWal2){
            check2(3);
            System.out.println("BlackWal2 getSource");
        }
    }

    public static void main(String[] args){
        Per p = new Per();
        p.setExtendedState(JFrame.MAXIMIZED_BOTH);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setTitle("Where's Waldo The Computer Game For Children Of All Ages");
    }
}