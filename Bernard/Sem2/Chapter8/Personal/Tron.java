import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.image.*;

public class Tron extends JFrame implements KeyListener, Runnable
{

    static int width, height;
    public int redV = 300;
    public int redH = 500;
    public int purpV = 300;
    public int purpH = 500;

    static Boolean up1 = false;
    static Boolean down1 = false;
    static Boolean left1 = false;
    static Boolean right1 = false;
    static Boolean up2 = false;
    static Boolean down2 = false;
    static Boolean left2 = false;
    static Boolean right2 = false;

    String pKey = " ";

    static Tron t;

    static Thread t1;

    PaintPanel body = new PaintPanel(redH, redV);

    public Tron()
    {
        add(body);
        body.setLayout(null);
        this.addKeyListener(this);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int)screenSize.getWidth();
        height = (int)screenSize.getHeight();
        PaintPanel.hStart.add(500);
        PaintPanel.vStart.add(300);
    }

    public void paintComponents(Graphics g)
    {
        super.paintComponents(g);
        System.out.println("IN");
        g.drawLine(redH, redV, redH , redV);
    }

    public void keyPressed(KeyEvent e)
    {
        up1 = false;
        down1 = false;
        left1 = false;
        right1 = false;
        up2 = false;
        down2 = false;
        left2 = false;
        right2 = false;
        t1 = new Thread(this);
        int keyCode = e.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_UP:
                // handle up
                pKey = "Up1";
                up1 = true;
                t1.start();
                System.out.println("Up Arrow");
                break;
            case KeyEvent.VK_DOWN:
                // handle down
                pKey = "Down1";
                down1 = true;
                t1.start();
                System.out.println("Down Arrow");
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                pKey = "Left1";
                left1 = true;
                t1.start();
                System.out.println("Left Arrow");
                break;
            case KeyEvent.VK_RIGHT:
                // handle right
                pKey = "Right1";
                right1 = true;
                t1.start();
                System.out.println("Right Arrow");
                break;
            case KeyEvent.VK_W:
                // handle up
                pKey = "Up2";
                up2 = true;
                t1.start();
                System.out.println("Up W");
                break;
            case KeyEvent.VK_S:
                // handle down
                pKey = "Down2";
                down2 = true;
                t1.start();
                System.out.println("Down S");
                break;
            case KeyEvent.VK_A:
                // handle left
                pKey = "Left2";
                left2 = true;
                t1.start();
                System.out.println("Left A");
                break;
            case KeyEvent.VK_D:
                // handle right
                pKey = "Right2";
                right2 = true;
                t1.start();
                System.out.println("Right D");
                break;
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}


    public void run()
    {
        if(pKey == "Up1")
        {
            PaintPanel.hEnd.add(redH);
            PaintPanel.vEnd.add(redV);
            PaintPanel.hStart.add(redH);
            PaintPanel.vStart.add(redV);
            PaintPanel.initialRedV = redV;
            PaintPanel.initialRedH = redH;
            while(up1)
            {
                redV -= 1;
                PaintPanel.redV = redV;
                if(redV == 0)
                {
                    uSuck();
                }
                System.out.println(redV);
                repaint();
                pauseThread(10);
            }
        }
        else if(pKey == "Down1")
        {
            PaintPanel.hEnd.add(redH);
            PaintPanel.vEnd.add(redV);
            PaintPanel.hStart.add(redH);
            PaintPanel.vStart.add(redV);
            PaintPanel.initialRedV = redV;
            PaintPanel.initialRedH = redH;
            while(down1)
            {
                redV += 1;
                PaintPanel.redV = redV;
                PaintPanel.checkH.add(redH);
                PaintPanel.checkV.add(redV);
                if(redV == height-50)
                {
                    uSuck();
                }
                System.out.println(redV);
                repaint();
                pauseThread(10);
            }
        }
        else if(pKey == "Left1")
        {
            PaintPanel.hEnd.add(redH);
            PaintPanel.vEnd.add(redV);
            PaintPanel.hStart.add(redH);
            PaintPanel.vStart.add(redV);
            PaintPanel.initialRedV = redV;
            PaintPanel.initialRedH = redH;
            while(left1)
            {
                redH -= 1;
                PaintPanel.redH = redH;
                PaintPanel.checkH.add(redH);
                PaintPanel.checkV.add(redV);
                if(redH == 0)
                {
                    uSuck();
                }
                System.out.println(redH);
                repaint();
                pauseThread(10);
            }
        }
        else if(pKey == "Right1")
        {
            PaintPanel.hEnd.add(redH);
            PaintPanel.vEnd.add(redV);
            PaintPanel.hStart.add(redH);
            PaintPanel.vStart.add(redV);
            PaintPanel.initialRedV = redV;
            PaintPanel.initialRedH = redH;
            while(right1)
            {
                redH += 1;
                PaintPanel.redH = redH;
                PaintPanel.checkH.add(redH);
                PaintPanel.checkV.add(redV);
                if(redH == width - 15)
                {
                    uSuck();
                }
                System.out.println(redV);
                repaint();
                pauseThread(10);
            }
        }
        else if(pKey == "Up2")
        {
            while(up2)
            {
                purpV -= 1;
                System.out.println(purpV);
                pauseThread(10);
            }
        }
        else if(pKey == "Down2")
        {
            while(down2)
            {
                purpV += 1;
                System.out.println(purpV);
                pauseThread(10);
            }
        }
        else if(pKey == "Left2")
        {
            while(left2)
            {
                purpH -= 1;
                System.out.println(purpV);
                pauseThread(10);
            }
        }
        else if(pKey == "Right2")
        {
            while(right2)
            {
                purpH += 1;
                System.out.println(purpV);
                pauseThread(10);
            }
        }
    }

    public static void uSuck()
    {
        JOptionPane.showMessageDialog(null, "You lost...");
        up1 = false;
        down1 = false;
        left1 = false;
        right1 = false;
        up2 = false;
        down2 = false;
        left2 = false;
        right2 = false;
    }

    public void pauseThread(int millisec)
    {
        try
        {
            t1.sleep(millisec);
        }
        catch(InterruptedException e){System.out.println("I am stuck in a sleep");}
    }

    public static void main(String[] args)
    {
        t = new Tron();
        t.setVisible(true);
        t.setBounds(0,0,width,height - 35);
        t1 = new Thread(t);
        t1.start();
    }
}