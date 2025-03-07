package animals;

import Farm.Farm;
import Modal.ModalAnimal;
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
    public void install(Farm farm, Button button) {
        if (farm.getRapeseedHarvest() >= 10) {
            this.BtnName = button.getText();
            this.grow(farm, button);
            button.setText("c");
        }
    }
    @Override
    public void collectProduction(Farm farm) {
        farm.setGoatMilkCount(farm.getGoatMilkCount() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button);
            farm.setBabyGoatCount(farm.getBabyGoatCount() - 1);
            farm.setGoatCount(farm.getGoatCount() + 1);
            button.setText("C");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm);
            if (farm.getRapeseedHarvest() >= 10) {
                farm.setRapeseedHarvest(farm.getRapeseedHarvest() - 10);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();

        button.setOnAction(event -> {
            ModalAnimal.showModal("Chevres", Integer.toString(farm.getGoatMilkCount()), button, this.BtnName, farm, timeline);
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
