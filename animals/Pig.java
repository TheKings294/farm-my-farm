package animals;

import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Animals;

public class Pig extends Animals {
    public Pig(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
    }
    @Override
    public void install(Farm farm, Button button) {
        this.grow(farm, button);
        button.setText("c");
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
            this.productions(farm, button);
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
}
