import javafx.scene.paint.Color;

public class Shades extends Neo {

    public Shades() { // these are neo's shades, which help to see which way he's facing
        setWidth(getWidth() / 2); // shades are always proportional to neo
        setHeight(getHeight() / 10); // shades are always proportional to neo
        setFill(Color.DEEPSKYBLUE);
    }

    public void setShadesLocation(int valueX, int valueY) { // shades move with neo
        setX(valueX); // on the X axis
        setY(valueY); // and on the Y axis
    }

}