import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
    public Pane menuContent = new Pane();
    public Scene menuContentFrame;
    public Stage menuWindow = new Stage();

    public Menu(){
        makeMenu();
    }

    public void makeMenu(){
        menuContent = new Pane();
        menuContentFrame = new Scene(menuContent, Brawl.fieldLength, Brawl.fieldHeight);
        menuWindow = new Stage();
        menuWindow.setScene(menuContentFrame);
        menuWindow.show();

        Button playButton = new Button("Play");
            playButton.setLayoutX(Brawl.fieldLength/2 - 50   )      ;
             playButton.setLayoutY(Brawl.fieldHeight/2);
        Button quitButton = new Button("Quit");
            quitButton.setLayoutX(Brawl.fieldLength/2);
            quitButton.setLayoutY(Brawl.fieldHeight/2);

        menuContent.getChildren().addAll(playButton, quitButton);

        playButton.setOnMouseClicked((event) -> {
            menuWindow.close();
            Brawl brawl = new Brawl(); //new game
        });

        quitButton.setOnMouseClicked((event) -> {
            menuWindow.close();
        });

    }
}