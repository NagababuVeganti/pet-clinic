package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfpetclinic.Model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {
}
