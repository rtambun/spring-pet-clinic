package rtambun.training.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtambun.training.spring.petclinic.model.Owner;
import rtambun.training.spring.petclinic.model.PetType;
import rtambun.training.spring.petclinic.model.Vet;
import rtambun.training.spring.petclinic.services.OwnerService;
import rtambun.training.spring.petclinic.services.PetTypeService;
import rtambun.training.spring.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Richson");
        owner1.setLastName("Tambun");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yenni");
        owner2.setLastName("Tambun");
        ownerService.save(owner2);

        System.out.println("------- Loading owner ------------");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr Doo");
        vet1.setLastName("Little");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Texas");
        vet2.setLastName("Heaven");
        vetService.save(vet2);

        System.out.println("------- Loading vet ------------");

    }
}
