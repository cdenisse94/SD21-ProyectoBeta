package Models;

import jsmTurboMessage.ChatMsgSender;
import jsmTurboMessage.FirstMsgReciever;
import jsmTurboMessage.FirstMsgSender;

public class Interface {

    private UserThread user;
    Login login;

    //Enviar mensaje a contacto
    public void sendmsg(String contacto,String mensaje){
        ChatMsgSender msj = new ChatMsgSender(user.get_Id(),contacto,mensaje);
        msj.produceMessages();
    }

    //enviar peticion
    public void solicitud (String idNuevousuario){
        FirstMsgSender primermsj = new FirstMsgSender(user.get_Id(),idNuevousuario);
        primermsj.send();
    }

    //contestar peticion
    public void responderSolicitud(String idNuevousuario, boolean res){
        FirstMsgReciever respondermsj = new FirstMsgReciever(user.get_Id(),idNuevousuario,res);
        respondermsj.send();

    }



}
