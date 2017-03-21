import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AddGame extends JFrame implements ActionListener{

	JButton addGame = new JButton("Add Game");
	JButton mainMenu = new JButton("Main Menu");
	
	public AddGame(){
		
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	public static void main(String args[]){
		AddGame ag = new AddGame();
		ag.setVisible(true);
		ag.setBounds(100,100,300,200);
		ag.setTitle("Game Store");
	}
}
