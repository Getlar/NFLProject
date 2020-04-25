package org.ttbdlk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class LoadingScreenController extends DAOImplementation{
    @FXML
    public Button startButton;

    @FXML
    private Label randomText;

    int x;
    String[] textek = {"Loading Database...","Initiating Players...","Waiting for David to finish Database...","Touchdown Control...","Preparing for Super Bowl..."
            ,"Initiating Draft Sequnce...","Drafting Players...","Preparing for Season...", "Getting To Know The User...","Finishing Off The Patriots..."};

    @FXML
    public ProgressBar progressBar;

    public void initialize() throws IOException {
        randomText.setText("");
    }

    class bg_Thread implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 101; i++){

                progressBar.setProgress(i / 100.0);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                App.setRoot("primary");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void startProgressBar() {
        startButton.setVisible(false);
        progressBar.setProgress(0);
        x = (int)(Math.random()*10);
        randomText.setText(textek[x]);
        Thread th = new Thread(new bg_Thread());
        th.start();
    }
}
