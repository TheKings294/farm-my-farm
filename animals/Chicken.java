package animals;

import Farm.Farm;
import Modal.ModalAnimal;
import board.Board;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Animals;

public class Chicken extends Animals {
    public static int numberOfChickens = 0;
    public Chicken(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
        numberOfChickens += 1;
    }
    @Override
    public void install(Farm farm, Button button, Board board) {
        if (farm.getWheatHarvest() >= 10) {
            this.BtnName = button.getText();
            this.grow(farm, button, board);
            button.setText("🐥");
        }
    }
    @Override
    public void collectProduction(Farm farm, Board board) {
        farm.setEggsCount(farm.getEggsCount() + 1);
        board.setTotalEggsProduced(board.getTotalEggsProduced() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button, Board board) {
        farm.setWheatHarvest(farm.getWheatHarvest() - 10);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button, board);
            farm.setBabyChickenCount(farm.getBabyChickenCount() - 1);
            farm.setChickenCount(farm.getChickenCount() + 1);
            button.setText("🐓");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button, Board board) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm, board);
            farm.setWheatHarvest(farm.getWheatHarvest() - 10);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        button.setOnAction(event -> {
            ModalAnimal.showModal("Poules", Integer.toString(farm.getEggsCount()), button, this.BtnName, farm, timeline, board);
        });

        farm.getWheatHarvestProperty().addListener((observable, oldValue, newValue) -> {
            if (farm.getWheatHarvest() < 10) {
                timeline.stop();
            } else if (farm.getWheatHarvest() >= 10 * numberOfChickens) {
                timeline.play();
            }
        });
    }
}
