package rtambun.training.spring.petclinic.services;

import rtambun.training.spring.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
