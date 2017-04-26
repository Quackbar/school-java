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

public class gamePanel extends JPanel{

    //Stats
    int health = 100, walls = 20, doors = 1, days = 1;
    boolean day = true;
    JLabel stats = new JLabel("Health: " + health + "     Walls(Z): " + walls + "    Doors(X): " + doors + "    Day: " + days);

    //Pictures
    BufferedImage grid, character, viper;
    BufferedImage[] goomba = new BufferedImage[5];

    //Locations (Grid is 0,0 to 1510,670
    int charX = 0, charY = 250;
    ArrayList<Integer> wallX = new ArrayList<>();
    ArrayList<Integer> wallY = new ArrayList<>();
    ArrayList<Integer> doorX = new ArrayList<>();
    ArrayList<Integer> doorY = new ArrayList<>();
    Integer[] goombaX = new Integer[5];
    int[] goombaY = {0, 0, 0, 0, 0};

    //2D array of whats in every coordinate
    String[][] occupied = new String[151][67];

    //What the goomba's need
    int[] turn = new int[5];
    enum directions{
        up, down, right, left, upRight, upLeft, downRight, downLeft
    }
    directions dirToChar;
    directions[] direction = new directions[5];

    public gamePanel(){
        this.add(stats);

        for(int row = 0; row < 151; row++){ //Populate occupied array with "empty"
            for(int col = 0; col < 67; col++){
                occupied[row][col] = "empty";
            }
        }

        try{ //Grid
            grid = ImageIO.read(new File("./Pictures/grid.png"));
        } catch(Exception e){System.out.println("Could not create grid: " + e.getStackTrace());}

        try{ //Ship
            viper = ImageIO.read(new File("./Pictures/viper.gif"));
        } catch(Exception e){System.out.println("Could not create viper: " + e.getStackTrace());}

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
                occupied[goombaX[i] /10][goombaY[i] / 10] = "goomba";
            }
        } catch(Exception e){System.out.println("Could not create goomba: " + e.getStackTrace());}

        for(int i = 0; i < turn.length; i++){
            goombaTurn(i);
        }
    }

    //Checks if an int is present in an array of Integers
    public static boolean contains(Integer[] arr, Integer item) {
        return Arrays.stream(arr).anyMatch(item::equals);
    }

    public void goombaTurn(int i){ //Change turn length and change direction
        int minDist = 3, maxDist = 15;
        turn[i] = ThreadLocalRandom.current().nextInt(minDist, maxDist + 1);
        int dir = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        if(dir == 0) //up
            direction[i] = directions.up;
        else if(dir == 1) //down
            direction[i] = directions.down;
        else if(dir == 2) //right
            direction[i] = directions.right;
        else if(dir == 3) //left
            direction[i] = directions.left;
        else if(dir == 4) //upRight
            direction[i] = directions.upRight;
        else if(dir == 5) //upLeft
            direction[i] = directions.upLeft;
        else if(dir == 6) //downRight
            direction[i] = directions.downRight;
        else if(dir == 7) //downLeft
            direction[i] = directions.downLeft;
    }

    public void createGoombaLocation(int i){ //Algorithm for moving the goomba
        int vertical = 0, horizontal = 0;
        boolean safe = false; //safe = nothing present in the location of move

        if(turn[i] == 0){
            goombaTurn(i);
        }
        turn[i] -= 1;

        while(!safe){
            if(inRange(i, 20))
                blowGoomba(i);
            else if(inRange(i, 200))
                direction[i] = dirToChar;

            if(direction[i] == directions.up){
                vertical = -10;
                horizontal = 0;
            }
            else if(direction[i] == directions.down){
                vertical = 10;
                horizontal = 0;
            }
            else if(direction[i] == directions.right){
                vertical = 0;
                horizontal = 10;
            }
            else if(direction[i] == directions.left){
                vertical = 0;
                horizontal = -10;
            }
            else if(direction[i] == directions.upRight){
                vertical = -10;
                horizontal = 10;
            }
            else if(direction[i] == directions.upLeft){
                vertical = -10;
                horizontal = -10;
            }
            else if(direction[i] == directions.downRight){
                vertical = 10;
                horizontal = 10;
            }
            else if(direction[i] == directions.downLeft){
                vertical = 10;
                horizontal = -10;
            }
            goombaY[i] += vertical;
            goombaX[i] += horizontal;
            if(validMove(i)){
                occupied[goombaX[i] / 10][goombaY[i] / 10] = "goomba";
                occupied[(goombaX[i] - horizontal) / 10][(goombaY[i] - vertical) / 10] = "empty";
                safe = true;
            } else{
                goombaY[i] -= vertical;
                goombaX[i] -= horizontal;
                directions check = direction[i];
                while(direction[i] == check)
                    goombaTurn(i);
            }

        }
    }

    public boolean inRange(int i, int range){
        if((charX - goombaX[i] <= range) && (charX - goombaX[i] >= 0) && (charY - goombaY[i] >= -range)  && (charY - goombaY[i] <= 0)){ //Goomba is UpLeft of Char
            dirToChar = directions.downRight;
            return true;
        }
        else if((charX - goombaX[i] >= -range) && (charX - goombaX[i] <= 0) && (charY - goombaY[i] >= -range)  && (charY - goombaY[i] <= 0)){ //Goomba is UpRight of Char
            dirToChar = directions.downLeft;
            return true;
        }
        else if((charX - goombaX[i] <= range) && (charX - goombaX[i] >= 0)&& (charY - goombaY[i] <= range)  && (charY - goombaY[i] >= 0)){ //Goomba is DownLeft of Char
            dirToChar = directions.upRight;
            return true;
        }
        else if((charX - goombaX[i] >= -range) && (charX - goombaX[i] <= 0)&& (charY - goombaY[i] <= range)  && (charY - goombaY[i] >= 0)){ //Goomba is DownLeft of Char
            dirToChar = directions.upLeft;
            return true;
        }
        else if((charX - goombaX[i] <= range) && (charX - goombaX[i] >= 0)){ //Goomba is Up from Char
            dirToChar = directions.down;
            return true;
        }
        else if((charX - goombaX[i] >= -range) && (charX - goombaX[i] <= 0)){ //Goomba is Down from Char
            dirToChar = directions.up;
            return true;
        }
        else if((charY - goombaY[i] <= range) && (charY - goombaY[i] >= 0)){ //Goomba is Left of Char
            dirToChar = directions.right;
            return true;
        }
        else if((charX - goombaX[i] >= -range) && (charX - goombaX[i] <= 0)){ //Goomba is Right of Char
            dirToChar = directions.left;
            return true;
        }
        else
            return false;

    }

    public void blowGoomba(int i){
        health -= 20;
    }

    public boolean validMove(int i){
        if((goombaX[i] < 0) || (goombaX[i] > 1500) || (goombaY[i] < 0) || goombaY[i] > 660) //Check if goomba is out of bounds
           return false;
        else if(!(occupied[goombaX[i] / 10][goombaY[i] / 10].equals("empty"))) //Check if location is already filled
            return false;
        else
            return true;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(grid, 200, 200, null);
        g.drawImage(viper, 0, 250, null);
        for(int i = 0; i < wallX.size(); i++){ //Draw walls
            g.setColor(Color.BLACK);
            g.fillRect(wallX.get(i) + 200, wallY.get(i) + 200, 11, 11);
        }
        for(int i = 0; i < doorX.size(); i ++){ //Draw doors
            g.setColor(Color.GRAY);
            g.fillRect(doorX.get(i) + 200, doorY.get(i) + 200, 11, 11);
        }
        g.drawImage(character, charX + 201, charY + 201, null); //Draw character

        for(int i = 0; i < goomba.length; i++){ //Draw gooombas moving
            g.drawImage(goomba[i], goombaX[i] + 201, goombaY[i] + 201, null);
        }
    }
}