package base;
import base.counter.FrameCounter;
import game.GameCanvas;
import tklibs.SpriteUtils;
import java.awt.image.BufferedImage;

import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;

import java.util.ArrayList;

public class Player extends GameObject {
//    boolean isValidFire;
    FrameCounter fireCounter;
    public Player() {
//        ArrayList<BufferedImage> images = new ArrayList<>();
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
        );

        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X, Settings.START_PLAYER_POSITION_Y);
//        isValidFire = true;
        this.fireCounter = new FrameCounter(10);
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
        //fire
        boolean fireCounteRun = this.fireCounter.run();
        if(KeyEventPress.isFirePress && fireCounteRun) {
//        if(KeyEventPress.isFirePress) {
            this.fire();
        }

    }

    public void fire() {
//        if (this.fireCounter.run()) {
//        PlayerBullet bullet = new PlayerBullet();
//        GameCanvas.playerBullets.add(bullet);
        PlayerBullet bullet = GameObject.create(PlayerBullet.class);

        bullet.position.set(this.position.x, this.position.y);

        this.fireCounter.reset();
//        }
    }

    public void move(int translateX, int translateY) {
        this.position.addThis(translateX, translateY);
    }
}
