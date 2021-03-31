package rtambun.training.spring.petclinic.services.map;

import org.springframework.stereotype.Service;
import rtambun.training.spring.petclinic.model.Owner;
import rtambun.training.spring.petclinic.model.Pet;
import rtambun.training.spring.petclinic.services.OwnerService;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetMapService petMapService;
    private final PetTypeMapService petTypeMapService;

    public OwnerMapService(PetMapService petMapService, PetTypeMapService petTypeMapService) {
        this.petMapService = petMapService;
        this.petTypeMapService = petTypeMapService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets().size() > 0) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getId() == null) {
                            pet.setPetType(petTypeMapService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type need to be set");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petMapService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> allOwner = findAll();
        return allOwner.stream()
                .filter(owner -> owner.getLastName().contentEquals(lastName))
                .findFirst()
                .orElse(null);
    }
}
