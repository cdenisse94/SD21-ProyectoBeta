package jsmTurboMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private int id;
    private List<User> subscription = new ArrayList<User>();

    public User(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<User> getSubscription() {
        return subscription;
    }

    public boolean addSubcription(int id) {
        subscription.add(new User(id));
        return true;
    }
}
