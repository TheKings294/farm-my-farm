package type;

import Farm.Farm;
import javafx.animation.Timeline;
import javafx.scene.control.Button;

public abstract class Animals {
    protected String type;
    protected int timeToGrow;
    protected int production;
    protected String productionType;
    protected String[] images;
    protected String BtnName;

    public abstract void install(Farm farm, Button button);
    protected abstract void grow(Farm farm, Button button);
    protected abstract void productions(Farm farm, Button button);
    public abstract void collectProduction(Farm farm);
    public static void stopProduction(Timeline t) {
        t.stop();
    };
}