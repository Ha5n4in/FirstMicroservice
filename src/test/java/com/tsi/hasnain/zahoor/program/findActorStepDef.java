package com.tsi.hasnain.zahoor.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.net.*;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class findActorStepDef {
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

    @Given("I have the actor id of the actor")
    public void i_have_the_actor_id_of_the_actor() {
        TestDummy = new Actor("FName", "LName");
        TestDummy.setActor_id(1);
    }
    @When("I input the data into the database to get")
    public void i_input_the_data_into_the_database_to_get() {
        setup();
        when(actorRepository.findById(1)).thenReturn(Optional.of(TestDummy));
        Actual = myFirstMicroserviceApplication.getActor(TestDummy.getActor_id());
    }
    @Then("I get a return of the correct actor")
    public void i_get_a_return_of_the_correct_actor() {
        expected = TestDummy;
        Assertions.assertEquals(expected, Actual, "Could not find actor with ID: ");
    }
}
