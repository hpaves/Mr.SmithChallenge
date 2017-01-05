import javafx.scene.paint.Color;

public class NeoShades extends Neo {

    public NeoShades() { // these are neo's shades, which help to see which way he's facing
        setX(getX());  //shades appear on neo
        setY(Brawl.neo.getY() + (getHeight() / 8)); // and on the correct height
        setWidth(getWidth() / 2); // shades are always proportional to neo
        setHeight(getHeight() / 10);
        setFill(Color.DEEPSKYBLUE);
    }

    public void setShadesOrientation(int value) { // shades move when neo turns
        setX(value);
    }

}