import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
            primaryStage.setTitle("Farm My Farm");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialize() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 18; j++) {
                Button button = new Button();
                button.setText(i + "-" + j);
                button.setOnAction(e -> {
                   showModal(button.getText());
                });
                gridPane.add(button, i, j);
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    private void showModal(String s) {
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./fxml/modalFields.fxml"));
           Parent root = fxmlLoader.load();

           Stage modalStage = new Stage();
           modalStage.initModality(Modality.APPLICATION_MODAL);
           modalStage.setTitle("Champs " + s);
           modalStage.setScene(new Scene(root));
           modalStage.showAndWait();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}