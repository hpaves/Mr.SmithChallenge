
import javafx.scene.paint.Color;

public class StrikeZone extends Neo {

    public StrikeZone () {
        setX(getX());
        setFill(Color.RED);
        System.out.println("strikezone konstruktor " + getX());
    }

    public void setStrikeZoneLocation(int value) {
        setX(value);
    }

}