package uncharted.treasure;

import adventurer.Adventure;

public class FrzTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Frostbite Staff");
    }

    @Override
    public void useBy(Adventure adv) {
        adv.addAllAtk(50);
    }
}