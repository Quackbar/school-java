import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Semester1 extends JFrame implements ActionListener, ItemListener
{
	int red,green,blue;
	int boo = 1;
	Color randomColor, inverseColor;
	Button boxUno = new Button("Random Color");

	Font f = new Font("Voltage", Font.ITALIC, 12);
	Font a = new Font("Voltage", Font.BOLD, 12);

	Button colorButton = new Button("Change Color");
	Button textButton = new Button("Change Text");

	JLabel bcLabel = new JLabel("Background Color:");
	JLabel fcLabel = new JLabel("Foreground Color:");
	JLabel clearLabel = new JLabel("Clear the Label");
	static JLabel outputLabel = new JLabel(" ");

	CheckboxGroup bColor = new CheckboxGroup();
		Checkbox redBox = new Checkbox("red",bColor,false);
		Checkbox greenBox = new Checkbox("green",bColor,false);
		Checkbox blueBox = new Checkbox("blue",bColor,false);
	CheckboxGroup fColor = new CheckboxGroup();
		Checkbox whiteBox = new Checkbox("white",fColor,false);
		Checkbox magentaBox = new Checkbox("magenta",fColor,false);
		Checkbox yellowBox = new Checkbox("yellow",fColor,false);

	Checkbox clearBox = new Checkbox("Clear",false);
	Checkbox emptyBox = new Checkbox("",false);

	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();

	public Semester1()
	{
		this.setTitle("Text Formatter");
		this.setLayout(new BorderLayout());
		add(panel1, BorderLayout.NORTH);
			panel1.setLayout(new GridLayout(0,3));
			panel1.setBackground(Color.black);
			panel1.add(colorButton);
				colorButton.setBackground(Color.black);
				colorButton.setForeground(Color.red);
				colorButton.addActionListener(this);
			panel1.add(boxUno);
				boxUno.addActionListener(this);
			panel1.add(textButton);
				textButton.setFont(f);
				textButton.setBackground(Color.black);
				textButton.setForeground(Color.white);
				textButton.addActionListener(this);
		add(panel2, BorderLayout.CENTER);
			panel2.setLayout(new GridLayout(3,4));
			panel2.setBackground(Color.black);
			panel2.add(bcLabel);
				bcLabel.setFont(f);
				bcLabel.setForeground(Color.green);
			panel2.add(redBox);
				redBox.setForeground(Color.red);
				redBox.addItemListener(this);
			panel2.add(greenBox);
				greenBox.setForeground(Color.green);
				greenBox.addItemListener(this);
			panel2.add(blueBox);
				blueBox.setForeground(Color.blue);
				blueBox.addItemListener(this);
			panel2.add(fcLabel);
				fcLabel.setFont(a);
				fcLabel.setForeground(Color.magenta);
			panel2.add(whiteBox);
				whiteBox.setForeground(Color.white);
				whiteBox.addItemListener(this);
			panel2.add(magentaBox);
				magentaBox.setForeground(Color.magenta);
				magentaBox.addItemListener(this);
			panel2.add(yellowBox);
				yellowBox.setForeground(Color.yellow);
				yellowBox.addItemListener(this);
			panel2.add(clearLabel);
				clearLabel.setForeground(Color.white);
			panel2.add(clearBox);
				clearBox.setForeground(Color.white);
				clearBox.addItemListener(this);
		add(panel3, BorderLayout.SOUTH);
			panel3.add(outputLabel);
			panel3.setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == colorButton)
		{
			if(redBox.getState() == true)
			{
				outputLabel.setBackground(Color.red);
				panel3.setBackground(Color.red);
			}
			if(greenBox.getState() == true)
			{
				outputLabel.setBackground(Color.green);
				panel3.setBackground(Color.green);
			}
			if(blueBox.getState() == true)
			{
				outputLabel.setBackground(Color.blue);
				panel3.setBackground(Color.blue);
			}
			if(whiteBox.getState() == true)
			{
				outputLabel.setForeground(Color.white);
			}
			if(magentaBox.getState() == true)
			{
				outputLabel.setForeground(Color.magenta);
			}
			if(yellowBox.getState() == true)
			{
				outputLabel.setForeground(Color.yellow);
			}
		}
		if(e.getSource() == textButton)
			{
				String text = JOptionPane.showInputDialog(null,"Enter text for the Label");
				outputLabel.setText(text);
			}
			if(e.getSource() == boxUno)
			{
				red = (int) (Math.random()*256);
				green = (int) (Math.random()*256);
				blue = (int) (Math.random()*256);
				randomColor = new Color(red,green,blue);
				inverseColor = new Color(255-red,255-green,255-blue);
				outputLabel.setForeground(randomColor);
				outputLabel.setBackground(inverseColor);
				panel3.setBackground(inverseColor);
			}
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource() == clearBox)
		{
			outputLabel.setText(" ");
			outputLabel.setForeground(Color.black);
			outputLabel.setBackground(Color.white);
			panel3.setBackground(Color.white);
			clearBox.setState(false);
		}

	}
	public static void main(String[] args)
	{
		String text = JOptionPane.showInputDialog(null,"Enter text for the Label");
		outputLabel.setText(text);
		Semester1 s = new Semester1();
		s.setVisible(true);
		s.setBounds(10,10,500,300);
	}

}