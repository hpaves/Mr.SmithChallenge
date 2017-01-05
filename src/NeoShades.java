import javafx.scene.paint.Color;

public class NeoShades extends Neo {

    public NeoShades() { // these are neo's shades, which help to see which way he's facing
        setWidth(getWidth() / 2); // shades are always proportional to neo
        setHeight(getHeight() / 10);
        setFill(Color.DEEPSKYBLUE);
    }

    public void setShadesLocation(int valueX, int valueY) { // shades move with neo
        setX(valueX);
        setY(valueY);
    }

}