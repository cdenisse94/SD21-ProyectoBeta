/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsmTurboMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class FirstMSG {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; // creo la conexión por defecto de activemq
    private static String subject;
    private static String subject2;
    private static int id ;
    private static int idContacto ;

    public FirstMSG(int id, int idContacto) {
        this.id = id;
        this.idContacto = idContacto;
        this.subject = id +"PendienteCon"+idContacto;
        //this.subject = "DeUsuario"+id+"_ParaContacto"+idContacto ;
        this.subject2 = "DeUsuario"+idContacto+"_ParaContacto"+id ;
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
            //Es transparente, no importa si aun no ha sido creada o ya fue creada
            Destination destination = session.createQueue(subject);

            //EL producer es el que consume el servicio, en este caso debemos de crear tantos como el usuario tenga contactos
            //TODOS LOS MENSAJES SON PARA ESE DESTINO
            messageProducer = session.createProducer(destination);
            // -------------------------------------------------------------------------------------------

            // -------------------------------------------------------------------------------------------

            //Destination destination2 = session.createQueue(subject2);
            //messageConsumer = session.createConsumer(destination2);

            // -------------------------------------------------------------------------------------------


            //Creamos mensaje
            textMessage = session.createTextMessage();

            textMessage.setText("Hola! soy el contacto: ");
            System.out.println("Mensaje enviado: " + textMessage.getText());
            messageProducer.send(textMessage);


            textMessage.setText(String.valueOf(+id));
            System.out.println("Mensaje enviado: " + textMessage.getText());
            messageProducer.send(textMessage);

            textMessage.setText("¿Te gustaria hacer contacto conmigo? (S/N)");
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
