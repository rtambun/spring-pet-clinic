package rtambun.training.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtambun.training.spring.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
