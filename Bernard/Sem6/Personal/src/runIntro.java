/**
 * Created by bkintzing on 4/24/2017.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class runIntro extends JPanel{
    BufferedImage viper, animCharacter;
    int viperX = 0, viperY = 0, animCharX = 150, animCharY = 450;
    boolean landed = false;

    public runIntro(){
        try{ //Ship
           viper = ImageIO.read(new File("./Pictures/viper.gif"));
        } catch(Exception e){System.out.println("Could not create viper: " + e.getStackTrace());}

        try{ //Animation Character
            animCharacter = ImageIO.read(new File("./Pictures/character.png"));
        } catch(Exception e){System.out.println("Could not create animCharacter: " + e.getStackTrace());}
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(viper, viperX, viperY, null);
        if(landed)
            g.drawImage(animCharacter, animCharX, animCharY, null);
    }
}
