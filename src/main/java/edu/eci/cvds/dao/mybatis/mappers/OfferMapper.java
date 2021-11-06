package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Offer;

public interface OfferMapper {

    public void InsertOffer(@Param("oferta") Offer offer, @Param("categoryId") int categoryId);
    public Offer getOffer(@Param("name") String name);
    public void ActualizarOffer(@Param("status") String status);
}
