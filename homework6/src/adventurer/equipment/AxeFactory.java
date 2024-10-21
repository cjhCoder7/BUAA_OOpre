package adventurer.equipment;

public class AxeFactory implements EquipmentFactory {
    @Override
    public Equipment createEquipment(int id, String name, int durability, int ce) {
        return new Axe(id, name, durability, ce);
    }
}
