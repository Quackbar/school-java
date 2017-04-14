import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class RandomColorApplet extends Applet implements ActionListener
{
	int red,green,blue;
	Color randomColor, inverseColor;
	//components
	Button colorButton = new Button("Change Color");
	//Label messageLabel = new Label("CS Period 6 is the best!");
	Font messageFont = new Font("Jokerman", Font.BOLD,  36);

	public void init()
	{
		setBackground(Color.blue);
		setFont(messageFont);
		add(colorButton);
		//add(messageLabel);
		colorButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
    {
		red = (int) (Math.random()*256);
		green = (int) (Math.random()*256);
		blue = (int) (Math.random()*256);

		randomColor = new Color(red,green,blue);
		inverseColor = new Color(255-red,255-green,255-blue);

		setBackground(randomColor);
		//messageLabel.setBackground(randomColor);
		//messageLabel.setForeground(inverseColor);
		colorButton.setBackground(inverseColor);
		colorButton.setForeground(randomColor);
	}
}


