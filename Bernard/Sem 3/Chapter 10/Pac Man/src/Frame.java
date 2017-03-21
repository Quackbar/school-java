/**
 * Created by Bernard on 11/12/2015.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JPanel implements ActionListener{

    String pan;

    JPanel homeScreen = new JPanel();
    JPanel creditsPanel = new JPanel();
    JPanel statsPanel = new JPanel();
    JPanel northPanel = new JPanel();

    Game g = new Game();

    Border emptyBorder = BorderFactory.createEmptyBorder();

    ImageIcon titleImg = new ImageIcon("Pac-Man-Title.png");
    ImageIcon startImg = new ImageIcon("Pac-Man-Start.png");
    ImageIcon aboutImg = new ImageIcon("Pac-Man-About.png");
    ImageIcon statsImg = new ImageIcon("Pac-Man-Stats.png");
    ImageIcon statsPgImg = new ImageIcon("Pacman-Stats-Page.png");
    ImageIcon backImg = new ImageIcon("BackArrow.png");

    JButton play = new JButton(startImg);
    JButton credits = new JButton(aboutImg);
    JButton stats = new JButton(statsImg);
    JButton back = new JButton(backImg);

    JLabel title = new JLabel(titleImg);
    JLabel statsPgL = new JLabel(statsPgImg);
    JLabel creditsL = new JLabel("<html><font face=\"Times New Roman\" size=\"32\"   color=#58FAF4>Product Manager</font> <br> <font face=\"Times New Roman\" size=\"32\"   color=white> Bernard Kintzing</font> <br><br> <font face=\"Times New Roman\" size=\"32\"   color=#FFFF00>Executive Producer</font> <br> <font face=\"Times New Roman\" size=\"32\"   color=white>Bernard Kintzing</font> <br><br> <font face=\"Times New Roman\" size=\"32\"   color=#FA58F4>Design</font> <br> <font face=\"Times New Roman\" size=\"32\"   color=white>Bernard Kintzing</font> <br><br> <font face=\"Times New Roman\" size=\"32\"   color=red>Code</font><br> <font face=\"Times New Roman\" size=\"32\"   color=white>Bernard Kintzing</font>");

    public Frame(){
        this.setLayout(new BorderLayout());
        this.add(homeScreen, BorderLayout.CENTER);
        homeScreen.setBackground(Color.BLACK);
        homeScreen.setLayout(null);
        homeScreen.add(title);
        title.setBounds(100, 23, 840, 292);
        homeScreen.add(play);
            play.setBounds(355, 355, 330, 36);
            play.setBorder(emptyBorder);
            play.addActionListener(this);
        homeScreen.add(credits);
            credits.setBounds(435, 431, 170, 36);
            credits.setBorder(emptyBorder);
            credits.addActionListener(this);
        homeScreen.add(stats);
            stats.setBounds(456, 507, 128, 36);
            stats.setBorder(emptyBorder);
            stats.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("In actionPerformed");
        if(e.getSource() == play){
            this.remove(homeScreen);
            this.add(g, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            g.playSound(g.intro);
        }
        else if(e.getSource() == credits){
            pan = "about";
            this.remove(homeScreen);
            this.add(creditsPanel, BorderLayout.CENTER);
            creditsPanel.setBackground(Color.BLACK);
            creditsPanel.setLayout(new GridLayout(0, 2));
            creditsPanel.add(creditsL);
            creditsL.setBackground(Color.BLACK);
            creditsPanel.add(statsPgL);
            this.add(northPanel, BorderLayout.NORTH);
            northPanel.setLayout(new GridLayout(0, 22));
            northPanel.setBackground(Color.BLACK);
            northPanel.add(back);
            back.setBorder(emptyBorder);
            back.setBackground(Color.BLACK);
            back.addActionListener(this);
            this.revalidate();
            this.repaint();
        }
        else if(e.getSource() == stats){
            pan = "stats";
            this.remove(homeScreen);
            this.add(statsPanel);
            statsPanel.setBackground(Color.BLACK);
            this.add(northPanel, BorderLayout.NORTH);
            northPanel.setLayout(new GridLayout(0, 22));
            northPanel.setBackground(Color.BLACK);
            northPanel.add(back);
            back.setBorder(emptyBorder);
            back.setBackground(Color.BLACK);
            back.addActionListener(this);
            this.revalidate();
            this.repaint();
        }
        else{
            if(pan.equals("about")){
                this.remove(creditsPanel);
                this.remove(northPanel);
                this.add(homeScreen);
                this.revalidate();
                this.repaint();
                pan = "null";
            }
            else{
                this.remove(statsPanel);
                this.add(homeScreen);
                this.remove(northPanel);
                this.repaint();
                this.revalidate();
                pan = "null";
            }
        }
    }
}


