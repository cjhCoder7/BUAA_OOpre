import java.util.HashMap;

public class Adventure implements Commodity {
    private final int id;
    private final String name;
    private int hitPoint;
    private int atk;
    private int def;
    private final HashMap<Integer, Commodity> things;
    private final HashMap<Integer, Commodity> packages;

    public Adventure(int id, String name) {
        this.id = id;
        this.name = name;
        this.hitPoint = 500;
        this.atk = 1;
        this.def = 0;
        this.things = new HashMap<>();
        this.packages = new HashMap<>();
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

    public void addEquipment(int id, String name, int durability, int ce) {
        Equipment newEquipment = new Equipment(id, name, durability, ce);
        things.put(id, newEquipment);
    }

    public void deleteBottle(int id) {
        Bottle tmpBottle = (Bottle) things.remove(id);
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
        System.out.println("Equipment" + " "
                + tmpEquipment.getName() + " "
                + tmpEquipment.getDurability());
    }

    public void carryThings(int id) {
        packages.put(id, things.get(id));
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

    public HashMap<Integer, Commodity> getPackages() { return packages; }

    public HashMap<Integer, Commodity> getThings() { return things; }

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
