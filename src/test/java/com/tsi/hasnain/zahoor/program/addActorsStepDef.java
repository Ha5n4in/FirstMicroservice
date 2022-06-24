package com.tsi.hasnain.zahoor.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.net.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addActorsStepDef {
        private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
        @Mock
        private ActorRepository actorRepository;
        @Mock
        private CategoryRepository categoryRepository;
        @Mock
        private CityRepository cityRepository;
        @Mock
        private CountryRepository countryRepository;
        @Mock
        private FilmRepository filmRepository;
        @Mock
        private LanguageRepository languageRepository;
        @Mock
        private RentalRepository rentalRepository;

        @BeforeEach
        void setup(){
            actorRepository =mock(ActorRepository.class);
            categoryRepository =mock(CategoryRepository.class);
            cityRepository =mock(CityRepository.class);
            countryRepository =mock(CountryRepository.class);
            filmRepository =mock(FilmRepository.class);
            languageRepository =mock(LanguageRepository.class);
            rentalRepository =mock(RentalRepository.class);
            myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, cityRepository, countryRepository, filmRepository, languageRepository, rentalRepository);
        }
    Actor TestDummy;
    Actor Actual;
    Actor expected;
    int test_id;

    @Given("I have the actors information")
    public void i_have_the_actors_information() {
        TestDummy = new Actor("FirstTest","LastTest");
        test_id = 1;
        TestDummy.setActor_id(test_id);
    }
    @When("I input the data into the database to add")
    public void i_input_the_data_into_the_database() {
        setup();
        Actual = myFirstMicroserviceApplication.addActor(TestDummy).getBody();
    }
    @Then("I get the success return for adding actor")
    public void i_get_the_success_return_string() {
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Actor was not updated.");
    }
}
