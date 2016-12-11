import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Fighter{

    public int fighterWidth = 50;
    public int fighterHeight = 100;
    private int position;
    public Rectangle fighter;

    public Fighter () {
        fighter = new Rectangle(50, 100, 20, 20);
//        fighter.setY(fieldHeight - fighterHeight);
        fighter.setX(300);
        fighter.setY(100);
        fighter.setFill(Color.GREEN);
        System.out.println("jõudsin siia");
    }




    public void setX(int x) {
        this.position = x;
    }

    public Rectangle getFighter(){
        return fighter;
    }

}