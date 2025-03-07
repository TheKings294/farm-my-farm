package animals;

import Farm.Farm;
import Modal.ModalAnimal;
import board.Board;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import type.Animals;
import javafx.scene.control.Button;

public class Cow extends Animals {
    public static int numberOfCows = 0;
    public Cow(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
        numberOfCows += 1;
    }
    @Override
    public void install(Farm farm, Button button, Board board) {
        if (farm.getWheatHarvest() >= 10 && farm.getMaizeHarvest() >= 10) {
            this.BtnName = button.getText();
            this.grow(farm, button, board);
            button.setText("🐮");
        }
    }
    @Override
    public void collectProduction(Farm farm, Board board) {
        farm.setMilkCount(farm.getMilkCount() + 1);
        board.setTotalMilkProduced(board.getTotalMilkProduced() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button, Board board) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button, board);
            farm.setBabyCowCount(farm.getBabyCowCount() - 1);
            farm.setCowCount(farm.getCowCount() + 1);
            button.setText("🐄");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button, Board board) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm, board);
            if (farm.getMaizeHarvest() >= 10 && farm.getWheatHarvest() >= 10) {
                farm.setWheatHarvest(farm.getWheatHarvest() - 10);
                farm.setMaizeHarvest(farm.getMaizeHarvest() - 10);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();

        button.setOnAction(event -> {
            ModalAnimal.showModal("Vaches", Integer.toString(farm.getMilkCount()), button, this.BtnName, farm, timeline, board);
        });

        farm.getWheatHarvestProperty().addListener((observable, oldValue, newValue) -> {
            if (farm.getWheatHarvest() < 10) {
                timeline.stop();
            } else if (farm.getWheatHarvest() >= 10 * numberOfCows && farm.getMaizeHarvest() >= 10 * numberOfCows) {
                timeline.play();
            }
        });
        farm.getMaizeHarvestProperty().addListener((observable, oldValue, newValue) -> {
            if (farm.getMaizeHarvest() < 10) {
                timeline.stop();
            } else if (farm.getWheatHarvest() >= 10 * numberOfCows && farm.getMaizeHarvest() >= 10 * numberOfCows) {
                timeline.play();
            }
        });
    }
}