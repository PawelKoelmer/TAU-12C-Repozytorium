package baza.slodycz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.*;

@RunWith(JUnit4.class)
public class SlodyczTest {
//Rozbić wszystko na minimumm TDD - każdą możliwość w teście - NULL i inne xceptiony -  wyjdzie około 40 testów
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
    public void renameSlodyczNazwaNullTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz();
        baza.insert(slodycz);
        baza.renameSlodycz(0,"Baton");
    }
    @Test
    public void renameSlodyczNullOpisTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz();
        baza.insert(slodycz);
        baza.renameSlodycz(0,"Baton");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void changeSlodyczAssertIdWithNoObjectTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.changeId(0,99);
        assertEquals(99,baza.getSingle(0).getId());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void changeSlodyczAssertNameWithNoObjectTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.renameSlodycz(0,"Baton");
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void changeSlodyczAssertDescriptionWithNoObjectTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        baza.changeDescription(0,"Baton");
    }
    @Test
    public void changeSlodyczAssertIdTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.changeId(0,99);
        assertEquals(99,baza.getSingle(0).getId());
    }

    @Test
    public void renameSlodyczAssertNazwaTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.renameSlodycz(0,"Baton");
        assertEquals("Baton",baza.getSingle(0).getNazwa());
    }

    @Test
    public void renameSlodyczAssertOpisTest(){
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteSlodyczTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        Slodycz slodycz1 = new Slodycz(2,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.insert(slodycz1);
        baza.deleteSlodycz(1);
        assertNull(baza.getSingle(1));

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteSlodyczAssertTest(){
        BazaSlodyczy baza = new BazaSlodyczy();
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        baza.insert(slodycz);
        baza.deleteSlodycz(0);
        assertNull(baza.getSingle(0));
    }



}
