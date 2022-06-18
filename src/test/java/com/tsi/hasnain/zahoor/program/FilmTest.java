package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Film;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FilmTest {
    Film testFilm = new Film("Filmname", "Filmdescription");
    Film testFilm2 = new Film();

    @Test
    public void testActor(){
        Assertions.assertEquals(0, testFilm.getFilm_id(),"Incorrect ID");
        Assertions.assertEquals("Filmname", testFilm.getFilm_name(),"Incorrect film name");
        Assertions.assertEquals("Filmdescription",testFilm.getFilm_description(),"Incorrect film description");

        testFilm2.setFilm_name("testFName");
        Assertions.assertEquals("testFName",testFilm2.getFilm_name(),"Incorrect film name");
        testFilm2.setFilm_description("testFDescription");
        Assertions.assertEquals("testFDescription",testFilm2.getFilm_description(),"Incorrect film description");
    }
}
