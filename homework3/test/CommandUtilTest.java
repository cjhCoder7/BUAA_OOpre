import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CommandUtilTest {
    @Before
    public void setUp(){
        CommandUtil.initCommandUtil();
        ArrayList<String> array = new ArrayList<>(Arrays.asList("1", "1", "adventure1"));
        CommandUtil.addAdventure(array);
    }

    @Test
    public void initCommandUtil() {
        CommandUtil.initCommandUtil();
        assertNotNull(CommandUtil.getCommandMap().get(1));
    }

    @Test
    public void addAdventure() {
        ArrayList<String> array2 = new ArrayList<>(Arrays.asList("1", "2", "adventure2"));
        CommandUtil.addAdventure(array2);
        assertNotNull(CommandUtil.getAdventures().get(2));
    }

    @Test
    public void addAdventureBottle() {
        ArrayList<String> array2 = new ArrayList<>(Arrays.asList("2", "1", "2", "bottle2", "40", "HpBottle", "0"));
        CommandUtil.addAdventureBottle(array2);
        assertNotNull(CommandUtil.getAdventures().get(1).getThings().get(2));

        ArrayList<String> array3 = new ArrayList<>(Arrays.asList("2", "1", "3", "bottle3", "40", "AtkBottle", "10"));
        CommandUtil.addAdventureBottle(array3);
        assertNotNull(CommandUtil.getAdventures().get(1).getThings().get(3));

        ArrayList<String> array4 = new ArrayList<>(Arrays.asList("2", "1", "4", "bottle4", "40", "DefBottle", "10"));
        CommandUtil.addAdventureBottle(array4);
        assertNotNull(CommandUtil.getAdventures().get(1).getThings().get(4));
    }

    @Test
    public void addAdventureEquipment() {
        ArrayList<String> array5 = new ArrayList<>(Arrays.asList("3", "1", "5", "equipment5", "0", "1"));
        CommandUtil.addAdventureEquipment(array5);
        assertNotNull(CommandUtil.getAdventures().get(1).getThings().get(5));
    }

    @Test
    public void increaseDurability() {
        ArrayList<String> array5 = new ArrayList<>(Arrays.asList("3", "1", "5", "equipment5", "0", "1"));
        CommandUtil.addAdventureEquipment(array5);

        ArrayList<String> array = new ArrayList<>(Arrays.asList("4", "1", "5"));
        CommandUtil.increaseDurability(array);

        Equipment equipment = (Equipment) CommandUtil.getAdventures().get(1).getThings().get(5);
        assertEquals(1, equipment.getDurability());
    }

    @Test
    public void deleteAdventureThing() {
        ArrayList<String> array2 = new ArrayList<>(Arrays.asList("2", "1", "2", "bottle2", "40", "HpBottle", "0"));
        CommandUtil.addAdventureBottle(array2);
        ArrayList<String> array5 = new ArrayList<>(Arrays.asList("3", "1", "5", "equipment5", "0", "1"));
        CommandUtil.addAdventureEquipment(array5);

        ArrayList<String> array = new ArrayList<>(Arrays.asList("5", "1", "2"));
        CommandUtil.deleteAdventureThing(array);
        assertNull(CommandUtil.getAdventures().get(1).getThings().get(2));

        array = new ArrayList<>(Arrays.asList("5", "1", "5"));
        CommandUtil.deleteAdventureThing(array);
        assertNull(CommandUtil.getAdventures().get(1).getThings().get(5));
    }

    @Test
    public void carryAdventureThing() {
        ArrayList<String> array2 = new ArrayList<>(Arrays.asList("2", "1", "2", "bottle2", "40", "HpBottle", "0"));
        CommandUtil.addAdventureBottle(array2);

        ArrayList<String> array = new ArrayList<>(Arrays.asList("6", "1", "2"));
        CommandUtil.carryAdventureThing(array);
        assertNotNull(CommandUtil.getAdventures().get(1).getPackages().get(2));
    }

    @Test
    public void useBottle() {
        ArrayList<String> array2 = new ArrayList<>(Arrays.asList("2", "1", "2", "bottle2", "40", "HpBottle", "0"));
        CommandUtil.addAdventureBottle(array2);
        ArrayList<String> array5 = new ArrayList<>(Arrays.asList("6", "1", "2"));
        CommandUtil.carryAdventureThing(array5);

        ArrayList<String> array3 = new ArrayList<>(Arrays.asList("2", "1", "3", "bottle3", "40", "AtkBottle", "10"));
        CommandUtil.addAdventureBottle(array3);
        array5 = new ArrayList<>(Arrays.asList("6", "1", "3"));
        CommandUtil.carryAdventureThing(array5);

        ArrayList<String> array4 = new ArrayList<>(Arrays.asList("2", "1", "4", "bottle4", "40", "DefBottle", "10"));
        CommandUtil.addAdventureBottle(array4);
        array5 = new ArrayList<>(Arrays.asList("6", "1", "4"));
        CommandUtil.carryAdventureThing(array5);

        ArrayList<String> array6 = new ArrayList<>(Arrays.asList("2", "1", "6", "bottle6", "40", "DefBottle", "10"));
        CommandUtil.addAdventureBottle(array6);

        ArrayList<String> array = new ArrayList<>(Arrays.asList("7", "1", "2"));
        CommandUtil.useBottle(array);
        array = new ArrayList<>(Arrays.asList("7", "1", "3"));
        CommandUtil.useBottle(array);
        array = new ArrayList<>(Arrays.asList("7", "1", "4"));
        CommandUtil.useBottle(array);
        array = new ArrayList<>(Arrays.asList("7", "1", "6"));
        CommandUtil.useBottle(array);
    }

    @Test
    public void getCommandMap() {
        assertNotNull(CommandUtil.getCommandMap());
    }

    @Test
    public void getAdventures() {
        assertNotNull(CommandUtil.getAdventures());
    }
}