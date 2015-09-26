/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

/**
 *
 * @author Don
 */
public class GameSettings {
    
    public String difficulty;
    public int playerNumber;
    public String mapType;
    public Player p1;
    public Player p2;
    public Player p3;
    public Player p4;
    
    public GameSettings(Player p1, Player p2, Player p3, Player p4) {
        difficulty = "Beginner";
        playerNumber = 4;
        mapType = "Standard";
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    @Override
    public String toString() {
        return "Difficulty: " +difficulty +"\nNumber of Players: " +playerNumber
                +"\nMap Type: "+mapType;
    }
    
}
