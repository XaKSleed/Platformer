package Model;
import java.awt.*;


public class Panels implements Drawable, NPC {
    private int Ox1;
    private int Oy1;
    private int width;
    private int height;
    private boolean markKey;


    public Panels(){}
    public Panels(int Ox1, int Oy1, int width, int height){
        this.Ox1 = Ox1;
        this.Oy1 = Oy1;
        this.width = width;
        this.height = height;
        this.markKey = false;

    }

    public int getOx(){return Ox1;}
    public int getWidth(){return width;}
    public int getOy(){return Oy1;}
    public int getHeight(){return height;}
    public int getSpeed(){return 1;}
    public void Move(int KeyCode){}
    public boolean getMark(){return markKey;}
    public Image getImage(){return null;}
    public String getName(){return "Panel";}

}
