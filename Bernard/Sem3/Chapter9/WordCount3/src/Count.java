import javax.swing.*;
import java.awt.event.*;

public class Count extends JFrame implements ActionListener{

    int wordCount;

    static JTextArea textArea = new JTextArea("");
    JTextField out = new JTextField("");
    JLabel lab = new JLabel("Word Count = ");
    JButton bun = new JButton("Count Words");

    public Count(){
        this.setLayout(null);
        this.add(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(5,5,570,160);
        this.add(bun);
        bun.setBounds(140,180,125,25);
        bun.addActionListener(this);
        this.add(lab);
        lab.setBounds(283,180,100,25);
        this.add(out);
        out.setBounds(370,180,100,25);


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bun){
            wordCount = 0;
            String str = textArea.getText();
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == ' ')
                {
                    wordCount++;
                    System.out.println(wordCount);
                }
            }
            wordCount ++;
            out.setText(String.valueOf(wordCount));
        }
    }

    public static void main(String[] args){
        Count c = new Count();
        c.setBounds(300,300,600,250);
        c.setVisible(true);
    }
}
