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

public class MenuScoreShow {
    public Stage menuWindow = new Stage(); // makes main menu window
    public String fileName = "Scores.txt";
    public int highScoreContainer;
    public String highScoreNameContainer;
    FontLoader fontLoader = Toolkit.getToolkit().getFontLoader(); // http://stackoverflow.com/questions/21074024/how-to-get-label-getwidth-in-javafx

    public MenuScoreShow(){
        makeMenu();
    }

    public void makeMenu(){ // method that adds all the main menu items together
        Pane menuContent = new Pane(); // container for the menu content
        Scene menuContentFrame = new Scene(menuContent, Brawl.fieldLength, Brawl.fieldHeight); // window resizer, holds content
        menuWindow.setScene(menuContentFrame); // sets window resizer into the main menu window
        menuWindow.show(); // displays the window

        ScoreReader();

        int menuCenterX = Brawl.fieldLength/2;
        int menuCenterY = Brawl.fieldHeight/2;

        Label highScoreName = new Label(highScoreNameContainer);
        highScoreName.setFont(Font.font("Ubuntu Bold", FontWeight.BOLD, 30));
        highScoreName.setLayoutX(menuCenterX - fontLoader.computeStringWidth(highScoreName.getText(), highScoreName.getFont())/2); // text centering
        highScoreName.setLayoutY(menuCenterY - 40); // text 40px higher than the middle
        Label highScore = new Label("killed " + highScoreContainer + " Smiths");
            highScore.setLayoutX(menuCenterX - fontLoader.computeStringWidth(highScore.getText(), highScore.getFont())/2); // text centering
            highScore.setLayoutY(menuCenterY); // button location, from which all other button locations are derived
        Button backButton = new Button("Back"); // play button
            backButton.setLayoutX(menuCenterX - (fontLoader.computeStringWidth(backButton.getText(), backButton.getFont()))/2 - 10); // button centering
            backButton.setLayoutY(menuCenterY + 40); // button 40px lower than the middle

        menuContent.getChildren().addAll(highScoreName, highScore, backButton); // adds all buttons/text

        backButton.setOnMouseClicked((event) -> { // when mouse clicks on "play"
            menuWindow.close(); // close menu window
            Menu menu = new Menu(); // open main menu
        });

    }

    public void ScoreReader() { // http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) { // goes through all the lines
                String[] score = line.split(":");
                lineNumber++;
                highScoreNameContainer = score[0];
                highScoreContainer = Integer.parseInt(score[1]);

//                int comparisonPurposes = Integer.parseInt(score[1]);
//                if (newScore > comparisonPurposes && comparisonPurposes > oldScore[lineNumber +  1]) {
//                    scoreSwitcher();
//
//                }
//                oldScore[newLine] = newScore;
//                Arrays.sort(oldScore);
//                System.out.println(score[0] + " killed " + score[1] + " Smiths " + lineNumber);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}