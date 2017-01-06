
import javafx.scene.paint.Color;

public class StrikeZone extends Neo {

    public StrikeZone () {
        setX(getX()); //strikezone appears by neo
        setFill(Color.RED);
    }

    public void setStrikeZoneLocation(int valueX, int valueY) { // strikezone moves with neo
        setX(valueX); // on the X axis
        setY(valueY); // and on the Y axis
    }

}