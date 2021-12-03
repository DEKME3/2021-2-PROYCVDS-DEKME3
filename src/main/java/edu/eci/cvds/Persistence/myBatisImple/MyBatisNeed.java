package edu.eci.cvds.Persistence.myBatisImple;


import java.util.ArrayList;
import java.util.Date;

import com.google.inject.Inject;
import edu.eci.cvds.Persistence.NeedDao;
import edu.eci.cvds.dao.mybatis.mappers.NeedMapper;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public class MyBatisNeed implements NeedDao{
	
    @Inject
    private NeedMapper needMappers;

	@Override
	public void insertNeed(Need need, int categoryId, int userId) throws ExcepcionesSolidaridad {
        try {
            if (!(need.getName().equals("") || need.getDescription().equals("") || need.getStatus().equals("") || categoryId == 0 || need.getUrgency().equals("") || userId == 0)) {
                need.setCreationDate(new Date());
                need.setModificationDate(new Date());
                needMappers.insertNeed(need, categoryId, userId); 
            } else {
                throw new ExcepcionesSolidaridad("No se logro crear la nueva Necesidad");
            }
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro crear la nueva Necesidad", e);
        }
	}

	@Override
	public int getTotalNeedsOfUser(int id) throws ExcepcionesSolidaridad {
        try {
        	return needMappers.getTotalNeedsOfUser(id);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener el total de las necesidades", e);
        }
	}

	@Override
	public void ActualizarNeed(int id, String status) throws ExcepcionesSolidaridad {
        try {
            if (!(id == 0 || status.equals(""))) {
                needMappers.ActualizarNeed(id, status);   
            } else {
                throw new ExcepcionesSolidaridad("No se logro actuañizar la necedidad con id: "+ id);
            }
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro actuañizar la necedidad con id: "+ id, e);
        }
	}

	@Override
	public ArrayList<Need> getNeedsResult(int usuario) throws ExcepcionesSolidaridad {
        try {
        	return needMappers.getNeedsResult(usuario);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener las necesidades del usuario: "+ usuario, e);
        }
	}

	@Override
	public int getIdUserByNeed(int id) throws ExcepcionesSolidaridad {
        try {
        	return needMappers.getIdUserByNeed(id);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener el id del usuario dado el id de la necesidad: : "+ id, e);
        }
	}

    @Override
    public ArrayList<Need> getNeeds() throws ExcepcionesSolidaridad {
        return needMappers.getNeeds();
    }

    @Override
    public Need getNeed(int id) throws ExcepcionesSolidaridad {
        return needMappers.getNeed(id);
    }

    @Override
    public int countCategories(int category) throws ExcepcionesSolidaridad {
        return needMappers.countCategories(category);
    }

	@Override
	public ArrayList<Need> getNeedsReporte() throws ExcepcionesSolidaridad {
		return needMappers.getNeedsReporte();
	}
    


}
