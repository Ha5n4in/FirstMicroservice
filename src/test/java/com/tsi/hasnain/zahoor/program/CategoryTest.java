package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Category;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CategoryTest {
    Category testCategory = new Category("Horror");
    Category testCategory2 = new Category();

    @Test
    public void testCategory() {
        Assertions.assertEquals(0, testCategory.getCategory_id(), "Incorrect ID");
        Assertions.assertEquals("Horror", testCategory.getCategory_name(), "Incorrect category name");

        testCategory2.setCategory_name("testCName");
        Assertions.assertEquals("testCName", testCategory2.getCategory_name(), "Incorrect category name");
    }
}
