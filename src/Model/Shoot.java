package Model;
import javax.swing.*;
import java.awt.*;

public class Shoot implements NPC, Drawable {
    private int Ox;
    private int Oy;
    private int speed;
    private int width;
    private int height;
    private int fieldOx1;
    private int fieldOx2;
    private Image shootImage = new ImageIcon("Data/Images/Shoot.png").getImage();

    public Shoot(int Ox, int Oy, int speed, int width, int height, int fieldOx1, int fieldOx2){
        this.Ox = Ox;
        this.Oy = Oy;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.fieldOx1 = fieldOx1;
        this.fieldOx2 = fieldOx2;
    }
    public void Move(int empty){
       Ox-=speed;
       if(Ox+width >= fieldOx2){
           Ox = fieldOx2;
       }
    }
    @Override
    public int getOx() {
        return Ox;
    }
    @Override
    public int getOy() {
        return Oy;
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    public int getWidth() {return width;}
    public int getHeight(){return height;}
    public boolean getMark(){return false;}
    public Image getImage(){return shootImage;}
    public String getName(){return "Shoot";}
}
