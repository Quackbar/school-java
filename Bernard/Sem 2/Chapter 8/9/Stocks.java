/*
   Project 8      hotStocks
   Programmer:    T.Smith
   Date:          September 18, 2012
   Program Name:  hotStocks
*/

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class Stocks extends Frame implements ActionListener
{
   DataInputStream input;

   int foo = 1;

   JPanel fieldPanel = new JPanel();
   JPanel buttonPanel = new JPanel();
   JLabel stockLabel = new JLabel("Stock Name: ");
   JLabel stock = new JLabel("                    ");
   JLabel volumeLabel = new JLabel("Volume: ");
   JLabel volume = new JLabel("                    ");
   JLabel priceLabel = new JLabel("Price: ");
   JLabel price = new JLabel("                    ");
   JLabel changeLabel = new JLabel("Change: ");
   JLabel change = new JLabel("                    ");
   JButton next = new JButton("Begin");

   public static void main(String[] args)
   {
      Stocks window = new Stocks();
      window.setTitle("Yesterday's 10 Hottest Stocks");
      window.setSize(300, 175);
      window.setVisible(true);
   }

   public Stocks()
   {
     //this.setBackground(Color.blue);
     this.setForeground(Color.white);
     next.setForeground(Color.black);

     this.setLayout(new BorderLayout());
     fieldPanel.setLayout(new GridLayout(4,2));
     buttonPanel.setLayout(new FlowLayout());

     fieldPanel.add(stockLabel);
     fieldPanel.add(stock);
     fieldPanel.add(volumeLabel);
     fieldPanel.add(volume);
     fieldPanel.add(priceLabel);
     fieldPanel.add(price);
     fieldPanel.add(changeLabel);
     fieldPanel.add(change);
     buttonPanel.add(next);
     add(fieldPanel, BorderLayout.CENTER);
     add(buttonPanel, BorderLayout.SOUTH);
     next.addActionListener(this);

     try
     {
		input = new DataInputStream(new FileInputStream("hotStocks.dat"));
     }
     catch(IOException ex)
     {
        closeFile();
     }

     //Construct window listener
     addWindowListener(
        new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
               {
                  closeFile();
               }
           }
      );
   }

   public void actionPerformed(ActionEvent e)
   {
	  if(foo == 1)
	  {
		  foo++;
		  next.setText("Next =>");
		  //repaint();
	  }
	  try
	  {
		 stock.setText(input.readUTF());
		 volume.setText(input.readUTF());
		 price.setText(input.readUTF());
		change.setText(input.readUTF());
	  }
	  catch(IOException e2)
	  {
		stock.setText("End of File");
		volume.setText("");
		price.setText("");
		change.setText("");
	  }
   }

   public void closeFile()
   {
      try
      {
         input.close();
      }
      catch(IOException c)
      {
         System.exit(1);
      }
      System.exit(0);
   }
}