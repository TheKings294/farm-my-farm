package type;

public abstract class Animals {
    private String type;
    private int timeToGrow;
    private int production;
    private String productionType;
    private String[] images;

    public abstract void install();
    public abstract void collectProduction();
}
