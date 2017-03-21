import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class OnTime extends JFrame implements ActionListener{

	DataOutputStream ds;

	Date currentDate = new Date();

	JLabel time = new JLabel("Date and Time:");
	JLabel cus = new JLabel("Customer:");
	JLabel address = new JLabel("Address:");
	JLabel tNum = new JLabel("Telephone:");
	JLabel disc = new JLabel("Discription:");

	JTextField timeT = new JTextField();
	JTextField cusT = new JTextField();
	JTextField addressT = new JTextField();
	JTextField tNumT = new JTextField();
	JTextField discT = new JTextField();

	JButton clear = new JButton("Clear");
	JButton cdat = new JButton("Current Date and Time");
	JButton save = new JButton("Save");

	public OnTime(){
		this.setLayout(null);
		this.add(time);
		this.add(timeT);
		time.setBounds(0,10,100,20);
		timeT.setBounds(100,7,200,26);
		this.add(cus);
		this.add(cusT);
		cus.setBounds(0,60,75,20);
		cusT.setBounds(100,57,200,26);
		this.add(address);
		this.add(addressT);
		address.setBounds(0,110,110,20);
		addressT.setBounds(100,107,200,26);
		this.add(tNum);
		this.add(tNumT);
		tNum.setBounds(0,160,80,20);
		tNumT.setBounds(100,157,200,26);
		this.add(disc);
		this.add(discT);
		disc.setBounds(0,210,80,20);
		discT.setBounds(100,207,450,26);
		this.add(cdat);
		cdat.addActionListener(this);
		cdat.setBounds(300,10,170,20);
		this.add(save);
		save.addActionListener(this);
		save.setBounds(500,10,80,30);
		this.add(clear);
		clear.addActionListener(this);
		clear.setBounds(590,10,80,30);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == cdat){
			timeT.setText(currentDate.toString());
		}
		else if(e.getSource() == clear){
			timeT.setText("");
			cusT.setText("");
			addressT.setText("");
			tNumT.setText("");
			discT.setText("");
		}
		else{
			Date today = new Date();
			SimpleDateFormat myFormat = new SimpleDateFormat("MMddyyyy");
			String file =("Dispatch " + myFormat.format(today) + ".txt");
			//String file =("Dispatch.txt");
			System.out.println(file);
			try{
				System.out.println("Im in big papa");
				ds = new DataOutputStream(new FileOutputStream(file));
				ds.writeUTF(timeT.getText());
				ds.writeUTF(cusT.getText());
				ds.writeUTF(addressT.getText());
				ds.writeUTF(tNumT.getText());
				ds.writeUTF(discT.getText());
			}
			catch(Exception ex){}
		}
	}
	public static void main(String[] args){
		OnTime o = new OnTime();
		o.setBounds(50,50,800,300);
		o.setTitle("On-Time Plumbers");
		o.setVisible(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "The UIManager could not set the look and Feel for this application.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}