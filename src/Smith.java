import javafx.scene.paint.Color;

public class Smith extends Fighter {

    public static int leftRightRandomizer;

    public Smith () {
        int location;
        leftRightRandomizer = (int) (Math.random() * 2); // generate 0 or 1
        if (leftRightRandomizer == 0) {
            location = 0; // smith starts from he left end of the screen
        } else {
            location = (int) (Brawl.fieldLength - getWidth()); // smith starts at the right end of the screen
        }
        setX(location); // actually sets the location
        setFill(Color.DARKGRAY);
    }

}