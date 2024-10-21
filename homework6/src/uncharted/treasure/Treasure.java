package uncharted.treasure;

import adventurer.Adventure;

public interface Treasure {
    public void showInfo(); // 显示宝物信息的方法

    public void useBy(Adventure adv); // 让该冒险者获得这个宝物的加成
}
