/**
 * Created by bernard on 4/15/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class JLucky7 extends JPanel implements ActionListener{

    JButton[] buttons = new JButton[7];
    Boolean[] flipped = new Boolean[7];
    Integer[] numbers = new Integer[7];
    Font fon = new Font("Serif", Font.BOLD, 40);
    JLabel player1 = new JLabel("Player 1               "), player2 = new JLabel("              Player 2");
    Boolean turn = true, win = false;
    int randNum, checkNum;

    public JLucky7(){
        for(int i = 0; i < buttons.length; i ++){
            buttons[i] = new JButton("Card " + (i + 1));
            buttons[i].setPreferredSize(new Dimension(100,200));
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
            flipped[i] = false;
            randNum = ThreadLocalRandom.current().nextInt(1, 7 + 1);
            while(contains(numbers, randNum)){
                randNum = ThreadLocalRandom.current().nextInt(1, 7 + 1);
            }
            numbers[i] = randNum;
            System.out.print(randNum);
        }
        player1.setFont(fon);
        player2.setFont(fon);
        this.add(player1);
        this.add(player2);
    }

    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < buttons.length; i ++){
            if(e.getSource() == buttons[i]){
                buttons[i].setText(Integer.toString(numbers[i]));
                buttons[i].removeActionListener(this);
                checkNum = numbers[i];
                flipped[i] = true;
            }
        }
        if(flipped[checkNum -1])
            win = true;
        if(turn)
            turn = false;
        else
            turn = true;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(fon);
        if(turn){
            if(win){
                for(int i = 0; i < buttons.length; i ++){
                    buttons[i].removeActionListener(this);
                    this.remove(player1);
                    this.remove(player2);
                }
                g.drawString("Player 1 Wins", 250, 300);
            }
            else{
                g.drawLine(370, 240, 250, 240);
                g.drawLine(250, 240, 270, 230);
                g.drawLine(250, 240, 270, 250);
            }
        }
        else{
            if(win){
                for(int i = 0; i < buttons.length; i ++){
                    buttons[i].removeActionListener(this);
                    this.remove(player1);
                    this.remove(player2);
                }
                g.drawString("Player 2 Wins", 250, 300);
            }
            else{
                g.drawLine(370, 240, 490, 240);
                g.drawLine(490, 240, 470, 230);
                g.drawLine(490, 240, 470, 250);
            }
        }
    }

    public static boolean contains(Integer[] arr, Integer item) {
        return Arrays.stream(arr).anyMatch(item::equals);
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new JLucky7());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(740, 450);
    }
}
