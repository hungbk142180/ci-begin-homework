package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    BufferedImage image;
    int x;
    int y;

    public GameObject() {
    }

//    public GameObject(BufferedImage image) {
//        this.image = image;
//        this.x = 0;
//        this.y = 0;
//    }

    public void run() {

    }

    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);

    }
}
