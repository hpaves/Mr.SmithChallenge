import javafx.scene.paint.Color;

public class Bullet extends Smith {

    public static boolean spawnLeft; // this can be called out from other classes

    public Bullet() { // this a bullet
        setWidth(getWidth() / 2); // it is always proportional to smith
        setHeight(getHeight() / 10); // it is always proportional to smith
        setFill(Color.BLACK);
        if (Smith.leftRightRandomizer == 0) { // checks smith randomizer
            spawnLeft = true; // and marks down that it comes from the left
        }
        if (Smith.leftRightRandomizer == 1) { // checks smith randomizer
            spawnLeft = false; // and marks down that it comes from the left
        }
    }

}

