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
public class Tile {
    
    public String terrain;
    public boolean owned;
    public String owner;
    
    public Tile(String terrain) {
        this.terrain = terrain;
        this.owned = false;
        this.owner = "";
    }
    
    public Tile(String terrain, String owner) {
        this.terrain = terrain;
        this.owned = true;
        this.owner = owner;
    }
    
}
