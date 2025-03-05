package type;

import Farm.Farm;
import javafx.scene.control.Button;

public abstract class Animals {
    protected String type;
    protected int timeToGrow;
    protected int production;
    protected String productionType;
    protected String[] images;

    public abstract void install(Farm farm, Button button);
    protected abstract void grow(Farm farm, Button button);
    protected abstract void productions(Farm farm, Button button);
    public abstract void collectProduction(Farm farm);
}
