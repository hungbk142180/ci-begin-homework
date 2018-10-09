package base.enemy;

import base.GameObject;
import base.Vector2D;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.counter.FrameCounter;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.util.ArrayList;

public class EnemySummoner extends GameObject {
    Action actionSpawn;
    FrameCounter spawnCounter;
    public EnemySummoner() {
        super();
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/spawn/spawnOpen.png"));
        this.position = new Vector2D(350, 100);
        this.defineAction();
    }

    public void defineAction() {
        ActionWait actionWait = new ActionWait(300);
        Action actionSpawn = new Action() {
            @Override
            public void run(GameObject master) {
                spawn();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        ActionSequence actionSequenceSpawn = new ActionSequence(actionSpawn, actionWait);
        ActionRepeat actionRepeatSpawn = new ActionRepeat(actionSequenceSpawn);

        this.actionSpawn = actionRepeatSpawn;
    }

    @Override
    public void run() {
        this.actionSpawn.run(this);
    }

    public void spawn(){
        Enemy enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(this.position.x - 10, this.position.y);
    }
}
