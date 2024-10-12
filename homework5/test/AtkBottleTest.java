import org.junit.Test;
import static org.junit.Assert.*;

public class AtkBottleTest {
    @Test
    public void use() {
        Bottle bottle = new AtkBottle(1, "atkBottle", 20, 0);
        bottle.use();
        assertTrue(bottle.getIsUsed());
    }

    @Test
    public void fill() {
        Bottle bottle = new AtkBottle(1, "atkBottle", 20, 0);
        bottle.fill();
        assertFalse(bottle.getIsUsed());
    }

    @Test
    public void getCapacity() {
        Bottle bottle = new AtkBottle(1, "atkBottle", 20, 0);
        assertEquals(20, bottle.getCapacity());
    }

    @Test
    public void getIsUsed() {
        Bottle bottle = new AtkBottle(1, "atkBottle", 20, 0);
        assertFalse(bottle.getIsUsed());
    }

    @Test
    public void getId() {
        Bottle bottle = new AtkBottle(1, "atkBottle", 20, 0);
        assertEquals(1, bottle.getId());
    }

    @Test
    public void getName() {
        Bottle bottle = new AtkBottle(1, "atkBottle", 20, 0);
        assertEquals("atkBottle", bottle.getName());
    }

    @Test
    public void getCe() {
        Bottle bottle = new AtkBottle(1, "atkBottle", 20, 0);
        assertEquals(0, bottle.getCe());
    }

}