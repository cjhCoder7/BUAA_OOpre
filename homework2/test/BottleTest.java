import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void getName() {
        Bottle bottle = new Bottle(1, "bottle", 10);
        assertEquals("bottle", bottle.getName());
    }

    @Test
    public void getCapacity() {
        Bottle bottle = new Bottle(1, "bottle", 10);
        assertEquals(10, bottle.getCapacity());
    }
}