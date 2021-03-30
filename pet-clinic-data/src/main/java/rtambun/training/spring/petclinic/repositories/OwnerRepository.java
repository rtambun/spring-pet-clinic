package rtambun.training.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtambun.training.spring.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName (String lastName);
}
