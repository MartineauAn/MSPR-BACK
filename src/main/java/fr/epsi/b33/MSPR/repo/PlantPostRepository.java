package fr.epsi.b33.MSPR.repo;

import fr.epsi.b33.MSPR.bo.PlantPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantPostRepository extends JpaRepository<PlantPost, Integer> {
}
