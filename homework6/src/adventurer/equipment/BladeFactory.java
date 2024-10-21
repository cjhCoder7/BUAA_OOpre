package adventurer.equipment;

public class BladeFactory implements EquipmentFactory {
    @Override
    public Equipment createEquipment(int id, String name, int durability, int ce) {
        return new Blade(id, name, durability, ce);
    }
}
