import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class IceCream extends JFrame implements ActionListener
{
	ImageIcon buttonImg;
	BufferedImage buttonImage;

	DataOutputStream output;
	DataInputStream input;
	double total = 0.0, price = 0.0;
	String namea, scoop, nut, sprink, choc, filename, daFlavor;

	String[] inStuff = new String[50];

	Color blueish = new Color(115,206,240);

	JLabel flavorLabel = new JLabel("       Choose flavor:");
	JLabel scoopsLabel = new JLabel("Choose scoops:");
	JLabel topLabel = new JLabel("Choose toppings:");
	JLabel aLabel = new JLabel();
	JLabel name = new JLabel("Ye Olde Ice Cream Shoppe",  SwingConstants.CENTER);
	JLabel laFinal = new JLabel(" ",  SwingConstants.CENTER);

	Font f = new Font("Lucida Handwriting", Font.PLAIN, 13);
	Font f2 = new Font("Lucida Handwriting", Font.PLAIN, 34);

	JComboBox<String> flavor = new JComboBox<String>();

	CheckboxGroup scoops = new CheckboxGroup();
		Checkbox oneScoop = new Checkbox("1 Scoop $1.50", true, scoops);
		Checkbox twoScoop = new Checkbox("2 Scoop $3.00", false, scoops);
		Checkbox threeScoop = new Checkbox("3 Scoop $4.50", false, scoops);

	Checkbox nuts = new Checkbox("Add Nuts $0.50", false);
	Checkbox sprinkles = new Checkbox("Add Sprinkles $0.50", false);
	Checkbox choco = new Checkbox("Add Chocolate Dip $0.75", false);

	JButton addB = new JButton("Add Order");
	JButton placeB = new JButton("Place Order");
	JButton clear = new JButton("Clear All");

	Panel allNorth = new Panel();
	Panel allCenter = new Panel();
	Panel allPointless = new Panel();
	Panel other = new Panel();
	Panel northern = new Panel();
	Panel southern = new Panel();
	Panel eastern = new Panel();
	Panel western = new Panel();
	Panel center = new Panel();
	Panel northSouth = new Panel();
	Panel picPanel = new Panel();

	JMenuItem retrive = new JMenuItem("Pointless Retrieve Option");

	public IceCream()
	{
		JMenuBar mnu = new JMenuBar();
		JMenu file = new JMenu("File");
		mnu.add(file);
		file.add(retrive);
		retrive.addActionListener(this);
		setJMenuBar(mnu);

		allNorth.setBackground(blueish);
		allCenter.setBackground(blueish);
		other.setBackground(blueish);
		northern.setBackground(blueish);
		southern.setBackground(blueish);
		eastern.setBackground(blueish);
		western.setBackground(blueish);
		center.setBackground(blueish);
		northSouth.setBackground(blueish);
		picPanel.setBackground(blueish);
		allPointless.setBackground(blueish);
		this.setLayout(new BorderLayout());
		setBackground(blueish);
		add(allNorth, BorderLayout.NORTH);
		allNorth.setLayout(new GridLayout(0,3));
			allNorth.add(flavorLabel);
			flavorLabel.setFont(f);
			allNorth.add(scoopsLabel);
			scoopsLabel.setFont(f);
			allNorth.add(topLabel);
			topLabel.setFont(f);
		add(allCenter, BorderLayout.CENTER);
		allCenter.setLayout(new GridLayout(3,0));
			allCenter.add(northern);
			northern.setLayout(new BorderLayout());
				northern.add(other, BorderLayout.CENTER);
				other.setLayout(new GridLayout(0,3));
					other.add(western);
						western.add(flavor);
						flavor.addActionListener(this);
					other.add(center);
					center.setLayout(new GridLayout(3,0));
						center.add(oneScoop);
						center.add(twoScoop);
						center.add(threeScoop);
					other.add(eastern);
					eastern.setLayout(new GridLayout(3,0));
						eastern.add(nuts);
						eastern.add(sprinkles);
						eastern.add(choco);
				northern.add(northSouth, BorderLayout.SOUTH);
				northSouth.setLayout(new GridLayout(0,3));
					northSouth.add(addB);
						addB.addActionListener(this);
						addB.setFont(f);
					northSouth.add(placeB);
						placeB.addActionListener(this);
						placeB.setFont(f);
					northSouth.add(clear);
						clear.addActionListener(this);
						clear.setFont(f);
			allCenter.add(southern);
			southern.setLayout(new BorderLayout());
			southern.add(picPanel);
			try
			{
				buttonImage = ImageIO.read(new File("icecreamPic.jpg"));
				buttonImg = new ImageIcon(buttonImage);
				aLabel.setIcon(buttonImg);
			}
			catch(IOException ex){}
			picPanel.add(aLabel);
			allCenter.add(allPointless);
			allPointless.setLayout(new BorderLayout());
			allPointless.add(name, BorderLayout.CENTER);
			name.setFont(f2);
			allPointless.add(laFinal, BorderLayout.SOUTH);
			laFinal.setFont(f);

		flavor.addItem("Flavor");
		flavor.addItem("Vanilla");
		flavor.addItem("Chocolate");
		flavor.addItem("Moose Tracks");
		flavor.addItem("Strawberry");
		flavor.addItem("Orange");
		flavor.addItem("Yellow Cake");
		flavor.addItem("Cotton Candy");
		flavor.addItem("Sorbet");
		flavor.addItem("Mint");

		Date today = new Date();
		String filename = "Order";
		try
		{
			output = new DataOutputStream(new FileOutputStream(filename));
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null, "The program could not create a storage location. Please check the disk drive and then run the program again.","ERROR", JOptionPane.INFORMATION_MESSAGE);
			System.exit(1);
		}
		try
		{
			input = new DataInputStream(new FileInputStream(filename));
		}
		catch(IOException io)
		{
			//JOptionPane.showMessageDialog(null, "The program could not create a storage location. Please check the disk drive and then run the program again.","ERROR", JOptionPane.INFORMATION_MESSAGE);
			System.exit(1);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == retrive)
		{
			try
			{
				for(int i = 0; i<inStuff.length; i++)
				{
					inStuff[i] = "";
					inStuff[i] = input.readUTF();
					laFinal.setText(laFinal.getText()+ " " + inStuff[i]);
				}
				if(inStuff[0] == "")
				{
					JOptionPane.showMessageDialog(null, "There was no order to retrieve");
				}
			}
			catch(IOException ie){}
			//laFinal.setText("Cost: $" + inStuff);
		}
		if(e.getSource() == addB)
		{
			price = 0.0;
			if(flavor.getSelectedItem().equals("Flavor"))
			{
				JOptionPane.showMessageDialog(null, "You need to select a flavor");
			}
			else
			{
				scoop = "";
				nut = "";
				sprink = "";
				choc = "";
				if(nuts.getState())
				{
					price += .50;
					total += .50;
					nut = " Nuts,";
				}
				if(sprinkles.getState())
				{
					price += .50;
					total += .50;
					sprink = " Sprinkles,";
				}
				if(choco.getState())
				{
					price += .75;
					total += .75;
					choc = " Chocolate Dip,";
				}
				if(oneScoop.getState())
				{
					price += 1.50;
					total += 1.50;
					scoop = " One Scoop";
				}
				else if(twoScoop.getState())
				{
					price += 3.00;
					total += 3.00;
					scoop = " Two Scoops";
				}
				else if(threeScoop.getState())
				{
					price += 4.50;
					total += 4.50;
					scoop = " Three Scoops";
				}
				laFinal.setText("Cost: $" + String.valueOf(total));
				oneScoop.setState(true);
				nuts.setState(false);
				sprinkles.setState(false);
				choco.setState(false);
				String foo = (String) flavor.getSelectedItem();
				daFlavor = (String)flavor.getSelectedItem();
				flavor.setSelectedIndex(0);
				try
				{
					output.writeUTF(daFlavor);
					output.writeUTF(scoop);
					output.writeUTF(nut);
					output.writeUTF(sprink);
					output.writeUTF(choc);
				}
				catch(IOException ie){}
			}
		}
		if(e.getSource() == placeB)
		{
			System.out.println(total);
			if(total == 0.0)
			{
				JOptionPane.showMessageDialog(null, "You need to add an order first.");
			}
			else
			{
				namea = JOptionPane.showInputDialog(null,"Whats your name");
				flavor.setSelectedIndex(0);
				oneScoop.setState(true);
				nuts.setState(false);
				sprinkles.setState(false);
				choco.setState(false);
				laFinal.setText(" ");
				try
				{
					output.writeUTF("for " + namea);
					output.writeUTF(String.valueOf(total));
				}
				catch(IOException ie){}
				JOptionPane.showMessageDialog(null,"Your final price is $" + total);
				total = 0;
			}

		}
		if(e.getSource() == clear)
		{
			flavor.setSelectedIndex(0);
			oneScoop.setState(true);
			nuts.setState(false);
			sprinkles.setState(false);
			choco.setState(false);
			total = 0;
			laFinal.setText(" ");
		}
	}
	public static void main(String[] args)
	{
		Class<Class<Class<?>>> c = (Class<Class<Class<?>>>)Class.class.getClass();
		System.out.println(c);
		IceCream ic = new IceCream();
		ic.setVisible(true);
		ic.setBounds(400,400,520,500);
	}
}