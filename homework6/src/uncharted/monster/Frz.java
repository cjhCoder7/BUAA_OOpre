package uncharted.monster;

import adventurer.Adventure;

public class Frz implements Guard {
    @Override
    public boolean fight(Adventure adv) {
        return adv.getComprehensiveCE() > 5000;
    }

    @Override
    public String getType() {
        return "Frz";
    }
}