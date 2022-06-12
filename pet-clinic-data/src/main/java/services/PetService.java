package services;

import sfpetclinic.Model.Owner;
import sfpetclinic.Model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastName(String lastName);
    Pet findById(Long Id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
