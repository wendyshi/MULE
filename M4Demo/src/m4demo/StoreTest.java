package m4demo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * CS 2340
 * Zheng Wu
 * M10
 */
public class StoreTest {
    private Store str;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    @Before
    public void setUp() throws Exception {
        str = new Store();
        p1 = new Player("aa","Elf","red",250);
        p2 = new Player("bb","Human","Blue",0);
        p3 = new Player("cc","Elf","green",300);
        p4 = new Player("dd","Human","purple",10);
    }
    @Test
    public void testbuyMuleE()throws Exception {
        assertEquals(true,str.buyMuleE(p1));
        assertEquals(false,str.buyMuleE(p2));
        assertEquals(true,str.buyMuleE(p3));
        assertEquals(false,str.buyMuleE(p4));
    }

}