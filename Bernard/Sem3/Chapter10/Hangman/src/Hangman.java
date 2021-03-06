/**
 * Created by bkintzing on 10/26/2015.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Hangman extends JFrame implements GuessInterface, ActionListener, WordInterface, Activator{
    int guessCounter = 0, guessWrongCounter = 0, option;
    ColorSettings game = new ColorSettings(Color.BLACK, Color.MAGENTA, Color.LIGHT_GRAY);
    JPanel wordPanel = new JPanel(), guessPanel = new JPanel(), buttonPanel = new JPanel();
    PaintPanel pictPanel = new PaintPanel(game, guessWrongCounter);
    JTextField wordField = new JTextField(20), guessField = new JTextField(5);
    String word;
    JButton letterButton = new JButton("Press to see misses");
    JButton resetButton = new JButton("Reset");
    ArrayList<Character> letMissList = new ArrayList<Character>();
    static Hangman f1;

    public Hangman(){
        game.userSetDifficulty();
        word = pickWord();
        for(int i = 0; i < word.length(); i++){
            wordField.setText(wordField.getText() + "*");
        }
        setLayout(new BorderLayout());
        wordPanel.add(wordField);
        wordField.setEditable(false);
        wordPanel.setBackground(game.getPanelColor());
        guessField.addActionListener(this);
        guessPanel.add(guessField);
        guessField.requestFocus();
        buttonPanel.setBackground(game.getPanelColor());
        buttonPanel.add(letterButton);
        buttonPanel.add(resetButton);
        letterButton.addActionListener(this);
        resetButton.addActionListener(this);
        guessPanel.setBackground(game.getDrawPanelColor());
        add(wordPanel, BorderLayout.NORTH);
        add(pictPanel, BorderLayout.CENTER);
        add(guessPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void activate(){
        setVisible(true);
    }

    public String pickWord(){
        int wordNum;
        String word = new String();

        if(game.getDifficulty() == 0){
            String[] words = {"Christmas", "Shovel", "Sweater", "Pumpkin", "Chocolate"};
            wordNum = (int)(Math.random() * words.length);
            word = words[wordNum];
        }
        if(game.getDifficulty() == 1){
            String[] words = {"Apple", "Coffee", "Java", "Chair", "Football"};
            wordNum = (int)(Math.random() * words.length);
            word = words[wordNum];
        }
        if(game.getDifficulty() == 2){
            String[] words = {"Pig", "Cat", "Star", "Moon", "Flag"};
            wordNum = (int)(Math.random() * words.length);
            word = words[wordNum];
        }
        return word;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == guessField){
            guess();
        }
        else if(e.getSource() == letterButton){
            miss();
        }
        else if (e.getSource() == resetButton){
            f1 = new Hangman();
            f1.setTitle("Hangman");
            f1.setBounds(5, 10, 300, 400);
            f1.setVisible(true);
        }
    }

    public boolean win(){
        if(wordField.getText().equals(word))
            return true;
        else
            return false;

    }

    public void guess(){
        boolean found = false;
        char letter = guessField.getText().charAt(0);
        char[] letterArray = wordField.getText().toCharArray();
        String newWord = new String();

        for(int j = 0; j<word.length(); j++){
            if(letter == word.charAt(j)){
                letterArray[j] = letter;
                found = true;
            }
        }
        for(int k = 0; k < letterArray.length; k++){
            newWord = newWord + letterArray[k];
        }
        wordField.setText(newWord);
        guessCounter++;
        if(win()){
            JOptionPane.showMessageDialog(null,"You Won it took you " + guessCounter + " guesses.", "Winner", JOptionPane.INFORMATION_MESSAGE);
            guessField.setEditable(false);
        }
        else{
            guessField.setText("");
            guessField.requestFocus();
        }
        if(!found){
            guessWrongCounter++;
            letMissList.add(letter);
            miss();
            pictPanel = new PaintPanel(game, guessWrongCounter);
            if(guessWrongCounter == 6){
                guessField.setEditable(false);
            }
        }
    }

    public void miss(){
        this.setVisible(false);
        MissedLetterFrame f1 = new MissedLetterFrame(letMissList, this, game);
        f1.setTitle("Misses");
        f1.setBounds(400, 200, 250, 70);
        f1.setVisible(true);
    }

    public static void main(String[] args){
        f1 = new Hangman();
        f1.setTitle("Hangman");
        f1.setBounds(5, 10, 300, 400);
        f1.setVisible(true);
    }
}
