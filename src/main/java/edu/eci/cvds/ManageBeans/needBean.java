package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.client.MyBatisPrueba;

@SessionScoped
@ManagedBean(name = "needBean")
public class needBean {

	private String name;
	private Category category;
	private String description;
	private Date creationDate;
	private String status;
	private Date modificationDate;
	private String urgency;
	private User usuario;
	public static List<Need> needs = new ArrayList<>();

	public needBean() {

	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
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

	public List<Need> getNeeds() {
		return needs;
	}

	public void setNeeds(List<Need> needs) {
		needBean.needs = needs;
	}
	
    public void insertNeed(){
        Need newNeed = new Need(name, description, new Date(), status, new Date() , urgency);
        MyBatisPrueba.insertarNecesidad(newNeed, 3, 2);
        needs.add(newNeed);
    }
}