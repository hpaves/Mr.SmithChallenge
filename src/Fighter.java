import javafx.scene.shape.Rectangle;

public class Fighter extends Rectangle {

    public Fighter () {
//        setY(fieldHeight - fighterHeight);
        setX(400);
        setY(200);
        setWidth(50);
        setHeight(100);
        System.out.println("jõudsin fighteri konstruktorisse");
    }

    public void fighterMovement(int value) {
        setX(getX() + value);
        //        Math.min(344,5566);
    }
}