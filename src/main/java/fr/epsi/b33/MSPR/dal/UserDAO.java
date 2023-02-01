package fr.epsi.b33.MSPR.dal;

import fr.epsi.b33.MSPR.bo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserDAO extends CrudRepository<User, Integer> {

}
