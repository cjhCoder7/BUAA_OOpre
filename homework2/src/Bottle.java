public class Bottle {
    private final int id;
    private final String name;
    private int capacity;

    public Bottle(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }

    public int getCapacity() { return capacity; }
}
