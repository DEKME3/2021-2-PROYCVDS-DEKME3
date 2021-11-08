package edu.eci.cvds.Persistence.myBatisImple;


import com.google.inject.Inject;
import edu.eci.cvds.Persistence.NeedDao;
import edu.eci.cvds.dao.mybatis.mappers.NeedMapper;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public class MyBatisNeed implements NeedDao{
	
    @Inject
    private NeedMapper needMappers;
    
	@Override
	public void save(Need need) throws ExcepcionesSolidaridad {
        try {
	        needMappers.insertNeed(new Need(need.getName(), need.getDescription(), need.getCreationDate(), need.getStatus(), need.getModificationDate(), need.getUrgency()) , 3, 2 );
	        } catch (Exception e) {
	        throw new ExcepcionesSolidaridad("No se logro crear la nueva necesidad", e);
        }
	}

	@Override
	public Need load(String name) throws ExcepcionesSolidaridad {
        try {
            return needMappers.getNeed(name);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener un Usuario.", e);
        }
	}

}
