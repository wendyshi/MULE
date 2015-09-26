package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by William on 2015/9/20.
 */
public class Scene3Controller {

    private String diff;
    private String mapT;
    private int numP;
    private Player p1, p2, p3, p4;


    @FXML
    private Label d;

    @FXML
    private Label t;

    @FXML
    private Label n;

    @FXML
    private Button shw;

    @FXML
    private Button Confirm;

    @FXML
    private Button StO;

    @FXML
    private Button Yes;
    @FXML
    private Button No;

    @FXML
    private Label p1Name;

    @FXML
    private Label p2Name;
    @FXML
    private Label p3Name;
    @FXML
    private Label p4Name;
    @FXML
    private Label p1Race;
    @FXML
    private Label p2Race;
    @FXML
    private Label p3Race;
    @FXML
    private Label p4Race;

    @FXML
    private Label p1Color;
    @FXML
    private Label p2Color;
    @FXML
    private Label p3Color;
    @FXML
    private Label p4Color;






    public Scene3Controller() {
        Scene1Controller s1c = new Scene1Controller();
        GameConfig gc = s1c.getGameConfig();
        diff = gc.getDiff();
        mapT = gc.getMapT();
        numP = gc.getNumP();

        Scene2Controller s2c = new Scene2Controller();
        p1 = s2c.getP1();
        p2 = s2c.getP2();
        p3 = s2c.getP3();
        p4 = s2c.getP4();


    }

    @FXML
    private void setshw(ActionEvent event) throws Exception {
        Scene2Controller s2c = new Scene2Controller();
        d.setText(diff);
        t.setText(mapT);
        n.setText(String.valueOf(numP));
        p1Name.setText(p1.getName());
        p2Name.setText(p2.getName());
        p1Race.setText(p1.getRace());
        p2Race.setText(p2.getRace());
        p1Color.setText(p1.getColor());
        p1Color.setTextFill((Paint.valueOf(p1.getColor())));
        p1Name.setTextFill((Paint.valueOf(p1.getColor())));
        p1Race.setTextFill((Paint.valueOf(p1.getColor())));
        p2Color.setText(p2.getColor());
        p2Color.setTextFill((Paint.valueOf(p2.getColor())));
        p2Name.setTextFill((Paint.valueOf(p2.getColor())));
        p2Race.setTextFill((Paint.valueOf(p2.getColor())));

        if(numP==4){
            p3Name.setText(p3.getName());
            p3Race.setText(p3.getRace());
            p3Color.setText(p3.getColor());
            p3Color.setTextFill((Paint.valueOf(p3.getColor())));
            p3Name.setTextFill((Paint.valueOf(p3.getColor())));
            p3Race.setTextFill((Paint.valueOf(p3.getColor())));

            p4Name.setText(p4.getName());
            p4Race.setText(p4.getRace());
            p4Color.setText(p4.getColor());
            p4Color.setTextFill((Paint.valueOf(p4.getColor())));
            p4Name.setTextFill((Paint.valueOf(p4.getColor())));
            p4Race.setTextFill((Paint.valueOf(p4.getColor())));

        }
        else if(numP==3)
        {
            p3Name.setText(p3.getName());
            p3Race.setText(p3.getRace());
            p3Color.setText(p3.getColor());
            p3Color.setTextFill((Paint.valueOf(p3.getColor())));
            p3Name.setTextFill((Paint.valueOf(p3.getColor())));
            p3Race.setTextFill((Paint.valueOf(p3.getColor())));

        }


    }

    @FXML
    private void setStO(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MuleScene1.fxml"));
        stage.setTitle("Mule");
        stage.setScene(new Scene(root, 600, 630));
        stage.resizableProperty().setValue(false);
        stage.show();

    }

    @FXML
    private void setConfirm(ActionEvent event) throws Exception {

        if (d.getText().equals("")||t.getText().equals("")|| n.getText().equals("") ) {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConfirmWarning.fxml"));
            stage.setTitle("Warning");
            stage.setScene(new Scene(root, 350, 170));
            stage.resizableProperty().setValue(false);
            stage.show();
        } else {
            Stage s = (Stage) Confirm.getScene().getWindow();
            s.close();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MuleScene4.fxml"));
            stage.setTitle("Mule");
            stage.setScene(new Scene(root, 600, 600));
            stage.resizableProperty().setValue(false);
            stage.show();
        }
    }


}
