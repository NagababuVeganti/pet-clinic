package services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import services.SpecialitiesService;
import sfpetclinic.Model.Speciality;

import java.util.Set;

@Service
@Profile({"default","Map"})
public class SpecalityMapService extends AbstractMapService<Speciality,Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findByLastName(String name) {
        return null;
    }

    @Override
    public void deleteByID(Long id) {

    }

    @Override
    public void delete(Speciality object) {

    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
