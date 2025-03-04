package Farm;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private int BankAcount;

    /*Seed stock*/
    private IntegerProperty wheatSeed = new SimpleIntegerProperty();
    private IntegerProperty barleySeed = new SimpleIntegerProperty();
    private IntegerProperty rapeseedSeed = new SimpleIntegerProperty();
    private IntegerProperty maizeSeed = new SimpleIntegerProperty();
    private IntegerProperty soySeed = new SimpleIntegerProperty();

    /*Harvest Stock*/
    private IntegerProperty wheatHarvest = new SimpleIntegerProperty();
    private IntegerProperty barleyHarvest = new SimpleIntegerProperty();
    private IntegerProperty rapeseedHarvest = new SimpleIntegerProperty();
    private IntegerProperty maizeHarvest = new SimpleIntegerProperty();
    private IntegerProperty soyHarvest = new SimpleIntegerProperty();

    /*Animals*/
    private int cowCount;
    private int sheepCount;
    private int goatCount;
    private int pigCount;
    private int chickenCount;

    public Farm(int bankAcount) {
        this.BankAcount = bankAcount;
    }
    public void setWheatSeed(int wheatSeed) {
        this.wheatSeed.set(wheatSeed);
    }
    public void setBarleySeed(int barleySeed) {
        this.barleySeed.set(barleySeed);
    }
    public void setRapeseedSeed(int rapeseedSeed) {
        this.rapeseedSeed.set(rapeseedSeed);
    }
    public void setMaizeSeed(int maizeSeed) {
        this.maizeSeed.set(maizeSeed);
    }
    public void setSoySeed(int soySeed) {
        this.soySeed.set(soySeed);
    }

    public int getWheatSeed() {
        return this.wheatSeed.getValue();
    }
    public int getBarleySeed() {
        return this.barleySeed.getValue();
    }
    public int getRapeseedSeed() {
        return this.rapeseedSeed.getValue();
    }
    public int getMaizeSeed() {
        return this.maizeSeed.getValue();
    }
    public int getSoySeed() {
        return this.soySeed.getValue();
    }

    public void setWheatHarvest(int wheatHarvest) {
        this.wheatHarvest.set(wheatHarvest);
    }
    public void setBarleyHarvest(int barleyHarvest) {
        this.barleyHarvest.set(barleyHarvest);
    }
    public void setRapeseedHarvest(int rapeseedHarvest) {
        this.rapeseedHarvest.set(rapeseedHarvest);
    }
    public void setMaizeHarvest(int maizeHarvest) {
        this.maizeHarvest.set(maizeHarvest);
    }
    public void setSoyHarvest(int soyHarvest) {
        this.soyHarvest.set(soyHarvest);
    }

    public int getWheatHarvest() {
        return this.wheatHarvest.getValue();
    }
    public int getBarleyHarvest() {
        return this.barleyHarvest.getValue();
    }
    public int getRapeseedHarvest() {
        return this.rapeseedHarvest.getValue();
    }
    public int getMaizeHarvest() {
        return this.maizeHarvest.getValue();
    }
    public int getSoyHarvest() {
        return this.soyHarvest.getValue();
    }

    public IntegerProperty getWheatSeedProperty() {
        return this.wheatSeed;
    }
    public IntegerProperty getBarleySeedProperty() {
        return this.barleySeed;
    }
    public IntegerProperty getRapeseedSeedProperty() {
        return this.rapeseedSeed;
    }
    public IntegerProperty getMaizeSeedProperty() {
        return this.maizeSeed;
    }
    public IntegerProperty getSoySeedProperty() {
        return this.soySeed;
    }
    public IntegerProperty getWheatHarvestProperty() {
        return this.wheatHarvest;
    }
    public IntegerProperty getBarleyHarvestProperty() {
        return this.barleyHarvest;
    }
    public IntegerProperty getRapeseedHarvestProperty() {
        return this.rapeseedHarvest;
    }
    public IntegerProperty getMaizeHarvestProperty() {
        return this.maizeHarvest;
    }
    public IntegerProperty getSoyHarvestProperty() {
        return this.soyHarvest;
    }
    public String[] getSeed() {
        List<String> seed = new ArrayList<String>();
        if (this.wheatSeed.getValue() > 0) {
            seed.add("Ble");
        }
        if (this.barleySeed.getValue() > 0) {
            seed.add("Orge");
        }
        if (this.rapeseedSeed.getValue() > 0) {
            seed.add("Colza");
        }
        if (this.maizeSeed.getValue() > 0) {
            seed.add("Mais");
        }
        if (this.soySeed.getValue() > 0) {
           seed.add("Soja");
        }

        return seed.toArray(new String[seed.size()]);
    }
}