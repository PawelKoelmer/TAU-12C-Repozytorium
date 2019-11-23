package baza.slodycz.api.services;

import baza.slodycz.api.domain.Slodycz;

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
    public Slodycz getSlodycz(int id);
    public List<Slodycz> getAllSlodycz();
    public void updateSlodycz(Slodycz slodycz, int id);
    void createTable() throws SQLException;
    public void dropTable() throws SQLException;

}
