package jsmTurboMessage;

import Models.Msg;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class FirstMsgSender {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; // no se si va en el constructor
    private static String Myid ;
    private static String idNewContact ;


    public FirstMsgSender(String Myid, String idNewContact) {
        this.Myid = Myid;
        this.idNewContact = idNewContact;
    }

    public void send(){
        MessageProducer messageProducer = null;
        MessageConsumer messageConsumer = null;
        ObjectMessage objectMessage;

        try{
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connectionFactory.setTrustAllPackages(true);
            Connection connection = connectionFactory.createConnection();

            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination1 = session.createQueue(Myid+"To"+idNewContact);
            Destination destination2 = session.createQueue(idNewContact+"To"+Myid);

            messageConsumer = session.createConsumer(destination1);
            messageProducer = session.createProducer(destination2);

            objectMessage = session.createObjectMessage();

            Msg mensaje = new Msg(Myid,"");

            System.out.println("Sending for the ve ry first time my potato " + mensaje.getId());
            objectMessage.setObject(mensaje);
            messageProducer.send(objectMessage);

            boolean waiting = true;
            while (waiting){
                Msg respuesta;
                System.out.println("Esperando respuesta");

                respuesta = (Msg) ((ObjectMessage) messageConsumer.receive()).getObject();

                if(respuesta != null){
                    System.out.println("Tengo una respuesta");
                    if(respuesta.getMensaje() == "si"){
                        System.out.println("Si quiso hacer contacto conmigo lo agrego a mi lista");
                    }else{
                        System.out.println("No quiso agregarme SAD");
                    }
                }
            }

            messageProducer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    //public static void main(String[] args){ new Player().playPotatoGame(); }
}
