import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

public class Contacts extends JFrame implements ActionListener{
	JTextField idF = new JTextField();
	JTextField fNameF = new JTextField();
	JTextField lNameF = new JTextField();
	JTextField emailF = new JTextField();
	JTextField numF = new JTextField();
	
	JLabel idL = new JLabel("Enter ID: ");
	JLabel fNameL = new JLabel("Enter First Name:");
	JLabel lNameL = new JLabel("Enter Last Name:");
	JLabel emailL = new JLabel("Enter Email:");
	JLabel numL = new JLabel("Enter Phone Number:");
	
	JButton add = new JButton("Add Contact");
	JButton view = new JButton("View Contact");
	
	JPanel cen = new JPanel();
	JPanel south = new JPanel();
	
	String input;
	
	ResultSet rs;
	
	String url = "jdbc:ucanaccess://Z:/Computer Science/Sem 3/Chapter 11/Contacts/Contacts.accdb";
	Connection con;
	Statement stmt;
	
	public Contacts(){
		try{
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
		}
		catch(Exception e1){
			System.out.println("Could not make connection");
			e1.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		this.add(cen, BorderLayout.CENTER);
			cen.setLayout(new GridLayout(5,2));
			cen.add(idL);
			cen.add(idF);
			cen.add(fNameL);
			cen.add(fNameF);
			cen.add(lNameL);
			cen.add(lNameF);
			cen.add(emailL);
			cen.add(emailF);
			cen.add(numL);
			cen.add(numF);
		this.add(south, BorderLayout.SOUTH);
			south.setLayout(new GridLayout(1,2));
			south.add(add);
				add.addActionListener(this);
			south.add(view);
				view.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		String id = idF.getText();
		String fName = fNameF.getText();
		String lName = lNameF.getText();
		String email = emailF.getText();
		String num = numF.getText();
		
		if(e.getSource() == add){
			if(id.equals(" ") || fName.equals("") || lName.equals("") || email.equals("") || num.equals("")){
				JOptionPane.showMessageDialog(null, "Please fill out all the fields!");
			}
			else{
				System.out.println(id + " " + fName + " " + lName + " " + email + " " + num);
				try{
					stmt.executeUpdate("INSERT INTO ContactsTable VALUES('" + id + "','" + fName + "','" + lName + "','" + email + "','" + num + "')");
					idF.setText("");
					fNameF.setText("");
					lNameF.setText("");
					emailF.setText("");
					numF.setText("");
				}
				catch(Exception ex){
					System.out.println("Could not add info to the DB");
					ex.printStackTrace();
				}
			}
		}
		if(e.getSource() == view){
			input = " ";
			try {
				rs = stmt.executeQuery("SELECT * FROM ContactsTable");
			} 
			catch (SQLException e1) {
				System.out.println("Could not retrieve data from the db");
				e1.printStackTrace();
			}

			try {
				while(rs.next()){
					input += rs.getString("ID") + "  ";
					System.out.println(input);
					input += rs.getString("FirstName") + "  ";
					System.out.println(input);
					input += rs.getString("LastName")  + "  ";
					System.out.println(input);
					input += rs.getString("Email")  + "  ";
					System.out.println(input);
					input += rs.getString("PhoneNumber") + "\n";
					System.out.println(input);
					
				}
			} 
			catch (SQLException ex) {
				System.out.println("Could not add db data to ArrayList");
				ex.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, input);
		}
	}
	
	public static void main(String[] args){
		Contacts c = new Contacts();
		c.setVisible(true);
		c.setBounds(500,500,500,500);
		c.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
