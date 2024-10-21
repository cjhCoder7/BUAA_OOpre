package uncharted.treasure;

import adventurer.Adventure;

public class ShdTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Cloak of Shadows");
    }

    @Override
    public void useBy(Adventure adv) {
        adv.addAllDef(40);
    }
}
