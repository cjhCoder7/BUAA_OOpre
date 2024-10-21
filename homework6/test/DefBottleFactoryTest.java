import adventurer.bottle.Bottle;
import adventurer.bottle.DefBottleFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefBottleFactoryTest {

    @Test
    public void createBottle() {
        DefBottleFactory factory = new DefBottleFactory();
        Bottle bottle = factory.createBottle(1, "bottle", 20, 10);
    }
}