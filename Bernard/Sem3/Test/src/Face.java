import java.awt.Color;

public abstract class Face {
	protected static Color faceColor, eyeColor, mouthColor;
	protected static int faceSize;
	protected static int eyeSize;
	protected static int mouthStartArc;
	protected static int mouthEndArc;

	public Color getFaceColor(){
		return faceColor;
	}
	public Color getEyeColor(){
		return eyeColor;
	}
	public Color getMouthColor(){
		return mouthColor;
	}
	public int getFaceSize(){
		return faceSize;
	}
	public int getEyeSize(){
		return eyeSize;
	}
	public int getMouthStartArc(){
		return mouthStartArc;
	}
	public int getMouthEndArc(){
		return mouthEndArc;
	}

	public void setFaceColor(Color col){
		faceColor = col;
	}
	public void setEyeColor(Color col){
		eyeColor = col;
	}
	public void setMouthColor(Color col){
		mouthColor = col;
	}
	public void setFaceSize(int size){
		faceSize = size;
	}
	public void setEyeSize(int size){
		eyeSize = size;
	}
	public void setMouthStartArc(int size){
		mouthStartArc = size;
	}
	public void setMouthEndArc(int size){
		mouthEndArc = size;
	}

	public abstract void makeNoise();
}