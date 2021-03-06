package base.enemy;

import base.counter.FrameCounter;
import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
//    FrameCounter fireCounter;
    Action actionFire;
    Action actionMove;
    FrameCounter moveCounter;
    public Enemy() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/pink/0.png",
                "assets/images/enemies/level0/pink/1.png",
                "assets/images/enemies/level0/pink/2.png",
                "assets/images/enemies/level0/pink/3.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D();
        this.collider = new BoxCollider(28,28);
        this.moveCounter = new FrameCounter(60);
//        this.fireCounter = new FrameCounter(20);
        this.defineAction();
    }

    public void defineAction() {
        ActionWait actionWait = new ActionWait(20);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                //this.fire(); //actionFire.fire()
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        Action actionMove = new Action() {
            @Override
            public void run(GameObject master) {
                move();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequenceFire = new ActionSequence(actionWait, actionFire);
        ActionRepeat actionRepeatFire = new ActionRepeat(actionSequenceFire);

        ActionSequence actionSequenceMove = new ActionSequence(actionMove);
        ActionRepeat actionRepeatMove = new ActionRepeat(actionSequenceMove);

        this.actionFire = actionRepeatFire;
        this.actionMove = actionRepeatMove;
    }
    @Override
    public void run() {
        this.actionFire.run(this);
        this.actionMove.run(this);
    }

    public void fire() {
//        if (this.fireCounter.run()) {
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position.x + 5, this.position.y + 20);
//            this.fireCounter.reset();
//        }
    }

    public void move() {
        boolean moveCounterRun = moveCounter.run();
        if(moveCounterRun) {
            this.position.addThis(5, 0);
        } else {
            this.position.addThis(-5, 0);
        }
        if (this.position.x >= 358) {
            this.moveCounter.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
