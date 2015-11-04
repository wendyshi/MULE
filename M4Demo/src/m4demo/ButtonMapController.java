/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.input.MouseEvent;
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
    @FXML
    public Button save;


    public Map map;
    private GameSettings gameSettings;
    public int freeTurns;
    public int landCost = 0;
    private int playerNumber = 0;
    public Player current;
    public Boolean canBuy = true;
    public Boolean regTurn = false;
    public ArrayList<Player> playerlist = new ArrayList<>();
    public int turnnumber = 1;
    public RandomEventController rec = new RandomEventController();


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
        if ((playerNumber % gameSettings.playerNumber) == 3) {
            current = gameSettings.p4;
        } else if ((playerNumber % gameSettings.playerNumber) == 2) {
            current = gameSettings.p3;
        } else if ((playerNumber % gameSettings.playerNumber) == 1) {
            current = gameSettings.p2;
        } else {
            current = gameSettings.p1;
        }

    }

    public void updateText() {
        current.calcScore();
        player.setText("Current player: " + current.toString());
        price.setText("Land price: " + String.valueOf(landCost));
    }

    public void updateText2() throws IOException{

        current.calcScore();
        player.setText("Current player: " + current.toString()
                +"\nTurn number: " +turnnumber);
        price.setText("Land price: " + String.valueOf(landCost));
        resources.setText(current.resourceString());

    }

    public void updateOrder() {
        playerlist.clear();
        playerlist.add(gameSettings.p1);
        playerlist.add(gameSettings.p2);
        playerlist.add(gameSettings.p3);
        playerlist.add(gameSettings.p4);
        Collections.sort(playerlist);
    }

    @FXML
    private void handleButtonPress(ActionEvent event) throws java.io.IOException{


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
                button.setText(current.name + "'s\nFMULE");
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

/*            if (turnnumber < 4){ // new for M9 --- start
                rec.setM(25);
            }else if (turnnumber < 8){
                rec.setM(50);
            }else if (turnnumber < 12){
                rec.setM(75);
            }else {
                rec.setM(100);
            }
            rec.setCurrent(current);
            rec.calculateRand();

            if (current == gameSettings.p1){
                rec.setB(rec.checkScore(current.score, gameSettings.p2.score, gameSettings.p3.score,
                        gameSettings.p4.score));
            }else if (current == gameSettings.p2){
                rec.setB(rec.checkScore(current.score, gameSettings.p1.score, gameSettings.p3.score,
                        gameSettings.p4.score));
            }else if (current == gameSettings.p3){
                rec.setB(rec.checkScore(current.score, gameSettings.p2.score, gameSettings.p1.score,
                        gameSettings.p4.score));
            }else if (current == gameSettings.p4){
                rec.setB(rec.checkScore(current.score, gameSettings.p2.score, gameSettings.p3.score,
                        gameSettings.p1.score));
            }
            rec.checkRand();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("RandomEvent.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 350, 170));
            stage.setTitle("Random Event");
            stage.resizableProperty().setValue(false);

            RandomEventController next = loader.getController();
            next.randomLabel.setText("player: " + current.name + " " + rec.renew());
//        next.setGameSettings(gameSettings);
//        next.setCurrent(current);
            stage.show(); // new for M9 --- end
*/
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
    private void handlePass(ActionEvent event) throws IOException{


        if (regTurn && !playerlist.isEmpty()) {
            current = playerlist.get(0);
            current.updateResources(map);
            playerlist.remove(0);
            info.setText("Standard turn.");
            pass.setText("Next player");

            rec.clearR1();
            if (turnnumber < 4){ // new for M9 --- start
                rec.setM(25);
            }else if (turnnumber < 8){
                rec.setM(50);
            }else if (turnnumber < 12){
                rec.setM(75);
            }else {
                rec.setM(100);
            }
            rec.setCurrent(current);
            rec.calculateRand();

            if (current == gameSettings.p1){
                rec.setB(rec.checkScore(current.score, gameSettings.p2.score, gameSettings.p3.score,
                        gameSettings.p4.score));
            }else if (current == gameSettings.p2){
                rec.setB(rec.checkScore(current.score, gameSettings.p1.score, gameSettings.p3.score,
                        gameSettings.p4.score));
            }else if (current == gameSettings.p3){
                rec.setB(rec.checkScore(current.score, gameSettings.p2.score, gameSettings.p1.score,
                        gameSettings.p4.score));
            }else if (current == gameSettings.p4){
                rec.setB(rec.checkScore(current.score, gameSettings.p2.score, gameSettings.p3.score,
                        gameSettings.p1.score));
            }
            rec.checkRand();
            if (!rec.renew().equals("")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("RandomEvent.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 350, 170));
                stage.setTitle("Random Event");
                stage.resizableProperty().setValue(false);

                RandomEventController next = loader.getController();
                next.randomLabel.setText("player: " + current.name + " " + rec.renew());
//        next.setGameSettings(gameSettings);
//        next.setCurrent(current);
                stage.show(); // new for M9 --- end
            }

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

            if (gameSettings.p1.passed == true
                    && gameSettings.p2.passed == true
                    && gameSettings.p3.passed == true
                    && gameSettings.p4.passed == true) {
                info.setText("All players have passed. Next phase beginning.");
                price.setVisible(false);
                canBuy = false;
                regTurn = true;
                pass.setText("Proceed");
                updateOrder();
                current = playerlist.get(0);
                updateText2();
            }

            if ((playerNumber % gameSettings.playerNumber) == 0) {
                gameSettings.p1.passed = false;
                gameSettings.p1.passed = false;
                gameSettings.p1.passed = false;
                gameSettings.p1.passed = false;
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
    
    @FXML
    private void saveGame(ActionEvent event) {
        try {
            gameSettings.saveOther(this);
            FileOutputStream fileOut = new FileOutputStream("MuleSave.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameSettings);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in MuleSave.ser");
        } catch (IOException i) {
        }
    }
    
    @FXML
    private void refreshMap(MouseEvent event) {
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
            
            if (map.getTile(row, column).owned && map.getTile(row, column).hasMule()) {
                button.setText(map.getTile(row, column).owner +"'s\nEMULE");
            } else if (map.getTile(row, column).owned) {
                button.setText(map.getTile(row, column).owner);
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
