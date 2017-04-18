/**
 * Created by bernard on 4/16/17.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class JSammySeashoreLogo extends JPanel{

    BufferedImage image;

    public JSammySeashoreLogo(){
        try{
            image  = ImageIO.read(new File("./logo.png"));
        }catch(Exception e){}
        this.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 50, 56, null);
    }
}
