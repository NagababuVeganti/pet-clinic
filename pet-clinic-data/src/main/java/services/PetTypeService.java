package services;

import org.springframework.stereotype.Service;
import sfpetclinic.Model.PetType;

@Service
public interface PetTypeService extends CurdService<PetType,Long> {
}
