/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Don
 */
public class SummaryScreenController implements Initializable {

//    @FXML
//    private Button button;
//    @FXML
//    private Button loadbutton;

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

    /**
     * method to set game settings
     * @param gameSettings  the variable of GameSettings
     * */
    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        settingsLabel.setText(gameSettings.toString());
        p1Label.setText(gameSettings.p1.toString());
        p2Label.setText(gameSettings.p2.toString());
        p3Label.setText(gameSettings.p3.toString());
        p4Label.setText(gameSettings.p4.toString());
    }
    
    /**
     * method to load the buttonMap.fxml
     * @param event  to act what we want to do
     * */
    @FXML
    private void toMap(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
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
        next.setFreeTurns(gameSettings.playerNumber);
        if (gameSettings.mapType.equals("Standard")) {
            next.setMap(new Map());
        }
        next.info.setText("Click on a tile to purchase it.");
        next.player.setText("Current player: " + gameSettings.p1.toString());
        next.price.setText("Land price: 0");
        next.resources.setVisible(false);
        next.updatePlayer();
        next.updateOrder();
        stage.show();
    }

    /**
     * method to load the buttonMap.fxml
     * @param event  to act what we want to do
     * */
    @FXML
    private void loadGame(ActionEvent event) throws IOException  {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ButtonMap.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 600));
        stage.setTitle("Mule");
        stage.resizableProperty().setValue(false);

        GameSettings loaded = null;

        try {
            FileInputStream fileIn = new FileInputStream("MuleSave.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            loaded = (GameSettings) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException c) {
            System.out.println("No save found.");
        }
                
        ButtonMapController next = loader.getController();
        next.setGameSettings(loaded);
        
        next.map = loaded.map;
        next.freeTurns = loaded.freeTurns;
        next.landCost = loaded.landCost;
        next.current = loaded.current;
        next.canBuy = loaded.canBuy;
        next.regTurn = loaded.regTurn;
        next.playerlist = loaded.playerlist;
        next.turnnumber = loaded.turnnumber;
        
        
        next.updatePlayer();
        next.updateOrder();
        next.updateText();
        next.updateText2();
        stage.show();
    }
    
    /**
     * override method
     * */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
