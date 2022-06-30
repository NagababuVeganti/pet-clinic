package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import repositories.*;
import services.OwnerService;
import services.PetTypeService;
import services.SpecialitiesService;
import services.VetService;
import sfpetclinic.Model.*;

import java.time.LocalDate;

@Component
@ComponentScan({"services", "repositories","services.SpringDataJPA"})
@EnableJpaRepositories("repositories")
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    private final SpecialityRepository specialityRepository;
    private final VetRepository vetRepository;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService, OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository, SpecialityRepository specialityRepository, VetRepository vetRepository)
    {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.specialityRepository = specialityRepository;
        this.vetRepository = vetRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {

        if(petTypeService.findAll().size()<=0) {
            System.out.println("Loading the data");
            loadData();
        }

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

        petTypeRepository.save(dog);
        petTypeRepository.save(cat);
        petTypeRepository.save(snake);
        petTypeRepository.save(bird);

        System.out.println("==========Loaded PetType data========");


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentry = new Speciality();
        dentry.setDescription("Dentry");


        Speciality savedRadiology = specialityRepository.save(radiology);
        Speciality saveddentry=specialityRepository.save(dentry);
        Speciality savedsurgery=specialityRepository.save(surgery);

        System.out.println("===========Loaded Specality data========");


        Owner owner1= new Owner();
        owner1.setFirstName("Nagababu");
        owner1.setLastName("Veganti");
        owner1.setAddress("14027 cyber place");
        owner1.setCity("Tampa");
        owner1.setPhone("888834343");

        Pet mikepet = new Pet();
        mikepet.setPettype(dog);
        mikepet.setName("tommmy");
        mikepet.setOwner(owner1);
        mikepet.setBirthdate(LocalDate.now());
        owner1.getPets().add(mikepet);
        ownerRepository.save(owner1);


        Owner owner2= new Owner();
        owner2.setFirstName("Michel");
        owner2.setLastName("Warner");
        owner2.setAddress("14024 cyber place");
        owner2.setCity("miami");
        owner2.setPhone("88812343");

        Pet sophepet = new Pet();
        sophepet.setPettype(dog);
        sophepet.setName("rufos");
        sophepet.setOwner(owner2);
        sophepet.setBirthdate(LocalDate.now());
        owner2.getPets().add(sophepet);

        ownerRepository.save(owner2);


        Owner owner4= new Owner();
        owner4.setFirstName("Sara");
        owner4.setLastName("widler");
        owner4.setAddress("14205 montery place");
        owner4.setCity("orlando");
        owner4.setPhone("123456");
        ownerRepository.save(owner4);

        System.out.println("============Loaded Owner data==============");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(saveddentry);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lilly");
        vet2.setLastName("Anne");
        vet2.getSpecialities().add(savedsurgery);

        Vet vet3 = new Vet();
        vet3.setFirstName("Joe");
        vet3.setLastName("A");
        vet3.getSpecialities().add(savedsurgery);

        Vet vet4 = new Vet();
        vet4.setFirstName("Adam");
        vet4.setLastName("Pudder");
        vet4.getSpecialities().add(savedRadiology);

        vetRepository.save(vet1);
        vetRepository.save(vet2);
        vetRepository.save(vet3);
        vetRepository.save(vet4);

        System.out.println("=========Loaded Vet data===============");


    }
}
