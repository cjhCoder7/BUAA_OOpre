import adventurer.Adventure;
import org.junit.Test;
import uncharted.treasure.WndTreasure;

import static org.junit.Assert.*;

public class WndTreasureTest {

    @Test
    public void showInfo() {
        WndTreasure w = new WndTreasure();
        w.showInfo();
    }

    @Test
    public void useBy() {
        WndTreasure w = new WndTreasure();
        Adventure adventure = new Adventure(1, "adv");
        w.useBy(adventure);
    }
}