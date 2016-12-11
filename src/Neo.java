import javafx.scene.paint.Color;

public class Neo extends Fighter {

    public Neo () {
        System.out.println("neo konstruktor " + getX());
    }

    public boolean StrikeZone () {
        System.out.println("strikezone!!");
        return true;
    }
}