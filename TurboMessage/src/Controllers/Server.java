package Controllers;

import java.util.ArrayList;
import java.util.List;

public class Server {

    List<UserThread> userThreads = new ArrayList<>();

    public void addClient(String id){
        userThreads.add(new UserThread(id));
        System.out.println("Total de usuarios: " + userThreads.size());
    }

    public String getUsuariosTotales() {
        String var = "";
        for(int x = 0 ; x<userThreads.size();x++){
            var = userThreads.get(x).getId() + " " + var ;
        }
        return var;
    }

}
