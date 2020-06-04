import Model.*;
import View.Display;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String [] args){

        short countOfDrawable = 0;
        short countOfEnemies = 0;

        JFrame frame  = Display.createFrame();

        Image img  = new ImageIcon("Data/Images/PlayerR.png").getImage();
        Player player = new Player(70, 867, 867, 35, 55, 15, 3, img);
        img  = new ImageIcon("Data/Images/Player1R.png").getImage();
        Player player2 = new Player2(70, 867, 867, 35, 55, 15, 3, img);
        player.setLevel(0);
        CreateLevels.createLevel(frame, player, player2, countOfDrawable, countOfEnemies);



    }
}