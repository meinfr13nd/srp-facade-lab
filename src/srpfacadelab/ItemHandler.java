package srpfacadelab;

import java.util.List;
import java.util.ArrayList;

public static class ItemHandler {
    public boolean rpgPicksUp(RpgPlayer player, Item item) {
        int weight = player.calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && player.checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            health += item.getHeal();

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            gameEngine.playSpecialEffect("cool_swirly_particles");

        if (item.isRare() && item.isUnique())
            gameEngine.playSpecialEffect("blue_swirly");

        inventory.add(item);

        player.calculateStats();
    }

    public void rpgUses(RpgPlayer player, Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }
}