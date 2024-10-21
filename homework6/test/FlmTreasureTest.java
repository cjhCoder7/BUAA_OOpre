import adventurer.Adventure;
import org.junit.Test;
import uncharted.treasure.FlmTreasure;

import static org.junit.Assert.*;

public class FlmTreasureTest {

    @Test
    public void showInfo() {
        FlmTreasure flmTreasure = new FlmTreasure();
        flmTreasure.showInfo();
    }

    @Test
    public void useBy() {
        FlmTreasure flmTreasure = new FlmTreasure();
        Adventure adventure = new Adventure(1, "adv");
        flmTreasure.useBy(adventure);
    }
}