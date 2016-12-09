import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Fighter extends Rectangle {

    public int fighterWidth = 50;
    public int fighterHeight = 100;
    private int position;

    public void fighterBlank (int fieldHeight) { 
        Rectangle fighter = new Rectangle(50, 100);
//        fighter.setY(fieldHeight - fighterHeight);
        fighter.setX(300);
        fighter.setY(100);
        fighter.setFill(Color.GREEN);
    }

    public void setX(int x) {
        this.position = x;
    }
}
