package services;
import org.springframework.stereotype.Service;
import services.map.OwnerMapService;
import sfpetclinic.Model.Owner;

@Service
public interface OwnerService extends CurdService<Owner,Long>  {

}
