package fr.epsi.b33.MSPR.repo;

import fr.epsi.b33.MSPR.bo.PlantPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlantPostRepositoryTest {

    @Autowired
    PlantPostRepository plantPostRepository;

    @Test
    public void testAssertNotNull(){
        PlantPost plantPost = new PlantPost();
    }
}