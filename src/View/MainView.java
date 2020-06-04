package View;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MainView extends JPanel implements ActionListener {
    private Drawable[] drawArray;
    private NPC[] npcArray;
    private short countOfDrawable;
    private short countOfEnemies;
    private Player player;
    private Player player2;
    private Key key1;
    private Key key2;
    private Door door;
    private JFrame frame;
    private Image mainImage;
    private Timer timer = new Timer(1, this);

    public MainView(Image mainImage, JFrame frame, Drawable[] drawArray, NPC[] npcArray, short countOfDrawable, short countOfEnemies, Player player, Player player2, Key key1, Key key2, Door door ){
        this.frame = frame;
        timer.start();
        this.drawArray = drawArray;
        this.npcArray = npcArray;
        this.countOfEnemies = countOfEnemies;
        this.countOfDrawable = countOfDrawable;
        this.player = player;
        this.player2 = player2;
        this.key1 = key1;
        this.key2 = key2;
        this.door = door;
        this.mainImage = mainImage;

        enemyStart(npcArray, countOfDrawable, countOfEnemies, door, key1, key2);
        frame.addKeyListener(new KeyAdapter(){

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                player.Move(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                player.Move(e.getKeyCode());

            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode()!=32){
                    player.clearDirection();

                }
            }
        });
        Thread player2Thread = new Thread(new Runnable(){
            public void run(){
                frame.addKeyListener(new KeyAdapter(){

                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);

                        player2.Move(e.getKeyCode());
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                        player2.Move(e.getKeyCode());

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);
                        if(e.getKeyCode()!=32){
                            player2.clearDirection();

                        }
                    }
                });

            }
        }); player2Thread.start();
    }

    public void paint (Graphics g) {
        g.drawImage(mainImage, 0, 0, frame.getWidth(), frame.getHeight(), null);
        String type;
        PlayerView.paintHearts(g, player.getLife());
        Player2View.paintHearts(g, player2.getLife());
        for (int i = 0; i < countOfDrawable; i++) {

            type = drawArray[i].getName();
            if(type == "Door"){
                DoorView.paint(g, drawArray[i].getOx(), drawArray[i].getOy(), drawArray[i].getWidth(), drawArray[i].getHeight());
            }
            if(type == "Enemy"){
                EnemyView.paint(g, drawArray[i].getImage(), drawArray[i].getOx(), drawArray[i].getOy(), drawArray[i].getWidth(), drawArray[i].getHeight());
            }
            if(type == "Key"){
                KeyView.paint(g, drawArray[i].getOx(), drawArray[i].getOy(), drawArray[i].getWidth(), drawArray[i].getHeight(), drawArray[i].getImage());
            }
            if(type == "Panel"){
                PanelView.paint(g, drawArray[i].getOx(), drawArray[i].getOy(), drawArray[i].getWidth(), drawArray[i].getHeight());
            }
            if(type == "Shoot"){
                ShootView.paint(g, drawArray[i].getImage(), drawArray[i].getOx(), drawArray[i].getOy(), drawArray[i].getWidth(), drawArray[i].getHeight());
            }
            PlayerView.paint(g, player.getImage(), player.getOx(), player.getOy(), player.getWidth(), player.getHeight());
            PlayerView.paint(g, player2.getImage(), player2.getOx(), player2.getOy(), player2.getWidth(), player2.getHeight());
        }
    }
    public void actionPerformed(ActionEvent e){
        repaint();
    }

    public void enemyStart(NPC[] npcArray, short countOfDrawable, short enemyCount, Door door,  Key key1, Key key2){
        Thread enemyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                int pos;
                Ok:
                while(true){
                    for(int i = 0; i < countOfDrawable; i++){

                        if(i < 12 || i > 15) {
                            pos = 12+rand.nextInt(4);
                            npcArray[pos].Move(0);
                            npcArray[i].Move(0);
                            if (interaction(npcArray, countOfDrawable, enemyCount, key1, key2) == 1) {

                                JOptionPane.showMessageDialog(null, "YOU ARE DEAD. TRY AGAIN :(");
                                System.exit(1);
                                break Ok;
                            }
                        }
                    }
                    try{
                        Thread.sleep(17);
                    }catch (InterruptedException e){}
                }
                return;
            }
        }); enemyThread.start();
        return;
    }


    public int interaction(NPC[] npcArray, short countOfDrawable, int enemyCount, Key key1, Key key2){
        int pox1;
        int pox2;
        int poy1;
        int poy2;
        int pox11;
        int pox21;
        int poy11;
        int poy21;
        int npcox2;
        int npcoy1;
        int npcox1;
        int npcoy2;

        pox1 = player.getOx();
        pox2 = pox1+player.getWidth();
        poy1 = player.getOy();
        poy2 = poy1+player.getHeight();

        pox11 = player2.getOx();
        pox21 = pox11+player2.getWidth();
        poy11 = player2.getOy();
        poy21 = poy11+player2.getHeight();

        for(int i = 0; i < countOfDrawable;i++){

            npcox1 = npcArray[i].getOx();
            npcox2 = npcox1+npcArray[i].getWidth();
            npcoy1 = npcArray[i].getOy();
            npcoy2 = npcoy1+npcArray[i].getHeight();

           if(player.isOnExit() && player2.isOnExit()){

               CreateLevels.createLevel(frame, player, player2, countOfDrawable, countOfEnemies);

            }
            if(i < enemyCount){
                if ((player.hitCheck(npcox1, npcox2, npcoy1, npcoy2, npcArray[i], key1, key2))|(player2.hitCheck(npcox1, npcox2, npcoy1, npcoy2, npcArray[i], key1, key2))){
                    return 1;
                }

                continue;
            }

           if(player.ifFalling()) {
                if(player.checkPlatform(pox1, pox2, poy1, poy2, npcox1, npcox2, npcoy1, npcoy2)){
                    return 0;
                }
            }
            if(player2.ifFalling()) {
                if(player2.checkPlatform(pox11, pox21, poy11, poy21,npcox1, npcox2, npcoy1, npcoy2 )){
                    return 0;
                }
            }
        }

        return 0;
    }


}



