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
    public void getListOfObjectsFromDatabaseNotNullTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        assertNotNull(baza.getAll());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getSingleObjectTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.getSingle(0);
    }

    @Test
    public void renameSlodyczTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.renameSlodycz(0,"Baton");
        assertEquals("Baton",baza.getSingle(0).getNazwa());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deletesingleSlodyczTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.deleteSlodycz(0);
    }

    @Test()
    public void deleteSlodyczTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.deleteSlodycz(0);
    }



}
