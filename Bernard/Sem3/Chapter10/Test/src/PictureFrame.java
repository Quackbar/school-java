/**
 * Created by bkintzing on 11/30/2015.
 */
import javax.swing.*;
import java.awt.*;

public class PictureFrame extends JFrame{
    Color f, b;
    String shape;

    public PictureFrame(Color f, Color b, String shape) {
        this.f = f;
        this.b = b;
        this.shape = shape;
    }

    public void paint(Graphics g) {
        if(shape.equals("Circle")){
            g.drawOval(10,10,50,50);
            g.fillOval(10,10,50,50);
            g.setColor(f);
        }
        else if(shape.equals("Rectangle")){
            g.drawRect(10, 10, 100, 50);
            g.fillRect(10, 10, 100, 50);
            g.setColor(f);
        }
        else{
            g.drawRect(10, 10, 50, 50);
            g.fillRect(10, 10, 50, 50);
            g.setColor(f);
        }
    }
    public static void main(String[] args){
        PictureFrame f = new PictureFrame(fColor,bColor,shape);
    }
}
