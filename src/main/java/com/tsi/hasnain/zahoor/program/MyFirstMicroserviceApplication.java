package com.tsi.hasnain.zahoor.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SpringBootApplication
@RestController //Tells IDE a REST Controller
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class MyFirstMicroserviceApplication {

	@Autowired //Handles all dependency injection

	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private RentalRepository rentalRepository;
	private String saved = "Saved";
	private String deleted = "Deleted";


	public MyFirstMicroserviceApplication(ActorRepository actorRepository, CategoryRepository categoryRepository, CityRepository cityRepository, CountryRepository countryRepository, FilmRepository filmRepository, LanguageRepository languageRepository, RentalRepository rentalRepository){
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.filmRepository = filmRepository;
		this.languageRepository = languageRepository;
		this.rentalRepository = rentalRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	//Actor Mappings

	@GetMapping("/all_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll(); //returns all actors within repository
	}

	@GetMapping("/a_Actor")
	public Actor getActor(@RequestParam Integer actor_id) {
		return actorRepository.findById(actor_id).orElseThrow(RuntimeException::new); // uses id to find actor within repository or else returns null
	}

	@PostMapping("/add_Actor")
	public @ResponseBody
	ResponseEntity<Actor>  addActor(@RequestBody Actor addActor) { //defines Actor and obtains data required for entry
		actorRepository.save(addActor); //saves actor
		return ResponseEntity.ok(addActor); //returns message saved
	}

	@PutMapping("/update_Actor/{id}")
	public @ResponseBody ResponseEntity<Actor> updateActor(@PathVariable int id, @RequestBody Actor actor) {
		Actor updateActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor not found :(")); //uses id to find actor entry
		updateActor.setFirst_name(actor.getFirst_name()); //once entry is found old data is replaced with update data
		updateActor.setLast_name(actor.getLast_name());
		actorRepository.save(updateActor); // entry is saved
		return ResponseEntity.ok(updateActor); //returns updated entry
	}

	@DeleteMapping("/delete_Actor")
	public ResponseEntity<Actor> deleteActor(@RequestParam Integer actor_id) {
		Actor deletedActor = actorRepository.findById(actor_id).orElseThrow(() -> new ResourceNotFoundException("Actor not found :(")); //id is used to locate actor entry
		actorRepository.deleteById(actor_id); //once loated it is delted
		return ResponseEntity.ok(deletedActor); //return deleted entry
	}

	//Categories Mapping

	@GetMapping("/all_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}

	@GetMapping("/a_Category")
	public Category getCategory(@RequestParam Integer category_id) {
		return categoryRepository.findById(category_id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/add_Category")
	public @ResponseBody
	String addCategory(@RequestParam String category_name ) {
		Category addCategory = new Category(category_name);
		categoryRepository.save(addCategory);
		return saved;
	}

	@PutMapping("/update_Category/{id}")
	public @ResponseBody ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
		Category updateCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found :("));
		updateCategory.setCategory_name (category.getCategory_name());
		categoryRepository.save(updateCategory);
		return ResponseEntity.ok(updateCategory);
	}

	@DeleteMapping("/delete_Category")
	public ResponseEntity<Category> deleteCategory(@RequestParam Integer category_id) {
		Category deletedCategory = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Category not found :("));
		categoryRepository.deleteById(category_id);
		return ResponseEntity.ok(deletedCategory);
	}

	//City Mapping

	@GetMapping("/all_Cities")
	public @ResponseBody
	Iterable<City>getAllCities(){
		return cityRepository.findAll();
	}

	@GetMapping("/a_City")
	public City getCity(@RequestParam Integer city_id) {
		return cityRepository.findById(city_id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/add_City")
	public @ResponseBody
	String addCity(@RequestParam String first_name, int country_id) {
		City addCity = new City(first_name, country_id);
		cityRepository.save(addCity);
		return saved;
	}

	@PutMapping("/update_City/{id}")
	public @ResponseBody ResponseEntity<City> updateCity(@PathVariable int id, @RequestBody City city) {
		City updateCity = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found :("));
		updateCity.setCity_name(city.getCity_name());
		updateCity.setCountry_id(city.getCountry_id());
		cityRepository.save(updateCity);
		return ResponseEntity.ok(updateCity);
	}

	@DeleteMapping("/delete_City")
	public ResponseEntity<City> deleteCity(@RequestParam Integer city_id) {
		City deletedCity = cityRepository.findById(city_id).orElseThrow(() -> new ResourceNotFoundException("City not found :("));
		cityRepository.deleteById(city_id);
		return ResponseEntity.ok(deletedCity);
	}

	//Country Mapping

	@GetMapping("/all_Countries")
	public @ResponseBody
	Iterable<Country>getAllCountries(){
		return countryRepository.findAll();
	}

	@GetMapping("/a_Country")
	public Country getCountry(@RequestParam Integer country_id) {
		return countryRepository.findById(country_id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/add_Country")
	public @ResponseBody
	String addCountry(@RequestParam String country_name) {
		Country addCountry = new Country(country_name);
		countryRepository.save(addCountry);
		return saved;
	}

	@PutMapping("/update_Country/{id}")
	public @ResponseBody ResponseEntity<Country> updateCountry(@PathVariable int id, @RequestBody Country country) {
		Country updateCountry = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found :("));
		updateCountry.setCountry_name (country.getCountry_name());
		countryRepository.save(updateCountry);
		return ResponseEntity.ok(updateCountry);
	}

	@DeleteMapping("/delete_Country")
	public ResponseEntity<Country> deleteCountry(@RequestParam Integer country_id) {
		Country deletedCountry = countryRepository.findById(country_id).orElseThrow(() -> new ResourceNotFoundException("Country not found :("));
		countryRepository.deleteById(country_id);
		return ResponseEntity.ok(deletedCountry);
	}

	//Film Mapping

	@GetMapping("/all_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/a_Film")
	public Film getFilm(@RequestParam Integer film_id) {
		return filmRepository.findById(film_id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/add_Film")
	public @ResponseBody
	String addFilm(@RequestParam String title, String description, Integer release_year, Integer language_id, Integer length, String rating) {
		Film addFilm = new Film(title, description, release_year, language_id, length, rating);
		filmRepository.save(addFilm);
		return saved;
	}

	@PutMapping("/update_Film/{id}")
	public @ResponseBody ResponseEntity<Film> updateFilm(@PathVariable int id, @RequestBody Film film) {
		Film updateFilm = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film not found :("));
		updateFilm.setFilm_name(film.getFilm_name());
		updateFilm.setFilm_description(film.getFilm_description());
		updateFilm.setRelease_year(film.getRelease_year());
		updateFilm.setLanguage_id(film.getLanguage_id());
		updateFilm.setLength(film.getLength());
		updateFilm.setRating(film.getRating());
		filmRepository.save(updateFilm);
		return ResponseEntity.ok(updateFilm);
	}

	@DeleteMapping("/delete_Film")
	public ResponseEntity<Film> deleteFilm(@RequestParam Integer film_id) {
		Film deletedFilm = filmRepository.findById(film_id).orElseThrow(() -> new ResourceNotFoundException("Film not found :("));
		filmRepository.deleteById(film_id);
		return ResponseEntity.ok(deletedFilm);
	}

	//Language Mapping

	@GetMapping("/all_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

	@GetMapping("/a_Language")
	public Language getLanguage(@RequestParam Integer language_id) {
		return languageRepository.findById(language_id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/add_Language")
	public @ResponseBody
	String addLanguage(@RequestParam String language_name) {
		Language addLanguage = new Language(language_name);
		languageRepository.save(addLanguage);
		return saved;
	}

	@PutMapping("/update_Language/{id}")
	public @ResponseBody ResponseEntity<Language> updateLanguage(@PathVariable int id, @RequestBody Language language) {
		Language updateLanguage = languageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language not found :("));
		updateLanguage.setLanguage_name(language.getLanguage_name());
		languageRepository.save(updateLanguage);
		return ResponseEntity.ok(updateLanguage);
	}

	@DeleteMapping("/delete_Language")
	public ResponseEntity<Language> deleteLanguage(@RequestParam Integer language_id) {
		Language deletedLanguage = languageRepository.findById(language_id).orElseThrow(() -> new ResourceNotFoundException("Language not found :("));
		languageRepository.deleteById(language_id);
		return ResponseEntity.ok(deletedLanguage);
	}

	//Rental Mapping

	@GetMapping("/all_Rentals")
	public @ResponseBody
	Iterable<Rental>getRentals(){
		return rentalRepository.findAll();
	}

	@GetMapping("/a_Rental")
	public Rental getRental(@RequestParam Integer rental_id) {
		return rentalRepository.findById(rental_id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/add_Rental")
	public @ResponseBody
	String addRental(@RequestParam String rental_date, int inventory_id, int customer_id, String return_date, int staff_id) {
		Rental addRental = new Rental(rental_date, inventory_id, customer_id, return_date, staff_id);
		rentalRepository.save(addRental);
		return saved;
	}

	@PutMapping("/update_Rental/{id}")
	public @ResponseBody ResponseEntity<Rental> updateRental(@PathVariable int id, @RequestBody Rental rental) {
		Rental updateRental = rentalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rental not found :("));
		updateRental.setRental_date(rental.getRental_date());
		updateRental.setInventory_id(rental.getInventory_id());
		updateRental.setCustomer_id(rental.getCustomer_id());
		updateRental.setReturn_date(rental.getReturn_date());
		updateRental.setStaff_id(rental.getStaff_id());
		rentalRepository.save(updateRental);
		return ResponseEntity.ok(updateRental);
	}

	@DeleteMapping("/delete_Rental")
	public ResponseEntity<Rental> deleteRental(@RequestParam Integer rental_id) {
		Rental deletedRental = rentalRepository.findById(rental_id).orElseThrow(() -> new ResourceNotFoundException("Rental not found :("));
		rentalRepository.deleteById(rental_id);
		return ResponseEntity.ok(deletedRental);
	}



}
