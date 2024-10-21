package uncharted.monster;

import adventurer.Adventure;

public class Shd implements Guard {
    @Override
    public boolean fight(Adventure adv) {
        return adv.getComprehensiveCE() > 1000;
    }

    @Override
    public String getType() {
        return "Shd";
    }
}