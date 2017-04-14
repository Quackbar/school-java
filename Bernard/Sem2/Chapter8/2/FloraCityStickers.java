import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FloraCityStickers extends JFrame implements ActionListener{

	JLabel VNum = new JLabel("Enter Vehicle VIN Number:");
	JLabel Year = new JLabel("Year:");
	JLabel Make = new JLabel("Make:");
	JLabel Model = new JLabel("Model:");
	JLabel FName = new JLabel("Enter First Name:");
	JLabel LName = new JLabel("Enter Last Name:");
	JLabel Address = new JLabel("Enter Flora Address:");

	JTextField VNumT = new JTextField();
	JTextField YearT = new JTextField();
	JTextField MakeT = new JTextField();
	JTextField ModelT = new JTextField();
	JTextField FNameT = new JTextField();
	JTextField LNameT = new JTextField();
	JTextField AddressT = new JTextField();

	JButton NSticker = new JButton("New Sticker");
	JButton Renewal = new JButton("Renewal");

	JPanel p = new JPanel();

	public FloraCityStickers(){
		this.add(p);
		Color purple = new Color(163,31,154);
		p.setBackground(purple);
		p.setLayout(null);
		p.add(VNum);
		VNum.setBounds(10,2,150,20);
		p.add(VNumT);
		VNumT.setBounds(9,25,170,20);
		p.add(Year);
		Year.setBounds(190,2,30,20);
		p.add(YearT);
		YearT.setBounds(189,25,50,20);
		p.add(Make);
		Make.setBounds(250,2,50,20);
		p.add(MakeT);
		MakeT.setBounds(249,25,80,20);
		p.add(Model);
		Model.setBounds(340,2,50,20);
		p.add(ModelT);
		ModelT.setBounds(339,25,80,20);
		p.add(FName);
		FName.setBounds(10,50,100,20);
		p.add(FNameT);
		FNameT.setBounds(9,73,150,20);
		p.add(LName);
		LName.setBounds(170,50,100,20);
		p.add(LNameT);
		LNameT.setBounds(169,73,150,20);
		p.add(Address);
		Address.setBounds(10,100,150,20);
		p.add(AddressT);
		AddressT.setBounds(9,123,310,20);
		p.add(NSticker);
		NSticker.addActionListener(this);
		NSticker.setBounds(110,165,110,20);
		p.add(Renewal);
		Renewal.addActionListener(this);
		Renewal.setBounds(225,165,110,20);
	}

	public void actionPerformed(ActionEvent e){
		boolean check = true;
		boolean check1 = true;
		if(e.getSource() == NSticker){
			if(VNumT.getText().equals("")){
				check = false;
				System.out.println(check);
			}
			else if(YearT.getText().equals("")){
				check = false;
				System.out.println(check);
			}
			else if(MakeT.getText().equals("")){
				check = false;
				System.out.println(check);
			}
			else if(ModelT.getText().equals("")){
				check = false;
				System.out.println(check);
			}
			else if(FNameT.getText().equals("")){
				check = false;
				System.out.println(check);
			}
			else if(LNameT.getText().equals("")){
				check = false;
				System.out.println(check);
			}
			else if(AddressT.getText().equals("")){
				check = false;
				System.out.println(check);
			}
			if(check == false){
				JOptionPane.showMessageDialog(null,"You must fill out all the fields");
			}
			else{
				JOptionPane.showMessageDialog(null,"Your sticker is being created!");
				VNumT.setText(" ");
				YearT.setText(" ");
				MakeT.setText(" ");
				ModelT.setText(" ");
				FNameT.setText(" ");
				LNameT.setText(" ");
				AddressT.setText(" ");
			}
		}
		else{
			if(VNumT.getText().equals("")){
				check1 = false;
			}
			else if(YearT.getText().equals("")){
				check1 = false;
			}
			else if(MakeT.getText().equals("")){
				check1 = false;
			}
			else if(ModelT.getText().equals("")){
				check1 = false;
			}
			else if(FNameT.getText().equals("")){
				check1 = false;
			}
			else if(LNameT.getText().equals("")){
				check1 = false;
			}
			else if(AddressT.getText().equals("")){
				check1 = false;
			}
			if(check1 == false){
				JOptionPane.showMessageDialog(null,"You must fill out all the fields");
			}
			else{
				JOptionPane.showMessageDialog(null,"Your sticker is being renewed!");
				VNumT.setText(" ");
				YearT.setText(" ");
				MakeT.setText(" ");
				ModelT.setText(" ");
				FNameT.setText(" ");
				LNameT.setText(" ");
				AddressT.setText(" ");
			}
		}
	}
	public static void main(String[] args){
		FloraCityStickers f = new FloraCityStickers();
		f.setVisible(true);
		f.setBounds(50,50,447,240);
		f.setTitle("Flora City Stickers");
	}

}