package com.tsi.hasnain.zahoor.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import java.net.*;

public class addActorsStepDef {
    @Given("I have the actors information")
    public void i_have_the_actors_information() {
//        try {
//            URL url = new URL("http://107.22.134.109:8080/CocktailsDB/allCocktails");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//
//            Assertions.assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode(), "A connection has not been made");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
