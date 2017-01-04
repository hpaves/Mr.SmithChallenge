import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        FontLoader fontLoader = Toolkit.getToolkit().getFontLoader(); // http://stackoverflow.com/questions/21074024/how-to-get-label-getwidth-in-javafx

        int menuCenterX = Brawl.fieldLength/2;
        int menuCenterY = Brawl.fieldHeight/2;

        Button playButton = new Button("Play"); // play button
            playButton.setLayoutX(menuCenterX - fontLoader.computeStringWidth(playButton.getText(), playButton.getFont()) - 24); // moving button to the left, relative to its length and modified by the button edges
            playButton.setLayoutY(menuCenterY); // fixed Y location
        Button quitButton = new Button("Quit"); // quit button
            quitButton.setLayoutX(menuCenterX); // button location, from which all other button locations are derived
            quitButton.setLayoutY(menuCenterY); // fixed Y location
        Button highScoreButton = new Button("High Score"); // play button
            highScoreButton.setLayoutX(menuCenterX - (fontLoader.computeStringWidth(highScoreButton.getText(), highScoreButton.getFont()))/2 - 12); // centering the button text modified by button edges
            highScoreButton.setLayoutY(quitButton.getLayoutY() + 40); // button fixed Y location
//        Button highScoreInsertButton = new Button("Insert Hight Score"); // quit button
//            highScoreInsertButton.setLayoutX(menuCenterX - 65); // button location
//            highScoreInsertButton.setLayoutY(menuCenterY + menuCenterY/4); // button location
        Label nameOfTheGame = new Label("mr. smith");
            nameOfTheGame.setFont(Font.font("Ubuntu Bold", FontWeight.BOLD, 50));
            nameOfTheGame.setLayoutX(menuCenterX - (fontLoader.computeStringWidth(nameOfTheGame.getText(), nameOfTheGame.getFont()))/2); // text centering
            nameOfTheGame.setLayoutY(quitButton.getLayoutY() - 70); // button fixed Y location

        menuContent.getChildren().addAll(nameOfTheGame, playButton, quitButton, highScoreButton); // adds all buttons/text

        playButton.setOnMouseClicked((event) -> { // when mouse clicks on "play"
            menuWindow.close(); // close menu window
            Brawl brawl = new Brawl(); // starts a new game
        });

        quitButton.setOnMouseClicked((event) -> { // when mouse clicks on "quit"
            menuWindow.close(); // close menu window
        });

        highScoreButton.setOnMouseClicked((event) -> { // when mouse clicks on "quit"
            menuWindow.close(); // close menu window
            MenuScoreShow menuScoreShow = new MenuScoreShow();
        });

    }

//    public static GetLabelWidth(String labelName) {
//
//        int labelWidth = (l.prefWidth(-1)+"/"+l.prefHeight(-1));
//    }
}