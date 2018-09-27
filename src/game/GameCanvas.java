package game;

import base.BackGround;
import base.Enemy;
import base.Player;
import base.PlayerBullet;
//import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BackGround background ;
    Player player ;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<PlayerBullet> playerBullets;

    public GameCanvas() {
        this.player = new Player();
        this.background = new BackGround();
        enemies = new ArrayList<>();
        playerBullets = new ArrayList<>();
    }

    public void run() {
        player.run();
        background.run();
        for (Enemy enemy: enemies) {
            enemy.run();
        }
        for (PlayerBullet playerBullet: playerBullets) {
            playerBullet.run();
        }
    }

    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        for (Enemy enemy: enemies) {
            enemy.render(g);
        }
        for (PlayerBullet playerBullet: playerBullets) {
            playerBullet.render(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
