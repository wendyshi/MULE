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
public class Map {
    
    public Tile[][] map;
    
    public Map() {
        map = new Tile[5][9];
        map[0][0] = new Tile("Plain");
        map[0][1] = new Tile("Plain");
        map[0][2] = new Tile("Mountain1");
        map[0][3] = new Tile("Plain");
        map[0][4] = new Tile("River");
        map[0][5] = new Tile("Plain");
        map[0][6] = new Tile("Mountain3");
        map[0][7] = new Tile("Plain");
        map[0][8] = new Tile("Plain");
        
        map[1][0] = new Tile("Plain");
        map[1][1] = new Tile("Mountain1");
        map[1][2] = new Tile("Plain");
        map[1][3] = new Tile("Plain");
        map[1][4] = new Tile("River");
        map[1][5] = new Tile("Plain");
        map[1][6] = new Tile("Plain");
        map[1][7] = new Tile("Plain");
        map[1][8] = new Tile("Mountain3");
        
        map[2][0] = new Tile("Mountain3");
        map[2][1] = new Tile("Plain");
        map[2][2] = new Tile("Plain");
        map[2][3] = new Tile("Plain");
        map[2][4] = new Tile("Town", "Default");
        map[2][5] = new Tile("Plain");
        map[2][6] = new Tile("Plain");
        map[2][7] = new Tile("Plain");
        map[2][8] = new Tile("Mountain1");
        
        map[3][0] = new Tile("Plain");
        map[3][1] = new Tile("Mountain2");
        map[3][2] = new Tile("Plain");
        map[3][3] = new Tile("Plain");
        map[3][4] = new Tile("River");
        map[3][5] = new Tile("Plain");
        map[3][6] = new Tile("Mountain2");
        map[3][7] = new Tile("Plain");
        map[3][8] = new Tile("Plain");
        
        map[4][0] = new Tile("Plain");
        map[4][1] = new Tile("Plain");
        map[4][2] = new Tile("Mountain2");
        map[4][3] = new Tile("Plain");
        map[4][4] = new Tile("River");
        map[4][5] = new Tile("Plain");
        map[4][6] = new Tile("Plain");
        map[4][7] = new Tile("Plain");
        map[4][8] = new Tile("Mountain2");
    }
    
    public Tile getTile(int row, int column) {
        return map[row][column];
    }
    
}
