/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m5demo;

/**
 *
 * @author Don
 */
public class Player {
    
    public String name;
    public String race;
    public String color;
    public int funds;
    public boolean passed;
    public boolean skipped;
    
    public Player(String name, String race, String color, int funds) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.funds = 600;
        passed = false;
        skipped = false;
    }
    public int getFunds()
    {
        return funds;
    }
    @Override
    public String toString() {
        return "Name: " +name +"\nRace: " +race
                +"\nColor: "+color +"\nFunds: " +funds;
    }
}
