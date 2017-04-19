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
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class gamePanel extends JPanel{

    //Stats
    int health = 100, walls = 20, doors = 1, days = 1;
    boolean day = true;
    JLabel stats = new JLabel("   Health: " + health + "     Walls(Z): " + walls + "    Doors(X): " + doors + "    Day: " + days + "    Time: " + day + " 0:00:30");

    //Pictures
    BufferedImage grid, character;
    BufferedImage[] goomba = new BufferedImage[5];

    //Locations (Grid is 0,0 to 1510,670
    int charX = 700, charY = 400;
    ArrayList<Integer> wallX = new ArrayList<>();
    ArrayList<Integer> wallY = new ArrayList<>();
    ArrayList<Integer> doorX = new ArrayList<>();
    ArrayList<Integer> doorY = new ArrayList<>();
    Integer[] goombaX = new Integer[5];
    int[] goombaY = {0, 0, 0, 0, 0};

    //2D array of whats in every coordinate
    String[][] occupied = new String[151][67];

    //What the goomba's need
    Random random = new Random();
    boolean direction, positive, empty, goombaRepaint;

    public gamePanel(){
        this.add(stats);
        try{ //Grid
            grid = ImageIO.read(new File("./Pictures/grid.png"));
        } catch(Exception e){System.out.println("Could not create grid: " + e.getStackTrace());}

        try{ //Character
            character = ImageIO.read(new File("./Pictures/character.png"));
        } catch(Exception e){System.out.println("Could not create character: " + e.getStackTrace());}

        try{ //Goomba
            for(int i = 0; i < goomba.length; i ++){
                goomba[i] = ImageIO.read(new File("./Pictures/goomba" + i +".png"));
                int randNum = ThreadLocalRandom.current().nextInt(0, 151 + 1);
                while(contains(goombaX, randNum)){
                    randNum = ThreadLocalRandom.current().nextInt(1, 151 + 1);
                }
                goombaX[i] = randNum * 10;
            }
        } catch(Exception e){System.out.println("Could not create goomba: " + e.getStackTrace());}

        for(int row = 0; row < 151; row++){
            for(int col = 0; col < 67; col++){
                occupied[row][col] = "empty";
            }
        }
    }

    //Checks if an int is present in an array of Integers
    public static boolean contains(Integer[] arr, Integer item) {
        return Arrays.stream(arr).anyMatch(item::equals);
    }

    public void createGoombaLocation(int i){
        empty = false;
        while(!empty){
            direction = random.nextBoolean(); //true = left-right, false = up-down
            positive = random.nextBoolean(); // true = right-down, false = left-up
            if(direction){ //left-right
                if(positive) //right
                    goombaX[i] += 10;
                else //left
                    goombaX[i] -= 10;
            } else{ //up-down
                if(positive) //down
                    goombaY[i] += 10;
                else //up
                    goombaY[i] -= 10;
            }
            if((goombaX[i] < 0) || (goombaX[i] > 1500) || (goombaY[i] < 0) || goombaY[i] > 660) //Check if goomba is out of bounds
                empty = false;
            else{
                if(occupied[goombaX[i] / 10][goombaY[i] / 10].equals("empty"))
                    empty = true;
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(grid, 200, 200, null);
        for(int i = 0; i < wallX.size(); i++){ //Draw walls
            g.setColor(Color.BLACK);
            g.fillRect(wallX.get(i) + 200, wallY.get(i) + 200, 11, 11);
        }
        for(int i = 0; i < doorX.size(); i ++){ //Draw doors
            g.setColor(Color.GRAY);
            g.fillRect(doorX.get(i) + 200, doorY.get(i) + 200, 11, 11);
        }
        g.drawImage(character, charX + 201, charY + 201, null); //Draw character
        if(goombaRepaint){
            for(int i = 0; i < goomba.length; i++){ //Draw gooombas moving
                createGoombaLocation(i);
                g.drawImage(goomba[i], goombaX[i] + 201, goombaY[i] + 201, null);
            }
            goombaRepaint = false;
        }
        else{
            for(int i = 0; i < goomba.length; i++){ //Draw gooombas still
                g.drawImage(goomba[i], goombaX[i] + 201, goombaY[i] + 201, null);
            }
        }
    }
}