package animals;

import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Animals;

public class Chicken extends Animals {
    public Chicken(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
    }
    @Override
    public void install(Farm farm, Button button) {
        if (farm.getWheatHarvest() > 10) {
            this.grow(farm, button);
            button.setText("c");
        }
    }
    @Override
    public void collectProduction(Farm farm) {
        farm.setEggsCount(farm.getEggsCount() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button) {
        farm.setWheatHarvest(farm.getWheatHarvest() - 10);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button);
            farm.setBabyChickenCount(farm.getBabyChickenCount() - 1);
            farm.setChickenCount(farm.getChickenCount() + 1);
            button.setText("C");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm);
            if (farm.getWheatHarvest() >= 10) {
                farm.setWheatHarvest(farm.getWheatHarvest() - 10);
                this.productions(farm, button);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
}
