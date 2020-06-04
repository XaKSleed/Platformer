package View;

import java.awt.*;

public class PanelView {
    public PanelView(){}
    public static void paint(Graphics g, int Ox, int Oy, int width, int height){
        g.setColor(Color.BLUE);
        g.drawRect(Ox, Oy, width, height);
    }
}
