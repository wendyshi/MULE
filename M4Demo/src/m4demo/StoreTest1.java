package m4demo;

import static org.junit.Assert.*;

/**
 *
 * Created by lintengfei on 15/11/4.
 */
public class StoreTest1 {

    private Store store;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;



    @org.junit.Before
    public void setUp() throws Exception {
        store = new Store();
        p1 = new Player("aa","Elf","Red",250);
        p2 = new Player("bb","Human","Blue",0);
        p3 = new Player("cc","Elf","Green",300);
        p4 = new Player("dd","Human","Purple",10);

    }


    @org.junit.Test
    public void testBuyEnergy() throws Exception {
        assertEquals(true,store.buyEnergy(p1));
        assertEquals(false,store.buyEnergy(p2));
        assertEquals(true,store.buyEnergy(p3));
        assertEquals(false,store.buyEnergy(p4));

    }
}