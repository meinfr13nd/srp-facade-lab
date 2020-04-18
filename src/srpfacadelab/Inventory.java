package srpfacadelab;

import java.util.List;
import java.util.ArrayList;

public class Inventory {

    private List<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<Item>();
    }

    public void calculateStats(RpgPlayer player) {
        int armor = 0;
        for (Item i: inventory) {
            armour += i.getArmour();
        }
        player.setArmor(armor);
    }

    public boolean checkExistance(RpgPlayer play, Item item) {
        for (Item i: inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public int calculateWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

}