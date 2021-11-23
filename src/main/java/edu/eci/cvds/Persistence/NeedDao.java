package edu.eci.cvds.Persistence;

import java.util.ArrayList;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface NeedDao {
    public void insertNeed(Need need, int categoryId, int userId) throws ExcepcionesSolidaridad;
    public int getTotalNeedsOfUser(int id) throws ExcepcionesSolidaridad;
    public void ActualizarNeed(int id, String status) throws ExcepcionesSolidaridad;
    public ArrayList<Need> getNeedsResult(int usuario) throws ExcepcionesSolidaridad;
    public int getIdUserByNeed(int id) throws ExcepcionesSolidaridad;
    public ArrayList<Need> getNeeds() throws ExcepcionesSolidaridad;
    public Need getNeed(int id) throws ExcepcionesSolidaridad;
}
