package Model;
import View.MainView;
import javax.swing.*;
import java.awt.*;

public class CreateLevels {

    public CreateLevels(){}
    public static void createLevel(JFrame frame, Player player1, Player player2,   short countOfDrawable, short countOfEnemies){

        Drawable[] drawArray;
        NPC[] npcArray;
        Image img1 = new ImageIcon("Data/Images/Key.png").getImage();
        Image img2 = new ImageIcon("Data/Images/Key2.png").getImage();
        MainView view;
        player1.highLevel();
        player1.noExit();
       if(player1.getLevel()==1){
            Image mainImage = new ImageIcon("Data/Levels/Level1.jpg").getImage();
            drawArray = new Drawable[36];
            npcArray = new NPC[36];
            countOfDrawable = 0;
            countOfEnemies = 0;
            Enemy enemy = new Enemy(840, 392, 80, 90, 1, false, 840, 1030, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy;
            Enemy enemy2 = new Enemy(700, 297, 80, 90, 1, false, 520, 700, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy2;
            Enemy enemy3 = new Enemy(1250, 637, 80, 90, 1, false, 1250, 1700, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy3;
            Enemy enemy4 = new Enemy(1100, 836, 80, 90, 1, false, 900, 1800, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy4;
            Enemy enemy5 = new Enemy(13, 641, 80, 90, 1, false, 13, 600, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy5;
            Enemy enemy6 = new Enemy(363, 480, 80, 90, 1, false, 363, 478, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy6;
            Enemy enemy7 = new Enemy(1330, 300, 80, 90, 1, false, 1140, 1330, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy7;
            Enemy enemy8 = new Enemy(890, 110, 80, 90, 1, false, 890, 1090, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy8;
            Enemy enemy9 = new Enemy(1800, 435, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy9;
            Enemy enemy10 = new Enemy(1800, 320, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy10;
            Enemy enemy11 = new Enemy(1800, 160, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy11;
            Enemy enemy12 = new Enemy(1800, 48, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy12;
            npcArray[0] = enemy;
            countOfEnemies++;
            npcArray[1] = enemy2;
            countOfEnemies++;
            npcArray[2] = enemy3;
            countOfEnemies++;
            npcArray[3] = enemy4;
            countOfEnemies++;
            npcArray[4] = enemy5;
            countOfEnemies++;
            npcArray[5] = enemy6;
            countOfEnemies++;
            npcArray[6] = enemy7;
            countOfEnemies++;
            npcArray[7] = enemy8;
            countOfEnemies++;
            npcArray[8] = enemy9;
            countOfEnemies++;
            npcArray[9] = enemy10;
            countOfEnemies++;
            npcArray[10] = enemy11;
            countOfEnemies++;
            npcArray[11] = enemy12;
            countOfEnemies++;

            Key key1 = new Key(80, 70, 1, 32, 50, 840, 1030, 80, 100, img1);
            drawArray[countOfDrawable++] = key1;
            npcArray[16] = key1;
            countOfEnemies++;
            Key key2 = new Key(120, 70, 1, 32, 50, 200, 1030, 80, 100, img2);
            drawArray[countOfDrawable++] = key2;
            npcArray[17] = key2;
            countOfEnemies++;

            Door door = new Door(1817, 606, 120, 129);
            drawArray[countOfDrawable++] = door;
            npcArray[18] = door;
            countOfEnemies++;

            Panels panel1 = new Panels(678, 823, 230, 35);
            drawArray[countOfDrawable++] = panel1;
            Panels panel2 = new Panels(13, 731, 635, 35);
            drawArray[countOfDrawable++] = panel2;
            Panels panel3 = new Panels(25, 644, 240, 35);
            drawArray[countOfDrawable++] = panel3;
            Panels panel4 = new Panels(363, 567, 240, 35);
            drawArray[countOfDrawable++] = panel4;
            Panels panel5 = new Panels(230, 505, 115, 35);
            drawArray[countOfDrawable++] = panel5;
            Panels panel6 = new Panels(365, 430, 115, 35);
            drawArray[countOfDrawable++] = panel6;
            Panels panel7 = new Panels(560, 390, 240, 35);
            drawArray[countOfDrawable++] = panel7;
            Panels panel8 = new Panels(860, 486, 240, 35);
            drawArray[countOfDrawable++] = panel8;
            Panels panel9 = new Panels(1140, 391, 235, 35);
            drawArray[countOfDrawable++] = panel9;
            Panels panel10 = new Panels(1470, 325, 235, 35);
            drawArray[countOfDrawable++] = panel10;
            Panels panel11 = new Panels(1180, 250, 235, 35);
            drawArray[countOfDrawable++] = panel11;
            Panels panel12 = new Panels(900, 197, 235, 35);
            drawArray[countOfDrawable++] = panel12;
            Panels panel13 = new Panels(570, 195, 235, 35);
            drawArray[countOfDrawable++] = panel13;
            Panels panel14 = new Panels(400, 160, 115, 35);
            drawArray[countOfDrawable++] = panel14;
            Panels panel15 = new Panels(232, 205, 115, 35);
            drawArray[countOfDrawable++] = panel15;
            Panels panel16 = new Panels(75, 160, 115, 35);
            drawArray[countOfDrawable++] = panel16;
            Panels panel17 = new Panels(1290, 730, 635, 35);
            drawArray[countOfDrawable++] = panel17;

            npcArray[19] = panel1;
            npcArray[20] = panel2;
            npcArray[21] = panel3;
            npcArray[22] = panel4;
            npcArray[23] = panel5;
            npcArray[24] = panel6;
            npcArray[25] = panel7;
            npcArray[26] = panel8;
            npcArray[27] = panel9;
            npcArray[28] = panel10;
            npcArray[29] = panel11;
            npcArray[30] = panel12;
            npcArray[31] = panel13;
            npcArray[32] = panel14;
            npcArray[33] = panel15;
            npcArray[34] = panel16;
            npcArray[35] = panel17;

            Shoot shoot1 = new Shoot(1740, 100, 1, 80, 30, 0, 1740);
            drawArray[countOfDrawable++] = shoot1;
            Shoot shoot2 = new Shoot(1740, 210, 2, 80, 30, 0, 1740);
            drawArray[countOfDrawable++] = shoot2;
            Shoot shoot3 = new Shoot(1740, 370, 1, 80, 30, 0, 1740);
            drawArray[countOfDrawable++] = shoot3;
            Shoot shoot4 = new Shoot(1740, 485, 2, 80, 30, 0, 1740);
            drawArray[countOfDrawable++] = shoot4;
            npcArray[12] = shoot1;
            countOfEnemies++;
            npcArray[13] = shoot2;
            countOfEnemies++;
            npcArray[14] = shoot3;
            countOfEnemies++;
            npcArray[15] = shoot4;
            countOfEnemies++;
            view = new MainView(mainImage, frame, drawArray, npcArray, countOfDrawable, countOfEnemies,player1, player2, key1, key2, door);
            frame.getContentPane().add(view);
            frame.setVisible(true);
        }
       if(player1.getLevel()==2){
            player1.setToPosition(70, 867);
            player2.setToPosition(70, 867);
            countOfDrawable = 0;
            countOfEnemies = 0;
            drawArray = new Drawable[23];
            npcArray = new NPC[23];

            Panels panel1 = new Panels(967, 845, 230, 35);
            drawArray[countOfDrawable++] = panel1;
            Panels panel2 = new Panels(695, 800, 230, 35);
            drawArray[countOfDrawable++] = panel2;
            Panels panel3 = new Panels(965, 715, 240, 35);
            drawArray[countOfDrawable++] = panel3;
            Panels panel4 = new Panels(680, 645, 240, 35);
            drawArray[countOfDrawable++] = panel4;
            Panels panel5 = new Panels(940, 542, 240, 35);
            drawArray[countOfDrawable++] = panel5;
            Panels panel6 = new Panels(825, 435, 240, 35);
            drawArray[countOfDrawable++] = panel6;
            Panels panel7 = new Panels(560, 390, 240, 35);
            drawArray[countOfDrawable++] = panel7;
            Panels panel8 = new Panels(317, 442, 240, 35);
            drawArray[countOfDrawable++] = panel8;
            Panels panel9 = new Panels(76, 390, 235, 35);
            drawArray[countOfDrawable++] = panel9;
            Panels panel10 = new Panels(1140, 390, 235, 35);
            drawArray[countOfDrawable++] = panel10;
            Panels panel11 = new Panels(1410, 430, 115, 35);
            drawArray[countOfDrawable++] = panel11;
            Panels panel12 = new Panels(1560, 390, 235, 35);
            drawArray[countOfDrawable++] = panel12;
            Panels panel13 = new Panels(10, 730, 635, 35);
            drawArray[countOfDrawable++] = panel13;
            Panels panel14 = new Panels(1290, 730, 635, 35);
            drawArray[countOfDrawable++] = panel14;

            npcArray[9] = panel1;
            npcArray[10] = panel2;
            npcArray[11] = panel3;
            npcArray[12] = panel4;
            npcArray[13] = panel5;
            npcArray[14] = panel6;
            npcArray[15] = panel7;
            npcArray[16] = panel8;
            npcArray[17] = panel9;
            npcArray[18] = panel10;
            npcArray[19] = panel11;
            npcArray[20] = panel12;
            npcArray[21] = panel13;
            npcArray[22] = panel14;

            Enemy enemy1 = new Enemy(1050, 754, 80, 90, 1, false, 967, 1150, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy1;
            Enemy enemy2 = new Enemy(700, 553, 80, 90, 1, false, 680, 860, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy2;
            Enemy enemy3 = new Enemy(850, 350, 80, 90, 1, false, 825, 1025, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy3;
            Enemy enemy4 = new Enemy(100, 645, 80, 90, 1, false, 10, 595, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy4;
            Enemy enemy5 = new Enemy(1500, 630, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
            drawArray[countOfDrawable++] = enemy5;
            Shoot shoot1 = new Shoot(1430, 680, 7, 80,30, 0, 1430 );
            drawArray[countOfDrawable++] = shoot1;

            npcArray[0] = enemy1;
            countOfEnemies++;
            npcArray[1] = shoot1;
            countOfEnemies++;
            npcArray[2] = enemy2;
            countOfEnemies++;
            npcArray[3] = enemy3;
            countOfEnemies++;
            npcArray[4] = enemy4;
            countOfEnemies++;
            npcArray[5] = enemy5;
            countOfEnemies++;


            Image Mainimg = new ImageIcon("Data/Levels/Level2.jpg").getImage();
            Key key1 = new Key(90, 320, 1, 32, 55, 840, 1030, 320, 340, img1);
            drawArray[countOfDrawable++] = key1;
            npcArray[6] = key1;
            countOfEnemies++;
            Key key2 = new Key(1600, 320, 1, 32, 55, 840, 1030, 320, 340, img2);
            drawArray[countOfDrawable++] = key2;
            npcArray[7] = key2;
            countOfEnemies++;
            Door door = new Door(1817, 606, 120, 129);
            drawArray[countOfDrawable++] = door;
            npcArray[8] = door;
            countOfEnemies++;

            Image img  = new ImageIcon("Data/Images/PlayerR.png").getImage();
            player1 = new Player(70, 867, 867, 35, 55, 15, 3, img);
            img  = new ImageIcon("Data/Images/Player1R.png").getImage();
            player2 = new Player2(70, 867, 867, 35, 55, 15, 3, img);
            player1.setLevel(2);


            view = new MainView(Mainimg, frame, drawArray, npcArray, countOfDrawable, countOfEnemies,player1, player2, key1, key2, door);
            frame.getContentPane().removeAll();
            frame.setContentPane(view);
            frame.setVisible(true);
        }
       if(player1.getLevel()==3){
           player1.setToPosition(70, 867);
           player2.setToPosition(70, 867);
            countOfDrawable = 0;
            countOfEnemies = 0;
            drawArray = new Drawable[30];
            npcArray = new NPC[30];
            Image Mainimg = new ImageIcon("Data/Levels/Level3.jpg").getImage();

            Image img  = new ImageIcon("Data/Images/PlayerR.png").getImage();
            player1 = new Player(70, 867, 867, 35, 55, 15, 3, img);
            img  = new ImageIcon("Data/Images/Player1R.png").getImage();
            player2 = new Player2(70, 867, 867, 35, 55, 15, 3, img);


            Key key1 = new Key(90, 100, 1, 32, 55, 90, 1030, 160, 175, img1);
            drawArray[countOfDrawable++] = key1;
            npcArray[10] = key1;
            countOfEnemies++;
            Key key2 = new Key(130, 100, 1, 32, 55, 130, 1030, 160, 175, img2);
            drawArray[countOfDrawable++] = key2;
            npcArray[11] = key2;
            countOfEnemies++;
            Door door = new Door(1817, 606, 120, 129);
            drawArray[countOfDrawable++] = door;
            npcArray[15] = door;
            countOfEnemies++;

        Panels panel1 = new Panels(935, 850, 115, 35);
        drawArray[countOfDrawable++] = panel1;
        Panels panel2 = new Panels(13, 731, 635, 35);
        drawArray[countOfDrawable++] = panel2;
        Panels panel3 = new Panels(656, 794, 240, 35);
        drawArray[countOfDrawable++] = panel3;
        Panels panel4 = new Panels(200, 645, 240, 35);
        drawArray[countOfDrawable++] = panel4;
        Panels panel5 = new Panels(13, 550, 240, 35);
        drawArray[countOfDrawable++] = panel5;
        Panels panel6 = new Panels(240, 440, 240, 35);
        drawArray[countOfDrawable++] = panel6;
        Panels panel7 = new Panels(560, 390, 240, 35);
        drawArray[countOfDrawable++] = panel7;
        Panels panel8 = new Panels(810, 305, 240, 35);
        drawArray[countOfDrawable++] = panel8;
        Panels panel9 = new Panels(1140, 390, 240, 35);
        drawArray[countOfDrawable++] = panel9;
        Panels panel10 = new Panels(1050, 230, 240, 35);
        drawArray[countOfDrawable++] = panel10;
        Panels panel11 = new Panels(760, 160, 240, 35);
        drawArray[countOfDrawable++] = panel11;
        Panels panel12 = new Panels(395, 160, 235, 35);
        drawArray[countOfDrawable++] = panel12;
        Panels panel13 = new Panels(30, 226, 235, 35);
        drawArray[countOfDrawable++] = panel13;
        Panels panel14 = new Panels(1290, 730, 635, 35);
        drawArray[countOfDrawable++] = panel14;

        npcArray[16] = panel1;
        npcArray[17] = panel2;
        npcArray[18] = panel3;
        npcArray[19] = panel4;
        npcArray[20] = panel5;
        npcArray[21] = panel6;
        npcArray[22] = panel7;
        npcArray[23] = panel8;
        npcArray[24] = panel9;
        npcArray[25] = panel10;
        npcArray[26] = panel11;
        npcArray[27] = panel12;
        npcArray[28] = panel13;
        npcArray[29] = panel14;

        Enemy enemy1 = new Enemy(575, 645, 80, 90, 1, false, 20, 575, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy1;
        Enemy enemy2 = new Enemy(20, 465, 80, 90, 1, false, 20, 180, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy2;
        Enemy enemy3 = new Enemy(720, 300, 80, 90, 1, false, 560, 720, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy3;
        Enemy enemy4 = new Enemy(1025, 140, 80, 90, 1, false, 1025, 1220, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy4;
        Enemy enemy5 = new Enemy(1110, 300, 80, 90, 1, false, 1110, 1320, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy5;
        Enemy enemy6 = new Enemy(395, 70, 80, 90, 1, false, 395, 550, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy6;
        Enemy enemy7 = new Enemy(1290, 645, 80, 90, 1, false, 1290, 1700, 510, 550, new ImageIcon("Data/Images/HandLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy7;

        Enemy enemy8 = new Enemy(1800, 445, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy8;
        Enemy enemy9 = new Enemy(1800, 290, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy9;
        Enemy enemy10 = new Enemy(1800, 120, 90, 120, 0, true, 1250, 1800, 510, 550, new ImageIcon("Data/Images/ShooterLeft.png").getImage());
        drawArray[countOfDrawable++] = enemy10;

        npcArray[0] = enemy1;
        countOfEnemies++;
        npcArray[1] = enemy2;
        countOfEnemies++;
        npcArray[2] = enemy3;
        countOfEnemies++;
        npcArray[3] = enemy4;
        countOfEnemies++;
        npcArray[4] = enemy5;
        countOfEnemies++;
        npcArray[5] = enemy6;
        countOfEnemies++;
        npcArray[6] = enemy7;
        countOfEnemies++;
        npcArray[7] = enemy8;
        countOfEnemies++;
        npcArray[8] = enemy9;
        countOfEnemies++;
        npcArray[9] = enemy10;
        countOfEnemies++;

        Shoot shoot1 = new Shoot(1725, 505, 2, 80, 30, 0, 1740);
        drawArray[countOfDrawable++] = shoot1;
        Shoot shoot2 = new Shoot(1725, 350, 3, 80, 30, 0, 1740);
        drawArray[countOfDrawable++] = shoot2;
        Shoot shoot3 = new Shoot(1725, 180, 2, 80, 30, 0, 1740);
        drawArray[countOfDrawable++] = shoot3;
        npcArray[12] = shoot1;
        countOfEnemies++;
        npcArray[13] = shoot2;
        countOfEnemies++;
        npcArray[14] = shoot3;
        countOfEnemies++;


            view = new MainView(Mainimg, frame, drawArray, npcArray, countOfDrawable, countOfEnemies,player1, player2, key1, key2, door);
            frame.getContentPane().removeAll();
            frame.setContentPane(view);
            frame.setVisible(true);
        }
    }
}