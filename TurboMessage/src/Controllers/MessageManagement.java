package Controllers;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageManagement {

    // @Resource(mappedName = "jms/TurboMessage")
    // private static ConnectionFactory connectionFactory;

    private boolean inicio;
    Destination destination1, destination2;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public void startMessaging(){

        //id = Random.math();

        //User us = new User(id.toString());

        try{
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connectionFactory.setTrustAllPackages(true);
            Connection connection = connectionFactory.createConnection();

            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination2);
            ObjectMessage ObjMessage = session.createObjectMessage();

            Session sessionr = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer messageConsumer = sessionr.createConsumer(destination1);

            //DestinationNode destination1 = session.createQueue(id.toString());
            // Pensar en como asignar resto de destinos





        } catch (JMSException e) {
            e.printStackTrace();
        }
    }





}
