/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m5demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Don
 */
public class TownOptionsController implements Initializable {

    @FXML
    public Button back;
    @FXML
    public Button op1;
    @FXML
    public Button op2;
    @FXML
    public Button op3;
    @FXML
    public Button op4;
    
    @FXML
    private void backToMap(ActionEvent event) {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
