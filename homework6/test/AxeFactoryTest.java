import adventurer.equipment.AxeFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeFactoryTest {

    @Test
    public void createEquipment() {
        AxeFactory axeFactory = new AxeFactory();
        axeFactory.createEquipment(1,"a",153,15);
    }
}