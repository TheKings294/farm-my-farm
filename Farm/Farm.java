package Farm;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private IntegerProperty BankAcount = new SimpleIntegerProperty();

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
    private IntegerProperty cowCount = new SimpleIntegerProperty();
    private IntegerProperty sheepCount = new SimpleIntegerProperty();
    private IntegerProperty goatCount = new SimpleIntegerProperty();
    private IntegerProperty pigCount = new SimpleIntegerProperty();
    private IntegerProperty chickenCount = new SimpleIntegerProperty();

    private IntegerProperty babyCowCount = new SimpleIntegerProperty();
    private IntegerProperty babySheepCount = new SimpleIntegerProperty();
    private IntegerProperty babyGoatCount = new SimpleIntegerProperty();
    private IntegerProperty babyPigCount = new SimpleIntegerProperty();
    private IntegerProperty babyChickenCount = new SimpleIntegerProperty();

    private IntegerProperty milkCount = new SimpleIntegerProperty();
    private IntegerProperty woolCount = new SimpleIntegerProperty();
    private IntegerProperty goatMilkCount = new SimpleIntegerProperty();
    private IntegerProperty sausagesCount = new SimpleIntegerProperty();
    private IntegerProperty eggsCount = new SimpleIntegerProperty();
    
    public int getBankAcount() {
        return BankAcount.getValue();
    }
    public void setBankAcount(int BankAcount) {
        this.BankAcount.set(BankAcount);
    }
    public IntegerProperty BankAcountProperty() {
        return BankAcount;
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

    public int getCowCount() {
        return this.cowCount.getValue();
    }
    public int getSheepCount() {
        return this.sheepCount.getValue();
    }
    public int getGoatCount() {
        return this.goatCount.getValue();
    }
    public int getPigCount() {
        return this.pigCount.getValue();
    }
    public int getChickenCount() {
        return this.chickenCount.getValue();
    }
    public int getBabyCowCount() {
        return this.babyCowCount.getValue();
    }
    public int getBabySheepCount() {
        return this.babySheepCount.getValue();
    }
    public int getBabyGoatCount() {
        return this.babyGoatCount.getValue();
    }
    public int getBabyPigCount() {
        return this.babyPigCount.getValue();
    }
    public int getBabyChickenCount() {
        return this.babyChickenCount.getValue();
    }
    public int getMilkCount() {
        return this.milkCount.getValue();
    }
    public int getWoolCount() {
        return this.woolCount.getValue();
    }
    public int getGoatMilkCount() {
        return this.goatMilkCount.getValue();
    }
    public int getSausagesCount() {
        return this.sausagesCount.getValue();
    }
    public int getEggsCount() {
        return this.eggsCount.getValue();
    }

    public void setCowCount(int cowCount) {
        this.cowCount.set(cowCount);
    }
    public void setSheepCount(int sheepCount) {
        this.sheepCount.set(sheepCount);
    }
    public void setGoatCount(int goatCount) {
        this.goatCount.set(goatCount);
    }
    public void setPigCount(int pigCount) {
        this.pigCount.set(pigCount);
    }
    public void setChickenCount(int chickenCount) {
        this.chickenCount.set(chickenCount);
    }
    public void setBabyCowCount(int babyCowCount) {
        this.babyCowCount.set(babyCowCount);
    }
    public void setBabySheepCount(int babySheepCount) {
        this.babySheepCount.set(babySheepCount);
    }
    public void setBabyGoatCount(int babyGoatCount) {
        this.babyGoatCount.set(babyGoatCount);
    }
    public void setBabyPigCount(int babyPigCount) {
        this.babyPigCount.set(babyPigCount);
    }
    public void setBabyChickenCount(int babyChickenCount) {
        this.babyChickenCount.set(babyChickenCount);
    }
    public void setMilkCount(int milkCount) {
        this.milkCount.set(milkCount);
    }
    public void setWoolCount(int woolCount) {
        this.woolCount.set(woolCount);
    }
    public void setGoatMilkCount(int goatMilkCount) {
        this.goatMilkCount.set(goatMilkCount);
    }
    public void setSausagesCount(int sausagesCount) {
        this.sausagesCount.set(sausagesCount);
    }
    public void setEggsCount(int eggsCount) {
        this.eggsCount.set(eggsCount);
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
    public IntegerProperty getCowProperty() {
        return this.cowCount;
    }
    public IntegerProperty getSheepProperty() {
        return this.sheepCount;
    }
    public IntegerProperty getGoatProperty() {
        return this.goatCount;
    }
    public IntegerProperty getPigProperty() {
        return this.pigCount;
    }
    public IntegerProperty getChickenProperty() {
        return this.chickenCount;
    }
    public IntegerProperty getBabyCowProperty() {
        return this.babyCowCount;
    }
    public IntegerProperty getBabySheepProperty() {
        return this.babySheepCount;
    }
    public IntegerProperty getBabyGoatProperty() {
        return this.babyGoatCount;
    }
    public IntegerProperty getBabyPigProperty() {
        return this.babyPigCount;
    }
    public IntegerProperty getBabyChickenProperty() {
        return this.babyChickenCount;
    }
    public IntegerProperty getMilkProperty() {
        return this.milkCount;
    }
    public IntegerProperty getWoolProperty() {
        return this.woolCount;
    }
    public IntegerProperty getGoatMilkProperty() {
        return this.goatMilkCount;
    }
    public IntegerProperty getSausagesProperty() {
        return this.sausagesCount;
    }
    public IntegerProperty getEggsProperty() {
        return this.eggsCount;
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
    public String[] getAnimals() {
        List<String> animals = new ArrayList<String>();
        if (this.babyCowCount.getValue() > 0) {
            animals.add("Vaches");
        }
        if (this.babySheepCount.getValue() > 0) {
            animals.add("Moutons");
        }
        if (this.babyGoatCount.getValue() > 0) {
            animals.add("Chevres");
        }
        if (this.babyPigCount.getValue() > 0) {
            animals.add("Cochons");
        }
        if (this.babyChickenCount.getValue() > 0) {
            animals.add("Poules");
        }

        return animals.toArray(new String[animals.size()]);
    }
}