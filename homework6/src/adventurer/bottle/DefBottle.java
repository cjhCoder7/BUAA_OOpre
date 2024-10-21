package adventurer.bottle;

public class DefBottle extends Bottle {
    public DefBottle(int id, String name, int capacity, int ce) {
        super(id, name, capacity, ce);
    }

    @Override
    public String getType() {
        return "DefBottle";
    }
}
