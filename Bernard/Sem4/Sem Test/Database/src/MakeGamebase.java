import java.sql.*;
import java.io.*;
import javax.swing.*;

public class MakeGamebase
{
	public static void main(String[] args) throws Exception
	{
		

		//String url = "jdbc:odbc:Gamebase";
		String url = "jdbc:ucanaccess://Z:/Computer Science/Sem 4/Sem Test/Gamebase.accdb";
		
		Connection con = null;
		Statement stmt = null;
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
		}
		catch(SQLException e){
			System.out.println("Somthing Wrong ln = 23" + e.getMessage());
		}


		System.out.println("Dropping tables . . .");

		try
		{
			stmt.executeUpdate("DROP TABLE Transactions");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Transactions table couldn't be dropped.", "Deleting Error", JOptionPane.WARNING_MESSAGE);
		}

		try
		{
			stmt.executeUpdate("DROP TABLE Games");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Games table couldn't be dropped.", "Deleting Error", JOptionPane.WARNING_MESSAGE);
		}

		try
		{
			stmt.executeUpdate("DROP TABLE Customers");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Customers table couldn't be dropped.", "Deleting Error", JOptionPane.WARNING_MESSAGE);
		}

		System.out.println("Creating tables . . .");

		try
		{
			stmt.executeUpdate("CREATE TABLE Games(gameID COUNTER NOT NULL CONSTRAINT PK_Games PRIMARY KEY, name TEXT(30) NOT NULL, price double NOT NULL)");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Games table couldn't be created.", "Table Error", JOptionPane.WARNING_MESSAGE);
		}

		try
		{
			stmt.executeUpdate("CREATE TABLE Customers(customerID COUNTER NOT NULL CONSTRAINT PK_Locations PRIMARY KEY, name TEXT(30) NOT NULL, address TEXT(30) NOT NULL, phone TEXT(15) NOT NULL)");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Customers table couldn't be created.", "Table Error", JOptionPane.WARNING_MESSAGE);
		}

		try
		{
			stmt.executeUpdate("CREATE TABLE Transactions(transactionID COUNTER NOT NULL CONSTRAINT PK_Transactions PRIMARY KEY, transDate DATE NOT NULL, gameID int CONSTRAINT FK1_Transactions REFERENCES Games(gameID), customerID int CONSTRAINT FK2_Transactions REFERENCES Customers(customerID))");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Transactions table couldn't be created.", "Table Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}