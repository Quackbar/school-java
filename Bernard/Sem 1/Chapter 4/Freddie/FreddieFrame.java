import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.util.Random;

public class FreddieFrame extends Panel implements ItemListener, ActionListener
{
	DecimalFormat df = new DecimalFormat("0.00##");
	Font f = new Font("Impact", 36 ,Font.BOLD);

	Label burgerPromptLabel = new Label("Select the Burger(s) in which you wish to consume");
	Label saucePromptLabel = new Label("Choose your Sauces");
	Label solidPromptLabel = new Label("Choose you Solid additions");
	Label moreLabel = new Label("Choose the More");
	TextField costField = new TextField(5);

	Checkbox mayoBox = new Checkbox("mayo",false);
	Checkbox mustardBox = new Checkbox("Mustard",false);
	Checkbox catchupBox = new Checkbox("Catchup",false);
	Checkbox spiceBox = new Checkbox("Mexican Spice",false);

	Checkbox lettuceBox = new Checkbox("Lettuce",false);
	Checkbox olivesBox = new Checkbox("Olives",false);
	Checkbox onionsBox = new Checkbox("Onions",false);
	Checkbox picklesBox = new Checkbox("Pickles",false);
	Checkbox baconBox = new Checkbox("Bacon",false);

	double cost =  0;

	Checkbox qtrBox = new Checkbox("Quarter Pound Burger",false);
	Checkbox halfBox = new Checkbox("Half Pound Burger",false);
	Checkbox poundBox = new Checkbox("One Pound Burger",false);
	Checkbox qtrCheeseBox = new Checkbox("Quarter Pound Cheeseburger",false);
	Checkbox halfCheeseBox = new Checkbox("Half Pound Cheeseburger",false);
	Checkbox poundCheeseBox = new Checkbox("One Pound Cheeseburger",false);

	Label drinkPromptLabel = new Label("Would you like a drink?");
		Checkbox rootBeerBox = new Checkbox("RootBeer",false);
		Checkbox mtnDewBox = new Checkbox("Mtn Dew",false);
		Checkbox pepsiBox = new Checkbox("Pepsi",false);
		Checkbox spriteBox = new Checkbox("Sprite",false);
		//Checkbox drBox = new Checkbox("Dr.Pepper",false);

	Label priceLabel = new Label("Your price is:");
	static TextField priceField = new TextField(10);
	Label emptyLabel = new Label("       ");

	Button order = new Button("Place Order");

	Panel northerPanel = new Panel();
	Panel northPanel = new Panel();
	Panel northNamePanel = new Panel();
	Panel centerPanel = new Panel();
	Panel centerCenterPanel = new Panel();
	Panel leftCenterPanel = new Panel();
	Panel rightCenterPanel = new Panel();
	Panel southPanel = new Panel();

