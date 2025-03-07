package animals;

import Farm.Farm;
import Modal.ModalAnimal;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Animals;

public class Pig extends Animals {
    public static int numberOfPigs = 0;
    public Pig(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
        numberOfPigs += 1;
    }
    @Override
    public void install(Farm farm, Button button) {
        if (farm.getMaizeHarvest() >= 10) {
            this.grow(farm, button);
            this.BtnName = button.getText();
            button.setText("c");
        } else if (farm.getBarleyHarvest() >= 10) {
            this.grow(farm, button);
            this.BtnName = button.getText();
            button.setText("c");
        }
    }
    @Override
    public void collectProduction(Farm farm) {
        farm.setSausagesCount(farm.getSausagesCount() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button);
            farm.setBabyPigCount(farm.getBabyPigCount() - 1);
            farm.setPigCount(farm.getPigCount() + 1);
            button.setText("C");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm);
            if (farm.getMaizeHarvest() >= 10) {
                farm.setMaizeHarvest(farm.getMaizeHarvest() - 10);
                this.productions(farm, button);
            } else if (farm.getBarleyHarvest() >= 10) {
                farm.setBarleyHarvest(farm.getBarleyHarvest() - 10);
                this.productions(farm, button);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();

        button.setOnAction(event -> {
            ModalAnimal.showModal("Cochons", Integer.toString(farm.getSausagesCount()), button, this.BtnName, farm, timeline);
        });

        farm.getMaizeHarvestProperty().addListener((observable, oldValue, newValue) -> {
            if (farm.getMaizeHarvest() < 10 && farm.getBarleyHarvest() < 10) {
                timeline.stop();
            } else if (farm.getMaizeHarvest() >= 10) {
                timeline.play();
            }
        });
        farm.getBarleyHarvestProperty().addListener((observable, oldValue, newValue) -> {
            if (farm.getBarleyHarvest() < 10 && farm.getMaizeHarvest() >= 10) {
                timeline.stop();
            } else if (farm.getBarleyHarvest() >= 10) {
                timeline.play();
            }
        });
    }
}
