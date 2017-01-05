
import javafx.scene.paint.Color;

public class StrikeZone extends Neo {

    public StrikeZone () {
        setX(getX()); //strikezone appears by neo
        setFill(Color.RED);
    }

    public void setStrikeZoneOrientation(int value) { //strikezone moves when neo turns
        setX(value);
    }

}