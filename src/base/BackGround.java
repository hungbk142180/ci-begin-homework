package base;

import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackGround extends GameObject {
    public BackGround() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.image = image;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void run() {
        // Ý tưởng: thêm điều kiện chỉ chạy khi tọa độ y >= (height của ảnh background - height của cửa sổ phần mềm windows)
        if (this.y >= -image.getHeight() + 600) {
            this.y -=1;
        }
    }


}
