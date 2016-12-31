import javafx.scene.shape.Rectangle;

public class Fighter extends Rectangle {

    public Fighter () {
        setWidth(50);
        setHeight(100);
        setX(Brawl.fieldLength / 2);
        setY(Brawl.fieldHeight - getHeight());
        System.out.println("jõudsin fighteri konstruktorisse");
    }

    public void fighterMovement(int value) {
        setX(getX() + value);
        //        Math.min(344,5566);
    }
}