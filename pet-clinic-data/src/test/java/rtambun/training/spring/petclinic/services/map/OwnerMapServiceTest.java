package rtambun.training.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rtambun.training.spring.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private Long OwnerId1L = 1L;
    private String OwnerLastName1L = "Tambun";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        Owner owner = Owner.builder().id(OwnerId1L).lastName(OwnerLastName1L).build();
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
        assertEquals(OwnerId1L, owners.toArray(new Owner[1])[0].getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OwnerId1L);
        assertEquals(OwnerId1L, owner.getId());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OwnerId1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OwnerId1L);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner  = ownerMapService.findByLastName(OwnerLastName1L);
        assertEquals(OwnerId1L, owner.getId());
        assertEquals(OwnerLastName1L, owner.getLastName());
    }
}