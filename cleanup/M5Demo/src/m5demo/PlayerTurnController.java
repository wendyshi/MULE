package m5demo;

/**
 * Created by William on 2015/10/1.
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Random;





public class PlayerTurnController {
    @FXML
    public ProgressBar playerTimer;
    @FXML
    private Label playerinfo;
    @FXML
    private Button town;
    @FXML
    public Label info;
    @FXML
    public Label info1;
    @FXML
    public Label info2;
    @FXML
    private Button NextOne;
    @FXML
    private Button pub;
    @FXML
    private Button assay;
    @FXML
    private Button store;
    @FXML
    private Button land;
    @FXML
    private Button back;

    private Boolean skipped = true;
    private GameSettings gameSettings;
    private int gambleGain =0;
    private Boolean a= false;
    private Boolean b = false;
    private Boolean c =false;
    private Player current;
    private int playerNumber =0;

    public PlayerTurnController()
    {
    }

    public void setCurrent(Player current)
    {
        this.current=current;
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
        playerinfo.setText("Current player: " + current.toString());
    }
    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        playerinfo.setText(gameSettings.p1.toString());

    }
    public void timerEnd(Boolean a ,Boolean c)
    {
        this.a =a;
        this.c=c;
        if(a) {
            this.a =true;
            this.c =true;
            pub.setDisable(true);
            store.setDisable(true);
            back.setDisable(true);
            land.setDisable(true);
            assay.setDisable(true);
            pub.setVisible(false);
            store.setVisible(false);
            back.setVisible(false);
            land.setVisible(false);
            assay.setVisible(false);
            info1.setVisible(true);
            current.skipped=true;

        }
        else
        {
            info1.setVisible(false);
        }
    }
    public void resetPlayerTimer()
    {
        playerTimer.progressProperty().unbind();
        playerTimer.setProgress(20);
    }
    private static int showRandomInteger(int aStart, int aEnd, Random aRandom){
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber =  (int)(fraction + aStart);
        return randomNumber;
    }



    @FXML
    private void setTown(ActionEvent event) {

        if (a) {
            if(c) {

                info.setText("Town Is Disabled!");
            }
            else{
                pub.setVisible(true);
                store.setVisible(true);
                back.setVisible(true);
                land.setVisible(true);
                assay.setVisible(true);

                pub.setDisable(false);
                store.setDisable(false);
                back.setDisable(false);
                land.setDisable(false);
                assay.setDisable(false);
                town.setDisable(true);

            }
        } else {

            pub.setVisible(true);
            store.setVisible(true);
            back.setVisible(true);
            land.setVisible(true);
            assay.setVisible(true);

            pub.setDisable(false);
            store.setDisable(false);
            back.setDisable(false);
            land.setDisable(false);
            assay.setDisable(false);
            town.setDisable(true);


        }
    }
    @FXML
    private void setBack()
    {
        if(b)
        {
            pub.setVisible(false);
            store.setVisible(false);
            back.setVisible(false);
            land.setVisible(false);
            assay.setVisible(false);
            town.setDisable(true);
            b = false;
        }
        else {
            pub.setDisable(true);
            store.setDisable(true);
            back.setDisable(true);
            land.setDisable(true);
            assay.setDisable(true);
            town.setDisable(false);

            pub.setVisible(false);
            store.setVisible(false);
            back.setVisible(false);
            land.setVisible(false);
            assay.setVisible(false);
        }


    }
    @FXML
    private void setPub()
    {
        Random random = new Random();
        int Start =100;
        int End = 200;
        if(current.funds>=10) {
            gambleGain = showRandomInteger(Start, End, random);
            current.funds = current.funds + gambleGain;
            info.setText("Player Gained" + gambleGain +"in Pub!");
            updateText();
            playerTimer.progressProperty().unbind();
            c=true;
            b = true;
            town.setDisable(true);
            pub.setDisable(true);
        }
        else{
            info2.setVisible(true);
        }
    }



    @FXML
    private void setNextOne(ActionEvent event)
    {
        c=true;
        System.out.print(c);
        info1.setVisible(false);
        info2.setVisible(false);
        info.setText("System Info");
        if( skipped ) {

            if (gameSettings.p1.skipped == true
                    && gameSettings.p2.skipped == true
                     )
            {
                skipped = false;
                playerTimer.progressProperty().unbind();
                town.setDisable(true);

            }
                current.skipped = true;
                a =false;
                playerNumber++;
                updatePlayer();
                updateText();
                playerTimer.progressProperty().unbind();
                playerTimer.progressProperty().setValue(10);
                Task<Void> task = new Task<Void>() {
                    @Override public Void call() {
                        for (int i = 10; i >=0; i--) {

                            c=false;
                            System.out.print(c);
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
                                c=true;
                                info1.setVisible(true);
                            }
                        }
                        return null;
                    }
                };
                playerTimer.progressProperty().bind(task.progressProperty());
                Thread th = new Thread(task);
                th.setDaemon(true);
                th.start();
                town.setDisable(false);
                info.setText("");


            if ((playerNumber % gameSettings.playerNumber) == 0) {
                gameSettings.p1.skipped = false;
            }
    }
    }
}
