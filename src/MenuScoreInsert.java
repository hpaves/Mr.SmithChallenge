import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuScoreInsert  {
    public Stage menuWindow = new Stage(); // makes main menu window
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

        Label highScoreAnnouncement = new Label("You killed " + (Brawl.finalSmithCount) + " Smiths\nThis is the new high score!\nPlease enter your name below:");
            highScoreAnnouncement.setTextAlignment(TextAlignment.CENTER);
            highScoreAnnouncement.setLayoutX(menuCenterX - fontLoader.computeStringWidth(highScoreAnnouncement.getText(), highScoreAnnouncement.getFont())/5); // text centering
            highScoreAnnouncement.setLayoutY(menuCenterY - 60); // button location, from which all other button locations are derived
        TextField textInsertion = new TextField();
            textInsertion.setLayoutX(menuCenterX - 84); // text centering
            textInsertion.setLayoutY(menuCenterY); // text 40px higher than the middle
        Button submitButton = new Button("Submit"); // play button
            submitButton.setLayoutX(menuCenterX - (fontLoader.computeStringWidth(submitButton.getText(), submitButton.getFont()))/2 - 8); // button centering
            submitButton.setLayoutY(menuCenterY + 36); // button 40px lower than the middle

        menuContent.getChildren().addAll(textInsertion, highScoreAnnouncement, submitButton); // adds all buttons/text

        submitButton.setOnMouseClicked((event) -> { // when mouse clicks on "play"
            ScoreReader.highScoreNameContainer = textInsertion.getText();
            ScoreWriter();
            menuWindow.close(); // close menu window
            Menu menu = new Menu(); // open main menu
        });

        submitButton.setOnKeyPressed((event) -> { // when mouse clicks on "quit"
            if(event.getCode() == KeyCode.ENTER) {
                ScoreReader.highScoreNameContainer = textInsertion.getText();
                ScoreWriter();
                menuWindow.close(); // close menu window
                Menu menu = new Menu(); // open main menu            }
            }
        });

    }

    public void ScoreWriter () { // http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
        try{
            PrintWriter writer = new PrintWriter(ScoreReader.fileName, "UTF-8");
            writer.println(ScoreReader.highScoreNameContainer + ":" + Brawl.finalSmithCount);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
