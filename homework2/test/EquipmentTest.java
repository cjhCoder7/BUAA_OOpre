import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void increaseDurability() {
        Equipment equipment = new Equipment(1, "equipment1", 10);
        equipment.increaseDurability();
        assertEquals(11, equipment.getDurability());
        equipment.increaseDurability();
        assertEquals(12, equipment.getDurability());
    }

    @Test
    public void getName() {
        Equipment equipment = new Equipment(1, "equipment1", 10);
        assertEquals("equipment1", equipment.getName());
    }

    @Test
    public void getDurability() {
        Equipment equipment = new Equipment(1, "equipment1", 10);
        assertEquals(10, equipment.getDurability());
    }
}