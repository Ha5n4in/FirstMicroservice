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

public class findFilmStepDef {

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
    Film TestDummy;
    Film Actual;
    Film expected;
    @Given("I have the film id of the film")
    public void i_have_the_film_id_of_the_film() {
        TestDummy = new Film("TestTitle", "TestDescription", 1998, 3, 100, "PGTest");
        TestDummy.setFilm_id(1);
    }
    @When("I input the film id into the database")
    public void i_input_the_film_id_into_the_database() {
        setup();
        when(filmRepository.findById(1)).thenReturn(Optional.of(TestDummy));
        Actual = myFirstMicroserviceApplication.getFilm(TestDummy.getFilm_id());
    }
    @Then("I get a return of the correct film")
    public void i_get_a_return_of_the_correct_film() {
        expected = TestDummy;
        Assertions.assertEquals(expected, Actual, "Could not find film with ID: ");
    }
}
