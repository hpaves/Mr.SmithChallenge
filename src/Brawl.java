import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
    Neo neo;
    StrikeZone strikeZone;
    Smith smith;

    public Brawl(){
        System.out.println("Brawl constructor");
        makeBrawl();
        addNeo();
        addSmith();
        readKeys(neo, strikeZone);
    }

    public void makeBrawl(){
        System.out.println("Brawl makeBrawl");
        window = new Pane(); // interface window, etc
        mainView = new Scene(window, fieldLength, fieldHeight);
        primaryStage.setScene(mainView);
        primaryStage.show();
    }

    public void addNeo(){ //
        System.out.println("Brawl addElemets");
        text = new Text(100, 100, "test");
        window.getChildren().add(text); // adds objects to the interface window
        neo = new Neo();
        strikeZone = new StrikeZone();
        System.out.println("Lisan fighteri");
        window.getChildren().add(neo);
    }

    public void addSmith(){
        smith = new Smith();
        window.getChildren().add(smith);
    }

    public void readKeys(Neo neo, StrikeZone strikeZone){
        // this is for reading keystrokes
        mainView.setOnKeyPressed(event1 -> {    // event on sisendparameeter
            switch (event1.getCode())           // kontrolli programmi toimimist kasvõi iga kolme rea tagant
            {
                case A:
                    text.setText("A");
                    neo.fighterMovement(-5);
                    strikeZone.fighterMovement(-5);
                    //zone.fighterMovement(-5);
                    break;
                case D:
                    text.setText("D");
                    neo.fighterMovement(+5);
                    strikeZone.fighterMovement(+5);
                    break;
                case ENTER:
                    text.setText("Enter");
                    window.getChildren().add(strikeZone); //collision detction
                    mainView.setOnKeyReleased(event -> window.getChildren().remove(strikeZone));
                    if (smith != null) {
                        if (strikeZone.getBoundsInParent().intersects(smith.getBoundsInParent())) {
                            text.setText("Tapsid Smithi");
                            window.getChildren().remove(smith);
                            smith = null; // miks smith peab one final element array olema, et asi töötaks?
                        }
                    }
                    break;
            }


        });

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; //võõras kood, viide panna!!!!!!!!!!!!

                if (smith != null) {
                    if (smith.getX() < neo.getX()) {
                        smith.fighterMovement(+1);
                    } else if (smith.getX() > neo.getX()) {
                        smith.fighterMovement(-1);
                    }
                }

                if (smith != null) {
                    if (neo.getBoundsInParent().intersects(smith.getBoundsInParent())) {
                        text.setText("Game over man, game over.");

                    }
                }
            }
        }.start();

    }
}

/*    public Boolean game_over() {
        return game_over;
    }

    public void moveChracters() {

    }*/