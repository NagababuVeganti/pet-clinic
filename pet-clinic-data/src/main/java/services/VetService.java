package services;

import sfpetclinic.Model.Pet;
import sfpetclinic.Model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastName);
    Vet findById(Long Id);
    Vet save(Vet pet);
    Set<Vet> findAll();
}
