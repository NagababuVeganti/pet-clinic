package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.PetTypeService;
import services.SpecialitiesService;
import services.VetService;
import sfpetclinic.Model.*;

import java.time.LocalDate;

@Component
@ComponentScan({"services"})
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService)
    {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception
    {

        if(petTypeService.findAll().size()<=0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        dog.setName("Cat");

        PetType bird = new PetType();
        dog.setName("Bird");

        PetType snake = new PetType();
        dog.setName("Snake");

        petTypeService.save(dog);
        petTypeService.save(cat);
        petTypeService.save(snake);
        petTypeService.save(bird);

        System.out.println("==========Loaded PetType data========");


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentry = new Speciality();
        dentry.setDescription("Dentry");

        Speciality savedRadiology = specialitiesService.save(radiology);
        Speciality saveddentry=specialitiesService.save(dentry);
        Speciality savedsurgery=specialitiesService.save(surgery);

        System.out.println("===========Loaded Specality data========");


        Owner owner1= new Owner();
        owner1.setFirstname("Nagababu");
        owner1.setLastname("Veganti");
        owner1.setAddress("14027 cyber place");
        owner1.setCity("Tampa");
        owner1.setPhone("888834343");

        Pet mikepet = new Pet();
        mikepet.setPetype(dog);
        mikepet.setName("tommmy");
        mikepet.setOwner(owner1);
        mikepet.setBirthdate(LocalDate.now());
        owner1.getPets().add(mikepet);

        ownerService.save(owner1);


        Owner owner2= new Owner();
        owner2.setFirstname("Michel");
        owner2.setLastname("Warner");
        owner2.setAddress("14024 cyber place");
        owner2.setCity("miami");
        owner2.setPhone("88812343");

        Pet sophepet = new Pet();
        sophepet.setPetype(dog);
        sophepet.setName("rufos");
        sophepet.setOwner(owner2);
        sophepet.setBirthdate(LocalDate.now());
        owner2.getPets().add(sophepet);

        ownerService.save(owner2);

        Owner owner3= new Owner();
        owner3.setFirstname("Fiona");
        owner3.setLastname("Veg");
        owner3.setAddress("14027 cyber place");
        owner3.setCity("Tampa");
        owner3.setPhone("2345");

        Pet stevepet = new Pet();
        stevepet.setPetype(dog);
        stevepet.setName("rufos");
        stevepet.setOwner(owner3);
        stevepet.setBirthdate(LocalDate.now());
        owner3.getPets().add(sophepet);

        ownerService.save(owner3);

        Owner owner4= new Owner();
        owner4.setFirstname("Sara");
        owner4.setLastname("widler");
        owner4.setAddress("14205 montery place");
        owner4.setCity("orlando");
        owner4.setPhone("123456");
        ownerService.save(owner4);

        System.out.println("Loaded Owner data");

        Vet vet1 = new Vet();
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");
        vet1.getSpecialities().add(saveddentry);

        Vet vet2 = new Vet();
        vet2.setFirstname("Lilly");
        vet2.setLastname("Anne");
        vet2.getSpecialities().add(savedsurgery);

        Vet vet3 = new Vet();
        vet3.setFirstname("Joe");
        vet3.setLastname("A");
        vet3.getSpecialities().add(savedsurgery);

        Vet vet4 = new Vet();
        vet4.setFirstname("Adam");
        vet4.setLastname("Pudder");
        vet4.getSpecialities().add(savedRadiology);


        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);
        vetService.save(vet4);

        System.out.println("=========Loaded Vet data===============");
    }
}
