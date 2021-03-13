package rtambun.training.spring.petclinic.services;

import java.util.Set;

import rtambun.training.spring.petclinic.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
