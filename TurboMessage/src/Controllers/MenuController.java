package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jsmTurboMessage.FirstMSG;

import java.util.Scanner;

public class MenuController {

    public TextField tfIDChat = new TextField();
    public ComboBox cbContacto = new ComboBox();
    public Button btMensaje;
    public TextArea taNuevoMens;
    public TextArea taMensajes;
    private UserThread user;

    //INTER GRAF

    public void btMensajeClick(ActionEvent actionEvent) throws Exception {
        Parent pagina2 = FXMLLoader.load(getClass().getResource("mensaje.fxml"));
    }

    public void btBuscarClick(ActionEvent actionEvent) throws Exception {
        Parent pagina3 = FXMLLoader.load(getClass().getResource("menu.fxml"));
    }

    public void btEnviarClick(ActionEvent actionEvent) {

    }

    //BACK

    //Solicitar a un usuario que hablemos
    public void firstContact(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe el ID que quieres contactar");
        String exp = entrada.nextLine();

        int numUsuarioBuscar = Integer.parseInt(exp);
        FirstMSG primerMsj = new FirstMSG(Integer.parseInt(user.get_Id()),numUsuarioBuscar);
        primerMsj.produceMessages();
    }

    //Ver las solicitudes pendientes
    public void pendingRequest(){

    }

    //Ver todos los mensajes pendientes
    public void seeMSG(){
    }

    public void menu (){
        Scanner entrada =new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1 Hacer primer contacto");
        System.out.println("2 Ver mensajes pendientes");
        System.out.println("3 Ver solicitudes pendientes");
        System.out.println("4 Salir");
        String expresion = entrada.nextLine();

        switch (expresion){
            case "1":
                firstContact();
                break;
            case "2":
                System.out.println("mensajes pendientes");
                break;
            case "3":
                System.out.println("Solicitudes pendientes ");
                break;
            default :
                System.out.println("Salir");

                break;
        }
    }

    public static void main(String[] args) {
        MenuController m1 = new MenuController();

        String id = m1.user.get_Id();
        System.out.println("------");
        System.out.println(id);
    }

}
