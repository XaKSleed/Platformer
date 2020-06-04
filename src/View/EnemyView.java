package View;

import java.awt.*;

public class EnemyView {
    public EnemyView(){}
    public static void paint(Graphics g, Image enemyImage, int Ox, int Oy, int width, int height){
        g.drawImage(enemyImage, Ox, Oy, width, height, null);
    }
}
