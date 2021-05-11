package jsmTurboMessage;

import Models.Msg;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class FirstMsgReciever {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String Myid ; // no se si este es el del otro
    private static String idNewContact ; // y este es mio
    private boolean respuesta; // esta el usuario tendra que decir si acepta o no la solicitud

    public FirstMsgReciever(String idNewContact, String Myid,boolean respuesta) {
        this.idNewContact = idNewContact;
        this.Myid = Myid;
        this.respuesta = respuesta;
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

            Destination destination1 = session.createQueue(idNewContact+"To"+Myid);
            Destination destination2 = session.createQueue(Myid+"To"+idNewContact);

            messageConsumer = session.createConsumer(destination1);
            messageProducer = session.createProducer(destination2);

            objectMessage = session.createObjectMessage();

            Msg mensaje = null ;
            if(respuesta){
                mensaje = new Msg(idNewContact,"si");
                //lo agrego a mi lista de amigos
            }else{
                mensaje = new Msg(idNewContact,"no");
            }

            objectMessage.setObject(mensaje);
            messageProducer.send(objectMessage);

            /*
            boolean stillOnTheAir = true;
            while (stillOnTheAir){
                Potato potato;
                System.out.println("Waiting for potatoes...");

                potato = (Potato) ((ObjectMessage) messageConsumer.receive()).getObject();

                if(potato != null){
                    System.out.println("I got potato " + potato.getId() + " from my neighbor");
                    System.out.println();

                    if(potato.isDropped()){
                        System.out.println("I lost! >:c I dropped potato " + potato.getId());
                        stillOnTheAir = false;
                    } else {
                        potato.decreaseRemainingTime();
                        System.out.println("Sending back potato " + potato.getId());
                        objectMessage = session.createObjectMessage();
                        objectMessage.setObject(potato);
                        messageProducer.send(objectMessage);
                    }
                }
            }*/

            messageProducer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    //public static void main(String[] args){ new Player2().playPotatoGame(); }
}
