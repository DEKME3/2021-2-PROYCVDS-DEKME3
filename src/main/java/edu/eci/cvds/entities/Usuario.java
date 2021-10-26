package edu.eci.cvds.entities;

import java.io.Serializable;

public class Usuario implements Serializable{
    private int id;
    private String name;
    private String password;
    private String email;
    private boolean status;
    private UserType userType;
}
