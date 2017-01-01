import javafx.scene.shape.Rectangle;

public class Fighter extends Rectangle {

    public Fighter () { // this is a fighter; a basis for all the fighting characters
        setWidth(50); // how fat
        setHeight(100); // how tall
        setX(Brawl.fieldLength / 2); // appears in the middle
        setY(Brawl.fieldHeight - getHeight()); // and on the ground
    }

    public void fighterMovement(int movementMod) { // fighter gets a speed modifier
        int location = (int) getX(); // location determined
        if ((location + movementMod) >= 0 && (location + movementMod) <= Brawl.fieldLength) { // move when on the field
            setX(location + movementMod);
        } else if ((location + movementMod) < 0) { // doesn't allow moving off the field
            setX(0);
        } else if ((location + movementMod) > Brawl.fieldLength) { // doesn't allow moving off the field
            setX(Brawl.fieldLength - getWidth());
        }
    }

}