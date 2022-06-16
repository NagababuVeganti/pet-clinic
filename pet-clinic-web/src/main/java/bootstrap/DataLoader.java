package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.CurdService;
import services.OwnerService;
import services.VetService;
import services.map.OwnerMapService;
import services.map.VetMapService;
import sfpetclinic.Model.Owner;
import sfpetclinic.Model.Vet;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader()
    {

         ownerService= new OwnerMapService();
         vetService=new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception
    {

        Owner owner1= new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Nagababu");
        owner1.setLastname("Veganti");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Michel");
        owner2.setLastname("Warner");
        ownerService.save(owner2);

        Owner owner3= new Owner();
        owner3.setId(3L);
        owner3.setFirstname("Fiona");
        owner3.setLastname("Veg");
        ownerService.save(owner3);

        Owner owner4= new Owner();
        owner4.setId(4L);
        owner4.setFirstname("Sara");
        owner4.setLastname("widler");
        ownerService.save(owner4);

        System.out.println("Loaded Owner data");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstname("Lilly");
        vet2.setLastname("Anne");

        Vet vet3 = new Vet();
        vet1.setId(3L);
        vet1.setFirstname("Joe");
        vet1.setLastname("A");

        Vet vet4 = new Vet();
        vet1.setId(4L);
        vet1.setFirstname("Adam");
        vet1.setLastname("Pudder");

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);
        vetService.save(vet4);

        System.out.println("Loaded Vet data");




    }
}
