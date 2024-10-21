import adventurer.equipment.SwordFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordFactoryTest {

    @Test
    public void createEquipment() {
        SwordFactory factory = new SwordFactory();
        factory.createEquipment(1, "a", 1, 5);
    }
}