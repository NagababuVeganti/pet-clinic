package services;

import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Set;

@Service
public interface CurdService<T,ID> {

    Set<T> findAll();

    T findByLastName(String name);

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteByID(ID id);

}
