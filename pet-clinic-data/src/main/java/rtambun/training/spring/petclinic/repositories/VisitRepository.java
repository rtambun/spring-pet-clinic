package rtambun.training.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtambun.training.spring.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
