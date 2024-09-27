import org.junit.Test;

import static org.junit.Assert.*;
public class AdventureTest {

    @Test
    public void addBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2",40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3",40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4",40, "DefBottle", 4);
        adventure.addBottle(5, "bottle5",40, "Bottle", 5);
        assertEquals("bottle2", adventure.getThings().get(2).getName());
        assertEquals("bottle3", adventure.getThings().get(3).getName());
        assertEquals("bottle4", adventure.getThings().get(4).getName());
    }

    @Test
    public void addEquipment() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addEquipment(2, "equipment2", 40, 2);
        assertEquals("equipment2", adventure.getThings().get(2).getName());
    }

    @Test
    public void deleteBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2",40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3",40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4",40, "DefBottle", 4);
        adventure.deleteBottle(2);
        assertNull(adventure.getThings().get(2));
        adventure.deleteBottle(3);
        assertNull(adventure.getThings().get(3));
        adventure.deleteBottle(4);
        assertNull(adventure.getThings().get(4));
    }

    @Test
    public void deleteEquipment() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addEquipment(2, "equipment2", 40, 2);
        adventure.deleteEquipment(2);
        assertNull(adventure.getThings().get(2));
    }

    @Test
    public void carryThings() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2", 40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3", 40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4", 40, "DefBottle", 4);
        adventure.carryThings(2);
        assertNotNull(adventure.getPackages().get(2));
    }

    @Test
    public void useBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2", 40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3", 40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4", 40, "DefBottle", 4);
        adventure.addBottle(5, "bottle5", 40, "HpBottle", 0);
        adventure.carryThings(2);
        adventure.carryThings(3);
        adventure.carryThings(4);
        adventure.useBottle(2);
        assertEquals(540, adventure.getHitPoint());
        adventure.useBottle(3);
        assertEquals(4, adventure.getAtk());
        adventure.useBottle(4);
        assertEquals(4, adventure.getDef());

        adventure.useBottle(5);

        adventure.useBottle(2);
        assertNull(adventure.getThings().get(2));
        assertNull(adventure.getPackages().get(2));
    }

    @Test
    public void getPackages() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertNotNull(adventure.getPackages());
    }

    @Test
    public void getThings() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertNotNull(adventure.getThings());
    }

    @Test
    public void getHitPoint() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(500, adventure.getHitPoint());
    }

    @Test
    public void getAtk() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(1, adventure.getAtk());
    }

    @Test
    public void getDef() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(0, adventure.getDef());
    }
    @Test
    public void getId() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(1, adventure.getId());
    }

    @Test
    public void getName() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals("adventure1", adventure.getName());
    }

    @Test
    public void getCe() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(1, adventure.getCe());
    }
}
