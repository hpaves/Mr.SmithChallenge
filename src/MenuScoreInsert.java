import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuScoreInsert  {
    public Stage menuWindow = new Stage(); // makes main menu window
    public static String fileName = "Scores.txt";
    public int highScoreContainer = Brawl.smithCounter - 1;
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

        TextField textInsertion = new TextField();
            textInsertion.setLayoutX(menuCenterX - 84); // text centering
            textInsertion.setLayoutY(menuCenterY); // text 40px higher than the middle
        Label highScoreAnnouncement = new Label("You killed " + highScoreContainer + " Smiths\nThis is the new high score!\nPlease enter your name below:");
            highScoreAnnouncement.setTextAlignment(TextAlignment.CENTER);
            highScoreAnnouncement.setLayoutX(menuCenterX - fontLoader.computeStringWidth(highScoreAnnouncement.getText(), highScoreAnnouncement.getFont())/5); // text centering
            highScoreAnnouncement.setLayoutY(menuCenterY - 60); // button location, from which all other button locations are derived
        Button submitButton = new Button("Submit"); // play button
            submitButton.setLayoutX(menuCenterX - (fontLoader.computeStringWidth(submitButton.getText(), submitButton.getFont()))/2 - 8); // button centering
            submitButton.setLayoutY(menuCenterY + 36); // button 40px lower than the middle

        menuContent.getChildren().addAll(textInsertion, highScoreAnnouncement, submitButton); // adds all buttons/text

        submitButton.setOnMouseClicked((event) -> { // when mouse clicks on "play"
            highScoreNameContainer = textInsertion.getText();
            ScoreWriter();
            menuWindow.close(); // close menu window
            Menu menu = new Menu(); // open main menu
        });

    }

    public void ScoreWriter () { // http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(highScoreNameContainer + ":" + highScoreContainer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
//
//    private void setupScene() {
//        VBox vbox = new VBox();
//        Scene scene = new Scene(vbox);
//
//        Label l1 = new Label("Kasutajanimi");
//        kasutajanimi = new TextField();
//        Label l2 = new Label("Parool");
//        parool = new PasswordField();
//        loginButton = new Button("logi sisse");
//        registerButton = new Button("registreeri");
//        vbox.getChildren().addAll(l1, kasutajanimi, l2, parool, loginButton, registerButton);
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    private void setupLogin() {
//        loginButton.setOnAction(event -> {
//            String nimi = kasutajanimi.getText();
//            String p = parool.getText();
//            Andmebaas a = new Andmebaas();
//            boolean result = a.login(nimi, p);
//            a.sulgeYhendus();
//            if (result) {
//                UserDetails ud = new UserDetails(nimi);
//                stage.close();
//            }
//        });
//    }