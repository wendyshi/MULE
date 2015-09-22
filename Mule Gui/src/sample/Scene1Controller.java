package sample;

import com.sun.javafx.scene.SceneEventDispatcher;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by zhengwu on 9/16/15.
 */
public class Scene1Controller {
    @FXML
    private Button Accept;
    @FXML
    private ToggleGroup MapChoice;
    @FXML
    private RadioButton Standard;
    @FXML
    private RadioButton Random;
    @FXML
    private ToggleGroup Number;
    @FXML
    private RadioButton Double;
    @FXML
    private RadioButton Triple;
    @FXML
    private RadioButton Quadra;
    @FXML
    private ComboBox Difficulty;


    private static String mType;
    private static int count;
    private static String level;
    private static GameConfig gameConfig;


    public Scene1Controller() {


    }


    @FXML
    public void ShowConfig(ActionEvent e) throws Exception {
        if ((!Standard.isSelected() && !Random.isSelected())
                || (!Double.isSelected()
                && !Triple.isSelected() && !Quadra.isSelected())
                || level == null) {
            newWindow("SelectWarning.fxml", "Warning", 350, 170);
        } else {
            gameConfig = new GameConfig(level, mType, count);
            Stage s = (Stage) Accept.getScene().getWindow();
            s.close();
            if(count == 4) {
                newWindow("MuleScene2.fxml", "Player Settings", 600, 600);
            }
            else if (count ==3)
            {
                newWindow("MuleScene2.fxml", "Player Settings", 600, 600);

            }
            else if(count ==2)
            {
                newWindow("MuleScene2.fxml", "Player Settings", 600, 600);
            }

        }
    }

    @FXML
    public void chooseLevel(ActionEvent event) throws Exception {
        level = Difficulty.getSelectionModel().getSelectedItem().toString();

    }


    @FXML
    public void selectMap(ActionEvent e) throws Exception {
        if (Standard.isSelected()) {
            mType = "Standard";
        } else if (Random.isSelected()) {
            mType = "Random";
        }

    }

    @FXML
    public void selectNumber(ActionEvent e) throws Exception {

        if (Double.isSelected()) {
            count = 2;
        } else if (Triple.isSelected()) {
            count = 3;
        } else {
            count = 4;
        }

    }

    public void newWindow(String fxml, String title, int height, int width) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage.setTitle(title);
        stage.setScene(new Scene(root, height, width));
        stage.resizableProperty().setValue(false);
        stage.show();

    }

    public String getmType() {
        return mType;
    }

    public String getLevel() {
        return level;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GameConfig getGameConfig()
    {
        return gameConfig;
    }

}

