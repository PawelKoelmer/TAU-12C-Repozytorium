package baza.slodycz;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SlodyczTest {

    @Test
    public void createObjectTest(){

        assertNotNull(new BazaSlodyczy());
    }
    
    @Test
    public void createSingleObjectTest(){
        Slodycz slodycz = new Slodycz(1,"Czekolada","Słodka");
        assertEquals(1,slodycz.getId());
        assertEquals("Czekolada",slodycz.getNazwa());
        assertEquals("Słodka",slodycz.getOpis());
    }
}
