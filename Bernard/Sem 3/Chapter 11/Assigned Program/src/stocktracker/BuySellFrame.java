package stocktracker;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class BuySellFrame extends JFrame implements ActionListener, STAction{
	
	JPanel main = new JPanel(), moreMain = new JPanel();
	JTextField stocks = new JTextField(), numShares = new JTextField();
	JLabel stockName = new JLabel("Enter Name of Stock");
	JLabel numSharesL = new JLabel("Enter the Number of Shares");
	JLabel price = new JLabel(), totalPrice = new JLabel();
	JButton buyS = new JButton("Buy Stock"), sellS = new JButton("Sell Stock");
	
	Activator caller = null;
	
	double priceDub = 13.00;
	
	static Connection con;
	static Statement stmt;
	static String url =  "jdbc:ucanaccess://Z:/Computer Science/Sem 3/Chapter 11/Assigned Program/StockTrackerDB2.accdb";
	
	public BuySellFrame( Activator callerObj){
		caller = callerObj;
		this.setBounds(300,300,350,150);
		this.add(moreMain);
		moreMain.setLayout(new BorderLayout());
		moreMain.add(main, BorderLayout.CENTER);
		main.setLayout(new GridLayout(4,2,5,5));
		main.add(stockName);
		main.add(numSharesL);
		main.add(stocks);
		main.add(numShares);
		main.add(price);
			price.setText(String.valueOf("Stock Price = $" + priceDub));
		main.add(totalPrice);
			totalPrice.setText("");
		main.add(buyS);
		main.add(sellS);
		buyS.addActionListener(this);
		sellS.addActionListener(this);
		
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
	
	public void actionPerformed(ActionEvent e){
		try{
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Could not connect to the Stock DataBase");
		}
		
		String BorS;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		String date = (dateFormat.format(cal.getTime()));
		int tot = (int) (priceDub * Integer.parseInt(numShares.getText()));
		
		if(e.getSource() == buyS){
			BorS = "Bought";
			try{
				System.out.println(StockTracker.username);
				System.out.println(stocks.getText());
				System.out.println(BorS);
				System.out.println(numShares.getText());
				System.out.println(priceDub);
				System.out.println(tot);
				System.out.println(date);
				stmt.executeUpdate("INSERT INTO StockTrades VALUES('" + StockTracker.username + "','" + stocks.getText() + "','" + BorS + "','" + numShares.getText() + "','" + priceDub + "','" + tot + "','" + date+ "')");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "The " + stocks.getText() + " stock has been bought."); 
				setVisible(false);
				dispose();
				caller.activate();
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
				ex.printStackTrace();
			}
		}
		else if(e.getSource() == sellS){
			BorS = "Sold";
			try{
				stmt.executeUpdate("INSERT INTO StockTrades VALUES('" + StockTracker.username + "','" + stocks.getText() + "','" + BorS + "','" + numShares.getText() + "','" + priceDub + "','" + tot + "','" + date+ "')");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "The " + stocks.getText() + " stock has been sold."); 
				setVisible(false);
				dispose();
				caller.activate();
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Could not List Transaction");
			}
		}
	}

}
