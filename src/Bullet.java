import javafx.scene.paint.Color;

public class Bullet extends Smith {

    public static boolean spawnLeft;

    public Bullet() { // this a bullet
        setWidth(getWidth() / 2); // it is always proportional to smith
        setHeight(getHeight() / 10); // it is always proportional to smith
        setFill(Color.BLACK);
        if (Smith.leftRightRandomizer == 0) {
            spawnLeft = true;
        }
        if (Smith.leftRightRandomizer == 1) {
            spawnLeft = false;
        }
    }

}

