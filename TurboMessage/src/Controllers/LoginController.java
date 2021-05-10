package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    Server server = new Server();

    public TextField tfID = new TextField();
    @FXML
    private Button btEntrar = new Button();

    public void btEntrarClick(ActionEvent actionEvent) throws Exception {
        String id = tfID.getText();
        System.out.println("ID: [" + id + "]");

        if (id.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Id incorrecto");
            alert.setHeaderText("Identificador vacío");
            tfID.requestFocus();
            alert.showAndWait();
        } else{
            iniciaThread(id);
            ventanaMenu(id);
        }

    }

    public void iniciaThread(String id) throws InterruptedException {
        server.addClient(id);
        UserThread newUser = new UserThread(id);
        newUser.start();
        Thread.sleep(1000);
    }

    public void ventanaMenu(String id) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("../Views/menu.fxml"));
        Scene secondScene = new Scene(root, 600, 400);
        Stage secondStage = new Stage();
        secondStage.setTitle(id);
        secondStage.setScene(secondScene);
        secondStage.show();
    }

}