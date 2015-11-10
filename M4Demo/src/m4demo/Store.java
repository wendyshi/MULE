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
    private static final int FOOD_PRICE = 30;
    private static final int ENERGY_PRICE = 25;
    private static final int SMITHORE_PRICE = 50;
    private static final int CRYSTITE_PRICE = 100;
    private static final int MULEF_PRICE = 125;
    private static final int MULEE_PRICE = 150;
    private static final int MULES_PRICE = 175;
   // private static final  int MULEC_PRICE = 200;
    
    /**
     * constructor method
     * */
    public Store() {
        foodq = 16;
        energyq = 16;
        smithoreq = 0;
        crystiteq = 0;
        muleq = 25;
    }
    
    /**
     * method to check the player have enough funds to buy food or not
     * @param player current player
     * @return return true if the player have enough funds otherwise 
     * return false
     * */
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

    /**
     * method to check the player have enough funds to buy energy or not
     * @param player current player
     * @return return true if the player have enough funds otherwise 
     * return false
     * */
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

    /**
     * method to check the player have enough funds to buy smithore or not
     * @param player current player
     * @return return true if the player have enough funds otherwise 
     * return false
     * */
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

    /**
     * method to check the player have enough funds to buy crystite or not
     * @param player current player
     * @return return true if the player have enough funds otherwise 
     * return false
     * */
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

    /**
     * method to check the player have enough funds to buy mulef or not
     * @param player current player
     * @return return true if the player have enough funds otherwise 
     * return false
     * */
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

    /**
     * method to check the player have enough funds to buy mulee or not
     * @param player current player
     * @return return true if the player have enough funds otherwise 
     * return false
     * */
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

    /**
     * method to check the player have enough funds to buy mules or not
     * @param player current player
     * @return return true if the player have enough funds otherwise 
     * return false
     * */
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

    /**
     * method to check the player have food to sell or not
     * @param player current player
     * @return return true if the player have food otherwise 
     * return false
     * */
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

    /**
     * method to check the player have energy to sell or not
     * @param player current player
     * @return return true if the player have energy otherwise 
     * return false
     * */
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

    /**
     * method to check the player have smithore to sell or not
     * @param player current player
     * @return return true if the player have smithore otherwise 
     * return false
     * */
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

    /**
     * method to check the player have crystite to sell or not
     * @param player current player
     * @return return true if the player have crystite otherwise 
     * return false
     * */
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

    /**
     * method to check the player have mulef to sell or not
     * @param player current player
     * @return return true if the player have mulef otherwise 
     * return false
     * */
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

    /**
     * method to check the player have mulee to sell or not
     * @param player current player
     * @return return true if the player have mulee otherwise 
     * return false
     * */
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

    /**
     * method to check the player have mules to sell or not
     * @param player current player
     * @return return true if the player have mules otherwise 
     * return false
     * */
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
    
    /**
     * override toString() method
     * */
    @Override
    public String toString() {
        return "Prices\nFood: 30\nEnergy: 25\nFood MULE: 125\nEnergy MULE: 125"
                + "\nSmithore MULE: 175";
    }
}
