package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfpetclinic.Model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet,Long> {
}
