import adventurer.bottle.Bottle;
import adventurer.bottle.HpBottleFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class HpBottleFactoryTest {

    @Test
    public void createBottle() {
        HpBottleFactory factory = new HpBottleFactory();
        Bottle bottle = factory.createBottle(1, "bottle", 20, 10);
    }
}