package jsmTurboMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.filter.DestinationNode;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.Random;

public class MessageManagement {

    // @Resource(mappedName = "jms/TurboMessage")
    // private static ConnectionFactory connectionFactory;

    // private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public void startMessaging(){
        MessageProducer messageProducer = null;
        MessageConsumer messageConsumer = null;
        ObjectMessage objectMessage;

        id = Random.math();

        User us = new User(id.toString());

        try{
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connectionFactory.setTrustAllPackages(true);
            Connection connection = connectionFactory.createConnection();

            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            DestinationNode destination1 = session.createQueue(id.toString());
            // Pensar en como asignar resto de destinos





        } catch (JMSException e) {
            e.printStackTrace();
        }
    }





}
