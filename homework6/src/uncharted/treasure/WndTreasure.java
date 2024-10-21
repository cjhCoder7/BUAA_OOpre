package uncharted.treasure;

import adventurer.Adventure;

public class WndTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Windrunner Boots");
    }

    @Override
    public void useBy(Adventure adv) {
        adv.addAllDef(30);
    }
}