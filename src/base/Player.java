package base;
import game.GameCanvas;
import tklibs.SpriteUtils;
import java.awt.image.BufferedImage;

import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;

import java.util.ArrayList;

public class Player extends GameObject {
    public Player() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));

        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X, Settings.START_PLAYER_POSITION_Y);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            this.move(0, -1);
        }

        if(KeyEventPress.isDownPress) {
            this.move(0, 1);
        }

        if(KeyEventPress.isLeftPress) {
            this.move(-1, 0);
        }

        if(KeyEventPress.isRightPress) {
            this.move(1, 0);
        }
    }

    void shoot() {
        //...
        PlayerBullet bullet = new PlayerBullet();
        GameCanvas.playerBullets.add(bullet);
    }

    public void move(int translateX, int translateY) {
        this.position.addThis(translateX, translateY);
    }
}
