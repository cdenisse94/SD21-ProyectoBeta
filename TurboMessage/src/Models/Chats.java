package Models;

import java.util.Scanner;

public class Chats {

    Login login;

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
                //firstContact(); //Si se da clic en el boton de nuevo chat, se abre la ventana NewChat, que tiene de controlador NewChat
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

    //Ver las solicitudes pendientes
    public void pendingRequest(){

    }

    //Ver todos los mensajes pendientes
    public void seeMSG(){
    }

}
