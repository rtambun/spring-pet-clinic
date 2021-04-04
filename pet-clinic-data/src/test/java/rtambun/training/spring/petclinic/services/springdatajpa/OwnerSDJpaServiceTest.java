package rtambun.training.spring.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rtambun.training.spring.petclinic.model.Owner;
import rtambun.training.spring.petclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;

    private Long OwnerId1L = 1L;
    private Long OwnerId2L = 2L;
    private String OwnerLastName1L = "Tambun";
    private Owner Owner1;

    @BeforeEach
    void setup() {
        Owner1 = Owner.builder().id(OwnerId1L).build();
    }

    @Test
    void findAll() {

        Set<Owner> owners = new HashSet<>();
        owners.add(Owner1);
        owners.add(Owner.builder().id(OwnerId2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> owners1 = ownerSDJpaService.findAll();
        assertNotNull(owners1);
        assertEquals(   2, owners1.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(OwnerId1L)).thenReturn(Optional.of(Owner1));

        Owner owner = ownerSDJpaService.findById(OwnerId1L);

        assertEquals(OwnerId1L, owner.getId());

        owner = ownerSDJpaService.findById(OwnerId2L);

        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(Owner1);

        Owner owner = ownerSDJpaService.save(Owner1);
        assertNotNull(owner);
        assertEquals(OwnerId1L, owner.getId());

        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(Owner1);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(OwnerId1L);

        verify(ownerRepository, times(1)).deleteById(OwnerId1L);
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(OwnerId1L).lastName(OwnerLastName1L).build();

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner ownerActual = ownerSDJpaService.findByLastName(OwnerLastName1L);

        assertEquals(OwnerLastName1L, ownerActual.getLastName());
        assertEquals(OwnerId1L, ownerActual.getId());
    }
}