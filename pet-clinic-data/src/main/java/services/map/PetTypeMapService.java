package services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import services.PetTypeService;
import sfpetclinic.Model.PetType;

import java.util.Set;

@Service
@Profile({"default","Map"})
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findByLastName(String name) {
        return null;
    }

    @Override
    public void deleteByID(Long aLong) {

    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
