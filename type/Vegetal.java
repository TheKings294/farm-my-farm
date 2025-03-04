package type;

import javafx.scene.control.Button;
import Farm.*;

public abstract class Vegetal {
    protected String type;
    protected int timeToGrowth;
    protected int yield;
    protected String[] images;

    public abstract void plant(Button button, Farm farm);
    public abstract void harvest(Farm farm, Button btn, String btnName);
}