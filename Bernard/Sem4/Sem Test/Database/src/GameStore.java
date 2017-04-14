import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameStore extends JFrame implements ActionListener{
	
	JButton addGame = new JButton("Add Game");
	JButton addCust = new JButton("Add Customer");
	JButton addTran = new JButton("Add Transaction");
	JButton view = new JButton("View Database");
	
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	
	public GameStore(){
		this.setLayout(new GridLayout(7,1));
		this.add(addGame);
			addGame.addActionListener(this);
		this.add(l1);
		this.add(addCust);
			addCust.addActionListener(this);
		this.add(l2);
		this.add(addTran);
			addTran.addActionListener(this);
		this.add(l3);
		this.add(view);
			view.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addGame){
			AddGame ag = new AddGame();
			
		}
		else if(e.getSource() == addCust){
			
		}
		else if(e.getSource() == addTran){
			
		}
		else if(e.getSource() == view){
			
		}
	}
	
	public static void main(String args[]){
		GameStore g = new GameStore();
		g.setVisible(true);
		g.setBounds(100,100,300,200);
		g.setTitle("Game Store");
	}

}
