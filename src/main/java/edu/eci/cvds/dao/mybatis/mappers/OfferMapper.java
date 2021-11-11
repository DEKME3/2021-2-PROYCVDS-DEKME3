package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Offer;

public interface OfferMapper {

    public void InsertOffer(@Param("oferta") Offer offer, @Param("categoryId") int categoryId, @Param("userId") int userId);
    public Offer getOffer(@Param("name") String name);
    public int getTotalOfferOfUser( @Param("userId") int id);
    public void ActualizarOffer(@Param("id") int id, @Param("status") String status);
    public Offer getOfferResult(@Param("usuario") String usuario);
}
