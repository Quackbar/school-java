import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class AverageGrade extends Applet implements ItemListener, ActionListener
{

	double[] grade = new double[8];

	DecimalFormat df = new DecimalFormat("##.##");

	CheckboxGroup classGroup = new CheckboxGroup();
		Checkbox zeroBox = new Checkbox("Period 0",false,classGroup);
		Checkbox oneBox = new Checkbox("Period 1",false,classGroup);
		Checkbox twoBox = new Checkbox("Period 2",false,classGroup);
		Checkbox threeBox = new Checkbox("Period 3",false,classGroup);
		Checkbox fourBox = new Checkbox("Period 4",false,classGroup);
		Checkbox fiveBox = new Checkbox("Period 5",false,classGroup);
		Checkbox sixBox = new Checkbox("Period 6",false,classGroup);
		Checkbox sevenBox = new Checkbox("Period 7",false,classGroup);
		Checkbox hiddenBox = new Checkbox("",true,classGroup);
		//hiddenBox.setVisible(false);

	Label numClassLabel = new Label("How many classes do you have?");
	Label zeroLabel = new Label("No grade entered.");
	Label oneLabel = new Label("No grade entered.");
	Label twoLabel = new Label("No grade entered.");
	Label threeLabel = new Label("No grade entered.");
	Label fourLabel = new Label("No grade entered.");
	Label fiveLabel = new Label("No grade entered.");
	Label sixLabel = new Label("No grade entered.");
	Label sevenLabel = new Label("No grade entered.");
	Label hiddenLabel1 = new Label("                                      ");
	Label hiddenLabel2 = new Label("    ");
	Label hiddenLabel3 = new Label("     ");

	TextField numClassField = new TextField(5);

	Button calculateButton = new Button("Calculate");

	public void init()
	{
		resize(250,500);
		Color blue = new Color(22, 148, 148);
		setBackground(blue);
		add(numClassLabel);
		add(numClassField);
		add(hiddenLabel1);
		add(zeroBox);
			zeroBox.addItemListener(this);
		add(zeroLabel);
		add(oneBox);
			oneBox.addItemListener(this);
		add(oneLabel);
		add(twoBox);
			twoBox.addItemListener(this);
		add(twoLabel);
		add(threeBox);
			threeBox.addItemListener(this);
		add(threeLabel);
		add(fourBox);
			fourBox.addItemListener(this);
		add(fourLabel);
		add(fiveBox);
			fiveBox.addItemListener(this);
		add(fiveLabel);
		add(sixBox);
			sixBox.addItemListener(this);
		add(sixLabel);
		add(sevenBox);
			sevenBox.addItemListener(this);
		add(sevenLabel);
		add(calculateButton);
			calculateButton.addActionListener(this);

	}

	public void itemStateChanged(ItemEvent classChoice)
	{
		if(zeroBox.getState())
		{
			try
			{
				String zero = (String)JOptionPane.showInputDialog("Enter your grade percentage for your zero period.");
				grade[0] = Integer.parseInt(zero);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percentage sign or decimal!");
				hiddenBox.setState(true);
			}
		}
			zeroLabel.setText("" + grade[0] + "%");

		if(oneBox.getState())
		{
			try
			{
				String one = (String)JOptionPane.showInputDialog("Enter your grade percentage for your first period.");
				grade[1] = Integer.parseInt(one);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percantage sign or decimal!");
				hiddenBox.setState(true);
			}
			oneLabel.setText("" + grade[1] + "%");
		}

		if(twoBox.getState())
		{
			try
			{
				String two = (String)JOptionPane.showInputDialog("Enter your grade percentage for your second period.");
				grade[2] = Integer.parseInt(two);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percentage sign or decimal!");
				hiddenBox.setState(true);
			}
			twoLabel.setText("" + grade[2] + "%");
		}

		if(threeBox.getState())
		{
			try
			{
				String three = (String)JOptionPane.showInputDialog("Enter your grade percentage for your third period.");
				grade[3] = Integer.parseInt(three);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percentage sign or decimal!");
				hiddenBox.setState(true);
			}
			threeLabel.setText("" + grade[3] + "%");
		}

		if(fourBox.getState())
		{
			try
			{
				String four = (String)JOptionPane.showInputDialog("Enter your grade percentage for your fourth period.");
				grade[4] = Integer.parseInt(four);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percentage sign or decimal!");
				hiddenBox.setState(true);
			}
			fourLabel.setText("" + grade[4] + "%");
		}

		if(fiveBox.getState())
		{
			try
			{
				String five = (String)JOptionPane.showInputDialog("Enter your grade percentage for your fifth period.");
				grade[5] = Integer.parseInt(five);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percentage sign or decimal!");
				hiddenBox.setState(true);
			}
			fiveLabel.setText("" + grade[5] + "%");
		}

		if(sixBox.getState())
		{
			try
			{
				String six = (String)JOptionPane.showInputDialog("Enter your grade percentage for your sixth period.");
				grade[6] = Integer.parseInt(six);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percentage sign or decimal!");
				hiddenBox.setState(true);
			}
			sixLabel.setText("" + grade[6] + "%");
		}

		if(sevenBox.getState())
		{
			try
			{
				String seven = (String)JOptionPane.showInputDialog("Enter your grade percentage for your seventh period.");
				grade[7] = Integer.parseInt(seven);
			}
			catch(NumberFormatException a)
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid grade with no percantage sign or decimal!");
				hiddenBox.setState(true);
			}
			sevenLabel.setText("" + grade[7] + "%");
		}
	}

	public void actionPerformed(ActionEvent calculate)
	{
		double sum = 0;
		int classNum = 0;
		double total = 0;

		try
		{
		classNum = Integer.parseInt(numClassField.getText());
		}
		catch(NumberFormatException a)
		{
		}

		if(classNum == 0)
		{
			JOptionPane.showMessageDialog(null,"Please enter the number of classes!");
		}
		else
		{
			for(int i = 0; i<8; i++)
			{
				sum += grade[i];
			}
			total = sum/classNum;
			JOptionPane.showMessageDialog(null,"Your grade average is " + df.format(total) + "%");
		}
	}
}