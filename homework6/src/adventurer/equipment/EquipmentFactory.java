package adventurer.equipment;

public interface EquipmentFactory {
    public Equipment createEquipment(int id, String name, int durability, int ce);
}
