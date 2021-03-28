package rtambun.training.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtambun.training.spring.petclinic.model.Owner;
import rtambun.training.spring.petclinic.model.Pet;
import rtambun.training.spring.petclinic.model.PetType;
import rtambun.training.spring.petclinic.model.Vet;
import rtambun.training.spring.petclinic.services.OwnerService;
import rtambun.training.spring.petclinic.services.PetTypeService;
import rtambun.training.spring.petclinic.services.VetService;

import java.time.LocalDate;

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

        PetType dogType = new PetType();
        dogType.setName("dog");
        petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("cat");
        petTypeService.save(catType);

        Owner richson = new Owner();
        richson.setFirstName("Richson");
        richson.setLastName("Tambun");
        richson.setAddress("Villa Panbil Blok O No 15");
        richson.setCity("Batam");
        richson.setTelephone("+6230438957209");

        Pet richsonPet = new Pet();
        richsonPet.setName("Oofoof");
        richsonPet.setPetType(dogType);
        richsonPet.setOwner(richson);
        richsonPet.setBirthDate(LocalDate.now());
        richson.getPets().add(richsonPet);

        ownerService.save(richson);

        Owner yenni = new Owner();
        yenni.setFirstName("Yenni");
        yenni.setLastName("Tambun");
        yenni.setAddress("Bassuray City Tower H 16-67");
        yenni.setCity("Jakarta");
        yenni.setTelephone("+62027842430099");
        ownerService.save(yenni);

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
