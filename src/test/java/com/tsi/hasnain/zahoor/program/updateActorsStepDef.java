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

public class updateActorsStepDef {

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
    Actor UpdatedDummy;
    Actor Actual;
    Actor expected;

    @Given("I have the new actor information")
    public void i_have_the_new_actor_information() {
        TestDummy = new Actor("DummyFName", "DummyLName");
        TestDummy.setActor_id(1);
        UpdatedDummy = new Actor("UpdatedFName", "UpdatedLName");
        UpdatedDummy.setActor_id(1);
    }
    @When("I input the data into the database to update")
    public void i_input_the_data_into_the_database_to_update() {
        setup();
        when(actorRepository.findById(TestDummy.getActor_id())).thenReturn(Optional.of(UpdatedDummy));
        Actual = myFirstMicroserviceApplication.updateActor(1,TestDummy).getBody();
    }
    @Then("I get the success return for updating an actor")
    public void i_get_the_success_return_for_updating_an_actor() {
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Actor was not updated.");
    }
}
