package animals;

import Farm.Farm;
import Modal.ModalAnimal;
import board.Board;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Animals;

public class Sheep extends Animals {
    public static int numberOfSheeps = 0;
    public Sheep(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
        numberOfSheeps += 1;
    }
    @Override
    public void install(Farm farm, Button button, Board board) {
        if (farm.getBarleyHarvest() >= 10) {
            this.grow(farm, button, board);
            this.BtnName = button.getText();
            button.setText("🐑");
        }
    }
    @Override
    public void collectProduction(Farm farm, Board board) {
        farm.setWoolCount(farm.getWoolCount() + 1);
        board.setTotalWoolProduced(board.getTotalWoolProduced() + 1);
        System.out.println(board.getTotalWoolProduced() + " wools collected");
    }
    @Override
    protected void grow(Farm farm, Button button, Board board) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button, board);
            farm.setBabySheepCount(farm.getBabySheepCount() - 1);
            farm.setSheepCount(farm.getSheepCount() + 1);
            button.setText("🐏");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button, Board board) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm, board);
            if (farm.getBarleyHarvest() >= 10) {
                farm.setBarleyHarvest(farm.getBarleyHarvest() - 10);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();

        button.setOnAction(event -> {
            ModalAnimal.showModal("Moutons", Integer.toString(farm.getWoolCount()), button, this.BtnName, farm, timeline, board);
        });

        farm.getBarleyHarvestProperty().addListener((observable, oldValue, newValue) -> {
            if (farm.getBarleyHarvest() < 10) {
                timeline.stop();
            } else if (farm.getBarleyHarvest() >= 10 * numberOfSheeps) {
                timeline.play();
            }
        });
    }
}
