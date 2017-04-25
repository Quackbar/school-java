import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JChangeSizeAndColorPanel2 extends JPanel implements ActionListener{
    String phrase = "Ye Be Warned of the Canadian Wrath";
    Color[] color = new Color[9];
    int x = 145, y = 475, sub = 0;
    Font[] font = new Font[9];
    JButton button = new JButton("Click Me");
    Random rand = new Random();

    public JChangeSizeAndColorPanel2(){
        color[0] = Color.RED;
        color[1] = Color.GREEN;
        color[2] = Color.BLUE;
        color[3] = Color.YELLOW;
        color[4] = Color.CYAN;
        color[5] = Color.LIGHT_GRAY;
        color[5] = Color.MAGENTA;
        color[6] = Color.ORANGE;
        color[7] = Color.PINK;
        color[8] = Color.WHITE;
        font[0] = new Font("Freestyle Script", Font.PLAIN, 70);
        font[1] = new Font("Freestyle Script", Font.PLAIN, 65);
        font[2] = new Font("Freestyle Script", Font.PLAIN, 60);
        font[3] = new Font("Freestyle Script", Font.PLAIN, 55);
        font[4] = new Font("Freestyle Script", Font.PLAIN, 50);
        font[5] = new Font("Freestyle Script", Font.PLAIN, 45);
        font[6] = new Font("Freestyle Script", Font.PLAIN, 40);
        font[7] = new Font("Freestyle Script", Font.PLAIN, 35);
        font[8] = new Font("Freestyle Script", Font.PLAIN, 30);
        setBackground(Color.BLACK);
        add(button);
        button.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color[sub]);
        g.setFont(font[sub]);
        g.drawString(phrase,x,y);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            sub = rand.nextInt((8 - 0) + 1) + 0;
            x = rand.nextInt((290 - 0) + 1) + 0;
            y = rand.nextInt((950 - 100) + 1) + 100;
            System.out.println("sub: " + sub + " x: " + x + " y: " + y);
            repaint();
        }
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new JChangeSizeAndColorPanel2());
        f.setVisible(true);
        f.setSize(1500,1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
