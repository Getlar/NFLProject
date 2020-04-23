package org.ttbdlk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("The NFL Project");
        scene = new Scene(loadFXML("loadingScreen"), 1920, 1080);
        Color c = Color.rgb(1, 51, 105);
        scene.setFill(c);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.getIcons().add(new Image("logo.png"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void alertApp(Alert.AlertType alertType, String title, String header, String content) throws IOException {
        if (alertType == Alert.AlertType.CONFIRMATION){
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            Optional <ButtonType> action = alert.showAndWait();
            //noinspection OptionalGetWithoutIsPresent
            if (action.get() == ButtonType.OK){
                DAOImplementation connect = new DAOImplementation();
                connect.DbConnect();
                connect.deleteDreamTeam(header);
                App.setRoot("dreamTeam");
            }
        }else{
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        }
    }

    public static void main(String[] args) throws IOException {
        DAOImplementation connect = new DAOImplementation();
        connect.DbConnect();
        launch();
    }
}