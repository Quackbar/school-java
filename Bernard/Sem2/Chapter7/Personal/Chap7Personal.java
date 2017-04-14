import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.net.URL;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Chap7Personal extends JFrame implements ActionListener, Runnable
{
    Color oneColor = new Color(14,29,126);
    Color twoColor = new Color(126,29,14);
    Color plain = new Color(255,255,255);
    int one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen,twenty;
    int place1 = 66;
    int place2 = 69 ;
    int level = 1;
    int oneBomb, twoBomb;
    int p1Win, p2Win;
    boolean bombo1 = false;
    boolean bombo2 = false;
    boolean turn = true;
    int p1Counter, p2Counter;
	static Thread t1;
	//static Thread t2;

	BufferedImage buttonImage;
	ImageIcon buttonImg;

    JButton[] field = new JButton[64];
    JButton start1 = new JButton();
    JButton start2 = new JButton();
    JButton bombButton = new JButton("Set your Personal Bomb!");
    Label[] infoLabel = new Label[6];

    Panel frame = new Panel();
    Panel startPanel = new Panel();
    Panel topPanel = new Panel();

    MenuItem restart = new MenuItem("Restart");
    MenuItem easy = new MenuItem("Easy");
    MenuItem medium = new MenuItem("Medium");
    MenuItem hard = new MenuItem("Hard");
    MenuItem extreme = new MenuItem("Extreme");
    MenuItem about = new MenuItem("About");
    MenuItem instructionsRules = new MenuItem("Rules");
    MenuItem instructionsRan = new MenuItem("Purposes");

    public Chap7Personal()
    {
        MenuBar mnuBar = new MenuBar();
        this.setMenuBar(mnuBar);

        Menu fileMenu = new Menu("File");
        mnuBar.add(fileMenu);
        fileMenu.add(restart);
        restart.addActionListener(this);
        Menu levelMenu = new Menu("Difficulty");
        fileMenu.add(levelMenu);
        levelMenu.add(easy);
        easy.addActionListener(this);
        levelMenu.add(medium);
        medium.addActionListener(this);
        levelMenu.add(hard);
        hard.addActionListener(this);
        levelMenu.add(extreme);
        extreme.addActionListener(this);

        Menu helpMenu = new Menu("Help");
        mnuBar.add(helpMenu);
        Menu instructions = new Menu("Instructions");
        helpMenu.add(instructions);
        instructions.add(instructionsRules);
        instructionsRules.addActionListener(this);
        instructions.add(instructionsRan);
        instructionsRan.addActionListener(this);
        helpMenu.add(about);
        about.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);
        add(topPanel, BorderLayout.NORTH);
        topPanel.add(bombButton);
        bombButton.addActionListener(this);
        add(frame, BorderLayout.CENTER);
        frame.setBackground(Color.GRAY);
        frame.setLayout(new GridLayout(8,8));
        for(int i = 0; i<field.length; i++)
        {
            field[i] = new JButton();
            frame.add(field[i]);
            field[i].setBackground(plain);
            field[i].setLabel(String.valueOf(i));
            field[i].addActionListener(this);
        }
        add(startPanel, BorderLayout.SOUTH);
        startPanel.setLayout(new GridLayout(0, 8));
        for(int i = 0; i<infoLabel.length; i++)
        {
            infoLabel[i] = new Label();
        }
        startPanel.add(infoLabel[0]);
        infoLabel[0].setText("PLAYER 1");
        startPanel.add(infoLabel[1]);
        startPanel.add(start1);
        start1.setBackground(twoColor);
        start1.setOpaque(true);
        startPanel.add(infoLabel[2]);
        infoLabel[2].setText(String.valueOf(p1Win));
        //infoLabel[2].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startPanel.add(infoLabel[3]);
        infoLabel[3].setText(String.valueOf(p2Win));
        startPanel.add(start2);
        start2.setBackground(oneColor);
        start2.setOpaque(true);
        startPanel.add(infoLabel[4]);
        startPanel.add(infoLabel[5]);
        infoLabel[5].setText("PLAYER 2");
        bombFinder();
    }

    private void bombFinder()
    {
        one = 0 + (int)(Math.random() * ((55 - 0) + 1));
        two = 0 + (int)(Math.random() * ((55 - 0) + 1));
        three = 0 + (int)(Math.random() * ((55 - 0) + 1));
        four = 0 + (int)(Math.random() * ((55 - 0) + 1));
        five = 0 + (int)(Math.random() * ((55 - 0) + 1));
        six = 0 + (int)(Math.random() * ((55 - 0) + 1));
        seven = 0 + (int)(Math.random() * ((55 - 0) + 1));
        eight = 0 + (int)(Math.random() * ((55 - 0) + 1));
        nine = 0 + (int)(Math.random() * ((55 - 0) + 1));
        ten = 0 + (int)(Math.random() * ((55 - 0) + 1));
        eleven = 0 + (int)(Math.random() * ((55 - 0) + 1));
        twelve = 0 + (int)(Math.random() * ((55 - 0) + 1));
        thirteen = 0 + (int)(Math.random() * ((55 - 0) + 1));
        fourteen = 0 + (int)(Math.random() * ((55 - 0) + 1));
        fifteen = 0 + (int)(Math.random() * ((55 - 0) + 1));
        sixteen = 0 + (int)(Math.random() * ((55 - 0) + 1));
        seventeen = 0 + (int)(Math.random() * ((55 - 0) + 1));
        eighteen = 0 + (int)(Math.random() * ((55 - 0) + 1));
        nineteen = 0 + (int)(Math.random() * ((55 - 0) + 1));
        twenty = 0 + (int)(Math.random() * ((55 - 0) + 1));
    }

    private void playSound()
    {
        try
        {
            URL url = this.getClass().getClassLoader().getResource("bomb.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        }
        catch (Exception e) {}
    }

    private boolean checkValid(int i)
    {
        boolean moveValid = false;
        if(turn)
        {
            if (i == 0)
            {
                if (i + 1 == place1 || i + 8 == place1 || i + 9 == place1)
                {
                    moveValid = true;
                }
            }
            else if (i == 8 || i == 16 || i == 24 || i == 32 || i == 40 || i == 48)
            {
                if (i - 8 == place1 || i - 7 == place1 || i + 1 == place1 || i + 8 == place1 || i + 9 == place1)
                {
                    moveValid = true;
                }
            }
            else if (i == 56)
            {
                if (i - 8 == place1 || i - 7 == place1 || i + 1 == place1)
                {
                    moveValid = true;
                }
            }
            else if (i == 7)
            {
                if (i - 1 == place1 || i + 8 == place1 || i + 7 == place1)
                {
                    moveValid = true;
                }
            }
            else if (i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55)
            {
                if (i - 8 == place1 || i - 9 == place1 || i - 1 == place1 || i + 8 == place1 || i + 7 == place1)
                {
                    moveValid = true;
                }
            }
            else if (i == 63)
            {
                if (i - 8 == place1 || i - 7 == place1 || i - 1 == place1)
                {
                    moveValid = true;
                }
            }
            else
            {
                if (i - 8 == place1 || i - 9 == place1 || i - 7 == place1|| i - 1 == place1 || i + 8 == place1 || i + 9 == place1 || i + 7 == place1 || i + 1 == place1)
                {
                    moveValid = true;
                }
            }
            if(i == place2)
            {
                moveValid = false;
            }
        }
        else
        {
            if (i == 0)
            {
                if (i + 1 == place2 || i + 8 == place2 || i + 9 == place2)
                {
                    moveValid = true;
                }
            }
            else if (i == 8 || i == 16 || i == 24 || i == 32 || i == 40 || i == 48)
            {
                if (i - 8 == place2 || i - 7 == place2 || i + 1 == place2 || i + 8 == place2 || i + 9 == place2)
                {
                    moveValid = true;
                }
            }
            else if (i == 56)
            {
                if (i - 8 == place2 || i - 7 == place2 || i + 1 == place2)
                {
                    moveValid = true;
                }
            }
            else if (i == 7)
            {
                if (i - 1 == place2 || i + 8 == place2 || i + 7 == place2)
                {
                    moveValid = true;
                }
            }
            else if (i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55)
            {
                if (i - 8 == place2 || i - 9 == place2 || i - 1 == place2 || i + 8 == place2 || i + 7 == place2)
                {
                    moveValid = true;
                }
            }
            else if (i == 63)
            {
                if (i - 8 == place2 || i - 7 == place2 || i - 1 == place2)
                {
                    moveValid = true;
                }
            }
            else
            {
                if (i - 8 == place2 || i - 9 == place2 || i - 7 == place2 || i - 1 == place2 || i + 8 == place2 || i + 9 == place2 || i + 7 == place2 || i + 1 == place2)
                {
                    moveValid = true;
                }
            }
            if(i == place1)
            {
                moveValid = false;
            }
        }
        return moveValid;
    }

    private void run(int i)
    {
		Boolean foo = false;
		try
		{
			  buttonImage = ImageIO.read(new File("explosion.png"));
			  buttonImg = new ImageIcon(buttonImage);
			  field[i].setIcon(buttonImg);
			  foo = true;
		}
		catch(IOException ex){}
		try
		{
			Thread.sleep(300);
		}
		catch(InterruptedException e){}
		if(foo)
		{
			field[i].setIcon(null);
		}
	}

    private boolean checkBomb(int i)
    {
        boolean bombValid = true;
        if (level == 1)
        {
            if (i == one || i == two || i == three || i == four || i == five || i == oneBomb || i == twoBomb)
            {
				//t2 = new Thread(this);
            	//t2.start(i);
                bombValid = false;
            }
        }
        else if (level == 2)
        {
            if (i == one || i == two || i == three || i == four || i == five || i == six || i == seven || i == eight || i == nine || i == ten || i == oneBomb || i == twoBomb)
            {
				//t2 = new Thread(this);
            	//t2.start(i);
                bombValid = false;
            }
        }
        else if (level == 3)
        {
            if (i == one || i == two || i == three || i == four || i == five || i == six || i == seven || i == eight || i == nine || i == ten || i == eleven || i == twelve || i == thirteen || i == fourteen || i == fifteen || i == oneBomb || i == twoBomb)
            {
				//t2 = new Thread(this);
            	//t2.start(i);
               	bombValid = false;
            }
        }
        else
        {
			if (i == one || i == two || i == three || i == four || i == five || i == six || i == seven || i == eight || i == nine || i == ten || i == eleven || i == twelve || i == thirteen || i == fourteen || i == fifteen || i == sixteen || i == seventeen || i == eighteen || i == nineteen || i == twenty || i == oneBomb || i == twoBomb)
			{
				//t2 = new Thread(this);
            	//t2.start(i);
				bombValid = false;
			}
		}
        return bombValid;
    }

    public void run()
	{
		boolean foo = false;
			if(level == 1)
			{
				for(int i = 0; i< field.length; i ++)
				{
					field[i].setLabel("");
				}
				field[one].setBackground(Color.red);
				field[two].setBackground(Color.red);
				field[three].setBackground(Color.red);
				field[four].setBackground(Color.red);
				field[five].setBackground(Color.red);
				field[oneBomb].setBackground(Color.red);
				field[twoBomb].setBackground(Color.red);
				foo = true;
			}
			else if(level == 2)
			{
				for(int i = 0; i< field.length; i ++)
				{
					field[i].setLabel("");
				}
				field[one].setBackground(Color.red);
				field[two].setBackground(Color.red);
				field[three].setBackground(Color.red);
				field[four].setBackground(Color.red);
				field[five].setBackground(Color.red);
				field[six].setBackground(Color.red);
				field[seven].setBackground(Color.red);
				field[eight].setBackground(Color.red);
				field[nine].setBackground(Color.red);
				field[ten].setBackground(Color.red);
				field[oneBomb].setBackground(Color.red);
				field[twoBomb].setBackground(Color.red);
				foo = true;
			}
			else if(level == 3)
			{
				for(int i = 0; i< field.length; i ++)
				{
					field[i].setLabel("");
				}
				field[one].setBackground(Color.red);
				field[two].setBackground(Color.red);
				field[three].setBackground(Color.red);
				field[four].setBackground(Color.red);
				field[five].setBackground(Color.red);
				field[six].setBackground(Color.red);
				field[seven].setBackground(Color.red);
				field[eight].setBackground(Color.red);
				field[nine].setBackground(Color.red);
				field[ten].setBackground(Color.red);
				field[eleven].setBackground(Color.red);
				field[twelve].setBackground(Color.red);
				field[thirteen].setBackground(Color.red);
				field[fourteen].setBackground(Color.red);
				field[fifteen].setBackground(Color.red);
				field[oneBomb].setBackground(Color.red);
				field[twoBomb].setBackground(Color.red);
				foo = true;
			}
			else if(level == 4)
			{
				for(int i = 0; i< field.length; i ++)
				{
					field[i].setLabel("");
				}
				field[one].setBackground(Color.red);
				field[two].setBackground(Color.red);
				field[three].setBackground(Color.red);
				field[four].setBackground(Color.red);
				field[five].setBackground(Color.red);
				field[six].setBackground(Color.red);
				field[seven].setBackground(Color.red);
				field[eight].setBackground(Color.red);
				field[nine].setBackground(Color.red);
				field[ten].setBackground(Color.red);
				field[eleven].setBackground(Color.red);
				field[twelve].setBackground(Color.red);
				field[thirteen].setBackground(Color.red);
				field[fourteen].setBackground(Color.red);
				field[fifteen].setBackground(Color.red);
				field[sixteen].setBackground(Color.red);
				field[seventeen].setBackground(Color.red);
				field[eighteen].setBackground(Color.red);
				field[nineteen].setBackground(Color.red);
				field[twenty].setBackground(Color.red);
				field[oneBomb].setBackground(Color.red);
				field[twoBomb].setBackground(Color.red);
				foo = true;
			}
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException e){}
			if(foo)
			{
				field[one].setBackground(Color.white);
				field[two].setBackground(Color.white);
				field[three].setBackground(Color.white);
				field[four].setBackground(Color.white);
				field[five].setBackground(Color.white);
				field[six].setBackground(Color.white);
				field[seven].setBackground(Color.white);
				field[eight].setBackground(Color.white);
				field[nine].setBackground(Color.white);
				field[ten].setBackground(Color.white);
				field[eleven].setBackground(Color.white);
				field[twelve].setBackground(Color.white);
				field[thirteen].setBackground(Color.white);
				field[fourteen].setBackground(Color.white);
				field[fifteen].setBackground(Color.white);
				field[sixteen].setBackground(Color.white);
				field[seventeen].setBackground(Color.white);
				field[eighteen].setBackground(Color.white);
				field[nineteen].setBackground(Color.white);
				field[twenty].setBackground(Color.white);
				field[oneBomb].setBackground(Color.white);
				field[twoBomb].setBackground(Color.white);
				foo = false;
			}
	}

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == restart)
        {

            bombFinder();
            bombButton.setEnabled(true);
            p1Win = 0;
            p2Win = 0;
            infoLabel[2].setText(String.valueOf(p1Win));
            infoLabel[3].setText(String.valueOf(p2Win));
            turn = true;
            p1Counter = 0;
            p2Counter = 0;
            place1 = 66;
            place2 = 69;
            for (int i = 0; i < field.length; i++)
            {
                field[i].setBackground(plain);
                field[i].setLabel(String.valueOf(i));
            }
            start1.setBackground(twoColor);
            start2.setBackground(oneColor);
            System.out.println(one + " " + two + " " + three + " " + four + " " + five);
        }
        if (e.getSource() == easy)
        {
            turn = true;
            p1Counter = 0;
            p2Counter = 0;
            place1 = 66;
            place2 = 69;
            bombFinder();
            bombButton.setEnabled(true);
            level = 1;
            for (int i = 0; i < field.length; i++)
            {
                field[i].setBackground(plain);
                field[i].setLabel(String.valueOf(i));
            }
            start1.setBackground(twoColor);
            start2.setBackground(oneColor);
            System.out.println(one + " " + two + " " + three + " " + four + " " + five);
        }
        if (e.getSource() == medium)
        {
            turn = true;
            p1Counter = 0;
            p2Counter = 0;
            place1 = 66;
            place2 = 69;
            bombFinder();
            bombButton.setEnabled(true);
            level = 2;
            for (int i = 0; i < field.length; i++)
            {
                field[i].setBackground(plain);
                field[i].setLabel(String.valueOf(i));
            }
            start1.setBackground(twoColor);
            start2.setBackground(oneColor);
            System.out.println(one + " " + two + " " + three + " " + four + " " + five + " " + six + " " + seven + " " + eight + " " + nine + " " + ten);
        }
        if (e.getSource() == hard)
        {
            bombButton.setEnabled(true);
            turn = true;
            p1Counter = 0;
            p2Counter = 0;
            place1 = 66;
            place2 = 69;
            bombFinder();
            level = 3;
            for (int i = 0; i < field.length; i++)
            {
                field[i].setBackground(plain);
                field[i].setLabel(String.valueOf(i));
            }
            start1.setBackground(twoColor);
            start2.setBackground(oneColor);
            System.out.println(one + " " + two + " " + three + " " + four + " " + five + " " + six + " " + seven + " " + eight + " " + nine + " " + ten + " " + eleven + " " + twelve + " " + thirteen + " " + fourteen + " " + fifteen);
        }
         if (e.getSource() == extreme)
		{
			bombButton.setEnabled(true);
			turn = true;
			p1Counter = 0;
			p2Counter = 0;
			place1 = 66;
			place2 = 69;
			bombFinder();
			level = 4;
			for (int i = 0; i < field.length; i++)
			{
				field[i].setBackground(plain);
				field[i].setLabel(String.valueOf(i));
			}
			start1.setBackground(twoColor);
			start2.setBackground(oneColor);
		}
        if(e.getSource() == instructionsRules)
        {
            JOptionPane.showMessageDialog(null,"HOW TO PLAY: \n\n At the beginning each player starts at the bottom of the course. \n\n Each player will be allowed to place one bomb in a place of choice on the map. \n\n Bombs are hidden throughout the course and they will be displayed for a short period of time before the game begins. \n\n The goal is to make it across the map without hitting any bombs. \n\n To win you must be the first player to make it to the last row of tiles. \n\n Your wins and moves will be recorded unless the game is restarted.");
        }
        if(e.getSource() == instructionsRan)
        {
			JOptionPane.showMessageDialog(null," ");
        }
        if(e.getSource() == bombButton)
        {
            bombButton.setEnabled(false);
            while (!bombo1)
            {
                try
                {
                    oneBomb = Integer.valueOf(JOptionPane.showInputDialog(null, "Player One choose which square you wish to place your bomb in:"));
                    if(oneBomb <= 55)
                    {
                        bombo1 = true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You must choose the number of the square less than or equal to 55!");
                        bombo1 = false;
                    }
                }
                catch (Exception a)
                {
                    JOptionPane.showMessageDialog(null, "You must choose the number of the square which you wish to place your bomb in!");
                }
            }
            while (!bombo2)
            {
                try
                {
                    twoBomb = Integer.valueOf(JOptionPane.showInputDialog(null, "Player two choose which square you wish to place your bomb in:"));
                    if(twoBomb <= 55)
                    {
                        bombo2 = true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You must choose the number of the square less than or equal to 55!");
                        bombo2 = false;
                    }
                }
                catch (Exception a)
                {
                    JOptionPane.showMessageDialog(null, "You must choose the number of the square which you wish to place your bomb in!");
                }
            }
            bombo1 = false;
            bombo2 = false;
            t1 = new Thread(this);
            t1.start();
        }
        if (turn)
        {
            for(int i = 0; i < field.length; i++)
            {
                if(e.getSource() == field[i])
                {
                    if(checkValid(i))
                    {
                        if(checkBomb(i))
                        {
                            if(place1 == 66)
                            {
								if(bombButton.isEnabled())
								{
                                	JOptionPane.showMessageDialog(null, "You need to place your personal bombs first");
								}
								else
								{
                                	place1 = i;
                                	field[i].setBackground(twoColor);
                                	start1.setBackground(plain);
                                	p1Counter++;
                                	System.out.println(p1Counter);
                                	turn = false;
								}
                            }
                            else
                            {
                                if(i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i ==7)
                                {
                                    bombButton.setEnabled(true);
                                    JOptionPane.showMessageDialog(null, "Player One win's with " + p1Counter + " moves!");
                                    p1Win ++;
                                    infoLabel[2].setText(String.valueOf(p1Win));
                                    p1Counter = 0;
                                    p2Counter = 0;
                                    place1 = 66;
                                    place2 = 69;
                                    for (int j = 0; j < field.length; j++)
                                    {
                                        field[j].setBackground(plain);
                                    }
                                    start1.setBackground(twoColor);
                                    start2.setBackground(oneColor);
                                    bombFinder();
                                    turn = false;
                                }
                                else
                                {
                                    bombButton.setEnabled(false);
                                    field[place1].setBackground(plain);
                                    place1 = i;
                                    field[i].setBackground(twoColor);
                                    p1Counter++;
                                    System.out.println(p1Counter);
                                    turn = false;
                                }
                            }
                        }
                        else
                        {
                            playSound();
                            field[place1].setBackground(plain);
                            place1 = 66;
                            start1.setBackground(twoColor);
                            p1Counter++;
                            System.out.println(p1Counter);
                            turn = false;
                        }
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < field.length; i++)
            {
                if (e.getSource() == field[i])
                {
                    if (checkValid(i))
                    {
                        if (checkBomb(i))
                        {
                            if(place2 == 69)
                            {
								if(bombButton.isEnabled())
								{
									JOptionPane.showMessageDialog(null, "You need to place your personal bombs first");
								}
								else
								{
                                	bombButton.setEnabled(false);
                                	place2 = i;
                                	start2.setBackground(plain);
                                	field[i].setBackground(oneColor);
                                	p2Counter++;
                                	System.out.println(p2Counter);
                                	turn = true;
								}
                            }
                            else
                            {
                                if(i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i ==7)
                                {
                                    bombButton.setEnabled(true);
                                    JOptionPane.showMessageDialog(null, "Player Two win's with " + p2Counter + " moves!");
                                    p2Win ++;
                                    infoLabel[3].setText(String.valueOf(p2Win));
                                    p1Counter = 0;
                                    p2Counter = 0;
                                    place1 = 66;
                                    place2 = 69;
                                    for (int j = 0; j < field.length; j++)
                                    {
                                        field[j].setBackground(plain);
                                    }
                                    start1.setBackground(twoColor);
                                    start2.setBackground(oneColor);
                                    bombFinder();
                                    turn = true;
                                }
                                else
                                {
                                    bombButton.setEnabled(false);
                                    field[place2].setBackground(plain);
                                    place2 = i;
                                    field[i].setBackground(oneColor);
                                    p2Counter++;
                                    System.out.println(p2Counter);
                                    turn = true;
                                }
                            }
                        }
                        else
                        {
                            playSound();
                            field[place2].setBackground(plain);
                            place2 = 69;
                            start2.setBackground(oneColor);
                            p2Counter++;
                            System.out.println(p2Counter);
                            turn = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Chap7Personal c = new Chap7Personal();
        c.setVisible(true);
        c.setBounds(0,0,500,500);
        c.setBackground(Color.GRAY);
    }
}