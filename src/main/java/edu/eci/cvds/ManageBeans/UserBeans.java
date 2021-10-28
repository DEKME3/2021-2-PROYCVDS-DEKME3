package edu.eci.cvds.manageBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "UserBean")
@SessionScoped
public class UserBean {

    private String name;
    private String password;




}