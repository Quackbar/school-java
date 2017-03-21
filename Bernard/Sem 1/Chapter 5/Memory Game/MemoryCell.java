import java.awt.*;

//instance class that makes a memory cell
public class MemoryCell extends Canvas
{
	// data fields

	// image constants
	public final static int NONE = -1, PICT1 = 0, PICT2 = 1, PICT3 = 2, PICT4 = 3, PICT5 = 4, PICT6 = 5, PICT7 = 6, PICT8 = 7;

	//protected - this class and any that extend this call can directly access and change\
	private int picture;
	private static Image image;
	private boolean matched, hidden, focused;

	//constructor  (method that has the same name as the class has no return type and it runs when you make an instance of a class)
	public MemoryCell(int pict)
	{
		setPicture(pict);
		matched = false;
		hidden = true;
		focused = false;
		setBackground(Color.black);
		setSize(80,80);
	}

	//get methods
	public int getPicture()
	{
		return picture;
	}

	public boolean getMatched()
	{
		return matched;
	}

	public boolean getHidden()
	{
		return hidden;
	}

	public boolean getFocused()
	{
		return focused;
	}

	//set methods
	public void setPicture(int pict)
	{
		picture = pict;
	}

	public void setMatched(boolean match)
	{
		matched = match;
		repaint();
	}

	public void setHidden(boolean hid)
	{
		hidden = hid;
		repaint();
	}

	public void setFocused(boolean focus)
	{
		focused = focus;
		repaint();
	}

	public boolean matches(MemoryCell secondMemCell)
	{
		return picture == secondMemCell.picture;
	}

	public void paint(Graphics g)
	{
		if(hidden)
		{
			g.setColor(Color.magenta);
			g.fillRect(0,0,getSize().width,getSize().height);
			g.setColor(Color.darkGray);
			g.setFont(new Font("Chiller",Font.ITALIC,36));
			g.drawString("?",25,37);
		}
		else
		{
			switch(picture)
			{
				case PICT1:
					image = Toolkit.getDefaultToolkit().getImage("PortlandTimbers.png");
					break;
				case PICT2:
					image = Toolkit.getDefaultToolkit().getImage("RedBull.png");
					break;
				case PICT3:
					image = Toolkit.getDefaultToolkit().getImage("RealSaltLake.png");
					break;
				case PICT4:
					image = Toolkit.getDefaultToolkit().getImage("LaGalaxy.png");
					break;
				case PICT5:
					image = Toolkit.getDefaultToolkit().getImage("Portugal.png");
					break;
				case PICT6:
					image = Toolkit.getDefaultToolkit().getImage("Usa.png");
					break;
				case PICT7:
					image = Toolkit.getDefaultToolkit().getImage("Argentina.png");
					break;
				case PICT8:
					image = Toolkit.getDefaultToolkit().getImage("IvoryCoast.png");
					break;
				default:
					super.paint(g);
			}
			g.drawImage(image,0,0,60,60,this);
			if(focused)
			{
				if(matched)
				{
					g.setColor(Color.green);
				}
				else
				{
					g.setColor(Color.red);
				}
				g.drawRect(0,0,getSize().width-1, getSize().height-1);
			}
		}
	}
}