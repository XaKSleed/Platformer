package Model;
import java.awt.*;

public class Key implements NPC, Drawable {
    private int Ox;
    private int Oy;
    private int speed;
    private int width;
    private int height;
    private int fieldOy1;
    private int fieldOy2;
    private int fieldOx1;
    private int fieldOx2;
    private boolean markKey;
    private Image KeyImage;
    private Player.Direction direction = Player.Direction.NONE;

    public Key(int Ox, int Oy, int speed, int width, int height,int fieldOx1, int fieldOx2,  int fieldOy1, int fieldOy2, Image img){
        this.Ox = Ox;
        this.Oy = Oy;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.fieldOx1 = fieldOx1;
        this.fieldOx2 = fieldOx2;
        this.fieldOy1 = fieldOy1;
        this.fieldOy2 = fieldOy2;
        this.markKey = true;
        direction = Player.Direction.LEFT;
        KeyImage = img;
    }
    public void Move(int empty){
        switch(direction){
            case UP:
                Oy-=speed;
                break;
            case DOWN:
                Oy+=speed;
                break;
        }
        if(Oy <= fieldOy1){
            Oy = fieldOy1;
            direction = Player.Direction.DOWN;
        }
        if(Oy >= fieldOy2){
            Oy = fieldOy2;
            direction = Player.Direction.UP;
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
    public boolean getMark(){return markKey;}
    public Image getImage(){
        return KeyImage;
    }
    public void setImage(Image img){ KeyImage=img; }
    public String getName(){return "Key";}


}
