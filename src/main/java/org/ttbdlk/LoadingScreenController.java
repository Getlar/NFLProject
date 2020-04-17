package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class LoadingScreenController {

    @FXML
    public ProgressBar progressBar;

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
    void startProgressBar(ActionEvent event) {
        progressBar.setProgress(0);
        Thread th = new Thread(new bg_Thread());
        th.start();
    }
}
