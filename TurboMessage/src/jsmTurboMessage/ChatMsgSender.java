/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsmTurboMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ChatMsgSender {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; // creo la conexión por defecto de activemq
    private static String subject;
    private static String subject2;
    private static String id ;
    private static String idNuevoContacto ;
    private static String mensaje;

    public ChatMsgSender(String id, String idContacto,String mensaje) {
        this.id = id;
        this.idNuevoContacto = idContacto;
        this.subject = id +"ChatCon"+idContacto;
        this.subject2 = idContacto +"ChatCon"+id;
        this.mensaje = mensaje;
    }

    public void produceMessages() {
        MessageProducer messageProducer;
        MessageConsumer messageConsumer ;
        TextMessage textMessage;

        try {
            //Creamos una conexion
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            //Enlazamos la conexion
            Connection connection = connectionFactory.createConnection();
            //Corremos la conexion
            connection.start();

            //Iniciamos sesion
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);

            // -------------------------------------------------------------------------------------------

            //Genero el recurso fisico COLA yo --> otro
            Destination destination = session.createQueue(subject);

            //EL producer es el que consume el servicio, en este caso debemos de crear tantos como el usuario tenga contactos
            //TODOS LOS MENSAJES SON PARA ESE DESTINO
            messageProducer = session.createProducer(destination);
            // -------------------------------------------------------------------------------------------

            // -------------------------------------------------------------------------------------------

            Destination destination2 = session.createQueue(subject2);
            messageConsumer = session.createConsumer(destination2);

            // -------------------------------------------------------------------------------------------


            //Solo mandamos el ID del usuario
            textMessage = session.createTextMessage();
            textMessage.setText(mensaje);
            System.out.println("Mensaje enviado: " + textMessage.getText());
            messageProducer.send(textMessage);
            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
