package Model;
import javax.swing.*;
import java.awt.*;

public class Door implements NPC, Drawable {
    private int Ox;
    private int Oy;
    private int width;
    private int height;
    private boolean keyMark;
    private Image DoorImage = new ImageIcon("Data/Images/Door.png").getImage();

    public Door(int Ox, int Oy, int width, int height){
        this.Ox = Ox;
        this.Oy = Oy;
        this.width = width;
        this.height = height;
        keyMark = false;
    }

    public int getOx(){return Ox;}
    public int getWidth(){return width;}
    public int getOy(){return Oy;}
    public int getHeight(){return height;}
    public int getSpeed(){return 0;}
    public void Move(int KeyCode){}
    public boolean getMark(){return keyMark;}
    public Image getImage(){return DoorImage;}
    public String getName(){return "Door";}



}
