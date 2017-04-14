
package webstocks;

import java.sql.*;
import java.io.*;

public class MakeDB {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:ucanaccess://C:/Users/bkintzing/workspace/StockTrackerDB.accdb";

		Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();

		// The following code deletes each index and table, if they exist
		// If they do not exist, a message is displayed and execution continues
		System.out.println("Dropping indexes and tables...");

		try { 
			stmt.executeUpdate("DROP TABLE UserStocks");
		} catch (Exception e) {
			System.out.println("Could not drop UserStock table: " + e.getMessage());
		} 

		 /*try //comment this out AFTER first run
		  { 
		  	stmt.executeUpdate("DROP TABLE Users"); 
		  } 
		  catch (Exception e) 
		  {
		  	System.out.println("Could not drop Users table: " + e.getMessage());
		  }*/

		try {
			stmt.executeUpdate("DROP TABLE Stocks");
		} catch (Exception e) {
			System.out.println("Could not drop Stocks table: " + e.getMessage());
		}

		////////// Create the database tables \\\\\\\\\\
		System.out.println("\nCreating tables .......... ");

		// Create Stocks table with primary index
		try {
			System.out.println("Creating Stocks table with primary key index...");
			stmt.executeUpdate("CREATE TABLE Stocks(" + "symbol TEXT(8) NOT NULL "
					+ "CONSTRAINT PK_Stocks PRIMARY KEY, " + "name TEXT(50)" + ")");
		} catch (Exception e) {
			System.out.println("Exception creating Stock table: " + e.getMessage());
		}

		// Create Users table with primary key index
		try {
			System.out.println("Creating Users table with primary key index");
			stmt.executeUpdate(
					"CREATE TABLE Users(userID TEXT(20) NOT NULL CONSTRAINT PK_Users PRIMARY KEY, lastName TEXT(30) NOT NULL, firstName TEXT(30) NOT NULL, pswd OLE, admin BIT )");
		} catch (Exception e) {
			System.out.println("Exception creating Users table: ");
		}

		// Create UserStocks table with a primary key and foreign keys to Users
		// and Stocks tables
		try {
			System.out.println("Creating UserStocks table...");
			stmt.executeUpdate(
					"CREATE TABLE UserStocks (userID TEXT(20) CONSTRAINT FK1_UserStocks REFERENCES Users (userID), symbol TEXT(8), CONSTRAINT FK2_UserStocks FOREIGN KEY (symbol) REFERENCES Stocks(symbol), CONSTRAINT PK_UserStocks PRIMARY KEY(userID, symbol))");
		} catch (Exception e) {
			System.out.println("Exception creating UserStocks table: " + e.getMessage());
		}

		try
		{
			System.out.println("Creating StockTrades table . . .");
			stmt.executeUpdate(
					"CREATE TABLE StockTrades (userID TEXT(20) NOT NULL, StockName TEXT(20) NOT NULL, NumOfShares INTEGER NOT NULL, SharePrice NUMBER NOT NULL, TotalPrice NUMBER NOT NULL, BoughtOrSold TEXT(6) NOT NULL, Date TEXT(30) NOT NULL)");
		} catch (Exception e) {
			System.out.println("Exception creating UserTrades table: " + e.getMessage());
		}
		
		// Create one admin user with password as initial data
		String userID = "admin01";
		String firstName = "Default";
		String lastName = "Admin";
		String initialPswd = "admin01";
		Password pswd = new Password(initialPswd);
		boolean admin = true;

		PreparedStatement pStmt = con.prepareStatement("INSERT INTO Users VALUES (?,?,?,?,?)");

		try {
			pStmt.setString(1, userID);
			pStmt.setString(2, lastName);
			pStmt.setString(3, firstName);
			pStmt.setBytes(4, serializeObj(pswd));
			pStmt.setBoolean(5, admin);
			pStmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception inserting user: " + e.getMessage());
		}

		pStmt.close();

		// Read and display all User data in the database
		ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

		System.out.println("Database created.\n");
		System.out.println("Displaying data from database...\n");
		System.out.println("Users table contains");

		Password pswdFromDB;
		byte[] buf = null;

		while (rs.next()) {
			System.out.println("Logon ID       		=" + rs.getString("userID"));
			System.out.println("First name		=" + rs.getString("firstName"));
			System.out.println("Last name      		=" + rs.getString("lastName"));
			System.out.println("Administrative		=" + rs.getBoolean("admin"));
			System.out.println("Initial password	=" + initialPswd);

			buf = rs.getBytes("pswd");
			if (buf != null) {
				System.out.println("Password Object	= " + (pswdFromDB = (Password) deserializedObj(buf)));
				System.out.println("AutoExpires	= " + pswdFromDB.getAutoExpires());
				System.out.println("Expiring now	= " + pswdFromDB.isExpiring());
				System.out.println("Remaining uses	= " + pswdFromDB.getRemainingUses());
			} else {
				System.out.println("Password Object = NULL!");
			}
		}
		rs = stmt.executeQuery("SELECT * FROM Stocks");
		if (!rs.next())
			System.out.println("Stocks table contains no records");
		else
			System.out.println("Stocks table still contains records");

		rs = stmt.executeQuery("SELECT * FROM UserStocks");
		if (!rs.next())
			System.out.println("UserStocks table contains no records");
		else
			System.out.println("UserStocks table still contains records");
		stmt.close();
	}// end of main

	public static byte[] serializeObj(Object obj) throws IOException {
		ByteArrayOutputStream baOStream = new ByteArrayOutputStream();
		ObjectOutputStream toilet = new ObjectOutputStream(baOStream);

		toilet.writeObject(obj);
		toilet.flush();
		toilet.close();
		return baOStream.toByteArray();
	}

	public static Object deserializedObj(byte[] buf) throws IOException, ClassNotFoundException {
		Object obj = null;
		if (buf != null) {
			ObjectInputStream objIStream = new ObjectInputStream(new ByteArrayInputStream(buf));
			obj = objIStream.readObject();
		}
		return obj;
	}
}