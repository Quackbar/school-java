public class Card
{
	private final String suit;
	private final int value;
	private final boolean faceCard;
	private final String name;

	public Card(String theName, String theSuit, int theValue)
	{
		name = theName;
		suit = theSuit;
		value = theValue;

		if(name.equals("Jack") || name.equals("Queen") || name.equals("King"))
		{
			faceCard = true;
		}
		else
		{
			faceCard = false;
		}
	}

	public boolean isFaceCard()
	{
		return faceCard;
	}
	public String getName()
	{
		return name;
	}
	public String getSuit()
	{
			return suit;
	}
	public int getValue()
	{
		return value;
	}

	public String getColor()
	{
		if(suit.equals("Hearts") || suit.equals("Diamonds"))
		{
			return "Red";
		}
		else
		{
			if(suit.equals("Joker"))
			{
				if(name.equals("#1"))
				{
					return "Red";
				}
				else
				{
					return "Black";
				}
			}
			else
			{
				return "Black";
			}
		}
	}

	public String toString()
	{
		if(suit.equals("Joker"))
		{
			return suit + " " + name;
		}
		else
		{
			return name + " of " + suit;
		}
	}

	public String getFileName()
	{
		int cardNumber;
		int offset;
		int suitVal = 0;

		switch(name)
		{
			case "Ace":
				offset = 0;
				break;
			case "King":
				offset = 1;
				break;
			case "Queen":
				offset = 2;
				break;
			case "Jack":
				offset = 3;
				break;
			case "Ten":
				offset = 4;
				break;
			case "Nine":
				offset = 5;
				break;
			case "Eight":
				offset = 6;
				break;
			case "Seven":
				offset = 7;
				break;
			case "Six":
				offset = 8;
				break;
			case "Five":
				offset = 9;
				break;
			case "Four":
				offset = 10;
				break;
			case "Three":
				offset = 11;
				break;
			case "Two":
				offset = 12;
				break;
			default:
				offset = 13; //Them Jokers
		}
		switch(suit)
		{
			case "Clubs": case "#1": // Red Joker
				suitVal = 1;
				break;
			case "Spades": case "#2": //Black Joker
				suitVal = 2;
				break;
			case "Hearts":
				suitVal = 3;
				break;
			case "Diamonds":
				suitVal = 4;
				break;
		}
		cardNumber = offset * 4 + suitVal;
		return cardNumber + ".png";
	}
}

