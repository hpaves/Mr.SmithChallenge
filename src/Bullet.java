import javafx.scene.paint.Color;

public class Bullet extends Smith {

    public Bullet() { // this a bullet
        setWidth(getWidth() / 2); // it is always proportional to smith
        setHeight(getHeight() / 10); // it is always proportional to smith
        setFill(Color.BLACK);
    }

}

