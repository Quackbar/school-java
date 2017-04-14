import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardMaker extends Frame implements ActionListener, ItemListener
{
	String fontS;

	String[] fontArray = {"Jokerman","Chiller","Tahoma","Playbill","Comic sans MS"};

	Font f = new Font("Arial", Font.BOLD, 26);

	JButton addText = new JButton("Add Text");
	JButton clear = new JButton("Clear");
	JButton color = new JButton("Color");
	JButton font = new JButton("Font");

	JPanel westPanel = new JPanel();
	JPanel eastPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel centerPanel = new JPanel();

	JLabel outputLabel = new JLabel("");

	CheckboxGroup cGroup = new CheckboxGroup();
		Checkbox red = new Checkbox("Red", cGroup, false);
		Checkbox green = new Checkbox("Green", cGroup, false);
		Checkbox blue = new Checkbox("Blue", cGroup, false);
		Checkbox magenta = new Checkbox("Magenta", cGroup, false);
		Checkbox hidden = new Checkbox("", cGroup, true);


	JComboBox cBox;

	public CardMaker()
	{
		this.setLayout(new BorderLayout());
		this.setTitle("Card Maker");
		add(westPanel, BorderLayout.WEST);
			westPanel.setLayout(new GridLayout(4,0));
			westPanel.add(addText);
			addText.addActionListener(this);
			westPanel.add(clear);
			clear.addActionListener(this);
			westPanel.add(color);
			color.addActionListener(this);
			westPanel.add(font);
			font.addActionListener(this);
		add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(4,0));
			eastPanel.add(red);
			red.setVisible(false);
			red.addItemListener(this);
			eastPanel.add(green);
			green.setVisible(false);
			green.addItemListener(this);
			eastPanel.add(blue);
			blue.setVisible(false);
			blue.addItemListener(this);
			eastPanel.add(magenta);
			magenta.setVisible(false);
			magenta.addItemListener(this);
		add(southPanel, BorderLayout.SOUTH);
		sort(fontArray);
		cBox = new JComboBox(fontArray);
		southPanel.add(cBox);
		cBox.addItemListener(this);
		cBox.setVisible(false);
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(outputLabel);
		outputLabel.setFont(f);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addText)
		{
			outputLabel.setText(JOptionPane.showInputDialog(null, "Enter the text wich you wish to be displayed"));
		}
		else if(e.getSource() == clear)
		{
			outputLabel.setText("");
			fontS = "Arial";
			outputLabel.setFont(f);
			outputLabel.setForeground(Color.black);
			red.setVisible(false);
			green.setVisible(false);
			blue.setVisible(false);
			magenta.setVisible(false);
			hidden.setState(true);
			cBox.setVisible(false);
			cBox.setSelectedIndex(0);
		}
		else if(e.getSource() == color)
		{
			red.setVisible(true);
			green.setVisible(true);
			blue.setVisible(true);
			magenta.setVisible(true);
		}
		else if(e.getSource() == font)
		{
			cBox.setVisible(true);
		}
	}

	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource() == red)
		{
			outputLabel.setForeground(Color.red);
		}
		else if(e.getSource() == green)
		{
			outputLabel.setForeground(Color.green);
		}
		else if(e.getSource() == blue)
		{
			outputLabel.setForeground(Color.blue);
		}
		else if(e.getSource() == magenta)
		{
			outputLabel.setForeground(Color.magenta);
		}
		else
		{
			fontS = String.valueOf(cBox.getSelectedItem());
			Font fon = new Font(fontS, Font.BOLD, 26);
			outputLabel.setFont(fon);
		}
	}

	public void sort(String[] s)
	{
	}

	public static void main(String args[])
	{
		CardMaker cm = new CardMaker();
		cm.setVisible(true);
		cm.setBounds(300,300,600,500);
	}
}