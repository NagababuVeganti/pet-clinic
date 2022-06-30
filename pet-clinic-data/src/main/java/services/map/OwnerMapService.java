package services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import services.OwnerService;
import services.PetService;
import services.PetTypeService;
import sfpetclinic.Model.Owner;
import sfpetclinic.Model.Pet;

import java.util.Set;

@Service
@Profile({"default","Map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        System.out.println("THis service EZ is being used");
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return  super.findAll();
    }

    @Override
    public Owner findByLastName(String name) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        System.out.println("Save method called");

        if(object!=null)
        {
            if(object.getPets()!=null)
            {
                object.getPets().forEach(pet->{
                    if (pet.getPettype()!=null)
                    {
                        if(pet.getPettype().getId()==null)
                            pet.setPettype(petTypeService.save(pet.getPettype()));
                    }
                    else
                        throw new RuntimeException("Pet Type is Required");

                    if(pet.getId()==null) {
                        Pet savedpet = petService.save(pet);
                        pet.setId(savedpet.getId());
                    }
                });

            }
            return super.save(object);
        }
        else
            return null;
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

}
