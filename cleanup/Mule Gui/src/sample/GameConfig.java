package sample;

/**
 * Created by William on 2015/9/20.
 */
public class GameConfig {
    private static String diff;
    private static String mapT;
    private static int numP;

    /**
     * Default Constructor
     */
    public GameConfig()
    {

    }

    /**
     * Constructor
     * @param dd difficulty
     * @param mm map
     * @param nn number of player
     */
    public GameConfig(String dd, String mm, int nn )
    {
        diff =dd;
        mapT =mm;
        numP =nn;
    }

    /**
     * set difficulty
     * @param d
     */
    public void setDiff(String d)
    {
        diff = d;
    }

    /**
     * set map type
     * @param m
     */
    public void setMapT(String m)
    {
        mapT = m;
    }

    /**
     * set number of players
     * @param n
     */
    public void setNumP(int n)
    {
        numP = n;
    }

    /**
     *
     * @return difficulty
     */
    public String getDiff()
    {
        return diff;
    }

    /**
     *
     * @return map type
     */
    public String getMapT()
    {
        return  mapT;
    }

    /**
     *
     * @return number of players
     */
    public int getNumP()
    {
        return numP;
    }
}
