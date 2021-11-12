package edu.eci.cvds.dao.mybatis.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Offer;

public interface OfferMapper {

    public void InsertOffer(@Param("oferta") Offer offer, @Param("categoryId") int categoryId, @Param("userId") int userId);
    public Offer getOffer(@Param("name") String name);
    public ArrayList<Offer> getOffers();
    public int getTotalOfferOfUser( @Param("userId") int id);
    public void ActualizarOffer(@Param("id") int id, @Param("status") String status);
}
