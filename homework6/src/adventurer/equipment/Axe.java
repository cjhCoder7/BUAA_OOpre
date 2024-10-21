package adventurer.equipment;

public class Axe extends Equipment {
    public Axe(int id, String name, int durability, int ce) {
        super(id, name, durability, ce);
    }

    @Override
    public String getType() {
        return "Axe";
    }
}
