package com.tsi.hasnain.zahoor.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private LanguageRepository languageRepository;
	private String saved = "Saved";
	private String deleted = "Deleted";


	public MyFirstMicroserviceApplication(ActorRepository actorRepository, CategoryRepository categoryRepository, FilmRepository filmRepository, LanguageRepository languageRepository){
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.filmRepository = filmRepository;
		this.languageRepository = languageRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	@GetMapping("/all_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/a_Actor")
	public Actor getActor(@RequestParam Integer actor_id) {
		return actorRepository.findById(actor_id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/add_Actor")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name) {
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return saved;
	}

	@PutMapping("/update_Actor")
	public ResponseEntity<Actor> updateActor(@RequestParam Integer actor_id, String first_name, String last_name) {
		Actor updateActor = actorRepository.findById(actor_id).orElseThrow(() -> new ResourceNotFoundException("Actor not found :("));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		final Actor updatedActor = actorRepository.save(updateActor);
		return ResponseEntity.ok(updatedActor);
	}

	@DeleteMapping("/delete_Actor")
	public ResponseEntity<Actor> deleteActor(@RequestParam Integer actor_id) {
		Actor deletedActor = actorRepository.findById(actor_id).orElseThrow(() -> new ResourceNotFoundException("Actor not found :("));
		actorRepository.deleteById(actor_id);
		return ResponseEntity.ok(deletedActor);
	}

	@GetMapping("/all_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}

	@PostMapping("/add_Category")
	public @ResponseBody
	String addCategory(@RequestParam String category_name ) {
		Category addCategory = new Category(category_name);
		categoryRepository.save(addCategory);
		return saved;
	}

	@GetMapping("/all_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@PostMapping("/add_Film")
	public @ResponseBody
	String addFilm(@RequestParam String film_name, String film_description, Integer release_year, Integer language_id, Integer length, String rating) {
		Film addFilm = new Film(film_name, film_description, release_year, language_id, length, rating);
		filmRepository.save(addFilm);
		return saved;
	}

	@GetMapping("/all_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}



}
