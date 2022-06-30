package services.sfdservices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import repositories.OwnerRepository;
import sfpetclinic.Model.Owner;

import java.util.Set;

@Service
@Profile("jpa")
//Below Line is import for the spring to enable EnableJpaRepositories
public class OwnerService implements services.OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {

        System.out.println("Using this service");
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        return (Set<Owner>) ownerRepository.findAll();
    }

    @Override
    public Owner findByLastName(String name) {
        return null;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).get();
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
    ownerRepository.deleteById(aLong);
    }
}
