package services.sfdservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repositories.PetRepository;
import sfpetclinic.Model.Pet;

import java.util.Set;

@Service
@Profile("jpa")
public class PetService implements services.PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return (Set<Pet>) petRepository.findAll();
    }

    @Override
    public Pet findByLastName(String name) {
        return null;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).get();
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);

    }
}
