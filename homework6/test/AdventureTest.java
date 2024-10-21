import adventurer.Adventure;
import adventurer.bottle.Bottle;
import adventurer.equipment.Equipment;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class AdventureTest {

    @Test
    public void addBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2",40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3",40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4",40, "DefBottle", 4);
        adventure.addBottle(5, "bottle5",40, "Bottle", 5);
        assertEquals("bottle2", adventure.getThings().get(2).getName());
        assertEquals("bottle3", adventure.getThings().get(3).getName());
        assertEquals("bottle4", adventure.getThings().get(4).getName());
    }

    @Test
    public void addEquipment() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addEquipment(2, "equipment2", 40, "Axe", 2);
        adventure.addEquipment(3, "equipment3", 40, "Sword", 2);
        adventure.addEquipment(4, "equipment4", 40, "Blade", 2);
        assertEquals("equipment2", adventure.getThings().get(2).getName());
        assertEquals("equipment3", adventure.getThings().get(3).getName());
        assertEquals("equipment4", adventure.getThings().get(4).getName());
    }

    @Test
    public void deleteBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2",40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3",40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4",40, "DefBottle", 4);
        adventure.deleteBottle(2);
        assertNull(adventure.getThings().get(2));
        adventure.deleteBottle(3);
        assertNull(adventure.getThings().get(3));
        adventure.deleteBottle(4);
        assertNull(adventure.getThings().get(4));
    }

    @Test
    public void deleteEquipment() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addEquipment(2, "equipment2", 40, "Axe", 2);
        adventure.addEquipment(3, "equipment3", 40, "Sword", 2);
        adventure.addEquipment(4, "equipment4", 40, "Blade", 2);
        adventure.deleteEquipment(2);
        assertNull(adventure.getThings().get(2));
        adventure.deleteEquipment(3);
        assertNull(adventure.getThings().get(3));
        adventure.deleteEquipment(4);
        assertNull(adventure.getThings().get(4));
    }

    @Test
    public void carryThings() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2", 40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3", 40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4", 40, "DefBottle", 4);
        adventure.addEquipment(5, "equipment2", 40, "Axe", 2);
        adventure.addEquipment(6, "equipment2", 40, "Sword", 2);
        adventure.addEquipment(7, "equipment4", 40, "Blade", 2);
        adventure.carryThings(2);
        adventure.carryThings(5);
        adventure.carryThings(6);
        assertNotNull(adventure.getPackages().get(2));
        assertNotNull(adventure.getPackages().get(6));
        assertNull(adventure.getPackages().get(5));
    }

    @Test
    public void useBottle() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addBottle(2, "bottle2", 40, "HpBottle", 0);
        adventure.addBottle(3, "bottle3", 40, "AtkBottle", 3);
        adventure.addBottle(4, "bottle4", 40, "DefBottle", 4);
        adventure.addBottle(5, "bottle5", 40, "HpBottle", 0);
        adventure.carryThings(2);
        adventure.carryThings(3);
        adventure.carryThings(4);
        adventure.useBottle(2);
        assertEquals(540, adventure.getHitPoint());
        adventure.useBottle(3);
        assertEquals(4, adventure.getAtk());
        adventure.useBottle(4);
        assertEquals(4, adventure.getDef());

        adventure.useBottle(5);

        adventure.useBottle(2);
        assertNull(adventure.getThings().get(2));
        assertNull(adventure.getPackages().get(2));
    }

    @Test
    public void addFragment() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addFragment(2, "fragment2");
        adventure.addFragment(3, "fragment2");
        adventure.addFragment(4, "fragment3");
        assertEquals("fragment2", adventure.getFragments().get("fragment2").get(0).getName());
        assertEquals("fragment2", adventure.getFragments().get("fragment2").get(1).getName());
    }

    @Test
    public void exchangeWelfare() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addFragment(2, "fragment2");
        adventure.addFragment(3, "fragment2");
        adventure.addFragment(4, "fragment2");
        adventure.addFragment(5, "fragment2");
        adventure.addFragment(6, "fragment2");
        adventure.addFragment(7, "fragment2");
        adventure.exchangeWelfare("fragment2", 123);
        assertEquals(1, adventure.getFragments().get("fragment2").size());

        adventure.addBottle(1234, "bottle2", 100, "HpBottle", 0);
        adventure.addEquipment(12345, "equipment2", 40, "Sword", 3);
        ((Bottle)adventure.getThings().get(1234)).use();

        adventure.addFragment(8, "fragment2");
        adventure.addFragment(9, "fragment2");
        adventure.addFragment(10, "fragment2");
        adventure.addFragment(11, "fragment2");
        adventure.addFragment(12, "fragment2");
        adventure.addFragment(13, "fragment2");
        adventure.addFragment(14, "fragment2");
        adventure.addFragment(15, "fragment2");
        adventure.addFragment(16, "fragment2");
        adventure.addFragment(17, "fragment2");
        adventure.exchangeWelfare("fragment2", 1234);
        adventure.exchangeWelfare("fragment2", 12345);
        adventure.exchangeWelfare("fragment2", 12345);
    }

    @Test
    public void attackAdventures() {
        Adventure adventure = new Adventure(1, "adventure1");
        Adventure adventure2 = new Adventure(2, "adventure2");
        Adventure adventure3 = new Adventure(3, "adventure3");

        adventure.addEquipment(123, "sword", 40, "Sword", 10);
        adventure.addEquipment(124, "axe", 40, "Axe", 10);
        adventure.addEquipment(125, "blade", 40, "Blade", 10);

        adventure.carryThings(123);
        adventure.carryThings(124);
        adventure.carryThings(125);

        ArrayList<Adventure> attacks = new ArrayList<>();
        attacks.add(adventure2);
        attacks.add(adventure3);
        adventure.attackAdventures("sword", attacks, "chain");
        adventure.attackAdventures("axe", attacks, "chain");
        adventure.attackAdventures("blade", attacks, "normal");

        ArrayList<Adventure> attacks2 = new ArrayList<>();
        attacks2.add(adventure);
        attacks2.add(adventure3);
        adventure2.attackAdventures("sword2", attacks2, "chain");
        adventure2.addEquipment(1234, "sword2", 40, "Sword", 10);
        adventure2.attackAdventures("sword2", attacks2, "chain");
    }

    @Test
    public void attackedByAdventure() {
        Adventure adventure = new Adventure(1, "adventure1");
        Adventure adventure2 = new Adventure(2, "adventure2");

        adventure.addEquipment(123, "sword", 40, "Sword", 10);
        adventure.addEquipment(124, "axe", 40, "Axe", 10);
        adventure.addEquipment(125, "blade", 40, "Blade", 10);

        adventure.carryThings(123);
        adventure.carryThings(124);
        adventure.carryThings(125);

        adventure2.attackedByAdventure(adventure, (Equipment) adventure.getPackages().get(123), "normal");
        adventure2.attackedByAdventure(adventure, (Equipment) adventure.getPackages().get(124), "chain");
        adventure2.attackedByAdventure(adventure, (Equipment) adventure.getPackages().get(125), "normal");
    }

    @Test
    public void getPackages() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertNotNull(adventure.getPackages());
    }

    @Test
    public void getThings() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertNotNull(adventure.getThings());
    }

    @Test
    public void getFragments() {
        Adventure adventure = new Adventure(1, "adventure1");
        adventure.addFragment(2, "fragment2");
        adventure.addFragment(3, "fragment2");
        adventure.addFragment(4, "fragment2");
        adventure.addFragment(5, "fragment2");
        adventure.addFragment(6, "fragment2");
        assertNotNull(adventure.getFragments());
    }

    @Test
    public void getHitPoint() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(500, adventure.getHitPoint());
    }

    @Test
    public void getAtk() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(1, adventure.getAtk());
    }

    @Test
    public void getDef() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(0, adventure.getDef());
    }
    @Test
    public void getId() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(1, adventure.getId());
    }

    @Test
    public void getName() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals("adventure1", adventure.getName());
    }

    @Test
    public void getCe() {
        Adventure adventure = new Adventure(1, "adventure1");
        assertEquals(1, adventure.getCe());
    }

    @Test
    public void enterUncharted() {
    }

    @Test
    public void findAttacks() {
    }

    @Test
    public void hireAdventure() {
    }

    @Test
    public void getComprehensiveCE() {
    }

    @Test
    public void addDef() {
    }

    @Test
    public void addAtk() {
    }

    @Test
    public void addAllDef() {
    }

    @Test
    public void addAllAtk() {
    }

    @Test
    public void watch() {
    }

    @Test
    public void registerObserver() {
    }

    @Test
    public void notifyObservers() {
    }
}
