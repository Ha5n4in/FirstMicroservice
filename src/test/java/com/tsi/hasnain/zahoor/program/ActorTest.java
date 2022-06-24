package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Actor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ActorTest {
    Actor testActor = new Actor("Firstname", "Lastname");
    Actor testActor2 = new Actor();

    @Test
    public void testActor(){
        Assertions.assertEquals(0, testActor.getActor_id(),"Incorrect ID");  //id compared to test actor id
        Assertions.assertEquals("Firstname", testActor.getFirst_name(),"Incorrect first name");
        Assertions.assertEquals("Lastname",testActor.getLast_name(),"Incorrect last name");
        // this is all done to test the getters now the setters are tested below

        testActor2.setFirst_name("testFName");
        Assertions.assertEquals("testFName",testActor2.getFirst_name(),"Incorrect first name");
        testActor2.setLast_name("testLName");
        Assertions.assertEquals("testLName",testActor2.getLast_name(),"Incorrect last name");
    }
}
