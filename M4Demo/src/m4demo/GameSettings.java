/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Don
 */
public class GameSettings implements Serializable {
    
    public String difficulty;
    public int playerNumber;
    public String mapType;
    public Player p1;
    public Player p2;
    public Player p3;
    public Player p4;
    public Store store = new Store();
    
    
    
    public Map map;
    public int freeTurns;
    public int landCost;
    public Player current;
    public Boolean canBuy;
    public Boolean regTurn;
    public ArrayList<Player> playerlist;
    public int turnnumber;
    
    public GameSettings(Player p1, Player p2, Player p3, Player p4) {
        difficulty = "Beginner";
        playerNumber = 4;
        mapType = "Standard";
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    
    public void saveOther(ButtonMapController curr) {
        this.map = curr.map;
        this.freeTurns = curr.freeTurns;
        this.landCost = curr.landCost;
        this.current = curr.current;
        this.canBuy = curr.canBuy;
        this.regTurn = curr.regTurn;
        this.playerlist = curr.playerlist;
        this.turnnumber = curr.turnnumber;
    }
    
    @Override
    public String toString() {
        return "Difficulty: " +difficulty +"\nNumber of Players: " +playerNumber
                +"\nMap Type: "+mapType;
    }
    
}
