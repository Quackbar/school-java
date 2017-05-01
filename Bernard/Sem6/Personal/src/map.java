/**
 * Created by bernard on 4/28/17.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class map{

    /**
     * createDoor and createWall should be in map.java, however it creates a StackOverFlow Error
     *  because character.java already has an instance of map.java.
     *  Locations (Grid is 0,0 to 1510,670)
     */

    ArrayList<Integer> wallX = new ArrayList<>();
    ArrayList<Integer> wallY = new ArrayList<>();
    ArrayList<Integer> doorX = new ArrayList<>();
    ArrayList<Integer> doorY = new ArrayList<>();

    //2D array of whats in every coordinate
    String[][] occupied = new String[151][67];

    //BufferedImage
    BufferedImage grid;

    //Stats
    int walls = 20, doors = 1, days = 1;
    boolean day = true;

    public map(){
        try{ //Grid
            grid = ImageIO.read(new File("./Pictures/grid.png"));
        } catch(Exception e){System.out.println("Could not create grid: " + e.getStackTrace());}

        for(int row = 0; row < 151; row++){ //Populate occupied array with "empty"
            for(int col = 0; col < 67; col++){
                occupied[row][col] = "empty";
            }
        }
    }
}