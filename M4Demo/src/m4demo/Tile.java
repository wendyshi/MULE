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
public class Tile implements Serializable {

    public String terrain;
    public boolean owned;
    public String owner;
    public boolean mule;

    public int food;
    public int energy;
    public int ore;

    public Tile(String terrain) {
        this.terrain = terrain;
        this.owned = false;
        this.owner = "";
        this.mule = false;
    }

    public Tile(String terrain, String owner) {
        this.terrain = terrain;
        this.owned = true;
        this.owner = owner;
        this.mule = false;
    }

    public boolean hasMule() {
        return mule;
    }

    public Player updateValue(Player current, String type) {
        if (current.energy > 0 && type.equals("Food")) {
            if (this.terrain.equals("River")) {
                this.food = 4;
                //current.food += 4;
            } else if (this.terrain.equals("Plain")) {
                this.food = 2;
                //current.food += 2;
            } else if (this.terrain.equals("Mountain1")) {
                this.food = 1;
                //current.food += 1;
            } else if (this.terrain.equals("Mountain2")) {
                this.food = 1;
                //current.food += 1;
            } else if (this.terrain.equals("Mountain3")) {
                this.food = 1;
                //current.food += 1;
            }
            //current.energy--;
            return current;
        } else if (current.energy > 0 && type.equals("Energy")) {
            if (this.terrain.equals("River")) {
                this.energy = 2;
                //current.food += 2;
            } else if (this.terrain.equals("Plain")) {
                this.energy = 3;
                //current.food += 3;
            } else if (this.terrain.equals("Mountain1")) {
                this.energy = 1;
                //current.food += 1;
            } else if (this.terrain.equals("Mountain2")) {
                this.energy = 1;
                //current.food += 1;
            } else if (this.terrain.equals("Mountain3")) {
                this.energy = 1;
                //current.food += 1;
            }
            //current.energy--;
            return current;
        } else if (current.energy > 0 && type.equals("Ore")) {
            if (this.terrain.equals("River")) {
                this.ore = 0;
                //current.smithore += 0;
            } else if (this.terrain.equals("Plain")) {
                this.ore = 1;
                //current.smithore += 1;
            } else if (this.terrain.equals("Mountain1")) {
                this.ore = 2;
                //current.smithore += 2;
            } else if (this.terrain.equals("Mountain2")) {
                this.ore = 3;
                //current.smithore += 3;
            } else if (this.terrain.equals("Mountain3")) {
                this.ore = 4;
                //current.smithore += 4;
            }
            //current.energy--;
            return current;
        }
        return current;
    }

}
