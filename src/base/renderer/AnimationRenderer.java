package base.renderer;

import base.GameObject;
import base.counter.FrameCounter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImage = 0;
//    int frameCount = 0;
    FrameCounter frameCounter;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.frameCounter = new FrameCounter(5);
    }
    //Hàm khởi tạo sau có tác dụng thay đổi tốc độ hoạt động render của một object
    public AnimationRenderer(ArrayList<BufferedImage> images, int frameCount) {
        this.images = images;
        this.frameCounter = new FrameCounter(frameCount);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        if (images.size() > 0) {
            g.drawImage(images.get(currentImage), (int)master.position.x, (int)master.position.y, null);
            if (this.frameCounter.run()) {
                currentImage++;
                if (currentImage >= images.size() - 1) {
                    currentImage = 0;
                }
                frameCounter.reset();
            }
        }
    }
}
