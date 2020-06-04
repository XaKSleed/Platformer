package View;

import javax.swing.*;
import java.awt.*;

public class DoorView {
    public DoorView(){}
    public static void paint(Graphics g, int Ox, int Oy, int width, int height ){
        Image doorImage = new ImageIcon("Data/Images/Door.png").getImage();
        g.drawImage(doorImage, Ox, Oy, width, height, null);
    }
}
