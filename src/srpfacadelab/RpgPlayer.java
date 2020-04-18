package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final IGameEngine gameEngine;

    private int health;

    private int maxHealth;

    private int armour;

    private Inventory inventory;

    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new Inventory();
        carryingCapacity = MAX_CARRYING_CAPACITY;
    }

    public void useItem(Item item) {
        ItemHandler.rpgUses(this, item);
    }

    public boolean pickUpItem(Item item) {
        return ItemHandler.rpgPicksUp(this, item);
    }

    private void calculateStats() {
        inventory.calculateStats(this);
    }

    private boolean checkIfItemExistsInInventory(Item item) {
        return inventory.checkExistance(this, item);
    }

    private int calculateInventoryWeight() {
        return inventory.calculateWeight();
    }

    public void takeDamage(int damage) {
        DamageTaker.takeDammage(this, damage);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    private void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    private void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
