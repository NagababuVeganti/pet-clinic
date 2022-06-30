package services.sfdservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repositories.SpecialityRepository;
import services.SpecialitiesService;
import sfpetclinic.Model.Speciality;

import java.util.Set;
@Service
@Profile("jpa")
public class SpecialityService implements services.SpecialitiesService {

    private final SpecialityRepository specialityRepository;

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        return (Set<Speciality>) specialityRepository.findAll();
    }

    @Override
    public Speciality findByLastName(String name) {
        return null;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).get();
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) {
        specialityRepository.deleteById(aLong );

    }
}
