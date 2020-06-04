package View;

import java.awt.*;

public class ShootView {
    public ShootView(){}
    public static void paint(Graphics g, Image shootImage, int Ox, int Oy, int width, int height){
        g.drawImage(shootImage, Ox, Oy, width, height, null);
    }
}
