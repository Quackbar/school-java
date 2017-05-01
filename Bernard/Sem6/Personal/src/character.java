/**
 * Created by bernard on 4/28/17.
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class character{

    //Instances of the other classes
    map map = new map();

    //Locations (Grid is 0,0 to 1510,670
    int x = 0, y = 250;

    //Buffered Image
    BufferedImage image;

    //Stats
    int health = 100;

    public character(){
        try{ //Character
            image = ImageIO.read(new File("./Pictures/character.png"));
        } catch(Exception e){System.out.println("Could not create character: " + e.getStackTrace());}
    }

    public void move(boolean vertical, int amount){
        if(vertical){
            if(validMove())
                y += amount;
        }
        else{
            if(validMove())
                x += amount;
        }
    }

    public boolean validMove(){
        if((x < 0) || (x > 1500) || (y < 0) || y > 660) //Check if goomba is out of bounds
            return false;
        else if(!(map.occupied[x / 10][y / 10].equals("empty"))) //Check if location is alredy filled
            return false;
        else
            return true;
    }
}
