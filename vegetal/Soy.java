package vegetal;

import Modal.Modal;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Vegetal;

import Farm.*;

public class Soy extends Vegetal {
    public Soy(String type, int yield, int time) {
        this.type = type;
        this.yield = yield;
        this.timeToGrowth = time;
    }
    @Override
    public void plant(Button button, Farm farm) {
        String dbName = button.getText();
        button.setText("s");
        button.setDisable(true);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrowth), e -> {
            button.setText("S");
            button.setDisable(false);
            button.setOnAction(event -> {
                this.harvest(farm,button, dbName);
            });
        }));
        farm.setSoySeed(farm.getWheatSeed() - 10);
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    public void harvest(Farm farm, Button btn, String btnName) {
        farm.setSoyHarvest(farm.getSoyHarvest() + (1 * this.yield));
        btn.setText(btnName);
        btn.setOnAction(e -> {
            Modal.showModal(btn.getText(), farm, (Button) e.getSource());
        });
    }
}
