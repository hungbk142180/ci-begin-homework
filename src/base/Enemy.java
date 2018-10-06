package base;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
    public Enemy() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/pink/0.png",
                "assets/images/enemies/level0/pink/1.png",
                "assets/images/enemies/level0/pink/2.png",
                "assets/images/enemies/level0/pink/3.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(200,100);
        this.collider = new BoxCollider(28,28);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
