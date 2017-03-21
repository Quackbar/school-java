import java.awt.Color;
import java.awt.Toolkit;

public class SadFace extends Face{

	public SadFace(){
		super.setFaceSize(200);
		super.setEyeSize(20);
		super.setMouthStartArc(0);
		super.setMouthEndArc(180);
		super.setFaceColor(Color.RED);
		super.setEyeColor(Color.BLACK);
		super.setMouthColor(Color.WHITE);
	}

	public void makeNoise() {
		DrawFaces.Mood.setText("");
		System.out.println("I am Sad \u0007 \u0007 \u0007");
		//Toolkit.getDefaultToolkit().beep();
		//Toolkit.getDefaultToolkit().beep();
		//Toolkit.getDefaultToolkit().beep();
	}
}

