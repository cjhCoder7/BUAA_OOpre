import org.junit.Test;
import static org.junit.Assert.*;

public class BladeTest {

    @Test
    public void increaseDurability() {
        Equipment equipment = new Blade(1, "equipment", 40, 1);
        equipment.increaseDurability();
        assertEquals(41, equipment.getDurability());
    }

    @Test
    public void decreaseDurability() {
        Equipment equipment = new Blade(1, "equipment", 40, 1);
        equipment.decreaseDurability();
        assertEquals(39, equipment.getDurability());
    }

    @Test
    public void getDurability() {
        Equipment equipment = new Blade(1, "equipment", 40, 1);
        assertEquals(40, equipment.getDurability());
    }

    @Test
    public void getId() {
        Equipment equipment = new Blade(1, "equipment", 40, 1);
        assertEquals(1, equipment.getId());
    }

    @Test
    public void getName() {
        Equipment equipment = new Blade(1, "equipment", 40, 1);
        assertEquals("equipment", equipment.getName());
    }

    @Test
    public void getCe() {
        Equipment equipment = new Blade(1, "equipment", 40, 1);
        assertEquals(1, equipment.getCe());
    }
}