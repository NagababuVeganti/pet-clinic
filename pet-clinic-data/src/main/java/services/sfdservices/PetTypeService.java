package services.sfdservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repositories.PetTypeRepository;
import sfpetclinic.Model.PetType;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeService implements services.PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes= new HashSet<>();
      petTypeRepository.findAll().iterator().forEachRemaining((type)->petTypes.add(type));
        return petTypes;
    }

    @Override
    public PetType findByLastName(String name) {
        return null;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).get();
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
