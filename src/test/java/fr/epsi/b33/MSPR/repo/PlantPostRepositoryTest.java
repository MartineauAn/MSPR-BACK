package fr.epsi.b33.MSPR.repo;

import fr.epsi.b33.MSPR.bo.Asset;
import fr.epsi.b33.MSPR.bo.Plant;
import fr.epsi.b33.MSPR.bo.PlantPost;
import fr.epsi.b33.MSPR.controlleur.PlantPostController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlantPostRepositoryTest {

    @Autowired
    PlantPostRepository plantPostRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        plantPostRepository.deleteAll();

        Collection<PlantPost> plantPosts = new ArrayList<>();
        plantPosts.add(new PlantPost(
                new Date(2023,12,12),
                LocalDateTime.now(),
                LocalDateTime.now(),
                "Garde de tomate",
                "description",
                "nom",
                "ville",
                "adresse",
                "code postal"
                ));
        plantPostRepository.saveAll(plantPosts);
    }
    @Test
    public void getAll_success() throws Exception{
        //Collection<Plant> allPlants = plantPostController.all();
        //System.out.println(allPlants);
        //Assert.notEmpty((Collection<?>) allPlants);
        Assert.notNull(plantPostRepository);
        plantPostRepository.findAll();
        assertNotNull(plantPostRepository.findAll());
    }

    @Test
    public void getById() throws Exception{
        Optional<PlantPost> plantPost = plantPostRepository.findById(1);
        assertNotNull(plantPost);
        assertEquals(plantPost.get().getTitle(), "Garde de tomate");
    }

    @Test
    public void deleteAll_success() throws Exception{
        plantPostRepository.deleteAll();
        assertEquals(plantPostRepository.findAll().stream().count(), 0);
    }
}