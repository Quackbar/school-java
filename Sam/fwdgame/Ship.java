import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import java.awt.geom.*;
import javax.swing.Timer;
import java.util.Random;


public class Ship extends JPanel implements ActionListener, KeyListener, path
{
	int x, y, velX;
	int bx, by;
	int bx2,by2;
	int bx3,by3;
	int bx4,by4;
	int r,g,b;
	int intsy;
	int sy, velYStar, velYStar1;
	boolean shot = false, readyToFire = true;
	boolean shot2 = false, readyToFire2 = false;
	boolean shot3 = false, readyToFire3 = false;
	boolean shot4 = false, readyToFire4 = false;
	boolean start = false;
	Rectangle bullet;
	Rectangle bullet2;
	Rectangle bullet3;
	Rectangle bullet4;
	int health = 100, ammo = 50, resources;
	String shipType;

	JLabel healthLabel = new JLabel();
	JLabel resourceLabel = new JLabel();
	JLabel ammoLabel = new JLabel();
	JLabel shipTypeLabel = new JLabel();

	JButton quitButton = new JButton();
	JPanel positionPanel = new JPanel();
	JPanel statsPanel = new JPanel();

	Font labelFont = new Font("Consolas", Font.BOLD, 18);
	JOptionPane ammoJopt = new JOptionPane();

	Color backgroundColor;
	Color foregroundColor;

	UIManager um = new UIManager();

	public Ship()
	{

		this.setLayout(new BorderLayout());
		add(statsPanel,BorderLayout.WEST);
		//positionPanel.setLayout(new BorderLayout());
		//positionPanel.add(statsPanel,BorderLayout.CENTER);
		//positionPanel.setBackground(Color.gray);
		statsPanel.setBackground(Color.gray);
		statsPanel.setLayout(new GridLayout(4,1,0,0));
		statsPanel.add(healthLabel);
		statsPanel.add(resourceLabel);
		statsPanel.add(ammoLabel);
		statsPanel.add(shipTypeLabel);

		r = 40;
		g = 40;
		b = 50;
		x = 400;
		y = 700;
		backgroundColor = new Color(r,g,b);
		foregroundColor = new Color(255,20,40);
		setBackground(backgroundColor);
		addKeyListener(this);
		setFocusable(true);

		healthLabel.setFont(labelFont);
		healthLabel.setText("Health: " + health);
		healthLabel.setForeground(foregroundColor);
		resourceLabel.setFont(labelFont);
		resourceLabel.setText("Resources: " + resources);
		resourceLabel.setForeground(foregroundColor);
		ammoLabel.setFont(labelFont);
		ammoLabel.setText("Ammo: " + ammo);
		ammoLabel.setForeground(foregroundColor);
		shipTypeLabel.setFont(labelFont);
		shipTypeLabel.setText("Ship Type: " + shipType);
		shipTypeLabel.setForeground(foregroundColor);

		quitButton.addActionListener(this);

		um.put("OptionPane.background",backgroundColor);
		um.put("Panel.background",backgroundColor);
		um.put("OptionPane.messageForeground",foregroundColor);
		um.put("OptionPane.font",labelFont);

	}

	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(keyCode == e.VK_S)
		{
			start = true;
		}

