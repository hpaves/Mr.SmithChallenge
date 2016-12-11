import javafx.scene.paint.Color;

public class Smith extends Fighter {

    public Smith () {
        setX(0);
        setFill(Color.DARKGRAY);
        System.out.println("smith konstruktor " + getX());
    }

/*    public boolean StrikeZone () {
        System.out.println("strikezone!!");
        return true;
    }*/
}