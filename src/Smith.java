import javafx.scene.paint.Color;

public class Smith extends Fighter {

    public Smith () {
        int smithLocation;
        int smithRandomizer = (int) (Math.random() * 2);
        if (smithRandomizer == 0) {
            smithLocation = (int) getWidth();
        } else {
            smithLocation = (int) (Brawl.fieldLength - getWidth() + getWidth());
        }
        setX(smithLocation);
        setFill(Color.DARKGRAY);
        System.out.println("smith konstruktor " + getX());
    }

}