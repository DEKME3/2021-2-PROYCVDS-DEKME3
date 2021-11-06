package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.services.client.MyBatisPrueba;



@SessionScoped
@ManagedBean(name = "categoryBean")
public class CategoriaBean {

    public int updateId;
    public String name;
    public String description;
    public String status;
    public String newName;
    public String newDescription;
    public String newStatus;
    public Date creationDate;
    public Date modificationDate;
    public static List<Category> categories = new ArrayList<>();

    public CategoriaBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
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

    public List<Category> getCategories() {
        return categories;
    }

    public String getNewName() {
        return newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void insertCategory(){
        Category newCategory = new Category(name, description, new Date(), status, new Date());
        MyBatisPrueba.insertarCategoria(newCategory);
        categories.add(newCategory);
    }

    public void updateCategory(){
        MyBatisPrueba.updateCategoria(updateId, newName, newDescription, newStatus);
    }
}
