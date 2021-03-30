package rtambun.training.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtambun.training.spring.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
