import java.util.ArrayList;
import java.util.List;

public class Farm {
    private int BankAcount;

    /*Seed stock*/
    private int wheatSeed;
    private int barleySeed;
    private int rapeseedSeed;
    private int maizeSeed;
    private int soySeed;

    /*Harvest Stock*/
    private int wheatHarvest;
    private int barleyHarvest;
    private int rapeseedHarvest;
    private int maizeHarvest;
    private int soyHarvest;

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
        this.wheatSeed = wheatSeed;
    }
    public void setBarleySeed(int barleySeed) {
        this.barleySeed = barleySeed;
    }
    public void setRapeseedSeed(int rapeseedSeed) {
        this.rapeseedSeed = rapeseedSeed;
    }
    public void setMaizeSeed(int maizeSeed) {
        this.maizeSeed = maizeSeed;
    }
    public void setSoySeed(int soySeed) {
        this.soySeed = soySeed;
    }
    public int getWheatSeed() {
        return this.wheatSeed;
    }
    public int getBarleySeed() {
        return this.barleySeed;
    }
    public int getRapeseedSeed() {
        return this.rapeseedSeed;
    }
    public int getMaizeSeed() {
        return this.maizeSeed;
    }
    public int getSoySeed() {
        return this.soySeed;
    }
    public String[] getSeed() {
        List<String> seed = new ArrayList<String>();
        if (this.wheatSeed < 0) {
            seed.add("Ble");
        }
        if (this.barleySeed < 0) {
            seed.add("Orge");
        }
        if (this.rapeseedSeed < 0) {
            seed.add("Colza");
        }
        if (this.maizeSeed < 0) {
            seed.add("Mais");
        }
        if (this.soySeed < 0) {
           seed.add("Soja");
        }

        return seed.toArray(new String[seed.size()]);
    }
}