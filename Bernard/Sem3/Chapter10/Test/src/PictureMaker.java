/**
 * Created by bkintzing on 11/17/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureMaker extends JFrame implements Activator, ActionListener{

    JPanel cenPan = new JPanel();
    JPanel cbPan = new JPanel();
    JPanel shapePan = new JPanel();
    JPanel backPan = new JPanel();
    JPanel ranPan1 = new JPanel();
    JPanel ranPan2 = new JPanel();
    JPanel southPan = new JPanel();

    JComboBox shapeColorCombo = new JComboBox();
    JComboBox backColorCombo = new JComboBox();

    static Color fColor;
    static Color bColor;

    static String f,b,shape;

    CheckboxGroup cb = new CheckboxGroup();
        Checkbox c1 = new Checkbox("Circle Box",true,cb);
        Checkbox c2 = new Checkbox("Rectangle Box",false,cb);
        Checkbox c3 = new Checkbox("Square Box",false,cb);

    JButton bun = new JButton("Make It");

    public PictureMaker(){
        this.setLayout(new BorderLayout());
        this.add(cenPan, BorderLayout.CENTER);
            cenPan.setLayout(new GridLayout(0,3));
            cenPan.add(cbPan);
                cbPan.setLayout(new GridLayout(3,0));
                cbPan.add(c1);
                cbPan.add(c2);
                cbPan.add(c3);
            cenPan.add(shapePan);
                shapePan.setLayout(new GridLayout(3,0));
                shapePan.add(ranPan1);
                shapePan.add(shapeColorCombo);
                    shapeColorCombo.addItem("Red");
                    shapeColorCombo.addItem("Green");
                    shapeColorCombo.addItem("Blue");
            cenPan.add(backPan);
                backPan.setLayout(new GridLayout(3,0));
                backPan.add(ranPan2);
                backPan.add(backColorCombo);
                    backColorCombo.addItem("Red");
                    backColorCombo.addItem("Green");
                    backColorCombo.addItem("Blue");
        this.add(southPan, BorderLayout.SOUTH);
            southPan.setLayout(new FlowLayout());
            southPan.add(bun);
                bun.addActionListener(this);
    }

    public void activate(){

    }

    public void actionPerformed(ActionEvent e) {
        f = (String) shapeColorCombo.getSelectedItem();
        b = (String) backColorCombo.getSelectedItem();
        if (f.equals("Red")) {
            fColor = new Color(256, 0, 0);
        } else if (f.equals("Green")) {
            fColor = new Color(0, 256, 0);
        } else {
            fColor = new Color(0, 0, 256);
        }

        if (b.equals("Red")) {
            bColor = new Color(256, 0, 0);
        } else if (b.equals("Green")) {
            bColor = new Color(0, 256, 0);
        } else {
            bColor = new Color(0, 0, 256);
        }

        if(c1.getState() == true){
            shape = "Circle";
        }
        else if(c2.getState() == true){
            shape = "Rectangle";
        }
        else {
            shape = "Square";
        }
    }


    public static void main(String[] args){
        PictureMaker p = new PictureMaker();
        p.setVisible(true);
        p.setBounds(0,0,500,200);
        p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
