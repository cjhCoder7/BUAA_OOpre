import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class AdventureTest {

    @Test
    public void addBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        HashMap<Integer, Bottle> bottles1 = adventure.getBottles();
        assertEquals(0, bottles1.size());
        adventure.addBottle(11, "bottle2", 10);
        HashMap<Integer, Bottle> bottles2 = adventure.getBottles();
        assertEquals(1, bottles2.size());
    }

    @Test
    public void addEquipment() {
        Adventure adventure = new Adventure(1, "adventure1");
        HashMap<Integer, Equipment> equipments = adventure.getEquipments();
        assertEquals(0, equipments.size());
        adventure.addEquipment(11, "equipment2", 10);
        HashMap<Integer, Equipment> equipments2 = adventure.getEquipments();
        assertEquals(1, equipments2.size());
    }

    @Test
    public void deleteBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(11, "bottle2", 10);
        adventure.addBottle(12, "bottle3", 10);
        HashMap<Integer, Bottle> bottles = adventure.getBottles();
        assertEquals(2, bottles.size());
        adventure.deleteBottle(12);
        HashMap<Integer, Bottle> bottles2 = adventure.getBottles();
        assertEquals(1, bottles2.size());
        assertNull(bottles2.get(12));
    }

    @Test
    public void deleteEquipment() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addEquipment(11, "equipment2", 10);
        adventure.addEquipment(12, "equipment3", 10);
        HashMap<Integer, Equipment> equipments = adventure.getEquipments();
        assertEquals(2, equipments.size());
        adventure.deleteEquipment(12);
        HashMap<Integer, Equipment> equipments2 = adventure.getEquipments();
        assertEquals(1, equipments2.size());
        assertNull(equipments2.get(12));
    }

    @Test
    public void getBottles() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(11, "bottle2", 10);
        adventure.addBottle(12, "bottle3", 10);
        HashMap<Integer, Bottle> bottles = adventure.getBottles();
        assertEquals(bottles.size(), 2);
        assertEquals("bottle2", bottles.get(11).getName());
        assertEquals("bottle3", bottles.get(12).getName());
    }

    @Test
    public void getEquipments() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addEquipment(11, "equipment2", 10);
        adventure.addEquipment(12, "equipment3", 10);
        HashMap<Integer, Equipment> equipments = adventure.getEquipments();
        assertEquals(equipments.size(), 2);
        assertEquals("equipment2", equipments.get(11).getName());
        assertEquals("equipment3", equipments.get(12).getName());
    }
}