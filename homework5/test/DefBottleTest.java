import org.junit.Test;

import static org.junit.Assert.*;

public class DefBottleTest {
    @Test
    public void use() {
        Bottle bottle = new DefBottle(1, "bottle1",40,1);
        bottle.use();
        assertTrue(bottle.getIsUsed());
    }

    @Test
    public void fill() {
        Bottle bottle = new DefBottle(1, "atkBottle", 20, 0);
        bottle.fill();
        assertFalse(bottle.getIsUsed());
    }

    @Test
    public void getId() {
        Bottle bottle = new DefBottle(1, "bottle1",40,1);
        assertEquals(1,bottle.getId());
    }

    @Test
    public void getName() {
        Bottle bottle = new DefBottle(1, "bottle1",40,1);
        assertEquals("bottle1",bottle.getName());
    }

    @Test
    public void getCe() {
        Bottle bottle = new DefBottle(1, "bottle1",40,1);
        assertEquals(1,bottle.getCe());
    }

    @Test
    public void getCapacity() {
        Bottle bottle = new DefBottle(1, "bottle1",40,1);
        assertEquals(40,bottle.getCapacity());
    }

    @Test
    public void getIsUsed() {
        Bottle bottle = new DefBottle(1, "bottle1",40,1);
        assertFalse(bottle.getIsUsed());
    }
}