		public FreddieFrame()
		{

			Color blue = new Color(22, 148, 148);
			Color green = new Color(0, 255, 30);
			setForeground(green);
			setBackground(blue);
			add(drinkPromptLabel);
			add(rootBeerBox);
				rootBeerBox.addItemListener(this);
			add(mtnDewBox);
				mtnDewBox.addItemListener(this);
			add(pepsiBox);
				pepsiBox.addItemListener(this);
			add(costField);
				costField.setEditable(false);
			costField.setText(" ");
			add(order);
			order.addActionListener(this);

			this.setLayout(new BorderLayout());
			northerPanel.setLayout(new GridLayout(2,1));
			northPanel.setLayout(new GridLayout(2,3));
			centerPanel.setLayout(new GridLayout(1,3));
				northerPanel.add(northNamePanel);
				northerPanel.add(northPanel);
			centerCenterPanel.setLayout(new GridLayout(6,1));
			leftCenterPanel.setLayout(new GridLayout(6,1));
			rightCenterPanel.setLayout(new GridLayout(6,1));
			this.add(northerPanel, BorderLayout.NORTH);
				northNamePanel.add(burgerPromptLabel);
				northPanel.add(qtrBox);
					qtrBox.addItemListener(this);
				northPanel.add(halfBox);
					halfBox.addItemListener(this);
				northPanel.add(poundBox);
					poundBox.addItemListener(this);
				northPanel.add(qtrCheeseBox);
					qtrCheeseBox.addItemListener(this);
				northPanel.add(halfCheeseBox);
					halfCheeseBox.addItemListener(this);
				northPanel.add(poundCheeseBox);
					poundCheeseBox.addItemListener(this);

			this.add(centerPanel, BorderLayout.CENTER);
			centerPanel.add(leftCenterPanel);
				leftCenterPanel.add(saucePromptLabel);
				leftCenterPanel.add(mayoBox);
					mayoBox.addItemListener(this);
				leftCenterPanel.add(mustardBox);
					mustardBox.addItemListener(this);
				leftCenterPanel.add(catchupBox);
					catchupBox.addItemListener(this);
				leftCenterPanel.add(spiceBox);
					spiceBox.addItemListener(this);
			centerPanel.add(centerCenterPanel);
				centerCenterPanel.add(solidPromptLabel);
				centerCenterPanel.add(lettuceBox);
					lettuceBox.addItemListener(this);
				centerCenterPanel.add(onionsBox);
					onionsBox.addItemListener(this);
				centerCenterPanel.add(picklesBox);
					picklesBox.addItemListener(this);
				centerCenterPanel.add(baconBox);
					baconBox.addItemListener(this);
			centerPanel.add(rightCenterPanel);
				rightCenterPanel.add(drinkPromptLabel);
				rightCenterPanel.add(mtnDewBox);
					mtnDewBox.addItemListener(this);
				rightCenterPanel.add(rootBeerBox);
					rootBeerBox.addItemListener(this);
				rightCenterPanel.add(pepsiBox);
					pepsiBox.addItemListener(this);
				rightCenterPanel.add(spriteBox);
					spriteBox.addItemListener(this);
			//add(eastPhotoPanel, BorderLayout.EAST);
			//add(westPhotoPanel, BorderLayout.WEST);
		this.add(southPanel, BorderLayout.SOUTH);
			southPanel.add(priceLabel);
			southPanel.add(priceField);
				priceField.setEditable(false);
			southPanel.add(order);

		burgerPromptLabel.setFont(f);



		}
		public void itemStateChanged(ItemEvent choice)
		{

			cost = 0;

			if(qtrBox.getState())
			{
				cost+= 5;
			}
			if(halfBox.getState())
			{
				cost+= 7;
			}
			if(poundBox.getState())
			{
				cost+= 9;
			}
			if(qtrCheeseBox.getState())
			{
				cost+= 7;
			}
			if(halfCheeseBox.getState())
			{
				cost+= 9;
			}
			if(poundCheeseBox.getState())
			{
				cost+= 11;
			}
			if(mayoBox.getState())
			{
				cost  += .50;
			}

			if(mustardBox.getState())
			{
				cost  += .50;
			}
			if(catchupBox.getState())
			{
				cost += .50;
			}

			if(spiceBox.getState())
			{
				cost  += .50;
			}

			if(picklesBox.getState())
			{
				cost  += .50;
			}

			if(lettuceBox.getState())
			{
				cost  += .50;
			}

			if(onionsBox.getState())
			{
				cost  += .50;
			}

			if(baconBox.getState())
			{
				cost  += .50;
			}

			if(rootBeerBox.getState())
			{
				cost  += 2.00;
			}

			if(mtnDewBox.getState())
			{
				cost  += 2.00;
			}

			if(pepsiBox.getState())
			{
				cost  += 2.00;
			}
			if(spriteBox.getState())
			{
				cost  += 2.00;
			}
			priceField.setText("$"+ df.format(cost));
			invalidate();
			revalidate();
		}
		public void actionPerformed(ActionEvent e)
		{
			if(JOptionPane.showConfirmDialog(null, "Would you like fries with that?","Fries", JOptionPane.YES_NO_OPTION) == 0)
			{
				cost += 2.00;
			}
			priceField.setText("$"+ df.format(cost));
			if(JOptionPane.showConfirmDialog(null, "Would you like to supersize that?","Supersize", JOptionPane.YES_NO_OPTION) == 0)
			{
				cost *= 2.00;
			}
			priceField.setText("$"+ df.format(cost));
			String name = JOptionPane.showInputDialog("Enter your name");
			Random number = new Random();
			int orderNumber = number.nextInt(100);
			JOptionPane.showMessageDialog(null, name + " your cost is now $" + cost +", and your order number is "+ orderNumber);
		}
	}
