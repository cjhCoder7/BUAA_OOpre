package adventurer;

import adventurer.bottle.AtkBottleFactory;
import adventurer.bottle.Bottle;
import adventurer.bottle.DefBottleFactory;
import adventurer.bottle.HpBottleFactory;
import adventurer.equipment.AxeFactory;
import adventurer.equipment.BladeFactory;
import adventurer.equipment.Equipment;
import adventurer.equipment.SwordFactory;
import uncharted.monster.Flm;
import uncharted.monster.Guard;
import uncharted.monster.Shd;
import uncharted.monster.Stn;
import uncharted.monster.Wnd;
import uncharted.monster.Frz;
import uncharted.treasure.Treasure;
import uncharted.treasure.TreasureFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Adventure implements Commodity, Watcher, Observed {
    private final int id;
    private final String name;
    private int hitPoint;
    private int atk;
    private int def;
    private final HashMap<Integer, Commodity> things;
    private final HashMap<Integer, Commodity> packages;
    private final HashMap<String, ArrayList<Fragment>> fragments;
    private final HashMap<Watcher, Integer> watchers = new HashMap<>();

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.hitPoint = 500;
        this.atk = 1;
        this.def = 0;
        this.things = new HashMap<>();
        this.packages = new HashMap<>();
        this.fragments = new HashMap<>();
    }

    public void addBottle(int id, String name, int capacity, String type, int ce) {
        Bottle newBottle;
        switch (type) {
            case "HpBottle" :
                newBottle = new HpBottleFactory().createBottle(id, name, capacity, ce);
                things.put(id, newBottle);
                break;
            case "AtkBottle" :
                newBottle = new AtkBottleFactory().createBottle(id, name, capacity, ce);
                things.put(id, newBottle);
                break;
            case "DefBottle" :
                newBottle = new DefBottleFactory().createBottle(id, name, capacity, ce);
                things.put(id, newBottle);
                break;
            default: break;
        }
    }

    public void addEquipment(int id, String name, int durability, String type, int ce) {
        Equipment newEquipment;
        switch (type) {
            case "Sword" :
                newEquipment = new SwordFactory().createEquipment(id, name, durability, ce);
                things.put(id, newEquipment);
                break;
            case "Axe" :
                newEquipment = new AxeFactory().createEquipment(id, name, durability, ce);
                things.put(id, newEquipment);
                break;
            case "Blade" :
                newEquipment = new BladeFactory().createEquipment(id, name, durability, ce);
                things.put(id, newEquipment);
                break;
            default: break;
        }

    }

    public void deleteBottle(int id) {
        Bottle tmpBottle = (Bottle) things.remove(id);
        String type = tmpBottle.getType();
        packages.remove(id);
        switch (type) {
            case "HpBottle" :
                System.out.println("HpBottle" + " "
                        + tmpBottle.getName() + " "
                        + tmpBottle.getCapacity());
                break;
            case "AtkBottle" :
                System.out.println("AtkBottle" + " "
                        + tmpBottle.getName() + " "
                        + tmpBottle.getCapacity());
                break;
            case "DefBottle" :
                System.out.println("DefBottle" + " "
                        + tmpBottle.getName() + " "
                        + tmpBottle.getCapacity());
                break;
            default: break;
        }
    }

    public void deleteEquipment(int id) {
        Equipment tmpEquipment = (Equipment) things.remove(id);
        String type = tmpEquipment.getType();
        packages.remove(id);
        switch (type) {
            case "Sword" :
                System.out.println("Sword" + " "
                        + tmpEquipment.getName() + " "
                        + tmpEquipment.getDurability());
                break;
            case "Axe" :
                System.out.println("Axe" + " "
                        + tmpEquipment.getName() + " "
                        + tmpEquipment.getDurability());
                break;
            case "Blade" :
                System.out.println("Blade" + " "
                        + tmpEquipment.getName() + " "
                        + tmpEquipment.getDurability());
                break;
            default: break;
        }
    }

    public void carryThings(int id) {
        Commodity newThing = things.get(id);
        if (newThing instanceof Bottle) {
            int bottleCount = 0;
            for (Commodity thing : packages.values()) {
                if (thing instanceof Bottle && thing.getName().equals(newThing.getName())) {
                    bottleCount++;
                }
            }
            int maxBottles = (atk + def) / 5 + 1;
            if (bottleCount < maxBottles) {
                packages.put(id, newThing);
            }
        } else {
            Iterator<Map.Entry<Integer, Commodity>> iter = packages.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, Commodity> entry = iter.next();
                Commodity thing = entry.getValue();
                if (thing instanceof Equipment && thing.getName().equals(newThing.getName())) {
                    iter.remove();
                }
            }
            packages.put(id, newThing);
        }
    }

    public void useBottle(int id) {
        if (packages.containsKey(id)) {
            Bottle tmpBottle = (Bottle) packages.get(id);
            if (tmpBottle.getIsUsed()) {
                things.remove(id);
                packages.remove(id);
            } else {
                String type = tmpBottle.getType();
                switch (type) {
                    case "HpBottle" :
                        hitPoint += tmpBottle.getCapacity();
                        tmpBottle.use();
                        break;
                    case "AtkBottle" :
                        atk += tmpBottle.getCapacity() / 100 + tmpBottle.getCe();
                        tmpBottle.use();
                        break;
                    case "DefBottle" :
                        def += tmpBottle.getCapacity() / 100 + tmpBottle.getCe();
                        tmpBottle.use();
                        break;
                    default: break;
                }
            }
            System.out.println(name + " " + hitPoint + " " + atk + " " + def);
        } else {
            System.out.println(name + " fail to use " + things.get(id).getName());
        }
    }

    public void addFragment(int id, String name) {
        Fragment newFragment = new Fragment(id, name);
        if (fragments.containsKey(name)) {
            fragments.get(name).add(newFragment);
        } else {
            fragments.put(name, new ArrayList<>());
            fragments.get(name).add(newFragment);
        }
    }

    public void exchangeWelfare(String name, int welfareId) {
        if (fragments.get(name).size() >= 5) {
            if (things.get(welfareId) instanceof Bottle) {
                if (((Bottle) things.get(welfareId)).getIsUsed()) {
                    ((Bottle) things.get(welfareId)).fill();
                }
                System.out.println(things.get(welfareId).getName() + " " +
                        ((Bottle) things.get(welfareId)).getCapacity());
            } else if (things.get(welfareId) instanceof Equipment) {
                ((Equipment) things.get(welfareId)).increaseDurability();
                System.out.println(things.get(welfareId).getName() + " " +
                        ((Equipment) things.get(welfareId)).getDurability());
            } else {
                Bottle newBottle = new HpBottleFactory().createBottle(welfareId, name, 100, 0);
                things.put(welfareId, newBottle);
                System.out.println("Congratulations! HpBottle" + " " + name + " " +  "acquired");
            }
            int size = fragments.get(name).size();
            for (int i = 1; i < 6; i++) {
                fragments.get(name).remove(size - i);
            }
        } else {
            System.out.println(fragments.get(name).size() + ": Not enough fragments collected yet");
        }
    }

    public void attackAdventures(String name, ArrayList<Adventure> attacks, String type) {
        int maxDef1 = 0;
        for (Adventure adventure : attacks) {
            if (adventure.getDef() > maxDef1) {
                maxDef1 = adventure.getDef();
            }
        }
        HashSet<Adventure> totalAttacks = new HashSet<>();
        for (Adventure adventure : attacks) {
            int currentDepth = 1;
            totalAttacks.add(adventure);
            adventure.findAttacks(totalAttacks, currentDepth);
        }
        int maxDef2 = 0;
        for (Adventure adventure : totalAttacks) {
            if (adventure.getDef() > maxDef2) {
                maxDef2 = adventure.getDef();
            }
        }
        for (Commodity thing : packages.values()) {
            if (thing.getName().equals(name) && thing instanceof Equipment) {
                Equipment equipment = (Equipment) thing;
                switch (type) {
                    case "normal":
                        if (this.atk + equipment.getCe() > maxDef1) {
                            for (Adventure adventure : attacks) {
                                adventure.attackedByAdventure(this, equipment, type);
                            }
                            equipment.decreaseDurability();
                            if (equipment.getDurability() == 0) {
                                packages.remove(equipment.getId());
                                things.remove(equipment.getId());
                            }
                        } else {
                            System.out.println("Adventurer" + " " + this.id + " " + "defeated");
                        }
                        return;
                    case "chain":
                        if (this.atk + equipment.getCe() > maxDef2) {
                            int totalLoss = 0;
                            for (Adventure adventure : totalAttacks) {
                                totalLoss += adventure.attackedByAdventure(this, equipment, type);
                            }
                            System.out.println(totalLoss);
                            equipment.decreaseDurability();
                            if (equipment.getDurability() == 0) {
                                packages.remove(equipment.getId());
                                things.remove(equipment.getId());
                            }
                        } else {
                            System.out.println("Adventurer" + " " + this.id + " " + "defeated");
                        }
                        return;
                    default: return;
                }
            }
        }
        System.out.println("Adventurer" + " " + this.id + " " + "defeated");
    }

    public void enterUncharted() {
        Guard shd = new Shd();
        if (shd.fight(this)) {
            Treasure treasure = TreasureFactory.createTreasure(shd);
            treasure.showInfo();
            treasure.useBy(this);
        }
        Guard flm = new Flm();
        if (flm.fight(this)) {
            Treasure treasure = TreasureFactory.createTreasure(flm);
            treasure.showInfo();
            treasure.useBy(this);
        }
        Guard stn = new Stn();
        if (stn.fight(this)) {
            Treasure treasure = TreasureFactory.createTreasure(stn);
            treasure.showInfo();
            treasure.useBy(this);
        }
        Guard wnd = new Wnd();
        if (wnd.fight(this)) {
            Treasure treasure = TreasureFactory.createTreasure(wnd);
            treasure.showInfo();
            treasure.useBy(this);
        }
        Guard frz = new Frz();
        if (frz.fight(this)) {
            Treasure treasure = TreasureFactory.createTreasure(frz);
            treasure.showInfo();
            treasure.useBy(this);
        }
    }

    public int attackedByAdventure(Adventure attackAdventure, Equipment equipment, String type) {
        String equipmentType = equipment.getType();
        int before = this.hitPoint;
        int loss = 0;
        switch (equipmentType) {
            case "Axe":
                loss = this.hitPoint - this.hitPoint / 10;
                this.hitPoint = this.hitPoint / 10;
                break;
            case "Sword":
                loss = equipment.getCe() + attackAdventure.getAtk() - this.def;
                this.hitPoint -= loss;
                break;
            case "Blade":
                loss = equipment.getCe() + attackAdventure.getAtk();
                this.hitPoint -= loss;
                break;
            default: break;
        }
        switch (type) {
            case "normal":
                if (this.hitPoint <= before / 2) {
                    this.notifyObservers();
                }
                System.out.println(this.name + " " + this.hitPoint);
                return 0;
            case "chain":
                return loss;
            default: return 0;
        }
    }

    public void findAttacks(HashSet<Adventure> totalAttacks, int currentDepth) {
        if (currentDepth < 5) {
            watchers.keySet().forEach(key -> {
                totalAttacks.add((Adventure) key);
                ((Adventure) key).findAttacks(totalAttacks, currentDepth + 1);
            });
        }
    }

    public void hireAdventure(Adventure adventure) {
        this.registerObserver(adventure);
    }

    public int getComprehensiveCE() {
        int comprehensiveCE = 0;
        for (Watcher key : watchers.keySet()) {
            comprehensiveCE += ((Adventure) key).getCe();
        }
        comprehensiveCE += this.getCe();
        for (Commodity thing : packages.values()) {
            comprehensiveCE += thing.getCe();
        }
        return comprehensiveCE;
    }

    public void addDef(int num) {
        def += num;
    }

    public void addAtk(int num) {
        atk += num;
    }

    public void addAllDef(int num) {
        for (Watcher key : watchers.keySet()) {
            ((Adventure) key).addDef(num);
        }
        this.addDef(num);
    }

    public void addAllAtk(int num) {
        for (Watcher key : watchers.keySet()) {
            ((Adventure) key).addAtk(num);
        }
        this.addAtk(num);
    }

    public HashMap<Integer, Commodity> getPackages() { return packages; }

    public HashMap<Integer, Commodity> getThings() { return things; }

    public HashMap<String, ArrayList<Fragment>> getFragments() { return fragments; }

    public int getHitPoint() { return hitPoint; }

    public int getAtk() { return atk; }

    public int getDef() { return def; }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int getCe() { return atk + def; }

    @Override
    public void watch(Observed o) {
        Adventure a = (Adventure) o;
        Iterator<Map.Entry<Integer, Commodity>> iter = packages.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Commodity> entry = iter.next();
            Commodity commodity = entry.getValue();
            if (commodity instanceof Equipment) {
                Equipment e = (Equipment) commodity;
                iter.remove();
                things.remove(e.getId());
                a.addEquipment(e.getId(), e.getName(), e.getDurability(), e.getType(), e.getCe());
            }
        }
    }

    @Override
    public void registerObserver(Watcher w) {
        Integer helpCount = 0;
        watchers.put(w, helpCount);
    }

    @Override
    public void notifyObservers() {
        Iterator<Watcher> iterator = watchers.keySet().iterator();
        while (iterator.hasNext()) {
            Watcher key = iterator.next();
            key.watch(this);
            Integer helpCount = watchers.get(key);
            helpCount = helpCount + 1;
            if (helpCount > 3) {
                iterator.remove();  // 使用 Iterator 的 remove 方法来安全地删除元素
            } else {
                watchers.put(key, helpCount);  // 更新 `HashMap` 中的值
            }
        }
    }
}