		if(keyCode == e.VK_LEFT)
		{
//			leftright = 0;
			velX = -5;
			x = x + velX;
			if(x <= 250)
				x = 251;
			if(x >= 650)
				x = 649;
		}
		if(keyCode == e.VK_RIGHT)
		{
//			leftright = 1;
			velX = 5;
			x = x + velX;
			if(x <= 200)
				x = 201;
			if(x >= 650)
				x = 649;
		}
		if(keyCode == e.VK_SPACE)
		{
			if(ammo > 0)
			{
			//System.out.println(readyToFire);
				System.out.println(readyToFire);
				if(readyToFire)
				{
					readyToFire = false;
					by = y-7;
					bx = x+18;

					bullet = new Rectangle(bx,by,3,5);
					readyToFire2 = true;
					shot = true;
					ammo -= 1;
					ammoLabel.setText("Ammo: " + ammo);
					//System.out.println(readyToFire);
				}
				if(readyToFire2)
				{
					if(bullet.y<=600)
					{
						readyToFire2 = false;
						readyToFire3 = true;
						by2 = y-7;
						bx2 = x+18;
						bullet2 = new Rectangle(bx2,by2,3,5);
						shot2 = true;
						ammo -= 1;
						ammoLabel.setText("Ammo: " + ammo);
					}
				}

				if(readyToFire3)
				{
					if(bullet2.y<=600)
					{
						readyToFire3 = false;
						readyToFire4 = true;
						by3 = y-7;
						bx3 = x+18;
						bullet3 = new Rectangle(bx3,by3,3,5);
						shot3 = true;
						ammo -= 1;
						ammoLabel.setText("Ammo: " + ammo);
					}
				}
				if(readyToFire4)
				{
					if(bullet3.y<=600)
					{
						readyToFire4 = false;
						by4 = y-7;
						bx4 = x+18;
						bullet4 = new Rectangle(bx4,by4,3,5);
						shot4 = true;
						ammo -= 1;
						ammoLabel.setText("Ammo: " + ammo);
					}
				}
			}
			else
			{


				JOptionPane.showMessageDialog(null,"YOU ARE OUT OF AMMO");
			}
		}
	}
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(keyCode == e.VK_LEFT)
		{
			velX = 0;
		}
		if(keyCode == e.VK_RIGHT)
		{
			velX = 0;
		}
		if(keyCode == e.VK_SPACE)
		{
			//readyToFire = false;
			if(bullet.y<=0)
			{
				shot = false;
				readyToFire = true;
				//System.out.println(readyToFire);
			}
			if(bullet2.y<=0)
			{
				shot2 = false;
				readyToFire2 = true;
			}
			if(bullet3.y<=0)
			{
				shot3 = false;
				readyToFire3 = true;
			}
			if(bullet4.y<=0)
			{
				shot4 = false;
				readyToFire4 = true;
			}
		}
	}
	public void keyTyped(KeyEvent e){}

	public void actionPerformed(ActionEvent e)
	{

	}
	public void paintComponent(Graphics g)
	{
		//first test ship
		super.paintComponent(g);
		g.setColor(foregroundColor);
		g.fillRect(x, y, 40, 10);
		g.fillRect(x+18, y-7, 4, 7);
		repaint();
		//border and grey box
		Rectangle statRectangle = new Rectangle();
		g.setColor(Color.gray);
		g.fillRect(0,0,250,1000);
		Rectangle redBorder = new Rectangle();
		g.setColor(foregroundColor);
		g.fillRect(250,0,2,1000);
		//bullet
		if(shot)
		{
			bullet.y -= 1;
			g.setColor(Color.yellow);
			g.fillRect(bullet.x,bullet.y,bullet.width,bullet.height);
			repaint();

		}
		if(shot2)
		{
			bullet2.y -= 1;
			g.setColor(Color.yellow);
			g.fillRect(bullet2.x,bullet2.y,bullet2.width,bullet2.height);
			repaint();
		}
		if(shot3)
		{
			bullet3.y -= 1;
			g.setColor(Color.yellow);
			g.fillRect(bullet3.x,bullet3.y,bullet3.width,bullet3.height);
			repaint();
		}
		if(shot4)
		{
			bullet4.y -= 1;
			g.setColor(Color.yellow);
			g.fillRect(bullet4.x,bullet4.y,bullet4.width,bullet4.height);
			repaint();
		}
		//stars
		if(start)
		{
			g.setColor(Color.white);
			g.fillRect(300,50,2,6);
			g.fillRect(298,52,6,2);

			g.fillRect(400,20,2,6);
			g.fillRect(398,22,6,2);

			g.fillRect(500,80,2,6);
			g.fillRect(498,82,6,2);

			g.fillRect(390,600,2,6);
			g.fillRect(388,602,6,2);

			g.fillRect(450,300,2,6);
			g.fillRect(448,302,6,2);

			g.fillRect(600,0,2,6);
			g.fillRect(598,2,6,2);

			g.fillRect(625,500,2,6);
			g.fillRect(623,502,6,2);

			g.fillRect(460,430,2,6);
			g.fillRect(458,432,6,2);

			g.fillRect(390,200,2,6);
			g.fillRect(388,202,6,2);

			g.fillRect(590,220,2,6);
			g.fillRect(588,222,6,2);

			g.fillRect(550,360,2,6);
			g.fillRect(548,362,6,2);

			g.fillRect(300,390,2,6);
			g.fillRect(298,392,6,2);

			g.fillRect(540,580,2,6);
			g.fillRect(538,582,6,2);

			g.fillRect(370,800,2,6);
			g.fillRect(368,802,6,2);

			g.fillRect(650,850,2,6);
			g.fillRect(648,852,6,2);

			g.fillRect(530,900,2,6);
			g.fillRect(528,902,6,2);
			repaint();

			//Rectangle star2 = new Rectangle();
		}


	}
	public static void main(String[] args)
	{
		Ship s = new Ship();

	}
}