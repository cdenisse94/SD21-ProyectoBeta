package Models;

import java.util.ArrayList;
import java.util.List;

public class UserThread extends Thread {

    private String id;
    private Boolean enLinea = true;
    private List<UserThread> subscription = new ArrayList<>();

    public UserThread(String id){ this.id = id; }

    public List<UserThread> getSubscription(){
        return subscription;
    }

    public void addSubcription(String id){ subscription.add(new UserThread(id)); }

    public boolean getEnLinea(){ return this.enLinea; }

    public void setEnLinea(Boolean linea){ this.enLinea = linea; }

    public String get_Id() {
        return id;
    }

    public void run(){
        System.out.println("Thread con ID: " + id);
    }
}
