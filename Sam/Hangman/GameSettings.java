import java.awt.*;
import javax.swing.*;

public abstract class GameSettings
{
	protected int difficulty;
	private Object[] options = {"Hard", "Medium", "Easy"};

	public int getDifficulty()
	{
		return difficulty;
	}
	public void setDifficulty(int diff)
	{
		difficulty = diff;
	}

	public void userSetDifficulty()
	{
		difficulty = JOptionPane.showOptionDialog(null, "Choose Difficulty","Difficulty", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[2]);
	}

	public abstract void setDrawPanelColor(Color dpColor);
	public abstract void setPanelColor(Color pColor);
	public abstract void setPenColor(Color penColor);
}