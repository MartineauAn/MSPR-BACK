package fr.epsi.b33.MSPR.seeder;

import fr.epsi.b33.MSPR.bo.Plant;
import fr.epsi.b33.MSPR.bo.User;
import fr.epsi.b33.MSPR.dal.PlantDAO;
import fr.epsi.b33.MSPR.dal.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    UserDAO user;
    @Autowired
    PlantDAO plant;
    @Override
    public void run(String... args) throws Exception {
        SeedUsers();
        SeedPlantes();
    }

    public void SeedUsers(){
        user.save(new User("DEF","Alexis","alexis.def@epsi.fr", new BCryptPasswordEncoder().encode("grogudev"),"B"));
        user.save(new User("RIMBAUD","Cyprien","cyprien.rimbaud@epsi.fr", new BCryptPasswordEncoder().encode("grogudev"),"B"));
        user.save(new User("SERRA","Alison","alison.serra@epsi.fr", new BCryptPasswordEncoder().encode("grogudev"),"B"));
        user.save(new User("MARTINEAU","Antoine","antoine.martineau@epsi.fr", new BCryptPasswordEncoder().encode("grogudev"),"A"));
    }

    public void SeedPlantes(){
        plant.save(new Plant("Corydale"));
        plant.save(new Plant("Coquelicot-coccinelle"));
        plant.save(new Plant("Belle-de-nuit"));
        plant.save(new Plant("Verveine de Buenos Aires"));
        plant.save(new Plant("Weigélia nain"));
        plant.save(new Plant("Osmanthe"));
        plant.save(new Plant("Hydrangéa"));
        plant.save(new Plant("Nandina nain"));
        plant.save(new Plant("Aconit"));
        plant.save(new Plant("Sauge violette"));
        plant.save(new Plant("Baptisia"));
        plant.save(new Plant("Liatris"));
        plant.save(new Plant("Crocosmia ‘Lucifer’"));
        plant.save(new Plant("Lis trompette"));
        plant.save(new Plant("Nérine"));
        plant.save(new Plant("Caseille"));
        plant.save(new Plant("Pommier"));
        plant.save(new Plant("Fraisier"));
        plant.save(new Plant("Néflier"));
    }

}
