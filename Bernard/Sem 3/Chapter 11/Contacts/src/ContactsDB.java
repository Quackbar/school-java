import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactsDB {
	public static void main(String[] args) throws Exception{
	String url = "jdbc:ucanaccess://Z:/Computer Science/Sem 3/Chapter 11/Contacts/Contacts.accdb";
	Connection con = null;
	Statement stmt = null;

		try{
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
		}
		catch(Exception e1){
			System.out.println("Could not make connection");
			e1.printStackTrace();
		}
		
		try{
			stmt.executeUpdate("CREATE TABLE ContactsTable(ID TEXT(10) NOT NULL, FirstName TEXT(15) NOT NULL, LastName TEXT(15) NOT NULL, Email TEXT(25) NOT NULL, PhoneNumber TEXT(12) NOT NULL)");
		}
		catch(SQLException e2){
			System.out.println("Could not create DB");
			e2.printStackTrace();

		}
	}
}
