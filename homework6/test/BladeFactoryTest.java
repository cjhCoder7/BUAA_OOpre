import adventurer.equipment.BladeFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class BladeFactoryTest {

    @Test
    public void createEquipment() {
        BladeFactory bladeFactory = new BladeFactory();
        bladeFactory.createEquipment(1,"a",153,15);
    }
}