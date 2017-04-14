import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class PegSolitaire extends JFrame implements ActionListener
{
	JMenuBar mBar = new JMenuBar();

	JMenu mHelp = new JMenu("Help");
	JMenuItem mHelpDirections = new JMenuItem("Directions");
	JMenuItem mHelpAbout = new JMenuItem("About");

	JMenu mSettings = new JMenu("Settings");
	JMenu mSettingsDifficulty = new JMenu("Difficulty");
	JMenuItem mSettingsDifficultyNotCenter = new JMenuItem("One Peg Left");
	JMenuItem mSettingsDifficultyCenter = new JMenuItem("One Peg Left in Center");

	JMenu mSettingsPegLayout = new JMenu("Peg Layout");
	JMenuItem mSettingsPegLayoutDiamond = new JMenuItem("Diamond");
	JMenuItem mSettingsPegLayoutPlus = new JMenuItem("Plus");
	JMenuItem mSettingsPegLayoutPyramid = new JMenuItem("Pyramind");

	JTextPane textPane;
	JPanel dPanel;
	//static ButtonPanel[] buttons = new ButtonPanel[33];
	static JPanel[][] board = new JPanel[7][7];
	static boolean centerFlag = false;

	public PegSolitaire()
	{
		setJMenuBar(mBar);
		mHelp.setMnemonic(KeyEvent.VK_H);
		mHelp.setDisplayedMnemonicIndex(0);
		mBar.add(mHelp);

		mHelpDirections.setMnemonic(KeyEvent.VK_D);
		mHelpDirections.setDisplayedMnemonicIndex(0);
		mHelpDirections.addActionListener(this);
		mHelp.add(mHelpDirections);

		mHelpAbout.setMnemonic(KeyEvent.VK_A);
		mHelpAbout.setDisplayedMnemonicIndex(0);
		mHelpAbout.addActionListener(this);
		mHelp.add(mHelpAbout);

		mSettings.setMnemonic(KeyEvent.VK_S);
		mSettings.setDisplayedMnemonicIndex(0);
		mBar.add(mSettings);

		mSettingsDifficulty.setMnemonic(KeyEvent.VK_F);
		mSettingsDifficulty.setDisplayedMnemonicIndex(2);
		mSettings.add(mSettingsDifficulty);

		mSettingsDifficultyNotCenter.setMnemonic(KeyEvent.VK_O);
		mSettingsDifficultyNotCenter.setDisplayedMnemonicIndex(0);
		mSettingsDifficultyNotCenter.addActionListener(this);
		mSettingsDifficulty.add(mSettingsDifficultyNotCenter);

		mSettingsDifficultyCenter.setMnemonic(KeyEvent.VK_C);
		mSettingsDifficultyCenter.setDisplayedMnemonicIndex(16);
		mSettingsDifficultyCenter.addActionListener(this);
		mSettingsDifficulty.add(mSettingsDifficultyCenter);

		mSettingsPegLayout.setMnemonic(KeyEvent.VK_P);
		mSettingsPegLayout.setDisplayedMnemonicIndex(0);
		mSettings.add(mSettingsPegLayout);

		mSettingsPegLayoutDiamond.setMnemonic(KeyEvent.VK_I);
		mSettingsPegLayoutDiamond.setDisplayedMnemonicIndex(1);
		mSettingsPegLayoutDiamond.addActionListener(this);
		mSettingsPegLayout.add(mSettingsPegLayoutDiamond);

		mSettingsPegLayoutPlus.setMnemonic(KeyEvent.VK_U);
		mSettingsPegLayoutPlus.setDisplayedMnemonicIndex(2);
		mSettingsPegLayoutPlus.addActionListener(this);
		mSettingsPegLayout.add(mSettingsPegLayoutPlus);

		mSettingsPegLayoutPyramid.setMnemonic(KeyEvent.VK_Y);
		mSettingsPegLayoutPyramid.setDisplayedMnemonicIndex(1);
		mSettingsPegLayoutPyramid.addActionListener(this);
		mSettingsPegLayout.add(mSettingsPegLayoutPyramid);

		this.setLayout(new GridLayout(7,7));
		this.getContentPane().setBackground(new Color(231,56,179));
		createInfoFrame("From the settings menu choose the difficulty, and which game you would like to play.", "TO BEGIN WITH", "fStyle", 62,125,300,400,"Chiller", 32);

	}

	public void createInfoFrame(String message, String title, String style, int x, int y, int width, int height, String fontName, int fontSize)
	{
		textPane = new JTextPane();
		setTabsAndStyles(textPane,fontName,fontSize);
		Document doc = textPane.getDocument();
		try
		{
			doc.remove(0,doc.getLength());
			doc.insertString(doc.getLength(),message,textPane.getStyle(style));
		}
		catch(BadLocationException ble){}
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPane.setEditable(false);
		JFrame iFrame = new JFrame();
		iFrame.setTitle(title);
		iFrame.setContentPane(scrollPane);
		iFrame.setBounds(x,y,width,height);
		iFrame.setAlwaysOnTop(true);
		iFrame.setVisible(true);
	}

	public void setTabsAndStyles(JTextPane textPane, String fontName, int fontSize)
	{
		/*Don't use in this program
		//creates tabs
		TabStop[] tabs = new TabStop[2];
		tabs[0] = new TabStop(150, TabStop.ALIGN_CENTER, TabStop.LEAD_NONE);
		tabs[1] = new TabStop(300, TabStop.ALIGN_DECIMAL, TabStop.LEAD_NONE);
		TabSet tabSet = new TabSet(tabs);

		//set tab style to text pane
		StyleContext tabStyle = StyleContext.getDefaultStyleContext();
		AttributeSet aSet= tabStyle.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabSet);
		textPane.setParagraphAttributes(aSet,false);
		*/

		//set font style
		Style fontStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		Style fStyle = textPane.addStyle("fStyle", fontStyle);
		StyleConstants.setFontFamily(fontStyle,fontName);
		StyleConstants.setItalic(fStyle, true);
		StyleConstants.setBold(fStyle, true);
		StyleConstants.setFontSize(fStyle, fontSize);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == mHelpDirections)
		{
			createInfoFrame("Use your brain...", "DIRECTION", "fStyle", 150,150,400,150,"Chiller", 60);
		}
		else if(e.getSource() == mHelpAbout)
		{
			createInfoFrame("Created by your one and only 6th period royalties\n March 4 2015", "ABOUT", "fStyle", 150,150,750,200,"Chiller", 40);
		}
		else if(e.getSource() == mSettingsDifficultyNotCenter)
		{
			centerFlag = false;
		}
		else if(e.getSource() == mSettingsDifficultyCenter)
		{
			centerFlag = true;
		}
		else
		{
			//get the number of the components on the ContentPAne of the JFrame to see if there are any to remove
			Component[] components = this.getContentPane().getComponents();
			if(components.length >0)
			{
				for(int j = 0; j < board.length; j++)
				{
					for(int k = 0; k< board[0].length; k ++)
					{
						this.remove(board[j][k]);
					}
				}
			}
			if(e.getSource() == mSettingsPegLayoutDiamond)
			{
				//new DiamondBoard();
			}
			else if(e.getSource() == mSettingsPegLayoutPlus)
			{
				new PlusBoard();
			}
			else if(e.getSource() == mSettingsPegLayoutPyramid)
			{
				//new PyramidBoard();
			}
			for(int j = 0; j < board.length; j++)
			{
				for(int k = 0; k < board[0].length; k++)
				{
					this.add(board[j][k]);
				}
			}
			invalidate();
			validate();
		}
	}

	public static void main(String args[])
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		PegSolitaire f1 = new PegSolitaire();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setTitle("Peg Solitaire");
		f1.setBounds(0,0,420,500);
		f1.setVisible(true);
	}
}
