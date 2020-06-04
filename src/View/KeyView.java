package View;
import java.awt.*;

public class KeyView {

    public KeyView(){}
    public static void paint(Graphics g, int Ox, int Oy, int width, int height, Image keyImage){
        g.drawImage(keyImage, Ox, Oy, width, height, null);

    }
}
