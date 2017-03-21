//Instance class used to create a game object
public class Game
{
	//data fields

	//private = only this class can directly access & change them
	private String gameName;
	private int score;
	private String playerName;

	//get method (accessors)
	public String getGameName()
	{
		return gameName;
	}

	public int getScore()
	{
		return score;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	//set method (mutators)
	public void setGameName(String gName)
	{
		gameName = gName;
	}

	public void setScore(int scor)
	{
		score = scor;
	}

	public void setPlayerName(String pName)
	{
		playerName = pName;
	}
}