package Tests;
import Model.Shoot;
import org.junit.Assert;
import org.junit.Test;


public class ShootTest {

    @Test
    public void move() {
        Shoot shoot1 = new Shoot(-79, 100, 1, 80, 30, 0, 1740);
        shoot1.Move(0);
        int test = shoot1.getOx();
        Assert.assertTrue(test == 1740);
    }
}