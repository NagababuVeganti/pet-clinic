package services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.sfdservices.PetService;
import services.sfdservices.PetTypeService;
import sfpetclinic.Model.Owner;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;



class OwnerMapServiceTest {

    private PetService petService;
    private OwnerMapService ownerMapService;
    final Long ownerId= Long.valueOf(1);

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        Owner own1= new Owner();
        own1.setId(1L);
        ownerMapService.save(own1);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet= ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findByLastName() {
        Owner owner= ownerMapService.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void save() {
        Owner own2= new Owner();
        own2.setId(2L);
        Owner savedOwner=ownerMapService.save(own2);
        assertEquals(Optional.of(2),savedOwner. getId());
    }

    @Test
    void delete() {
    }

    @Test
    void deleteByID() {
    }

    @Test
    void findById() {
    }
}