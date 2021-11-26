package edu.eci.cvds.services.impl;

import java.util.ArrayList;

import com.google.inject.Inject;
import edu.eci.cvds.Persistence.NeedDao;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.NeedServices;

public class NeedServicesImpl implements NeedServices{
	
	@Inject
    private NeedDao needDao;
	
	@Override
	public void insertNeed(Need need, int categoryId, int userId) throws ExcepcionesSolidaridad{
		needDao.insertNeed(need, categoryId, userId);
	}

	@Override
	public int getTotalNeedsOfUser(int id) throws ExcepcionesSolidaridad{
		return needDao.getTotalNeedsOfUser(id);
	}

	@Override
	public void ActualizarNeed(int id, String status) throws ExcepcionesSolidaridad{
		needDao.ActualizarNeed(id, status);
	}

	@Override
	public ArrayList<Need> getNeedsResult(int usuario) throws ExcepcionesSolidaridad{
		return needDao.getNeedsResult(usuario);
	}

	@Override
	public int getIdUserByNeed(int id) throws ExcepcionesSolidaridad{
		return needDao.getIdUserByNeed(id);
	}

	@Override
	public ArrayList<Need> getNeeds() throws ExcepcionesSolidaridad {
		return needDao.getNeeds();
	}

	@Override
	public Need getNeed(int id) throws ExcepcionesSolidaridad {
		return needDao.getNeed(id);
	}

	@Override
	public int countCategories(int category) throws ExcepcionesSolidaridad {
		return needDao.countCategories(category);
	}

	@Override
	public ArrayList<Need> getNeedsReporte() throws ExcepcionesSolidaridad {
		return needDao.getNeedsReporte();
	}

}
