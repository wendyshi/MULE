package sample;

/**
 * Created by William on 2015/9/20.
 */
public class GameConfig {
    private static String diff;
    private static String mapT;
    private static int numP;

    public GameConfig()
    {

    }
    public GameConfig(String dd, String mm, int nn )
    {
        diff =dd;
        mapT =mm;
        numP =nn;
    }
    public void setDiff(String d)
    {
        diff = d;
    }
    public void setMapT(String m)
    {
        mapT = m;
    }
    public void setNumP(int n)
    {
        numP = n;
    }
    public String getDiff()
    {
        return diff;
    }
    public String getMapT()
    {
        return  mapT;
    }
    public int getNumP()
    {
        return numP;
    }
}
