import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import java.io.*;
import java.text.*;

public class BlackJackGUI extends JFrame
{
	Deck myDeck = new Deck(false,0,10,11);
	boolean gameOver = false, playerWin = false, playerStand = false, dealerStand = false;
	int counter = 1, credits = 100, winnings = 10;
	ArrayList<Card> dealerCards = new ArrayList<Card>();
	ArrayList<Card> playerCards = new ArrayList<Card>();
	String lastPlay;
	JPanel contentPane;
	JLabel playerCardsLabel, dealerCardsLabel, feedbackLabel, creditsLabel, moneyLabel, lastWinLabel, winningsLabel;
	JButton hitButton, standButton, newGameButton;
	JLabel[] pCardLabels = new JLabel[10];
	JLabel[] dCardLabels = new JLabel[6];
	DataOutputStream oStream;
	DataInputStream iStream;
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	public BlackJackGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340,150,615,640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		playerCardsLabel = new JLabel("Player Cards");
		playerCardsLabel.setForeground(Color.blue);
		playerCardsLabel.setFont(new Font("CASTELLAR", Font.BOLD, 11));
		playerCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerCardsLabel.setBounds(15,16,109,29);
		contentPane.add(playerCardsLabel);

		dealerCardsLabel = new JLabel("Dealer Cards");
		dealerCardsLabel.setForeground(Color.blue);
		dealerCardsLabel.setFont(new Font("CASTELLAR", Font.BOLD, 11));
		dealerCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dealerCardsLabel.setBounds(15,218,109,29);
		contentPane.add(dealerCardsLabel);

		feedbackLabel = new JLabel("");
		feedbackLabel.setForeground(Color.red);
		feedbackLabel.setFont(new Font("CASTELLAR", Font.BOLD, 11));
		feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		feedbackLabel.setBounds(92,378,338,29);
		contentPane.add(feedbackLabel);

