import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JChangeSizeAndColorPanel extends JPanel implements ActionListener{
    String phrase = "Ye Be Warned of the Canadian Wrath";
    Color[] color = new Color[4];
    int x = 30, y = 100, sub = 0;
    Font[] font = new Font[4];
    JButton button = new JButton("Click Me (3)");

    public JChangeSizeAndColorPanel(){
        color[0] = Color.RED;
        color[1] = Color.GREEN;
        color[2] = Color.BLUE;
        color[3] = Color.YELLOW;
        font[0] = new Font("Freestyle Script", Font.PLAIN, 50);
        font[1] = new Font("Freestyle Script", Font.PLAIN, 45);
        font[2] = new Font("Freestyle Script", Font.PLAIN, 40);
        font[3] = new Font("Freestyle Script", Font.PLAIN, 35);
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
            sub +=1;
            x += 20;
            if(sub == 3) {
                button.setText("Out of Clicks");
                button.removeActionListener(this);
            }
            else if(sub == 2){
                button.setText("CLick Me (1)");
            }
            else if(sub == 1){
                button.setText("CLick Me (2)");
            }
            repaint();
        }
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new JChangeSizeAndColorPanel());
        f.setVisible(true);
        f.setSize(1000,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}