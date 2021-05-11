package Models;

import java.io.Serializable;

public class Msg implements Serializable {

    private String id;
    private String mensaje;

    public Msg(String id, String mensaje) {
        this.id = id;
        this.mensaje = mensaje;
    }

    public String getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }
}
