import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Modal {
    @FXML
    private Button closeModalButton;
    @FXML
    private void closeModal() {
        Stage stage = (Stage) ((javafx.scene.Node) closeModalButton).getScene().getWindow();
        stage.close();
    }
}