		hitButton = new JButton("Player Hits");
		hitButton.setFont(new Font("CASTELLAR", Font.BOLD, 11));
		hitButton.setBackground(Color.green);
		hitButton.setForeground(Color.blue);
		hitButton.setBounds(15,452,173,42);
		contentPane.add(hitButton);
		hitButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				Card nextCard = null;
				if(!playerStand && !gameOver)
				{
					nextCard = myDeck.dealCard();
					playerCards.add(nextCard);

					if(calculatePoints(playerCards) >= 21)
					{
						if(calculatePoints(playerCards) == 21)
						{
							gameOver = true;
							playerWin = true;
							winnings *= 2;
							lastPlay = "Player wins with 21";
						}
						else
						{
							gameOver = true;
							playerWin = false;
							lastPlay = "Player busted with " + calculatePoints(playerCards);
						}
						feedbackLabel.setText(lastPlay);
						displayDealerCards();
						if(!playerWin)
						{
							winnings = -10;
						}
						credits += winnings;
						moneyLabel.setText(Integer.toString(credits));
						winningsLabel.setText(Integer.toString(winnings));
					}
					displayPlayerCards();
					myUpdate();
				}
			}
		});

		standButton = new JButton("Player Stands");
		standButton.setFont(new Font("CASTELLAR", Font.BOLD, 11));
		standButton.setBackground(Color.red);
		standButton.setForeground(Color.blue);
		standButton.setBounds(203,452,173,42);
		contentPane.add(standButton);
		standButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				playerStand = true;
				while(!gameOver)
				{
					if(calculatePoints(playerCards) >= 21 || calculatePoints(dealerCards) >= 21 || dealerStand)
					{
						//Someone won
						if(dealerStand)
						{
							gameOver = true;//dealer wins
							playerWin = false;
							lastPlay = "Dealer wins with " + calculatePoints(dealerCards);
						}
						else
						{
							if(calculatePoints(playerCards) > 21)
							{
								gameOver = true; //playerBusted
								playerWin = false;
								lastPlay = "Dealer wins, Player busted with " + calculatePoints(playerCards);
							}
							else
							{
								if(calculatePoints(dealerCards) > 21)
								{
									gameOver = true; //dealerBusted
									playerWin = true;
									lastPlay = "Player wins, Dealer busted with " + calculatePoints(dealerCards);
								}
								else
								{
									if(calculatePoints(playerCards) == 21)
									{
										gameOver = true;
										playerWin = true;
										winnings *= 2;
										lastPlay = "Player wins with 21";
									}
									else
									{
										if(calculatePoints(dealerCards) == 21)
										{
											gameOver = true; //dealerWins
											playerWin = false;
											lastPlay = "Dealer wins with 21";
										}
									}
								}
							}
						}
					}
					else //player stands and dealer must beat player
					{
						if(calculatePoints(playerCards) >= calculatePoints(dealerCards))
						{
							lastPlay = "Dealer draws"; //dealer gets new cards until they have a higher
							Card nextCard = myDeck.dealCard();
							dealerCards.add(nextCard);
						}
						else
						{
							dealerStand = true;
							lastPlay = "Dealer Stands";
						}
					}
					displayDealerCards();
					myUpdate();
				}

				feedbackLabel.setText(lastPlay);
				displayDealerCards();
				if(!playerWin)
				{
					winnings = -10;
				}
				credits += winnings;
				moneyLabel.setText(Integer.toString(credits));
				winningsLabel.setText(Integer.toString(winnings));
			}
		});

		newGameButton = new JButton("New Game");
		newGameButton.setFont(new Font("CASTELLAR", Font.BOLD, 11));
		newGameButton.setBackground(Color.yellow);
		newGameButton.setForeground(Color.blue);
		newGameButton.setBounds(391,452,173,42);
		contentPane.add(newGameButton);
		newGameButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				myDeck = new Deck(false,0,10,1);
				gameOver = false;
				playerWin = false;
				playerStand = false;
				dealerStand = false;
				counter = 1;
				winnings = 10;
				dealerCards = new ArrayList<Card>();
				playerCards = new ArrayList<Card>();
				dealerCards.add(myDeck.dealCard());
				playerCards.add(myDeck.dealCard());
				dealerCards.add(myDeck.dealCard());
				playerCards.add(myDeck.dealCard());
				lastPlay = "New Game";
				displayPlayerCards();
				displayDealerCards();
				myUpdate();
				feedbackLabel.setText("");
			}
		});

		creditsLabel = new JLabel("Credits");
		creditsLabel.setFont(new Font("CASTELLAR", Font.BOLD, 14));
		creditsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditsLabel.setBounds(40,532,84,36);
		contentPane.add(creditsLabel);

		try
		{
			iStream = new DataInputStream(new FileInputStream("BlackJackCredits.txt"));
			credits = iStream.readInt();
			String stringDate = iStream.readUTF();
			JOptionPane.showMessageDialog(null, "Date Saved: " + stringDate + "\n" + "Credits Saved: " + credits, "Credits", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null, "There was no credits saved. You will start with 100", "Credits", JOptionPane.WARNING_MESSAGE);
		}
		moneyLabel = new JLabel(Integer.toString(credits));
		moneyLabel.setForeground(Color.red);
		moneyLabel.setFont(new Font("Impact", Font.BOLD, 18));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setBounds(169,532,90,36);
		contentPane.add(moneyLabel);

		lastWinLabel = new JLabel("Last Hand");
		lastWinLabel.setFont(new Font("CASTELLAR", Font.BOLD, 12));
		lastWinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastWinLabel.setBounds(288,541,90,20);
		contentPane.add(lastWinLabel);

		winningsLabel = new JLabel("");
		winningsLabel.setForeground(Color.red);
		winningsLabel.setFont(new Font("Impact", Font.BOLD, 18));
		winningsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winningsLabel.setBounds(444,541,69,20);
		contentPane.add(winningsLabel);


		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					JOptionPane.showMessageDialog(null, Integer.toString(credits) + " credits will be saved", "Saving", JOptionPane.INFORMATION_MESSAGE);
					try
					{
						oStream = new DataOutputStream( new FileOutputStream("BlackJackCredits.txt"));
						String stringDate = dateFormat.format(new Date());
						oStream.writeInt(credits);
						oStream.writeUTF(stringDate);
						JOptionPane.showMessageDialog(null,"Credits saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(IOException ex){}
					dispose();
					System.exit(0);
				}
			}
			);

		playerCards.add(myDeck.dealCard());
		dealerCards.add(myDeck.dealCard());
		playerCards.add(myDeck.dealCard());
		dealerCards.add(myDeck.dealCard());
		lastPlay = "New Game";
		displayPlayerCards();
		displayDealerCards();
	}

	public int calculatePoints(ArrayList<Card> cardsToCheck)
	{
		int points = 0;
		int aceCount = 0;

		for(int x = 0; x< cardsToCheck.size(); x++)
		{
			if(cardsToCheck.get(x).getValue() == 1)
			{
				points += 11;
				aceCount ++;
			}
			else
			{
				points += cardsToCheck.get(x).getValue();
			}
		}
		if(aceCount> 0 && points > 21)
		{
			points -=10;
		}
		if(aceCount> 1 && points > 21)
		{
			points -=10;
		}
		if(aceCount> 2 && points > 21)
		{
			points -=10;
		}
		if(aceCount == 4 && points > 21)
		{
			points -=10;
		}
		return points;
	}

	public void displayDealerCards()
	{
		for(int i = 0; i< dCardLabels.length; i++)
		{
			if(dCardLabels[i] != null)
			{
				contentPane.remove(dCardLabels[i]); //Remove previous Cards
			}
		}
		if(counter == 1)
		{
			java.net.URL imgURL = getClass().getResource("b2fv.png");
			if(imgURL != null)
			{
				dCardLabels[0] = new JLabel("Card 1", new ImageIcon(imgURL), JLabel.CENTER);
				dCardLabels[0].setHorizontalTextPosition(JLabel.CENTER);
				dCardLabels[0].setVerticalTextPosition(JLabel.TOP);
				dCardLabels[0].setBounds(10,250,72,120);
				contentPane.add(dCardLabels[0]);
			}

			java.net.URL imgURL1 = getClass().getResource(dealerCards.get(1).getFileName());
			if(imgURL1 != null)
			{
				dCardLabels[1] = new JLabel("Card 2", new ImageIcon(imgURL1), JLabel.CENTER);
				dCardLabels[1].setHorizontalTextPosition(JLabel.CENTER);
				dCardLabels[1].setVerticalTextPosition(JLabel.TOP);
				dCardLabels[1].setBounds(100,250,72,120);
				contentPane.add(dCardLabels[1]);
			}
			counter ++;
		}
		else
		{
			for(int i =0; i < dealerCards.size(); i++)
			{
				if(dCardLabels[i] != null)
				{
					contentPane.remove(dCardLabels[i]); //Remove previous Cards
				}
				java.net.URL imgURL = getClass().getResource(dealerCards.get(i).getFileName());
				if(imgURL != null)
				{
					dCardLabels[i] = new JLabel("Card " + (i + 1), new ImageIcon(imgURL), JLabel.CENTER);
					dCardLabels[i].setHorizontalTextPosition(JLabel.CENTER);
					dCardLabels[i].setVerticalTextPosition(JLabel.TOP);
					dCardLabels[i].setBounds(10 + i * 90,250,72,120);
					contentPane.add(dCardLabels[i]);
				}
			}
		}
	}

	public void displayPlayerCards()
	{
		for(int i = 0; i< pCardLabels.length; i++)
		{
			if(pCardLabels[i] != null)
			{
				contentPane.remove(pCardLabels[i]); //Remove previous Cards
			}
		}

		for(int i =0; i < playerCards.size(); i++)
		{
			java.net.URL imgURL = getClass().getResource(playerCards.get(i).getFileName());
			if(imgURL != null)
			{
				pCardLabels[i] = new JLabel("Card " + (i + 1), new ImageIcon(imgURL), JLabel.CENTER);
				pCardLabels[i].setHorizontalTextPosition(JLabel.CENTER);
				pCardLabels[i].setVerticalTextPosition(JLabel.TOP);
				pCardLabels[i].setBounds(10 + i * 90,50,72,120);
				contentPane.add(pCardLabels[i]);
			}
		}
	}

	private void myUpdate()
	{
		repaint();
	}

	public static void main(String[] args)
	{
		BlackJackGUI f = new BlackJackGUI();
		f.setVisible(true);
	}
}