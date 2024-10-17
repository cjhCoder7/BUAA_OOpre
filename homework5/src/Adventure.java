import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Adventure implements Commodity {
    private final int id;
    private final String name;
    private int hitPoint;
    private int atk;
    private int def;
    private final HashMap<Integer, Commodity> things;
    private final HashMap<Integer, Commodity> packages;
    private final HashMap<String, ArrayList<Fragment>> fragments;

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
                newBottle = new HpBottle(id, name, capacity, ce);
                things.put(id, newBottle);
                break;
            case "AtkBottle" :
                newBottle = new AtkBottle(id, name, capacity, ce);
                things.put(id, newBottle);
                break;
            case "DefBottle" :
                newBottle = new DefBottle(id, name, capacity, ce);
                things.put(id, newBottle);
                break;
            default: break;
        }
    }

    public void addEquipment(int id, String name, int durability, String type, int ce) {
        Equipment newEquipment;
        switch (type) {
            case "Sword" :
                newEquipment = new Sword(id, name, durability, ce);
                things.put(id, newEquipment);
                break;
            case "Axe" :
                newEquipment = new Axe(id, name, durability, ce);
                things.put(id, newEquipment);
                break;
            case "Blade" :
                newEquipment = new Blade(id, name, durability, ce);
                things.put(id, newEquipment);
                break;
            default: break;
        }

    }

    public void deleteBottle(int id) {
        Bottle tmpBottle = (Bottle) things.remove(id);
        packages.remove(id);
        if (tmpBottle instanceof HpBottle) {
            System.out.println("HpBottle" + " "
                    + tmpBottle.getName() + " "
                    + tmpBottle.getCapacity());
        }
        else if (tmpBottle instanceof AtkBottle) {
            System.out.println("AtkBottle" + " "
                    + tmpBottle.getName() + " "
                    + tmpBottle.getCapacity());
        }
        else if (tmpBottle instanceof DefBottle) {
            System.out.println("DefBottle" + " "
                    + tmpBottle.getName() + " "
                    + tmpBottle.getCapacity());
        }
    }

    public void deleteEquipment(int id) {
        Equipment tmpEquipment = (Equipment) things.remove(id);
        packages.remove(id);
        if (tmpEquipment instanceof Sword) {
            System.out.println("Sword" + " "
                    + tmpEquipment.getName() + " "
                    + tmpEquipment.getDurability());
        }
        else if (tmpEquipment instanceof Axe) {
            System.out.println("Axe" + " "
                    + tmpEquipment.getName() + " "
                    + tmpEquipment.getDurability());
        } else if (tmpEquipment instanceof Blade) {
            System.out.println("Blade" + " "
                    + tmpEquipment.getName() + " "
                    + tmpEquipment.getDurability());
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
                System.out.println(name + " " + hitPoint + " " + atk + " " + def);
            } else {
                if (tmpBottle instanceof HpBottle) {
                    hitPoint += tmpBottle.getCapacity();
                    tmpBottle.use();
                    System.out.println(name + " " + hitPoint + " " + atk + " " + def);
                }
                else if (tmpBottle instanceof AtkBottle) {
                    atk += tmpBottle.getCapacity() / 100 + tmpBottle.getCe();
                    tmpBottle.use();
                    System.out.println(name + " " + hitPoint + " " + atk + " " + def);
                }
                else if (tmpBottle instanceof DefBottle) {
                    def += tmpBottle.getCapacity() / 100 + tmpBottle.getCe();
                    tmpBottle.use();
                    System.out.println(name + " " + hitPoint + " " + atk + " " + def);
                }
            }
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
                HpBottle newBottle = new HpBottle(welfareId, name, 100, 0);
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

    public void attackAdventures(String name, ArrayList<Adventure> attacks) {
        int maxDef = 0;
        for (Adventure adventure : attacks) {
            if (adventure.getDef() > maxDef) {
                maxDef = adventure.getDef();
            }
        }
        for (Commodity thing : packages.values()) {
            if (thing.getName().equals(name) && thing instanceof Equipment) {
                Equipment equipment = (Equipment) thing;
                if (this.atk + equipment.getCe() > maxDef) {
                    for (Adventure adventure : attacks) {
                        adventure.attackedByAdventure(this, equipment);
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
            }
        }
        System.out.println("Adventurer" + " " + this.id + " " + "defeated");
    }

    public void attackedByAdventure(Adventure attackAdventure, Equipment equipment) {
        if (equipment instanceof Axe) {
            this.hitPoint = this.hitPoint / 10;
        } else if (equipment instanceof Sword) {
            this.hitPoint -= equipment.getCe() + attackAdventure.getAtk() - this.def;
        } else {
            this.hitPoint -= equipment.getCe() + attackAdventure.getAtk();
        }
        System.out.println(this.name + " " + this.hitPoint);
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
}
