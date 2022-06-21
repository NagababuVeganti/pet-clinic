package services.map;

import org.springframework.stereotype.Service;
import services.OwnerService;
import services.PetService;
import services.PetTypeService;
import sfpetclinic.Model.Owner;
import sfpetclinic.Model.Pet;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return  super.findAll();
    }

    @Override
    public Owner save(Owner object) {

        if(object!=null)
        {
            if(object.getPets()!=null)
            {
                object.getPets().forEach(pet->{
                    if (pet.getPetype()!=null)
                    {
                        if(pet.getPetype().getId()==null)
                            pet.setPetype(petTypeService.save(pet.getPetype()));
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
