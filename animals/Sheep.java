package animals;

import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Animals;

public class Sheep extends Animals {
    public Sheep(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
    }
    @Override
    public void install(Farm farm, Button button) {
        this.grow(farm, button);
        button.setText("m");
    }
    @Override
    public void collectProduction(Farm farm) {
        farm.setWoolCount(farm.getWoolCount() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button);
            farm.setBabySheepCount(farm.getBabySheepCount() - 1);
            farm.setSheepCount(farm.getSheepCount() + 1);
            button.setText("M");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    protected void productions(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(production), event -> {
            this.collectProduction(farm);
            if (farm.getBarleyHarvest() >= 10) {
                farm.setBarleyHarvest(farm.getBarleyHarvest() - 10);
                this.productions(farm, button);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
}
