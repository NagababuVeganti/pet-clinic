package services;

import javax.persistence.Id;
import java.util.Set;

public interface CurdService<T,ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    T delete(T object);

    T deleteByID(ID id);

}
