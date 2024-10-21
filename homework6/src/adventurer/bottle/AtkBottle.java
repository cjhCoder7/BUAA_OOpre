package adventurer.bottle;

public class AtkBottle extends Bottle {
    public AtkBottle(int id, String name, int capacity, int ce) {
        super(id, name, capacity, ce);
    }

    @Override
    public String getType() {
        return "AtkBottle";
    }
}
