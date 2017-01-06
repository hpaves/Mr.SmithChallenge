import javafx.scene.paint.Color;

public class Smith extends Fighter {

    public static boolean spawnLeft;

    public Smith () {
        int location;
        int leftRightRandomizer = (int) (Math.random() * 2); // generate 0 or 1
        if (leftRightRandomizer == 0) {
            location = 0; // smith starts from he left end of the screen
            spawnLeft = true;
        } else {
            location = (int) (Brawl.fieldLength - getWidth()); // smith starts at the right end of the screen
            spawnLeft = false;
        }
        setX(location); // actually sets the location
        setFill(Color.DARKGRAY);
    }

}