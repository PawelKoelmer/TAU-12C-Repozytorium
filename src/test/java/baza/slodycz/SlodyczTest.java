package baza.slodycz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(JUnit4.class)
public class SlodyczTest {

    @Test
    public void createObjectTest(){
        assertNotNull(new BazaSlodyczy());
}

    @Test
    public void createSingleObjectTest(){
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        assertEquals(1, slodycz.getId());
        assertEquals("Czekolada",slodycz.getNazwa());
        assertEquals("Słodka",slodycz.getOpis());
    }

    @Test
    public void addObjectToDatabase(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        assertEquals(1,baza.getSingle(0).getId());
    }

    @Test
    public void getListOfObjectsFromDatabaseNotNull(){
        BazaSlodyczy baza = new BazaSlodyczy();
        assertNotNull(baza.getAll());
    }



}
