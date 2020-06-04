package Tests;
import Model.Enemy;
import org.junit.Assert;
import org.junit.Test;
import javax.swing.*;


public class EnemyTest {

    @Test
    public void move() {
        Enemy enemy = new Enemy(700, 392, 80, 90, 1, false, 840, 1030, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        int test;
        enemy.Move(0);
        test = enemy.getOx();
        Assert.assertTrue(test == 840);
    }
}