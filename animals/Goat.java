package animals;

import Farm.Farm;
import Modal.ModalAnimal;
import board.Board;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Animals;

public class Goat extends Animals {
    public static int numberOfGoats = 0;
    public Goat(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
        numberOfGoats += 1;
    }
    @Override
    public void install(Farm farm, Button button, Board board) {
        if (farm.getRapeseedHarvest() >= 10) {
            this.BtnName = button.getText();
            this.grow(farm, button, board);
            button.setText("🐐");
            button.setDisable(true);
        }
    }
    @Override
    public void collectProduction(Farm farm, Board board) {
        farm.setGoatMilkCount(farm.getGoatMilkCount() + 1);
        board.setTotalGoatMilkProduced(board.getTotalGoatMilkProduced() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button, Board board) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button, board);
            farm.setBabyGoatCount(farm.getBabyGoatCount() - 1);
            farm.setGoatCount(farm.getGoatCount() + 1);
            button.setText("🐐");
            button.setDisable(false);
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button, Board board) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm, board);
            if (farm.getRapeseedHarvest() >= 10) {
                farm.setRapeseedHarvest(farm.getRapeseedHarvest() - 10);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();

        button.setOnAction(event -> {
            ModalAnimal.showModal("Chevres", Integer.toString(farm.getGoatMilkCount()), button, this.BtnName, farm, timeline, board);
        });

        farm.getRapeseedHarvestProperty().addListener((observable, oldValue, newValue) -> {
           if (farm.getRapeseedHarvest() < 10) {
               timeline.stop();
           } else if (farm.getRapeseedHarvest() >= 10 * numberOfGoats) {
               timeline.play();
           }
        });
    }
}
