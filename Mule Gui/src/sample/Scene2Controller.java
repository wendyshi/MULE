package sample;

import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.sun.javafx.scene.SceneEventDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javax.lang.model.util.ElementFilter;
import java.awt.*;
import java.io.IOException;

/**
 * Created by William on 2015/9/19.
 */

public class Scene2Controller {
    @FXML
    private Button Next;
    @FXML
    private Button Back;
    @FXML
    private ComboBox Race ;
    @FXML
    private ComboBox ColorPick ;
    @FXML
    private Label Description ;
    @FXML
    private Label Color ;
    @FXML
    private Label PlayerX;
    @FXML
    private Pane Scene2;
    @FXML
    private javafx.scene.control.TextField Name;

    private String race;
    private String colorp;
    private static int cc;
    private static Player p1;
    private static Player p2;
    private static Player p3;
    private static Player p4;
    private int count;
    private String n,c,r;




    public  Scene2Controller()
    {

        Scene1Controller s1 = new Scene1Controller();
        cc= s1.getCount();
        count = cc;
        s1.setCount(count - 1);
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
    }

    @FXML
    private void chooseColor (ActionEvent event) throws Exception
    {
        colorp = ColorPick.getSelectionModel().getSelectedItem().toString();
        Description.setTextFill(javafx.scene.paint.Color.valueOf(colorp));
        if(colorp.equals("Blue")) {
            Color.setStyle("-fx-background-color: Blue;");
        }
        else if (colorp.equals("Red")) {
            Color.setStyle("-fx-background-color: Red;");
        }
        else if (colorp.equals("Purple")) {
            Color.setStyle("-fx-background-color: Purple;");
        }
        else if (colorp.equals("Green")){
            Color.setStyle("-fx-background-color: Green;");
        }

    }
    @FXML
    private void chooseRace(ActionEvent event) throws Exception
    {
        race = Race.getSelectionModel().getSelectedItem().toString();
        Description.wrapTextProperty().setValue(true);
        if(race.equals("Human")) {
            Description.setText("Human is a race living on earth, with a human looking like you and me.");
        }
        else if (race.equals("Elf")) {
            Description.setText("The Elves were the fairest creatures,a far more beautiful race than Human,and generally taller.");
    }
        else if (race.equals("Dwarve")){
            Description.setText("The Dwarves are from underground, they are shorter and more hairy than human.");
        }
        else if(race.equals("Hobbit"))
        {
            Description.setText("The Hobbits are Generally Shorter than Human,they are thin and small.");
        }
    }

    @FXML
    private void getBack(ActionEvent event) throws Exception
    {
        Stage st1 = (Stage) Back.getScene().getWindow();
        st1.close();
        createWindow
                ("MuleScene1.fxml",600,630);

    }

    @FXML
    private void goNext(ActionEvent event) throws Exception {

        try {
            if (count == 4) {

                n = Name.getText();
                r = Race.getSelectionModel().getSelectedItem().toString();
                c = ColorPick.getSelectionModel().getSelectedItem().toString();
                p4.setAll(n,r,c);
                repeatScene("MuleScene2.fxml");


            }
            if (count == 3) {
                n = Name.getText();
                r = Race.getSelectionModel().getSelectedItem().toString();
                c = ColorPick.getSelectionModel().getSelectedItem().toString();
                p3.setAll(n,r,c);
                repeatScene("MuleScene2.fxml");
            }
            if (count == 2) {
                n = Name.getText();
                r = Race.getSelectionModel().getSelectedItem().toString();
                c = ColorPick.getSelectionModel().getSelectedItem().toString();
                p2.setAll(n, r, c);
               // System.out.println(p2.toString());
                repeatScene("MuleScene2.fxml");

            }
            if (count == 1) {

                n = Name.getText();
                r = Race.getSelectionModel().getSelectedItem().toString();
                c = ColorPick.getSelectionModel().getSelectedItem().toString();
                p1.setAll(n, r, c);
                //System.out.println(p1.toString());
                repeatScene("MuleScene3.fxml");

            }

        } catch (Exception e) {
            Scene1Controller s1 = new Scene1Controller();
            int cc = s1.getCount();
            s1.setCount(cc++);
            createWindow("SettingWarning.fxml", 350, 170);
        }
        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }
    //create a new window by name of fxml
    private void createWindow
    (String fxml) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage.setTitle("Player Settings");
        stage.setScene(new Scene(root, 600, 600));
        stage.resizableProperty().setValue(false);
        stage.show();

    }

    private void createWindow(String fxml, int height, int width) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage.setTitle("Player Settings");
        stage.setScene(new Scene(root, height, width));
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //create a same scene
    private void repeatScene(String fxml) throws Exception
    {
        Stage ss = (Stage)Next.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        ss.setScene(new Scene(root, 600, 600));

    }
    public static Player getP1()
    {
        return p1;
    }
    public static Player getP2()
    {
        return p2;
    }
    public static Player getP3()
    {
        return p3;
    }
    public static Player getP4()
    {
        return p4;
    }

}
