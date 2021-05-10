package jsmTurboMessage;
import java.util.Iterator;
import java.util.Scanner;


public class Sesion {
    private static TurboMSG sistema = new TurboMSG();
    private User user;

    public Sesion(User user) {
        this.user = user;
    }

    public void hacercontacto(){
        // AQUI VAMOS A SUPONER QUE YO YA TENGO MI CUENTA INICIADA Y SOLO ESTOY BUSCANDO EL NUMUSUARIO
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe el ID que quieres contactar");
        String exp = entrada.nextLine();
        int numUsuarioBuscar = Integer.parseInt(exp);
        FirstMSG primerMsj = new FirstMSG(user.getId(),numUsuarioBuscar);
        primerMsj.produceMessages();
    }

    public boolean iniciarSesion(int id){
        boolean res = false ;
        User usuariochiquito = new User(id);
        Iterator<User> it = sistema.usuariosTotales.iterator();
        while(it.hasNext()){
            User userTemp = it.next();
            if(userTemp.getId() == usuariochiquito.getId()){
                res=false;
            }
            else{
                res = true;
            }
        }
        return res;
    }

    public void solicitudespendientes(){

    }

    public void verMensajes(){

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
                hacercontacto();
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


        Scanner entrada =new Scanner(System.in);
        System.out.println("1 Darte de alta");
        System.out.println("2 Iniciar sesion");

        String opcion = entrada.nextLine();
        System.out.println("------"+opcion  );
        if(opcion.equals("1")){
            System.out.println("Tu id es: ");
            User us = sistema.registrar_usuario();
            System.out.println(us.getId());
            Sesion s1 = new Sesion(us);
            s1.menu();
        }else{
            if(opcion.equals("2")){
                System.out.println("Escribe tu ID:");
                String idLog = entrada.nextLine();
                User us = sistema.login(Integer.parseInt(idLog));
                if(us != null){
                    System.out.println("Bienvenido");
                    Sesion s1 = new Sesion(us);
                    s1.menu();
                }else{
                    System.out.println("No se encontro su registro");
                }
            }else{
                System.out.println("Salimos del programa");

            }

        }
        //User user = new User(Integer.parseInt(id));

        //Sesion sesionPrincipal = new Sesion(user);
        //sesionPrincipal.hacercontacto(3);

    }


}
