package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by zhengwu on 9/20/15.
 */
public class WarningController {
    @FXML
    private Button Okay;
    @FXML
    private Button Ok;

    @FXML
    public void oKclicked(ActionEvent event) throws Exception {
        Stage s = (Stage) Okay.getScene().getWindow();
        s.close();
    }

    @FXML
    public void oKclick(ActionEvent event) throws Exception {
        Stage s = (Stage) Ok.getScene().getWindow();
        s.close();

    }
}
