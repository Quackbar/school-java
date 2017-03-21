import java.awt.*;                     //for the dimension
import javax.swing.*;                  //for the JButton
import java.awt.event.*;               //to make the MouseAdapter
import java.io.*; 					   //read form a file
import javax.imageio.ImageIO;          //image IO
import java.awt.image.BufferedImage;   // for the buffered image

public class ShapedButton extends JButton
{
	BufferedImage buttonImage;
	ImageIcon buttonImg;
	int x,y;

	public ShapedButton(String buttonPict)
	{
		try
		{
			buttonImage = ImageIO.read(new File(buttonPict));
			buttonImg = new ImageIcon(buttonImage);
			setIcon(buttonImg);
		}
		catch(IOException ex){}

		Dimension size = getPreferredSize();
		size.width = getIcon().getIconWidth();
		size.height = getIcon().getIconHeight();
		setPreferredSize(size);
		setBorderPainted(false);
		setContentAreaFilled(false);

		addMouseListener(
			new MouseAdapter()
			{
				public void mousePressed(MouseEvent me)
				{
					x = me.getX();
					y = me.getY();
				}
			}
		);
	}

	public boolean contains()
	{
		boolean flag = true;
		int aux = buttonImage.getRGB(x,y);
		int alpha = (int)(aux&0xFF000000)>>>24; //Return the ALPHA level

		/* don't use but how to get red, green, and blue of the pixel
		int red (int)(aux&0x00FF0000)>>>16;   //Red Level
		int green (int)(aux&0x0000FF00)>>>8;  //Green Level
		int blue (int)(aux&0x000000FF);       //Blue Level
		*/

		if(alpha == 0)
		{
			flag = false;
		}
		return flag;

	}
}