package services;

import org.springframework.stereotype.Service;
import sfpetclinic.Model.Owner;
import sfpetclinic.Model.Pet;

import java.util.Set;
@Service
public interface PetService extends CurdService<Pet,Long> {

}
