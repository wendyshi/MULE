package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by zhengwu on 9/18/15.
 */
public class MainController {
    @FXML
    private Button New;
    @FXML

    public void ShowScene1(ActionEvent e) throws Exception
    {
        Stage stage = (Stage)New.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MuleScene1.fxml"));
        stage.setTitle("Mule");
        stage.setScene(new Scene(root, 600, 630));
        stage.resizableProperty().setValue(false);
        stage.show();

    }

}
