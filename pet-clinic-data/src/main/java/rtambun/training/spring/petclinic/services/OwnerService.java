package rtambun.training.spring.petclinic.services;

import java.util.Set;

import rtambun.training.spring.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
