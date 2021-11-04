package edu.eci.cvds.ManageBeans;

import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;

import org.apache.commons.collections4.Get;

import edu.eci.cvds.entities.Category;

import javax.faces.bean.ManagedBean;

@SessionScoped
@ManagedBean(name = "categoryBean")
public class CategoriaBean {
    public String name;
    public String description;
    public String status;
    public Date creationDate;
    public Date modificationDate;

    public CategoriaBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void insertCategory(){
        Category newCategory = new Category(name, description, new Date(), status, new Date());
    }
}
