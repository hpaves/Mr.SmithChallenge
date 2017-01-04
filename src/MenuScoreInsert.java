import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuScoreInsert  {
    public Stage menuWindow = new Stage(); // makes main menu window
    public String fileName = "Scores.txt";
    public int highScoreContainer;
    public String highScoreNameContainer;
    FontLoader fontLoader = Toolkit.getToolkit().getFontLoader(); // http://stackoverflow.com/questions/21074024/how-to-get-label-getwidth-in-javafx

    public MenuScoreInsert(){
        makeMenu();
    }

    public void makeMenu(){ // method that adds all the main menu items together
        Pane menuContent = new Pane(); // container for the menu content
        Scene menuContentFrame = new Scene(menuContent, Brawl.fieldLength, Brawl.fieldHeight); // window resizer, holds content
        menuWindow.setScene(menuContentFrame); // sets window resizer into the main menu window
        menuWindow.show(); // displays the window



        int menuCenterX = Brawl.fieldLength/2;
        int menuCenterY = Brawl.fieldHeight/2;

        Label highScoreName = new Label(highScoreNameContainer);
        highScoreName.setFont(Font.font("Ubuntu Bold", FontWeight.BOLD, 30));
        highScoreName.setLayoutX(menuCenterX - fontLoader.computeStringWidth(highScoreName.getText(), highScoreName.getFont())/2); // text centering
        highScoreName.setLayoutY(menuCenterY - 40); // text 40px higher than the middle
        Label highScore = new Label("killed " + highScoreContainer + " Smiths");
        highScore.setLayoutX(menuCenterX - fontLoader.computeStringWidth(highScore.getText(), highScore.getFont())/2); // text centering
        highScore.setLayoutY(menuCenterY); // button location, from which all other button locations are derived
        Button submitButton = new Button("Submit"); // play button
        submitButton.setLayoutX(menuCenterX - (fontLoader.computeStringWidth(submitButton.getText(), submitButton.getFont()))/2 - 10); // button centering
        submitButton.setLayoutY(menuCenterY + 40); // button 40px lower than the middle

        menuContent.getChildren().addAll(highScoreName, highScore, submitButton); // adds all buttons/text

        submitButton.setOnMouseClicked((event) -> { // when mouse clicks on "play"
            ScoreWriter();
            menuWindow.close(); // close menu window
            Menu menu = new Menu(); // open main menu
        });


    }

    public void ScoreWriter () { // http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
        try{
            PrintWriter writer = new PrintWriter("Scores.txt", "UTF-8");
            writer.println(highScoreNameContainer + ":" + highScoreContainer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}