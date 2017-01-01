import javafx.scene.shape.Rectangle;

public class Fighter extends Rectangle {

    public Fighter () {
        setWidth(50);
        setHeight(100);
        setX(Brawl.fieldLength / 2);
        setY(Brawl.fieldHeight - getHeight());
        System.out.println("jõudsin fighteri konstruktorisse");
    }

    public void fighterMovement(int movementMod) {
        int location = (int) getX();
        if ((location + movementMod) >= 0 && (location + movementMod) <= Brawl.fieldLength) {
            setX(location + movementMod);
            System.out.println(getX());
        } else if ((location + movementMod) < 0) {
            setX(0);
            System.out.println(getX());
        } else if ((location + movementMod) > Brawl.fieldLength) {
            setX(Brawl.fieldLength - getWidth());
            System.out.println(getX());
        }
        //        Math.min(344,5566);
    }

}