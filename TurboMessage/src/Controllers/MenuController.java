package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuController {

    public TextField tfIDChat = new TextField();
    public ComboBox cbContacto = new ComboBox();
    public Button btMensaje;
    public TextArea taNuevoMens;
    public TextArea taMensajes;

    public void btMensajeClick(ActionEvent actionEvent) throws Exception {
        Parent pagina2 = FXMLLoader.load(getClass().getResource("mensaje.fxml"));
    }

    public void btBuscarClick(ActionEvent actionEvent) throws Exception {
        Parent pagina3 = FXMLLoader.load(getClass().getResource("menu.fxml"));
    }

    public void btEnviarClick(ActionEvent actionEvent) {

    }
}
