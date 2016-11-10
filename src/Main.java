import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Text text = new Text(100, 100, "TEST");
    int fieldLength = 800;
    int fieldHeight = 300;
    int characterWidth = 50;
    int characterHeight = 100;

    int neoPosition = (fieldLength/2-characterWidth/2);

    boolean right = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle character = new Rectangle(characterWidth, characterHeight);
        character.setY(fieldHeight-characterHeight);


        character.setX(neoPosition);

        Pane window = new Pane();
        Scene mainView = new Scene(window, fieldLength, fieldHeight);

        window.getChildren().add(character);
        window.getChildren().add(text);

        primaryStage.setScene(mainView);
        primaryStage.show();

        mainView.setOnKeyPressed(event1 -> {    // event on sisendparameeter
            switch (event1.getCode())           // kontrolli programmi toimimist kasvõi iga kolme rea tagant
            {
                case A:
                    neoPosition = neoPosition - 10;
                    break;
                case D:
                    text.setText("D klahvi vajutati");
                    break;
                case ENTER:
                    text.setText("Enterit vajutati");
                    break;
            }
        });

        while (neoPosition < fieldLength) {
            neoPosition++;
            System.out.println(neoPosition);
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