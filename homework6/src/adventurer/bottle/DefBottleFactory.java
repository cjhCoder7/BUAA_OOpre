package adventurer.bottle;

public class DefBottleFactory implements BottleFactory {
    @Override
    public Bottle createBottle(int id, String name, int capacity, int ce) {
        return new DefBottle(id, name, capacity, ce);
    }
}
