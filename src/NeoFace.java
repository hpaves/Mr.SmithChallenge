import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class NeoFace extends Neo {

    public NeoFace () {
        setX(getX());
        setY(Brawl.fieldHeight - getHeight() + (getHeight()/8));
        setWidth(getWidth()/2);
        setHeight(getHeight()/10);
        setFill(Color.DEEPSKYBLUE);
    }

//    public void Shades () {
//      //  if (faceLeft == true)
//        setX(getX() + 25);
//        //        Math.min(344,5566);
//    }
}