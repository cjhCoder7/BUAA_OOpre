package adventurer.bottle;

import adventurer.Commodity;

public class Bottle implements Commodity {
    private final int id;
    private final String name;
    private final int ce;
    private final int capacity;
    private boolean isUsed;

    public Bottle(int id, String name, int capacity, int ce) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.ce = ce;
        this.isUsed = false;
    }

    public void use() {
        isUsed = true;
    }

    public void fill() {
        isUsed = false;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public String getType() { return "Bottle"; }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int getCe() { return ce; }
}
