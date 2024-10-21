package adventurer.bottle;

public class AtkBottleFactory implements BottleFactory {
    @Override
    public Bottle createBottle(int id, String name, int capacity, int ce) {
        return new AtkBottle(id, name, capacity, ce);
    }
}
