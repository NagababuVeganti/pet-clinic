package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfpetclinic.Model.Speciality;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
