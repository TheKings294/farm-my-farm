package type;

public abstract class Vegetal {
    private String type;
    private int timeToGrowth;
    private int yield;
    private String[] images;

    public abstract void plant();
    public abstract int harvest();
}