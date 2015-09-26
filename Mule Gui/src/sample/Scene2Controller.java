package sample;

import com.sun.deploy.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.invoke.empty.Empty;


/**
 * Created by William on 2015/9/19.
 */

public class Scene2Controller {
    @FXML
    private Button Next;
    @FXML
    private Button Back;
    @FXML
    private ComboBox Race;
    @FXML
    private ComboBox ColorPick;
    @FXML
    private Label Description;
    @FXML
    private Label Color;
    @FXML
    private Label PlayerX;
    @FXML
    private Pane Scene2;
    @FXML
    private javafx.scene.control.TextField Name;

    private String race;
    private String colorp;
    private String name;
    private static int cc;
    private static Player p1;
    private static Player p2;
    private static Player p3;
    private static Player p4;
    private int count;
    private String n, c, r;


    public Scene2Controller() {

    }

    @FXML
    private void chooseColor(ActionEvent event) throws Exception {
        colorp = ColorPick.getSelectionModel().getSelectedItem().toString();
        if (colorp.equals("Cyan")) {
            Color.setStyle("-fx-background-color: Cyan;");
        } else if (colorp.equals("Red")) {
            Color.setStyle("-fx-background-color: Red;");
        } else if (colorp.equals("Purple")) {
            Color.setStyle("-fx-background-color: Purple;");
        } else if (colorp.equals("GreenYellow")) {
            Color.setStyle("-fx-background-color: Greenyellow;");
        }

    }

    @FXML
    private void chooseRace(ActionEvent event) throws Exception {
        race = Race.getSelectionModel().getSelectedItem().toString();
        Description.wrapTextProperty().setValue(true);
        if (race.equals("Human")) {
            Description.setText("Human is a race living on earth, with a human looking like you and me.");
        } else if (race.equals("Elf")) {
            Description.setText("The Elves were the fairest creatures,a far more beautiful race than Human,and generally taller.");
        } else if (race.equals("Dwarve")) {
            Description.setText("The Dwarves are from underground, they are shorter and more hairy than human.");
        } else if (race.equals("Hobbit")) {
            Description.setText("The Hobbits are Generally Shorter than Human,they are thin and small.");
        }
    }

    @FXML
    private void getBack(ActionEvent event) throws Exception {
        Stage st1 = (Stage) Back.getScene().getWindow();
        st1.close();
        createWindow
                ("MuleScene1.fxml", 600, 630);

    }

