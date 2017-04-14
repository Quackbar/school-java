import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DrawFaces extends JFrame implements ActionListener{

	JButton Happy = new JButton("Happy");
	JButton Sad = new JButton("Sad");

	static JLabel Mood = new JLabel("");

	JPanel pan = new JPanel();
	JPanel southPan = new JPanel();

	Face f;

	int count = 0;

	static String faceType = null;

	public DrawFaces(){
		this.add(pan);
		pan.setLayout(new BorderLayout());
		pan.add(southPan, BorderLayout.SOUTH);
			southPan.setLayout(new GridLayout(0,2));
			southPan.add(Happy);
				Happy.addActionListener(this);
			southPan.add(Sad);
				Sad.addActionListener(this);
		pan.add(Mood, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == Happy){
			f = new HappyFace();
		}
		else if(e.getSource() == Sad){
			f = new SadFace();
		}
		this.repaint();
	}

	public void paint(Graphics g){
		if(count > 1){
			f.makeNoise();
			g.setColor(f.getFaceColor());
			g.fillOval(50, 50, f.getFaceSize(), f.getFaceSize());
			g.setColor(f.getEyeColor());
			g.fillOval(120, 100, f.getEyeSize(), f.getEyeSize());
			g.fillOval(160, 100, f.getEyeSize(), f.getEyeSize());
			g.setColor(f.getMouthColor());
			g.fillArc(100, 150, 110, 40, f.getMouthStartArc(), f.getMouthEndArc());
		}
		count++;
	}

	public static void main(String[] args){
		DrawFaces f = new DrawFaces();
		f.setVisible(true);
		f.setTitle("Faces");
		f.setBounds(300,300,300,300);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


}

