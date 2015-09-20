package sample;
import com.sun.javafx.scene.SceneEventDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

import javafx.stage.Stage;

/**
 * Created by zhengwu on 9/16/15.
 */
public class SampleController {
    @FXML
    private Button Accept;
    @FXML
    private RadioButton Standard;
    @FXML
    private ComboBox Difficulty;
    String level;
    public SampleController()
    {

    }

    @FXML
    public void ShowConfig (ActionEvent e) throws Exception
    {
        Stage stage = (Stage) Accept.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MuleScene2.fxml"));
        stage.setTitle("Mule");
        stage.setScene(new Scene(root, 600, 600));
        stage.resizableProperty().setValue(false);
        stage.show();

    }

    public void chooseLevel (ActionEvent event) throws Exception
    {
        level = Difficulty.getSelectionModel().getSelectedItem().toString();
        System.out.println(level);

    }

    public  String getLevel()
    {
        return level;
    }

}

