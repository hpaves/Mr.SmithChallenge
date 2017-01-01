
import javafx.scene.paint.Color;

public class StrikeZone extends Neo {

    public StrikeZone () {
        setX(getX()); //strikezone appears by neo
        setFill(Color.RED);
    }

    public void setStrikeZoneLocation(int value) { //strikezone moves with neo
        setX(value);
    }

}