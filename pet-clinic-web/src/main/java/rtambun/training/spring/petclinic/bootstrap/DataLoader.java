package rtambun.training.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtambun.training.spring.petclinic.model.*;
import rtambun.training.spring.petclinic.services.*;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dogType = PetType.builder().name("dog").build();
        PetType savedDogType = petTypeService.save(dogType);

        PetType catType = PetType.builder().name("cat").build();
        PetType savedCatType = petTypeService.save(catType);

        Speciality radiology = Speciality.builder().description("radiology").build();
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = Speciality.builder().description("dentistry").build();
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = Speciality.builder().description("surgery").build();
        Speciality savedSurgery = specialityService.save(surgery);

        Owner richson = Owner.builder()
                .firstName("Richson")
                .lastName("Tambun")
                .address("Villa Panbil Blok O No 15")
                .city("Batam")
                .telephone("+6230438957209")
                .build();

        Pet richsonPet = Pet.builder()
                .name("Oofoof")
                .petType(savedDogType)
                .owner(richson)
                .birthDate(LocalDate.now())
                .build();
        richson.getPets().add(richsonPet);

        ownerService.save(richson);

        Owner yenni = Owner.builder()
                .firstName("Yenni")
                .lastName("Tambun")
                .address("Bassuray City Tower H 16-67")
                .city("Jakarta")
                .telephone("+62027842430099")
                .build();

        Pet yenniPet = Pet.builder()
                .name("Meowmeow")
                .petType(savedCatType)
                .owner(yenni)
                .birthDate(LocalDate.now())
                .build();
        yenni.getPets().add(yenniPet);

        ownerService.save(yenni);

        Visit meowmeowVisit = new Visit();
        meowmeowVisit.setPet(yenniPet);
        meowmeowVisit.setDate(LocalDate.now());
        meowmeowVisit.setDescription("Yenni pet cough");

        visitService.save(meowmeowVisit);

        System.out.println("------- Loading owner ------------");

        Vet vet1 = Vet.builder().firstName("Dr Doo").lastName("Little").build();
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = Vet.builder().firstName("Texas").lastName("Heaven").build();
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("------- Loading vet ------------");
    }
}
