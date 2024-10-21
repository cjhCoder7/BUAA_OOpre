package adventurer.equipment;

public class SwordFactory implements EquipmentFactory {
    @Override
    public Equipment createEquipment(int id, String name, int durability, int ce) {
        return new Sword(id, name, durability, ce);
    }
}
