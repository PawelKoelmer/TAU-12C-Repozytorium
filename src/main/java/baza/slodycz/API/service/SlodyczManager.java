package baza.slodycz.API.service;

import baza.slodycz.Slodycz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SlodyczManager {
    //Connection
    public Connection getConnection();
    public void setConnection(Connection connection) throws SQLException;
    //CRUD
    public void deleteSlodycz(int id);
    public void addSlodycz(Slodycz slodycz);
    public Slodycz getSlodycz(int id) throws SQLException;
    public List<Slodycz> getAllSlodycz();
    public void updateSlodycz(Slodycz slodycz) throws SQLException;
    public void deleteAllSlodycz();

}
