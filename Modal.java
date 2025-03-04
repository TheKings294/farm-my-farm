import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


public class Modal {
    @FXML
    private Button closeModalButton;
    @FXML
    private ComboBox<String> ComboBoxVegetal;
    @FXML
    private void closeModal() {
        Stage stage = (Stage) ((javafx.scene.Node) closeModalButton).getScene().getWindow();
        stage.close();
    }
    public void initializeComboBax(String[] vegetals) {
        if (ComboBoxVegetal != null) {
            ComboBoxVegetal.getItems().addAll(vegetals);
        }
    }
}
