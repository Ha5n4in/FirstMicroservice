package com.tsi.hasnain.zahoor.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private LanguageRepository languageRepository;

    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, filmRepository, languageRepository);
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
        String expected = "Saved";
        String Actual = myFirstMicroserviceApplication.addActor(TestSaveActor.getFirst_name(),TestSaveActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,Actual,"Actor unable to be saved");
    }

//    @Test
//    public void TestUpdateActor(){
//        Actor TestActor = new Actor("John", "Doe");
//        TestActor.setActor_id(1);
//        Actor TestUpdateActor = new Actor("Sponge", "Bob");
//        TestUpdateActor.setActor_id(1);
//        when(actorRepository.findById(TestActor.getActor_id())).thenReturn(Optional.of(TestUpdateActor));
//        Actor Actual = myFirstMicroserviceApplication.updateActor(TestUpdateActor).getBody();
//        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//        verify(actorRepository).save(actorArgumentCaptor.capture());
//        Actor expected = actorArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,Actual,"Actor was not updated.");
//    }


    @Test
    public void getAllCategories(){
        myFirstMicroserviceApplication.getAllCategories();
        verify(categoryRepository).findAll();
    }

    @Test
    public void getAllFilms(){
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }

    @Test
    public void getAllLanguages(){
        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }
}
