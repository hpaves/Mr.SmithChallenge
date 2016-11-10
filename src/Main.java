import javafx.application.Application;
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

/*    boolean right = false;*/

    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle neo = new Rectangle(fighterWidth, fighterHeight);
        neo.setY(fieldHeight-fighterHeight);

        Rectangle strikeZone = new Rectangle(strikeWidth, strikeHeight);
        strikeZone.setY(fieldHeight-strikeHeight);
        strikeZone.setFill(Color.RED);

        Rectangle smith = new Rectangle(fighterWidth, fighterHeight);
        smith.setY(fieldHeight-fighterHeight);
        smith.setFill(Color.DARKGREY);

        neo.setX(neoPosition);
        strikeZone.setX(neoPosition);
        smith.setX(200);

        Pane window = new Pane();
        Scene mainView = new Scene(window, fieldLength, fieldHeight);

        window.getChildren().add(text);
        window.getChildren().add(neo);
        window.getChildren().add(smith);

        primaryStage.setScene(mainView);
        primaryStage.show();

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

/*        while (neoPosition < fieldLength) {
            neoPosition++;
            neo.setX(neoPosition);
        }*/

/*        neo.setOnMouseClicked(event -> { // event on sisendparameeter
                System.out.println("KLIKK"); // kontrolli programmi toimimist kasvõi iga kolme rea tagant
                neoPosition++;
            neo.setX(neoPosition);
        });*/

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