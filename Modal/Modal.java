package Modal;

import Farm.Farm;
import animals.Cow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vegetal.*;


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
            modal.initializeComboAnimals(farm.getAnimals());
            modal.initializeSeedBtn(button, farm);
            modal.initializeAnimalsBtn(button, farm);

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
                       Wheat wheat = new Wheat("Céréale", 100, 20);
                       wheat.plant(Btn, farm);
                       closeModal();
                       break;
                   case "Orge":
                       Barley barley = new Barley("Céréale", 100, 20);
                       barley.plant(Btn, farm);
                       closeModal();
                       break;
                   case "Colza":
                       Rapeseed rapeseed = new Rapeseed("Céréale", 100, 20);
                       rapeseed.plant(Btn, farm);
                       closeModal();
                       break;
                   case "Mais":
                       Maize maize = new Maize("Céréale", 100, 20);
                       maize.plant(Btn, farm);
                       closeModal();
                       break;
                   case "Soja":
                       Soy soy = new Soy("Céréale", 100, 20);
                       soy.plant(Btn, farm);
                       closeModal();
                       break;
                   default:
                       break;
               }
            });
        }
    }
    public void initializeAnimalsBtn(Button Btn, Farm farm) {
        if (animalsBtn != null) {
            animalsBtn.setOnMouseClicked(e -> {
                switch (ComboBoxAnimals.getValue()) {
                    case "Vaches":
                        Cow cow = new Cow("Vache", 10, 10, "Lait");
                        cow.install(farm, Btn);
                        closeModal();
                        break;
                    default:
                        break;
                }
            });
        }
    }
}