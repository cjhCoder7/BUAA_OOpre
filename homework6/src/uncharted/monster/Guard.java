package uncharted.monster;

import adventurer.Adventure;

public interface Guard {
    public boolean fight(Adventure adv); // 守门怪物与冒险者战斗，返回战斗结果

    public String getType(); // 返回守门怪物的类型
}
