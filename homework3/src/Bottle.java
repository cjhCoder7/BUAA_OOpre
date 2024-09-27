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

    public int getCapacity() { return capacity; }

    public boolean getIsUsed() { return isUsed; }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int getCe() { return ce; }
}
