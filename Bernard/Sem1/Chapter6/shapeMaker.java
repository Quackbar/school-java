import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class shapeMaker extends Frame implements ActionListener
{
	MenuBar mnuBar = new MenuBar();
	Menu file = new Menu("File");
	Menu edit = new Menu("Edit");
	Menu tools = new Menu("Tools");
	Menu shape = new Menu("Shape");
	MenuItem exitItem = new MenuItem("Exit");
	MenuItem clearItem = new MenuItem("Clear");
	MenuItem colorItem = new MenuItem("Color");
	MenuItem sizeItem = new MenuItem("Size");
	MenuItem positionItem = new MenuItem("Position");
	MenuItem rectangleItem = new MenuItem("Rectangle");
	MenuItem ovalItem = new MenuItem("Oval");


	Color ranColor;

	Random rand = new Random();

    int red,green,blue;

	int height = 10;
	int width = 10;
	int x = 50;
	int y = 50;
	public shapeMaker()
	{
		this.setTitle("Shape Maker");
		this.setMenuBar(mnuBar);
		mnuBar.add(file);
		mnuBar.add(edit);
		mnuBar.add(tools);
		mnuBar.add(shape);
		file.add(exitItem);
		exitItem.addActionListener(this);
		edit.add(clearItem);
		clearItem.addActionListener(this);
		tools.add(colorItem);
		colorItem.addActionListener(this);
		tools.add(sizeItem);
		sizeItem.addActionListener(this);
		tools.add(positionItem);
		positionItem.addActionListener(this);
		shape.add(rectangleItem);
		rectangleItem.addActionListener(this);
		shape.add(ovalItem);
		ovalItem.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		Graphics g = getGraphics();
		if(e.getSource() == exitItem)
		{
			System.exit(0);
		}
		else if(e.getSource() == clearItem)
		{
			repaint();
		}
		else if(e.getSource() == colorItem)
		{
 			red = (int) (Math.random()*256);
			green = (int) (Math.random()*256);
			blue = (int) (Math.random()*256);
			ranColor = new Color(red,green,blue);
		}
		else if(e.getSource() == sizeItem)
		{
			height = Integer.valueOf(JOptionPane.showInputDialog(null, "What do you want the height to be?"));
			width = Integer.valueOf(JOptionPane.showInputDialog(null, "What do you want the width to be?"));
		}
		else if(e.getSource() == positionItem)
		{
			x = Integer.valueOf(JOptionPane.showInputDialog(null, "What do you want the x coordinate to be?"));
			y = Integer.valueOf(JOptionPane.showInputDialog(null, "What do you want the y coordinate to be?"));
		}
		else if(e.getSource() == rectangleItem)
		{
			g.setColor(ranColor);
			g.fillRect(x,y,width,height);
		}
		else if(e.getSource() == ovalItem)
		{
			g.setColor(ranColor);
			g.fillOval(x,y,width,height);
		}
	}

	public static void main(String[] args)
	{
		shapeMaker sp = new shapeMaker();
		sp.setVisible(true);
		sp.setBounds(0,0,300,300);
	}
}