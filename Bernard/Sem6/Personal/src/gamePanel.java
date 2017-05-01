/**
 * Created by bernard on 4/16/17.
 */
import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel{

    //Instances of the other classes
    map map = new map();
    character character = new character();
    goomba goomba = new goomba();
    runIntro runIntro = new runIntro();

    //Locations (Grid is 0,0 to 1510,670

    JLabel stats = new JLabel("Health: " + character.health + "     Walls(Z): " + map.walls + "    Doors(X): " + map.doors + "    Day: " + map.days);

    public gamePanel(){
        this.add(stats);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(map.grid, 200, 200, null);
        g.drawImage(runIntro.viper, 0, 250, null);
        for(int i = 0; i < map.wallX.size(); i++){ //Draw walls
            g.setColor(Color.BLACK);
            g.fillRect(map.wallX.get(i) + 200, map.wallY.get(i) + 200, 11, 11);
        }

        for(int i = 0; i < map.doorX.size(); i ++){ //Draw doors
            g.setColor(Color.GRAY);
            g.fillRect(map.doorX.get(i) + 200, map.doorY.get(i) + 200, 11, 11);
        }
        g.drawImage(character.image, character.x + 201, character.y + 201, null); //Draw character

        for(int i = 0; i < goomba.image.length; i++){ //Draw gooombas moving
            System.out.println("Paint(" + i +") x: " + goomba.x[i] + " y: "+ goomba.y[i]);
            g.drawImage(goomba.image[i], goomba.x[i] + 201, goomba.y[i] + 201, null);
        }
    }
}