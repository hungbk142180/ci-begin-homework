import base.BackGround;
import base.Player;
//import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
//import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BackGround background ;
    Player player ;

    public GameCanvas() {
        this.background = new BackGround();
        this.player = new Player();
    }

    public void run() {
        background.run();
        player.run();
    }

    public void render(Graphics g) {
        background.render(g);
        player.render(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
