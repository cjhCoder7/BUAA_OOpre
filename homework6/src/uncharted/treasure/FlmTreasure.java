package uncharted.treasure;

import adventurer.Adventure;

public class FlmTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Flamebrand Sword");
    }

    @Override
    public void useBy(Adventure adv) {
        adv.addAllAtk(40);
    }
}