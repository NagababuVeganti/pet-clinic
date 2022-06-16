package services.map;

import org.springframework.stereotype.Service;
import services.CurdService;
import services.PetService;
import sfpetclinic.Model.Pet;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
            super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
            super.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

}
