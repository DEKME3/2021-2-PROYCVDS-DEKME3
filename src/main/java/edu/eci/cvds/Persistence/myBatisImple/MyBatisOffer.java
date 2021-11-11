package edu.eci.cvds.Persistence.myBatisImple;


import com.google.inject.Inject;
import edu.eci.cvds.Persistence.OfferDao;
import edu.eci.cvds.dao.mybatis.mappers.OfferMapper;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public class MyBatisOffer implements OfferDao {

    @Inject
    private OfferMapper offerMappers;

    @Override
    public void save(Offer offer) throws ExcepcionesSolidaridad {
        try {
            offerMappers.InsertOffer(new Offer(offer.getName(), offer.getDescription(), offer.getCreationDate(), offer.getStatus(), offer.getModification()) , 3, 2 );
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro crear la nueva oferta", e);
        }
    }

    @Override
    public Offer load(String name) throws ExcepcionesSolidaridad {
        try {
            return offerMappers.getOffer(name);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener un Usuario.", e);
        }
    }

}