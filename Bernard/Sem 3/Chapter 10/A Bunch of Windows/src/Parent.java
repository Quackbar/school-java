/**
 * Created by bkintzing on 11/2/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Parent extends JFrame implements ActionListener, Activator{

    JLabel l1 = new JLabel("Parent Window");

    JButton bun1 = new JButton("Display Child 1");
    JButton bun2 = new JButton("Display Child 2");

    JPanel top1 = new JPanel();
    JPanel bottom1 = new JPanel();

    static Parent p = new Parent();
    static ChildOne c = new ChildOne();
    static ChildTwo cc = new ChildTwo();

    public Parent(){
        this.setLayout(new GridLayout(2,0));
        this.add(top1);
        this.add(bottom1);
        top1.setLayout(new GridLayout(0,2));
        top1.add(l1);
        bottom1.add(bun1);
        bun1.addActionListener(this);
        bottom1.add(bun2);
        bun2.addActionListener(this);
    }

    public void Activate(){
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==  bun1){
            ChildOne c = new ChildOne();
            c.setVisible(true);
            c.setBounds(500,500,300,100);
            p.setVisible(false);
        }
        else{
            ChildTwo cc = new ChildTwo();
            cc.setVisible(true);
            cc.setBounds(500, 500, 300, 100);
            p.setVisible(false);
        }
    }

    public static void main(String[] args) {
        p.setBounds(500, 500, 300, 100);
        p.setVisible(true);
        p.setTitle("Parent for Callback");
        p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
