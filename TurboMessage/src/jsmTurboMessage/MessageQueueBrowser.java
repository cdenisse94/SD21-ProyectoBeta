/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsmTurboMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Enumeration;

public class MessageQueueBrowser {

    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    private static String subject = "Usuario_A_Cola";

    public void browseMessages() {
        try {

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(subject);

            //DE MI COLA OBTENGO EL BROWSER (UNA EXTENSION UNO A UNO) DE MI COLA
            QueueBrowser browser = session.createBrowser((Queue) destination);
            Enumeration messageEnumeration = browser.getEnumeration();
            if (messageEnumeration != null) { //SI NO ENTRA ES QUE LA COLA NO EXISTE
                if (!messageEnumeration.hasMoreElements()) { //NO TIENE ELEMENTOS LA COLA
                    System.out.println("There are no messages " + "in the queue.");
                } else {
                    System.out.println("The following messages are in the queue:");
                    while (messageEnumeration.hasMoreElements()) { //RECORREMOS LA COLA DE MENSAJES
                        TextMessage textMessage = (TextMessage) messageEnumeration.nextElement();
                        System.out.println(textMessage.getText());
                    }
                }
            }
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageQueueBrowser().browseMessages();
    }
}
