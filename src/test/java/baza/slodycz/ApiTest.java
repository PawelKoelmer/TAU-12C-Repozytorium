package baza.slodycz;

import baza.slodycz.api.domain.Slodycz;
import baza.slodycz.api.services.SlodyczManager;
import baza.slodycz.api.services.SlodyczManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ApiTest {

    SlodyczManager slodyczManager;
    Slodycz slodycz;

    @Before
    public void setup() throws SQLException{
        slodyczManager = new SlodyczManagerImpl();
        String csvFile = "src/test/resources/dane.csv";
        String line = "";
        String csvSplitBy =",";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader((csvFile)));
            while((line = br.readLine())!=null){
                String[] slodyczParameters = line.split(csvSplitBy);
                slodycz = new Slodycz(slodyczParameters[0],slodyczParameters[1]);
                slodyczManager.addSlodycz(slodycz);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void cleanup() throws SQLException{
        slodyczManager.dropTable();
    }

    @Test
    public void checkConnection(){
        assertNotNull(slodyczManager.getConnection());
    }
    @Test
    public void checkGettingAll(){
        assertNotNull(slodyczManager.getAllSlodycz());
    }
    @Test
    public void checkGetOne(){
            slodyczManager.getSlodycz(1);
    }
    @Test
    public void checkAdding(){
        slodycz = new Slodycz("Guma","HubbaBubba");
        slodyczManager.addSlodycz(slodycz);
    }
    @Test
    public void checkDeleting(){
        slodyczManager.deleteSlodycz(0);
        assertNull(slodyczManager.getSlodycz(0));
    }
    @Test
    public void checkUpdating(){
        slodycz = new Slodycz("Zelki","Haribo");
        slodyczManager.updateSlodycz(slodycz,0);
        Slodycz slodycz1 = new Slodycz();
        slodycz1 = slodyczManager.getSlodycz(0);
        assertEquals("Zelki",slodycz1.getNazwa());
        assertEquals("Haribo", slodycz1.getOpis());

    }
}
