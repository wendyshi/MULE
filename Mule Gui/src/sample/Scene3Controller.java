package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by William on 2015/9/20.
 */
public class Scene3Controller {

    private String diff;
    private String mapT;
    private int numP;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;

    @FXML
    private Button bbbb;
    public Scene3Controller(){
        Scene1Controller s1c = new Scene1Controller();
        GameConfig gc = s1c.getGameConfig();
        diff =gc.getDiff();
        mapT = gc.getMapT();
        numP = gc.getNumP();

        Scene2Controller s2c = new Scene2Controller();
        if(numP == 2) {
            p1 = s2c.returnPlayer1();
            p2 = s2c.returnPlayer2();
            p3 = null;
            p4 = null;
        }
        else if(numP == 3)
        {
            p1 = s2c.returnPlayer1();
            p2 = s2c.returnPlayer2();
            p3 = s2c.returnPlayer3();
            p4 = null;
        }
        else if (numP ==4)
        {
            p1 = s2c.returnPlayer1();
            p2 = s2c.returnPlayer2();
            p3 = s2c.returnPlayer3();
            p4 = s2c.returnPlayer4();
        }

    }
    @FXML
    private void setbbbb(ActionEvent event) throws Exception
    {
        System.out.println(diff+" "+mapT+" "+numP);
        System.out.println(p1.getColor()+p1.getName()+p1.getRace());
    }

 }
