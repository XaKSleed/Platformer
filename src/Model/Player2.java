package Model;
import javax.swing.*;
import java.awt.*;

public class Player2 extends Player {

    public Player2(int Ox, int Oy, int groundOy, int width, int height, int speed, int life, Image img){
        super(Ox, Oy, groundOy, width, height, speed, life, img);
    }

    @Override
    public void Move(int KeyCode) {
        if(KeyCode == 16 && this.jumpThread == false){
            Thread space2Thread = new Thread(new Runnable(){
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
            }); space2Thread.start();
            return;
        }
        switch(KeyCode){
            case 90:
                playerImage = new ImageIcon("Data/Images/Player1L.png").getImage();
                direction = Direction.LEFT;
                Ox-=speed;
                if(ifOnPlatform() && Ox+width < platformOx1){
                    ifFalling = true;
                    Ox+=speed;
                    Move(87);
                }
                break;

            case 67:
                playerImage = new ImageIcon("Data/Images/Player1R.png").getImage();
                direction = Direction.RIGHT;
                Ox+=speed;
                if(ifOnPlatform() && Ox > platformOx2){
                    ifFalling = true;
                    Ox-=speed;
                    Move(87);
                }
                break;
        }
        if(Ox <= speed){
            Ox = speed+10;
        }
        if(Ox >= 2000){
            Ox = 2000;
        }
        if(Ox <= 50){
            Ox = 50;
        }
    }
    public String getName(){return "Player2";}
}
