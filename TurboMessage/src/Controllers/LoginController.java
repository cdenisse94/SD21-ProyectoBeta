package Controllers;

import Models.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    Login login = new Login();
    InterfaceController chats;

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
        } else if(login.puedoAgregarId(id)){
            login.iniciaThread(id);
            ventanaChats(id);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sesión iniciada");
            alert.setHeaderText("Usuario ya tiene la sesión iniciada");
            tfID.requestFocus();
            alert.showAndWait();
        }
    }

    public void ventanaChats(String id) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("../Views/Chats.fxml"));
        Scene secondScene = new Scene(root, 600, 400);
        Stage secondStage = new Stage();
        secondStage.setTitle(id);
        secondStage.setScene(secondScene);
        secondStage.show();
    }

}