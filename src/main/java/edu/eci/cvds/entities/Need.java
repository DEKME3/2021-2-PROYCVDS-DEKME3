package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Need implements Serializable{
	private int id;
	private String name;
	private Category category;
	private String description;
	private Date creationDate;
	private String status;
	private Date modificationDate;
	private String urgency;
	private User usuario;
	
	public Need(String name,  String description , Date creationDate, String status, Date modificationDate , String urgency) {
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.status = status;
		this.modificationDate = modificationDate;
		this.urgency = urgency;
	}
	
	public Need(int id, String name,  String description , Date creationDate, String status, Date modificationDate , String urgency) {
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.status = status;
		this.modificationDate = modificationDate;
		this.urgency = urgency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
    @Override
    public String toString() {
        return "Need{id=" + id + " name=" + name + " category=" + category + " description=" + description + " creation Date=" + creationDate + "status= " + status  + "modification Date= " + modificationDate +  "urgency= " + urgency +" }";
    }
}
