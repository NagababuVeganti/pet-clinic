package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfpetclinic.Model.Visit;


@Repository
public interface VisitRepository extends CrudRepository<Visit,Long> {
}
