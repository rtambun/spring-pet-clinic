package rtambun.training.spring.petclinic.services.map;

import org.springframework.stereotype.Service;
import rtambun.training.spring.petclinic.model.Vet;
import rtambun.training.spring.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityMapService specialtyMapService;

    public VetMapService(SpecialityMapService specialtyMapService) {
        this.specialtyMapService = specialtyMapService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(specialty -> {
                if (specialty.getId() == null) {
                    specialty.setId(specialtyMapService.save(specialty).getId());
                }
            });
        }
        //TODO: Check if vet must have speciality
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
