import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MoveIt3 extends Applet implements ActionListener, KeyListener
{
	private Image duck;
	private Panel keypad;
	public int top = 300;
	public int left = 500;
	private Button[] keysArray = new Button[5];

	public void init()
	{
		duck = getImage(getDocumentBase(), "duck.png");
		this.addKeyListener(this);
		this.setFocusable(true);
		Canvas myCanvas = new Canvas();
		Panel keypad = new Panel();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.blue);
		add(keypad, BorderLayout.SOUTH);
		keypad.setLayout(new BorderLayout());
		for(int i =0; i<keysArray.length; i++)
		{
			keysArray[i] = new Button();
			keysArray[i].addActionListener(this);
		}
		keysArray[0].setLabel("Up");
		keysArray[1].setLabel("Down");
		keysArray[2].setLabel("Left");
		keysArray[3].setLabel("Right");
		keysArray[4].setLabel("Center");
		keypad.add(keysArray[0], BorderLayout.NORTH);
		keypad.add(keysArray[1], BorderLayout.SOUTH);
		keypad.add(keysArray[2], BorderLayout.WEST);
		keypad.add(keysArray[3], BorderLayout.EAST);
		keypad.add(keysArray[4], BorderLayout.CENTER);

		add(myCanvas, BorderLayout.NORTH);
	}
	public void paint(Graphics g)
	{
		g.drawImage( duck, left, top, this );
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == keysArray[0])
		{
			top -= 15;
			repaint();
		}
		else if(e.getSource() == keysArray[1])
		{
			top += 15;
			repaint();
		}
		else if(e.getSource() == keysArray[2])
		{
			left -= 15;
			repaint();
		}
		else if(e.getSource() == keysArray[3])
		{
			left += 15;
			repaint();
		}
		else if(e.getSource() == keysArray[4])
		{
			top = 300;
			left = 500;
			repaint();
		}
	}
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		switch(keyCode)
		{
			case KeyEvent.VK_UP:
				// handle up
				top -= 15;
				repaint();
				break;
			case KeyEvent.VK_DOWN:
				// handle down
				top += 15;
				repaint();
				break;
			case KeyEvent.VK_LEFT:
				// handle left
				left -= 15;
				repaint();
				break;
			case KeyEvent.VK_RIGHT:
				// handle right
				left += 15;
				repaint();
				break;
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}