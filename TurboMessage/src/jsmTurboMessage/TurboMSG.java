package jsmTurboMessage;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

public class TurboMSG {
    private int id = 0 ;
    public List<User> usuariosTotales = new ArrayList<User>();
    private static Sesion sesionPrincipal ;

    public TurboMSG() {
        this.id = id;
        this.usuariosTotales = usuariosTotales;
        registrar_usuario();
        registrar_usuario();
        registrar_usuario();
    }

    public User registrar_usuario(){
        id = id + 1;
        User u = new User(id);
        usuariosTotales.add(u);

        return usuariosTotales.get((id-1));
    }

    public String getUsuariosTotales() {
        String var = "";
        for(int x = 0 ; x<usuariosTotales.size();x++){
            var = usuariosTotales.get(x).getId() + " " + var ;
        }
        return var;
    }

    public User login (int id){
        if(id <= usuariosTotales.size()){
            return usuariosTotales.get((id-1));
        }else{
            return null ;
        }

    }

    public static void main(String[] args) {
        /*
        TurboMSG m1 = new TurboMSG();
        m1.registrar_usuario();
        m1.registrar_usuario();
        m1.registrar_usuario();
        System.out.println(m1.getUsuariosTotales());
        System.out.println("---------");
        System.out.println(m1.iniciarSesion(2));
        if(m1.iniciarSesion(2)){
            sesionPrincipal.hacercontacto(3);
        }

         */
    }

}
