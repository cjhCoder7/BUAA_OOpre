import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    private static final HashMap<Integer, Adventure> adventures = new HashMap<>();
    private static final ArrayList<ArrayList<String>> inputInfo =  new ArrayList<>();
    private static final HashMap<Integer, Consumer<ArrayList<String>>> commandMap = new HashMap<>();

    public static void main(String[] args) {
        initCommandMap();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
        }
        for (ArrayList<String> strings : inputInfo) {
            int command = Integer.parseInt(strings.get(0));
            commandMap.get(command).accept(strings);
        }
    }

    public static void initCommandMap() {
        commandMap.put(1, Main::addAdventure);
        commandMap.put(2, Main::addAdventureBottle);
        commandMap.put(3, Main::addAdventureEquipment);
        commandMap.put(4, Main::increaseDurability);
        commandMap.put(5, Main::deleteAdventureBottle);
        commandMap.put(6, Main::deleteAdventureEquipment);
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
        adventures.get(advId)
                .addBottle(bottleId, bottleName, capacity);
    }

    public static void addAdventureEquipment(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int equipmentId = Integer.parseInt(array.get(2));
        String equipmentName = array.get(3);
        int durability = Integer.parseInt(array.get(4));
        adventures.get(advId)
                .addEquipment(equipmentId, equipmentName, durability);
    }

    public static void increaseDurability(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int equipmentId = Integer.parseInt(array.get(2));
        adventures.get(advId).getEquipments().get(equipmentId).increaseDurability();
    }

    public static void deleteAdventureBottle(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int bottleId = Integer.parseInt(array.get(2));
        adventures.get(advId).deleteBottle(bottleId);
    }

    public static void deleteAdventureEquipment(ArrayList<String> array) {
        int advId = Integer.parseInt(array.get(1));
        int equipmentId = Integer.parseInt(array.get(2));
        adventures.get(advId).deleteEquipment(equipmentId);
    }
}
