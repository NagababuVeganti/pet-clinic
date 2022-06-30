package services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import services.VisitService;
import sfpetclinic.Model.Visit;

import java.util.Set;

@Service
@Profile({"default","Map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findByLastName(String name) {
        return null;
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
            super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
