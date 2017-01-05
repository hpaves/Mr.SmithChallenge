import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Brawl { // this is a brawl; the main game engine
    Pane window; // main game window
    Scene mainView; // the window sizer
    Stage primaryStage = new Stage(); // holder of game contents

    AnimationTimer animationTimer;

    Text text; // a text block for testing purposes
    public static int fieldLength = 800; // how long the game field is
    public static int fieldHeight = 300; // how high the game field is

    Neo neo; // there is a Neo class element in this game called neo
    StrikeZone strikeZone; // other variables created
    NeoShades neoShades;
    int neoSpeed = 5;
    public static boolean faceLeft; // neo faces left by default

    Smith[] smithArray = new Smith[10]; // there can be up to 10 smiths in the game simultaneously
    public static int smithCounter = 0; // zero smiths killed in the beginning of the game
    int smithSpeed = 3;

    public ScoreReader scoreReader = new ScoreReader();

    public Brawl(){ // this method launches the game
        makeBrawl();
        addNeo();
        addSmith(0); // adds the very first smith
        readKeys(neo, strikeZone); // makes the game ... read keystrokes
        faceLeft = true;
        setOrientation(); // makes neo face in the correct direction
        smithCounter = 0;
    }

    public void makeBrawl(){ // this method completes all steps to generate the game window
        window = new Pane(); // makes the game window base
        mainView = new Scene(window, fieldLength, fieldHeight); // determines scene size
        primaryStage.setScene(mainView); // sets scene on the state
        primaryStage.show(); // displays the game contents
        text = new Text(100, 100, "test"); // testing text
        window.getChildren().add(text); // adds objects to the interface window
    }

    public void addNeo(){ // this method adds all the components of neo
        neo = new Neo(); // creates neo
        window.getChildren().add(neo); // adds it to the game
        neoShades = new NeoShades(); // creates shades
        window.getChildren().add(neoShades); // adds them to the game
        strikeZone = new StrikeZone(); // creates the strikezone, won't add it
    }

    public void addSmith(int i){ // this method adds smiths
        smithArray[i] = new Smith(); // makes an array of smiths
        window.getChildren().add(smithArray[i]); // and adds them to the game
    }

    public void setOrientation(){ // this method makes sure neo is facing the correct direction
        if (faceLeft == true) {
            neoShades.setShadesLocation((int) neo.getX()); // the shades are on the left
            strikeZone.setStrikeZoneLocation((int) ((int) neo.getX() - neo.getWidth())); // strikezone is on the left
        } else {
            neoShades.setShadesLocation((int) (neo.getX() + neo.getWidth() / 2)); // the shades are on the right
            strikeZone.setStrikeZoneLocation((int) ((int) neo.getX() + neo.getWidth())); // strikezone is on the right
        }
    }

    private void gameOver() { // this method initializes game over sequence
        animationTimer.stop(); // stops the animation
        primaryStage.close(); // closes the game window
        if (scoreReader.returnOldHighScore() < smithCounter -1) {
            MenuScoreInsert menuScoreInsert = new MenuScoreInsert(); // open high score insertion menu
        } else {
            Menu menu = new Menu(); // opens the main menu
        }
//        Menu menu = new Menu(); // opens the main menu
    }

    public void readKeys(Neo neo, StrikeZone strikeZone){ // this is for reading keystrokes
        mainView.setOnKeyPressed(event1 -> {    // event is a parameter
            switch (event1.getCode()) // listens for the keycodes
            {
                case A: // game can be played both using wasd...
                case LEFT: { // ...and arrow keys
                    neo.fighterMovement(-neoSpeed); // moves neo
                    faceLeft = true; // says he faces left
                    strikeZone.fighterMovement(-neoSpeed); // moves strikezone
                    break; // ends the action
                }
                case D:
                case RIGHT: {
                    neo.fighterMovement(+neoSpeed); // moves neo
                    faceLeft = false; // says doesn't face left, meaning he faces right
                    strikeZone.fighterMovement(+neoSpeed); // moves strikezone
                    break; // ends the action
                }
                case ENTER:
                case SPACE: { //this part is for collision detction
                    window.getChildren().add(strikeZone); // if key pressed, adds strikezone to the game
                    mainView.setOnKeyReleased(event -> window.getChildren().remove(strikeZone)); // if key released, removes strikezone
                    for (int i = 0; i < 9; i++) { // checks all the smiths one at a time
                        if (smithArray[i] != null) { // if smiths are present
                            if (strikeZone.getBoundsInParent().intersects(smithArray[i].getBoundsInParent())) { // if strikezone and smith intesect (gracious help from Krister Viirsaar)
                                window.getChildren().remove(smithArray[i]); // remove that smith from play
                                text.setText("Tapsid Smithi slotis " + i);
                                smithArray[i] = null; // and remove its value
                                smithCounter++;
                                System.out.println(smithCounter);
                                addSmith(i); //adds another smith to replace the fallen one
                            }
                        }
                    }
                    if (smithCounter == 1) { // if the first smith is killed...
                        addSmith(1); // ...put an additional smith in play
                        smithCounter++; // and count it (important! it bumps counter to 2 to avoid bugs)
                    }
                break; // ends the action
                }
            }
        setOrientation(); // makes neo face in the correct direction
        });

        final long startNanoTime = System.nanoTime(); // this was sort of complicated to figure out

        animationTimer = new AnimationTimer() {
            public void handle(long currentNanoTime) {                          // AnimationTimer code borrowed from gamedevelopment.tutsplus.com
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;    // https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
                for (int i = 0; i < 9; i++) { // checks all the smiths one at a time
                    if (smithArray[i] != null) { // if they are present
                        if (smithArray[i].getX() < neo.getX()) { // and left from neo
                            smithArray[i].fighterMovement(+smithSpeed); // move smith towards neo
                        } else if (smithArray[i].getX() > neo.getX()) { // if they're right
                            smithArray[i].fighterMovement(-smithSpeed); // move smith towards neo, too
                        }
                    }

                    if (smithArray[i] != null) { // if smiths are present
                        if (neo.getBoundsInParent().intersects(smithArray[i].getBoundsInParent())) { // and neo intersects with smith (gracious help from Krister Viirsaar)
                            gameOver(); // initiate game over sequence
                        }
                    }

                }
            }
        };

        animationTimer.start(); // starts the animation

    }

}
