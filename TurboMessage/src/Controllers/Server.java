package Controllers;

import java.util.ArrayList;
import java.util.List;

public class Server {

    List<UserThread> userThreads = new ArrayList<>();

    public void addClient(String id){
        userThreads.add(new UserThread(id));
        System.out.println("Total de usuarios: " + userThreads.size());
    }

}
