/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Don
 */
public class TownOptionsController implements Initializable {

    @FXML
    public Label player;
    @FXML
    public Label prices;
    @FXML
    public Button map;
    @FXML
    public Button storebutton;
    @FXML
    public Button pubbutton;
    @FXML
    public Button landbutton;
    @FXML
    public Button assaybutton;
    @FXML
    public Button back;
    @FXML
    public Button buy;
    @FXML
    public Button sell;
    @FXML
    public Button foodb;
    @FXML
    public Button energyb;
    @FXML
    public Button smithb;
    @FXML
    public Button mulefb;
    @FXML
    public Button muleeb;
    @FXML
    public Button mulesb;
    @FXML
    public Button foods;
    @FXML
    public Button energys;
    @FXML
    public Button mulefs;
    @FXML
    public Button mulees;
    @FXML
    public Button muless;
    
    private GameSettings gameSettings;
    private Player current;
    
    /**
     * method to set the game setttings
     * @param gameSettings the variable of GameSettings
     * */
    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }
    
    /**
     * method to set current player
     * @param current the current player
     * */
    public void setCurrent(Player current) {
        this.current = current;
        player.setText(current.toString());
        prices.setText(gameSettings.store.toString());
    }
    
    /**
     * method to back to the map
     * */
    @FXML
    private void backToMap() {
        Stage stage = (Stage) map.getScene().getWindow();
        stage.close();
    }
    
    /**
     * method to setVisible of the button
     * */
    @FXML
    private void storeClick() {
        storebutton.setVisible(false);
        pubbutton.setVisible(false);
        landbutton.setVisible(false);
        assaybutton.setVisible(false);
        map.setVisible(false);
        buy.setVisible(true);
        sell.setVisible(true);
        back.setVisible(true);
        prices.setVisible(true);
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void backDefault() {
        storebutton.setVisible(true);
        pubbutton.setVisible(true);
        landbutton.setVisible(true);
        assaybutton.setVisible(true);
        map.setVisible(true);
        buy.setVisible(false);
        sell.setVisible(false);
        back.setVisible(false);
        prices.setVisible(false);
        foodb.setVisible(false);
        energyb.setVisible(false);
        smithb.setVisible(false);
        mulefb.setVisible(false);
        muleeb.setVisible(false);
        mulesb.setVisible(false);
        foods.setVisible(false);
        energys.setVisible(false);
        mulefs.setVisible(false);
        mulees.setVisible(false);
        muless.setVisible(false);
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void buyClick() {
        foodb.setVisible(true);
        energyb.setVisible(true);
        smithb.setVisible(true);
        mulefb.setVisible(true);
        muleeb.setVisible(true);
        mulesb.setVisible(true);
        foods.setVisible(false);
        energys.setVisible(false);
        mulefs.setVisible(false);
        mulees.setVisible(false);
        muless.setVisible(false);
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void sellClick() {
        foods.setVisible(true);
        energys.setVisible(true);
        mulefs.setVisible(true);
        mulees.setVisible(true);
        muless.setVisible(true);
        foodb.setVisible(false);
        energyb.setVisible(false);
        smithb.setVisible(false);
        mulefb.setVisible(false);
        muleeb.setVisible(false);
        mulesb.setVisible(false);
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void foodBClick() {
        gameSettings.store.buyFood(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void energyBClick() {
        gameSettings.store.buyEnergy(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void mulefBClick() {
        gameSettings.store.buyMuleF(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void muleeBClick() {
        gameSettings.store.buyMuleE(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void mulesBClick() {
        gameSettings.store.buyMuleS(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void foodSClick() {
        gameSettings.store.sellFood(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void energySClick() {
        gameSettings.store.sellEnergy(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void mulefSClick() {
        gameSettings.store.sellMuleF(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void muleeSClick() {
        gameSettings.store.sellMuleE(current);
        player.setText(current.toString());
    }

    /**
     * method to setVisible of the button
     * */
    @FXML
    private void mulesSClick() {
        gameSettings.store.sellMuleS(current);
        player.setText(current.toString());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buy.setVisible(false);
        sell.setVisible(false);
        back.setVisible(false);
        prices.setVisible(false);
        foodb.setVisible(false);
        energyb.setVisible(false);
        smithb.setVisible(false);
        mulefb.setVisible(false);
        muleeb.setVisible(false);
        mulesb.setVisible(false);
        foods.setVisible(false);
        energys.setVisible(false);
        mulefs.setVisible(false);
        mulees.setVisible(false);
        muless.setVisible(false);
    }
    
}
