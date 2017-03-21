import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DuckDynasty extends JFrame implements ActionListener{
	FileChannel fcIn = null;
	Path P1 = Paths.get(".\\Duckies.txt");

	JButton submitButton = new JButton("Submit");
	JButton viewButton = new JButton("View Duckies");

	String submit;
	String[] submits;
	String delimiter = ",";

	JLabel firstLabel = new JLabel("Enter ducky ID: "), secondLabel = new JLabel("Enter ducky Name: "), thirdLabel = new JLabel("Enter ducky color: "), fourthLabel = new JLabel("Enter smack of: ");
	JTextField firstTextField  = new JTextField(), secondTextField  = new JTextField(), thirdTextField  = new JTextField(), fourthTextField  = new JTextField();

	public static void checkDuckyID(String string){

	}

	public Container createContentPane(){

/*		try{
			fcIn = (FileChannel)Files.newByteChannel(P1, CREATE, WRITE);
		}catch(Exception e){}*/

		submitButton.addActionListener(this);
		viewButton.addActionListener(this);

		JPanel MainPanel = new JPanel();
			MainPanel.setLayout(new GridLayout(4,2));
			MainPanel.add(firstLabel);
			MainPanel.add(firstTextField);
			MainPanel.add(secondLabel);
			MainPanel.add(secondTextField);
			MainPanel.add(thirdLabel);
			MainPanel.add(thirdTextField);
			MainPanel.add(fourthLabel);
			MainPanel.add(fourthTextField);

		JPanel ButtonPanel = new JPanel();
			ButtonPanel.setLayout(new GridLayout(1,2));
			ButtonPanel.add(submitButton);
			ButtonPanel.add(viewButton);

		Container c = getContentPane();
			c.setLayout(new BorderLayout(0,0));
			c.add(MainPanel,BorderLayout.CENTER);
			c.add(ButtonPanel,BorderLayout.SOUTH);
		return c;
	}

	public DuckDynasty(){
		super("Input Duckies");
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == submitButton){
			submit = submit + "ID #" + firstTextField.getText() + delimiter + "Name:" + secondTextField.getText() + delimiter + "Color:" + thirdTextField.getText() + delimiter + "Smack Of:" + fourthTextField.getText();
			submits = submit.split(delimiter);
			byte data[] = submit.getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(data);
			try{
				fcIn.write(buffer);
			}catch(Exception y){}
		}
		else if(e.getSource() == viewButton){
			int entries =1;
//			for(int i; i<entries;i++){
//				String[] info;
//				String line = i;
/*				try{
					BufferedReader reader = new BufferedReader(new FileReader(".//Duckies.txt"));
					line = reader.readLine();
				}catch(Exception r){}
				info = line.split(delimiter);*/

				//JOptionPane.showMessagedialog(null, info);
//			}
		}
	}
	public static void main(String[] args){
		DuckDynasty d = new DuckDynasty();
		d.setContentPane(d.createContentPane());
		d.setSize(500,200);
		d.setVisible(true);
	}
}