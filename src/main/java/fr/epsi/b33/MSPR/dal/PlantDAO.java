package fr.epsi.b33.MSPR.dal;

import fr.epsi.b33.MSPR.bo.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "plants", collectionResourceRel = "plants")
public interface PlantDAO extends CrudRepository<Plant, Integer> {
}
