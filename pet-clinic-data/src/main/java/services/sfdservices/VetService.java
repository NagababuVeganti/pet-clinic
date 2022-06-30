package services.sfdservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repositories.VetRepository;
import sfpetclinic.Model.Vet;

import java.util.Set;

@Service
@Profile("jpa")
public class VetService implements services.VetService {
    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        return (Set<Vet>) vetRepository.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).get();
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        vetRepository.deleteById(aLong);

    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
