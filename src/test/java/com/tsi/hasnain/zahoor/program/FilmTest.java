package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Film;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FilmTest {
    Film testFilm = new Film("Filmname", "Filmdescription", 2022, 1, 60, "PG");
    Film testFilm2 = new Film();

    @Test
    public void testActor(){
        Assertions.assertEquals(0, testFilm.getFilm_id(),"Incorrect ID");
        Assertions.assertEquals("Filmname", testFilm.getFilm_name(),"Incorrect film name");
        Assertions.assertEquals("Filmdescription", testFilm.getFilm_description(),"Incorrect film description");
        Assertions.assertEquals(2022, testFilm.getRelease_year(), "Incorrect release year");
        Assertions.assertEquals(1, testFilm.getLanguage_id(), "Incorrect language ID");
        Assertions.assertEquals(60, testFilm.getLength(), "Incorrect film length");
        Assertions.assertEquals("PG", testFilm.getRating(), "Incorrect film rating");

        testFilm2.setFilm_name("testFName");
        Assertions.assertEquals("testFName", testFilm2.getFilm_name(),"Incorrect film name");
        testFilm2.setFilm_description("testFDescription");
        Assertions.assertEquals("testFDescription", testFilm2.getFilm_description(),"Incorrect film description");
        testFilm2.setRelease_year(2000);
        Assertions.assertEquals(2000, testFilm2.getRelease_year(), "Incorrect Release Year");
        testFilm2.setLanguage_id(2);
        Assertions.assertEquals(2, testFilm2.getLanguage_id(), "Incorrect language ID");
        testFilm2.setLength(75);
        Assertions.assertEquals(75, testFilm2.getLength(), "Incorrect film length");
        testFilm2.setRating("PG-13");
        Assertions.assertEquals("PG-13", testFilm2.getRating(), "Incorrect film rating");
    }
}
