public class Equipment implements Commodity {
    private final int id;
    private final String name;
    private final int ce;
    private int durability;

    public Equipment(int id, String name, int durability, int ce) {
        this.id = id;
        this.name = name;
        this.durability = durability;
        this.ce = ce;
    }

    public void increaseDurability() {
        this.durability += 1;
        System.out.println(name + " " + durability);
    }

    public int getDurability() { return durability; }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int getCe() { return ce; }
}
