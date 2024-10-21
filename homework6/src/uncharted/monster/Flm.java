package uncharted.monster;

import adventurer.Adventure;

public class Flm implements Guard {
    @Override
    public boolean fight(Adventure adv) {
        return adv.getComprehensiveCE() > 2000;
    }

    @Override
    public String getType() {
        return "Flm";
    }
}