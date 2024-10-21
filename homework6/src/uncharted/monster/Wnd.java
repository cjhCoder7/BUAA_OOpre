package uncharted.monster;

import adventurer.Adventure;

public class Wnd implements Guard {
    @Override
    public boolean fight(Adventure adv) {
        return adv.getComprehensiveCE() > 4000;
    }

    @Override
    public String getType() {
        return "Wnd";
    }
}