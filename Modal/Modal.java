package Modal;

import Farm.Farm;
import animals.*;
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
                       if (farm.getWheatSeed() >= 10) {
                           Wheat wheat = new Wheat("Céréale", 110, 5);
                           wheat.plant(Btn, farm);
                           closeModal();
                       }
                       break;
                   case "Orge":
                       if (farm.getBarleySeed() >= 10) {
                           Barley barley = new Barley("Céréale", 80, 20);
                           barley.plant(Btn, farm);
                           closeModal();
                       }
                       break;
                   case "Colza":
                       if (farm.getRapeseedSeed() >= 10) {
                           Rapeseed rapeseed = new Rapeseed("Céréale", 80, 20);
                           rapeseed.plant(Btn, farm);
                           closeModal();
                       }
                       break;
                   case "Mais":
                       if (farm.getMaizeSeed() >= 10) {
                           Maize maize = new Maize("Céréale", 60, 20);
                           maize.plant(Btn, farm);
                           closeModal();
                       }
                       break;
                   case "Soja":
                       if (farm.getSoySeed() >= 10) {
                           Soy soy = new Soy("Céréale", 40, 20);
                           soy.plant(Btn, farm);
                           closeModal();
                       }
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
                        if (farm.getWheatHarvest() >= 10 && farm.getMaizeHarvest() >= 10) {
                            Cow cow = new Cow("Vache", 10, 10, "Lait");
                            cow.install(farm, Btn);
                            closeModal();
                        }
                        break;
                    case "Moutons":
                        if (farm.getBarleySeed() >= 10) {
                            Sheep sheep = new Sheep("Moutons", 10, 10, "Laine");
                            sheep.install(farm, Btn);
                            closeModal();
                        }
                        break;
                    case "Chevres":
                        if (farm.getRapeseedHarvest() >= 10) {
                            Goat goat = new Goat("Chevres", 10, 10, "Lait");
                            goat.install(farm, Btn);
                            closeModal();
                        }
                        break;
                    case "Cochons":
                        if (farm.getMaizeHarvest() >= 10) {
                            Pig pig = new Pig("Cochons", 10, 10, "Saucisse");
                            pig.install(farm, Btn);
                            closeModal();
                        } else if (farm.getBarleyHarvest() >= 10) {
                            Pig pig = new Pig("Cochons", 10, 10, "Saucisse");
                            pig.install(farm, Btn);
                            closeModal();
                        }
                        break;
                    case "Poules":
                        if (farm.getWheatSeed() >= 10) {
                            Chicken chicken = new Chicken("Poules", 10, 5, "Oeufs");
                            chicken.install(farm, Btn);
                            closeModal();
                        }
                        break;
                    default:
                        break;
                }
            });
        }
    }
}