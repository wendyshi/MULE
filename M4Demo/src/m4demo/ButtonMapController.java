/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Don
 */
public class ButtonMapController implements Initializable {

    @FXML
    public Label info;
    @FXML
    public Label player;
    @FXML
    public Label price;
    @FXML
    public Label resources;
    @FXML
    public Button pass;
    @FXML
    public Button refresh;

    private Map map;
    private GameSettings gameSettings;
    private int freeTurns;
    private int landCost = 0;
    private int playerNumber = 0;
    private Player current;
    private Boolean canBuy = true;
    private Boolean regTurn = false;
    private ArrayList<Player> playerlist = new ArrayList<>();
    private int turnnumber = 1;

    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }
    
    public void setCurrent(Player current) {
        this.current = current;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setFreeTurns(int players) {
        freeTurns = players * 2;
    }

    public void updatePlayer() {
        if ((playerNumber % GameSettings.playerNumber) == 3) {
            current = GameSettings.p4;
        } else if ((playerNumber % GameSettings.playerNumber) == 2) {
            current = GameSettings.p3;
        } else if ((playerNumber % GameSettings.playerNumber) == 1) {
            current = GameSettings.p2;
        } else {
            current = GameSettings.p1;
        }
    }

    public void updateText() {
        current.calcScore();
        player.setText("Current player: " + current.toString());
        price.setText("Land price: " + String.valueOf(landCost));
    }
    
    public void updateText2() {
        current.calcScore();
        player.setText("Current player: " + current.toString()
                +"\nTurn number: " +turnnumber);
        price.setText("Land price: " + String.valueOf(landCost));
        resources.setText(current.resourceString());
    }

    public void updateOrder() {
        playerlist.clear();
        playerlist.add(GameSettings.p1);
        playerlist.add(GameSettings.p2);
        playerlist.add(GameSettings.p3);
        playerlist.add(GameSettings.p4);
        Collections.sort(playerlist);
    }

    @FXML
    private void handleButtonPress(ActionEvent event) {
        
        if (regTurn) {
            Button button = (Button) event.getSource();

            int row;
            int column;
            if (GridPane.getRowIndex(button) != null) {
                row = GridPane.getRowIndex(button);
            } else {
                row = 0;
            }
            if (GridPane.getColumnIndex(button) != null) {
                column = GridPane.getColumnIndex(button);
            } else {
                column = 0;
            }
            
            if (map.getTile(row, column).owner.equals(current.name) && current.mulef > 0
                    && !map.getTile(row, column).hasMule()) {
                current = map.getTile(row, column).updateValue(current, "Food");
                button.setText(current.name +"'s\nFMULE");
                current.mulef--;
                info.setText("MULE placed.");
                map.getTile(row, column).mule = true;
                updateText2();
            } else if (map.getTile(row, column).owner.equals(current.name) && current.mulee > 0) {
                current = map.getTile(row, column).updateValue(current, "Energy");
                button.setText(current.name +"'s\nEMULE");
                current.mulee--;
                info.setText("MULE placed.");
                map.getTile(row, column).mule = true;
            } else if (map.getTile(row, column).owner.equals(current.name) && current.mules > 0) {
                current = map.getTile(row, column).updateValue(current, "Ore");
                button.setText(current.name +"'s\nSMULE");
                current.mules--;
                info.setText("MULE placed.");
                map.getTile(row, column).mule = true;
            }

            else if ((!map.getTile(row, column).owner.equals(current.name))
                    || map.getTile(row, column).food != 0
                    || map.getTile(row, column).hasMule()) {
                if (current.mulef > 0) {
                    current.mulef--;
                } else if (current.mulee > 0) {
                    current.mulee--;
                } else if (current.mules > 0) {
                    current.mules--;
                }
                info.setText("MULE destroyed.");
            }

            updateText();
        }
        
        if (canBuy) {
            Button button = (Button) event.getSource();

            int row;
            int column;
            if (GridPane.getRowIndex(button) != null) {
                row = GridPane.getRowIndex(button);
            } else {
                row = 0;
            }
            if (GridPane.getColumnIndex(button) != null) {
                column = GridPane.getColumnIndex(button);
            } else {
                column = 0;
            }

            updatePlayer();

            if (current.funds < landCost) {
                info.setText("You do not have the required funds to purchase this.");
            }

            if (map.getTile(row, column).owned) {
                info.setText("Tile is owned.");
            }

            if (!map.getTile(row, column).owned && current.funds >= landCost) {
                map.getTile(row, column).owned = true;
                map.getTile(row, column).owner = current.name;
                current.funds -= landCost;
                button.setText(current.name);
                current.passed = false;
                current.landowned++;
                playerNumber++;
            }

            updatePlayer();

            if (freeTurns > 0) {
                freeTurns--;
                if (freeTurns == 0) {
                    landCost = 300;
                }
            }

            updateText();
        }

    }

    @FXML
    private void handlePass(ActionEvent event) {
        
        if (regTurn && !playerlist.isEmpty()) {
            current = playerlist.get(0);
            current.updateResources(map);
            playerlist.remove(0);
            info.setText("Standard turn.");
            pass.setText("Next player");
            updateText2();
        }
        
        if (regTurn && playerlist.isEmpty()) {
            updateOrder();
            updateText2();
            pass.setText("Next turn");
            turnnumber++;
        }
        
        if (canBuy) {
            current.passed = true;
            playerNumber++;
            updatePlayer();
            updateText();

            if (GameSettings.p1.passed == true
                    && GameSettings.p2.passed == true
                    && GameSettings.p3.passed == true
                    && GameSettings.p4.passed == true) {
                info.setText("All players have passed. Next phase beginning.");
                price.setVisible(false);
                canBuy = false;
                regTurn = true;
                pass.setText("Proceed");
                updateOrder();
                current = playerlist.get(0);
                updateText2();
            }

            if ((playerNumber % GameSettings.playerNumber) == 0) {
                GameSettings.p1.passed = false;
                GameSettings.p1.passed = false;
                GameSettings.p1.passed = false;
                GameSettings.p1.passed = false;
            }
        }
        
    }
    
    @FXML
    private void refreshData(ActionEvent event) {
        current.calcScore();
        player.setText("Current player: " + current.toString());
        price.setText("Land price: " + String.valueOf(landCost));
        if (!canBuy) {
            resources.setVisible(true);
            player.setText("Current player: " + current.toString()
                +"\nTurn number: " +turnnumber);
            resources.setText(current.resourceString());
        }
    }
    
    @FXML
    private void handleTown(ActionEvent event) throws IOException {
        if (canBuy) {
            info.setText("Cannot buy the Town.");
        } else {
            /*Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TownOptions.fxml"));
            stage.setTitle("Town");
            stage.setScene(new Scene(root, 350, 170));
            stage.resizableProperty().setValue(false);
            stage.show();*/
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TownOptions.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 350, 170));
            stage.setTitle("Town");
            stage.resizableProperty().setValue(false);

            TownOptionsController next = loader.getController();
            next.setGameSettings(gameSettings);
            next.setCurrent(current);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
