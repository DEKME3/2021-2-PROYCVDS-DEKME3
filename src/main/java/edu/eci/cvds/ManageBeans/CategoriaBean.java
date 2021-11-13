package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.ServicesFactory;


@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "categoryBean")
public class CategoriaBean {

    private int updateId;
    private String name;
    private String description;
    private String status;
    private String newName;
    private String newDescription;
    private String newStatus;
    private Date creationDate;
    private Date modificationDate;
    private List<Category> categories = new ArrayList<>();
    private CategoryServices categoryServices = ServicesFactory.getInstance().getCategoryServices();

    public CategoriaBean() {
    }

    @PostConstruct
    public void loadCategories(){
        ArrayList<Category> categoryList;
        try {
            categoryList = categoryServices.getCategories();
            categories.addAll(categoryList);
        } catch (ExcepcionesSolidaridad e) {
            e.printStackTrace();
        }
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
        try {
            categoryServices.InsertCategory(newCategory);
            categories.clear();
            loadCategories();
        } catch (ExcepcionesSolidaridad e) {
            System.out.println("No se pudo insertar la categoria" + e.toString());
        }
    }

    public void updateCategory(){
        try {
            categoryServices.ActualizarCategory(updateId, newName, newDescription, newStatus);
            categories.clear();
            loadCategories();
        } catch (ExcepcionesSolidaridad e) {
            System.out.println("No se pudo actualizar la categoria" + e.toString());
        }
    }
}