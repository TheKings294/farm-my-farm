import Farm.Farm;
import Modal.Modal;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;

import Modal.*;

public class Main extends Application {
    @FXML
    private GridPane gridPane;
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./fxml/map.fxml"));
            SplitPane root = fxmlLoader.load();
            Scene scene = new Scene(root, 900, 700);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Farm.Farm My Farm.Farm");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialize() {
        Farm farm = new Farm(500);
        Path pathToSave = Path.of("./save/farm.json");

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 18; j++) {
                Button button = new Button();
                button.setText(i + "-" + j);
                button.setOnAction(e -> {
                   Modal.showModal(button.getText(), farm, (Button) e.getSource());
                });
                gridPane.add(button, i, j);
            }
        }

        farm.setWheatSeed(200);
        farm.setSoySeed(200);
        farm.setBarleySeed(200);
        farm.setSoySeed(200);
        farm.setMaizeSeed(200);
        farm.setRapeseedSeed(200);
        if (Files.exists(pathToSave)) {

        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}