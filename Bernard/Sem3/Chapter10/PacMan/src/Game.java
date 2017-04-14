/**
 * Created by Bernard on 11/22/2015.
 */
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Game extends JPanel implements KeyListener{

    File intro = new File("pacman_beginning.wav");
    File death = new File("pacman_death.wav");
    File chomp = new File("pacman_chomp.wav");

    Pac p;

    static Frame f2 = new Frame();

    Color color = new Color(0, 0, 0);

    Ghost[] ghostName = new Ghost[4];

    String Direction = "L";

    boolean rLeaveBox = false, pLeaveBox = false, bLeaveBox = false, oLeaveBox = false;
    boolean firstLeft = false;
    boolean firstRight = false;
    boolean firstDown = false;
    boolean firstUp = false;
    boolean OorC = false;
    boolean start = false;
    boolean gameOver = false;

    int timer = 0, key, tim = 0, dotCount = 0, speed = 1, gSpeed = 1, x, y;

    ImageIcon PacmanOpenRI;
    ImageIcon PacmanClosedRI;
    ImageIcon PacmanOpenLI;
    ImageIcon PacmanClosedLI;
    ImageIcon PacmanOpenUI;
    ImageIcon PacmanClosedUI;
    ImageIcon PacmanOpenDI;
    ImageIcon PacmanClosedDI;
    ImageIcon RedGhostI;
    ImageIcon PinkGhostI;
    ImageIcon BlueGhostI;
    ImageIcon OrangeGhostI;
    ImageIcon BlueGhostZI;
    ImageIcon WhiteGhostZI;

    BufferedImage image;

    public Game(){
        this.addKeyListener(this);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        try{
            File img = new File("BlueBoard.png");
            image = ImageIO.read(img);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        for(int i = 0; i < ghostName.length; i++){
            if(i == 0){
                RedGhostI = new ImageIcon("RedGhost.png");
                ghostName[i] = new Ghost(RedGhostI, "RED");
                this.add(ghostName[i]);
                ghostName[i].setBounds(500, 260, 30, 30);
            }
            else if(i == 1){
                PinkGhostI = new ImageIcon("PinkGhost.png");
                ghostName[i] = new Ghost(PinkGhostI, "PINK");
                this.add(ghostName[i]);
                ghostName[i].setBounds(500, 315, 30, 30);
            }
            else if(i == 2){
                BlueGhostI = new ImageIcon("BlueGhost.png");
                ghostName[i] = new Ghost(BlueGhostI, "BLUE");
                this.add(ghostName[i]);
                ghostName[i].setBounds(438, 315, 30, 30);
            }
            else if(i == 3){
                OrangeGhostI = new ImageIcon("OrangeGhost.png");
                ghostName[i] = new Ghost(OrangeGhostI, "ORANGE");
                this.add(ghostName[i]);
                ghostName[i].setBounds(562, 315, 30, 30);
            }
        }
        PacmanOpenRI = new ImageIcon("PacmanOpenR.png");
        PacmanClosedRI = new ImageIcon("PacmanClosedR.png");
        PacmanOpenLI = new ImageIcon("PacmanOpenL.png");
        PacmanClosedLI = new ImageIcon("PacmanClosedL.png");
        PacmanOpenUI = new ImageIcon("PacmanOpenU.png");
        PacmanClosedUI = new ImageIcon("PacmanClosedU.png");
        PacmanOpenDI = new ImageIcon("PacmanOpenD.png");
        PacmanClosedDI = new ImageIcon("PacmanClosedD.png");
        p = new Pac(PacmanClosedLI, "YELLOW");
        this.add(p);
        p.setBounds(497, 490, 30, 30);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void addNotify(){
        super.addNotify();
        requestFocus();
    }

    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(!gameOver){
                for(int i = 0; i < ghostName.length; i++){
                    moveGhost(ghostName[i], gSpeed);
                }
                pacMove(p);
                pacAnim();
            }
        }
    };

    public void keyPressed(KeyEvent e){
        key = e.getKeyCode();
        if(!start){
            Timer t = new Timer(7, al);
            t.start();
            start = true;
        }
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }

    public void pacAnim(){
        if(tim % 10 == 0){
            if(!OorC){
                if(Direction.equals("RIGHT")){
                    p.setIcon(PacmanOpenRI);
                    tim++;
                    OorC = true;
                }
                else if(Direction.equals("LEFT")){
                    p.setIcon(PacmanOpenLI);
                    tim++;
                    OorC = true;
                }
                else if(Direction.equals("UP")){
                    p.setIcon(PacmanOpenUI);
                    tim++;
                    OorC = true;
                }
                else{
                    p.setIcon(PacmanOpenDI);
                    tim++;
                    OorC = true;
                }
            }
            else{
                if(Direction.equals("RIGHT")){
                    p.setIcon(PacmanClosedRI);
                    tim++;
                    OorC = false;
                }
                else if(Direction.equals("LEFT")){
                    p.setIcon(PacmanClosedLI);
                    tim++;
                    OorC = false;
                }
                else if(Direction.equals("UP")){
                    p.setIcon(PacmanClosedUI);
                    tim++;
                    OorC = false;
                }
                else{
                    p.setIcon(PacmanClosedDI);
                    tim++;
                    OorC = false;
                }
            }
        }
        else{
            tim++;
        }
    }

    public void pacMove(Pac pac){
        Direction = "LEFT";
        x = p.getLocation().x;
        y = p.getLocation().y;
        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A){
            speed = 1;
            if(!firstLeft){
                firstLeft = true;
                firstRight = false;
                firstDown = false;
                firstUp = false;
                System.out.println("In KeyEvent.VK_LEFT");
            }
            Color color = new Color(image.getRGB(x, y + (p.getHeight() / 2)), true);
            int cloy = 0;
            for(int i = 1; i < pac.yCoord.length; i++){
                if(Math.abs(y + (p.getHeight() / 2) - pac.yCoord[i]) < Math.abs(y + (p.getHeight() / 2) - pac.yCoord[cloy])){
                    cloy = i;
                }
            }
            y = pac.yCoord[cloy];
            p.setLocation(x, y);
            if(color.equals(pac.wallColor)){
                //System.out.println("Hit Wall");
                speed = 0;
            }
            if(x == 36 && y < 350 && y > 314){
                p.setLocation(968, 318);
            }
            else{
                p.setLocation(x - speed, y);
            }
            if(color.equals(pac.dotColor)){
                for(int i = -8; i < 9; i++){
                    for(int j = -8; j < 9; j++){
                        image.setRGB(x + i, y + j + (p.getHeight() / 2), 0x000000);
                        this.revalidate();
                        this.repaint();
                    }
                }
                dotCount++;
                checkDot(dotCount);
            }
            //System.out.println(x + "|" + y);
            Direction = "LEFT";
        }

        if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
            speed = 1;
            if(!firstRight){
                System.out.println("In KeyEvent.VK_RIGHT");
                firstRight = true;
                firstLeft = false;
                firstUp = false;
                firstDown = false;
            }
            Color color = new Color(image.getRGB(x + p.getWidth(), y + (p.getHeight() / 2)), true);
            int cloy = 0;
            for(int i = 1; i < pac.yCoord.length; i++){
                if(Math.abs(y + (p.getHeight() / 2) - pac.yCoord[i]) < Math.abs(y + (p.getHeight() / 2) - pac.yCoord[cloy])){
                    cloy = i;
                }
            }
            y = pac.yCoord[cloy];
            p.setLocation(x, y);
            if(color.equals(pac.wallColor)){
                //System.out.println("Hit Wall");
                speed = 0;
            }
            if(x == 977 && y < 350 && y > 314){
                p.setLocation(57, 320);
            }
            else{
                p.setLocation(x + speed, y);
            }
            if(color.equals(pac.dotColor)){
                for(int i = -8; i < 9; i++){
                    for(int j = -8; j < 9; j++){
                        image.setRGB(x + i + p.getWidth(), y + j + (p.getHeight() / 2), 0x000000);
                        this.revalidate();
                        this.repaint();
                    }
                }
                dotCount++;
                checkDot(dotCount);
            }
            //System.out.println(x + "|" + y);
            Direction = "RIGHT";
        }

        if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W){
            speed = 1;
            if(!firstUp){
                System.out.println("In KeyEvent.VK_UP");
                firstUp = true;
                firstDown = false;
                firstLeft = false;
                firstRight = false;
            }
            int x;
            int y;
            x = p.getLocation().x;
            y = p.getLocation().y;
            Color color = new Color(image.getRGB(x + (p.getWidth() / 2), y), true);
            int cloy = 0;
            for(int i = 1; i < pac.xCoord.length; i++){
                if(Math.abs(x + (p.getWidth() / 2) - pac.xCoord[i]) < Math.abs(x + (p.getWidth() / 2) - pac.xCoord[cloy])){
                    cloy = i;
                }
            }
            x = pac.xCoord[cloy];
            p.setLocation(x, y);
            if(color.equals(pac.wallColor)){
                //System.out.println("Hit Wall");
                speed = 0;
            }
            else{
                p.setLocation(x, y - speed);
                //System.out.println(x + "|" + y);
                Direction = "UP";
            }
            if(color.equals(pac.dotColor)){
                for(int i = -8; i < 9; i++){
                    for(int j = -8; j < 9; j++){
                        image.setRGB(x + i + (p.getWidth() / 2), y + j, 0x000000);
                        this.revalidate();
                        this.repaint();
                    }
                }
                dotCount++;
                checkDot(dotCount);
            }
        }

        if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S){
            speed = 1;
            if(!firstDown){
                System.out.println("In KeyEvent.VK_DOWN");
                firstDown = true;
                firstUp = false;
                firstLeft = false;
                firstRight = false;
            }
            int x;
            int y;
            x = p.getLocation().x;
            y = p.getLocation().y;
            Color color = new Color(image.getRGB(x + (p.getWidth() / 2), y + p.getHeight()), true);
            int cloy = 0;
            for(int i = 1; i < pac.xCoord.length; i++){
                if(Math.abs(x + (p.getWidth() / 2) - pac.xCoord[i]) < Math.abs(x + (p.getWidth() / 2) - pac.xCoord[cloy])){
                    cloy = i;
                }
            }
            x = pac.xCoord[cloy];
            p.setLocation(x, y);
            if(color.equals(pac.wallColor)){
                //System.out.println("Hit Wall");
                speed = 0;
            }
            else{
                p.setLocation(x, y + speed);
                //System.out.println(x + "|" + y);
                Direction = "DOWN";
            }
            if(color.equals(pac.dotColor)){
                for(int i = -8; i < 9; i++){
                    for(int j = -8; j < 9; j++){
                        image.setRGB(x + i + (p.getWidth() / 2), y + j + p.getHeight(), 0x000000);
                        this.revalidate();
                        this.repaint();
                    }
                }
                dotCount++;
                checkDot(dotCount);
            }
        }
        checkCollision();
    }

    public void checkCollision(){
        boolean check = false;

        for(int i = 0; i < ghostName.length; i++){
            if(Direction.equals("RIGHT") || Direction.equals("LEFT")){
                int X = p.getLocation().x + p.getHeight() / 2;
                int x = ghostName[i].getLocation().x + ghostName[i].getWidth() / 2;
                int Y = p.getLocation().y;
                int y = ghostName[i].getLocation().y;
                if(Math.abs(X - x) <= 30 && Y == y){
                    check = true;
                }
            }
            else{
                int Y = p.getLocation().y + p.getWidth() / 2;
                int y = ghostName[i].getLocation().y + ghostName[i].getWidth() / 2;
                int X = p.getLocation().x;
                int x = ghostName[i].getLocation().x;
                if(Math.abs(Y - y) <= 30 && X == x){
                    check = true;
                }
            }
        }
        if(check){
            playSound(death);
            System.exit(0);
        }
    }

    public void checkDot(int dCount){
        if(dCount == 152){
            speed = 0;
            gameOver = true;
            JOptionPane.showMessageDialog(null, "You Won");
            System.exit(0);
        }
    }

    private void moveGhost(Ghost ghost, int ghostSpeed){

        int X = ghost.getLocation().x;
        int Y = ghost.getLocation().y;
        timer++;
        //Set the beginning movement
        if(ghost.getColor().equals("RED") && !rLeaveBox){
            String res = ghost.coinFlip();
            if(res.equals("HEADS")){
                ghost.setDirection("RIGHT");
            }
            else{
                ghost.setDirection("LEFT");
            }
            rLeaveBox = true;
        }
        else if(ghost.getColor().equals("PINK") && !pLeaveBox){
            if(timer >= 300){
                ghostSpeed = gSpeed;
            }
            else{
                ghostSpeed = 0;
                return;
            }
            if(ghostSpeed == gSpeed){
                ghost.setLocation(X, Y - gSpeed);
                if(Y == 260){
                    pLeaveBox = true;
                    String res = ghost.coinFlip();
                    if(res.equals("HEADS")){
                        ghost.setDirection("RIGHT");
                    }
                    else{
                        ghost.setDirection("LEFT");
                    }
                }
            }
        }
        else if(ghost.getColor().equals("BLUE") && !bLeaveBox){
            if(timer >= 600){
                ghostSpeed = gSpeed;
            }
            else{
                ghostSpeed = 0;
                return;
            }
            if(!bLeaveBox && ghostSpeed == gSpeed){
                int x = ghost.getLocation().x;// + ghost.getWidth();
                int y = ghost.getLocation().y;// + ghost.getHeight()/2;
                ghost.setLocation(x + ghostSpeed, y);
                if(x == 500){
                    if(ghostSpeed == gSpeed){
                        ghost.setLocation(X, Y - gSpeed);
                        if(Y == 260){
                            bLeaveBox = true;
                            String res = ghost.coinFlip();
                            if(res.equals("HEADS")){
                                ghost.setDirection("RIGHT");
                            }
                            else{
                                ghost.setDirection("LEFT");
                            }
                        }
                    }
                }
            }
        }
        else if(ghost.getColor().equals("ORANGE") && !oLeaveBox){
            if(timer >= 900){
                ghostSpeed = gSpeed;
            }
            else{
                ghostSpeed = 0;
                return;
            }
            if(!oLeaveBox && ghostSpeed == gSpeed){
                int x = ghost.getLocation().x;
                int y = ghost.getLocation().y;// + ghost.HEIGHT/2;
                ghost.setLocation(x - ghostSpeed, y);
                if(x == 500){
                    if(ghostSpeed == gSpeed){
                        ghost.setLocation(X, Y - gSpeed);
                        if(Y == 260){
                            oLeaveBox = true;
                            String res = ghost.coinFlip();
                            if(res.equals("HEADS")){
                                ghost.setDirection("RIGHT");
                            }
                            else{
                                ghost.setDirection("LEFT");
                            }
                        }
                    }
                }
            }
        }
        if(ghost.getDirection().equals("RIGHT")){
            color = new Color(image.getRGB(X + ghost.getWidth() + gSpeed, Y + (ghost.getHeight() / 2)), true);
        }
        else if(ghost.getDirection().equals("LEFT")){
            color = new Color(image.getRGB(X - gSpeed, Y + (ghost.getHeight() / 2)), true);
        }
        else if(ghost.getDirection().equals("UP")){
            color = new Color(image.getRGB(X + (ghost.getWidth() / 2), Y - gSpeed), true);
        }
        else{
            color = new Color(image.getRGB(X + (ghost.getWidth() / 2), Y + gSpeed + ghost.getHeight()), true);
        }
        if(color.equals(ghost.wallColor)){
            if(ghost.getDirection().equals("RIGHT") || ghost.getDirection().equals("LEFT")){
                Color c1 = new Color(image.getRGB(X + (ghost.getWidth() / 2), Y), true); //Up
                Color c2 = new Color(image.getRGB(X + (ghost.getWidth() / 2), Y + ghost.getHeight()), true); //Down
                if(c1.equals(ghost.wallColor)){
                    ghost.setDirection("DOWN");
                }
                else if(c2.equals(ghost.wallColor)){
                    ghost.setDirection("UP");
                }
                else{
                    Random rand = new Random();
                    int randomNum = rand.nextInt(6 - 1) + 1;
                    System.out.println(randomNum);
                    if(randomNum == 1 || randomNum == 2){
                        ghost.setDirection("UP");
                    }
                    else if(randomNum == 3 || randomNum == 4){
                        ghost.setDirection("DOWN");
                    }
                    else{
                        if(ghost.getDirection().equals("RIGHT")){
                            ghost.setDirection("LEFT");
                        }
                        else{
                            ghost.setDirection("RIGHT");
                        }
                    }
                }
            }
            else{
                Color c1 = new Color(image.getRGB(X + ghost.getWidth(), Y + (ghost.getHeight() / 2)), true); //Right
                Color c2 = new Color(image.getRGB(X, Y + (ghost.getHeight() / 2)), true); //Left
                if(c1.equals(ghost.wallColor)){
                    ghost.setDirection("LEFT");
                }
                else if(c2.equals(ghost.wallColor)){
                    ghost.setDirection("RIGHT");
                }
                else{
                    Random rand = new Random();
                    int randomNum = rand.nextInt(6 - 1) + 1;
                    System.out.println(randomNum);
                    if(randomNum == 1 || randomNum == 2){
                        ghost.setDirection("RIGHT");
                    }
                    else if(randomNum == 3 || randomNum == 4){
                        ghost.setDirection("LEFT");
                    }
                    else{
                        if(ghost.getDirection().equals("UP")){
                            ghost.setDirection("DOWN");
                        }
                        else{
                            ghost.setDirection("UP");
                        }
                    }
                }
            }

        }

        if(ghost.getDirection().equals("LEFT")){
            int x = ghost.getLocation().x;
            int y = ghost.getLocation().y;// + ghost.getHeight()/2;
            int cloy = 0;
            for(int i = 1; i < ghost.yCoord.length; i++){
                if(Math.abs(y + (ghost.getHeight() / 2) - ghost.yCoord[i]) < Math.abs(y + (ghost.getHeight() / 2) - ghost.yCoord[cloy])){
                    cloy = i;
                }
            }
            y = ghost.yCoord[cloy];
            if(!checkEligablitlity(ghost)){
            }
            else{
                if(x == 36 && y < 350 && y > 314){ // Portal moving left
                    ghost.setLocation(968, 318);
                }
                else{
                    ghost.setLocation(x - ghostSpeed, y);
                }
                changeDirection(ghost);
            }
        }
        else if(ghost.getDirection().equals("RIGHT")){
            int x = ghost.getLocation().x;// + ghost.getWidth();
            int y = ghost.getLocation().y;// + ghost.getHeight()/2;
            int cloy = 0;
            for(int i = 1; i < ghost.yCoord.length; i++){
                if(Math.abs(y + (ghost.getHeight() / 2) - ghost.yCoord[i]) < Math.abs(y + (ghost.getHeight() / 2) - ghost.yCoord[cloy])){
                    cloy = i;
                }
            }
            y = ghost.yCoord[cloy];
            if(!checkEligablitlity(ghost)){
            }
            else{
                if(x == 977 && y < 350 && y > 314){
                    ghost.setLocation(57, 320);
                }
                else{
                    ghost.setLocation(x + ghostSpeed, y);
                }
                changeDirection(ghost);
            }
        }
        else if(ghost.getDirection().equals("UP")){
            int x = ghost.getLocation().x;// + ghost.getWidth()/2;
            int y = ghost.getLocation().y;
            int clox = 0;
            for(int i = 1; i < ghost.xCoord.length; i++){
                if(Math.abs(x + (ghost.getWidth() / 2) - ghost.xCoord[i]) < Math.abs(x + (ghost.getWidth() / 2) - ghost.xCoord[clox])){
                    clox = i;
                }
            }
            x = ghost.xCoord[clox];
            if(!checkEligablitlity(ghost)){
            }
            else{
                ghost.setLocation(x, y - ghostSpeed);
                changeDirection(ghost);
            }
        }
        else if(ghost.getDirection().equals("DOWN")){
            int x = ghost.getLocation().x;// + ghost.getWidth()/2;
            int y = ghost.getLocation().y;//+ ghost.getHeight();
            int clox = 0;
            for(int i = 1; i < ghost.xCoord.length; i++){
                if(Math.abs(x + (ghost.getWidth() / 2) - ghost.xCoord[i]) < Math.abs(x + (ghost.getWidth() / 2) - ghost.xCoord[clox])){
                    clox = i;
                }
            }
            x = ghost.xCoord[clox];
            if(!checkEligablitlity(ghost)){
            }
            else{
                ghost.setLocation(x, y + ghostSpeed);
                changeDirection(ghost);
            }
        }
    }

    public void changeDirection(Ghost ghost){
        if(ghost.getDirection().equals("RIGHT") || ghost.getDirection().equals("LEFT")){
            int x, y;
            if(ghost.getDirection().equals("RIGHT")){
                x = ghost.getLocation().x + ghost.getWidth();
                y = ghost.getLocation().y + ghost.getHeight() / 2;
            }
            else{
                x = ghost.getLocation().x;
                y = ghost.getLocation().y + ghost.getHeight() / 2;
            }
            for(int j = 0; j < ghost.xCoord.length; j++){
                if(x == ghost.xCoord[j]){
                    String res = ghost.coinFlip();
                    if(res.equals("HEADS")){
                        if(checkX(x, y, ghost)){
                            String res2 = ghost.coinFlip();
                            if(res2.equals("HEADS")){
                                Direction = "UP";
                            }
                            else{
                                Direction = "DOWN";
                            }
                        }
                    }
                }
            }
        }
        else{
            int x, y;
            if(ghost.getDirection().equals("UP")){
                x = ghost.getLocation().x + ghost.getWidth() / 2;
                y = ghost.getLocation().y;
            }
            else{
                x = ghost.getLocation().x + ghost.getWidth() / 2;
                y = ghost.getLocation().y + ghost.getHeight();
            }
            for(int j = 0; j < ghost.yCoord.length; j++){
                if(y == ghost.yCoord[j]){
                    String res = ghost.coinFlip();
                    if(res.equals("HEADS")){
                        if(checkY(x, y, ghost)){
                            String res2 = ghost.coinFlip();
                            if(res2.equals("HEADS")){
                                ghost.setDirection("RIGHT");
                            }
                            else{
                                ghost.setDirection("LEFT");
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkY(int X, int Y, Ghost ghost){
        int x = X;
        int y = Y;
        boolean check = true;
        if(x == 85 && y == 318){
            check = false;
        }
        else if(x == 138 && (y != 494 || y != 553)){
            check = false;
        }
        else if(x == 240 && y == 614){
            check = false;
        }
        else if(x == 344 && (y != 142 || y != 260 || y != 494 || y != 553)){
            check = false;
        }
        else if(x == 450 && y == 318){
            check = false;
        }
        else if(x == 553 && y == 318){
            check = false;
        }
        else if(x == 650 && (y != 142 || y != 260 || y != 494 || y != 553)){
            check = false;
        }
        else if(x == 761 && y == 614){
            check = false;
        }
        else if(x == 864 && (y != 494 || y != 553)){
            check = false;
        }
        else if(x == 918 && y == 318){
            check = false;
        }

        if(x == 85 && y == 51){
            ghost.setDirection("DOWN");
        }
        if(x == 85 && y == 200){
            ghost.setDirection("UP");
        }
        else if(x == 85 && y == 434){
            ghost.setDirection("DOWN");
        }
        else if(x == 85 && y == 494){
            ghost.setDirection("UP");
        }
        else if(x == 85 && y == 553){
            ghost.setDirection("DOWN");
        }
        else if(x == 85 && y == 614){
            ghost.setDirection("UP");
        }
        return check;
    }

    public boolean checkX(int X, int Y, Ghost ghost){
        int x = X;
        int y = Y;
        boolean check = true;
        if(y == 51 && (x == 138 || x == 344 || x == 650 || x == 864)){
            check = false;
        }
        else if(y == 142 && (x == 138 || x == 864)){
            check = false;
        }
        else if(y == 200 && (x == 138 || x == 864)){
            check = false;
        }
        else if(y == 260 && (x == 340 || x == 450 || x == 553 || x == 656)){
            check = false;
        }
        else if(y == 318 && (x == 240 || x == 344 || x == 650 || x == 761)){
            check = false;
        }
        else if(y == 329 && (x == 344 || x == 650)){
            check = false;
        }
        else if(y == 434 && (x != 138 || x != 344 || x != 650 || x != 864)){
            check = false;
        }
        else if(y == 553 && (x == 138 || x == 450 || x == 553 || x == 864)){
            check = false;
        }
        else if(y == 614 && (x == 138 || x == 344 || x == 650 || x == 864)){
            check = false;
        }


        return check;
    }

    public boolean checkEligablitlity(Ghost ghost){
        boolean check = true;
        if(ghost.getColor().equals("RED") && !rLeaveBox){
            check = false;
        }
        else if(ghost.getColor().equals("PINK") && !pLeaveBox){
            check = false;
        }
        else if(ghost.getColor().equals("BLUE") && !bLeaveBox){
            check = false;
        }
        else if(ghost.getColor().equals("ORANGE") && !oLeaveBox){
            check = false;
        }
        return check;
    }

    static void playSound(File Sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
        }
        catch(Exception ex){
            System.out.println("Failure to play the melody");
        }
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(f2);
        f.setBounds(10, 10, 1040, 723);
        f.setResizable(false);
        f.setVisible(true);
        f.setTitle("Pac-Man");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}