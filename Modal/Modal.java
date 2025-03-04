package Modal;

import Farm.Farm;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vegetal.Wheat;


public class Modal {
    @FXML
    private Button closeModalButton;
    @FXML
    private ComboBox<String> comboBoxVegetal;
    @FXML
    private ComboBox<String> ComboBoxAnimals;
    @FXML
    private Button seedBtn;
    @FXML
    private Button animalsBtn;
    @FXML
    private void closeModal() {
        Stage stage = (Stage) ((javafx.scene.Node) closeModalButton).getScene().getWindow();
        stage.close();
    }
    public static void showModal(String s, Farm farm, Button button) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Modal.class.getResource("../fxml/modalFields.fxml"));
            Parent root = fxmlLoader.load();
            Modal modal = fxmlLoader.getController();

            modal.initializeComboBax(farm.getSeed());
            modal.initializeSeedBtn(button, farm);

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Champs " + s);
            modalStage.setScene(new Scene(root));
            modalStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initializeComboBax(String[] vegetals) {
        if (comboBoxVegetal != null) {
            for (String vegetal : vegetals) {
                comboBoxVegetal.getItems().add(vegetal);
            }
        }
    }
    public void initializeComboAnimals(String[] animals) {
        if (ComboBoxAnimals != null) {
            for (String animal : animals) {
                ComboBoxAnimals.getItems().add(animal);
            }
        }
    }
    public void initializeSeedBtn(Button Btn, Farm farm) {
        if (seedBtn != null) {
            seedBtn.setOnMouseClicked(e -> {
               switch (comboBoxVegetal.getValue()) {
                   case "Ble":
                       Wheat wheat = new Wheat("Céréale", 10, 20);
                       wheat.plant(Btn, farm);
                       closeModal();
                       break;
                   case "Orge":
                       System.out.println("Orge");
                       break;
                   case "Colza":
                       System.out.println("Colza");
                       break;
                   case "Mais":
                       System.out.println("Mais");
                       break;
                   case "Soja":
                       System.out.println("Soja");
                       break;
                   default:
                       break;
               }
            });
        }
    }
}
