import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Chap6Connect5 extends JFrame implements ActionListener
{
    TextField[] tf = new TextField[42];
    Button[] buttons = new Button[7];

    Panel centerPanel = new Panel();
    Panel northPanel = new Panel();

    Boolean p1 = true;
    Boolean p2 = false;

    Font f = new Font("", Font.PLAIN, 100);

    Thread t1;

    public Chap6Connect5()
    {
        this.setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(6,7));
        add(northPanel, BorderLayout.NORTH);
        northPanel.setLayout(new GridLayout(0,7));
        for(int i =0; i<buttons.length; i++)
        {
            buttons[i] = new Button();
            buttons[i].addActionListener(this);
            northPanel.add(buttons[i]);
        }
        buttons[0].setLabel("Column 1");
        buttons[1].setLabel("Column 2");
        buttons[2].setLabel("Column 3");
        buttons[3].setLabel("Column 4");
        buttons[4].setLabel("Column 5");
        buttons[5].setLabel("Column 6");
        buttons[6].setLabel("Column 7");
        for(int i = 0; i<tf.length; i++)
        {
            tf[i] = new TextField();
            centerPanel.add(tf[i]);
            tf[i].setEditable(false);
            //tf[i].setText(String.valueOf(i));
            tf[i].setText(" ");
            tf[i].setFont(f);
        }
    }

    public void p15Check()
    {
        Boolean check = false;
        Boolean done = false;
        for(int i = 0; i<tf.length; i++)
        {
            if(done)
            {
                break;
            }
            // Left to Right
            if(i != 3 && i != 4 && i != 5 && i != 6 && i != 10 &&i != 11 && i != 12 && i != 13 && i != 17 && i !=18 && i !=19 && i !=20 && i != 24 && i != 25 && i != 26 && i != 27 && i != 31 && i != 32 && i != 33 && i != 34 && i != 38 && i != 39 && i != 40 && i != 41 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+1].getText()) && tf[i].getText().equals(tf[i+2].getText()) && tf[i].getText().equals(tf[i+3].getText()) && tf[i].getText().equals(tf[i+4].getText()))
            {
                check = true;
            }
            // Right to left
            else if(i != 0 && i != 1 && i != 2 && i != 3&& i != 7 &&i != 8 && i != 9 && i != 10 && i != 14 && i != 15 && i != 16 && i != 17 && i != 21 && i != 22 && i != 23 && i != 24 && i != 28 && i != 29 && i != 30 && i != 31 && i != 35 && i != 36 && i != 37 && i != 38 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-1].getText()) && tf[i].getText().equals(tf[i-2].getText()) && tf[i].getText().equals(tf[i-3].getText()) && tf[i].getText().equals(tf[i-4].getText()))
            {
                check = true;
            }
            // Top to Bottom
            else if(i !=14  && i != 15 && i != 16 && i != 17&& i != 18 &&i != 19 && i != 20 && i != 21 && i != 22 && i != 23 && i != 24 && i != 25 && i != 26 && i != 27 && i != 28 && i != 29 && i != 30 && i != 31 && i != 32 && i !=33  &&i !=34  &&i !=35 &&i !=36  &&i !=37  &&i !=38  &&i !=39  &&i !=40  &&i !=41 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+7].getText()) && tf[i].getText().equals(tf[i+14].getText()) && tf[i].getText().equals(tf[i+21].getText()) && tf[i].getText().equals(tf[i+28].getText()))
            {
                check = true;
            }
            //Bottom to Top
            else if(i !=0  &&i != 1 &&i !=2  &&i !=3  &&i !=4  &&i !=5  &&i !=6  &&i != 7 &&i != 8 &&i != 9 &&i != 10 &&i != 11 &&i != 12 &&i != 13 &&i != 14 &&i != 15 &&i != 16 &&i != 17 &&i != 18 &&i != 19 &&i != 20 &&i != 21 &&i != 22 &&i != 23 &&i != 24 &&i != 25 &&i != 26 &&i != 27 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-7].getText()) && tf[i].getText().equals(tf[i-14].getText()) && tf[i].getText().equals(tf[i-21].getText()) && tf[i].getText().equals( tf[i-28].getText()))
            {
                check = true;
            }
            //Upper Left to Lower Right
            else if(((i == 0) || (i == 7) || (i == 1) || (i == 2) || (i == 8) || (i == 9)) && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+8].getText()) && tf[i].getText().equals(tf[i+16].getText()) && tf[i].getText().equals(tf[i+24].getText()) && tf[i].getText().equals(tf[i + 32].getText()))
            {
                check = true;
            }
            // Lower Right to Upper Left
            else if(((i == 41) || (i == 40) || (i == 34) || (i == 33) || (i == 32) || (i == 29)) && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-8].getText()) && tf[i].getText().equals(tf[i-16].getText()) && tf[i].getText().equals(tf[i-24].getText()) && tf[i].getText().equals(tf[i - 32].getText()))
            {
                check = true;
            }
            //Upper Right to Lower Left
            else if(((i == 6)|| (i == 5) || (i == 13) || (i == 4) || (i == 11) || (i == 12) || (i == 13)) && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+6].getText()) && tf[i].getText().equals(tf[i+12].getText()) && tf[i].getText().equals(tf[i+18].getText()) && tf[i].getText().equals(tf[i + 24].getText()))
            {
                check = true;
            }
            //Lower Left to Upper Right
            else if(((i == 35) || (i == 36) || (i == 28) || (i ==29) || (i == 30) || (i == 37))  &&  tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-6].getText()) && tf[i].getText().equals(tf[i-12].getText()) && tf[i].getText().equals(tf[i-18].getText()) && tf[i].getText().equals(tf[i - 24].getText()))
            {
                check = true;
            }
            else if(check)
            {
                JOptionPane.showMessageDialog(null, "Player One Wins");
                done = true;
            }
        }
    }
    public void p25Check()
    {
        Boolean check = false;
        Boolean done = false;
        for(int i = 0; i<tf.length; i++)
        {
            if(done)
            {
                break;
            }
            // Left to Right
            if(i != 3 && i != 4 && i != 5 && i != 6 && i != 10 &&i != 11 && i != 12 && i != 13 && i != 17 && i !=18 && i !=19 && i !=20 && i != 24 && i != 25 && i != 26 && i != 27 && i != 31 && i != 32 && i != 33 && i != 34 && i != 38 && i != 39 && i != 40 && i != 41 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+1].getText()) && tf[i].getText().equals(tf[i+2].getText()) && tf[i].getText().equals(tf[i+3].getText()) && tf[i].getText().equals(tf[i+4].getText()))
            {
                check = true;
            }
            // Right to left
            else if(i != 0 && i != 1 && i != 2 && i != 3&& i != 7 &&i != 8 && i != 9 && i != 10 && i != 14 && i != 15 && i != 16 && i != 17 && i != 21 && i != 22 && i != 23 && i != 24 && i != 28 && i != 29 && i != 30 && i != 31 && i != 35 && i != 36 && i != 37 && i != 38 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-1].getText()) && tf[i].getText().equals(tf[i-2].getText()) && tf[i].getText().equals(tf[i-3].getText()) && tf[i].getText().equals(tf[i-4].getText()))
            {
                check = true;
            }
            // Top to Bottom
            else if(i !=14  && i != 15 && i != 16 && i != 17&& i != 18 &&i != 19 && i != 20 && i != 21 && i != 22 && i != 23 && i != 24 && i != 25 && i != 26 && i != 27 && i != 28 && i != 29 && i != 30 && i != 31 && i != 32 && i !=33  &&i !=34  &&i !=35 &&i !=36  &&i !=37  &&i !=38  &&i !=39  &&i !=40  &&i !=41 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+7].getText()) && tf[i].getText().equals(tf[i+14].getText()) && tf[i].getText().equals(tf[i+21].getText()) && tf[i].getText().equals(tf[i+28].getText()))
            {
                check = true;
            }
            //Bottom to Top
            else if(i !=0  &&i != 1 &&i !=2  &&i !=3  &&i !=4  &&i !=5  &&i !=6  &&i != 7 &&i != 8 &&i != 9 &&i != 10 &&i != 11 &&i != 12 &&i != 13 &&i != 14 &&i != 15 &&i != 16 &&i != 17 &&i != 18 &&i != 19 &&i != 20 &&i != 21 &&i != 22 &&i != 23 &&i != 24 &&i != 25 &&i != 26 &&i != 27 && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-7].getText()) && tf[i].getText().equals(tf[i-14].getText()) && tf[i].getText().equals(tf[i-21].getText()) && tf[i].getText().equals( tf[i-28].getText()))
            {
                check = true;
            }
            //Upper Left to Lower Right
            else if(((i == 0) || (i == 7) || (i == 1) || (i == 2) || (i == 8) || (i == 9)) && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+8].getText()) && tf[i].getText().equals(tf[i+16].getText()) && tf[i].getText().equals(tf[i+24].getText()) && tf[i].getText().equals(tf[i + 32].getText()))
            {
                check = true;
            }
            // Lower Right to Upper Left
            else if(((i == 41) || (i == 40) || (i == 34) || (i == 33) || (i == 32) || (i == 29)) && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-8].getText()) && tf[i].getText().equals(tf[i-16].getText()) && tf[i].getText().equals(tf[i-24].getText()) && tf[i].getText().equals(tf[i - 32].getText()))
            {
                check = true;
            }
            //Upper Right to Lower Left
            else if(((i == 6)|| (i == 5) || (i == 13) || (i == 4) || (i == 11) || (i == 12) || (i == 13)) && tf[i].getText().equals("O") && tf[i].getText().equals(tf[i+6].getText()) && tf[i].getText().equals(tf[i+12].getText()) && tf[i].getText().equals(tf[i+18].getText()) && tf[i].getText().equals(tf[i + 24].getText()))
            {
                check = true;
            }
            //Lower Left to Upper Right
            else if(((i == 35) || (i == 36) || (i == 28) || (i ==29) || (i == 30) || (i == 37))  &&  tf[i].getText().equals("O") && tf[i].getText().equals(tf[i-6].getText()) && tf[i].getText().equals(tf[i-12].getText()) && tf[i].getText().equals(tf[i-18].getText()) && tf[i].getText().equals(tf[i - 24].getText()))
            {
                check = true;
            }
            else if(check)
            {
                JOptionPane.showMessageDialog(null, "Player Two Wins");
                done = true;
            }

        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == buttons[0])
        {
            if(p1)
            {
                p1 = false;
                p2 = true;
                if(tf[35].getText().equals(" "))
                {
                    //Create a drop effect using Threads
                	tf[0].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[0].setText(" ");
					tf[7].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[7].setText(" ");
					tf[14].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[14].setText(" ");
					tf[21].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[21].setText(" ");
					tf[28].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[28].setText(" ");

                    tf[35].setText("O");
                }
                else if(tf[28].getText().equals(" "))
                {
					tf[0].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[0].setText(" ");
					tf[7].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[7].setText(" ");
					tf[14].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[14].setText(" ");
					tf[21].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[21].setText(" ");
                    tf[28].setText("O");
                }
                else if(tf[21].getText().equals(" "))
                {
					tf[0].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[0].setText(" ");
					tf[7].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[7].setText(" ");
					tf[14].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[14].setText(" ");
                    tf[21].setText("O");
                }
                else if(tf[14].getText().equals(" "))
                {
					tf[0].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[0].setText(" ");
					tf[7].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[7].setText(" ");
                    tf[14].setText("O");
                }
                else if(tf[7].getText().equals(" "))
                {
					tf[0].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[0].setText(" ");
                    tf[7].setText("O");
                }
                else if(tf[0].getText().equals(" "))
                {
                    tf[0].setText("O");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p1 = true;
                    p2 = false;
                }
                p15Check();
            }
            else
            {
				p1 = true;
				p2 = false;
				if(tf[35].getText().equals(" "))
			   	{
				   //Create a drop effect using Threads
				tf[0].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[0].setText(" ");
				tf[7].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[7].setText(" ");
				tf[14].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[14].setText(" ");
				tf[21].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[21].setText(" ");
				tf[28].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[28].setText(" ");

				   tf[35].setText("X");
			   }
			   else if(tf[28].getText().equals(" "))
			   {
				tf[0].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[0].setText(" ");
				tf[7].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[7].setText(" ");
				tf[14].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[14].setText(" ");
				tf[21].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[21].setText(" ");
				   tf[28].setText("X");
			   }
			   else if(tf[21].getText().equals(" "))
			   {
				tf[0].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[0].setText(" ");
				tf[7].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[7].setText(" ");
				tf[14].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[14].setText(" ");
				   tf[21].setText("X");
			   }
			   else if(tf[14].getText().equals(" "))
			   {
				tf[0].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[0].setText(" ");
				tf[7].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[7].setText(" ");
				   tf[14].setText("X");
			   }
			   else if(tf[7].getText().equals(" "))
			   {
				tf[0].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[0].setText(" ");
				   tf[7].setText("X");
			   }
			   else if(tf[0].getText().equals(" "))
			   {
				   tf[0].setText("X");
			   }
			   else
			   {
				   JOptionPane.showMessageDialog(null, "This column is full choose another");
				   p2 = true;
				   p1 = false;
		   }
                p25Check();
            }
        }
        else if(e.getSource() == buttons[1])
        {
            if(p1)
            {
                p1 = false;
                p2 = true;
                if (tf[36].getText().equals(" "))
                {
					tf[1].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[1].setText(" ");
					tf[8].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[8].setText(" ");
					tf[15].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[15].setText(" ");
					tf[22].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[22].setText(" ");
					tf[29].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[29].setText(" ");
                    tf[36].setText("O");
                }
                else if (tf[29].getText().equals(" "))
                {
					tf[1].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[1].setText(" ");
					tf[8].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[8].setText(" ");
					tf[15].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[15].setText(" ");
					tf[22].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[22].setText(" ");
                    tf[29].setText("O");
                }
                else if (tf[22].getText().equals(" "))
                {
					tf[1].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[1].setText(" ");
					tf[8].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[8].setText(" ");
					tf[15].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[15].setText(" ");
                    tf[22].setText("O");
                }
                else if (tf[15].getText().equals(" "))
                {
					tf[1].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[1].setText(" ");
					tf[8].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[8].setText(" ");
                    tf[15].setText("O");
                }
                else if (tf[8].getText().equals(" "))
                {
					tf[1].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[1].setText(" ");
                    tf[8].setText("O");
                }
                else if (tf[1].getText().equals(" "))
                {
                    tf[1].setText("O");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p1 = true;
                    p2 = false;
                }
                p15Check();
            }
            else
            {
            	p2 = false;
				p1 = true;
			   	if (tf[36].getText().equals(" "))
			   	{
				tf[1].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[1].setText(" ");
				tf[8].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[8].setText(" ");
				tf[15].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[15].setText(" ");
				tf[22].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[22].setText(" ");
				tf[29].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[29].setText(" ");
				tf[36].setText("X");
			   	}
			   	else if (tf[29].getText().equals(" "))
			  	{
				tf[1].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[1].setText(" ");
				tf[8].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[8].setText(" ");
				tf[15].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[15].setText(" ");
				tf[22].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[22].setText(" ");
				tf[29].setText("X");
			   	}
			   	else if (tf[22].getText().equals(" "))
			   	{
				tf[1].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[1].setText(" ");
				tf[8].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[8].setText(" ");
				tf[15].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[15].setText(" ");
				tf[22].setText("X");
				}
			   	else if (tf[15].getText().equals(" "))
			   	{
				tf[1].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[1].setText(" ");
				tf[8].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[8].setText(" ");
				   tf[15].setText("X");
			   	}
			   	else if (tf[8].getText().equals(" "))
			   	{
				tf[1].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[1].setText(" ");
			   	tf[8].setText("X");
			   	}
			   	else if (tf[1].getText().equals(" "))
			   	{
				   tf[1].setText("X");
			   	}
			   	else
			   	{
				   JOptionPane.showMessageDialog(null, "This column is full choose another");
				   p2 = true;
				   p1 = false;
			   	}
                p25Check();
			}
        }
        else if(e.getSource() == buttons[2])
        {
            if(p1)
            {
                p1 = false;
                p2 = true;
                if (tf[37].getText().equals(" "))
                {
					tf[2].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[2].setText(" ");
					tf[9].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[9].setText(" ");
					tf[16].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[16].setText(" ");
					tf[23].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[23].setText(" ");
					tf[30].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[30].setText(" ");
					tf[37].setText("O");
				}
                else if (tf[30].getText().equals(" "))
                {
					tf[2].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[2].setText(" ");
					tf[9].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[9].setText(" ");
					tf[16].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[16].setText(" ");
					tf[23].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[23].setText(" ");
                    tf[30].setText("O");
                }
                else if (tf[23].getText().equals( " "))
                {
					tf[2].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[2].setText(" ");
					tf[9].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[9].setText(" ");
					tf[16].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[16].setText(" ");
                    tf[23].setText("O");
                }
                else if (tf[16].getText().equals( " "))
                {
					tf[2].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[2].setText(" ");
					tf[9].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[9].setText(" ");
                    tf[16].setText("O");
                }
                else if (tf[9].getText().equals( " "))
                {
					tf[2].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[2].setText(" ");
                    tf[9].setText("O");
                }
                else if (tf[2].getText().equals( " "))
                {
                    tf[2].setText("O");
                } else {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p1 = true;
                    p2 = false;
                }
                p15Check();
            }
            else
            {
               p2 = false;
			   p1 = true;
			   if (tf[37].getText().equals(" "))
			   {
				tf[2].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[2].setText(" ");
				tf[9].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[9].setText(" ");
				tf[16].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[16].setText(" ");
				tf[23].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[23].setText(" ");
				tf[30].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[30].setText(" ");
				tf[37].setText("X");
			}
			   else if (tf[30].getText().equals(" "))
			   {
				tf[2].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[2].setText(" ");
				tf[9].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[9].setText(" ");
				tf[16].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[16].setText(" ");
				tf[23].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[23].setText(" ");
				   tf[30].setText("X");
			   }
			   else if (tf[23].getText().equals( " "))
			   {
				tf[2].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[2].setText(" ");
				tf[9].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[9].setText(" ");
				tf[16].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[16].setText(" ");
				   tf[23].setText("X");
			   }
			   else if (tf[16].getText().equals( " "))
			   {
				tf[2].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[2].setText(" ");
				tf[9].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[9].setText(" ");
				   tf[16].setText("X");
			   }
			   else if (tf[9].getText().equals( " "))
			   {
				tf[2].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[2].setText(" ");
				   tf[9].setText("X");
			   }
			   else if (tf[2].getText().equals( " "))
			   {
				   tf[2].setText("X");
			   } else {
				   JOptionPane.showMessageDialog(null, "This column is full choose another");
				   p2 = true;
				   p1 = false;
			   }
                p25Check();
            }
        }
        else if(e.getSource() == buttons[3])
        {
            if(p1)
            {
                p1 = false;
                p2 = true;
                if (tf[38].getText().equals(" "))
                {
					tf[3].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[3].setText(" ");
					tf[10].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[10].setText(" ");
					tf[17].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[17].setText(" ");
					tf[24].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[24].setText(" ");
					tf[31].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[31].setText(" ");
                    tf[38].setText("O");
                }
                else if (tf[31].getText().equals(" "))
                {
					tf[3].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[3].setText(" ");
					tf[10].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[10].setText(" ");
					tf[17].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[17].setText(" ");
					tf[24].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[24].setText(" ");
                    tf[31].setText("O");
                }
                else if (tf[24].getText().equals( " "))
                {
					tf[3].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[3].setText(" ");
					tf[10].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[10].setText(" ");
					tf[17].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[17].setText(" ");
                    tf[24].setText("O");
                }
                else if (tf[17].getText().equals( " "))
                {
					tf[3].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[3].setText(" ");
					tf[10].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[10].setText(" ");
                    tf[17].setText("O");
                }
                else if (tf[10].getText().equals( " "))
                {
					tf[3].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[3].setText(" ");
                    tf[10].setText("O");
                }
                else if (tf[3].getText().equals( " "))
                {
                    tf[3].setText("O");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p1 = true;
                    p2 = false;
                }
                p15Check();
            }
            else
            {
               p2 = false;
			   p1 = true;
			   if (tf[38].getText().equals(" "))
			   {
				tf[3].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[3].setText(" ");
				tf[10].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[10].setText(" ");
				tf[17].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[17].setText(" ");
				tf[24].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[24].setText(" ");
				tf[31].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[31].setText(" ");
				   tf[38].setText("X");
			   }
			   else if (tf[31].getText().equals(" "))
			   {
				tf[3].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[3].setText(" ");
				tf[10].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[10].setText(" ");
				tf[17].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[17].setText(" ");
				tf[24].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[24].setText(" ");
				   tf[31].setText("X");
			   }
			   else if (tf[24].getText().equals( " "))
			   {
				tf[3].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[3].setText(" ");
				tf[10].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[10].setText(" ");
				tf[17].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[17].setText(" ");
				   tf[24].setText("X");
			   }
			   else if (tf[17].getText().equals( " "))
			   {
				tf[3].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[3].setText(" ");
				tf[10].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[10].setText(" ");
				   tf[17].setText("X");
			   }
			   else if (tf[10].getText().equals( " "))
			   {
				tf[3].setText("X");
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException a)
				{
				}
				tf[3].setText(" ");
				   tf[10].setText("X");
			   }
			   else if (tf[3].getText().equals( " "))
			   {
				   tf[3].setText("X");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p2 = true;
                    p1 = false;
                }
                p25Check();
            }
        }
        else if(e.getSource() == buttons[4])
        {
            if(p1)
            {
                p1 = false;
                p2 = true;
                if (tf[39].getText().equals(" "))
                {
					tf[4].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[4].setText(" ");
					tf[11].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[11].setText(" ");
					tf[18].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[18].setText(" ");
					tf[25].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[25].setText(" ");
					tf[32].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[32].setText(" ");
				   tf[39].setText("O");
				else if (tf[32].getText().equals( " "))
				{
					tf[4].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[4].setText(" ");
					tf[11].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[11].setText(" ");
					tf[18].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[18].setText(" ");
					tf[25].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
										}
					tf[25].setText(" ");
					tf[32].setText("O");
                }
                else if (tf[25].getText().equals( " "))
                {
					tf[4].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[4].setText(" ");
					tf[11].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[11].setText(" ");
					tf[18].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[18].setText(" ");
                    tf[25].setText("O");
                }
                else if (tf[18].getText().equals( " "))
                {
					tf[4].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[4].setText(" ");
					tf[11].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[11].setText(" ");
                    tf[18].setText("O");
                }
                else if (tf[11].getText().equals( " "))
                {
					tf[4].setText("O");
					try
					{
						Thread.sleep(100);
					}
					catch(InterruptedException a)
					{
					}
					tf[4].setText(" ");
                    tf[11].setText("O");
                }
                else if (tf[4].getText().equals( " "))
                {
                    tf[4].setText("O");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p1 = true;
                    p2 = false;
                }
                p15Check();
            }
            else
            {
                p2 = false;
                p1 = true;
                if (tf[39].getText().equals(" "))
                {
                    tf[39].setText("X");
                }
                else if (tf[32].getText().equals(" "))
                {
                    tf[32].setText("X");
                }
                else if (tf[25].getText().equals( " "))
                {
                    tf[25].setText("X");
                }
                else if (tf[18].getText().equals( " "))
                {
                    tf[18].setText("X");
                }
                else if (tf[11].getText().equals( " "))
                {
                    tf[11].setText("X");
                }
                else if (tf[4].getText().equals( " "))
                {
                    tf[4].setText("X");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p2 = true;
                    p1 = false;
                }
                p25Check();
            }
        }
        else if(e.getSource() == buttons[5])
        {
            if(p1)
            {
                p1 = false;
                p2 = true;
                if(tf[40].getText().equals(" "))
                {
                    tf[40].setText("O");
                }
                else if (tf[33].getText().equals(" "))
                {
                    tf[33].setText("O");
                }
                else if (tf[26].getText().equals( " "))
                {
                    tf[26].setText("O");
                }
                else if (tf[19].getText().equals( " "))
                {
                    tf[19].setText("O");
                }
                else if (tf[12].getText().equals( " "))
                {
                    tf[12].setText("O");
                }
                else if (tf[5].getText().equals( " "))
                {
                    tf[5].setText("O");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p1 = true;
                    p2 = false;
                }
                p15Check();
            }
            else
            {
                p2 = false;
                p1 = true;
                if (tf[40].getText().equals(" "))
                {
                    tf[40].setText("X");
                }
                else if (tf[33].getText().equals(" "))
                {
                    tf[33].setText("X");
                }
                else if (tf[26].getText().equals( " "))
                {
                    tf[26].setText("X");
                }
                else if (tf[19].getText().equals( " "))
                {
                    tf[19].setText("X");
                }
                else if (tf[12].getText().equals( " "))
                {
                    tf[12].setText("X");
                }
                else if (tf[5].getText().equals( " "))
                {
                    tf[5].setText("X");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p2 = true;
                    p1 = false;
                }
                p25Check();
            }
        }
        else if(e.getSource() == buttons[6])
        {
            if(p1)
            {
                p1 = false;
                p2 = true;
                if (tf[41].getText().equals(" "))
                {
                    tf[41].setText("O");
                }
                else if (tf[34].getText().equals(" "))
                {
                    tf[34].setText("O");
                }
                else if (tf[27].getText().equals( " "))
                {
                    tf[27].setText("O");
                }
                else if (tf[20].getText().equals( " "))
                {
                    tf[20].setText("O");
                }
                else if (tf[13].getText().equals( " "))
                {
                    tf[13].setText("O");
                }
                else if (tf[6].getText().equals( " "))
                {
                    tf[6].setText("O");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p1 = true;
                    p2 = false;
                }
                p15Check();
            }
            else
            {
                p2 = false;
                p1 = true;
                if (tf[40].getText().equals(" "))
                {
                    tf[40].setText("X");
                }
                else if (tf[34].getText().equals(" "))
                {
                    tf[34].setText("X");
                }
                else if (tf[27].getText().equals( " "))
                {
                    tf[27].setText("X");
                }
                else if (tf[20].getText().equals( " "))
                {
                    tf[20].setText("X");
                }
                else if (tf[13].getText().equals( " "))
                {
                    tf[13].setText("X");
                }
                else if (tf[6].getText().equals( " "))
                {
                    tf[6].setText("X");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This column is full choose another");
                    p2 = true;
                    p1 = false;
                }
                p25Check();
            }
        }
    }

    public static void main(String[] args)
    {
        Chap6Connect5 c = new Chap6Connect5();
        c.setVisible(true);
        c.setBounds(0,0,700,600);
    }
}
