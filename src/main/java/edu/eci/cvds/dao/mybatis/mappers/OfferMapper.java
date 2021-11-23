package edu.eci.cvds.dao.mybatis.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Offer;

public interface OfferMapper {

    public void InsertOffer(@Param("oferta") Offer offer, @Param("categoryId") int categoryId, @Param("userId") int userId);
    public Offer getOffer(@Param("id") int id);
    public ArrayList<Offer> getOffers();
    public int getTotalOfferOfUser( @Param("userId") int id);
    public void ActualizarOffer(@Param("id") int id, @Param("status") String status);
    public int getOfferIdByName(@Param("name") String name);
    public int countCategories(@Param("category") int category);
}
