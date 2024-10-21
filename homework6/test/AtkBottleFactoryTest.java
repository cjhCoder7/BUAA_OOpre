import adventurer.bottle.AtkBottleFactory;
import adventurer.bottle.Bottle;
import org.junit.Test;

public class AtkBottleFactoryTest {

    @Test
    public void createBottle() {
        AtkBottleFactory factory = new AtkBottleFactory();
        Bottle bottle = factory.createBottle(1, "bottle", 20, 10);
    }
}