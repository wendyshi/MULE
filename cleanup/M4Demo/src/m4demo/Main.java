/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Don
 */
public class Main extends Application {
    
    private Player p1 = new Player("Alex", "Human", "Blue", 600);
    private Player p2 = new Player("Bob", "Human", "Red", 600);
    private Player p3 = new Player("Charlie", "Human", "Green", 600);
    private Player p4 = new Player("Dan", "Human", "Purple", 600);
    private GameSettings gameSettings = new GameSettings(p1, p2, p3, p4);
    
    @Override
    public void start(Stage mainStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SummaryScreen.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        mainStage.setScene(new Scene(root, 600, 600));
        mainStage.setTitle("Mule");
        mainStage.resizableProperty().setValue(false);
        
        SummaryScreenController next = loader.getController();
        next.setGameSettings(gameSettings);
        
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
