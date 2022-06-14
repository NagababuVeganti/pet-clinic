package services.map;

import services.CurdService;
import sfpetclinic.Model.Pet;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet,Long> implements CurdService<Pet,Long> {
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
        return super.save(object.getId(), object);
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