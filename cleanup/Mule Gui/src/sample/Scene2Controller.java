
package sample;

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
    private static int cc;
    private static Player p1;
    private static Player p2;
    private static Player p3;
    private static Player p4;
    private int count;
    private String n, c, r;

    /**
     * default constructor
     */
    public Scene2Controller() {

    }

    /**
     * choose the color of the player
     * @param event
     * @throws Exception
     */
    @FXML
    private void chooseColor(ActionEvent event) throws Exception {
        colorp = ColorPick.getSelectionModel().getSelectedItem().toString();
        Description.setTextFill(javafx.scene.paint.Color.valueOf(colorp));
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

    /**
     * choose the race of a player
     * @param event
     * @throws Exception
     */
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

    /**
     * back button controller
     * @param event
     * @throws Exception
     */
    @FXML
    private void getBack(ActionEvent event) throws Exception {
        Stage st1 = (Stage) Back.getScene().getWindow();
        st1.close();
        createWindow
                ("MuleScene1.fxml", 600, 630);

    }

    /**
     * Handle the next button based on the number of player
     * @param event
     * @throws Exception
     */
    @FXML
    private void goNext(ActionEvent event) throws Exception {

        Scene1Controller s1 = new Scene1Controller();
        cc = s1.getCount();
        count = cc;
        final int c1 = s1.getC();
        s1.setCount(count - 1);
        try {
            if (count == 4) {
                p4 = new Player();
                n = Name.getText();
                r = Race.getSelectionModel().getSelectedItem().toString();
                c = ColorPick.getSelectionModel().getSelectedItem().toString();
                p4.setAll(n, r, c);
                repeatScene("MuleScene2.fxml");

            }
            if (count == 3) {
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
            if (count == 2) {
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
                    } else {
                        repeatScene("MuleScene2.fxml");
                    }
                }
                if (c1 == 3) {
                    if (p2.getName().equals(p3.getName())) {
                        createWindow("SameNameWarning.fxml", 350, 170);
                        s1.setCount(count++);
                    } else if (p2.getColor().equals(p3.getColor())) {
                        createWindow("SameColorWarning.fxml", 350, 170);
                        s1.setCount(count++);
                    } else {
                        repeatScene("MuleScene2.fxml");
                    }

                }
            }

            if (count == 1) {
                p1 = new Player();
                n = Name.getText();
                r = Race.getSelectionModel().getSelectedItem().toString();
                c = ColorPick.getSelectionModel().getSelectedItem().toString();
                p1.setAll(n, r, c);

                if (c1 == 2) {
                    if (p1.getName().equals(p2.getName())) {
                        createWindow("SameNameWarning.fxml", 350, 170);
                        s1.setCount(count++);
                    } else if (p1.getColor().equals(p2.getColor())) {
                        createWindow("SameColorWarning.fxml", 350, 170);
                        s1.setCount(count++);
                    } else {
                        repeatScene("MuleScene3.fxml");
                    }
                }
                if (c1 == 3) {
                    if (p1.getName().equals(p2.getName()) ||
                            p1.getName().equals(p3.getName())) {
                        createWindow("SameNameWarning.fxml", 350, 170);
                        s1.setCount(count++);
                    } else if (p1.getColor().equals(p2.getColor()) ||
                            p1.getColor().equals(p3.getColor())) {
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
                        createWindow("SameNameWarning.fxml", 350, 170);
                        s1.setCount(count++);
                    } else if (p1.getColor().equals(p2.getColor()) ||
                            p1.getColor().equals(p3.getColor()) ||
                            p1.getColor().equals(p4.getColor())) {
                        createWindow("SameColorWarning.fxml", 350, 170);
                        s1.setCount(count++);
                    } else {
                        repeatScene("MuleScene3.fxml");
                    }
                }
            }
        } catch (Exception e) {
            Scene1Controller s2 = new Scene1Controller();
            int cc = s2.getCount();
            s1.setCount(cc++);
            createWindow("SettingWarning.fxml", 350, 170);
        }

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
    private void repeatScene(String fxml) throws Exception {
        Stage ss = (Stage) Next.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        ss.setScene(new Scene(root, 600, 600));

    }

    /**
     * return player1
     * @return
     */
    public Player getP1() {
        return p1;
    }

    /**
     * return player 2
     * @return
     */
    public Player getP2() {
        return p2;
    }

    /**
     * returm player 3
     * @return
     */
    public Player getP3() {
        return p3;
    }

    /**
     * return player 4
     * @return
     */
    public Player getP4() {
        return p4;
    }

}
