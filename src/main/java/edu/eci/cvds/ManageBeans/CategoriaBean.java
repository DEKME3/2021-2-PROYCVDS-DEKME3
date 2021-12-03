package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.OfferServices;
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
    private String deleteName;
    private Date creationDate;
    private Date modificationDate;
    private List<Category> categories = new ArrayList<>();
    private List<Category> categoriesTable2 = new ArrayList<>();
    private BarChartModel barChartModel;
    private CategoryServices categoryServices = ServicesFactory.getInstance().getCategoryServices();
    private OfferServices ofertaServices = ServicesFactory.getInstance().getOfferServices();
    private NeedServices needServices = ServicesFactory.getInstance().getNeedServices();

    public CategoriaBean() {
    }

    @PostConstruct
    public void loadCategories(){
        ArrayList<Category> categoryList;
        try {
            categoryList = categoryServices.getCategories();
            categories.addAll(categoryList);
            loadTable2(categories);
            createBarModel();
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

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }

    public void setCategoriesTable2(List<Category> categoriesTable2) {
        this.categoriesTable2 = categoriesTable2;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public List<Category> getCategoriesTable2() {
        return categoriesTable2;
    }

    public String getDeleteName() {
        return deleteName;
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

    private void loadTable2(List<Category> categories){
        categoriesTable2.clear();
        for (Category category : categories) {
            Category categoryInformation = new Category();
            categoryInformation.setName(category.getName());
            try {
                categoryInformation.setCantidadNecesidades(needServices.countCategories(category.getId()));
                categoryInformation.setCantidadOfertas(ofertaServices.countCategories(category.getId()));
                categoryInformation.setTotalOfertasNecesidades(categoryInformation.getCantidadNecesidades() + categoryInformation.getCantidadOfertas());
            } catch (ExcepcionesSolidaridad e) {
                e.printStackTrace();
            }
            categoriesTable2.add(categoryInformation);
        }
    }

    public void insertCategory(){
        Category newCategory = new Category(name, description, new Date(), status, new Date());
        try {
            if (categoryServices.validarCategory(name) == 0) {
                categoryServices.InsertCategory(newCategory);
                categories.clear();
                loadCategories();
                restartInsert();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoría registrada", "La categoría que creo ha sido registrada");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoría invalida", "Seleccione una categoría valida!");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        } catch (ExcepcionesSolidaridad e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo insertar la categoría");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }
    }

    public void updateCategory(){
        try {
            categoryServices.ActualizarCategory(updateId, newName, newDescription, newStatus);
            categories.clear();
            loadCategories();
            restartUpdate();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoría actualizada", "La categoría ha sido actualizada");
                PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (ExcepcionesSolidaridad e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo actualizar la categoría");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }
    }

    public void deleteCategory(){
        try {
            categoryServices.deleteCategory(deleteName);
            categories.clear();
            loadCategories();
            restartDelete();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoría eliminada", "La categoría ha sido eliminada");
                PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (ExcepcionesSolidaridad e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo eliminar la categoría");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }
    }

    private void createBarModel() {
        barChartModel = initBarModel();

        barChartModel.setTitle("Reporte Categorías");
        barChartModel.setLegendPosition("ne");

        Axis xAxis = barChartModel.getAxis(AxisType.X);
        xAxis.setLabel("Oferta/Necesidad");

        Axis yAxis = barChartModel.getAxis(AxisType.Y);
        yAxis.setLabel("Número solicitudes");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries ofertas = new ChartSeries();
        ofertas.setLabel("Ofertas");
        for (Category categoryT : categoriesTable2) {
            ofertas.set(categoryT.getName(), categoryT.getCantidadOfertas());
        }

        ChartSeries necesidades = new ChartSeries();
        necesidades.setLabel("Necesidades");
        for (Category categoryT : categoriesTable2) {
            necesidades.set(categoryT.getName(), categoryT.getCantidadNecesidades());
        }

        model.addSeries(ofertas);
        model.addSeries(necesidades);

        return model;
    }

    private void restartInsert(){
        name = "";
        description = "";
        status = "";
    }

    private void restartUpdate(){
        updateId = 0;
        newName = "";
        newDescription = "";
        newStatus = "";
    }

    private void restartDelete(){
        deleteName = "";
    }
}