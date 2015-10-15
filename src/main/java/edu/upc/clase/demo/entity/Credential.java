package edu.upc.clase.demo.entity;

import java.io.Serializable;

/**
 *
 * @author gian
 */
public class Credential implements Serializable {
    private String correo;
    private String password;

    public Credential() {}

    public Credential(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }        
}
