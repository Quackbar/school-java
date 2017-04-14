/**
 * Created by Bernard on 11/22/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Base extends JLabel{

    Color wallColor = new Color(4,4,252);
    Color dotColor = new Color(252,252,12);

    int[] xCoord = {85,138,240,344,450,553,656,761,864,918};
    int[] yCoord = {51,142,200,260,318,379,434,494,553,614};

    String color;
    String direction = "";

    public Base(ImageIcon img, String color){
        super(img);
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setDirection(String direction){
       this.direction = direction;
    }

    public String getDirection(){
        return direction;
    }

    public String coinFlip(){
        String res;
        Random rand = new Random();
        int randomNum = rand.nextInt(3 - 1) + 1;
        if(randomNum == 1){
            res = "HEADS";
        }
        else{
            res = "TAILS";
        }
        return res;
    }
}
