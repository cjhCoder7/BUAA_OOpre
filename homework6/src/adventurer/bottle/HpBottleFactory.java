package adventurer.bottle;

public class HpBottleFactory implements BottleFactory {
    @Override
    public Bottle createBottle(int id, String name, int capacity, int ce) {
        return new HpBottle(id, name, capacity, ce);
    }
}
