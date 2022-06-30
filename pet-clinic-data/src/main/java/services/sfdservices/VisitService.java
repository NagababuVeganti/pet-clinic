package services.sfdservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repositories.VisitRepository;
import sfpetclinic.Model.Visit;

import java.util.Set;

@Service
@Profile("jpa")
public class VisitService implements services.VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return (Set<Visit>) visitRepository.findAll();
    }

    @Override
    public Visit findByLastName(String name) {
        return null;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).get();
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        visitRepository.deleteById(aLong);

    }
}
