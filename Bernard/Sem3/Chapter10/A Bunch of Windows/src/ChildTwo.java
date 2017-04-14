/**
 * Created by bkintzing on 11/2/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChildTwo extends Parent{
    JLabel l3 = new JLabel("Child Two");

    JButton bun4 = new JButton("Go back to Parent");

    JPanel top3 = new JPanel();
    JPanel bottom3 = new JPanel();


    public ChildTwo(){
        l1.setText("Child Two");
        bun1.setVisible(false);
        bun2.setVisible(false);
        this.setLayout(new GridLayout(2, 0));
        this.add(top3);
        this.add(bottom3);
        this.setTitle("Child Two");
        top3.setLayout(new FlowLayout());
        //top3.add(l3);
        bottom3.add(bun4);
        bun4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        c.setVisible(false);
        cc.setVisible(false);
        p.setVisible(true);
    }
}
