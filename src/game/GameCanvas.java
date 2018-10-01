package game;

import base.*;
//import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BackGround background ;
    Player player ;
//    public static ArrayList<Enemy> enemies;
//    public static ArrayList<PlayerBullet> playerBullets;

    public GameCanvas() {
        //Khởi tạo các game object
        this.background = GameObject.create(BackGround.class);
        this.player = GameObject.create(Player.class);
//        enemies = new ArrayList<>();
//        playerBullets = new ArrayList<>();

        Enemy enemy = GameObject.create(Enemy.class);
    }

    public void run() {
//        player.run();
//        background.run();
//        for (Enemy enemy: enemies) {
//            enemy.run();
//        }
//        for (PlayerBullet playerBullet: playerBullets) {
//            playerBullet.run();
//        }
        GameObject.runAll();
    }

    public void render(Graphics g) {
//        background.render(g);
//        player.render(g);
//        for (Enemy enemy: enemies) {
//            enemy.render(g);
//        }
//        for (PlayerBullet playerBullet: playerBullets) {
//            playerBullet.render(g);
//        }
        GameObject.renderAll(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
