package baza.slodycz.API.service;

import baza.slodycz.Slodycz;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SlodyczManagerImpl implements SlodyczManager {

    private Connection connection;
    //Statements
    private PreparedStatement addSlodyczStatement;
    private PreparedStatement deleteSlodyczStatement;
    private PreparedStatement getAllSlodyczStatement;
    private PreparedStatement getSlodyczStatement;
    private PreparedStatement updateSlodyczStatement;
    private PreparedStatement deleteAllSlodyczStatement;
    private PreparedStatement dropTableSlodyczStatement;


    public SlodyczManagerImpl(Connection connection) throws SQLException{
        this.connection = connection;
        if(!isDatabaseReady()){
            createTables();
        }
        setConnection(connection);
    }

    public SlodyczManagerImpl() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        if (!isDatabaseReady()) {
            createTables();
        }
        this.setConnection(this.connection);
    }

    private void createTables() throws SQLException{
         connection.createStatement().executeUpdate("CREATE TABLE" +
                " slodycze (" +
                " id INT NOT NULL," +
                " name VARCHAR(50) NOT NULL," +
                " description VARCHAR(20) NOT NULL," +
                " PRIMARY KEY (id) " +
                ");");
    }

    public boolean isDatabaseReady() {
        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Person".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }
            return tableExists;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
            this.connection = connection;
        dropTableSlodyczStatement = connection.prepareStatement("Drop table slodycze");
        deleteSlodyczStatement = connection.prepareStatement("DELETE FROM slodycze where id = ?");
        deleteAllSlodyczStatement = connection.prepareStatement("DELETE FROM slodycze");
        getAllSlodyczStatement = connection.prepareStatement("SELECT id, name, description FROM slodycze ORDER BY id");
        getSlodyczStatement = connection.prepareStatement("SELECT id, name, description FROM slodycze WHERE id = ?");
        updateSlodyczStatement = connection.prepareStatement("UPDATE slodycze SET name=?,description=? WHERE id = ?");
    }

    @Override
    public void deleteSlodycz(int id) {
        try {
            deleteSlodyczStatement.setInt(1,id);
            deleteSlodyczStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public void addSlodycz(Slodycz slodycz) {
        try {
            addSlodyczStatement.setString(1, slodycz.getNazwa());
            addSlodyczStatement.setString(2, slodycz.getOpis());
            addSlodyczStatement.executeUpdate();
            ResultSet generatedKeys = addSlodyczStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                slodycz.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public Slodycz getSlodycz(int id) throws SQLException{
        try{
            getAllSlodyczStatement.setInt(1,id);
            ResultSet rs = getSlodyczStatement.executeQuery();
            if (rs.next()) {
                Slodycz slodycz = new Slodycz();
                slodycz.setId(rs.getInt("id"));
                slodycz.setNazwa(rs.getString("name"));
                slodycz.setOpis(rs.getString("description"));
                return slodycz;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        throw new SQLException("Slodycz with id " + id + " does not exist");
    }

    @Override
    public List<Slodycz> getAllSlodycz() {
        List<Slodycz> slodycze = new LinkedList<>();
        try{
            ResultSet rs = getAllSlodyczStatement.executeQuery();
            while(rs.next()){
                Slodycz slodycz = new Slodycz();
                slodycz.setId(rs.getInt("id"));
                slodycz.setNazwa(rs.getString("name"));
                slodycz.setOpis(rs.getString("description"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        return slodycze;
    }

    @Override
    public void updateSlodycz(Slodycz slodycz) throws SQLException{
        int count = 0;
        try{
            updateSlodyczStatement.setString(1, slodycz.getNazwa());
            updateSlodyczStatement.setString(2, slodycz.getOpis());
            updateSlodyczStatement.setInt(3, slodycz.getId());
            count = updateSlodyczStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        if(count <=0){
            throw new SQLException("Person not found for update");
        }
    }

    @Override
    public void deleteAllSlodycz() {
        try {
             deleteAllSlodyczStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public void dropTable() throws SQLException{
        dropTableSlodyczStatement.executeUpdate();
    }

}
