package fr.epsi.b33.MSPR.repo;

import fr.epsi.b33.MSPR.bo.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface SpecificationRepository  extends JpaRepository<Specification, Integer> {
}
