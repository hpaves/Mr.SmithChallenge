import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox esimeseAknaStruktuur = new VBox();
        Scene sisseLogimisAken = new Scene(esimeseAknaStruktuur, 300, 300);
        primaryStage.setScene(sisseLogimisAken);
        primaryStage.show();

        Label pealkiri = new Label("Kirjuta parool:");
        TextField parooliV2li = new TextField();
        Button sisestusNupp = new Button("Sisene");

        esimeseAknaStruktuur.getChildren().addAll(pealkiri, parooliV2li, sisestusNupp);

        Circle pallike = new Circle(50);
        Pane sisuPaneel = new Pane();
        sisuPaneel.getChildren().add(pallike);
        Scene leheSisu = new Scene(sisuPaneel, 600, 500);

        sisestusNupp.setOnAction(event -> {
            String parool = parooliV2li.getText();
            if (parool.equals("salakala")) {
                System.out.println("Parool on õige");
                primaryStage.setScene(leheSisu);
            } else {
                System.out.println("Parool on vale");
            }
        });

/*        Pane window = new Pane();
        Scene view1 = new Scene(window, 400, 300);

        primaryStage.setScene(view1);
        primaryStage.show();

        Circle ring = new Circle(100);
        ring.setCenterX(100);
        ring.setCenterY(-50);
        window.getChildren().add(ring);

        ring.setOnMouseClicked(event -> { // event on sisendparameeter
            System.out.println("KLIKK"); // kontrolli programmi toimimist kasvõi iga kolme rea tagant
            ring.setCenterX(200);
            ring.setCenterY(150);
        });*/
    }
}