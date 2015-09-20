package sample;

import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import com.sun.javafx.scene.SceneEventDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
    private TextField Name;

    private static String race;
    private static String colorp;
    private static int c;
    private static Player p1,p2,p3,p4;
    private int count;




    public  Scene2Controller() throws Exception
    {

        Scene1Controller s1 = new Scene1Controller();
        c = s1.getCount();
        count = c;
        s1.setCount(count - 1);
        System.out.println(c);
        if (count == 4){

        }

        if(count ==3)
        {

        }

        if(count == 2){

        }

        if (count == 1){

        }
    }

    @FXML
    private void scene2Initial(ActionEvent event) throws Exception
    {

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
        else if (race.equals("Dwarves")){
            Description.setText("The Dwarves are from underground, they are shorter and more hairy than human.");
        }
    }

    @FXML
    private void getBack(ActionEvent event) throws Exception
    {
        Stage st1 = (Stage) Back.getScene().getWindow();
        st1.close();
        creatWindow("MuleScene1.fxml");

    }

    @FXML
    private void goNext(ActionEvent event) throws Exception {

        if(count==4)
        {
//            count=3;
            repeatScene("MuleScene2.fxml");
            p4.setName(Name.getText());
            p4.setColor(colorp);

        }
        if(count==3)
        {
//            count=2;
            repeatScene("MuleScene2.fxml");
            System.out.println(c);
        }
       if(count==2)
        {
            repeatScene("MuleScene2.fxml");
            System.out.println(c);
        }
        if(count==1)
        {

            repeatScene("MuleScene3.fxml");
            System.out.println(c);
        }

    }

    //create a new window by name of fxml
    private void creatWindow(String fxml) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage.setTitle("Player Settings");
        stage.setScene(new Scene(root, 600, 600));
        stage.resizableProperty().setValue(false);
        stage.show();

    }
    //create a same scene
    private void repeatScene(String fxml) throws Exception
    {
        Stage ss = (Stage)Next.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        ss.setScene(new Scene(root,600,600));

    }

}
