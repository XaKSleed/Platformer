package View;
import javax.swing.*;
import java.awt.*;

public class PlayerView {
    public PlayerView(){}
    public static void paint(Graphics g, Image playerImage, int Ox, int Oy, int width, int height){
        g.drawImage(playerImage, Ox, Oy, width, height, null);
    }
    public static void paintHearts(Graphics g, int life){
        Image heartImage;
        switch (life){
            case 1:
                heartImage = new ImageIcon("Data/Images/Heart1.png").getImage();
                g.drawImage(heartImage, 50, 30, 65, 60, null);
                break;
            case 2:
                heartImage = new ImageIcon("Data/Images/Heart2.png").getImage();
                g.drawImage(heartImage, 50, 30, 140, 60, null);
                break;
            case 3:
                heartImage = new ImageIcon("Data/Images/Heart3.png").getImage();
                g.drawImage(heartImage, 50, 30, 200, 60, null);
                break;
        }
    }
}
