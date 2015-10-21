/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Don
 */
public class SummaryScreenController implements Initializable {
    
    @FXML
    private Button button;
    
    @FXML
    private Label settingsLabel;
    @FXML
    private Label p1Label;
    @FXML
    private Label p2Label;
    @FXML
    private Label p3Label;
    @FXML
    private Label p4Label;
    
    private GameSettings gameSettings;
    
    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        settingsLabel.setText(gameSettings.toString());
        p1Label.setText(GameSettings.p1.toString());
        p2Label.setText(GameSettings.p2.toString());
        p3Label.setText(GameSettings.p3.toString());
        p4Label.setText(GameSettings.p4.toString());
    }
    
    @FXML
    private void toMap(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ButtonMap.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 600));
        stage.setTitle("Mule");
        stage.resizableProperty().setValue(false);
        
        ButtonMapController next = loader.getController();
        next.setGameSettings(gameSettings);
        next.setFreeTurns(GameSettings.playerNumber);
        if (GameSettings.mapType.equals("Standard")) {
            next.setMap(new Map());
        }
        next.info.setText("Click on a tile to purchase it.");
        next.player.setText("Current player: " +GameSettings.p1.toString());
        next.price.setText("Land price: 0");
        next.resources.setVisible(false);
        next.updatePlayer();
        next.updateOrder();
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
