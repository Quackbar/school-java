package stocktracker;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

public class ListTransFrame extends JFrame implements STAction{
	
	static Connection con;
	static Statement stmt; 
	static String url =  "jdbc:ucanaccess://Z:/Computer Science/Sem 3/Chapter 11/Assigned Program/StockTrackerDB2.accdb";
	
	JLabel UserID = new JLabel("User's Name");
	JLabel Stock = new JLabel("Stock Name");
	JLabel BorS = new JLabel("Bought or Sold");
	JLabel numShares = new JLabel("Num of Shares");
	JLabel PPS = new JLabel("Price Per Share");
	JLabel totalPrice = new JLabel("Total Price");
	JLabel date = new JLabel("Date of Trans.");
	
	JLabel Jl1 = new JLabel("------------------------");
	JLabel Jl2 = new JLabel("------------------------");
	JLabel Jl3 = new JLabel("------------------------");
	JLabel Jl4 = new JLabel("------------------------");
	JLabel Jl5 = new JLabel("------------------------");
	JLabel Jl6 = new JLabel("------------------------");
	JLabel Jl7 = new JLabel("------------------------");
	
	JPanel mainPan = new JPanel();
	JPanel northPan = new JPanel();
	
	Activator caller = null;
	
	int size;
	
	public ListTransFrame( Activator callerObj){
		
		String search = JOptionPane.showInputDialog("Enter the name of the user you wish to search by, or enter all to show all");
		caller = callerObj;
		this.setBounds(300,300,690,225);
		try{
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM StockTrades");
			rs = stmt.executeQuery("SELECT COUNT(*) FROM StockTrades");
		    rs.next();
		    int rowCount = rs.getInt(1);
		    System.out.println(rowCount);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Could not connect to the Stock DataBase");
			ex.printStackTrace();
		}
		 
		this.setLayout(new BorderLayout());
		this.add(mainPan, BorderLayout.CENTER);
				
			ArrayList al = new ArrayList();
			try{
				ResultSet rs = stmt.executeQuery("SELECT userID, Stock, BoughtOrSold, Shares, PricePerShare, TotalPrice, Date " + "FROM StockTrades ORDER BY Date");
	
			    while(rs.next()){
			    	if(search.equals("all")){
			    		al.add(rs.getString("userID") + "\t     " + rs.getString("Stock") + "\t            " + rs.getString("BoughtOrSold") + "\t                  " + String.valueOf(rs.getInt("Shares") + "\t               " + String.valueOf(rs.getInt("PricePerShare") + "\t                  " + String.valueOf(rs.getInt("TotalPrice") + "\t                " + rs.getString("Date")))));
			    	}
			    	else{
			    		if(rs.getString("userID").equals(search)){
			    			al.add(rs.getString("userID") + "\t     " + rs.getString("Stock") + "\t            " + rs.getString("BoughtOrSold") + "\t                  " + String.valueOf(rs.getInt("Shares") + "\t               " + String.valueOf(rs.getInt("PricePerShare") + "\t                  " + String.valueOf(rs.getInt("TotalPrice") + "\t                " + rs.getString("Date")))));
			    		}
			    		else{}
			    	}
			    }
	
			    rs.close();
			    stmt.close();
			}
			catch(Exception ex){}
			JTextArea textArea = new JTextArea(12,60); // rows, cols

	        Insets margins = new Insets(5,5,2,2); // top,left,bottom,right margins
	        textArea.setMargin(margins);
	        textArea.setLineWrap(false);
	        textArea.setEditable(false);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
			for(int i = 0; i< al.size(); i++){
				System.out.println(al.get(i));
				//textArea.setText(textArea.getText() + (String) al.get(i) + "\n");
				textArea.append("\n" + al.get(i));
			}
			mainPan.add(areaScrollPane);
			invalidate();
			validate();
			
		this.add(northPan, BorderLayout.NORTH);
			northPan.setLayout(new GridLayout(2,6));
			northPan.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			northPan.add(UserID);
			northPan.add(Stock);
			northPan.add(BorS);
			northPan.add(numShares);
			northPan.add(PPS);
			northPan.add(totalPrice);
			northPan.add(date);
			northPan.add(Jl1);
			northPan.add(Jl2);
			northPan.add(Jl3);
			northPan.add(Jl4);
			northPan.add(Jl5);
			northPan.add(Jl6);
			northPan.add(Jl7);
			
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					setVisible(false);
					dispose();
					caller.activate();
				}
			}
		);
	}
}
