package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*; 
import javafx.stage.Stage;



import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Scene scene1;

    @Override
    public void start(Stage stage) throws IOException {
        // StackPane pane = new StackPane();
        // Button btOK = new Button("OK");
        // btOK.setStyle("-fx-border-color: red; -fx-text-fill: black;");
        // btOK.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        // pane.getChildren().add(btOK);

        // scene = new Scene(pane, 800, 480);
        scene = new Scene(loadFXML("main3"));
        stage.setScene(scene);
        stage.show();
        

        // // stage.setTitle("Testing");
        // // stage.setScene(scene);
        // // stage.show();

        // Pane pane = new Pane();
        // pane.setPadding(new Insets(5, 5, 5, 5));
        // Text text1 = new Text(20, 20, "Programming is fun");
        // text1.setFont(Font.font("Courier", FontWeight.BOLD,
        // FontPosture.ITALIC, 15));
        // pane.getChildren().add(text1);

        // Text text2 = new Text(60, 60, "Programming is fun\nDisplay text");
        // pane.getChildren().add(text2);

        // Text text3 = new Text(10, 100, "Programming is fun\nDisplay text");
        // text3.setFill(Color.RED);
        // text3.setUnderline(true);
        // text3.setStrikethrough(true);
        // pane.getChildren().add(text3);

        // // Create a scene and place it in the stage
        // Stage stage1 = new Stage();
        // Scene scene = new Scene(pane, 600, 600);
        // stage.setTitle("ShowText"); // Set the stage title
        // stage1.setScene(scene); // Place the scene in the stage
        // stage1.show(); // Display the stage
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}