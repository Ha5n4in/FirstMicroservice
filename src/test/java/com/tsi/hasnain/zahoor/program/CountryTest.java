package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Country;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CountryTest {
    Country testCountry = new Country("Canada");
    Country testCountry2 = new Country();

    @Test
    public void testCountry() {
        Assertions.assertEquals(0, testCountry.getCountry_id(), "Incorrect ID");
        Assertions.assertEquals("Canada", testCountry.getCountry_name(), "Incorrect country name");

        testCountry2.setCountry_name("testCountryName");
        Assertions.assertEquals("testCountryName", testCountry2.getCountry_name(), "Incorrect country name");
    }
}
