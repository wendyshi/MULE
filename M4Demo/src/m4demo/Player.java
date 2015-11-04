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
public class Player implements Comparable<Player>, Serializable {
    
    public String name;
    public String race;
    public String color;
    public int funds;
    public boolean passed;
    public int landowned;
    public int food;
    public int energy;
    public int smithore;
    public int crystite;
    public int mulef;
    public int mulee;
    public int mules;
    public int score;
    public int onturn = 1;
    
    public Player(String name, String race, String color, int funds) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.funds = 600;
        passed = false;
        landowned = 0;
        food = 8;
        energy = 4;
        smithore = 0;
        crystite = 0;
        mulef = 0;
        mulee = 0;
        mules = 0;
        this.calcScore();
    }
    
    public void calcScore() {
        score = (landowned * 500) + (food * 30) + (energy * 25) + 
                (smithore * 50) + (crystite * 100) + (mulef * 125)
                + (mulef * 150) + (mules * 175) + funds;
    }
    
    public void updateResources(Map map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (map.map[i][j].owner.equals(name) && map.map[i][j].hasMule()) {
                    if (this.energy > 0) {
                        food += map.map[i][j].food;
                        energy += map.map[i][j].energy;
                        smithore += map.map[i][j].ore;
                        energy--;
                    }
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return "Name: " +name +"\nRace: " +race
                +"\nColor: "+color +"\nFunds: " +funds +"\nScore: " +score;
    }
    
    public String resourceString() {
        return "Food: " +food +"\nEnergy: " +energy +"\nSmithore: "+smithore
                +"\nMULE (F): " +mulef +"\nMULE (E): " +mulee +"\nMULE (S): " +mules;
    }

    @Override
    public int compareTo(Player other) {
        return other.score - this.score;
    }
}
