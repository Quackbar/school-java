/**
 * Created by bkintzing on 11/2/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChildOne extends Parent {
    JLabel l2 = new JLabel("Child One");

    JButton bun3 = new JButton("Go Back to Parent");

    JPanel top2 = new JPanel();
    JPanel bottom2 = new JPanel();

    public ChildOne(){
        l1.setText("Child One");
        bun1.setVisible(false);
        bun2.setVisible(false);
        this.setLayout(new GridLayout(2, 0));
        this.add(top2);
        this.add(bottom2);
        this.setTitle("Child One");
        top2.setLayout(new GridLayout(0, 3));
        //top2.add(l2);
        bottom2.add(bun3);
        bun3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        c.setVisible(false);
        cc.setVisible(false);
        p.setVisible(true);
    }
}
