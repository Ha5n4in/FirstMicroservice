package com.tsi.hasnain.zahoor.program;

import com.tsi.hasnain.zahoor.program.Actor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ActorTest {
//    Actor testActor = new Actor("Firstname", "Lastname");
//    Actor testActor2 = new Actor();
//
//    @Test
//    public void testActor(){
//        Assertions.assertEquals(0, testActor.getActor_id(),"Incorrect ID");  //id compared to test actor id
//        Assertions.assertEquals("Firstname", testActor.getFirst_name(),"Incorrect first name");
//        Assertions.assertEquals("Lastname",testActor.getLast_name(),"Incorrect last name");
//        // this is all done to test the getters now the setters are tested below
//
//        testActor2.setFirst_name("testFName");
//        Assertions.assertEquals("testFName",testActor2.getFirst_name(),"Incorrect first name");
//        testActor2.setLast_name("testLName");
//        Assertions.assertEquals("testLName",testActor2.getLast_name(),"Incorrect last name");
//    }
    @Test
    void testGetActorID(){
    Actor testActor = new Actor("testFName", "testLName");
    testActor.setActor_id(1);
    Assertions.assertEquals(1, testActor.getActor_id(), "id not there.");
}
    @Test
    void testSetActorID(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Assertions.assertEquals(1, testActor.getActor_id(), "id not set.");
    }
    @Test
    void testGetFirstName(){
        Actor testActor = new Actor("testFName", "testLName");
        Assertions.assertEquals("testFName", testActor.getFirst_name(), "first name not found/set.");
    }
    @Test
    void testSetFirstName(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setFirst_name("replacedFName");
        Assertions.assertEquals("replacedFName", testActor.getFirst_name(), "first name not set.");
    }
    @Test
    void testGetLastName(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.getLast_name();
        Assertions.assertEquals("testLName", testActor.getLast_name(), "last name not found/set.");
    }
    @Test
    void testSetLastName(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setLast_name("replacedLName");
        Assertions.assertEquals("replacedLName", testActor.getLast_name(), "last name not set.");
    }
}
