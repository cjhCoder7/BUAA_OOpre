import org.junit.Test;
import uncharted.monster.Flm;
import uncharted.monster.Guard;
import uncharted.treasure.Treasure;
import uncharted.treasure.TreasureFactory;

import static org.junit.Assert.*;

public class TreasureFactoryTest {

    @Test
    public void createTreasure() {
        Guard flm = new Flm();
        TreasureFactory.createTreasure(flm);
    }
}