    @FXML
    private void goNext(ActionEvent event) throws Exception {


        Scene1Controller s1 = new Scene1Controller();
        cc = s1.getCount();
        count = cc;
        final int c1 = s1.getC();
        s1.setCount(count - 1);
        try {
            if (count == 4) {
                name = Name.getText();
                if(colorp==null||race==null||name==null||name.equals("")||name.equals("Enter your name Here"))
                {
                    Scene1Controller s2 = new Scene1Controller();
                    int cc = s2.getCount();
                    s1.setCount(cc+1);
                    createWindow("SettingWarning.fxml", 350, 170);
                }else {
                    p4 = new Player();
                    n = Name.getText();
                    r = Race.getSelectionModel().getSelectedItem().toString();
                    c = ColorPick.getSelectionModel().getSelectedItem().toString();
                    p4.setAll(n, r, c);
                    repeatScene("MuleScene2.fxml");
                }

            }
            if (count == 3) {
                name = Name.getText();
                if(colorp==null||race==null||name==null||name.equals("")||name.equals("Enter your name Here"))
                {
                    Scene1Controller s2 = new Scene1Controller();
                    int cc = s2.getCount();
                    s1.setCount(cc+1);
                    createWindow("SettingWarning.fxml", 350, 170);
                }else {
                    p3 = new Player();
                    n = Name.getText();
                    r = Race.getSelectionModel().getSelectedItem().toString();
                    c = ColorPick.getSelectionModel().getSelectedItem().toString();
                    p3.setAll(n, r, c);
                    if (c1 == 3) {
                        repeatScene("MuleScene2.fxml");
                    }
                    if (c1 == 4) {
                        if (p3.getName().equals(p4.getName())) {
                            createWindow("SameNameWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else if (p3.getColor().equals(p4.getColor())) {
                            createWindow("SameColorWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else {
                            repeatScene("MuleScene2.fxml");
                        }
                    }
                }

            }
            if (count == 2) {
                name = Name.getText();
                if(colorp==null||race==null||name==null||name.equals("")||name.equals("Enter your name Here"))
                {
                    Scene1Controller s2 = new Scene1Controller();
                    int cc = s2.getCount();
                    s1.setCount(cc+1);
                    createWindow("SettingWarning.fxml", 350, 170);
                }else {
                    p2 = new Player();
                    n = Name.getText();
                    r = Race.getSelectionModel().getSelectedItem().toString();
                    c = ColorPick.getSelectionModel().getSelectedItem().toString();
                    p2.setAll(n, r, c);
                    if (c1 == 2) {
                        repeatScene("MuleScene2.fxml");
                    }
                    if (c1 == 4) {
                        if (p2.getName().equals(p4.getName()) ||
                                p2.getName().equals(p3.getName())) {
                            createWindow("SameNameWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else if (p2.getColor().equals(p4.getColor())
                                || p2.getColor().equals(p3.getColor())) {

                            createWindow("SameColorWarning.fxml", 350, 170);
                            s1.setCount(count++);
                            System.out.println(count + "A count");
                        } else {
                            repeatScene("MuleScene2.fxml");
                        }
                    }
                    if (c1 == 3) {
                        if (p2.getName().equals(p3.getName())) {
                            System.out.println(count + "A count");
                            createWindow("SameNameWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else if (p2.getColor().equals(p3.getColor())) {
                            System.out.println(count + "A count");
                            createWindow("SameColorWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else {
                            repeatScene("MuleScene2.fxml");
                        }

                    }
                }
            }

            if (count == 1) {
                name = Name.getText();
                if(colorp==null||race==null||name==null||name.equals("")||name.equals("Enter your name Here"))
                {
                    Scene1Controller s2 = new Scene1Controller();
                    int cc = s2.getCount();
                    s1.setCount(cc+1);
                    createWindow("SettingWarning.fxml", 350, 170);
                }else {
                p1 = new Player();
                n = Name.getText();
                r = Race.getSelectionModel().getSelectedItem().toString();
                c = ColorPick.getSelectionModel().getSelectedItem().toString();
                p1.setAll(n, r, c);

                    if (c1 == 2) {
                        if (p1.getName().equals(p2.getName())) {
                            System.out.println(count + "A count");
                            createWindow("SameNameWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else if (p1.getColor().equals(p2.getColor())) {
                            System.out.println(count + "A count");
                            createWindow("SameColorWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else {
                            repeatScene("MuleScene3.fxml");
                        }
                    }
                    if (c1 == 3) {
                        if (p1.getName().equals(p2.getName()) ||
                                p1.getName().equals(p3.getName())) {
                            System.out.println(count + "A count");
                            createWindow("SameNameWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else if (p1.getColor().equals(p2.getColor()) ||
                                p1.getColor().equals(p3.getColor())) {
                            System.out.println(count + "A count");
                            createWindow("SameColorWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else {
                            repeatScene("MuleScene3.fxml");
                        }
                    }
                    if (c1 == 4) {
                        if (p1.getName().equals(p2.getName()) ||
                                p1.getName().equals(p3.getName()) ||
                                p1.getName().equals(p4.getName())) {
                            System.out.println(count + "A count");
                            createWindow("SameNameWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else if (p1.getColor().equals(p2.getColor()) ||
                                p1.getColor().equals(p3.getColor()) ||
                                p1.getColor().equals(p4.getColor())) {
                            System.out.println(count + "A count");
                            createWindow("SameColorWarning.fxml", 350, 170);
                            s1.setCount(count++);
                        } else {
                            repeatScene("MuleScene3.fxml");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    @FXML
    private void DragRace(ActionEvent event) throws Exception {

    }
    @FXML
    private void DragColor(ActionEvent event) throws Exception {
        ColorPick.setPromptText("");
    }


    //create a new window by name of fxml
    private void createWindow
    (String fxml) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage.setTitle("Player Settings");
        stage.setScene(new Scene(root, 600, 600));
        stage.resizableProperty().setValue(false);
        stage.alwaysOnTopProperty().equals(true);
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
    private void repeatScene(String fxml) throws Exception {
        Stage ss = (Stage) Next.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        ss.setScene(new Scene(root, 600, 600));

    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getP3() {
        return p3;
    }

    public Player getP4() {
        return p4;
    }

}
