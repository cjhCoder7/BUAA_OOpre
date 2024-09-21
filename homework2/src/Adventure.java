import java.util.HashMap;

public class Adventure {
    private final int id;
    private final String name;
    private final HashMap<Integer, Bottle> bottles;
    private final HashMap<Integer, Equipment> equipments;

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
    }

    public void addBottle(int id, String name, int capacity) {
        Bottle newBottle = new Bottle(id, name, capacity);
        bottles.put(id, newBottle);
    }

    public void addEquipment(int id, String name, int durability) {
        Equipment newEquipment = new Equipment(id, name, durability);
        equipments.put(id, newEquipment);
    }

    public void deleteBottle(int id) {
        Bottle tmpBottle = bottles.remove(id);
        System.out.println(bottles.size() + " "
                + tmpBottle.getName() + " "
                + tmpBottle.getCapacity());
    }

    public void deleteEquipment(int id) {
        Equipment tmpEquipment = equipments.remove(id);
        System.out.println(equipments.size() + " "
                + tmpEquipment.getName() + " "
                + tmpEquipment.getDurability());
    }

    public HashMap<Integer, Bottle> getBottles() { return bottles; }

    public HashMap<Integer, Equipment> getEquipments() { return equipments; }
}
