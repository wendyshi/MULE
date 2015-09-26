package sample;

/**
 * Created by William on 2015/9/19.
 */
public class Player {
    private  String color;
    private  String name;
    private  String race;
    public Player()
    {
        color = "";
        name ="" ;
        race ="";
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

    public void setAll(String n, String r, String c)
    {
        name =n;
        race =r;
        color =c;
    }
    public String toString()
    {
        return race+name+color;
    }
}
