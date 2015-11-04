/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import java.io.Serializable;

/**
 *
 * @author Don
 */
public class Store implements Serializable{
    private int foodq;
    private int energyq;
    private int smithoreq;
    private int crystiteq;
    private int muleq;
    private final int FOOD_PRICE = 30;
    private final int ENERGY_PRICE = 25;
    private final int SMITHORE_PRICE = 50;
    private final int CRYSTITE_PRICE = 100;
    private final int MULEF_PRICE = 125;
    private final int MULEE_PRICE = 150;
    private final int MULES_PRICE = 175;
    private final int MULEC_PRICE = 200;
    
    public Store() {
        foodq = 16;
        energyq = 16;
        smithoreq = 0;
        crystiteq = 0;
        muleq = 25;
    }
    
    public boolean buyFood(Player player) {
        if (foodq > 0 && player.funds > FOOD_PRICE) {
            foodq--;
            player.funds = player.funds - FOOD_PRICE;
            player.food++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean buyEnergy(Player player) {
        if (energyq > 0 && player.funds > ENERGY_PRICE) {
            energyq--;
            player.funds = player.funds - ENERGY_PRICE;
            player.energy++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean buySmithore(Player player) {
        if (smithoreq > 0 && player.funds > SMITHORE_PRICE) {
            smithoreq--;
            player.funds = player.funds - SMITHORE_PRICE;
            player.smithore++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean buyCrystite(Player player) {
        if (crystiteq > 0 && player.funds > CRYSTITE_PRICE) {
            crystiteq--;
            player.funds = player.funds - CRYSTITE_PRICE;
            player.crystite++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean buyMuleF(Player player) {
        if (muleq > 0 && player.funds > MULEF_PRICE) {
            muleq--;
            player.funds = player.funds - MULEF_PRICE;
            player.mulef++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean buyMuleE(Player player) {
        if (muleq > 0 && player.funds > MULEE_PRICE) {
            muleq--;
            player.funds = player.funds - MULEE_PRICE;
            player.mulee++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean buyMuleS(Player player) {
        if (muleq > 0 && player.funds > MULES_PRICE) {
            muleq--;
            player.funds = player.funds - MULES_PRICE;
            player.mules++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean sellFood(Player player) {
        if (player.food > 0) {
            foodq++;
            player.funds = player.funds + FOOD_PRICE;
            player.food--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean sellEnergy(Player player) {
        if (player.energy > 0) {
            energyq++;
            player.funds = player.funds + ENERGY_PRICE;
            player.energy--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean sellSmithore(Player player) {
        if (player.smithore > 0) {
            smithoreq++;
            player.funds = player.funds + SMITHORE_PRICE;
            player.smithore--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean sellCrystite(Player player) {
        if (player.crystite > 0) {
            crystiteq++;
            player.funds = player.funds + CRYSTITE_PRICE;
            player.crystite--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean sellMuleF(Player player) {
        if (player.mulef > 0) {
            muleq++;
            player.funds = player.funds + MULEF_PRICE;
            player.mulef--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean sellMuleE(Player player) {
        if (player.mulee > 0) {
            muleq++;
            player.funds = player.funds + MULEE_PRICE;
            player.mulee--;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean sellMuleS(Player player) {
        if (player.mules > 0) {
            muleq++;
            player.funds = player.funds + MULES_PRICE;
            player.mules--;
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Prices\nFood: 30\nEnergy: 25\nFood MULE: 125\nEnergy MULE: 125"
                + "\nSmithore MULE: 175";
    }
}
