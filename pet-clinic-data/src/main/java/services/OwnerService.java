package services;
import sfpetclinic.Model.Owner;

import java.util.Set;

public interface OwnerService extends CurdService<Owner,Long> {
    Owner findByLastName(String lastName);

}
