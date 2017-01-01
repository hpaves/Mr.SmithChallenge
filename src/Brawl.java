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
//    Smith smith;
    Smith[] smithArray = new Smith[10];

    public Brawl(){
        System.out.println("Brawl constructor");
        makeBrawl();
        addNeo();
        addSmith(0);
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

    public void addSmith(int i){
//        smith = new Smith();
        smithArray[i] = new Smith();
        window.getChildren().add(smithArray[i]);
    }

    public void setOrientation(){
        if (faceLeft == true) {
            neoShades.setShadesLocation((int) neo.getX());
            strikeZone.setStrikeZoneLocation((int) ((int) neo.getX() - neo.getWidth()));
        } else {
            neoShades.setShadesLocation((int) (neo.getX() + neo.getWidth() / 2));
            strikeZone.setStrikeZoneLocation((int) ((int) neo.getX() + neo.getWidth()));

        }
    }

    public void readKeys(Neo neo, StrikeZone strikeZone){
        // this is for reading keystrokes
        mainView.setOnKeyPressed(event1 -> {    // event on sisendparameeter
            switch (event1.getCode())           // kontrolli programmi toimimist kasvõi iga kolme rea tagant
            {
                case A:
                case LEFT: {
                    neo.fighterMovement(-5);
                    faceLeft = true;
                    strikeZone.fighterMovement(-5);
                    break;
                }
                case D:
                case RIGHT: {
                    neo.fighterMovement(+5);
                    faceLeft = false;
                    strikeZone.fighterMovement(+5);
                    break;
                }
                case ENTER:
                case SPACE: {
                    window.getChildren().add(strikeZone); //collision detction
                    mainView.setOnKeyReleased(event -> window.getChildren().remove(strikeZone));
                    for (int i = 0; i < 9; i++) {
                        if (smithArray[i] != null) {
                            if (strikeZone.getBoundsInParent().intersects(smithArray[i].getBoundsInParent())) { // gracious help from Krister Viirsaar
                                text.setText("Tapsid Smithi slotis " + i);
                                window.getChildren().remove(smithArray[i]);
                                smithArray[i] = null;
                                smithCounter++;
                                // smithSpeed = (int) (1 + smithCounter/3);
                                System.out.println(smithCounter);
                                addSmith(i);
                            }
                        }
                    }
//                    if (smithCounter % 2 == 0) {
//                        addSmith(1);
//                    }
                break;
                }
            }

        setOrientation();

        });

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {                          // AnimationTimer code borrowed from gamedevelopment.tutsplus.com
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;    // https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
                for (int i = 0; i < 9; i++) {
                    if (smithArray[i] != null) {
                        if (smithArray[i].getX() < neo.getX()) {
                            smithArray[i].fighterMovement(+smithSpeed);
                        } else if (smithArray[i].getX() > neo.getX()) {
                            smithArray[i].fighterMovement(-smithSpeed);
                        }
                    }

                    if (smithArray[i] != null) {
                        if (neo.getBoundsInParent().intersects(smithArray[i].getBoundsInParent())) { // gracious help from Krister Viirsaar
                            text.setText("Game over man, game over.");

                        }
                    }

                }
            }
        }.start();

    }
}
