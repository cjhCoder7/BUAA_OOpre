package uncharted.treasure;

import uncharted.monster.Guard;

public class TreasureFactory {
    public static Treasure createTreasure(Guard guard) {
        switch (guard.getType()) {
            case "Shd":
                return new ShdTreasure();
            case "Stn":
                return new StnTreasure();
            case "Frz":
                return new FrzTreasure();
            case "Flm":
                return new FlmTreasure();
            case "Wnd":
                return new WndTreasure();
            default:
                throw new IllegalArgumentException("Unknown guard type");
        }
    }
}