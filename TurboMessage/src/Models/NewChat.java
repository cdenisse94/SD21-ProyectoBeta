package Models;

import jsmTurboMessage.FirstMSG;

import java.util.Scanner;

public class NewChat {

    private UserThread user;

    //Solicitar a un usuario que hablemos
    public void firstContact(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe el ID que quieres contactar");
        String exp = entrada.nextLine();

        int numUsuarioBuscar = Integer.parseInt(exp);
        FirstMSG primerMsj = new FirstMSG(Integer.parseInt(user.get_Id()),numUsuarioBuscar);
        primerMsj.produceMessages();
    }

}
