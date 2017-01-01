import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
    public Stage menuWindow = new Stage(); // makes main menu window

    public Menu(){
        makeMenu();
    }

    public void makeMenu(){ // method that adds all the main menu items together
        Pane menuContent = new Pane(); // container for the menu content
        Scene menuContentFrame = new Scene(menuContent, Brawl.fieldLength, Brawl.fieldHeight); // window resizer, holds content
        menuWindow.setScene(menuContentFrame); // sets window resizer into the main menu window
        menuWindow.show(); // displays the window

        Button playButton = new Button("Play"); // play button
            playButton.setLayoutX(Brawl.fieldLength/2 - 50); // button location
            playButton.setLayoutY(Brawl.fieldHeight/2); // button location
        Button quitButton = new Button("Quit"); // quit button
            quitButton.setLayoutX(Brawl.fieldLength/2); // button location
            quitButton.setLayoutY(Brawl.fieldHeight/2); // button location

        menuContent.getChildren().addAll(playButton, quitButton); // adds all buttons

        playButton.setOnMouseClicked((event) -> { // when mouse clicks on "play"
            menuWindow.close(); // close menu window
            Brawl brawl = new Brawl(); // starts a new game
        });

        quitButton.setOnMouseClicked((event) -> { // when mouse clicks on "quit"
            menuWindow.close(); // close menu window
        });

    }
}