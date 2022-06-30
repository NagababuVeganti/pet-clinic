package repositories;

import org.springframework.data.repository.CrudRepository;
import sfpetclinic.Model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
