package Model;
import javax.swing.*;
import java.awt.*;

public class Player implements NPC, Drawable {
    protected int Ox, platformOx1, platformOx2;
    protected int Oy, groundOy, platformOy;
    protected int speed;
    protected int width;
    protected int height;
    protected boolean jumpThread, onPlatform, ifFalling;
    protected boolean getKey;
    protected int life;
    protected boolean onDoor;
    protected int level;
    protected Image playerImage;
    protected boolean getBack;
    public enum Direction{
        RIGHT,
        LEFT,
        UP,
        DOWN,
        NONE
    }public Direction direction;

    public Player(int Ox, int Oy, int groundOy, int width, int height, int speed, int life, Image img){
        this.Ox = Ox;
        this.Oy = Oy;
        this.groundOy = groundOy;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.life = life;
        this.getKey = true;
        direction = Direction.NONE;
        onPlatform = false;
        jumpThread = false;
        ifFalling = false;
        onDoor = false;
        playerImage = img;
        level = 0;
        getBack = false;
    }
    public int getLevel(){return level;}
    public Image getImage(){return playerImage;}
    public void setLevel(int lvl){ level = lvl;}
    public int getLife(){return life;}
    public void highLevel(){level++;}
    public void noExit(){onDoor = false;}
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
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void stopJumping(){jumpThread =false;}
    public void gotKey(){ getKey = true;}
    public void lostKey(){getKey = false;}
    public boolean isGetKey() { return getKey; }
    public boolean getMark(){return false;}
    public void makeHurt(){ life--; }
    public void setOnPlatform(int npcox1, int npcox2, int npcoy1){
        this.onPlatform = true;
        this.platformOx1 = npcox1;
        this.platformOx2 = npcox2;
        this.platformOy = npcoy1;
    }
    public boolean ifJumping(){return jumpThread? true: false;}
    public boolean ifOnPlatform(){return onPlatform;}
    public boolean ifFalling(){return ifFalling;}
    public void setToPosition(int Ox, int Oy){
        this.Ox = Ox;
        this.Oy = Oy;
    }
    public String getName(){return "Player";}
    public boolean isOnExit(){return onDoor;}
    @Override
    public void Move(int KeyCode) {
        if(KeyCode == 32 && !jumpThread){
            Thread spaceThread = new Thread(new Runnable(){
                @Override
                public void run() {
                    jumpThread = true;
                    int counter = 20;
                   if(!ifFalling) {
                       for (int i = 50; i > 0; i -= counter, counter -= 5) {
                           Oy -= i;
                           if (direction == Direction.LEFT) {
                               Ox -= speed;
                           }
                           if (direction == Direction.RIGHT) {
                               Ox += speed;
                           }
                           try {
                               Thread.sleep(85);
                           } catch (InterruptedException e) {
                           }
                       }
                   }
                   ifFalling = true;
                    counter = 5;
                    for(int i = 2; i <= 800; counter+=2, i+=counter){

                        if(!ifJumping()){
                            jumpThread = false;
                            ifFalling = false;
                            return;
                        }
                        if(counter >= 10){
                            counter = 10;
                            Oy+=counter;
                        }
                        else {
                            Oy+=i;
                        }
                        if(direction == Direction.LEFT){
                            Ox-=speed;
                        }
                        if(direction == Direction.RIGHT){
                            Ox+=speed;
                        }
                        if(ifOnPlatform()){
                            if(Ox+width < platformOx1 || Ox > platformOx2){
                                onPlatform = false;
                            }
                            else{
                                onPlatform = true;
                                if(Oy >= platformOy){
                                    Oy = platformOy-height;
                                    break;
                                }
                            }
                        }
                        if(Oy >= groundOy){
                            Oy = groundOy;
                            jumpThread = false;
                            ifFalling = false;
                            direction = Direction.NONE;
                            return;
                        }
                        try{
                            Thread.sleep(25);
                        }catch(InterruptedException e){}
                    }
                    jumpThread = false;
                    ifFalling = false;
                }
            }); spaceThread.start();
            return;
        }
        switch(KeyCode){
            case 37:
                playerImage = new ImageIcon("Data/Images/PlayerL.png").getImage();
                direction = Direction.LEFT;
                Ox-=speed;
                if(ifOnPlatform() && Ox+width < platformOx1){
                    ifFalling = true;
                    Ox+=speed;
                    Move(32);
                }
                break;

            case 39:
                playerImage = new ImageIcon("Data/Images/PlayerR.png").getImage();
                direction = Direction.RIGHT;
                Ox+=speed;
                if(ifOnPlatform() && Ox > platformOx2){
                    ifFalling = true;
                    Ox-=speed;
                    Move(32);
                }
                break;
        }
        if(Ox <= speed){
            Ox = speed+10;
        }
        if(Ox >= 1800){
            Ox = 1800;
        }
        if(Ox <= 50){
            Ox = 50;
        }
    }
    public void clearDirection(){
        direction = Direction.NONE;
    }
    public boolean hitCheck(int npcox1, int npcox2, int npcoy1, int npcoy2, NPC enemyI, Key key1, Key key2){
        int range = 50;
        int pox1 = this.Ox;
        int pox2 = pox1+this.width;
        int poy1 = this.Oy;
        int poy2 = poy1+this.height;
        if(pox1 > npcox1 && pox1 < npcox2 && poy1 > npcoy1 && poy1 < npcoy2){
            if(enemyI.getName() =="Door" && (this.isGetKey())){
                this.onDoor = true;
                return false;
            }
            if(enemyI.getMark()){
                this.gotKey();
                if(this.getName()=="Player") {
                    key1.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                if(this.getName()=="Player2"){
                    key2.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                return false;
            }
            else {
                this.makeHurt();
                if (this.getLife() == 0)
                    return true;
                this.setToPosition(70, 867);
                return false;
            }
        }
        //up right
        if(pox2 > npcox1 && pox2 < npcox2 && poy1 > npcoy1 && poy1 < npcoy2){
            if(enemyI.getName()=="Door"&&(this.isGetKey())){
                this.onDoor=true;
                return false;
            }
            if(enemyI.getMark()){
                this.gotKey();
                if(this.getName()=="Player") {
                    key1.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                if(this.getName()=="Player2"){
                    key2.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                return false;
            }
            else {
                this.makeHurt();
                if (this.getLife() == 0)
                    return true;
                this.setToPosition(70, 867);
                return false;
            }
        }
        //down left
        if(pox1 > npcox1 && pox1 < npcox2 && poy1 > npcoy1 && poy2 < npcoy2){
            if(enemyI.getName()=="Door"&&(this.isGetKey())){
                this.onDoor = true;
                return false;
            }
            if(enemyI.getMark()){
                this.gotKey();
                if(this.getName()=="Player") {
                    key1.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                if(this.getName()=="Player2"){
                    key2.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                return false;
            }
            else {
                this.makeHurt();
                if (this.getLife() == 0)
                    return true;
                this.setToPosition(70, 867);
                return false;
            }
        }
        //down right
        if(pox2 > npcox1 && pox2 < npcox2 && poy2 > npcoy1+range && poy2 < npcoy2+range){
            if(enemyI.getName()=="Door"&&(this.isGetKey())){
                this.onDoor = true;
                return false;
            }
            if(enemyI.getMark()){
                this.gotKey();
                if(this.getName()=="Player") {
                    key1.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                if(this.getName()=="Player2"){
                    key2.setImage(new ImageIcon("Data/Images/None.png").getImage());
                }
                return false;
            }
            else {
                this.makeHurt();
                if (this.getLife() == 0)
                    return true;
                this.setToPosition(70, 867);
                return false;
            }
        }
        return false;
    }
    public boolean checkPlatform(int pox1, int pox2, int poy1, int poy2, int npcox1, int npcox2, int npcoy1, int npcoy2){
        if(pox1 > npcox1 && pox1 < npcox2 && poy2 > npcoy1 && poy2 < npcoy2) {

            this.stopJumping();
            this.setToPosition(pox1, npcoy1-this.getHeight());
            this.setOnPlatform(npcox1, npcox2, npcoy1);
            return true;
        }
        if (pox2 > npcox1 && pox2 < npcox2 && poy2 > npcoy1 && poy2 < npcoy2) {

            this.stopJumping();
            this.setToPosition(pox1, npcoy1 - this.getHeight());
            this.setOnPlatform(npcox1, npcox2, npcoy1);
            return true;
        }
        return false;
    }

}
