import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MakeSnakeDB {

	static Connection con;
	static Statement stmt;
	public static void main(String[] args){
		String url = "jdbc:ucanaccess://L:/SnakeDB.accdb";

		try{
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
		}catch(SQLException e){
			System.out.println("Could not make DB connection");
		}

		//The following code deletes the table if it exists
		//If it does not exist a message is displayed and execution continues
		System.out.println("Dropping Table");

		try{
			stmt.executeUpdate("DROP TABLE HighScoreTable");
		}catch(SQLException e){
			System.out.println("Could not drop HighScore Table:" + e.getMessage());
		}

		//Create HighScore Table
		System.out.println("Creating HighScore Table");

		try{
			stmt.executeUpdate("CREATE TABLE HighScoreTable(Username TEXT(30) NOT NULL, HighScore INTEGER)");
		}catch(SQLException e){
			System.out.println("Exception creating high score table:" + e.getMessage());
		}

		//Populate the table with beginning values
		try{
			for(int i = 0; i < 10; i++){
				stmt.executeUpdate("INSERT INTO HighScoreTable VALUES(' ', '0')");
			}
		}catch(SQLException e){
			System.out.println("Exception creating high score table:" + e.getMessage());
		}
		try{
		stmt.close();
		con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
