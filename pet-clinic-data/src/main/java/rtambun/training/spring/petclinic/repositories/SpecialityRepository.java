package rtambun.training.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtambun.training.spring.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
