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
//        System.out.println(getX());
        //        Math.min(344,5566);
    }



/*    public strikeZone () {
//        setY(fieldHeight - fighterHeight);
        setX(fighterPosition-50);
        setY(200);
        setWidth(100);
        setHeight(100);
        setFill(Color.RED);
        System.out.println("strikeZone!!!");
    }*/

/*    public void setX(int x) {
        this.position = x;
    }*/

}