import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Brawl {
    Pane window;
    Scene mainView;
    Stage primaryStage = new Stage();

    Text text;
    int fieldLength = 800;
    int fieldHeight = 300;
    Fighter neo;

    public Brawl(){
        System.out.println("Brawl constructor");
        neo = new Fighter();
        makeBrawl();
        addElements();
    }

    public void makeBrawl(){

        System.out.println("Brawl makeBrawl");
// miks nii ei saa??        Pane window = new Pane(); // interface window, etc
// miks nii ei saa??        Scene mainView = new Scene(window, fieldLength, fieldHeight);
        window = new Pane(); // interface window, etc
        System.out.println("here 1");
        mainView = new Scene(window, fieldLength, fieldHeight);
        System.out.println("here 2");
        primaryStage.setScene(mainView);
        System.out.println("here 3");
        primaryStage.show();
        System.out.println("here 4");
    }

    public void addElements(){
        System.out.println("Brawl addElemets");
        text = new Text(100, 100, "test");
        window.getChildren().add(text); // adds objects to the interface window

        System.out.println("Lisan fighteri");
        Rectangle kuubik = new Rectangle(20, 20, 20, 20);
        Rectangle ajutine = neo.getFighter();
        window.getChildren().add(ajutine);
        //window.getChildren().add(neo.getFighter());
//        window.getChildren().add(smith[0]);

    }
}