import javafx.scene.paint.Color;

public class StrikeZone extends Neo {

    public StrikeZone () {
        setX(getX() - getWidth() / 2);
        setWidth(getWidth() * 2);
        setFill(Color.RED);
        System.out.println("strikezone konstruktor " + getX());
    }
}