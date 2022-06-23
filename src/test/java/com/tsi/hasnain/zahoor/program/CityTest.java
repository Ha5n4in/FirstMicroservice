package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.City;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CityTest {
    City testCity = new City("Dublin",5);
    City testCity2 = new City();

    @Test
    public void testCity() {
        Assertions.assertEquals(0, testCity.getCity_id(), "Incorrect ID");
        Assertions.assertEquals("Dublin", testCity.getCity_name(), "Incorrect City name");
        Assertions.assertEquals(5, testCity.getCountry_id(), "Incorrect country ID");

        testCity2.setCity_name("testCityName");
        Assertions.assertEquals("testCityName", testCity2.getCity_name(), "Incorrect City name");
        testCity2.setCountry_id(103);
        Assertions.assertEquals(103, testCity2.getCountry_id(), "Incorrect country ID");
    }
}
