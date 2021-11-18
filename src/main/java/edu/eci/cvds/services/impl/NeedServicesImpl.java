package edu.eci.cvds.services.impl;

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
	public Need getNeedsResult(String usuario) throws ExcepcionesSolidaridad{
		return needDao.getNeedsResult(usuario);
	}

	@Override
	public int getIdUserByNeed(int id) throws ExcepcionesSolidaridad{
		return needDao.getIdUserByNeed(id);
	}

}
