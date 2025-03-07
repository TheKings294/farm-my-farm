package Modal;

import Farm.Farm;
import animals.*;
import board.Board;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import type.Animals;

public class ModalAnimal {
    @FXML
    private Label animalType;
    @FXML
    private Label production;
    @FXML
    private Button removeAnimal;

    private void closeModal() {
        Stage stage = (Stage) animalType.getScene().getWindow(); // Use any injected node
        stage.close();
    }

    public static void showModal(String animal, String prod, Button button, String btnName, Farm farm, Timeline t, Board board) {
        try {
            FXMLLoader loader = new FXMLLoader(ModalAnimal.class.getResource("../fxml/modalAnimal.fxml"));
            Parent root = loader.load();
            ModalAnimal modal = loader.getController();

            modal.initialize(animal, prod, button, btnName, farm, t, board);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(animal);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialize(String animal, String prod, Button remove, String s, Farm farm, Timeline t, Board board) {
        animalType.setText(animal);
        production.setText(prod);
        removeAnimal.setOnAction(e -> {
            switch (animal) {
                case "Vaches":
                    farm.setCowCount(farm.getCowCount() - 1);
                    Cow.numberOfCows = Cow.numberOfCows - 1;
                    break;
                case "Moutons":
                    farm.setSheepCount(farm.getSheepCount() - 1);
                    Sheep.numberOfSheeps = Sheep.numberOfSheeps - 1;
                    break;
                case "Chevres":
                    farm.setGoatCount(farm.getGoatCount() - 1);
                    Goat.numberOfGoats = Goat.numberOfGoats - 1;
                    break;
                case "Cochons":
                    farm.setPigCount(farm.getPigCount() - 1);
                    Pig.numberOfPigs = Pig.numberOfPigs - 1;
                    break;
                case "Poules":
                    farm.setChickenCount(farm.getChickenCount() - 1);
                    Chicken.numberOfChickens = Chicken.numberOfChickens - 1;
                    break;
                default:
                    break;
            }
            remove.setText(s);
            remove.setOnAction(event -> {
                Modal.showModal(s, farm, remove, board);
            });
            Animals.stopProduction(t);
            closeModal();
        });
    }
}
