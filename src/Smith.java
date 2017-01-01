import javafx.scene.paint.Color;

public class Smith extends Fighter {

    public Smith () {
        int smithLocation;
        int smithRandomizer = (int) (Math.random() * 2); // generate 0 or 1
        if (smithRandomizer == 0) {
            smithLocation = 0; // smith starts from he left end of the screen
        } else {
            smithLocation = (int) (Brawl.fieldLength - getWidth()); // smith starts at the right end of the screen
        }
        setX(smithLocation); // actually sets the location
        setFill(Color.DARKGRAY);
        System.out.println("smith konstruktor " + getX());
    }

}