package m4demo;



import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Lei on 15/10/25.
 */
public class RandomEventController implements Initializable {
    private int rand; // a random number to determine the random event is happen or not
    private int m; // m is factor for the price calculation, it determined by the round the game
    private boolean b; // round of the game;
    private Player current; // current player
    private String rl = "";

    @FXML
    public Label randomLabel;


    public RandomEventController(){
    }

    /**
     * method to make a random number
     * */
    public void calculateRand(){
        int r = (int)(Math.random() * 100 + 1);
        setRand(r);
    }

    /**
     * method for the random number decide the random event
     * 27%
     * */
    public void checkRand() throws java.io.IOException{
        if (getRand() <= 27){
            selectRand(); // random event happened
        }
    }

    /**
     * method to random a random event
     * no bad event happened to the lowest score player
     * */
    public void selectRand(){
        int r = (int)(Math.random() * 7) + 1;
        System.out.println("boolean: " + getB());
        System.out.println("M: " + getM());
        while (getB()){
            if (r == 5 || r == 6 || r == 7) {
                r = (int)(Math.random() * 7) + 1;
            }else{
                setB(false);
            }
        }
        switch (r){
            case 1:
                rl = "YOU JUST RECEIVED A PACKAGE FROM THE GT "
                        + "\n ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";

                current.food += 3;
                current.energy += 2;

                break;
            case 2:
                rl = "A WANDERING TECH STUDENT REPAID YOUR "
                        + "\n HOSPITALITY BY LEAVING TWO BARS OF ORE.";
                current.smithore += 2;

                break;
            case 3:
                rl = "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER"
                        + "\n For $" + 8 * getM();
                System.out.println("original fund is " + current.funds);
                current.funds += 8 * getM();
                System.out.println("current fund is " + current.funds);
                break;
            case 4:
                rl = "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE "
                        + "\n FOR $" + 2 * getM();
                System.out.println("original fund is " + current.funds);
                current.funds += 2 * getM();
                System.out.println("current fund is " + current.funds);

                break;
            case 5:
                rl = "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE."
                        + "\n REPAIRS COST $" + 4 * getM();
                System.out.println("original fund is " + current.funds);
                current.funds -= 4 * getM();
                System.out.println("current fund is " + current.funds);

                break;
            case 6:
                rl = "MISCHIEVOUS UGA STUDENTS BROKE INTO"
                        + "\n YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
                current.food = current.food / 2;

                break;
            case 7:
                rl = "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. "
                        + "\nIT COST YOU $" + 6 * getM() + " TO CLEAN IT UP.";
                System.out.println("original fund is " + current.funds);
                current.funds -= 6 * getM();
                System.out.println("current fund is " + current.funds);

                break;
        }

    }

    /**
     * method to check the player has lowest score or not
     * if yes, no bad event happened to this player
     * @param s1 one player score
     * @param s2 one player score
     * @param s3 one player score
     * @param s4 one player score
     * @return return true if s1 is the lowest score
     *          otherwise return false
     * */
    public boolean checkScore(int s1, int s2, int s3, int s4){
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
        System.out.println("s4: " + s4);
        if (s1 <= s2 && s1 <= s3 && s1 <= s4){
            return true;
        }else {
            return false;
        }
    }

    /**
     * method to show a window about the random event
     * */

    /**
     * set method to set the random number
     * @param rand the random number
     * */
    public void setRand(int rand){
        this.rand = rand;
    }

    /**
     * get method to get the random number
     * @return return the random number
     * */
    public int getRand(){
        return this.rand;
    }

    /**
     * set method to set the factor m
     * @param m the factor m
     * */
    public void setM(int m){
        System.out.println("3333");
        this.m = m;
    }

    /**
     * get method to get the factor m
     * @return return the factor m
     * */
    public int getM(){
        return this.m;
    }

    /**
     * set method to set a boolean value
     * @param b use for check the lowest score
     * */
    public void setB(boolean b){
        this.b = b;
    }

    /**
     * get method to get a boolean value
     * @return return true if this player has lowest score
     * otherwise return false
     * */
    public boolean getB(){
        return this.b;
    }

    /**
     * method to reset the text on the label
     * */
    public String renew(){
        return rl;
    }

    /**
     * set method to set the current player
     * */
    public void setCurrent(Player p){
        this.current = p;
    }
    
    public void clearR1() {
        this.rl = "";
    }


   @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
