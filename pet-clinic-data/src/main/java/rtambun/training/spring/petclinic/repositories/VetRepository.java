package rtambun.training.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtambun.training.spring.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
