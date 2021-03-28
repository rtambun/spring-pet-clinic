package rtambun.training.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtambun.training.spring.petclinic.model.*;
import rtambun.training.spring.petclinic.services.OwnerService;
import rtambun.training.spring.petclinic.services.PetTypeService;
import rtambun.training.spring.petclinic.services.SpecialityService;
import rtambun.training.spring.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dogType = new PetType();
        dogType.setName("dog");
        PetType savedDogType = petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("cat");
        PetType savedCatType = petTypeService.save(catType);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        dentistry.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Owner richson = new Owner();
        richson.setFirstName("Richson");
        richson.setLastName("Tambun");
        richson.setAddress("Villa Panbil Blok O No 15");
        richson.setCity("Batam");
        richson.setTelephone("+6230438957209");

        Pet richsonPet = new Pet();
        richsonPet.setName("Oofoof");
        richsonPet.setPetType(savedDogType);
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

        Pet yenniPet = new Pet();
        yenniPet.setName("Meowmeow");
        yenniPet.setPetType(savedCatType);
        yenniPet.setOwner(yenni);
        yenniPet.setBirthDate(LocalDate.now());
        richson.getPets().add(yenniPet);

        ownerService.save(yenni);

        System.out.println("------- Loading owner ------------");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr Doo");
        vet1.setLastName("Little");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Texas");
        vet2.setLastName("Heaven");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("------- Loading vet ------------");
    }
}
