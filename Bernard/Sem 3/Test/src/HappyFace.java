import java.awt.Color;

public class HappyFace extends Face{

	public HappyFace(){
		super.setFaceSize(200);
		super.setEyeSize(30);
		super.setMouthStartArc(0);
		super.setMouthEndArc(-180);
		super.setFaceColor(Color.YELLOW);
		super.setEyeColor(Color.BLUE);
		super.setMouthColor(Color.PINK);
	}

	public void makeNoise() {
		DrawFaces.Mood.setText("I am Happy!");
	}

}
