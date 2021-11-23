package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{
    private int id;
    private String name;
    private String description;
    private Date creationDate;
    private String status;
    private Date modificationDate;
    private int cantidadOfertas;
    private int cantidadNecesidades;
    private int totalOfertasNecesidades;

    public Category(String name, String description, Date creationDate, String status, Date modification){
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.modificationDate = modification;
    }

    public Category(int id, String name, String description, Date creationDate, String status, Date modificationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.modificationDate = modificationDate;
    }

    public Category() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setCantidadNecesidades(int cantidadNecesidades) {
        this.cantidadNecesidades = cantidadNecesidades;
    }

    public void setCantidadOfertas(int cantidadOfertas) {
        this.cantidadOfertas = cantidadOfertas;
    }

    public void setTotalOfertasNecesidades(int totalOfertasNecesidades) {
        this.totalOfertasNecesidades = totalOfertasNecesidades;
    }

    public int getTotalOfertasNecesidades() {
        return totalOfertasNecesidades;
    }

    public int getCantidadNecesidades() {
        return cantidadNecesidades;
    }

    public int getCantidadOfertas() {
        return cantidadOfertas;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getStatus() {
        return status;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    @Override
    public String toString() {
        return name;
    }
}