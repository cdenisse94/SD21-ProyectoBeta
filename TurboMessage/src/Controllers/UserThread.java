package Controllers;

import java.util.ArrayList;
import java.util.List;

public class UserThread extends Thread {

    private String id;
    private List<UserThread> subscription = new ArrayList<UserThread>();

    public UserThread(String id) {
        this.id = id;
    }

    public List<UserThread> getSubscription(){
        return subscription;
    }

    public boolean addSubcription(String id){
        subscription.add(new UserThread(id));
        return true;
    }

    public void run(){
        System.out.println("Thread con ID: " + id);
    }
}
