package sample;

/**
 * Created by William on 2015/9/19.
 */
public class Player {
    private static String color;
    private static String name;
    private static String race;
    public Player()
    {

    }
    public Player(String name, String race, String color)
    {
        this.name = name;
        this.race = race;
        this.color = color;
    }
    public String getColor()
    {
        return color;
    }

    public void setColor(String c)
    {
        color = c;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }
    public String getRace()
    {
        return race;
    }
    public void setRace(String r)
    {
        race =r;
    }
    public String toString()
    {
        System.out.println(race+" "+name+" "+color);
        return race+name+color;
    }
}
