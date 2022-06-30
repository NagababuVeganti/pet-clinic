package services;
import org.springframework.stereotype.Service;
import services.map.OwnerMapService;
import sfpetclinic.Model.Owner;

import java.util.List;

public interface OwnerService extends CurdService<Owner,Long>  {

    List<Owner> findAllByLastNameLike(String lastname);
}
