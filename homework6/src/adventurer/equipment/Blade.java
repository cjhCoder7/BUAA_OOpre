package adventurer.equipment;

public class Blade extends Equipment {
    public Blade(int id, String name, int durability, int ce) {
        super(id, name, durability, ce);
    }

    @Override
    public String getType() {
        return "Blade";
    }
}
