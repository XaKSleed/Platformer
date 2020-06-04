package Tests;
import Model.Key;
import org.junit.Assert;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;



public class KeyTest {

    @Test
    public void move() {
        Image img1 = new ImageIcon("Data/Images/Key.png").getImage();
        Key key1 = new Key(90, 310, 1, 32, 55, 840, 1030, 320, 340, img1);
        key1.Move(0);
        int test = key1.getOy();
        Assert.assertTrue(test == 320);

    }
}