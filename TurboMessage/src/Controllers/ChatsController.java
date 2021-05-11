package Controllers;

import Models.UserThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jsmTurboMessage.FirstMSG;

import java.util.Scanner;

public class ChatsController {

    public TextField tfIDChat = new TextField();
    public ComboBox cbContacto = new ComboBox();
    public Button btMensaje;
    public TextArea taNuevoMens;
    public TextArea taMensajes;

    public void btMensajeClick(ActionEvent actionEvent) throws Exception {
        Parent pagina2 = FXMLLoader.load(getClass().getResource("NewChat.fxml"));
    }

    public void btBuscarClick(ActionEvent actionEvent) throws Exception {
        Parent pagina3 = FXMLLoader.load(getClass().getResource("Chats.fxml"));
    }

    public void btEnviarClick(ActionEvent actionEvent) {

    }

}
