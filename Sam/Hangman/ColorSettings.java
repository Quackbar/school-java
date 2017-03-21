import java.awt.*;
import javax.swing.*;

public class ColorSettings extends GameSettings
{
	boolean stuff = true;
	private Color drawPanelColor;
	private Color panelColor;
	private Color penColor;

	public ColorSettings(Color dpColor, Color pColor, Color penColor)
	{
		super();
		drawPanelColor = dpColor;
		panelColor = pColor;
		this.penColor = penColor;
	}

	public Color getDrawPanelColor()
	{
		return drawPanelColor;
	}
	public Color getPanelColor()
	{
		while(true)
		{

			int red = (int)(Math.random()*256);
			int green = (int)(Math.random()*256);
			int blue = (int)(Math.random()*256);
			panelColor = new Color(red,green,blue);
			return panelColor;
		}

	}
	public Color getPenColor()
	{
		return penColor;
	}
	public void setDrawPanelColor(Color dpColor)
	{
		drawPanelColor = dpColor;
	}
	public void setPanelColor(Color pColor)
	{
		while(true)
		{
			int red = (int)(Math.random()*256);
			int green = (int)(Math.random()*256);
			int blue = (int)(Math.random()*256);
			panelColor = new Color(red,green,blue);
		}
	}
	public void setPenColor(Color penColor)
	{
		this.penColor = penColor;
	}
	public Color setRandomPen()
	{
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		penColor = new Color(red,green,blue);
		return penColor;

	}
}