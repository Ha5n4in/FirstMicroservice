package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Rental;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RentalTest {
    Rental testRental = new Rental("02/02/2020", 2, 1, "22/02/2020", 3);
    Rental testRental2 = new Rental();

    @Test
    public void testRental(){
        Assertions.assertEquals(0, testRental.getRental_id(),"Incorrect ID");
        Assertions.assertEquals("02/02/2020", testRental.getRental_date(),"Incorrect rental date");
        Assertions.assertEquals(2,testRental.getInventory_id(),"Incorrect inventory_id");
        Assertions.assertEquals(1,testRental.getCustomer_id(),"Incorrect customer ID");
        Assertions.assertEquals("22/02/2020", testRental.getReturn_date(), "Incorrect return date");
        Assertions.assertEquals(3, testRental.getStaff_id(), "Incorrect return date");

        testRental2.setRental_date("testRenDate");
        Assertions.assertEquals("testRenDate",testRental2.getRental_date(),"Incorrect rental date");
        testRental2.setInventory_id(5);
        Assertions.assertEquals(5,testRental2.getInventory_id(),"Incorrect inventory_id");
        testRental2.setCustomer_id(6);
        Assertions.assertEquals(6,testRental2.getCustomer_id(),"Incorrect customer ID");
        testRental2.setReturn_date("testRetDate");
        Assertions.assertEquals("testRetDate",testRental2.getReturn_date(),"Incorrect return date");
        testRental2.setStaff_id(7);
        Assertions.assertEquals(7, testRental2.getStaff_id(), "Incorrect return date");
    }
}
