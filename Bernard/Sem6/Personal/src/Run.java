/**
 * Created by bernard on 4/16/17.
 */
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class Run extends JFrame implements KeyListener{

    gamePanel game = new gamePanel();

    Timer timer = new Timer();

    public Run(){
        this.add(game);
        addKeyListener(this);
        startTimer();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        if((e.getKeyCode() == 87) || (e.getKeyCode() == 38)){ //W and Up
            if(!(game.charY == 0)){
                game.charY -= 10;
                if(!game.occupied[game.charX /10][game.charY / 10].equals("empty"))
                    game.charY +=10;
            }
            game.repaint();
        }
        else if((e.getKeyCode() == 65) || (e.getKeyCode() == 37)){ //A and Left
            if(!(game.charX == 0)){
                game.charX -= 10;
                if(!game.occupied[game.charX /10][game.charY / 10].equals("empty"))
                    game.charX +=10;
            }
            game.repaint();
        }
        else if((e.getKeyCode() == 83) || (e.getKeyCode() == 40)){ //S and Down
            if(!(game.charY == 670)){
                game.charY += 10;
                if(!game.occupied[game.charX /10][game.charY / 10].equals("empty"))
                    game.charY -=10;
            }
            game.repaint();
        }
        else if((e.getKeyCode() == 68) || (e.getKeyCode() == 39)){ //D and Right
            if(!(game.charX == 1510)){
                game.charX += 10;
                if(!game.occupied[game.charX /10][game.charY / 10].equals("empty"))
                    game.charX -=10;
            }
            game.repaint();
        }
        else if(e.getKeyCode() == 90){ //Z Wall
            if(!(game.walls == 0)){
                if(game.wallX.size() == 0){ //No walls placed yet
                    game.occupied[game.charX /10][game.charY / 10] = "wall";
                    createWall();
                }
                else{
                    boolean filled = false;
                    for(int i = 0; i < game.wallX.size(); i++){
                        if(!checkOccupied(i)){
                            filled = true;
                            i = game.wallX.size();
                        }
                    }
                    if(!filled){
                        game.occupied[game.charX /10][game.charY / 10] = "wall";
                        createWall();
                    }
                }
            }
        }
        else if(e.getKeyCode() == 88){ //X Door
            if(!(game.doors == 0)){
                if(game.doorX.size() == 0){ //No doors placed yet
                    game.occupied[game.charX /10][game.charY / 10] = "door";
                    createDoor();
                }
                else{
                    boolean filled = false;
                    for(int i = 0; i < game.doorX.size(); i++){
                        if(!checkOccupied(i)){
                            filled = true;
                            i = game.doorX.size();
                        }
                    }
                    if(!filled){
                        game.occupied[game.charX /10][game.charY / 10] = "door";
                        createDoor();
                    }
                }
            }
        }
    }

    public boolean checkOccupied(int i){
        if((i >= game.doorX.size()) || (game.doorX.size() == 0)){ //i is out of bounds for doors
            if((game.wallX.get(i) == game.charX) && (game.wallY.get(i) == game.charY))
                return false;
            else
                return true;
        }
        else if((i >= game.wallX.size()) || (game.wallX.size() == 0)){ //i is out of bounds for walls
            if((game.doorX.get(i) == game.charX) && (game.doorY.get(i) == game.charY))
                return false;
            else
                return true;
        }
        else{ // i is not out of bounds for wall or door
            if((game.doorX.get(i) == game.charX) && (game.doorY.get(i) == game.charY))
                return false;
            else if((game.wallX.get(i) == game.charX) && (game.wallY.get(i) == game.charY))
                return false;
            else
                return true;
        }
    }

    public void createWall(){
        game.wallX.add(game.charX);
        game.wallY.add(game.charY);
        game.walls -= 1;
        game.stats.setText("   Health: " + game.health + "     Walls(Z): " + game.walls + "    Doors(X): " + game.doors + "    Day: " + game.days + "    Time: " + game.day);
        repaint();
    }

    public void createDoor(){
        game.doorX.add(game.charX);
        game.doorY.add(game.charY);
        game.doors -= 1;
        game.stats.setText("   Health: " + game.health + "     Walls(Z): " + game.walls + "    Doors(X): " + game.doors + "    Day: " + game.days + "    Time: " + game.day);
        repaint();
    }
    public void startTimer(){
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                game.repaint();
                game.goombaRepaint = true;
            }
        }, 0, 100);
    }
    public static void main(String[]  args){
        Run m = new Run();
        m.setVisible(true);
        m.setSize(1920, 1080);
        m.setTitle("My Title");
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}