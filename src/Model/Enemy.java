package Model;
import javax.swing.*;
import java.awt.*;

public class Enemy implements NPC, Drawable {
    private int Ox;
    private int Oy;
    private int speed;
    private int width;
    private int height;
    private int fieldOx1;
    private int fieldOy2;
    private int fieldOy1;
    private int fieldOx2;
    private boolean shootingSkills;
    private boolean markKey;
    private Image enemyImage;
    private Player.Direction direction = Player.Direction.NONE;

    public Enemy(int Ox, int Oy, int width, int height, int speed, boolean shootingSkills, int fieldOx1, int fieldOx2, int fieldOy1, int fieldOy2, Image enemyImage  ){
        this.Ox = Ox;
        this.Oy = Oy;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.fieldOx1 = fieldOx1;
        this.fieldOx2 = fieldOx2;
        this.fieldOy1 = fieldOy1;
        this.fieldOy2 = fieldOy2;
        this.enemyImage = enemyImage;
        this.markKey = false;
        this.shootingSkills = shootingSkills;
        direction = Player.Direction.LEFT;
    }

    public void Move(int empty){
        switch(direction){
            case LEFT:
                if(shootingSkills == true){
                    enemyImage = new ImageIcon("Data/Images/ShooterLeft.png").getImage();
                }
                else {
                    enemyImage = new ImageIcon("Data/Images/HandLeft.png").getImage();
                }
                Ox-=speed;
                break;
            case RIGHT:
                if(shootingSkills == true){
                    enemyImage = new ImageIcon("Data/Images/ShooterRight.png").getImage();
                }
                else {
                    enemyImage = new ImageIcon("Data/Images/HandRight.png").getImage();
                }
                Ox+=speed;
                break;
        }
        if(Ox <= fieldOx1){
            Ox = fieldOx1;
            direction = Player.Direction.RIGHT;
        }
        if(Ox >= fieldOx2){
            Ox = fieldOx2;
            direction = Player.Direction.LEFT;
        }
    }

    @Override
    public int getOx() {return Ox; }
    @Override
    public int getOy() {return Oy;}
    @Override
    public int getSpeed() {return speed;}
    public int getWidth() {return width;}
    public int getHeight(){return height;}
    public int getFieldOx1(){return fieldOx1;}
    public int getFieldOx2(){return fieldOx2;}
    public boolean getMark(){return markKey;}
    public String getName(){return "Enemy";}
    public Image getImage(){
        return enemyImage;
    }

}
