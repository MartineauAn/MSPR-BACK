package fr.epsi.b33.MSPR.dal;

import fr.epsi.b33.MSPR.bo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserDAO extends CrudRepository<User, Integer> {

}
