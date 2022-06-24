package com.tsi.hasnain.zahoor.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock //makes mock of repository below
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
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, cityRepository, countryRepository, filmRepository, languageRepository, rentalRepository);
    }

    //Actor Tests
    @Test
    public void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void getActor() {
        Actor testActor = new Actor("FName", "LName");
        testActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        Actor Actual = myFirstMicroserviceApplication.getActor(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected, Actual, "Could not find actor with ID: ");
    }

    @Test
    public void AddActorTest(){
        Actor TestSaveActor = new Actor("John", "Doe");
        Actor Actual = myFirstMicroserviceApplication.addActor(TestSaveActor).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Actor unable to be saved");
    }

    @Test
    void TestUpdateActor(){
        Actor TestActor = new Actor("John", "Doe");
        TestActor.setActor_id(1);
        Actor TestUpdateActor = new Actor("Sponge", "Bob");
        TestUpdateActor.setActor_id(1);
        when(actorRepository.findById(TestActor.getActor_id())).thenReturn(Optional.of(TestUpdateActor));
        Actor Actual = myFirstMicroserviceApplication.updateActor(1,TestActor).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor was not updated.");

    }

    @Test
    public void TestDeleteActor() {
        Actor deletedActor = new Actor("testActorFirst", "testActorLast");
        deletedActor.setActor_id(1);
        System.out.println(actorRepository.findAll());
        when(actorRepository.findById(1)).thenReturn(Optional.of(deletedActor));
        Actor Actual = myFirstMicroserviceApplication.deleteActor(1).getBody();
        Actor expected = deletedActor;
        ArgumentCaptor<Integer> actorArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(actorRepository).deleteById(actorArgumentCaptor.capture());
        Assertions.assertEquals(expected, Actual, "Shopper not deleted");
    }

    //Category Tests

    @Test
    public void getAllCategories(){
        myFirstMicroserviceApplication.getAllCategories();
        verify(categoryRepository).findAll();
    }

    @Test
    public void getCategory() {
        Category testCategory = new Category("CategoryName");
        testCategory.setCategory_id(1);
        when(categoryRepository.findById(1)).thenReturn(Optional.of(testCategory));
        Category Actual = myFirstMicroserviceApplication.getCategory(testCategory.getCategory_id());
        Category Expected = testCategory;
        Assertions.assertEquals(Expected, Actual, "Could not find category with ID: ");
    }

    //City Tests

    @Test
    public void getAllCities(){
        myFirstMicroserviceApplication.getAllCities();
        verify(cityRepository).findAll();
    }

    @Test
    public void getCity() {
        City testCity = new City("CityName", 103);
        testCity.setCity_id(1);
        when(cityRepository.findById(1)).thenReturn(Optional.of(testCity));
        City Actual = myFirstMicroserviceApplication.getCity(testCity.getCity_id());
        City Expected = testCity;
        Assertions.assertEquals(Expected, Actual, "Could not find city with ID: ");
    }

    //Country Tests

    @Test
    public void getAllCountries(){
        myFirstMicroserviceApplication.getAllCountries();
        verify(countryRepository).findAll();
    }

    @Test
    public void getCountry() {
        Country testCountry = new Country("CountryName");
        testCountry.setCountry_id(1);
        when(countryRepository.findById(1)).thenReturn(Optional.of(testCountry));
        Country Actual = myFirstMicroserviceApplication.getCountry(testCountry.getCountry_id());
        Country Expected = testCountry;
        Assertions.assertEquals(Expected, Actual, "Could not find country with ID: ");
    }

    //Film Test

    @Test
    public void getAllFilms(){
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }

    @Test
    public void getFilm() {
        Film testFilm = new Film("TestTitle", "TestDescription", 1998, 3, 100, "PGTest");
        testFilm.setFilm_id(1);
        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm));
        Film Actual = myFirstMicroserviceApplication.getFilm(testFilm.getFilm_id());
        Film Expected = testFilm;
        Assertions.assertEquals(Expected, Actual, "Could not find film with ID: ");
    }

    //Language Test

    @Test
    public void getAllLanguages(){
        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }

    @Test
    public void getLanguage() {
        Language testLanguage = new Language("TestLanguage");
        testLanguage.setLanguage_id(1);
        when(languageRepository.findById(1)).thenReturn(Optional.of(testLanguage));
        Language Actual = myFirstMicroserviceApplication.getLanguage(testLanguage.getLanguage_id());
        Language Expected = testLanguage;
        Assertions.assertEquals(Expected, Actual, "Could not find language with ID: ");
    }

    //Rental Test

    @Test
    public void getAllRentals(){
        myFirstMicroserviceApplication.getRentals();
        verify(rentalRepository).findAll();
    }

    @Test
    public void getRental() {
        Rental testRental = new Rental("1/2/2022", 8, 3, "30/3/2022", 7);
        testRental.setRental_id(1);
        when(rentalRepository.findById(1)).thenReturn(Optional.of(testRental));
        Rental Actual = myFirstMicroserviceApplication.getRental(testRental.getRental_id());
        Rental Expected = testRental;
        Assertions.assertEquals(Expected, Actual, "Could not find rental with ID: ");
    }
}
