package uncharted.treasure;

import adventurer.Adventure;

public class StnTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Stoneheart Amulet");
    }

    @Override
    public void useBy(Adventure adv) {
        adv.addAllDef(40);
    }
}