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

public class hotStocks extends Frame implements ActionListener
{
   //Declare an input variable

   //Construct components

   public static void main(String[] args)
   {
      Stock window = new Stock();
      window.setTitle("Yesterday's 10 Hottest Stocks");
      window.setSize(300, 175);
      window.setVisible(true);
   }

   public hotStocks()
   {
     //Set colors

     //Set layout managers

     //Add components and actionListener to interface

     try
     {
        //Open the file
        input = new DataInputStream(new FileInputStream("hotStocks.data"));
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
      try
      {
         //Read the data into the text fields
      }
      catch(IOException e2)
      {
         //Print End of file message and clear fields
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

