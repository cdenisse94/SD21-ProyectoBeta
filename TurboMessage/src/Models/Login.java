package Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Login {

    public List<UserThread> userThreads = new ArrayList<>();

    public void addClient(UserThread user){
        userThreads.add(user);
        System.out.println("Total de usuarios: " + userThreads.size());
    }

    public String getUsuariosTotales() {
        String var = "";
        for(int x = 0 ; x<userThreads.size();x++){
            var = userThreads.get(x).getId() + " " + var ;
        }
        return var;
    }

    public void iniciaThread(String id) throws InterruptedException {
        UserThread newUser = new UserThread(id);
        addClient(newUser);
        newUser.start();
        Thread.sleep(1000);
    }

    //CREO QUE AUN NO JALA
    public boolean puedoAgregarId(String id){
        Iterator<UserThread> it = userThreads.iterator();
        while (it.hasNext()){
            UserThread user = it.next();
            if(user.get_Id() == id) {
                return (user.getEnLinea())? false: true;
            }
        }
        return true;
    }

}
