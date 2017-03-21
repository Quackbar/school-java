/**
 * Created by bkintzing on 10/23/2015.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MissedLetterFrame extends JFrame{
    JPanel letterPanel = new JPanel();
    JTextField letterField = new JTextField(10);
    Activator caller;
    String letterString = new String();
    ColorSettings currentGame;

    public MissedLetterFrame(ArrayList<Character> letMissList, final Activator callerObj, ColorSettings game){
        currentGame = game;
        caller = callerObj;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                caller.activate();
            }
        });
        for(Character letter : letMissList){
            letterString += letter;
        }
        letterField.setText(letterString);
        setLayout(new BorderLayout());
        letterPanel.add(letterField);
        letterField.setEditable(false);
        letterPanel.setBackground(currentGame.getPanelColor());
        add(letterPanel, BorderLayout.CENTER);
    }

}
