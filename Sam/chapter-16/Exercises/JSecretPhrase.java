import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class JSecretPhrase extends JPanel implements ActionListener{
    JButton[] alphaBun = new JButton[26];
    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    Boolean[] alphaBool = new Boolean[26];
    String[] phraseArray = {"SMITH IS CANADIAN  ", "YE BE WARNED       ", "RIP BART           ", "SAM NEEDS ADMIN    ", "BERNARD NEEDS ADMIN", "IM OUT OF PHRASES  "};
    JPanel[] panels = new JPanel[6];
    JLabel title = new JLabel("Secret Phrase Game");
    JLabel description = new JLabel("Play our game - guess the phrase  Enter one letter");
    JLabel phraseLabel = new JLabel("");
    String phrase;
    char[] phraseChar;
    Boolean astiCheck = true;
    JLabel success = new JLabel("               ");
    Font fonLarge = new Font("Serif", Font.BOLD, 40), fonMed = new Font("Serif", Font.BOLD, 30), fonSmall = new Font("Serif", Font.BOLD, 20);
    int randNum;

    public JSecretPhrase(){
        this.setLayout(new GridLayout(6, 1));
        for(int i = 0; i < panels.length; i++){
            panels[i] = new JPanel();
            this.add(panels[i]);
        }
        title.setFont(fonLarge);
        panels[0].add(title);
        description.setFont(fonSmall);
        panels[1].add(description);
        phraseLabel.setFont(fonMed);
        panels[2].add(phraseLabel);
        success.setFont(fonSmall);
        panels[2].add(success);
        for(int i = 0; i < alphabet.length; i ++){
            alphaBool[i] = false;
            alphaBun[i] = new JButton(alphabet[i]);
            alphaBun[i].addActionListener(this);
            if(i <= 10)
                panels[3].add(alphaBun[i]);
            else if((i > 10) && (i <= 20))
                panels[4].add(alphaBun[i]);
            else
                panels[5].add(alphaBun[i]);
        }
        randNum = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        phraseCheck();
    }

    public void phraseCheck(){
        phrase = phraseArray[randNum];
        phraseChar = phrase.toCharArray();
        for(int i = 0; i < phraseChar.length; i ++){
            for(int n = 0; n < alphabet.length; n++){
                if(phraseChar[i] == alphabet[n].charAt(0)){
                    if(!alphaBool[n])
                        phraseChar[i] = '*';
                }
            }
        }
        phrase = String.copyValueOf(phraseChar);
        phraseLabel.setText(phrase);
        for(int i = 0; i < phraseChar.length; i ++){
            if (phraseChar[i] == '*'){
                astiCheck = true;
                i = phraseChar.length;
            }
            else
                astiCheck = false;
        }
        if(!astiCheck){
            success.setText("Congrats");
            for(int i = 0; i < alphaBun.length; i++){
                alphaBun[i].setEnabled(false);
            }
        }
    }

    public void correctClick(int num){
        phrase = phraseArray[randNum];
        phraseChar = phrase.toCharArray();
        for(int i = 0; i < phraseChar.length; i ++){
            if(phraseChar[i] == alphabet[num].charAt(0)){
                success.setText("    Correct!   ");
                i = phraseChar.length;
            }
            else
                success.setText("    Wrong!     ");
        }
    }

    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < alphaBun.length; i++){
            if(e.getSource() == alphaBun[i]){
                alphaBun[i].setEnabled(false);
                alphaBool[i] = true;
                correctClick(i);
            }
        }
        phraseCheck();
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new JSecretPhrase());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
        f.setSize(550, 320);
    }
}