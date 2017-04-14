/**
 * Created by bkintzing on 4/14/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JChangeSizeAndColorPanel extends JPanel implements ActionListener{
    String phrase = "Ye Be Warned of the Canadian Wrath";
    Font fon = new Font("Freestyle Script", Font.BOLD, 30);
    JTextField feild = new JTextField(phrase);

    public JChangeSizeAndColorPanel(){
        feild.setFont(fon);
        feild.
    }

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args){
        JChangeSizeAndColorPanel f = new JChangeSizeAndColorPanel();
        f.setVisible(true);
        f.setSize(700,200);
    }
}
