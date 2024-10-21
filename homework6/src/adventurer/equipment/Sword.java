package adventurer.equipment;

public class Sword extends Equipment {
    public Sword(int id, String name, int durability, int ce) {
        super(id, name, durability, ce);
    }

    @Override
    public String getType() {
        return "Sword";
    }
}
