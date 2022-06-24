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
        Assertions.assertEquals(expected, Actual, "Actor not deleted");
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

    @Test
    public void AddCategoryTest(){
        Category TestSaveCategory = new Category("Horror");
        Category Actual = myFirstMicroserviceApplication.addCategory(TestSaveCategory).getBody();
        ArgumentCaptor<Category> CategoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(CategoryArgumentCaptor.capture());
        Category expected = CategoryArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Category unable to be saved");
    }

    @Test
    void TestUpdateCategory(){
        Category TestCategory = new Category("Comedy");
        TestCategory.setCategory_id(1);
        Category TestUpdateCategory = new Category("Drama");
        TestUpdateCategory.setCategory_id(1);
        when(categoryRepository.findById(TestCategory.getCategory_id())).thenReturn(Optional.of(TestUpdateCategory));
        Category Actual = myFirstMicroserviceApplication.updateCategory(1,TestCategory).getBody();
        ArgumentCaptor<Category> CategoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(CategoryArgumentCaptor.capture());
        Category Expected = CategoryArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Category was not updated.");

    }

    @Test
    public void TestDeleteCategory() {
        Category deletedCategory = new Category("testCategory");
        deletedCategory.setCategory_id(1);
        System.out.println(categoryRepository.findAll());
        when(categoryRepository.findById(1)).thenReturn(Optional.of(deletedCategory));
        Category Actual = myFirstMicroserviceApplication.deleteCategory(1).getBody();
        Category expected = deletedCategory;
        ArgumentCaptor<Integer> CategoryArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(categoryRepository).deleteById(CategoryArgumentCaptor.capture());
        Assertions.assertEquals(expected, Actual, "Category not deleted");
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

    @Test
    public void AddCityTest(){
        City TestSaveCity = new City("San Fransisco",103);
        City Actual = myFirstMicroserviceApplication.addCity(TestSaveCity).getBody();
        ArgumentCaptor<City> CityArgumentCaptor = ArgumentCaptor.forClass(City.class);
        verify(cityRepository).save(CityArgumentCaptor.capture());
        City expected = CityArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"City unable to be saved");
    }

    @Test
    void TestUpdateCity(){
        City TestCity = new City("Paris", 23);
        TestCity.setCity_id(1);
        City TestUpdateCity = new City("London", 45);
        TestUpdateCity.setCity_id(1);
        when(cityRepository.findById(TestCity.getCity_id())).thenReturn(Optional.of(TestUpdateCity));
        City Actual = myFirstMicroserviceApplication.updateCity(1,TestCity).getBody();
        ArgumentCaptor<City> CityArgumentCaptor = ArgumentCaptor.forClass(City.class);
        verify(cityRepository).save(CityArgumentCaptor.capture());
        City Expected = CityArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"City was not updated.");

    }

    @Test
    public void TestDeleteCity() {
        City deletedCity = new City("testCity", 103);
        deletedCity.setCity_id(1);
        System.out.println(cityRepository.findAll());
        when(cityRepository.findById(1)).thenReturn(Optional.of(deletedCity));
        City Actual = myFirstMicroserviceApplication.deleteCity(1).getBody();
        City expected = deletedCity;
        ArgumentCaptor<Integer> CityArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(cityRepository).deleteById(CityArgumentCaptor.capture());
        Assertions.assertEquals(expected, Actual, "City not deleted");
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

    @Test
    public void AddCountryTest(){
        Country TestSaveCountry = new Country("Brasil");
        Country Actual = myFirstMicroserviceApplication.addCountry(TestSaveCountry).getBody();
        ArgumentCaptor<Country> CountryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryRepository).save(CountryArgumentCaptor.capture());
        Country expected = CountryArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Country unable to be saved");
    }

    @Test
    void TestUpdateCountry(){
        Country TestCountry = new Country("France");
        TestCountry.setCountry_id(1);
        Country TestUpdateCountry = new Country("Spain");
        TestUpdateCountry.setCountry_id(1);
        when(countryRepository.findById(TestCountry.getCountry_id())).thenReturn(Optional.of(TestUpdateCountry));
        Country Actual = myFirstMicroserviceApplication.updateCountry(1,TestCountry).getBody();
        ArgumentCaptor<Country> CountryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryRepository).save(CountryArgumentCaptor.capture());
        Country Expected = CountryArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Country was not updated.");

    }

    @Test
    public void TestDeleteCountry() {
        Country deletedCountry = new Country("testCountry");
        deletedCountry.setCountry_id(1);
        System.out.println(countryRepository.findAll());
        when(countryRepository.findById(1)).thenReturn(Optional.of(deletedCountry));
        Country Actual = myFirstMicroserviceApplication.deleteCountry(1).getBody();
        Country expected = deletedCountry;
        ArgumentCaptor<Integer> CountryArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(countryRepository).deleteById(CountryArgumentCaptor.capture());
        Assertions.assertEquals(expected, Actual, "Country not deleted");
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

    @Test
    public void AddFilmTest(){
        Film TestSaveFilm = new Film("King Kong", "Action", 2004, 1, 75, "PG-15");
        Film Actual = myFirstMicroserviceApplication.addFilm(TestSaveFilm).getBody();
        ArgumentCaptor<Film> FilmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(FilmArgumentCaptor.capture());
        Film expected = FilmArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Film unable to be saved");
    }

    @Test
    void TestUpdateFilm(){
        Film TestFilm = new Film("John Wick", "test description", 2016, 4, 75, "PG-18");
        TestFilm.setFilm_id(1);
        Film TestUpdateFilm = new Film("Iron Man", "MCU Opener", 2008, 3, 60, "PG-13");
        TestUpdateFilm.setFilm_id(1);
        when(filmRepository.findById(TestFilm.getFilm_id())).thenReturn(Optional.of(TestUpdateFilm));
        Film Actual = myFirstMicroserviceApplication.updateFilm(1,TestFilm).getBody();
        ArgumentCaptor<Film> FilmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(FilmArgumentCaptor.capture());
        Film Expected = FilmArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Film was not updated.");

    }

    @Test
    public void TestDeleteFilm() {
        Film deletedFilm = new Film("testFilmTitle", "testFilmDescription", 2014, 6, 55, "testRating");
        deletedFilm.setFilm_id(1);
        System.out.println(filmRepository.findAll());
        when(filmRepository.findById(1)).thenReturn(Optional.of(deletedFilm));
        Film Actual = myFirstMicroserviceApplication.deleteFilm(1).getBody();
        Film expected = deletedFilm;
        ArgumentCaptor<Integer> FilmArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(filmRepository).deleteById(FilmArgumentCaptor.capture());
        Assertions.assertEquals(expected, Actual, "Film not deleted");
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

    @Test
    public void AddLanguageTest(){
        Language TestSaveLanguage = new Language("English");
        Language Actual = myFirstMicroserviceApplication.addLanguage(TestSaveLanguage).getBody();
        ArgumentCaptor<Language> LanguageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(LanguageArgumentCaptor.capture());
        Language expected = LanguageArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Language unable to be saved");
    }

    @Test
    void TestUpdateLanguage(){
        Language TestLanguage = new Language("Spanish");
        TestLanguage.setLanguage_id(1);
        Language TestUpdateLanguage = new Language("German");
        TestUpdateLanguage.setLanguage_id(1);
        when(languageRepository.findById(TestLanguage.getLanguage_id())).thenReturn(Optional.of(TestUpdateLanguage));
        Language Actual = myFirstMicroserviceApplication.updateLanguage(1,TestLanguage).getBody();
        ArgumentCaptor<Language> LanguageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(LanguageArgumentCaptor.capture());
        Language Expected = LanguageArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Language was not updated.");

    }

    @Test
    public void TestDeleteLanguage() {
        Language deletedLanguage = new Language("testLanguage");
        deletedLanguage.setLanguage_id(1);
        System.out.println(languageRepository.findAll());
        when(languageRepository.findById(1)).thenReturn(Optional.of(deletedLanguage));
        Language Actual = myFirstMicroserviceApplication.deleteLanguage(1).getBody();
        Language expected = deletedLanguage;
        ArgumentCaptor<Integer> LanguageArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(languageRepository).deleteById(LanguageArgumentCaptor.capture());
        Assertions.assertEquals(expected, Actual, "Language not deleted");
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

    @Test
    public void AddRentalTest(){
        Rental TestSaveRental = new Rental("1/1/2001", 2, 3, "31/1/2002", 1);
        Rental Actual = myFirstMicroserviceApplication.addRental(TestSaveRental).getBody();
        ArgumentCaptor<Rental> RentalArgumentCaptor = ArgumentCaptor.forClass(Rental.class);
        verify(rentalRepository).save(RentalArgumentCaptor.capture());
        Rental expected = RentalArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Rental unable to be saved");
    }

    @Test
    void TestUpdateRental(){
        Rental TestRental = new Rental("2/2/2002", 4, 5, "24/3/2002", 5);
        TestRental.setRental_id(1);
        Rental TestUpdateRental = new Rental("1/1/2011", 5, 3, "31/2/2011", 4);
        TestUpdateRental.setRental_id(1);
        when(rentalRepository.findById(TestRental.getRental_id())).thenReturn(Optional.of(TestUpdateRental));
        Rental Actual = myFirstMicroserviceApplication.updateRental(1,TestRental).getBody();
        ArgumentCaptor<Rental> RentalArgumentCaptor = ArgumentCaptor.forClass(Rental.class);
        verify(rentalRepository).save(RentalArgumentCaptor.capture());
        Rental Expected = RentalArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Rental was not updated.");

    }

    @Test
    public void TestDeleteRental() {
        Rental deletedRental = new Rental("20/2/2012", 1, 2, "31/3/2012",4);
        deletedRental.setRental_id(1);
        System.out.println(rentalRepository.findAll());
        when(rentalRepository.findById(1)).thenReturn(Optional.of(deletedRental));
        Rental Actual = myFirstMicroserviceApplication.deleteRental(1).getBody();
        Rental expected = deletedRental;
        ArgumentCaptor<Integer> RentalArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(rentalRepository).deleteById(RentalArgumentCaptor.capture());
        Assertions.assertEquals(expected, Actual, "Rental not deleted");
    }
}
