package sample;

/**
 * Created by William on 2015/9/19.
 */
public class Player {
    private  String color;
    private  String name;
    private  String race;

    /**
     * default constructor
     */
    public Player()
    {
        color = "";
        name ="" ;
        race ="";
    }

    /**
     * constructor
     * @param name player name
     * @param race player race
     * @param color player color
     */
    public Player(String name, String race, String color)
    {
        this.name = name;
        this.race = race;
        this.color = color;
    }

    /**
     *
     * @return player color
     */
    public String getColor()
    {
        return color;
    }

    /**
     *
     * @param c player color
     */
    public void setColor(String c)
    {
        color = c;
    }

    /**
     *
     * @return player name
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @param n player name
     */
    public void setName(String n)
    {
        name = n;
    }

    /**
     *
     * @return player race
     */
    public String getRace()
    {
        return race;
    }
    /**
     *
     * @param r set player race
     */
    public void setRace(String r)
    {
        race =r;
    }

    /**
     * set race, name, color
     * @param n name
     * @param r race
     * @param c color
     */
    public void setAll(String n, String r, String c)
    {
        name =n;
        race =r;
        color =c;
    }

    /**
     * To string
     * @return return toString
     */
    public String toString()
    {
        return race+name+color;
    }
}
