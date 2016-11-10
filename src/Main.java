import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Text text = new Text(100, 100, "");
    int fieldLength = 800;
    int fieldHeight = 300;

    int fighterWidth = 50;
    int fighterHeight = 100;

    int strikeWidth = 100;
    int strikeHeight = 100;

    int neoPosition = (fieldLength/2);

    boolean smithCollision = false;
    boolean strikeCollision = false;

/*    boolean right = false;*/

    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle neo = new Rectangle(fighterWidth, fighterHeight); //define Neo
        neo.setY(fieldHeight-fighterHeight);

        Rectangle strikeZone = new Rectangle(strikeWidth, strikeHeight); //deefine Neo's strike zone
        strikeZone.setY(fieldHeight-strikeHeight);
        strikeZone.setFill(Color.RED);

        Rectangle smith = new Rectangle(fighterWidth, fighterHeight); // define Smith
        smith.setY(fieldHeight-fighterHeight);
        smith.setFill(Color.DARKGREY);

        neo.setX(neoPosition); // initial positions
        strikeZone.setX(neoPosition);
        smith.setX(200);

        Pane window = new Pane(); // interface window, etc
        Scene mainView = new Scene(window, fieldLength, fieldHeight);

        window.getChildren().add(text); // adds objects to the interface window
        window.getChildren().add(neo);
        window.getChildren().add(smith);

        primaryStage.setScene(mainView);
        primaryStage.show();
                                                // this is for reading keystrokes
        mainView.setOnKeyPressed(event1 -> {    // event on sisendparameeter
            switch (event1.getCode())           // kontrolli programmi toimimist kasvõi iga kolme rea tagant
            {
                case A:
                    text.setText("A");
                    neoPosition = neoPosition - 5;
                    neo.setX(neoPosition);
                    strikeZone.setX(neoPosition-fighterWidth/2);
                    break;
                case D:
                    text.setText("D");
                    neoPosition = neoPosition + 5;
                    neo.setX(neoPosition);
                    strikeZone.setX(neoPosition-fighterWidth/2);
                    break;
                case ENTER:
                    text.setText("Enter");
                    window.getChildren().add(strikeZone);
                    mainView.setOnKeyReleased(event -> window.getChildren().remove(strikeZone));
                    break;
            }
        });

        mainView.setOnKeyReleased(event -> text.setText(""));

        // if collision




        if (neo.intersects(smith)){
            smithCollision = true;
                    text.setText("Mäng läbi");
        } else {
            smithCollision = false;
        }




    }

/*    public void move() {
        if (neoPosition == fieldLength) {
            right = true;
        }
        if (neoPosition == 0) {
            right = false;
        }
        if (right) {
            neoPosition++;
        } else {
            neoPosition--;
        }

    }*/
}