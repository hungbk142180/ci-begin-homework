package base.counter;

public class FrameCounter {
    int frameCount;
    int maxCount;
    public FrameCounter(int maxCount) {
        this.maxCount = maxCount;
        this.frameCount = 0;
    }

    public boolean run() {
        if(frameCount >= maxCount) {
            return true;
        } else {
            frameCount ++;
            return false;
        }
    }

//    public boolean run(int resetPoint) {
//        if(frameCount >= maxCount && frameCount <= resetPoint) {
//            frameCount++;
//            return true;
//        } else if(frameCount < maxCount) {
//            frameCount ++;
//            return false;
//        } else {
//            reset();
//            return true;
//        }
//    }

    public void reset() {
        this.frameCount = 0;
    }
}
