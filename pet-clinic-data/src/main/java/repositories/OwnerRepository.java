package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sfpetclinic.Model.Owner;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastname);
    List<Owner> findAllByLastNameLike(String lastname);

}
