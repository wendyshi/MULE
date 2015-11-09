package m4demo;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhengwu on 11/9/15.
 */
public class StoreTest2 {

        private Store store;
        private Player p1;
        private Player p2;
        private Player p3;
        private Player p4;

        @Before
        public void setUp ()throws Exception {
            store = new Store();
            p1 = new Player("a", "Elf", "Red", 100);
            p2 = new Player("b", "Human", "Blue", 0);
            p3 = new Player("c", "Elf", "Green", 210);
            p4 = new Player("d", "Human", "Purple", 29);

        }


        @Test
        public void testBuyFood ()throws Exception {
            assertEquals(true, store.buyFood(p1));
            assertEquals(false, store.buyFood(p2));
            assertEquals(true, store.buyFood(p3));
            assertEquals(false, store.buyFood(p4));

        }


}