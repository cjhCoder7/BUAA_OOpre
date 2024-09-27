import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public class CommandUtil {
    // 管理输出和所有冒险者
    private static final HashMap<Integer, Adventure> adventures = new HashMap<>();
    private static final HashMap<Integer, Consumer<ArrayList<String>>> commandMap = new HashMap<>();

    public static void initCommandUtil() {
        commandMap.put(1, CommandUtil::addAdventure);
        commandMap.put(2, CommandUtil::addAdventureBottle);
        commandMap.put(3, CommandUtil::addAdventureEquipment);
        commandMap.put(4, CommandUtil::increaseDurability);
        commandMap.put(5, CommandUtil::deleteAdventureThing);
        commandMap.put(6, CommandUtil::carryAdventureThing);
        commandMap.put(7, CommandUtil::useBottle);
    }

    public static void addAdventure(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        String advName = array.get(2);
        Adventure newAdv = new Adventure(advId, advName);
        adventures.put(advId, newAdv);
    }

    public static void addAdventureBottle(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int bottleId = Integer.parseInt(array.get(2));
        String bottleName = array.get(3);
        int capacity = Integer.parseInt(array.get(4));
        String bottleType = array.get(5);
        int bottleCe = Integer.parseInt(array.get(6));
        adventures.get(advId)
                .addBottle(bottleId, bottleName, capacity, bottleType, bottleCe);
    }

    public static void addAdventureEquipment(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int equipmentId = Integer.parseInt(array.get(2));
        String equipmentName = array.get(3);
        int durability = Integer.parseInt(array.get(4));
        int equipmentCe = Integer.parseInt(array.get(5));
        adventures.get(advId)
                .addEquipment(equipmentId, equipmentName, durability, equipmentCe);
    }

    public static void increaseDurability(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int equipmentId = Integer.parseInt(array.get(2));
        Equipment equipment = (Equipment) adventures.get(advId)
                .getThings()
                .get(equipmentId);
        equipment.increaseDurability();
    }

    public static void deleteAdventureThing(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int thingId = Integer.parseInt(array.get(2));
        if (adventures.get(advId).getThings().get(thingId) instanceof Equipment) {
            adventures.get(advId)
                    .deleteEquipment(thingId);
        } else if (adventures.get(advId).getThings().get(thingId) instanceof Bottle) {
            adventures.get(advId)
                    .deleteBottle(thingId);
        }
    }

    public static void carryAdventureThing(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int thingId = Integer.parseInt(array.get(2));
        adventures.get(advId)
                .carryThings(thingId);
    }

    public static void useBottle(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int bottleId = Integer.parseInt(array.get(2));
        adventures.get(advId)
                .useBottle(bottleId);
    }

    public static HashMap<Integer, Consumer<ArrayList<String>>> getCommandMap() {
        return commandMap;
    }

    public static HashMap<Integer, Adventure> getAdventures() { return adventures; }
}
