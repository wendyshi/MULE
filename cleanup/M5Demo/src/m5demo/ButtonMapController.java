/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m5demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
    public Button pass;
    @FXML
    public Button Next;

    public int count;
    public boolean a = false;
    public boolean c =false;


    private Map map;
    private GameSettings gameSettings;
    private int freeTurns;
    private int landCost = 0;
    private int playerNumber = 0;
    private Player current;
    private Boolean canBuy = true;

    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }
    public void setCurrent(Player current)
    {
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
        player.setText("Current player: " + current.toString());
        price.setText("Land price: " + String.valueOf(landCost));
    }

    @FXML
    private void handleButtonPress(ActionEvent event) {
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
                canBuy = false;
                pass.setDisable(true);
                pass.visibleProperty().setValue(false);
                Next.setDisable(false);
                Next.visibleProperty().setValue(true);

            }

            if ((playerNumber % gameSettings.playerNumber) == 0) {
                gameSettings.p1.passed = false;
            }
        }
    }

    @FXML
    private void handleTown(ActionEvent event) throws IOException {
        if (canBuy) {
            info.setText("Cannot buy the Town.");
        } else {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TownOptions.fxml"));
            stage.setTitle("Town");
            stage.setScene(new Scene(root, 350, 170));
            stage.resizableProperty().setValue(false);
            stage.show();
        }
    }
    @FXML
    private void handleNext(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("playerTurn.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 600));
        stage.setTitle("Mule");
        stage.resizableProperty().setValue(false);
        PlayerTurnController pt = loader.getController();
        pt.setGameSettings(gameSettings);

        Task<Void> task = new Task<Void>() {
            @Override public Void call() {
                for (int i = 10; i >=0; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    updateProgress(i, 10);
                    if(i==0)
                    {
                        a = true;
                        c= true;
                        pt.timerEnd(a,c);
                    }
                }
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        pt.playerTimer.progressProperty().bind(task.progressProperty());
        pt.setCurrent(gameSettings.p1);
        stage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
