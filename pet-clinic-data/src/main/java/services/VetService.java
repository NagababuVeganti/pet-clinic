package services;

import sfpetclinic.Model.Pet;
import sfpetclinic.Model.Vet;

import java.util.Set;
/*

Here we are trying to miminc the Spring CURDRepository , we lifted up the commmon functions to single repositroy using Generics.

*/
public interface VetService extends CurdService<Vet,Long> {
    Vet findByLastName(String lastName);

}
