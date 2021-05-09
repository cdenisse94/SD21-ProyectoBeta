/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsmTurboMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; // creo la conexión por defecto de activemq
    private static String subject;
    private static int id ;
    private static int idContacto ;

    public MessageSender(int id, int idContacto) {
        this.id = id;
        this.idContacto = idContacto;
        this.subject = "Usuario"+id+"Contacto"+idContacto ;
    }

    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;
        try {

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);// creamos la conection factory
            Connection connection = connectionFactory.createConnection(); //establezco
            connection.start(); //corro la conexion

            //Nosotros no vemos el acknowledge es automático
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);


            Destination destination = session.createQueue(subject); // Termino genero de la cola recurso físico cola
            // es transparente, no importa si aún no ha sido creada o ya activeMQ se encarga de eso

            //EL producer es el que consume el servicio, en este caso debemos de crear tantos como el usuario tenga contactos
            //TODOS LOS MENSAJES SON PARA ESE DESTINO
            messageProducer = session.createProducer(destination);

            //Creamos mensaje
            textMessage = session.createTextMessage();

            textMessage.setText("Hola! soy el contacto 1");
            System.out.println("Mensaje enviado: " + textMessage.getText());
            messageProducer.send(textMessage);

            textMessage.setText("¿Te gustaria hacer contacto conmigo?");
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
