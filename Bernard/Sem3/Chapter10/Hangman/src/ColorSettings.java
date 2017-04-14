/**
 * Created by bkintzing on 10/23/2015.
 */

import java.awt.*;

public class ColorSettings extends GameSettings{
    private Color drawPanelColor;
    private Color panelColor;
    private Color penColor;

    public ColorSettings(Color dpColor, Color pColor, Color penColor){
        super();
        drawPanelColor = dpColor;
        panelColor = pColor;
        this.penColor = penColor;
    }

    public Color getDrawPanelColor(){
        return drawPanelColor;
    }

    public Color getPanelColor(){
        return panelColor;
    }

    public Color getPenColor(){
        return penColor;
    }

    public void setDrawPanelColor(Color dpColor){
        drawPanelColor = dpColor;
    }

    public void setPanelColor(Color pColor){
        panelColor = pColor;
    }

    public void setPenColor(Color penColor){
        this.penColor = penColor;
    }

    public Color setRandomPen(){
        int red = (int)(Math.random() * 256);
        int green = (int)(Math.random() * 256);
        int blue = (int)(Math.random() * 256);
        penColor = new Color(red,green,blue);
        return penColor;
    }
}
