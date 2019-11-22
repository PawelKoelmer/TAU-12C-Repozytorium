package baza.slodycz;

import baza.slodycz.api.domain.Slodycz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.*;

@RunWith(JUnit4.class)
public class SlodyczTest {

    @Test
    public void createObjectTest(){
        assertNotNull(new BazaSlodyczy());
    }

    @Test
    public void createSingleSlodyczTest(){
        assertNotNull(new Slodycz());
    }

    @Test
    public void createSingleObjectTest(){
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        assertEquals(1, slodycz.getId());
        assertEquals("Czekolada",slodycz.getNazwa());
        assertEquals("Słodka",slodycz.getOpis());
    }

    @Test
    public void addEmptyObjectToDatabase(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz();
        baza.insert(slodycz);
        assertEquals(0,baza.getSingle(0).getId());
        assertEquals(null,baza.getSingle(0).getNazwa());
        assertEquals(null,baza.getSingle(0).getOpis());
    }

    @Test
    public void addObjectToDatabase(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        assertEquals(1,baza.getSingle(1).getId());
    }

    @Test(expected = NullPointerException.class)
    public void renameNazwaNullTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz();
        baza.insert(slodycz);
        baza.rename(1,"Baton");
    }
    @Test(expected = NullPointerException.class)
    public void renameNullOpisTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz();
        baza.insert(slodycz);
        baza.rename(1,"Baton");
    }

    @Test(expected = NullPointerException.class)
    public void changeSlodyczAssertIdWithNoObjectTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.changeId(1,99);
        assertEquals(99,baza.getSingle(0).getId());
    }
    @Test(expected = NullPointerException.class)
    public void changeSlodyczAssertNameWithNoObjectTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.rename(1,"Baton");
    }
    @Test(expected = NullPointerException.class)
    public void changeSlodyczAssertDescriptionWithNoObjectTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.changeDescription(1,"Baton");
    }
    @Test
    public void changeSlodyczAssertIdTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.changeId(1,99);
        assertEquals(99,baza.getSingle(99).getId());
    }

    @Test
    public void renameAssertNazwaTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.rename(1,"Baton");
        assertEquals("Baton",baza.getSingle(1).getNazwa());
    }

    @Test
    public void renameAssertOpisTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.rename(1,"Baton");
        assertEquals("Baton",baza.getSingle(1).getNazwa());
    }

    @Test
    public void deleteNullSlodyczTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.delete(1);
    }
}
