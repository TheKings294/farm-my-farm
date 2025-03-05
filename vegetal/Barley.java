package vegetal;

import Modal.Modal;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import type.Vegetal;

import Farm.*;

public class Barley extends Vegetal {
    public Barley(String type, int yield, int time) {
        this.type = type;
        this.yield = yield;
        this.timeToGrowth = time;
    }
    @Override
    public void plant(Button button, Farm farm) {
        String dbName = button.getText();
        button.setText("o");
        button.setDisable(true);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToGrowth), e -> {
            button.setText("O");
            button.setDisable(false);
            button.setOnAction(event -> {
                this.harvest(farm,button, dbName);
            });
        }));
        farm.setBarleySeed(farm.getBarleySeed() - 10);
        timeline.setCycleCount(1);
        timeline.play();
    }
    @Override
    public void harvest(Farm farm, Button btn, String btnName) {
        farm.setBarleyHarvest(farm.getBarleyHarvest() + (1 * this.yield));
        btn.setText(btnName);
        btn.setOnAction(e -> {
            Modal.showModal(btn.getText(), farm, (Button) e.getSource());
        });
    }
}
