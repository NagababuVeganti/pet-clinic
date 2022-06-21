package services.map;

import org.springframework.stereotype.Service;
import services.SpecialitiesService;
import services.VetService;
import sfpetclinic.Model.Speciality;
import sfpetclinic.Model.Vet;

import java.util.Set;
@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialitiesService specialitiesService;

    public VetMapService(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

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
        if(object.getSpecialities().size()>0)
        {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null)
                {
                 Speciality saved=specialitiesService.save(speciality);
                 speciality.setId(saved.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String name)
    {
        return null;
    }
}
