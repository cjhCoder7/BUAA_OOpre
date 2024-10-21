import adventurer.Adventure;
import org.junit.Test;
import uncharted.treasure.FrzTreasure;

import static org.junit.Assert.*;

public class FrzTreasureTest {

    @Test
    public void showInfo() {
        FrzTreasure frzTreasure = new FrzTreasure();
        frzTreasure.showInfo();
    }

    @Test
    public void useBy() {
        FrzTreasure frzTreasure = new FrzTreasure();
        Adventure adventure = new Adventure(1, "adv");
        frzTreasure.useBy(adventure);
    }
}