import javafx.scene.paint.Color;

public class StrikeZone extends Neo {

    public StrikeZone () {
        setX(getX() - 25);
        setWidth(100);
        setFill(Color.RED);
        System.out.println("strikezone konstruktor " + getX());
    }
}