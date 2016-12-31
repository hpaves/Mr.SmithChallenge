import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Brawl {
    Pane window;
    Scene mainView;
    Stage primaryStage = new Stage();

    Text text;
    public static int fieldLength = 800;
    public static int fieldHeight = 300;
    int smithCounter = 0;
    int smithSpeed = 3;
    Neo neo;
    public static boolean faceLeft = true;
    StrikeZone strikeZone;
    NeoShades neoShades;
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
        text = new Text(100, 100, "test");
        window.getChildren().add(text); // adds objects to the interface window
        neo = new Neo();
        strikeZone = new StrikeZone();
        window.getChildren().add(neo);
        neoShades = new NeoShades();
        window.getChildren().add(neoShades);
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
                case LEFT: {
                    text.setText("A");
                    neo.fighterMovement(-5);
                    faceLeft = true;
                    strikeZone.fighterMovement(-5);
                    break;
                }
                case D:
                case RIGHT: {
                    text.setText("D");
                    neo.fighterMovement(+5);
                    faceLeft = false;
                    strikeZone.fighterMovement(+5);
                    break;
                }
                case ENTER:
                case SPACE: {
                    text.setText("Enter");
                    window.getChildren().add(strikeZone); //collision detction
                    mainView.setOnKeyReleased(event -> window.getChildren().remove(strikeZone));
                    if (smith != null) {
                        if (strikeZone.getBoundsInParent().intersects(smith.getBoundsInParent())) { // gracious help from Krister Viirsaar
                            text.setText("Tapsid Smithi");
                            window.getChildren().remove(smith);
                            smith = null;
                            smithCounter++;
//                            smithSpeed = (int) (1 + smithCounter/3);
                            System.out.println(smithCounter);
                            addSmith();
                            addSmith();
//                            if (smithCounter == 3) {
//                                smithSpeed++;
//                            }

                        }
                    }
                    break;
                }
            }

            if (faceLeft == true) {
                neoShades.setShadesLocation((int) neo.getX());
            } else {
                neoShades.setShadesLocation((int) (neo.getX() + neo.getWidth() / 2));
            }

        });

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {                          // AnimationTimer code borrowed from gamedevelopment.tutsplus.com
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;    // https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835

                if (smith != null) {
                    if (smith.getX() < neo.getX()) {
                        smith.fighterMovement(+smithSpeed);
                    } else if (smith.getX() > neo.getX()) {
                        smith.fighterMovement(-smithSpeed);
                    }
                }

                if (smith != null) {
                    if (neo.getBoundsInParent().intersects(smith.getBoundsInParent())) { // gracious help from Krister Viirsaar
                        text.setText("Game over man, game over.");

                    }
                }

            }
        }.start();

    }
}
