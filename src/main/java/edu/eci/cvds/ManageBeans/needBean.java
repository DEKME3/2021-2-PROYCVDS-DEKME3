package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.ServicesFactory;
import edu.eci.cvds.services.UserServices;


@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "needBean")
public class needBean {

	private int idNeed;
	private String name;
	private String category;
	private String description;
	private Date creationDate;
	private String status;
	private String updateStatus;
	private Date modificationDate;
	private String urgency;
	private int usuario;
	private String nombreCategoria;
	private List<Need> needs = new ArrayList<>();
	private List<Category> categorias = new ArrayList<>();
	private String nombreUsuarioLogin;
	private int idUserLogin;
	private int idUserTypeLogin;
	private UserServices userServices = ServicesFactory.getInstance().getUserServices();
	private NeedServices needServices = ServicesFactory.getInstance().getNeedServices();
	private CategoryServices categoryServices = ServicesFactory.getInstance().getCategoryServices();


	public needBean() {
		
	}

	@PostConstruct
    public void loadNeeds(){
        ArrayList<Need> needList;
        ArrayList<Category> categoriesList;
        try {
            needList = needServices.getNeeds();
			needs.clear();
            needs.addAll(needList);
            categoriesList = categoryServices.getCategories();
            categorias.addAll(categoriesList);
        } catch (ExcepcionesSolidaridad e) {
            e.printStackTrace();
        }
    }
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	public void setIdNeed(int idNeed) {
		this.idNeed = idNeed;
	}

	public int getIdNeed() {
		return idNeed;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
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
		this.needs = needs;
	}

	public void setCategorias(List<Category> categorias) {
		this.categorias = categorias;
	}
	
	public String getNombreUsuarioLogin() {
		return nombreUsuarioLogin;
	}

	public void setNombreUsuarioLogin(String nombreUsuarioLogin) {
		this.nombreUsuarioLogin = nombreUsuarioLogin;
	}

	public int getIdUserLogin() {
		return idUserLogin;
	}

	public List<Category> getCategorias() {
		return categorias;
	}

	public void setIdUserLogin(int idUserLogin) {
		this.idUserLogin = idUserLogin;
	}

	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}

	public String getUpdateStatus() {
		return updateStatus;
	}

	public int getIdUserTypeLogin() {
		return idUserTypeLogin;
	}

	public void setIdUserTypeLogin(int idUserType) {
		this.idUserTypeLogin = idUserType;
	}
	
	private void obtnerDatosUsuario() throws ExcepcionesSolidaridad {
		Subject currentUser = SecurityUtils.getSubject();
		setNombreUsuarioLogin((String) currentUser.getSession().getAttribute("Nombre"));
		setIdUserLogin(userServices.getIdUserByName(getNombreUsuarioLogin()));
		setIdUserTypeLogin(userServices.getIdUserTypeByIdUser(getIdUserLogin()));
	}
		
    public void insertNeed() throws ExcepcionesSolidaridad{
    	obtnerDatosUsuario();
        int totalNecesidades = needServices.getTotalNeedsOfUser(getIdUserLogin());
        int necesidadesUsuario = userServices.getNumero_necesidades(getIdUserLogin());
		int idCategoria = categoryServices.getCategoryIdByName(category);
    	if((totalNecesidades < necesidadesUsuario) && getIdUserTypeLogin() == 2) {
    		setCreationDate(new Date());
    		setModificationDate(new Date());
	        Need newNeed = new Need(name, description, new Date(), getStatus(), new Date() , urgency);
	        needServices.insertNeed(newNeed, idCategoria, idUserLogin);
	        needs.clear();
			loadNeeds();
    	}
    }

    public void updateNeed() throws ExcepcionesSolidaridad{
    	obtnerDatosUsuario();
    	boolean banderaUpdate = false;
		if(getIdUserTypeLogin() == 2 && (needServices.getIdUserByNeed(getIdNeed()) == getIdUserLogin() )) {
			banderaUpdate = true;
		}
		if(getIdUserTypeLogin() == 1) {
			banderaUpdate = true;
    	}
    	if(banderaUpdate) {
    		needServices.ActualizarNeed(idNeed, updateStatus);
			needs.clear();
			loadNeeds();
    	}

    }
    
    public void buscarPorUsuario(){
		try {
			obtnerDatosUsuario();
			ArrayList<Need> busquedaNecesidades = needServices.getNeedsResult(idUserLogin);
			needs.clear();
			needs.addAll(busquedaNecesidades);
		} catch (ExcepcionesSolidaridad e) {
			e.printStackTrace();
		}
	}

}