package srpfacadelab;

import java.util.List;
import java.util.ArrayList;

public static class DamageTaker {
    public static void takeDamage(RpgPlayer player, int item) {
        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - armour;
        health -= damageToDeal;

        gameEngine.playSpecialEffect("lots_of_gore");
    }
}