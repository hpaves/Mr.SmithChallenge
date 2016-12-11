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

//    public Boolean game_over = Boolean.FALSE;

    Text text;
    int fieldLength = 800;
    int fieldHeight = 300;
//    public int fighterPosition = 500;

    public Brawl(){
        System.out.println("Brawl constructor");
        makeBrawl();
        Fighter neo = addElements();
        Fighter zone = insertStrikeZone();
        readKeys(neo);
    }

    public void makeBrawl(){
        System.out.println("Brawl makeBrawl");
        window = new Pane(); // interface window, etc
        mainView = new Scene(window, fieldLength, fieldHeight);
        primaryStage.setScene(mainView);
        primaryStage.show();
    }

    public Fighter addElements(){ //
        System.out.println("Brawl addElemets");
        text = new Text(100, 100, "test");
        window.getChildren().add(text); // adds objects to the interface window
        Fighter neo = new Fighter();
        System.out.println("Lisan fighteri");
        window.getChildren().add(neo);
//        window.getChildren().add(smith[0]);
        return neo;

    }

    public Fighter insertStrikeZone(){ //
        Fighter zone = new Fighter();
        window.getChildren().add(zone);
        System.out.println("Lisan strikezone");
//        window.getChildren().add(smith[0]);
        zone.setFill(Color.RED);
        zone.setWidth(10);
        return zone;
    }

/*    public void neoMovement(int value) {
        this.neoPosition = this.neoPosition + value;
    }
*/
    public void readKeys(Fighter neo){
        // this is for reading keystrokes
        mainView.setOnKeyPressed(event1 -> {    // event on sisendparameeter
            switch (event1.getCode())           // kontrolli programmi toimimist kasvõi iga kolme rea tagant
            {
                case A:
                    text.setText("A");
                    neo.fighterMovement(-5);
                    //zone.fighterMovement(-5);
                    break;
                case D:
                    text.setText("D");
                    neo.fighterMovement(+5);
                    break;
                case ENTER:
                    text.setText("Enter");

//                    window.getChildren().add(Fighter); //collision detction
/*                    mainView.setOnKeyReleased(event -> window.getChildren().remove(strikeZone));
                    if (smith[0] != null) {
                        if (strikeZone.getBoundsInParent().intersects(smith[0].getBoundsInParent())) {
                            text.setText("Tapsid Smithi");
                            window.getChildren().remove(smith[0]);
                            smith[0] = null; // miks smith peab one final element array olema, et asi töötaks?
                        }
                    }*/
                    break;
            }


        });

/*        final long startNanoTime = System.nanoTime();

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
        }.start();*/

    }
}

/*    public Boolean game_over() {
        return game_over;
    }

    public void moveChracters() {

    }*/