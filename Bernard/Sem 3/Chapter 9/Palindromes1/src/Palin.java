import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.StringBuffer.*;

public class Palin extends JFrame implements ActionListener {

    int red, green, blue;

    Color randomColor = new Color(0, 0, 0);

    Font f1 = new Font("Ravie", Font.PLAIN, 20);
    Font f2 = new Font("", Font.PLAIN, 17);
    Font f3 = new Font("Ravie", Font.PLAIN, 25);

    JLabel title = new JLabel("Playing with Palindromes");
    JLabel prompt = new JLabel("Enter a word or phrase without punctuation:");
    JLabel output = new JLabel("");

    JTextField input = new JTextField();

    JButton bun = new JButton("Check");

    public Palin() {
        this.setLayout(null);
        this.add(title);
        title.setFont(f1);
        title.setBounds(120, 5, 350, 20);
        this.add(prompt);
        prompt.setFont(f2);
        prompt.setBounds(0, 60, 350, 20);
        this.add(input);
        input.setBounds(330, 60, 150, 25);
        this.add(bun);
        bun.setBounds(220, 130, 120, 30);
        bun.addActionListener(this);
        this.add(output);
        output.setBounds(220, 170, 200, 80);
        output.setFont(f3);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bun) {
            if (!check()) {
                red = (int) (Math.random() * 256);
                green = (int) (Math.random() * 256);
                blue = (int) (Math.random() * 256);
                randomColor = new Color(red, green, blue);
                output.setForeground(randomColor);
                output.setText("Failure");
            } else {
                red = (int) (Math.random() * 256);
                green = (int) (Math.random() * 256);
                blue = (int) (Math.random() * 256);
                randomColor = new Color(red, green, blue);
                output.setForeground(randomColor);
                output.setText("Success");
            }
        }
    }

    public boolean check(){
                String in = input.getText();
                String inWithoutSpaces = in.replaceAll("\\s+","");
                System.out.println(inWithoutSpaces);
                String reverse = new StringBuffer(inWithoutSpaces).reverse().toString();
                if(reverse.equals(inWithoutSpaces)){
                    return true;
                }
                else{
                    return false;
                }
    }

    public static void main(String[] args) {
        Palin p = new Palin();
        p.setVisible(true);
        p.setBounds(400, 300, 600, 300);
        p.setTitle("Playing with Palindromes!");
    }
}
