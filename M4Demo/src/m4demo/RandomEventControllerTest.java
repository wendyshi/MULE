package m4demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CS 2340
 * Lei Qi
 * M10
 */
public class RandomEventControllerTest {
    private RandomEventController rec;

    @Before
    public void setUp() throws Exception {
        rec = new RandomEventController();
    }
    
    /**
     * use to check the current player has the lowest score or not
     * the first one is the current player's score, the other three
     * is the other players score
     * if the current has the lowest score return true
     * otherwise return false
     * */
    @Test
    public void testCheckScore(){
        assertTrue(rec.checkScore(1, 1, 1, 1));
        assertTrue(rec.checkScore(1, 1, 1, 2));
        assertTrue(rec.checkScore(1, 1, 2, 1));
        assertTrue(rec.checkScore(1, 2, 1, 1));
        assertTrue(rec.checkScore(1, 2, 2, 1));
        assertTrue(rec.checkScore(1, 1, 2, 2));
        assertTrue(rec.checkScore(1, 2, 1, 2));
        assertTrue(rec.checkScore(1, 2, 3, 4));
        assertFalse(rec.checkScore(65, 12, 32, 23));
        assertFalse(rec.checkScore(23, 32, 12, 11));
        assertFalse(rec.checkScore(13, 34, 54, 1));
    }
}
