package animals;

import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import type.Animals;
import javafx.scene.control.Button;

public class Cow extends Animals {
    public Cow(String type, int timeToGrow, int production, String productionType) {
        this.type = type;
        this.timeToGrow = timeToGrow;
        this.production = production;
        this.productionType = productionType;
    }
    @Override
    public void install(Farm farm, Button button) {
        this.grow(farm, button);
        button.setText("v");
    }
    @Override
    public void collectProduction(Farm farm) {
        farm.setMilkCount(farm.getMilkCount() + 1);
    }
    @Override
    protected void grow(Farm farm, Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrow), event -> {
            this.productions(farm, button);
            farm.setBabyCowCount(farm.getBabyCowCount() - 1);
            farm.setCowCount(farm.getCowCount() + 1);
            button.setText("V");
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
