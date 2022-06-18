package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Language;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LanguageTest {
    Language testLanguage = new Language("English");
    Language testLanguage2 = new Language();

    @Test
    public void testLanguage() {
        Assertions.assertEquals(0, testLanguage.getLanguage_id(), "Incorrect ID");
        Assertions.assertEquals("English", testLanguage.getLanguage_name(), "Incorrect language name");

        testLanguage2.setLanguage_name("testLName");
        Assertions.assertEquals("testLName", testLanguage2.getLanguage_name(), "Incorrect language name");
    }
}

