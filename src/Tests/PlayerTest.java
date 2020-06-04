package Tests;

import Model.Enemy;
import Model.Key;
import Model.Panels;
import Model.Player;
import org.junit.Assert;
import javax.swing.*;
import java.awt.*;


public class PlayerTest {

    @org.junit.Test
    public void move() {
        Image img  = new ImageIcon("Data/Images/PlayerR.png").getImage();
        Player player = new Player(826, 392, 867, 35, 55, 15, 3, img);
        player.Move(39);
        int test = player.getOx();
        Assert.assertTrue(test == 841);
    }

    @org.junit.Test
    public void hitCheck() {
        Image img1 = new ImageIcon("Data/Images/Key.png").getImage();
        Image img2 = new ImageIcon("Data/Images/Key2.png").getImage();
        Key key1 = new Key(80, 70, 1, 32, 50,840, 1030, 80, 100, img1);
        Key key2 = new Key(120, 70, 1, 32, 50,200, 1030, 80, 100, img2);
        Enemy enemy = new Enemy(840, 392, 80, 90, 1, false, 840, 1030, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        Image img  = new ImageIcon("Data/Images/PlayerR.png").getImage();
        Player player = new Player(850, 392, 867, 35, 55, 15, 3, img);

        int npcox1 = enemy.getOx();
        int npcox2 = npcox1+enemy.getWidth();
        int npcoy1 = enemy.getOy();
        int npcoy2 = npcoy1+enemy.getHeight();
        player.hitCheck(npcox1, npcox2, npcoy1, npcoy2, enemy, key1, key2);
        int test = player.getLife();
        Assert.assertTrue(test == 2);
    }

    @org.junit.Test
    public void checkPlatform() {
        Image img  = new ImageIcon("Data/Images/PlayerR.png").getImage();
        Player player = new Player(520, 470, 867, 35, 55, 15, 3, img);
        Panels panel = new Panels(500, 500, 230,35);
        int npcox1 = panel.getOx();
        int npcox2 = npcox1+panel.getWidth();
        int npcoy1 = panel.getOy();
        int npcoy2 = npcoy1+panel.getHeight();

        int pox1 = player.getOx();
        int pox2 = pox1+player.getWidth();
        int poy1 = player.getOy();
        int poy2 = poy1+player.getHeight();

        player.checkPlatform(pox1, pox2, poy1, poy2, npcox1,npcox2, npcoy1, npcoy2);
        int test = player.getOy();
        Assert.assertTrue(test == 445);
    }
}