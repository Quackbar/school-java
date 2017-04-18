/**
 * Created by bernard on 4/16/17.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;
import java.util.TimerTask;

public class gamePanel extends JPanel{

    //Stats
    int health = 100, walls = 20, doors = 1, days = 1;
    boolean day = true;
    JLabel stats = new JLabel("   Health: " + health + "     Walls(Z): " + walls + "    Doors(X): " + doors + "    Day: " + days + "    Time: " + day + " 0:00:30");

    //Day timer
    Timer time = new Timer();
    int length = 10, delay = 1000, period = 1000;

    //Pictures
    BufferedImage grid, character;
    BufferedImage[] goomba;

    //Locations (Grid is 0,0 to 1510,670
    int charX = 700, charY = 400;
    ArrayList<Integer> wallX = new ArrayList<>();
    ArrayList<Integer> wallY = new ArrayList<>();
    ArrayList<Integer> doorX = new ArrayList<>();
    ArrayList<Integer> doorY = new ArrayList<>();
    Integer[] goombaX = new Integer[5];
    int[] goombaY = {0, 0, 0, 0, 0};

    Boolean[][] wallOccupied = new Boolean[151][67];

    public gamePanel(){
        this.add(stats);
        try{
            grid = ImageIO.read(new File("./Pictures/grid.png"));
            character = ImageIO.read(new File("./Pictures/character.png"));
            for(int i = 0; i < goomba.length; i ++){
                goomba[i] = ImageIO.read(new File("./Pictures/goomba" + i +".png"));
                int randNum = ThreadLocalRandom.current().nextInt(0, 151 + 1);
                while(contains(goombaX, randNum)){
                    randNum = ThreadLocalRandom.current().nextInt(1, 151 + 1);
                }
                goombaX[i] = randNum * 10;
            }
        }
        catch(Exception e){}
        for(int row = 0; row < 151; row++){
            for(int col = 0; col < 67; col++){
                wallOccupied[row][col] = false;
            }
        }
        startTimer();
    }

    public static boolean contains(Integer[] arr, Integer item) {
        return Arrays.stream(arr).anyMatch(item::equals);
    }

    public void startTimer(){
        time.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                changeDay();
            }
        },delay, period);
    }

    public void changeDay(){
        length -= 1;
        if(length == 0){
            time.cancel();
            startTimer();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(grid, 200, 200, null);
        for(int i = 0; i < wallX.size(); i++){
            g.setColor(Color.BLACK);
            g.fillRect(wallX.get(i) + 200, wallY.get(i) + 200, 11, 11);
        }
        for(int i = 0; i < doorX.size(); i ++){
            g.setColor(Color.GRAY);
            g.fillRect(doorX.get(i) + 200, doorY.get(i) + 200, 11, 11);
        }
        g.drawImage(character, charX + 201, charY + 201, null);
    }
}