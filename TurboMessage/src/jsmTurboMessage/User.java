package jsmTurboMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private String id;
    private List<User> subscription = new ArrayList<User>();

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<User> getSubscription(){
        return subscription;
    }

    public boolean addSubcription(String id){
        subscription.add(new User(id));
        return true;
    }
}
