import adventurer.equipment.Equipment;
import adventurer.equipment.Sword;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwordTest {

    @Test
    public void increaseDurability() {
        Equipment equipment = new Sword(1, "adventurer/equipment", 40, 1);
        equipment.increaseDurability();
        assertEquals(41, equipment.getDurability());
    }

    @Test
    public void decreaseDurability() {
        Equipment equipment = new Sword(1, "adventurer/equipment", 40, 1);
        equipment.decreaseDurability();
        assertEquals(39, equipment.getDurability());
    }

    @Test
    public void getDurability() {
        Equipment equipment = new Sword(1, "adventurer/equipment", 40, 1);
        assertEquals(40, equipment.getDurability());
    }

    @Test
    public void getId() {
        Equipment equipment = new Sword(1, "adventurer/equipment", 40, 1);
        assertEquals(1, equipment.getId());
    }

    @Test
    public void getName() {
        Equipment equipment = new Sword(1, "adventurer/equipment", 40, 1);
        assertEquals("adventurer/equipment", equipment.getName());
    }

    @Test
    public void getCe() {
        Equipment equipment = new Sword(1, "adventurer/equipment", 40, 1);
        assertEquals(1, equipment.getCe());
    }
}