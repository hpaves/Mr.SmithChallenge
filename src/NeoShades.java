import javafx.scene.paint.Color;

public class NeoShades extends Fighter {

    public NeoShades() {
        setX(getX());
        setY(Brawl.fieldHeight - getHeight() + (getHeight() / 8));
        setWidth(getWidth() / 2);
        setHeight(getHeight() / 10);
        setFill(Color.DEEPSKYBLUE);
    }

    public void setShadesLocation(int value) {
        setX(value);
    }
}