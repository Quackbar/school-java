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

			int red = 0;
			int green = (int)(Math.random()*256);
			int blue = 0;
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
			panelColor = Color.green;
		}
	}
	public Color setRandomSpaceShip()
	{
		penColor = Color.blue;
		return penColor;

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
	public Color setRandomLazer()
	{
		int red = (int)(Math.random()*256);
		int green = 0;
		int blue = 0;
		penColor = new Color(red,green,blue);
		return penColor;

	}
	public Color setRandomBuilding()
	{
		penColor = new Color(180, 180, 180);
		return penColor;

	}
	public Color setRandomBomb()
	{
		penColor = Color.red;
		return penColor;

	}
	public Color setRandomBombRing()
	{
		penColor = Color.orange;
		return penColor;

	}
	public Color setRandomStar()
	{
		penColor = Color.white;
		return penColor;

	}
	public Color setRandomNuke()
	{
		penColor = Color.yellow;
		return penColor;

	}
	public Color setRandomBuildingD()
	{
		penColor = new Color(200, 200, 200);
		return penColor;

	}
}