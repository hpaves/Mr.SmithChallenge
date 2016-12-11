import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Brawl brawl = new Brawl(); //new game

/*        if(brawl.game_over()) {
            System.out.println("Mäng ei ole läbi");
            //Brawl.newgame();

        }
        else {
            brawl.moveCharacters();
            brawl.checkCollision();
            brawl.draw();
        }*/

    }
}
/*    Text text = new Text(100, 100, "");
    int fieldLength = 800;
    int fieldHeight = 300;

    int fighterWidth = 50;
    int fighterHeight = 100;

    int strikeWidth = 100;
    int strikeHeight = 100;

    int neoPosition = (fieldLength / 2);
    int smithPosition = (200);

    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle neo = new Rectangle(fighterWidth, fighterHeight); //define Neo
        neo.setY(fieldHeight - fighterHeight);

//        Fighter neo = new Fighter();

        Rectangle strikeZone = new Rectangle(strikeWidth, strikeHeight); //define Neo's strike zone
        strikeZone.setY(fieldHeight - strikeHeight);
        strikeZone.setFill(Color.RED);

        final Rectangle[] smith = {new Rectangle(fighterWidth, fighterHeight)}; // define Smith
        smith[0].setY(fieldHeight - fighterHeight);
        smith[0].setFill(Color.DARKGREY);

        neo.setX(neoPosition); // initial positions
        strikeZone.setX(neoPosition - fighterWidth/2);
        smith[0].setX(smithPosition);

        Pane window = new Pane(); // interface window, etc
        Scene mainView = new Scene(window, fieldLength, fieldHeight);

        window.getChildren().add(text); // adds objects to the interface window
        window.getChildren().add(neo);
        window.getChildren().add(smith[0]);

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
                    strikeZone.setX(neoPosition - fighterWidth / 2);
                    break;
                case D:
                    text.setText("D");
                    neoPosition = neoPosition + 5;
                    neo.setX(neoPosition);
                    strikeZone.setX(neoPosition - fighterWidth / 2);

                    break;
                case ENTER:
                    text.setText("Enter");
                    window.getChildren().add(strikeZone); //collision detction
                    mainView.setOnKeyReleased(event -> window.getChildren().remove(strikeZone));
                    if (smith[0] != null) {
                        if (strikeZone.getBoundsInParent().intersects(smith[0].getBoundsInParent())) {
                            text.setText("Tapsid Smithi");
                            window.getChildren().remove(smith[0]);
                            smith[0] = null; // miks smith peab one final element array olema, et asi töötaks?
                        }
                    }
                    break;
            }


        });

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; //võõras kood, viide panna!!!!!!!!!!!!

                if (smith[0] != null) {
                    if (smithPosition < neoPosition) {
                        smithPosition++;
                        smith[0].setX(smithPosition);
                    } else if (smithPosition > neoPosition) {
                        smithPosition--;
                        smith[0].setX(smithPosition);
                    }
                }

                if (smith[0] != null) {
                    if (neo.getBoundsInParent().intersects(smith[0].getBoundsInParent())) {
                        text.setText("Game over man, game over.");

                    }
                }
            }
        }.start();

        // smith angriness level
        // you reached smith angriness level n
    }
}*/