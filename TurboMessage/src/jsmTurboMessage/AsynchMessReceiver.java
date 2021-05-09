/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsmTurboMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AsynchMessReceiver {

    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    //consume TODOS LOS MENSAJES DE
    private static String subject = "Usuario1Contacto3";

    public void getMessages() {

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(subject);

            //COLA 1
            MessageConsumer messageConsumer = session.createConsumer(destination);
            //ESTE METODO NOS PERMTE COLGARLE EL HILO
            messageConsumer.setMessageListener(new ExampleMessageListener());

            //COLA 2
            //MessageConsumer messageConsumer = session.createConsumer(destination);
            //ESTE METODO NOS PERMTE COLGARLE EL HILO
            //messageConsumer.setMessageListener(new ExampleMessageListener());


            connection.start();
            System.out.println("Our code does not have to block while messages are received.");
            Thread.sleep(30000);
            messageConsumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AsynchMessReceiver().getMessages();
    }

}
