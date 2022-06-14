package services.map;

import services.CurdService;
import sfpetclinic.Model.Pet;
import sfpetclinic.Model.Vet;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet,Long> implements CurdService<Vet,Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
