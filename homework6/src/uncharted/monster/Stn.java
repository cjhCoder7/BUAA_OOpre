package uncharted.monster;

import adventurer.Adventure;

public class Stn implements Guard {
    @Override
    public boolean fight(Adventure adv) {
        return adv.getComprehensiveCE() > 3000;
    }

    @Override
    public String getType() {
        return "Stn";
    }
}
