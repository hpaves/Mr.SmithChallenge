import javafx.scene.shape.Rectangle;

public class Fighter {

    public int fighterWidth = 50;
    public int fighterHeight = 100;
    private int position;

    public void fighterBlank (int fieldHeight) { 
        Rectangle fighter = new Rectangle(fighterWidth, fighterHeight);
        fighter.setY(fieldHeight - fighterHeight);
    }

    public void setX(int x) {
        this.position = x;
    }
}
