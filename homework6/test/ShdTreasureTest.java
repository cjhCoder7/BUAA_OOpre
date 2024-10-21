import adventurer.Adventure;
import org.junit.Test;
import uncharted.treasure.ShdTreasure;

import static org.junit.Assert.*;

public class ShdTreasureTest {

    @Test
    public void showInfo() {
        ShdTreasure shd = new ShdTreasure();
        shd.showInfo();
    }

    @Test
    public void useBy() {
        ShdTreasure shd = new ShdTreasure();
        Adventure adventure = new Adventure(1, "adv");
        shd.useBy(adventure);
    }
}