package jsmTurboMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.filter.DestinationNode;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageManagement {
    private int id = 0 ;
    private List<User> usuariosTotales = new ArrayList<User>();


    public void startMessaging() {
        MessageProducer messageProducer = null;
        MessageConsumer messageConsumer = null;
        ObjectMessage objectMessage;

        //id = Random.math();

        //User us = new User(id.toString());

        //ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //connectionFactory.setTrustAllPackages(true);
        //Connection connection = connectionFactory.createConnection();

        //connection.start();
        int i = 0 ;
        //Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //DestinationNode destination1 = session.createQueue(id.toString());
        // Pensar en como asignar resto de destinos


    }

    public void registrar_usuario(){
        id = id + 1;
        User u = new User(id);
        usuariosTotales.add(u);
    }

    public String getUsuariosTotales() {
        String var = "";
        for(int x = 0 ; x<usuariosTotales.size();x++){
            var = usuariosTotales.get(x).getId() + " " + var ;
        }
        return var;
    }

    public void hacercontacto(int numUsuarioBuscar){

        // AQUI VAMOS A SUPONER QUE YO YA TENGO MI CUENTA INICIADA Y SOLO ESTOY BUSCANDO EL NUMUSUARIO

        MessageSender primerMsj = new MessageSender(1,numUsuarioBuscar);
        primerMsj.produceMessages();

    }

    public static void main(String[] args) {
        MessageManagement m1 = new MessageManagement();
        m1.registrar_usuario();
        m1.registrar_usuario();
        m1.registrar_usuario();
        System.out.println(m1.getUsuariosTotales());
        System.out.println("---------");
        m1.hacercontacto(3);
    }


}
