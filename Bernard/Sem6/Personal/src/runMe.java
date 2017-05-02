/**
 * Created by bernard on 4/16/17.
 */
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class runMe extends JFrame implements KeyListener{

    /**
     *  createDoor and createWall should be in map.java, however it creates a StackOverFlow Error
     *  because character.java already has an instance of map.java.
     *  Locations (Grid is 0,0 to 1510,670)
    */

    //Instances of the other classes
    gamePanel gamePanel = new gamePanel();
    map map = new map();
    character character = new character();
    goomba goomba = new goomba();
    runIntro runIntro = new runIntro();

    //Everything for the JMenu
    JMenuBar menuBar = new JMenuBar();
    JMenu controls = new JMenu("Controls");
    JMenuItem move = new JMenuItem("Movement - WASD & Arrow Keys");
    JMenuItem walls = new JMenuItem("Walls - Z");
    JMenuItem doors = new JMenuItem("Doors - X");

    Timer timer = new Timer();

    public runMe(){
        addKeyListener(this);
        this.setJMenuBar(menuBar);
            menuBar.add(controls);
                controls.add(move);
                controls.add(walls);
                controls.add(doors);
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        if((e.getKeyCode() == 87) || (e.getKeyCode() == 38)){ //W and Up
            character.move(true, -10);
            gamePanel.repaint();
        }
        else if((e.getKeyCode() == 65) || (e.getKeyCode() == 37)){ //A and Left
            character.move(false, -10);
            gamePanel.repaint();
        }
        else if((e.getKeyCode() == 83) || (e.getKeyCode() == 40)){ //S and Down
            character.move(true, 10);
            gamePanel.repaint();
        }
        else if((e.getKeyCode() == 68) || (e.getKeyCode() == 39)){ //D and Right
            character.move(false, 10);
            gamePanel.repaint();
        }
        else if(e.getKeyCode() == 90){ //Z Wall
            if(!(map.walls == 0)){
                if(map.wallX.size() == 0){ //No walls placed yet
                    map.occupied[character.x /10][character.y / 10] = "wall";
                    createWall();
                }
                else{
                    boolean filled = false;
                    for(int i = 0; i < map.wallX.size(); i++){
                        if(!checkOccupied(i)){
                            filled = true;
                            i = map.wallX.size();
                        }
                    }
                    if(!filled){
                        map.occupied[character.x /10][character.y / 10] = "wall";
                        createWall();
                    }
                }
            }
        }
        else if(e.getKeyCode() == 88){ //X Door
            if(!(map.doors == 0)){
                if(map.doorX.size() == 0){ //No doors placed yet
                    map.occupied[character.x /10][character.y / 10] = "door";
                    createDoor();
                }
                else{
                    boolean filled = false;
                    for(int i = 0; i < map.doorX.size(); i++){
                        if(!checkOccupied(i)){
                            filled = true;
                            i = map.doorX.size();
                        }
                    }
                    if(!filled){
                        map.occupied[character.x /10][character.y / 10] = "door";
                        createDoor();
                    }
                }
            }
        }
    }

    public boolean checkOccupied(int i){
        if((i >= map.doorX.size()) || (map.doorX.size() == 0)){ //i is out of bounds for doors
            if((map.wallX.get(i) == character.x) && (map.wallY.get(i) == character.y))
                return false;
            else
                return true;
        }
        else if((i >= map.wallX.size()) || (map.wallX.size() == 0)){ //i is out of bounds for walls
            if((map.doorX.get(i) == character.x) && (map.doorY.get(i) == character.y))
                return false;
            else
                return true;
        }
        else{ //i is not out of bounds for wall or door
            if((map.doorX.get(i) == character.x) && (map.doorY.get(i) == character.y))
                return false;
            else if((map.wallX.get(i) == character.x) && (map.wallY.get(i) == character.y))
                return false;
            else
                return true;
        }
    }

    //Should be located in map.java
    public void createWall(){
        map.wallX.add(character.x);
        map.wallY.add(character.y);
        map.walls -= 1;
        gamePanel.stats.setText("   Health: " + character.health + "     Walls(Z): " + map.walls + "    Doors(X): " + map.doors + "    Day: " + map.days + "    Time: " + map.day);
        repaint();
    }

    //Should be located in map.java
    public void createDoor(){
        map.doorX.add(character.x);
        map.doorY.add(character.y);
        map.doors -= 1;
        gamePanel.stats.setText("   Health: " + character.health + "     Walls(Z): " + map.walls + "    Doors(X): " + map.doors + "    Day: " + map.days + "    Time: " + map.day);
        repaint();
    }

    //Schedules the goombas to move at a fixed rate of 100 milliseconds
    public void startTimer(){
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                for(int i = 0; i < goomba.image.length; i++){
                    goomba.createLocation(i);
                }
                gamePanel.repaint();
                repaint();
            }
        }, 0, 100);
    }

    //Calls the run repaint method of runIntro.java while changing the y coordinate for viper.gif
    public void runAnimation(){
        add(runIntro);
        for(int i = -200; i < 250; i++){
            runIntro.y = i;
            runIntro.repaint();
            try{
                Thread.sleep(6);
            }catch(Exception e){System.out.println("Trouble sleeping");}
        }
        runIntro.landed = true;
        for(int i = 150; i < 200; i++){
            runIntro.animCharX = i;
            runIntro.repaint();
            try{
                Thread.sleep(10);
            }catch(Exception e){System.out.println("Trouble sleeping");}
        }
        remove(runIntro);
        add(gamePanel);
        validate();
        repaint();
        startTimer();
    }

    public static void main(String[] args){
        runMe m = new runMe();
        m.setVisible(true);
        m.setSize(1920, 1080);
        m.setTitle("My Title");
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.runAnimation();
    }
}