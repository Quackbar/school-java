import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Menu5 extends Frame implements ActionListener, Runnable
{
    //static JTextArea text = new JTextArea("",3,100,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static JTextArea text = new JTextArea("",3,100);

    Font font = new Font("Verdana", Font.PLAIN, 12);

    Random rand = new Random();

    int red,green,blue, index;
	Color randomColor, inverseColor;

    MenuItem openMenuItem = new MenuItem("Open");
    MenuItem saveMenuItem = new MenuItem("Save");
    MenuItem saveAsMenuItem = new MenuItem("Save As");
    MenuItem cutMenuItem = new MenuItem("Cut");
    MenuItem copyMenuItem = new MenuItem("Copy");
    MenuItem pasteMenuItem = new MenuItem("Paste");
    MenuItem sizeMenuItem = new MenuItem("Size");
    MenuItem fontMenuItem = new MenuItem("Font");
    MenuItem helpMenuItem = new MenuItem("Help");
    MenuItem aboutMenuItem = new MenuItem("About");
    MenuItem redB = new MenuItem("Red");
    MenuItem greenB = new MenuItem("Green");
    MenuItem blueB = new MenuItem("Blue");
    MenuItem cyanB = new MenuItem("Cyan");
    MenuItem magentaB = new MenuItem("Magenta");
    MenuItem orangeB = new MenuItem("Orange");
    MenuItem whiteB = new MenuItem("White");
    MenuItem blackB = new MenuItem("Black");
    MenuItem redF = new MenuItem("Red");
    MenuItem greenF = new MenuItem("Green");
    MenuItem blueF = new MenuItem("Blue");
    MenuItem cyanF = new MenuItem("Cyan");
    MenuItem magentaF = new MenuItem("Magenta");
    MenuItem orangeF = new MenuItem("Orange");
    MenuItem whiteF = new MenuItem("White");
    MenuItem blackF = new MenuItem("Black");
    MenuItem ranColor = new MenuItem("Random Colors");
    MenuItem ranColorParty = new MenuItem("Color Party");
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int size = 12;
    int space = 0;
    String copyText = new String();
    String copy2Text = new String();
    String f = new String();
    String input = new String();

    String[] textFonts = {"Arial","Baskerville Old Face","Bodoni MT","Calibri","Century","Century Gothic","Chiller","Comic Sans MS","Impact","Jokerman","Lucida Bright","Lucida Calligraphy","Magneto","Microsoft Sans Serif","Papyrus","Rage Italic","SansSerif","Times New Roman","Trebuchet MS","Verdana","Webdings"};
    String[] saveName = new String[21];
    String[] openText = new String[21];

    Thread t1;

    public Menu5()
    {
		text.setLineWrap(true);
        System.out.println("ARRAY LEN " + saveName.length);

        this.setTitle("untitled");
        this.setLayout(new BorderLayout());
        add(text, BorderLayout.CENTER);
        this.setFont(font);

        MenuBar mnuBar = new MenuBar();

        // build the File menu
        Menu fileMenu = new Menu("File");
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);

        // build the Edit menu
        Menu editMenu = new Menu("Edit");
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pasteMenuItem.addActionListener(this);
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        // build the Format Menu
        Menu formatMenu = new Menu("Format");
        sizeMenuItem.addActionListener(this);
        fontMenuItem.addActionListener(this);
        Menu backgroundMenuItem = new Menu("Background");
        Menu foregroundMenuItem = new Menu("Foreground");
        formatMenu.add(backgroundMenuItem);
        backgroundMenuItem.add(redB);
        redB.addActionListener(this);
        backgroundMenuItem.add(greenB);
        greenB.addActionListener(this);
        backgroundMenuItem.add(blueB);
        blueB.addActionListener(this);
        backgroundMenuItem.add(cyanB);
        cyanB.addActionListener(this);
        backgroundMenuItem.add(magentaB);
        magentaB.addActionListener(this);
        backgroundMenuItem.add(orangeB);
        orangeB.addActionListener(this);
        backgroundMenuItem.add(blackB);
        blackB.addActionListener(this);
        backgroundMenuItem.add(whiteB);
        whiteB.addActionListener(this);
        formatMenu.add(foregroundMenuItem);
        foregroundMenuItem.add(redF);
        redF.addActionListener(this);
        foregroundMenuItem.add(greenF);
        greenF.addActionListener(this);
        foregroundMenuItem.add(blueF);
        blueF.addActionListener(this);
        foregroundMenuItem.add(cyanF);
        cyanF.addActionListener(this);
        foregroundMenuItem.add(magentaF);
        magentaF.addActionListener(this);
        foregroundMenuItem.add(orangeF);
        orangeF.addActionListener(this);
        foregroundMenuItem.add(blackF);
        blackF.addActionListener(this);
        foregroundMenuItem.add(whiteF);
        whiteF.addActionListener(this);
        formatMenu.add(ranColor);
        ranColor.addActionListener(this);
        formatMenu.add(ranColorParty);
        ranColorParty.addActionListener(this);
        formatMenu.add(sizeMenuItem);
        formatMenu.add(fontMenuItem);

        // build the Help Menu
        Menu helpMenu = new Menu("Help");
        helpMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        helpMenu.add(helpMenuItem);
        helpMenu.add(aboutMenuItem);

        //add menus to menu bar
        mnuBar.add(fileMenu);
        mnuBar.add(editMenu);
        mnuBar.add(formatMenu);
        mnuBar.add(helpMenu);


        // put the mnubar on the frame
        this.setMenuBar(mnuBar);
	}

	public void run()
	{
		int i = 0;
		while(i<1000)
		{
		    red = (int) (Math.random()*256);
			green = (int) (Math.random()*256);
			blue = (int) (Math.random()*256);

			randomColor = new Color(red,green,blue);
			inverseColor = new Color(255-red,255-green,255-blue);
		    text.setBackground(randomColor);
            text.setForeground(inverseColor);
            try
			{
				Thread.sleep(1);
			}
			catch(InterruptedException e)
			{
			}
		}
		i++;
	}

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == openMenuItem)
        {
            String open = (String) JOptionPane.showInputDialog(null, "Choose file","Open", JOptionPane.QUESTION_MESSAGE, null, saveName, saveName[1]);
            this.setTitle(open);
            for(int i= 0; i<saveName.length; i++)
            {
                if(saveName[i] == open)
                {
                    index = i;
                }
            }
            text.setText(openText[index]);
        }
        else if(e.getSource() == saveMenuItem)
        {
            String name = JOptionPane.showInputDialog(null,"Enter a name");
            if(space == 20)
            {
                JOptionPane.showMessageDialog(null,"You have run out of storage space");
            }
            else
            {
                boolean match = false;
                for(int i= 0; i<space; i++)
                {
                    if(saveName[i].equals(name))
                    {
                        match = true;
                        JOptionPane.showConfirmDialog (null, "There is already a document saved with that name, do you wish to override it?","Warning",dialogButton);
                        if(dialogButton == JOptionPane.YES_OPTION)
                        {
                            this.setTitle(name);
                            copyText = text.getText();
                            openText[i] = copyText;

                        }
                        else if(dialogButton == JOptionPane.NO_OPTION)
                        {

                        }
                    }
                }
                if(match == false)
                {
                    this.setTitle(name);
                    copyText = text.getText();
                    saveName[space] = name;
                    openText[space] = copyText;
                    space++;
                }
            }

        }
        else if(e.getSource() == saveAsMenuItem)
        {
            String name = JOptionPane.showInputDialog(null,"Enter a name");
            if(space == 20)
            {
                JOptionPane.showMessageDialog(null,"You have run out of storage space");
            }
            else
            {
                boolean match = false;
                for(int i= 0; i<space; i++)
                {
                    if(saveName[i].equals(name))
                    {
                        match = true;
                        JOptionPane.showConfirmDialog (null, "There is already a document saved with that name, do you wish to override it?","Warning",dialogButton);
                        if(dialogButton == JOptionPane.YES_OPTION)
                        {
                            this.setTitle(name);
                            copyText = text.getText();
                            openText[i] = copyText;

                        }
                        else if(dialogButton == JOptionPane.NO_OPTION)
                        {

                        }
                    }
                }
                if(match == false)
                {
                    this.setTitle(name);
                    copyText = text.getText();
                    saveName[space] = name;
                    openText[space] = copyText;
                    space++;
                }
            }
        }
        else if(e.getSource() == cutMenuItem)
        {
            copyText = text.getSelectedText();
            text.replaceRange(" ", text.getSelectionStart(), text.getSelectionEnd());

        }
        else if(e.getSource() == copyMenuItem)
        {
            copyText = text.getSelectedText();
        }
        else if(e.getSource() == pasteMenuItem)
        {
            copy2Text = text.getText();
            text.setText(copy2Text + " " + copyText);
        }
        else if(e.getSource() == redB)
        {
            text.setBackground(Color.red);
        }
        else if(e.getSource() == greenB)
        {
            text.setBackground(Color.green);
        }
        else if(e.getSource() == blueB)
        {
            text.setBackground(Color.blue);
        }
        else if(e.getSource() == cyanB)
        {
            text.setBackground(Color.cyan);
        }
        else if(e.getSource() == magentaB)
        {
            text.setBackground(Color.magenta);
        }
        else if(e.getSource() == orangeB)
        {
            text.setBackground(Color.orange);
        }
        else if(e.getSource() == blackB)
        {
            text.setBackground(Color.black);
        }
        else if(e.getSource() == whiteB)
        {
            text.setBackground(Color.white);
        }
        else if(e.getSource() == redF)
        {
            text.setForeground(Color.red);
        }
        else if(e.getSource() == greenF)
        {
            text.setForeground(Color.green);
        }
        else if(e.getSource() == blueF)
        {
            text.setForeground(Color.blue);
        }
        else if(e.getSource() == cyanF)
        {
            text.setForeground(Color.cyan);
        }
        else if(e.getSource() == magentaF)
        {
            text.setForeground(Color.magenta);
        }
        else if(e.getSource() == orangeF)
        {
            text.setForeground(Color.orange);
        }
        else if(e.getSource() == blackF)
        {
            text.setForeground(Color.black);
        }
        else if(e.getSource() == whiteF)
        {
            text.setForeground(Color.white);
        }
        else if(e.getSource() == ranColor)
        {
            red = (int) (Math.random()*256);
			green = (int) (Math.random()*256);
			blue = (int) (Math.random()*256);

			randomColor = new Color(red,green,blue);
			inverseColor = new Color(255-red,255-green,255-blue);
            text.setBackground(randomColor);
            text.setForeground(inverseColor);
        }
        else if(e.getSource() == ranColorParty)
        {
			t1 = new Thread(this);
			t1.start();
		}
        else if(e.getSource() == sizeMenuItem)
        {
            size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the size of text"));
            Font font = new Font(input, Font.PLAIN, size);
            Font newFont = font.deriveFont(size);
            text.setFont(newFont);

        }
        else if(e.getSource() == fontMenuItem)
        {
            String input = (String) JOptionPane.showInputDialog(null, "Choose Font","Font", JOptionPane.QUESTION_MESSAGE, null, textFonts, textFonts[1]);
            Font fonty = new Font(input, Font.PLAIN, size);
            text.setFont(font);
        }
        else if(e.getSource() == helpMenuItem)
        {
            JOptionPane.showMessageDialog(null, "If you need help with this Application, there is something wrong with your head... go talk to a doctor");
        }
        else if(e.getSource() == aboutMenuItem)
        {
            JOptionPane.showMessageDialog(null, "This is a Console Application designed by Bernard Kintzing \n�2015");
        }
    }

    public static void main(String[] args)
    {
        Menu5 MDD = new Menu5();
        MDD.setVisible(true);
        MDD.setBounds(10,10,700,900);
       	text.setEditable(false);
		JOptionPane.showMessageDialog(null,"This program can not be used until the payment of 45,000 has been compleated");
		JOptionPane.showInputDialog(null,"Enter your credit card number below:");
		text.setEditable(true);
    }
}