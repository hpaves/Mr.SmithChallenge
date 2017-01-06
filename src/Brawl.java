import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Brawl { // this is a brawl; the main game engine
    Pane window; // main game window
    Scene mainView; // the window sizer
    Stage primaryStage = new Stage(); // holder of game contents

    AnimationTimer animationTimer;

    public static int fieldLength = 800; // how long the game field is
    public static int fieldHeight = 300; // how high the game field is

    public static Neo neo; // there is a Neo class element in this game called neo
    StrikeZone strikeZone; // other variables created
    Shades shades;
    int neoSpeed = 5;
    public static boolean faceLeft; // neo faces left by default
    boolean spaceDown = false;

    Smith[] smithArray = new Smith[10]; // there can be up to 10 smiths in the game simultaneously
    public static int smithCounter;
    public static int finalSmithCount;
    int smithSpeed = 2;
    Bullet bullet;
    int bulletSpeed = 5;
    public ScoreReader scoreReader = new ScoreReader();

    public Brawl(){ // this method launches the game
        makeBrawl();
        addNeo();
        addSmith(0); // adds the very first smith
        readKeys(neo, strikeZone); // makes the game ... read keystrokes
        faceLeft = true;
        setOrientation(); // makes neo face in the correct direction
        smithCounter = 0; // zero smiths killed in the beginning of the game
        finalSmithCount = 0;
    }

    public void makeBrawl(){ // this method completes all steps to generate the game window
        window = new Pane(); // makes the game window base
        mainView = new Scene(window, fieldLength, fieldHeight); // determines scene size
        primaryStage.setScene(mainView); // sets scene on the state
        primaryStage.show(); // displays the game contents
    }

    public void addNeo(){ // this method adds all the components of neo
        neo = new Neo(); // creates neo
        window.getChildren().add(neo); // adds it to the game
        shades = new Shades(); // creates shades
        window.getChildren().add(shades); // adds them to the game
        strikeZone = new StrikeZone(); // creates the strikezone, won't add it
    }

    public void addSmith(int i){ // this method adds smiths
        smithArray[i] = new Smith(); // makes an array of smiths
        window.getChildren().add(smithArray[i]); // and adds them to the game
    }

    public void addBullet(){
        int bulletRandomizer = (int) (Math.random() * 3); // 33% to generate 0
        if (bulletRandomizer == 0) {
            bullet = new Bullet(); // creates a bullet
            window.getChildren().add(bullet); // adds it to the game
        }
    }

    public void setOrientation(){ // this method makes sure neo is facing the correct direction
        if (faceLeft == true) {
            shades.setShadesLocation((int) neo.getX(), (int) (neo.getY() + neo.getHeight()/8)); // the shades are on the left
            strikeZone.setStrikeZoneLocation((int) ((int) neo.getX() - neo.getWidth()), (int) neo.getY()); // strikezone is on the left
        } else {
            shades.setShadesLocation((int) (neo.getX() + neo.getWidth() / 2), (int) (neo.getY() + neo.getHeight()/8)); // the shades are on the right
            strikeZone.setStrikeZoneLocation((int) ((int) neo.getX() + neo.getWidth()), (int) neo.getY()); // strikezone is on the right
        }
    }

    private void gameFasterCheck(){
        if ((smithCounter % 8) == 0) {
            bulletSpeed++;
        }
        if ((smithCounter % 12) == 0) {
            smithSpeed++;
       }
    }

    private void gameOver() { // this method initializes game over sequence
        animationTimer.stop(); // stops the animation
        primaryStage.close(); // closes the game window
        finalSmithCount = smithCounter - 1; // we artificially added 1 to the smith count to avoid bugs
        if (scoreReader.returnOldHighScore() < finalSmithCount) {
            MenuScoreInsert menuScoreInsert = new MenuScoreInsert(); // open high score insertion menu
        } else {
            Menu menu = new Menu(); // opens the main menu
        }
    }

    public void readKeys(Neo neo, StrikeZone strikeZone){ // this is for reading keystrokes
        mainView.setOnKeyPressed(event1 -> {    // event is a parameter
            switch (event1.getCode()) // listens for the keycodes
            {
                case LEFT: { // works with arrow keys
                    neo.fighterMovement(-neoSpeed); // moves neo left
                    faceLeft = true; // says he faces left
                    mainView.setOnKeyReleased(event -> {
                        neo.fighterUnDuck();
                        setOrientation(); // re-checks orientation after key released
                    });
                    window.getChildren().remove(strikeZone);
                    break; // ends the action
                }
                case RIGHT: {
                    neo.fighterMovement(+neoSpeed); // moves neo
                    faceLeft = false; // says doesn't face left, meaning he faces right
                    mainView.setOnKeyReleased(event -> {
                        neo.fighterUnDuck();
                        setOrientation(); // re-checks orientation after key released
                    });
                    window.getChildren().remove(strikeZone);
                    break; // ends the action
                }
                case UP: {
                    neo.fighterUnDuck(); // neo unducks
                    break; // ends the action
                }
                case DOWN: {
                    neo.fighterDuck(); // neo ducks
                    mainView.setOnKeyReleased(event -> {
                        neo.fighterUnDuck();
                        setOrientation(); // re-checks orientation after key released
                    });
                    break; // ends the action
                }
                case SPACE: { //this part is for collision detction
                    if (spaceDown == false) {
                        spaceDown = true;
                        setOrientation();
                        window.getChildren().add(strikeZone); // if key pressed, adds strikezone to the game
                        for (int i = 0; i < 9; i++) { // checks all the smiths one at a time
                            if (smithArray[i] != null) { // if smiths are present
                                if (strikeZone.getBoundsInParent().intersects(smithArray[i].getBoundsInParent())) { // if strikezone and smith intesect (gracious help from Krister Viirsaar)
                                    window.getChildren().remove(smithArray[i]); // remove that smith from play
                                    smithArray[i] = null; // and remove its value
                                    smithCounter++;
                                    addSmith(i); //adds another smith to replace the fallen one
                                    if (bullet == null) {
                                        addBullet();
                                    }
                                    gameFasterCheck();
                                }
                            }
                        }
                        if (smithCounter == 1) { // if the first smith is killed...
                            addSmith(1); // ...put an additional smith in play
                            smithCounter++; // and count it (important! it bumps counter to 2 to avoid bugs)
                        }
                }
                    mainView.setOnKeyReleased(event -> {
                                window.getChildren().remove(strikeZone);
                                neo.fighterUnDuck();
                                setOrientation();
                                spaceDown = false;
                            }
                    ); // if key released, removes strikezone

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

                if (bullet != null) {
                    if (bullet.spawnLeft == true) {
                        bullet.fighterMovement(+bulletSpeed);
                        if (bullet.getX() > neo.getX()) {
                            bullet.fighterMovement(+bulletSpeed+10);
                        }
                        if (bullet.getX() >= (fieldLength - bullet.getWidth())){
                            window.getChildren().remove(bullet); // remove bullet from play
                            bullet = null; // and remove its value
                        }
                    }
                    if (bullet.spawnLeft == false) {
                        bullet.fighterMovement(-bulletSpeed);
                        if (bullet.getX() < (neo.getX() + neo.getWidth()) ) {
                            bullet.fighterMovement(-(bulletSpeed+10));
                        }
                        if (bullet.getX() <= 0){
                            window.getChildren().remove(bullet); // remove bullet from play
                            bullet = null; // and remove its value
                        }
                    }
                }

                if (bullet != null) { // if bullet is present
                    if (neo.getBoundsInParent().intersects(bullet.getBoundsInParent())) { // and neo intersects with bullet
                        gameOver(); // initiate game over sequence
                    }

                }
            }
        };

        animationTimer.start(); // starts the animation

    }

}
