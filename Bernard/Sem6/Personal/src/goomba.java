/**
 * Created by bernard on 4/28/17.
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class goomba{

    //Instances of the other classes
    map map = new map();
    character character = new character();
    
    //Locations (Grid is 0,0 to 1510,670
    static Integer[] x = new Integer[5];
    static int[] y = {50, 50, 50, 50, 50};
    static int[] turn = new int[5];

    BufferedImage[] image = new BufferedImage[5];
    enum directions{
        up, down, right, left, upRight, upLeft, downRight, downLeft
    }
    static directions dirToChar;
    static directions[] direction = new directions[5];
    
    public goomba(){
        try{ //Goomba
            for(int i = 0; i < image.length; i ++){
                image[i] = ImageIO.read(new File("./Pictures/goomba" + i +".png"));
                int randNum = ThreadLocalRandom.current().nextInt(0, 151 + 1);
                while(contains(x, randNum)){
                    randNum = ThreadLocalRandom.current().nextInt(1, 151 + 1);
                }
                x[i] = randNum * 10;
                map.occupied[x[i] /10][y[i] / 10] = "goomba";
            }
        } catch(Exception e){System.out.println("Could not create goomba: " + e.getStackTrace());}

        for(int i = 0; i < turn.length; i++){
            turn(i);
        }
    }
    
    public void turn(int i){ //Change turn length and change direction
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

    public void createLocation(int i){ //Algorithm for moving the goomba
        int vertical = 0, horizontal = 0;
        boolean safe = false; //safe = nothing present in the location of move

        if(turn[i] == 0){
            turn(i);
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
            y[i] += vertical;
            x[i] += horizontal;
            if(validMove(i)){
                map.occupied[x[i] / 10][y[i] / 10] = "goomba";
                map.occupied[(x[i] - horizontal) / 10][(y[i] - vertical) / 10] = "empty";
                safe = true;
            }
            else{
                y[i] -= vertical;
                x[i] -= horizontal;
                directions check = direction[i];
                while(direction[i] == check)
                    turn(i);
            }
        }
    }

    public void blowGoomba(int i){
        character.health -= 20;
    }

    public boolean validMove(int i){
        if((x[i] < 0) || (x[i] > 1500) || (y[i] < 0) || y[i] > 660) //Check if goomba is out of bounds
            return false;
        else if(!(map.occupied[x[i] / 10][y[i] / 10].equals("empty"))) //Check if location is already filled
            return false;
        else
            return true;
    }

    public boolean inRange(int i, int range){
        if((character.x - x[i] <= range) && (character.x - x[i] >= 0) && (character.y - y[i] >= -range)  && (character.y - y[i] <= 0)){ //Goomba is DownLeft of Char
            dirToChar = directions.upRight;
            return true;
        }
        else if((character.x - x[i] >= -range) && (character.x - x[i] <= 0) && (character.y - y[i] >= -range)  && (character.y - y[i] <= 0)){ //Goomba is DownRight of Char
            dirToChar = directions.upLeft;
            return true;
        }
        else if((character.x - x[i] <= range) && (character.x - x[i] >= 0)&& (character.y - y[i] <= range)  && (character.y - y[i] >= 0)){ //Goomba is UpLeft of Char
            dirToChar = directions.downRight;
            return true;
        }
        else if((character.x - x[i] >= -range) && (character.x - x[i] <= 0)&& (character.y - y[i] <= range)  && (character.y - y[i] >= 0)){ //Goomba is upRight of Char
            dirToChar = directions.upLeft;
            return true;
        }
        else if((character.y - y[i] <= range) && (character.y - y[i] >= 0) && (character.x == x[i])){ //Goomba is Up from Char
            dirToChar = directions.down;
            return true;
        }
        else if((character.y - y[i] >= -range) && (character.y - y[i] <= 0) && (character.x == x[i])){ //Goomba is Down from Char
            dirToChar = directions.up;
            return true;
        }
        else if((character.x - x[i] <= range) && (character.x - x[i] >= 0) && (character.y == y[i])){ //Goomba is Left of Char
            dirToChar = directions.right;
            return true;
        }
        else if((character.x - x[i] >= -range) && (character.x - x[i] <= 0) && (character.y == y[i])){ //Goomba is Right of Char
            dirToChar = directions.left;
            return true;
        }
        else
            return false;
    }

    //Checks if an int is present in an array of Integers
    public static boolean contains(Integer[] arr, Integer item) {
        return Arrays.stream(arr).anyMatch(item::equals);
    }
}